package org.insightcentre.election.imports;

import framework.types.*;
import org.insightcentre.election.datamodel.*;

import java.util.Date;

import static org.insightcentre.election.logging.LogShortcut.severe;
import static org.insightcentre.election.logging.LogShortcut.warning;


public class ImportCSV {

    public double readDouble(String entry){
        if (entry.equals("")||entry.equals("null")||entry.equals(" ")|| entry.equals("NA")){
            return Double.NaN;
        }
        double d = Double.parseDouble(entry);

        return d;

    }

    public int readInteger(String entry){
        if (entry.equals("")||entry.equals("null")){
            return 0;
        }
        return Integer.parseInt(entry);
    }

    DateTime readDateTime(String entry){
        return readDateTime(entry,"dd/MM/yyyy HH:mm");
    }

    public DateTime readDateTime(String entry, String format){
        if (entry.equals("")) return null;
        Date date = IrishCalendar.getDate(entry,format);
        if (date == null) {
//            return null;
            date= IrishCalendar.getDate(entry,"yyyy-MM-dd HH:mm':00 UTC'");
            if (date == null) {
                return null;
            }
//            date = IrishCalendar.getDate(entry,"dd/MM/yyyy");
//            if (date == null) {
//                date = IrishCalendar.getDate(entry,"yyyy-MM-dd");
//                if (date == null) {
//                    return null;
//                }
//            }
        }
        return new DateTime(date);
    }

    DateOnly readDateOnly(String entry){
        return readDateOnly(entry,"dd/MM/yyyy");
    }

    public DateOnly readDateOnly(String entry, String format){
        if (entry.equals("")) {
            return null;
        }
        Date date = IrishCalendar.getDate(entry,format);
        if (date == null) {
            return null;
        }
        return new DateOnly(date);
    }

    TimeOnly readTimeOnly(String entry){
        Date time = IrishCalendar.getTimeOnly(entry);
        if (time == null){
            return null;
        }
        return new TimeOnly(time);
    }

    TimeOnly readTimeOnly(String entry, String format){
        Date time = IrishCalendar.getTimeOnly(entry,format);
        if (time == null){
            return null;
        }
        return new TimeOnly(time);
    }

    Minutes readMinutes(String entry) {
        String[] split = entry.split(":");
        if (split.length == 2) {
            int hr = Integer.parseInt(split[0]);
            int min = Integer.parseInt(split[1]);
            return new Minutes(hr * 60 + min);
        } else if (split.length == 3) {
            int hr = Integer.parseInt(split[0]);
            int min = Integer.parseInt(split[1]);
            return new Minutes(hr * 60 + min);
        } else {
            warning("cannot parse minutes: "+entry);
            return new Minutes(0);
        }
    }

    Boolean readBoolean(String entry){
        switch (entry.toUpperCase()){
            case "TRUE":
            case "Y":
            case "YES":
                return true;
            case "FALSE":
            case "N":
            case "NO":
            default:
                return false;
        }
    }



}
