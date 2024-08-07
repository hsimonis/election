package org.insightcentre.election.exports;

import org.insightcentre.election.datamodel.Scenario;
import org.insightcentre.election.datamodel.SolCounty;
import org.insightcentre.election.datamodel.SolTransfer;
import org.insightcentre.election.datamodel.Solution;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import static org.insightcentre.election.logging.LogShortcut.severe;

public class ExportSolutions {
    public ExportSolutions(Scenario base, String fullName){
        JSONArray arr = new JSONArray();
        for(Solution sol:base.getListSolution()){
            JSONObject obj = new JSONObject();
            obj.put("name",sol.getName());
            obj.put("nr",sol.getNr());
            obj.put("k",sol.getK());
            obj.put("delta",sol.getDelta());
            obj.put("deltaPercent",sol.getDeltaPercent());
            obj.put("timeLimit",sol.getTimeLimit());
            obj.put("nrThreads",sol.getNrThreads());
            obj.put("personsPerTD",sol.getPersonsPerTD());
            obj.put("minE",sol.getMinE());
            obj.put("maxE",sol.getMaxE());
            obj.put("weightedAverage",sol.getWeightedAverage());
            obj.put("weightedVariance",sol.getWeightedVariance());
            obj.put("minV",sol.getMinV());
            obj.put("maxV",sol.getMaxV());
            obj.put("range",sol.getRange());
            obj.put("totalTransfers",sol.getTotalTransfers());
            obj.put("totalTransferred",sol.getTotalTransferred());
            obj.put("nrConstituencies",sol.getNrConstituencies());
            obj.put("avgSeatsPerConstituency",sol.getAvgSeatsPerConstituency());
            obj.put("solutionStatus",sol.getSolutionStatus().toString());
            obj.put("objValue",sol.getObjValue());
            obj.put("lb",sol.getLb());
            obj.put("gapPercent",sol.getGapPercent());
            obj.put("time",sol.getTime());
            JSONArray counties = new JSONArray();
            for(SolCounty sc:base.getListSolCounty().stream().filter(x->x.getSolution()==sol).toList()){
                JSONObject county = new JSONObject();
                county.put("county",sc.getCounty().getName());
                county.put("population",sc.getEffectivePopulation());
                county.put("effectivePopulation",sc.getPopulation());
                county.put("transferOut",sc.getTransferOut());
                county.put("transferIn",sc.getTransferIn());
                county.put("effectivePopulation",sc.getEffectivePopulation());
                county.put("constituenciesAssigned",sc.getConstituenciesAssigned());
                county.put("seatsAssigned",sc.getSeatsAssigned());
                county.put("personsPerSeat",sc.getPersonsPerSeat());
                county.put("variation",sc.getVariation());
                counties.put(county);
            }
            JSONArray transfers = new JSONArray();
            for(SolTransfer st:base.getListSolTransfer().stream().filter(x->x.getSolution()==sol).toList()){
                JSONObject t = new JSONObject();
                t.put("from",st.getFrom());
                t.put("to",st.getTo());
                t.put("value",st.getValue());
                t.put("percentOfFrom",st.getPercentOfFrom());
                transfers.put(t);
            }
            obj.put("counties",counties);
            obj.put("transfers",transfers);
            arr.put(obj);
        }
        try{
            PrintWriter out = new PrintWriter(new File(fullName));
            out.print(arr.toString(2));
            out.close();

        } catch(IOException e){
            severe("Cannot write file "+fullName+", exception "+e.getMessage());
        }
    }
}
