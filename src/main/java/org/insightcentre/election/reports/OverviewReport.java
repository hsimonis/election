package org.insightcentre.election.reports;

import framework.reports.visualization.plot.lineplot.LinePlot;
import framework.reports.visualization.plot.lineplot.LinePlotFunctions;
import framework.reports.visualization.tabular.TableStyle;
import framework.reports.visualization.tabular.table.TableDraw;
import org.insightcentre.election.datamodel.*;

import java.util.Comparator;
import java.util.List;

public class OverviewReport extends AbstractReport{
    String scenario;
    String specifics;
    public OverviewReport(Scenario base, String reportDir,String scenario,String specifics){
        super(base,reportDir);
        this.scenario = scenario;
        this.specifics = specifics;
    }

    public void content(){
        section("Introduction");
        paragraph("This report gives an overview of the solution found for the Irish Constituency Reassignment " +
                "problem, it also presents details of selected solutions. The problem, a model and the relevant data " +
                "are described in a companion report.");
        paragraph("This version of the analysis considers solutions for a fixed number of seats, and a " +
                "variable += delta in the population per seat for each county.");
        paragraph(specifics);
        clearpage();
        paragraph("Figure~\\ref{fig:countiesmap} shows a schematic map of the counties in Ireland, with lines " +
                "indicating that two counties are neighbors, and a reassignment of population from one county to " +
                "the neighbor can be considered. The positions of the county labels are based on the centroid point " +
                "of the counties in the map of Ireland.");
        paragraph("We also use this map layout in the visualization of the results. We draw two versions, one " +
                "shows the number of seats allocated, and the number of constituencies of different types created. " +
                "The nodes are colored by the number of seats given. Transfers between counties are marked by arrows, " +
                "arrows colored in red indicate that the complete county is transferred to another county. Arrows in " +
                "gray also show the percentage of the population of the 'from' county transferred to the 'to' county.");
        paragraph("The second type of map shows the variation in the number of persons per seat, expressed as a " +
                "percentage of the overall target average. A green color indicates that the number is below the " +
                "average, a yellow color indicates that the value is above average. Counties fro which the achieved " +
                "variation is within 1 percent of the maximum delta allowed are outlined in red.");
        countyMap();
        clearpage();
        section("Solution Overview");
        solutionTable();

        new LinePlot<>(base.getListSolution(),
                new LinePlotFunctions<>(Solution::getDelta, Solution::getRange)).
                title("Range as a Function of Delta Value").
                xlabel("Delta").ylabel("Range").
                width(22).height(12).
                generate().latex(tex);
        new LinePlot<>(base.getListSolution(),
                new LinePlotFunctions<>(Solution::getDelta, Solution::getTotalTransfers)).
                title("Total Transfers as a Function of Delta Value").
                xlabel("Delta").ylabel("Nr Transfers").
                width(22).height(12).
                generate().latex(tex);
        new LinePlot<>(base.getListSolution(),
                new LinePlotFunctions<>(Solution::getDelta, Solution::getTotalTransferred)).
                title("Total Transferred as a Function of Delta Value").
                xlabel("Delta").ylabel("Nr Transferred").
                width(22).height(12).
                generate().latex(tex);
        new LinePlot<>(base.getListSolution(),
                new LinePlotFunctions<>(Solution::getDelta, Solution::getWeightedAverage)).
                title("Weighted Average of Persons per Seat as a Function of Delta Value").
                xlabel("Delta").ylabel("Weighted Average of Persons Per Seat").
                width(22).height(12).
                generate().latex(tex);
        new LinePlot<>(base.getListSolution(),
                new LinePlotFunctions<>(Solution::getDelta, Solution::getWeightedVariance)).
                title("Weighted Variance of Persons per Seat as a Function of Delta Value").
                xlabel("Delta").ylabel("Weighted Variance of Persons Per Seat").
                width(22).height(12).
                generate().latex(tex);
        new LinePlot<>(base.getListSolution(),
                new LinePlotFunctions<>(Solution::getDelta, Solution::getWeightedAbsoluteVariation)).
                title("Weighted Absolute Variation as a Function of Delta Value").
                xlabel("Delta").ylabel("Weighted Absolute Variation").
                width(22).height(12).
                generate().latex(tex);

        section("Details of Selected Solutions");
        for(Solution sol:base.getListSolution()) {
            solutionDetails(sol);
        }
    }

    private void solutionDetails(Solution sol){
        clearpage();
        subsection("Solution "+sol.getName());
        solutionTable(sol);
        tex.printf("\\begin{figure}[htbp]\n");
        tex.printf("\\caption{\\label{fig:countymap%d}%s (%d seats, %d constituencies, %d transfers, %,5.2f persons per TD, " +
                        "$\\Delta_{max}$ %,d (%.2f\\%% of %,d), weighted variation %5.2f\\%%)}\n",
                sol.getNr(),sol.getName(),sol.getK(),sol.getNrConstituencies(),sol.getTotalTransfers(),
                sol.getWeightedAverage(),
                sol.getDelta(),sol.getDeltaPercent(),sol.getPersonsPerTD(),
                sol.getWeightedAbsoluteVariation());
        tex.printf("\\begin{tabular}{cc}\n");
        countyMap(sol);
        tex.printf("&\n");
        variationMap(sol);
        tex.printf("\\end{tabular}\n");
        tex.printf("\\end{figure}\n\n");
        countyTable(base.getListSolCounty().stream().filter(x->x.getSolution()==sol).sorted(Comparator.comparing(SolCounty::getName)).toList());
        transferTable(base.getListSolTransfer().stream().filter(x->x.getSolution()==sol).toList());
    }

    private void countyTable(List<SolCounty> list){
        new TableDraw<>("Counties",list).
                addStringColumn("Name",SolCounty::getName).
                addIntegerColumn("Population",SolCounty::getPopulation,"%,d").
                addDoubleColumn(st("Fractional","Seat"),SolCounty::getFractionalSeats,"%,5.2f").
                addIntegerColumn(st("Transfer","Out"),SolCounty::getTransferOut,"%,d").
                addIntegerColumn(st("Transfer","In"),SolCounty::getTransferIn,"%,d").
                addIntegerColumn(st("Effective","Population"),SolCounty::getEffectivePopulation,"%,d").
                addIntegerColumn(st("Const.","Assigned"),SolCounty::getConstituenciesAssigned,"%,d").
                addStringColumn(st("Const.","Types"),SolCounty::getConstTypes).
                addIntegerColumn(st("Seats","Assigned"),SolCounty::getSeatsAssigned,"%,d").
                addDoubleColumn(st("Persons","Per","Seat"),SolCounty::getPersonsPerSeat,"%,5.2f").
                addDoubleColumn("Variation",SolCounty::getVariation,"%,5.2f").
                tableStyle(TableStyle.LONGTABLE).
                generate().
                latex(tex);
    }
    private void transferTable(List<SolTransfer> list){
        int total = list.stream().mapToInt(SolTransfer::getValue).sum();
        new TableDraw<>(list.size()+" Transfers (Total "+total+")",list).
                addStringColumn("From",x->nameOf(x.getFrom())).
                addStringColumn("To",x->nameOf(x.getTo())).
                addIntegerColumn("Volume",SolTransfer::getValue,"%,d").
                addDoubleColumn(st("Percent","of From"),SolTransfer::getPercentOfFrom,"%,5.2f").
                generate().latex(tex);
    }

    private void countyMap(){
        tex.printf("\\begin{figure}[htbp]\n");
        tex.printf("\\caption{\\label{fig:countiesmap}Ireland: Counties and Neighbors}\n");
        tex.printf("\\centering\n");
        tex.printf("\\begin{tikzpicture}\n");
        for(NeighborCounty nc:base.getListNeighborCounty()){
            tex.printf("\\draw[black!50] (%f,%f) -- (%f,%f);\n",
                    xcoor(nc.getCounty1().getCentroidX()),ycoor(nc.getCounty1().getCentroidY()),
                    xcoor(nc.getCounty2().getCentroidX()),ycoor(nc.getCounty2().getCentroidY()));
        }
        for(County c:base.getListCounty()){
            tex.printf("\\node[fill=green!10,draw=black,rounded corners] () at (%f,%f) {\\scriptsize %s};\n",xcoor(c.getCentroidX()),ycoor(c.getCentroidY()),c.getName());
        }
        tex.printf("\\end{tikzpicture}\n");
        tex.printf("\\end{figure}\n\n");

    }

    private void countyMap(Solution sol){
        tex.printf("\\begin{tikzpicture}\n");
        for(NeighborCounty nc:base.getListNeighborCounty()){
            tex.printf("\\draw[black!30] (%f,%f) -- (%f,%f);\n",
                    xcoor(nc.getCounty1().getCentroidX()),ycoor(nc.getCounty1().getCentroidY()),
                    xcoor(nc.getCounty2().getCentroidX()),ycoor(nc.getCounty2().getCentroidY()));
        }
        for(SolCounty sc:base.getListSolCounty().stream().filter(x->x.getSolution()==sol).toList()){
            County c = sc.getCounty();
            tex.printf("\\node[fill=%s,draw=black,rounded corners] (%s) at (%f,%f) {\\tiny %s};\n",
                    seatsColor(sc.getSeatsAssigned()),
                    c.getName(),
                    xcoor(c.getCentroidX()),ycoor(c.getCentroidY()),c.getName()+" "+sc.getConstTypes());
        }
        for(SolTransfer st:base.getListSolTransfer().stream().filter(x->x.getSolution()==sol).toList()){
            tex.printf("\\draw[->,very thick,%s] (%s) -- %s (%s);\n",
                    transferColor(st.getPercentOfFrom()),
                    st.getFrom().getName(),
                    transferredValue(st.getValue()),
                    st.getTo().getName());
        }
        tex.printf("\\end{tikzpicture}\n");
    }

    private void variationMap(Solution sol){
        tex.printf("\\begin{tikzpicture}\n");
        for(NeighborCounty nc:base.getListNeighborCounty()){
            tex.printf("\\draw[black!30] (%f,%f) -- (%f,%f);\n",
                    xcoor(nc.getCounty1().getCentroidX()),ycoor(nc.getCounty1().getCentroidY()),
                    xcoor(nc.getCounty2().getCentroidX()),ycoor(nc.getCounty2().getCentroidY()));
        }
        for(SolCounty sc:base.getListSolCounty().stream().filter(x->x.getSolution()==sol).toList()){
            County c = sc.getCounty();
            tex.printf("\\node[fill=%s,draw=%s,rounded corners] (%s) at (%f,%f) {\\tiny %s};\n",
                    variationColor(sc.getVariation()),
                    deltaPercentColor(sc.getVariation(),sol.getDeltaPercent()),
                    c.getName(),
                    xcoor(c.getCentroidX()),ycoor(c.getCentroidY()),c.getName()+" "+String.format("%5.2f",sc.getVariation()));
        }
        for(SolTransfer st:base.getListSolTransfer().stream().filter(x->x.getSolution()==sol).toList()){
            tex.printf("\\draw[->,very thick,%s] (%s) -- %s (%s);\n",
                    transferColor(st.getPercentOfFrom()),
                    st.getFrom().getName(),
                    percentValue(st.getPercentOfFrom()),
                    st.getTo().getName());
        }
        tex.printf("\\end{tikzpicture}\n");
    }

    private String transferredValue(int p){
        if (p>0.0) {
            return String.format("node[right,text=black] {\\tiny %,d}", p);
        }
        return "";
    }
    private String percentValue(double p){
        if (p<100.0) {
            return String.format("node[right,text=black] {\\tiny %5.2f\\%%}", p);
        }
        return "";
    }
    private String deltaPercentColor(double variation,double deltaPercent){
        if (Math.abs(Math.abs(variation)-deltaPercent) <= 1.0){
            return "red";
        }
        return "black";
    }

    private String variationColor(double v){
        if (v >= 10.0){
            return "yellow!100";
        } else if (v >=9.0){
            return "yellow!90";
        } else if (v >=8.0){
            return "yellow!80";
        } else if (v >=7.0){
            return "yellow!70";
        } else if (v >=6.0){
            return "yellow!60";
        } else if (v >=5.0){
            return "yellow!50";
        } else if (v >=4.0){
            return "yellow!40";
        } else if (v >=3.0){
            return "yellow!30";
        } else if (v >=2.0){
            return "yellow!20";
        } else if (v >=1.0){
            return "yellow!10";
        } else if (v <= -10){
            return "green!100";
        } else if (v <= -9){
            return "green!90";
        } else if (v <= -8){
            return "green!80";
        } else if (v <= -7){
            return "green!70";
        } else if (v <= -6){
            return "green!60";
        } else if (v <= -5){
            return "green!50";
        } else if (v <= -4){
            return "green!40";
        } else if (v <= -3){
            return "green!30";
        } else if (v <= -2){
            return "green!20";
        } else if (v <= -1){
            return "green!10";
        }
        return "white";
    }

    private String seatsColor(int seats){
        if (seats==0){
            return "black!10";
        } else if (seats==3){
            return "green!10";
        } else if (seats==4){
            return "green!20";
        } else if (seats==5){
            return "green!30";
        } else if (seats==6){
            return "blue!10";
        } else if (seats==7){
            return "blue!20";
        } else if (seats==8){
            return "blue!30";
        } else if (seats==9){
            return "yellow!10";
        } else if (seats==10){
            return "yellow!20";
        } else if (seats>10){
            return "red!30";
        }
        return "red";
    }

    private String transferColor(double percent){
        if (percent >= 100.0){
            return "red";
        } else if (percent <= 1.0){
            return "black!20";
        } else {
            return "black!40";
        }
    }

    private double xcoor(double x){
        return x/25000.0;
    }
    private double ycoor(double y){
        return y/25000.0;
    }
}
