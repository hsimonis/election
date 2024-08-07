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

public abstract class MapLocation extends ApplicationObject{
/**
 *  
 *
*/

    public String ident;

/**
 *  
 *
*/

    public Double latitude;

/**
 *  
 *
*/

    public Double longitude;

/**
 *  
 *
*/

    public String shortName;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public MapLocation(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public MapLocation(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setIdent("");
        setLatitude(0.0);
        setLongitude(0.0);
        setShortName("");
        applicationDataset.addMapLocation(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public MapLocation(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            String ident,
            Double latitude,
            Double longitude,
            String shortName){
        super(applicationDataset,
            id,
            name);
        setIdent(ident);
        setLatitude(latitude);
        setLongitude(longitude);
        setShortName(shortName);
        applicationDataset.addMapLocation(this);
    }

    public MapLocation(MapLocation other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.ident,
            other.latitude,
            other.longitude,
            other.shortName);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        getApplicationDataset().cascadeDistanceFrom(this);
        getApplicationDataset().cascadeDistanceTo(this);
        getApplicationDataset().cascadeDistanceErrorFrom(this);
        getApplicationDataset().cascadeDistanceErrorTo(this);
        return getApplicationDataset().removeMapLocation(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute ident
 *
 * @return String
*/

    public String getIdent(){
        return this.ident;
    }

/**
 *  get attribute latitude
 *
 * @return Double
*/

    public Double getLatitude(){
        return this.latitude;
    }

/**
 *  get attribute longitude
 *
 * @return Double
*/

    public Double getLongitude(){
        return this.longitude;
    }

/**
 *  get attribute shortName
 *
 * @return String
*/

    public String getShortName(){
        return this.shortName;
    }

/**
 *  set attribute ident, mark dataset as dirty, mark dataset as not valid
@param ident String
 *
*/

    public void setIdent(String ident){
        this.ident = ident;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute latitude, mark dataset as dirty, mark dataset as not valid
@param latitude Double
 *
*/

    public void setLatitude(Double latitude){
        this.latitude = latitude;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute longitude, mark dataset as dirty, mark dataset as not valid
@param longitude Double
 *
*/

    public void setLongitude(Double longitude){
        this.longitude = longitude;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute shortName, mark dataset as dirty, mark dataset as not valid
@param shortName String
 *
*/

    public void setShortName(String shortName){
        this.shortName = shortName;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  override generic toString() method, show all attributes in human readable form
 * @return String details of the format are not clearly defined at the moment
*/

    @Override
    public String toString(){
        return toColumnString();
    }

/**
 *  alternative to the toString() method, experimental at this point
 *  This should be easier to read than toString(), but contain more information than toColumnString()
 * @return String human readable
*/

    public String prettyString(){
        return ""+ " " +getId()+ " " +getName()+ " " +getIdent()+ " " +getLatitude()+ " " +getLongitude()+ " " +getShortName();
    }

/**
 *  alternative to the toString() method, used in the table views
 *  this only shows enough fields to identify the object
 *  Normally this is the name attribute, but this can be changed by the display_key fields
 * @return String normally name or other fields defned in display_key
*/

    public String toColumnString(){
        return getName();
    }

/**
 * show object as one element in XML format
 * side effect of writing to file
 * @param out PrintWriter
*/

     public void toXML(PrintWriter out){
         out.println("<mapLocation "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " ident=\""+toXMLIdent()+"\""+
            " latitude=\""+toXMLLatitude()+"\""+
            " longitude=\""+toXMLLongitude()+"\""+
            " shortName=\""+toXMLShortName()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLIdent(){
        return this.safeXML(getIdent());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLLatitude(){
        return this.getLatitude().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLLongitude(){
        return this.getLongitude().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLShortName(){
        return this.safeXML(getShortName());
    }

/**
 * find the same object in another dataset
 * @param a MapLocation item we are looking for
 * @param bList List<MapLocation> list of items in which we are searching
 * @return MapLocation entry of list b which is applicationSame() to a
*/

    public static MapLocation find(MapLocation a, List<MapLocation> bList){
        for(MapLocation b : bList){
            if (b.applicationSame(a)){
                return b;
            }
        }
        return null;
    }

/**
 * find an object from its name; returns null if no such item exists
 * it is not defined which object is returned if multiple have the same name
 * @param base  dataset in which we are searching
 * @param name MapLocation name of the object we are looking for
 * @return MapLocation entry of the dataset with the given name; otherwise null
*/

    public static MapLocation findByName(ApplicationDataset base, String name){
        for(MapLocation a:base.getListMapLocation()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        return null;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return MapLocation first entry in the dataset of this type; null if that does not exists
*/

    public static MapLocation findFirst(ApplicationDataset base){
        if (base.getListMapLocation().isEmpty()) {
            return null;
        }
        return base.getListMapLocation().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return MapLocation some entry in the dataset of this type; null if that does not exists
*/

    public static MapLocation findAny(ApplicationDataset base){
        int size=base.getListMapLocation().size();
        if (size > 0) {
             return base.getListMapLocation().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return MapLocation last entry in the dataset of this type; null if that does not exists
*/

    public static MapLocation findLast(ApplicationDataset base){
        int size=base.getListMapLocation().size();
        if (size > 0) {
             return base.getListMapLocation().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b MapLocation compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(MapLocation b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b MapLocation compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(MapLocation b){
      if(!this.getIdent().equals(b.getIdent())){
         System.out.println("Ident");
        }
      if(!this.getLatitude().equals(b.getLatitude())){
         System.out.println("Latitude");
        }
      if(!this.getLongitude().equals(b.getLongitude())){
         System.out.println("Longitude");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getShortName().equals(b.getShortName())){
         System.out.println("ShortName");
        }
        return  this.getIdent().equals(b.getIdent()) &&
          this.getLatitude().equals(b.getLatitude()) &&
          this.getLongitude().equals(b.getLongitude()) &&
          this.getName().equals(b.getName()) &&
          this.getShortName().equals(b.getShortName());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","MapLocation",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
    }

/**
 *  This method states if the class depends on the solver.
 *
*/

    public static Boolean isSolverDependent(){
        return false;
    }

   public List<ApplicationObjectInterface> getFeasibleValues(ApplicationDatasetInterface base,String attrName){
      return null;
   }

}
