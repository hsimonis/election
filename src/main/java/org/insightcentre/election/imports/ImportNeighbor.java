package org.insightcentre.election.imports;

import au.com.bytecode.opencsv.CSVReader;
import org.insightcentre.election.datamodel.County;
import org.insightcentre.election.datamodel.NeighborCounty;
import org.insightcentre.election.datamodel.Scenario;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.insightcentre.election.logging.LogShortcut.info;
import static org.insightcentre.election.logging.LogShortcut.severe;

public class ImportNeighbor extends ImportCSV{
    public ImportNeighbor(Scenario base, String fullFile){
        String dateFormat = "yyyyMMddHHmm";
        try{
            info("Reading file " + fullFile);
            CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(fullFile),"UTF8"),',');
            String[] firstLine = reader.readNext();
            String[] nextLine;
            int line = 1;
            int created = 0;
            while ((nextLine = reader.readNext()) != null) {
                int col= 0;
//                System.out.println(nextLine[0]);
                if (!nextLine[0].equals("")) {


                    String a = nextLine[col++].trim();
                    String b = nextLine[col++].trim();

                    County ca = County.findByName(base,a);
                    County cb = County.findByName(base,b);

                    NeighborCounty n = new NeighborCounty(base);
                    n.setCounty1(ca);
                    n.setCounty2(cb);



                    created++;


                }
                line++;
            }
            info("Neighborhood File read, "+line+" lines, "+created+ " created neighbors");

        } catch (IOException e){
            severe("Cannot read file: "+fullFile+" exception "+e.getMessage());
        }
    }

}
