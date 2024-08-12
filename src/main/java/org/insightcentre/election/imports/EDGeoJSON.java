package org.insightcentre.election.imports;

import org.insightcentre.election.datamodel.County;
import org.insightcentre.election.datamodel.ElectoralDivision;
import org.insightcentre.election.datamodel.Lea;
import org.insightcentre.election.datamodel.Scenario;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.insightcentre.election.logging.LogShortcut.info;
import static org.insightcentre.election.logging.LogShortcut.severe;

public class EDGeoJSON {
    public EDGeoJSON(Scenario base, String fullName){
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
//                info("---------------------");
                String iType = item.getString("type");
                int nr = item.getInt("id");
                JSONObject geom = item.getJSONObject("geometry");
                String gType = geom.getString("type");
                JSONArray gArr = geom.getJSONArray("coordinates");
                Polygon polygon;
                Point p=new Point(0,0);

//                info("geo "+gType+" "+gArr.length());
                if (gType.equals("Polygon")) {
//                    assert (gArr.length() == 1);
                    JSONArray pArr = gArr.getJSONArray(0);
                    polygon = readPolygon(pArr);
                    p = polygon.centroid();

                } else if (gType.equals("MultiPolygon")){
                    List<Polygon> list = new ArrayList<>();
                    for(int j=0;j<gArr.length();j++){
                        JSONArray mArr = gArr.getJSONArray(j);
                        assert(mArr.length()==1);
                        JSONArray pArr = mArr.getJSONArray(0);
                        polygon = readPolygon(pArr);
                        list.add(polygon);
                    }
                    MultiPolygon mp = new MultiPolygon(list);
                    p = mp.centroid();
                 } else {
                    severe("unknown shape "+gType);
                    assert(false);
                }
                JSONObject properties = item.getJSONObject("properties");
                String name = properties.getString("ED_GUID");
                String official = properties.getString("ED_OFFICIAL");
                String lea = properties.getString("CSO_LEA");
                String county = capitalize(convertCounty(properties.getString("COUNTY_ENGLISH")).toLowerCase());
                ElectoralDivision ed = ElectoralDivision.findByName(base,name);
                assert(ed != null);
                County c = County.findByName(base,county);
                if (c==null){
                    info("bad "+county);
                    assert(false);
                }
//                info("name "+name+" "+county);
                ed.setCounty(c);
                ed.setIdent(official);
                ed.setCentroidX(p.getX());
                ed.setCentroidY(p.getY());
                ed.setShape(geom.toString());
                ed.setLea(Lea.findOrCreate(base,lea));

//                for(String key: geom.keySet()){
//                    info("prop "+key);
//                }
            }
        } catch(IOException e){
            severe("Cannot read file "+fullName+", exception "+e.getMessage());
        }

    }

    private Polygon readPolygon(JSONArray pArr){
        info("p "+pArr.length());
        List<Point> list = new ArrayList<>();
        for(int j=0;j<pArr.length();j++){
            JSONArray point = pArr.getJSONArray(j);
//            info("point "+j+" "+point.length());
            double x = point.getDouble(0);
            double y = point.getDouble(1);
            list.add(new Point(x,y));

        }
        return new Polygon(list);

    }

    private String convertCounty(String name){
        switch(name){
            case "SOUTH DUBLIN": return "DUBLIN";
            case "FINGAL": return "DUBLIN";
            case "DUBLIN CITY": return "DUBLIN";
            case "DUN LAOGHAIRE/RATHDOWN": return "DUBLIN";
            case "CORK CITY": return "CORK";
            case "GALWAY CITY": return "GALWAY";
            case "LIMERICK CITY": return "LIMERICK";
            case "WATERFORD CITY": return "WATERFORD";
            case "SOUTH TIPPERARY": return "TIPPERARY";
            case "NORTH TIPPERARY": return "TIPPERARY";
            default:
                return name;
        }
    }
}
