package org.insightcentre.election.implementedsolver;

import org.insightcentre.election.datamodel.ConstituencyType;
import org.insightcentre.election.datamodel.County;
import org.insightcentre.election.datamodel.ElectoralDivision;
import org.insightcentre.election.datamodel.Scenario;

import java.util.Arrays;
import java.util.List;

import static org.insightcentre.election.logging.LogShortcut.info;

public class DetailedSolver {
    Scenario base;
    public DetailedSolver(Scenario base, String county, int[] types){
        this.base = base;
        County c = County.findByName(base,county);
        assert(c!=null);
        int nrConstituencies = Arrays.stream(types).sum();
        int[] sizes = new int[types.length];
        int nrSeats = 0;
        int i = 0;
        for(ConstituencyType ct:base.getListConstituencyType()){
            sizes[i] = ct.getNrSeats();
            nrSeats += sizes[i]*types[i];
            i++;
        }
        List<ElectoralDivision> list = base.getListElectoralDivision().stream().filter(x->x.getCounty()==c).toList();
        int edPop = list.stream().mapToInt(ElectoralDivision::getTotalPopulation).sum();
        double popPerSeat = 1.0*edPop/nrSeats;
        info("County "+c.getName()+
                " Const "+nrConstituencies+
                " Seats "+nrSeats+
                " EDs "+list.size()+
                " 2022pop "+c.getTotalPopulation()+
                " EDpop "+edPop+
                " AvgPerSeat "+popPerSeat);

    }
}
