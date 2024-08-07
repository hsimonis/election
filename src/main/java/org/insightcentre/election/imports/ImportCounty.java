package org.insightcentre.election.imports;

import au.com.bytecode.opencsv.CSVReader;
import org.insightcentre.election.datamodel.Country;
import org.insightcentre.election.datamodel.County;
import org.insightcentre.election.datamodel.Scenario;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.insightcentre.election.logging.LogShortcut.info;
import static org.insightcentre.election.logging.LogShortcut.severe;

public class ImportCounty extends ImportCSV{
    public ImportCounty(Scenario base, String fullFile){
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


                    String label = nextLine[col++].trim();
                    String year = nextLine[col++].trim();
                    String sex = nextLine[col++].trim();
                    String name = nextLine[col++].trim();
                    String unit = nextLine[col++].trim();
                    int value = readInteger(nextLine[col++].trim());

                    County c = new County(base);
                    c.setName(name);
                    c.setPopulation(value);



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
