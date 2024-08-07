// licence details to be added
package org.insightcentre.election.datamodel;
import org.insightcentre.election.datamodel.ApplicationDataset;
import org.insightcentre.election.datamodel.ApplicationObject;
import org.insightcentre.election.datamodel.ApplicationDifference;
import org.insightcentre.election.datamodel.ApplicationWarning;
import org.insightcentre.election.datamodel.Scenario;
import org.insightcentre.election.datamodel.Country;
import org.insightcentre.election.datamodel.County;
import org.insightcentre.election.datamodel.ConstituencyType;
import org.insightcentre.election.datamodel.MapLocation;
import org.insightcentre.election.datamodel.Area;
import org.insightcentre.election.datamodel.Nuts3;
import org.insightcentre.election.datamodel.Province;
import org.insightcentre.election.datamodel.Shaped;
import org.insightcentre.election.datamodel.ElectoralDivision;
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
 * 
 * @author generated
*/

public enum SolutionStatus{
    /**
 *  
 *
*/

Solution,
    /**
 *  
 *
*/

Optimal,
    /**
 *  
 *
*/

Unsatisfiable,
    /**
 *  
 *
*/

Unknown,
    /**
 *  
 *
*/

Undetermined;
private static SolutionStatus[] cache = null;

public static SolutionStatus[] cachedValues(){
    if (cache== null){
        cache = SolutionStatus.values();
    }
    return cache;
}

public static String[] getNamesAndAll(){
    String[] res = new String[SolutionStatus.cachedValues().length+1];
    int i=0;
    res[i++] = "All";
    for(SolutionStatus p:SolutionStatus.cachedValues()){
        res[i++] = p.name();
    }
    return res;
}

public static String[] getNames(){
    String[] res = new String[SolutionStatus.cachedValues().length];
    int i=0;
    for(SolutionStatus p:SolutionStatus.cachedValues()){
        res[i++] = p.name();
    }
    return res;
}

public static SolutionStatus entry(int i){
    return cachedValues()[i];
}

public static String nameOf(int i){
    return cachedValues()[i].name();
}

public static int indexOf(SolutionStatus p){
    return p.ordinal();
}

public static int size(){
    return cachedValues().length;
}

}
