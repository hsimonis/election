package org.insightcentre.election.imports;

import au.com.bytecode.opencsv.CSVReader;
import org.insightcentre.election.datamodel.ElectoralDivision;
import org.insightcentre.election.datamodel.Scenario;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

import static org.insightcentre.election.logging.LogShortcut.info;
import static org.insightcentre.election.logging.LogShortcut.severe;

public class ImportEDPopulation extends ImportCSV{
    public ImportEDPopulation(Scenario base, String importDir, String fileName){
        String fullName = importDir+fileName;
        Hashtable<String,ElectoralDivision> guidHash = new Hashtable<>();
        for(ElectoralDivision ed:base.getListElectoralDivision()){
            guidHash.put(ed.getIdent(),ed);
        }
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
                    String guid = nextLine[col++].trim();
                    String geoid = nextLine[col++].trim();
                    String name = nextLine[col++].trim();
                    int cohort0 = readInteger(nextLine[col++]);
                    int cohort10 = readInteger(nextLine[col++]);
                    int cohort20 = readInteger(nextLine[col++]);
                    int cohort30 = readInteger(nextLine[col++]);
                    int cohort40 = readInteger(nextLine[col++]);
                    int cohort50 = readInteger(nextLine[col++]);
                    int cohort60 = readInteger(nextLine[col++]);
                    int cohort70 = readInteger(nextLine[col++]);
                    int cohort80 = readInteger(nextLine[col++]);

                    ElectoralDivision ed = guidHash.get(guid);
                    if (ed == null){
                        severe("Unknown "+guid+" name "+name +" pop "+(cohort0+cohort10+cohort20+cohort30+cohort40+cohort50+cohort60+cohort70+cohort80));
                    } else {
                        ed.setTotalPopulation(cohort0+cohort10+cohort20+cohort30+cohort40+cohort50+cohort60+cohort70+cohort80);
//                        ed.setPopulationDensity(1000.0*1000.0*ed.getTotalPopulation()/ed.getShapeArea());
                    }

                    created++;


                }
                line++;
            }
            info("PopCentre File read, "+line+" lines, "+created+ " created centres");

        } catch(IOException e){
            severe("Cannot read file "+fullName+", exception "+e.getMessage());
        }

    }
}
