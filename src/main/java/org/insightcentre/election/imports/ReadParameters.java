package org.insightcentre.election.imports;

import org.insightcentre.election.datamodel.ConstituencyType;
import org.insightcentre.election.datamodel.County;
import org.insightcentre.election.datamodel.NeighborCounty;
import org.insightcentre.election.datamodel.Scenario;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.insightcentre.election.logging.LogShortcut.severe;

public class ReadParameters {
    public ReadParameters(Scenario base, String fullName){
        try {
            String text = new String(Files.readAllBytes(Paths.get(fullName)));
//            System.out.println(text);
            JSONObject obj = new JSONObject(text);
            base.setAlphaCostFactor(obj.getInt("alpha"));
            base.setBetaCostFactor(obj.getInt("beta"));
            base.setLowBound(obj.getInt("low"));
            base.setHighBound(obj.getInt("high"));
            base.setTotalPopulation(obj.getInt("totalPopulation"));
            JSONArray arr = obj.getJSONArray("sizes");
            for(int i=0;i<arr.length();i++){
                JSONObject type = arr.getJSONObject(i);
                ConstituencyType cType = new ConstituencyType(base);
                cType.setName("T"+type.getInt("nrSeats"));
                cType.setNrSeats(type.getInt("nrSeats"));
                cType.setGammaCostFactor(type.getInt("cost"));
            }
            JSONArray counties = obj.getJSONArray("counties");
            for(int i=0;i<counties.length();i++){
                JSONObject county = counties.getJSONObject(i);
                County c = new County(base);
                c.setName(county.getString("name"));
                c.setShortName(county.getString("name"));
                c.setTotalPopulation(county.getInt("size"));
                c.setNr(i);
            }
            JSONArray neighbors = obj.getJSONArray("neighbors");
            for(int i=0;i<neighbors.length();i++){
                JSONObject neighbor = neighbors.getJSONObject(i);
                NeighborCounty nc = new NeighborCounty(base);
                nc.setCounty1(lookupCounty(base,neighbor.getString("a")));
                nc.setCounty2(lookupCounty(base,neighbor.getString("b")));
            }
        } catch(IOException e){
            severe("Cannot read file "+fullName+", exception "+e.getMessage());
        }

    }

    private County lookupCounty(Scenario base,String name){
        County res= County.findByName(base,name);
        assert(res != null);
        return res;
    }
}
