package org.insightcentre.election.imports;

import au.com.bytecode.opencsv.CSVReader;
import framework.types.DateTime;
import framework.types.Minutes;
import org.insightcentre.election.datamodel.Country;
import org.insightcentre.election.datamodel.Scenario;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.insightcentre.election.logging.LogShortcut.info;
import static org.insightcentre.election.logging.LogShortcut.severe;

public class ImportCountry extends ImportCSV{
    public ImportCountry(Scenario base, String fullFile){
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


                    String label = nextLine[col++].trim();
                    String year = nextLine[col++].trim();
                    String sex = nextLine[col++].trim();
                    String name = nextLine[col++].trim();
                    String unit = nextLine[col++].trim();
                    int value = readInteger(nextLine[col++].trim());

                    Country c = new Country(base);
                    c.setName(name);
                    c.setPopulation(value);



                    created++;


                }
                line++;
            }
            info("Item File read, "+line+" lines, "+created+ " created items");

        } catch (IOException e){
            severe("Cannot read file: "+fullFile+" exception "+e.getMessage());
        }
    }

}
