package org.insightcentre.election.imports;

import org.insightcentre.election.datamodel.County;
import org.insightcentre.election.datamodel.Scenario;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.insightcentre.election.logging.LogShortcut.info;
import static org.insightcentre.election.logging.LogShortcut.severe;

public class CountyGeoJSON {
    public CountyGeoJSON(Scenario base, String fullName){
        try {
            String text = new String(Files.readAllBytes(Paths.get(fullName)));
//            System.out.println(text);
            JSONObject obj = new JSONObject(text);
            String type = obj.getString("type");
            info("type "+type);
            assert(type.equals("FeatureCollection"));
            JSONArray arr = obj.getJSONArray("features");
            info("arr "+arr.length());
            for(int i=0;i<arr.length();i++){
                JSONObject item = arr.getJSONObject(i);
                info("---------------------");
                String iType = item.getString("type");
                int nr = item.getInt("id");
                JSONObject geom = item.getJSONObject("geometry");
                String gType = geom.getString("type");
                JSONArray gArr = geom.getJSONArray("coordinates");
                info("geo "+gType+" "+gArr.length());
                if (gType.equals("Polygon")){
                    assert(gArr.length()==1);
                    JSONArray pArr = gArr.getJSONArray(0);
//                    readPolygon(pArr);
                } else if (gType.equals("MultiPolygon")){
                    for(int j=0;j<gArr.length();j++){
                        JSONArray mArr = gArr.getJSONArray(j);
                        assert(mArr.length()==1);
                        JSONArray pArr = mArr.getJSONArray(0);
                        info("p "+pArr.length());
//                        readPolygon(pArr);
                    }
                }
                JSONObject properties = item.getJSONObject("properties");
                String name = capitalize(properties.getString("ENGLISH").toLowerCase());
                String county = properties.getString("COUNTY");
                String province = properties.getString("PROVINCE");
                double x = properties.getDouble("CENTROID_X");
                double y = properties.getDouble("CENTROID_Y");
                County c = County.findByName(base,name);
                c.setCentroidX(x);
                c.setCentroidY(y);
                info("name "+name+" "+county+" "+province+" "+x+" "+y);

//                for(String key: geom.keySet()){
//                    info("prop "+key);
//                }
            }
        } catch(IOException e){
            severe("Cannot read file "+fullName+", exception "+e.getMessage());
        }

    }

    private void readPolygon(JSONArray pArr){
        info("p "+pArr.length());
        for(int j=0;j<pArr.length();j++){
            JSONArray point = pArr.getJSONArray(j);
            info("point "+j+" "+point.length());
            double x = point.getDouble(0);
            double y = point.getDouble(1);
        }

    }
}
