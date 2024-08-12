package org.insightcentre.election.imports;

import org.insightcentre.election.datamodel.County;
import org.insightcentre.election.datamodel.ElectoralDivision;
import org.insightcentre.election.datamodel.Scenario;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class Importer {
    public Importer(Scenario base,String importDir,String scenario){
        assert(importDir.endsWith("/"));
        new ReadParameters(base,importDir+scenario+".json");
        // different coordinate system compare to ED
        new CountyGeoJSON(base,importDir+"Counties.geojson");
        // centroid and shape coordinate systems differ
//        new CountyGeoJSON(base,importDir+"Counties___OSi_National_Statutory_Boundaries___Generalised_20m_-6920972630406172930.geojson");
        new ImportSAPS(base,importDir+"CSO_2022_ED.csv");
        new EDGeoJSON(base,importDir+"CSO_2022_ELECTORAL_DIVISIONS.geojson");
        groupED(base);
    }

    private void groupED(Scenario base){
        Map<County, List<ElectoralDivision>> map = base.getListElectoralDivision().stream().collect(groupingBy(ElectoralDivision::getCounty));
        for(County c:map.keySet()){
            c.setNrED(map.get(c).size());
        }
    }
}
