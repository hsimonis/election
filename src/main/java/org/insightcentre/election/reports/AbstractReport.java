package org.insightcentre.election.reports;

import framework.reports.AbstractBaseReport;
import framework.reports.visualization.tabular.TableStyle;
import framework.reports.visualization.tabular.table.TableDraw;
import org.insightcentre.election.datamodel.ConstituencyType;
import org.insightcentre.election.datamodel.Scenario;
import org.insightcentre.election.datamodel.SolConstType;
import org.insightcentre.election.datamodel.Solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public abstract class AbstractReport extends AbstractBaseReport {
    Scenario base;

    public AbstractReport(Scenario base, String root) {
        super(root);
        this.base = base;
    }


    public void solutionTable() {
        solutionTable("Solutions",base.getListSolution());
    }

    public void solutionTable(Solution sol){
        List<Solution> list = new ArrayList<>();
        list.add(sol);
        solutionTable("Solution "+sol.getNr(),list);
    }

    public void solutionTable(String label,List<Solution> list){
        new TableDraw<>(label, list).
                addStringColumn("Name", this::nameOf).
                addIntegerColumn("K", Solution::getK, "%,d").
                addIntegerColumn("Delta", Solution::getDelta, "%,d").
                addDoubleColumn(st("Delta", "Percent"), Solution::getDeltaPercent, "%,5.2f").
                addDoubleColumn(st("Range","Percent"), Solution::getRange, "%,5.2f").
                addDoubleColumn("Min E", Solution::getMinE, "%,5.2f").
                addDoubleColumn("Max E", Solution::getMaxE, "%,5.2f").
                addDoubleColumn(st("Weighted","Average"), Solution::getWeightedAverage, "%,5.2f").
                addDoubleColumn(st("Weighted","Variance"), Solution::getWeightedVariance, "%,5.2f").
                addDoubleColumn(st("Weighted","Absolute","Variation"), Solution::getWeightedAbsoluteVariation, "%,5.2f").
                addIntegerColumn(st("Nr","Trans"), Solution::getTotalTransfers, "%,d").
                addIntegerColumn("Transferred", Solution::getTotalTransferred, "%,d").
                addIntegerColumn(st("Nr","Const."), Solution::getNrConstituencies, "%,d").
                addStringColumn("3/4/5",this::typeCount).
                addDoubleColumn(st("Seats","Per","Const."), Solution::getAvgSeatsPerConstituency, "%,5.2f").
                addStringColumn(st("Solution", "Status"), x -> safe(x.getSolutionStatus().toString())).
                addDoubleColumn(st("Time", "(s)"), Solution::getTime, "%,5.2f").
//                addDoubleColumn("Objective", Solution::getObjValue, "%,5.2f").
//                addDoubleColumn(st("Lower","Bound"), Solution::getLb, "%,5.2f").
                addDoubleColumn(st("Gap", "Percent"), Solution::getGapPercent, "%5.4f").
                tableStyle(TableStyle.LONGTABLE).
                textSize("\\scriptsize").
                generate().latex(tex);

    }

    private String typeCount(Solution sol){
        return  base.getListSolConstType().stream().filter(x->x.getSolution()==sol).
                sorted(Comparator.comparing(this::compareTypes)).map(x->x.getValue().toString()).collect(Collectors.joining("/"));
     }

     private Integer compareTypes(SolConstType type){
        return type.getConstituencyType().getNrSeats();
     }



    protected String st(String a,String b){
        return String.format("\\shortstack{%s\\\\%s}",a,b);
    }
    protected String st(String a,String b,String c){
        return String.format("\\shortstack{%s\\\\%s\\\\%s}",a,b,c);
    }
    protected String st(String a,String b,String c,String d){
        return String.format("\\shortstack{%s\\\\%s\\\\%s\\\\%s}",a,b,c,d);
    }


    public static String time(long start){
        return String.format("%5.2f s",(System.currentTimeMillis()-start)/1000.0);
    }

    public static double time(long from,long to){
        return (to-from)/1000.0;
    }

}
