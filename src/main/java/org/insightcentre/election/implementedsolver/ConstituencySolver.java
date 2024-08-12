package org.insightcentre.election.implementedsolver;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.insightcentre.election.datamodel.*;

import ilog.concert.*;
import ilog.cplex.IloCplex;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static org.insightcentre.election.datamodel.SolutionStatus.Solution;
import static org.insightcentre.election.logging.LogShortcut.info;
import static org.insightcentre.election.logging.LogShortcut.severe;
public class ConstituencySolver {
    static int solNr = 1;
    Scenario base;
    public ConstituencySolver(Scenario base,int k,int delta,int timeLimit,int nrThreads) {
        this.base =base;
        long start = System.currentTimeMillis();
        // cost of a transfer across borders
        int alpha = base.getAlphaCostFactor();
        // cost of a transfer of one person across a border
        int beta = base.getBetaCostFactor();
        int low = base.getLowBound();
        int high = base.getHighBound();
        // cost of a constituency of a given type
        int nrSizes = base.getListConstituencyType().size();
        ConstituencyType[] types = new ConstituencyType[nrSizes];
        int[] gamma = new int[nrSizes];
        // number of seats in a constituency of a given type
        int[] sizes = new int[nrSizes];
        int jj=0;
        for(ConstituencyType type:base.getListConstituencyType()){
            types[jj] = type;
            sizes[jj] = type.getNrSeats();
            gamma[jj] = type.getGammaCostFactor();
            jj++;
        }
        int totalPopulation = base.getTotalPopulation();
        int lowSeats = (int) Math.ceil(1.0*totalPopulation / high);
        int highSeats = (int) Math.ceil(1.0*totalPopulation / low);
        // choose a feasible value
        assert(k >= lowSeats);
        assert(k <= highSeats);
        int a = totalPopulation/k;
        info("Seats " + k+" avgPerSeat "+a);
        int nrCounties = base.getListCounty().size();
        County[] county = new County[nrCounties];
        int[] population = new int[nrCounties];
        int cc=0;
        Hashtable<County,Integer> countyHash = new Hashtable<>();
        for(County c:base.getListCounty()){
            county[cc] = c;
            population[cc] = c.getTotalPopulation();
            countyHash.put(c,cc);
            cc++;
        }
        int[][] connected = new int[nrCounties][nrCounties];
        for(NeighborCounty nc:base.getListNeighborCounty()){
            connected[countyHash.get(nc.getCounty1())][countyHash.get(nc.getCounty2())] =1;
            connected[countyHash.get(nc.getCounty2())][countyHash.get(nc.getCounty1())] =1;
        }

        IloCplex.Status status = null;


        try {
            IloCplex cplex = new IloCplex();
            // create cost variable
            IloLinearNumExpr obj = cplex.linearNumExpr();
            //
            IloNumVar[][] x = new IloNumVar[nrCounties][nrSizes]; // allocation of constituencies of different sizes to counties
            IloNumVar[][] y = new IloNumVar[nrCounties][nrCounties]; // do we transfer from one county to a neighbor
            IloNumVar[][] z = new IloNumVar[nrCounties][nrCounties]; // how much do we transfer between neighbors
            IloNumVar[] u = new IloNumVar[nrSizes]; // how many constituencies of a given size do we use

            // we must allocate the correct number of seats
            IloLinearNumExpr allocatedSeats = cplex.linearNumExpr();
            for (int i = 0; i < nrCounties; i++) {
                for (int j = 0; j < nrSizes; j++) {
                    x[i][j] = cplex.numVar(0, Math.ceil(1.0*k/sizes[j]), IloNumVarType.Int);
                    allocatedSeats.addTerm(x[i][j], sizes[j]);
                }
            }
            cplex.addEq(allocatedSeats, k);

            // we can only transfer between two counties if they are connected
            // we can transfer up to the total population of the source
            for(int i1=0;i1<nrCounties;i1++){
                for(int i2=0;i2<nrCounties;i2++){
                    if (connected[i1][i2] > 0) {
                        int maxTransfer = population[i1];
//                        int maxTransfer = Math.min(population[i1],population[i2]);
                        y[i1][i2] = cplex.numVar(0, 1, IloNumVarType.Int);
                        z[i1][i2] = cplex.numVar(0, maxTransfer, IloNumVarType.Float);
                        IloLinearNumExpr rhs = cplex.linearNumExpr();
                        rhs.addTerm(y[i1][i2], maxTransfer);
                        // bigM constraint linking decision and size transfer variable
                        cplex.addLe(z[i1][i2], rhs);
                        // each transfer costs regardless of volume
                        obj.addTerm(y[i1][i2], alpha);
                        obj.addTerm(z[i1][i2], beta);
                    }
                }
            }
            // the u variables count the total number of constituencies of a given size
            for (int j = 0; j < nrSizes; j++) {
                u[j] = cplex.numVar(0, 100, IloNumVarType.Int);
                IloLinearNumExpr sum = cplex.linearNumExpr();
                for(int i=0;i<nrCounties;i++){
                    sum.addTerm(x[i][j],1);
                }
                cplex.addEq(u[j],sum);
                obj.addTerm(u[j],gamma[j]);
            }
            // no bidirectional transfer between counties
            for(int i1=0;i1<nrCounties-1;i1++) {
                for (int i2 = i1 + 1; i2 < nrCounties; i2++) {
                    if (connected[i1][i2] > 0) {
                        assert(connected[i2][i1] > 0);
                        IloLinearNumExpr sum = cplex.linearNumExpr();
                        sum.addTerm(y[i1][i2], 1);
                        sum.addTerm(y[i2][i1], 1);
                        cplex.addLe(sum, 1);
                    }

                }
            }
            // we can only transfer up to the total population of the source
            for(int i=0;i<nrCounties;i++){
                IloLinearNumExpr sum = cplex.linearNumExpr();
                for(int i2=0;i2<nrCounties;i2++){
                    if (connected[i][i2] > 0){
                        sum.addTerm(z[i][i2],1);
                    }
                }
                cplex.addLe(sum,population[i]);
            }
            //the allocated seats must cover the population + transfer in - transfer out with +- delta of allocated seats
            for(int i=0;i<nrCounties;i++){
                IloLinearNumExpr lhs = cplex.linearNumExpr(population[i]);
                for(int i2=0;i2<nrCounties;i2++){
                    if (y[i2][i] != null){
                        lhs.addTerm(z[i2][i],1);
                    }
                    if (y[i][i2] != null){
                        lhs.addTerm(z[i][i2],-1);
                    }
                }
                IloLinearNumExpr rhs = cplex.linearNumExpr();
                IloLinearNumExpr rhs2 = cplex.linearNumExpr();
                for(int j=0;j<nrSizes;j++){
                    rhs.addTerm(x[i][j],sizes[j]*(a+delta));
                    rhs2.addTerm(x[i][j],sizes[j]*(a-delta));
                }
                cplex.addLe(lhs,rhs);
                cplex.addGe(lhs,rhs2);
            }
            info("Constraints set");
            cplex.setParam(IloCplex.DoubleParam.TimeLimit, timeLimit);
            cplex.setParam(IloCplex.DoubleParam.Threads, nrThreads);

            cplex.addMinimize(obj);

//           info("Objective set");
            IloObjective objective = cplex.getObjective();
            if (objective == null) {
                severe("null objective");
            }

            boolean isfeas = cplex.solve();
            status = cplex.getStatus();

            if (isfeas) {
                Solution sol = new Solution(base);
                sol.setName("Sol"+solNr);
                sol.setNr(solNr++);
                sol.setK(k);
                sol.setDelta(delta);
                sol.setDeltaPercent(100.0*delta/a);
                sol.setTimeLimit(timeLimit);
                sol.setNrThreads(nrThreads);
                sol.setPersonsPerTD(a);
                sol.setSolutionStatus(toSolutionStatus(status));
                sol.setTime(time(start));
                double costValue = cplex.getObjValue();
                double lb = cplex.getBestObjValue();
                sol.setObjValue(costValue);
                double gapPercent = 100.0*(costValue-lb)/lb;
                sol.setGapPercent(gapPercent);
                sol.setLb(lb);

                info("Solution found:" + costValue);
                int totalAllocated = 0;
                int totalConst = 0;
                for (int i = 0; i < nrCounties; i++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(county[i].getName());
                    int nrSeats = 0;
                    int nrConstituencies = 0;
                    List<String> typeCount = new ArrayList<>();
                    for (int j = 0; j < nrSizes; j++) {
                        int allocated = (int) Math.round(cplex.getValue(x[i][j]));
                        sb.append(" ");
                        sb.append(allocated);
                        totalAllocated += allocated*sizes[j];
                        nrSeats += allocated*sizes[j];
                        nrConstituencies += allocated;
                        totalConst += allocated;
                        typeCount.add(String.format("%d",allocated));
                    }

                    SolCounty sc = new SolCounty(base);
                    sc.setName(county[i].getName());
                    sc.setSolution(sol);
                    sc.setCounty(county[i]);
                    sc.setSeatsAssigned(nrSeats);
                    sc.setConstituenciesAssigned(nrConstituencies);
                    sc.setConstTypes(String.join("/", typeCount));
                    int transferOut = 0;
                    for(int i2=0;i2<nrCounties;i2++){
                        if (connected[i][i2] > 0){
                            transferOut += (int) Math.round(cplex.getValue(z[i][i2]));
                        }
                    }
                    int transferIn = 0;
                    for(int i2=0;i2<nrCounties;i2++){
                        if (connected[i2][i] > 0){
                            transferIn += (int) Math.round(cplex.getValue(z[i2][i]));
                        }
                    }
                    sc.setPopulation(population[i]);
                    sc.setFractionalSeats(1.0*population[i]/a);
                    sc.setTransferOut(transferOut);
                    sc.setTransferIn(transferIn);
                    int effectivePopulation = population[i]-transferOut+transferIn;
                    sc.setEffectivePopulation(effectivePopulation);
                    double personsPerSeat = (nrSeats>0 ?1.0*effectivePopulation/nrSeats:0.0);
                    sc.setPersonsPerSeat(personsPerSeat);
                    sc.setVariation(nrSeats > 0?100.0*(personsPerSeat-a)/a:0.0);
                    info(sb.toString());
                }
                sol.setMinE(base.getListSolCounty().stream().filter(xx->xx.getSolution()==sol).filter(xx->xx.getSeatsAssigned()>0).mapToDouble(SolCounty::getPersonsPerSeat).min().orElse(0.0));
                sol.setMaxE(base.getListSolCounty().stream().filter(xx->xx.getSolution()==sol).filter(xx->xx.getSeatsAssigned()>0).mapToDouble(SolCounty::getPersonsPerSeat).max().orElse(0.0));
                sol.setMinV(base.getListSolCounty().stream().filter(xx->xx.getSolution()==sol).filter(xx->xx.getSeatsAssigned()>0).mapToDouble(SolCounty::getVariation).min().orElse(0.0));
                sol.setMaxV(base.getListSolCounty().stream().filter(xx->xx.getSolution()==sol).filter(xx->xx.getSeatsAssigned()>0).mapToDouble(SolCounty::getVariation).max().orElse(0.0));
                sol.setRange(sol.getMaxV()-sol.getMinV());
                sol.setWeightedAverage(weightedAverage(sol));
                sol.setWeightedVariance(weightedVariance(sol));
                sol.setWeightedAbsoluteVariation(weightedAbsoluteVariation(sol));
                info("Total allocated " + totalAllocated);
                int totalConstituencies = 0;
                for(int j=0;j<nrSizes;j++){
                    int cnt = (int) Math.round(cplex.getValue(u[j]));
                    totalConstituencies += cnt;
                    info("Count "+j+" size "+sizes[j]+" value "+cnt);
                    SolConstType ct = new SolConstType(base);
                    ct.setName(types[j].getName());
                    ct.setSolution(sol);
                    ct.setConstituencyType(types[j]);
                    ct.setValue(cnt);
                    ct.setPercent(100.0*cnt/totalConst);
                }
                assert(totalConst == totalConstituencies);
                sol.setNrConstituencies(totalConstituencies);
                sol.setAvgSeatsPerConstituency(1.0*k/totalConstituencies);
                int totalTransfers = 0;
                int totalTransferred = 0;
                for(int i1=0;i1<nrCounties;i1++){
                    for(int i2=0;i2<nrCounties;i2++){
                        if (y[i1][i2] != null){
                            int transferring = (int) Math.round(cplex.getValue(y[i1][i2]));
                            int transferred = (int) Math.round(cplex.getValue(z[i1][i2]));
                            if (transferring > 0 && transferred > 0) {
                                double percent = 100.0*transferred/population[i1];
                                info("From " + county[i1].getName() + " to " + county[i2].getName() +
                                        " " + transferring +
                                        " " + transferred+
                                        " percent "+String.format("%5.2f",percent));
                                SolTransfer st = new SolTransfer(base);
                                st.setName(county[i1]+" - "+county[i2]);
                                st.setSolution(sol);
                                st.setFrom(county[i1]);
                                st.setTo(county[i2]);
                                st.setValue(transferred);
                                st.setPercentOfFrom(percent);
                                totalTransferred += transferred;
                                totalTransfers++;
                            } else {
                                assert(transferred == 0);
                            }
                        }
                    }
                }
                sol.setTotalTransfers(totalTransfers);
                sol.setTotalTransferred(totalTransferred);
                info("Total transfers "+totalTransfers+" total transferred "+totalTransferred);

            } else {
                severe("No solution found");
            }

            if (cplex != null) {
                cplex.end();
//                cplex.clearModel();
            }

        } catch (IloException e) {
            severe("Concert exception caught: " + e.getMessage());
        }
    }

    protected SolutionStatus toSolutionStatus(IloCplex.Status status){
        if (status == null){
            return null;
        }
        switch (status.toString()){
            case "Optimal": return SolutionStatus.Optimal;
            case "Feasible": return SolutionStatus.Solution;
            case "Unknown": return SolutionStatus.Unknown;
            case "Infeasible": return SolutionStatus.Unsatisfiable;
            default:
                severe("Bad status "+status.toString());
                assert(false);
                return SolutionStatus.Undetermined;
        }
    }


    private double time(long start){
        return (System.currentTimeMillis()-start)/1000.0;
    }


    private double weightedAverage(Solution sol){
        List<SolCounty> list = base.getListSolCounty().stream().filter(x->x.getSolution()==sol).filter(x->x.getEffectivePopulation() > 0).toList();
        double[] values = new double[list.size()];
        double[] weights = new double[list.size()];
        int i=0;
        for(SolCounty sc:list){
            values[i] = sc.getPersonsPerSeat();
            weights[i] = sc.getEffectivePopulation();
            i++;
        }
        return new Mean().evaluate(values,weights);
    }
    private double weightedVariance(Solution sol){
        List<SolCounty> list = base.getListSolCounty().stream().filter(x->x.getSolution()==sol).filter(x->x.getEffectivePopulation() > 0).toList();
        double[] values = new double[list.size()];
        double[] weights = new double[list.size()];
        int i=0;
        for(SolCounty sc:list){
            values[i] = sc.getPersonsPerSeat();
            weights[i] = sc.getEffectivePopulation();
            i++;
        }
        return new Variance().evaluate(values,weights);
    }

    private double weightedAbsoluteVariation(Solution sol){
        List<SolCounty> list = base.getListSolCounty().stream().filter(x->x.getSolution()==sol).filter(x->x.getEffectivePopulation() > 0).toList();
        double res  = list.stream().mapToDouble(x->Math.abs(x.getVariation())*x.getPopulation()).sum();
        return res/base.getTotalPopulation();


    }

}
