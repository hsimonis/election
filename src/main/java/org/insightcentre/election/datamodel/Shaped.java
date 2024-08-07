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

public abstract class Shaped extends Area{
/**
 *  
 *
*/

    public Integer cluster;

/**
 *  
 *
*/

    public County county;

/**
 *  
 *
*/

    public Integer nr;

/**
 *  
 *
*/

    public Double populationDensity;

/**
 *  
 *
*/

    public Province province;

/**
 *  
 *
*/

    public String shape;

/**
 *  
 *
*/

    public Double shapeArea;

/**
 *  
 *
*/

    public Double shapeLength;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public Shaped(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public Shaped(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setCluster(0);
        setCounty(null);
        setNr(0);
        setPopulationDensity(0.0);
        setProvince(null);
        setShape("");
        setShapeArea(0.0);
        setShapeLength(0.0);
        applicationDataset.addShaped(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public Shaped(ApplicationDataset applicationDataset,
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
            Double yMin,
            Integer cluster,
            County county,
            Integer nr,
            Double populationDensity,
            Province province,
            String shape,
            Double shapeArea,
            Double shapeLength){
        super(applicationDataset,
            id,
            name,
            ident,
            latitude,
            longitude,
            shortName,
            totalArea,
            totalPopulation,
            xMax,
            xMin,
            yMax,
            yMin);
        setCluster(cluster);
        setCounty(county);
        setNr(nr);
        setPopulationDensity(populationDensity);
        setProvince(province);
        setShape(shape);
        setShapeArea(shapeArea);
        setShapeLength(shapeLength);
        applicationDataset.addShaped(this);
    }

    public Shaped(Shaped other){
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
            other.yMin,
            other.cluster,
            other.county,
            other.nr,
            other.populationDensity,
            other.province,
            other.shape,
            other.shapeArea,
            other.shapeLength);
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
        return getApplicationDataset().removeShaped(this) && getApplicationDataset().removeArea(this) && getApplicationDataset().removeMapLocation(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute cluster
 *
 * @return Integer
*/

    public Integer getCluster(){
        return this.cluster;
    }

/**
 *  get attribute county
 *
 * @return County
*/

    public County getCounty(){
        return this.county;
    }

/**
 *  get attribute nr
 *
 * @return Integer
*/

    public Integer getNr(){
        return this.nr;
    }

/**
 *  get attribute populationDensity
 *
 * @return Double
*/

    public Double getPopulationDensity(){
        return this.populationDensity;
    }

/**
 *  get attribute province
 *
 * @return Province
*/

    public Province getProvince(){
        return this.province;
    }

/**
 *  get attribute shape
 *
 * @return String
*/

    public String getShape(){
        return this.shape;
    }

/**
 *  get attribute shapeArea
 *
 * @return Double
*/

    public Double getShapeArea(){
        return this.shapeArea;
    }

/**
 *  get attribute shapeLength
 *
 * @return Double
*/

    public Double getShapeLength(){
        return this.shapeLength;
    }

/**
 *  set attribute cluster, mark dataset as dirty, mark dataset as not valid
@param cluster Integer
 *
*/

    public void setCluster(Integer cluster){
        this.cluster = cluster;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute county, mark dataset as dirty, mark dataset as not valid
@param county County
 *
*/

    public void setCounty(County county){
        this.county = county;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute nr, mark dataset as dirty, mark dataset as not valid
@param nr Integer
 *
*/

    public void setNr(Integer nr){
        this.nr = nr;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute populationDensity, mark dataset as dirty, mark dataset as not valid
@param populationDensity Double
 *
*/

    public void setPopulationDensity(Double populationDensity){
        this.populationDensity = populationDensity;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute province, mark dataset as dirty, mark dataset as not valid
@param province Province
 *
*/

    public void setProvince(Province province){
        this.province = province;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute shape, mark dataset as dirty, mark dataset as not valid
@param shape String
 *
*/

    public void setShape(String shape){
        this.shape = shape;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute shapeArea, mark dataset as dirty, mark dataset as not valid
@param shapeArea Double
 *
*/

    public void setShapeArea(Double shapeArea){
        this.shapeArea = shapeArea;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute shapeLength, mark dataset as dirty, mark dataset as not valid
@param shapeLength Double
 *
*/

    public void setShapeLength(Double shapeLength){
        this.shapeLength = shapeLength;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute cluster, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incCluster(){
        this.cluster++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute nr, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incNr(){
        this.nr++;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getIdent()+ " " +getLatitude()+ " " +getLongitude()+ " " +getShortName()+ " " +getTotalArea()+ " " +getTotalPopulation()+ " " +getXMax()+ " " +getXMin()+ " " +getYMax()+ " " +getYMin()+ " " +getCluster()+ " " +getCounty().toColumnString()+ " " +getNr()+ " " +getPopulationDensity()+ " " +getProvince().toColumnString()+ " " +getShape()+ " " +getShapeArea()+ " " +getShapeLength();
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
         out.println("<shaped "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
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
            " yMin=\""+toXMLYMin()+"\""+
            " cluster=\""+toXMLCluster()+"\""+
            " county=\""+toXMLCounty()+"\""+
            " nr=\""+toXMLNr()+"\""+
            " populationDensity=\""+toXMLPopulationDensity()+"\""+
            " province=\""+toXMLProvince()+"\""+
            " shape=\""+toXMLShape()+"\""+
            " shapeArea=\""+toXMLShapeArea()+"\""+
            " shapeLength=\""+toXMLShapeLength()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCluster(){
        return this.getCluster().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCounty(){
        return "ID_"+this.getCounty().getId().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLNr(){
        return this.getNr().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLPopulationDensity(){
        return this.getPopulationDensity().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLProvince(){
        return "ID_"+this.getProvince().getId().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLShape(){
        return this.safeXML(getShape());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLShapeArea(){
        return this.getShapeArea().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLShapeLength(){
        return this.getShapeLength().toString();
    }

/**
 * find the same object in another dataset
 * @param a Shaped item we are looking for
 * @param bList List<Shaped> list of items in which we are searching
 * @return Shaped entry of list b which is applicationSame() to a
*/

    public static Shaped find(Shaped a, List<Shaped> bList){
        for(Shaped b : bList){
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
 * @param name Shaped name of the object we are looking for
 * @return Shaped entry of the dataset with the given name; otherwise null
*/

    public static Shaped findByName(ApplicationDataset base, String name){
        for(Shaped a:base.getListShaped()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        return null;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Shaped first entry in the dataset of this type; null if that does not exists
*/

    public static Shaped findFirst(ApplicationDataset base){
        if (base.getListShaped().isEmpty()) {
            return null;
        }
        return base.getListShaped().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Shaped some entry in the dataset of this type; null if that does not exists
*/

    public static Shaped findAny(ApplicationDataset base){
        int size=base.getListShaped().size();
        if (size > 0) {
             return base.getListShaped().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Shaped last entry in the dataset of this type; null if that does not exists
*/

    public static Shaped findLast(ApplicationDataset base){
        int size=base.getListShaped().size();
        if (size > 0) {
             return base.getListShaped().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b Shaped compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(Shaped b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b Shaped compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(Shaped b){
      if(!this.getCluster().equals(b.getCluster())){
         System.out.println("Cluster");
        }
      if(!this.getCounty().applicationSame(b.getCounty())){
         System.out.println("County");
        }
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
      if(!this.getNr().equals(b.getNr())){
         System.out.println("Nr");
        }
      if(!this.getPopulationDensity().equals(b.getPopulationDensity())){
         System.out.println("PopulationDensity");
        }
      if(!this.getProvince().applicationSame(b.getProvince())){
         System.out.println("Province");
        }
      if(!this.getShape().equals(b.getShape())){
         System.out.println("Shape");
        }
      if(!this.getShapeArea().equals(b.getShapeArea())){
         System.out.println("ShapeArea");
        }
      if(!this.getShapeLength().equals(b.getShapeLength())){
         System.out.println("ShapeLength");
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
        return  this.getCluster().equals(b.getCluster()) &&
          this.getCounty().applicationSame(b.getCounty()) &&
          this.getIdent().equals(b.getIdent()) &&
          this.getLatitude().equals(b.getLatitude()) &&
          this.getLongitude().equals(b.getLongitude()) &&
          this.getName().equals(b.getName()) &&
          this.getNr().equals(b.getNr()) &&
          this.getPopulationDensity().equals(b.getPopulationDensity()) &&
          this.getProvince().applicationSame(b.getProvince()) &&
          this.getShape().equals(b.getShape()) &&
          this.getShapeArea().equals(b.getShapeArea()) &&
          this.getShapeLength().equals(b.getShapeLength()) &&
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
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","Shaped",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getCounty() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"county","Shaped",(getCounty()==null?"null":getCounty().toString()),"",WarningType.NOTNULL);
        }
        if (getProvince() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"province","Shaped",(getProvince()==null?"null":getProvince().toString()),"",WarningType.NOTNULL);
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
      if (attrName.equals("county")){
         return (List) ((Scenario)base).getListCounty();
      }
      if (attrName.equals("province")){
         return (List) ((Scenario)base).getListProvince();
      }
      return null;
   }

}
