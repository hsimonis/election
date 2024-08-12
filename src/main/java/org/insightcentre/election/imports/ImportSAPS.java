package org.insightcentre.election.imports;

import au.com.bytecode.opencsv.CSVReader;
import org.insightcentre.election.datamodel.County;
import org.insightcentre.election.datamodel.ElectoralDivision;
import org.insightcentre.election.datamodel.Scenario;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.insightcentre.election.logging.LogShortcut.info;
import static org.insightcentre.election.logging.LogShortcut.severe;

public class ImportSAPS extends ImportCSV{
    public ImportSAPS(Scenario base, String fullFile){
        try{
            info("Reading file " + fullFile);
            CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(fullFile),"UTF8"),',');
            String[] firstLine = reader.readNext();
            String[] nextLine ;
            int line = 1;
            int created = 0;
            // skip over summary data line
            nextLine = reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                int col= 0;
//                System.out.println(nextLine[0]);
                if (!nextLine[0].equals("")) {


                    String guid = nextLine[col++].trim();
                    String geogid = nextLine[col++].trim();
                    String geodesc = nextLine[col++].trim();
                    int i = 107;
                    int value = readInteger(nextLine[i].trim());

                    ElectoralDivision ed = new ElectoralDivision(base);
                    ed.setName(guid);
                    ed.setShortName(geodesc);
                    ed.setEdIdString(geogid);
                    ed.setTotalPopulation(value);
                    ed.setNr(created);



                    created++;


                }
                line++;
            }
            info("County File read, "+line+" lines, "+created+ " created counties");

        } catch (IOException e){
            severe("Cannot read file: "+fullFile+" exception "+e.getMessage());
        }
    }

}
