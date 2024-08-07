package org.insightcentre.election.exports;

import org.insightcentre.election.datamodel.Scenario;

public class Exporter {
    public Exporter(Scenario base, String exportDir){
        assert(exportDir.endsWith("/"));
        new ExportSolutions(base,exportDir+"sols.json");
    }
}
