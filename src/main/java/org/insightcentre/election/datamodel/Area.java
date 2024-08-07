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

public abstract class Area extends MapLocation{
/**
 *  
 *
*/

    public Double totalArea;

/**
 *  
 *
*/

    public Integer totalPopulation;

/**
 *  
 *
*/

    public Double xMax;

/**
 *  
 *
*/

    public Double xMin;

/**
 *  
 *
*/

    public Double yMax;

/**
 *  
 *
*/

    public Double yMin;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public Area(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public Area(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setTotalArea(0.0);
        setTotalPopulation(0);
        setXMax(0.0);
        setXMin(0.0);
        setYMax(0.0);
        setYMin(0.0);
        applicationDataset.addArea(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public Area(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            String ident,
            Double latitude,
            Double longitude,
            String shortName,
            Double totalArea,
            Integer totalPopulation,
            Double xMax,
            Double xMin,
            Double yMax,
            Double yMin){
        super(applicationDataset,
            id,
            name,
            ident,
            latitude,
            longitude,
            shortName);
        setTotalArea(totalArea);
        setTotalPopulation(totalPopulation);
        setXMax(xMax);
        setXMin(xMin);
        setYMax(yMax);
        setYMin(yMin);
        applicationDataset.addArea(this);
    }

    public Area(Area other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.ident,
            other.latitude,
            other.longitude,
            other.shortName,
            other.totalArea,
            other.totalPopulation,
            other.xMax,
            other.xMin,
            other.yMax,
            other.yMin);
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
        return getApplicationDataset().removeArea(this) && getApplicationDataset().removeMapLocation(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute totalArea
 *
 * @return Double
*/

    public Double getTotalArea(){
        return this.totalArea;
    }

/**
 *  get attribute totalPopulation
 *
 * @return Integer
*/

    public Integer getTotalPopulation(){
        return this.totalPopulation;
    }

/**
 *  get attribute xMax
 *
 * @return Double
*/

    public Double getXMax(){
        return this.xMax;
    }

/**
 *  get attribute xMin
 *
 * @return Double
*/

    public Double getXMin(){
        return this.xMin;
    }

/**
 *  get attribute yMax
 *
 * @return Double
*/

    public Double getYMax(){
        return this.yMax;
    }

/**
 *  get attribute yMin
 *
 * @return Double
*/

    public Double getYMin(){
        return this.yMin;
    }

/**
 *  set attribute totalArea, mark dataset as dirty, mark dataset as not valid
@param totalArea Double
 *
*/

    public void setTotalArea(Double totalArea){
        this.totalArea = totalArea;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute totalPopulation, mark dataset as dirty, mark dataset as not valid
@param totalPopulation Integer
 *
*/

    public void setTotalPopulation(Integer totalPopulation){
        this.totalPopulation = totalPopulation;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute xMax, mark dataset as dirty, mark dataset as not valid
@param xMax Double
 *
*/

    public void setXMax(Double xMax){
        this.xMax = xMax;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute xMin, mark dataset as dirty, mark dataset as not valid
@param xMin Double
 *
*/

    public void setXMin(Double xMin){
        this.xMin = xMin;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute yMax, mark dataset as dirty, mark dataset as not valid
@param yMax Double
 *
*/

    public void setYMax(Double yMax){
        this.yMax = yMax;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute yMin, mark dataset as dirty, mark dataset as not valid
@param yMin Double
 *
*/

    public void setYMin(Double yMin){
        this.yMin = yMin;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute totalPopulation, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incTotalPopulation(){
        this.totalPopulation++;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getIdent()+ " " +getLatitude()+ " " +getLongitude()+ " " +getShortName()+ " " +getTotalArea()+ " " +getTotalPopulation()+ " " +getXMax()+ " " +getXMin()+ " " +getYMax()+ " " +getYMin();
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
         out.println("<area "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " ident=\""+toXMLIdent()+"\""+
            " latitude=\""+toXMLLatitude()+"\""+
            " longitude=\""+toXMLLongitude()+"\""+
            " shortName=\""+toXMLShortName()+"\""+
            " totalArea=\""+toXMLTotalArea()+"\""+
            " totalPopulation=\""+toXMLTotalPopulation()+"\""+
            " xMax=\""+toXMLXMax()+"\""+
            " xMin=\""+toXMLXMin()+"\""+
            " yMax=\""+toXMLYMax()+"\""+
            " yMin=\""+toXMLYMin()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLTotalArea(){
        return this.getTotalArea().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLTotalPopulation(){
        return this.getTotalPopulation().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLXMax(){
        return this.getXMax().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLXMin(){
        return this.getXMin().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLYMax(){
        return this.getYMax().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLYMin(){
        return this.getYMin().toString();
    }

/**
 * find the same object in another dataset
 * @param a Area item we are looking for
 * @param bList List<Area> list of items in which we are searching
 * @return Area entry of list b which is applicationSame() to a
*/

    public static Area find(Area a, List<Area> bList){
        for(Area b : bList){
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
 * @param name Area name of the object we are looking for
 * @return Area entry of the dataset with the given name; otherwise null
*/

    public static Area findByName(ApplicationDataset base, String name){
        for(Area a:base.getListArea()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        return null;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Area first entry in the dataset of this type; null if that does not exists
*/

    public static Area findFirst(ApplicationDataset base){
        if (base.getListArea().isEmpty()) {
            return null;
        }
        return base.getListArea().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Area some entry in the dataset of this type; null if that does not exists
*/

    public static Area findAny(ApplicationDataset base){
        int size=base.getListArea().size();
        if (size > 0) {
             return base.getListArea().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Area last entry in the dataset of this type; null if that does not exists
*/

    public static Area findLast(ApplicationDataset base){
        int size=base.getListArea().size();
        if (size > 0) {
             return base.getListArea().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b Area compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(Area b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b Area compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(Area b){
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
      if(!this.getTotalArea().equals(b.getTotalArea())){
         System.out.println("TotalArea");
        }
      if(!this.getTotalPopulation().equals(b.getTotalPopulation())){
         System.out.println("TotalPopulation");
        }
      if(!this.getXMax().equals(b.getXMax())){
         System.out.println("XMax");
        }
      if(!this.getXMin().equals(b.getXMin())){
         System.out.println("XMin");
        }
      if(!this.getYMax().equals(b.getYMax())){
         System.out.println("YMax");
        }
      if(!this.getYMin().equals(b.getYMin())){
         System.out.println("YMin");
        }
        return  this.getIdent().equals(b.getIdent()) &&
          this.getLatitude().equals(b.getLatitude()) &&
          this.getLongitude().equals(b.getLongitude()) &&
          this.getName().equals(b.getName()) &&
          this.getShortName().equals(b.getShortName()) &&
          this.getTotalArea().equals(b.getTotalArea()) &&
          this.getTotalPopulation().equals(b.getTotalPopulation()) &&
          this.getXMax().equals(b.getXMax()) &&
          this.getXMin().equals(b.getXMin()) &&
          this.getYMax().equals(b.getYMax()) &&
          this.getYMin().equals(b.getYMin());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","Area",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
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
