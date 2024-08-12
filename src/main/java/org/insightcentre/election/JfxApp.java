package org.insightcentre.election;

/*
Generated once, should be extended by user
*/

import org.insightcentre.election.datamodel.*;
import framework.ApplicationDatasetInterface;
import framework.ApplicationObjectInterface;
import framework.types.IrishCalendar;
import org.insightcentre.election.exports.Exporter;
import org.insightcentre.election.implementedsolver.ConstituencySolver;
import org.insightcentre.election.implementedsolver.DetailedSolver;
import org.insightcentre.election.imports.Importer;
import org.insightcentre.election.reports.OverviewReport;

public class JfxApp extends GeneratedJfxApp {

// callbacks to add for user interaction that is not generated
// use stubs in GeneratedJFxApp as basis
// callback for ctrl+selection in list
        public void showObject(ApplicationObjectInterface obj){
                super.showObject(obj);
        }

// callback called once at startup to create initial data in application
        @Override
        public ApplicationDatasetInterface minimalDataset() {
                Scenario base = new Scenario();
                IrishCalendar.buildCalendar();
                int seats = 174;
                String scenario="parameters"; // "parameters","nogamma","noalpha"
                String specifics;
                switch(scenario) {
                        case "parameters":
                                specifics = "This scenario has " + seats + " seats in total. It is the computational " +
                                        "baseline, with balanced weights for alpha, beta, and gamma.";
                                break;
                        case "nogamma":
                                specifics = "This scenario has " + seats + " seats in total. The scenario does not assign a cost to the " +
                                        "different sizes of constituencies, i.e. the gamma weight factors are zero.";
                                break;
                        case "noalpha":
                                specifics = "This scenario has " + seats + " seats in total. The scenario does not assign a cost to the " +
                                        "inter-county transfers, but does count the transferred population in the cost. " +
                                        "This should results in many small transfers between counties.";
                                break;
                        default:
                                specifics = "No description provided for scenario.";
                }
                new Importer(base,"imports/",scenario);
//                for(int delta = 100;delta<=3000;delta+= 50) {
//                        new ConstituencySolver(base, seats, delta, 300, 25);
//                }
//                new Exporter(base,"exports/");
//                new OverviewReport(base,"reports/",scenario,specifics).produce(scenario,"Solution Overview Report for Scenario "+scenario,"H. Simonis");
                new DetailedSolver(base,"Galway",new int[]{0,1,1});
                new DetailedSolver(base,"Dublin",new int[]{0,1,9});
                new DetailedSolver(base,"Cork",new int[]{0,1,3});
                new DetailedSolver(base,"Meath",new int[]{0,2,0});
                new DetailedSolver(base,"Kildare",new int[]{0,2,0});
                new DetailedSolver(base,"Limerick",new int[]{1,1,0});
                base.setDirty(false);
                return base;
        }

// main entry point for interactive application
        public static void main(String[] args) {
                launch(args);
        }

}
