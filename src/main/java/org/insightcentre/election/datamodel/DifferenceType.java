// licence details to be added
package org.insightcentre.election.datamodel;
import org.insightcentre.election.datamodel.ApplicationDataset;
import org.insightcentre.election.datamodel.ApplicationObject;
import org.insightcentre.election.datamodel.ApplicationDifference;
import org.insightcentre.election.datamodel.ApplicationWarning;
import org.insightcentre.election.datamodel.Scenario;
import org.insightcentre.election.datamodel.ConstituencyType;
import org.insightcentre.election.datamodel.MapLocation;
import org.insightcentre.election.datamodel.Area;
import org.insightcentre.election.datamodel.Nuts3;
import org.insightcentre.election.datamodel.Province;
import org.insightcentre.election.datamodel.Shaped;
import org.insightcentre.election.datamodel.County;
import org.insightcentre.election.datamodel.ElectoralDivision;
import org.insightcentre.election.datamodel.Lea;
import org.insightcentre.election.datamodel.Distance;
import org.insightcentre.election.datamodel.DistanceError;
import org.insightcentre.election.datamodel.NeighborCounty;
import org.insightcentre.election.datamodel.Solution;
import org.insightcentre.election.datamodel.SolCounty;
import org.insightcentre.election.datamodel.SolTransfer;
import org.insightcentre.election.datamodel.SolConstType;
import org.insightcentre.election.datamodel.DifferenceType;
import org.insightcentre.election.datamodel.WarningType;
import org.insightcentre.election.datamodel.SolutionStatus;
import org.insightcentre.election.datamodel.SolverType;
import org.insightcentre.election.datamodel.XMLLoader;
import java.util.*;
import java.io.*;
import framework.types.*;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import framework.ApplicationObjectInterface;
import framework.ApplicationDatasetInterface;
import framework.AppearInCollection;

/**
 * This type decribes the annotation used when comparing two datasets to indicate the differences between datasets A and B.
 * @author generated
*/

public enum DifferenceType{
    /**
 *  The item only occurs in dataset A.
 *
*/

ONLYA,
    /**
 *  The item only occurs in dataset B.
 *
*/

ONLYB,
    /**
 *  The item occurs in both datasets, but is different. This is the version of dataset A.
 *
*/

DIFFERA,
    /**
 *  The item occurs in both datasets, but is different. This is the version of dataset B.
 *
*/

DIFFERB;
private static DifferenceType[] cache = null;

public static DifferenceType[] cachedValues(){
    if (cache== null){
        cache = DifferenceType.values();
    }
    return cache;
}

public static String[] getNamesAndAll(){
    String[] res = new String[DifferenceType.cachedValues().length+1];
    int i=0;
    res[i++] = "All";
    for(DifferenceType p:DifferenceType.cachedValues()){
        res[i++] = p.name();
    }
    return res;
}

public static String[] getNames(){
    String[] res = new String[DifferenceType.cachedValues().length];
    int i=0;
    for(DifferenceType p:DifferenceType.cachedValues()){
        res[i++] = p.name();
    }
    return res;
}

public static DifferenceType entry(int i){
    return cachedValues()[i];
}

public static String nameOf(int i){
    return cachedValues()[i].name();
}

public static int indexOf(DifferenceType p){
    return p.ordinal();
}

public static int size(){
    return cachedValues().length;
}

}
