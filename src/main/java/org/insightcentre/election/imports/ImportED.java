package org.insightcentre.election.imports;

import au.com.bytecode.opencsv.CSVReader;
import org.insightcentre.election.datamodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.insightcentre.election.logging.LogShortcut.info;
import static org.insightcentre.election.logging.LogShortcut.severe;

public class ImportED extends ImportCSV{
    public ImportED(Scenario base, String importDir, String fileName){
        String fullName = importDir+fileName;
        try{
            info("Reading file " + fullName);
            CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(fullName),"UTF8"),',');
            String[] firstLine = reader.readNext();
            String[] nextLine;
            int line = 1;
            int created = 0;
            while ((nextLine = reader.readNext()) != null) {
                int col= 0;
                if (!nextLine[0].equals("")) {

                    int nr = readInteger(nextLine[col++].trim());
//                    info("Nr "+nr+" length "+nextLine.length);
                    String objectId = nextLine[col++];
                    String edId = nextLine[col++];
                    String edName = nextLine[col++];
                    String edNameGaelige = nextLine[col++];
                    String county = nextLine[col++];
                    String countyGaelige = nextLine[col++];
                    String province = nextLine[col++];
                    double centroidX = readDouble(nextLine[col++].trim());
                    double centroidY = readDouble(nextLine[col++].trim());
                    String guid = nextLine[col++];
                    String csoed = nextLine[col++];
                    String osied = nextLine[col++];
                    String csoed_34_1 = nextLine[col++];
                    double shapeArea = readDouble(nextLine[col++]);
                    double shapeLength = readDouble(nextLine[col++]);
                    String geometry = nextLine[col++];
                    double longitude = readDouble(nextLine[col++].trim());
                    double latitude = readDouble(nextLine[col++].trim());


                    ElectoralDivision p = new ElectoralDivision(base);
                    p.setName(edName);
                    p.setNr(nr);
                    p.setIdent(guid);
                    p.setEdId(readInteger(edId));
                    p.setEdIdString(edId);
                    p.setLongitude(longitude);
                    p.setLatitude(latitude);
                    p.setShortName(edId);
                    p.setCounty(findCounty(base,county));
                    p.setProvince(Province.findOrCreate(base,province));
                    p.setShapeLength(shapeLength);
                    p.setShapeArea(shapeArea);
                    p.setTotalArea(shapeArea);
                    p.setShape(treat(geometry));
                    BoundingBox b = new BoundingBox(p.getShape());
                    p.setXMin(b.getX1());
                    p.setXMax(b.getX2());
                    p.setYMin(b.getY1());
                    p.setYMax(b.getY2());
                    assert(b.contains(longitude,latitude));


                    created++;


                }
                line++;
            }
            info("PopCentre File read, "+line+" lines, "+created+ " created centres");

        } catch(IOException e){
            severe("Cannot read file "+fullName+", exception "+e.getMessage());
        }

    }

    private String treat(String shape){
        if (shape.startsWith("POLYGON")){
            String mod =  shape.replace("POLYGON ((","{\"shape\":[[").replace("))","]]}").
                    replaceAll("\\), \\(","],[").
                    replaceAll(", ",",").replaceAll(" ",",");
            return mod;
        } else if (shape.startsWith("MULTIPOLYGON")){
            String mod = shape.replace("MULTIPOLYGON (((","{\"multi\":[[[").replace(")))","]]]}").
                    replaceAll("\\)\\), \\(\\(","]],[[").
                    replaceAll("\\), \\(","],[").
                    replaceAll(", ",",").replaceAll(" ",",");
            return mod;
        } else {
            return ">>>>>"+shape;
        }
    }

    private int countyNr=0;
    private County findCounty(Scenario base,String name){
        County res = County.findByName(base,capitalize(name.toLowerCase()));
        if (res == null){
            res = new County(base);
            res.setName(name);
//            res.setNr(countyNr++);
        }
        return res;
    }
}
