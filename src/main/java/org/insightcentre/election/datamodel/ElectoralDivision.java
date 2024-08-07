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

public  class ElectoralDivision extends Shaped{
/**
 *  
 *
*/

    public Integer edId;

/**
 *  
 *
*/

    public String edIdString;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public ElectoralDivision(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public ElectoralDivision(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setEdId(0);
        setEdIdString("");
        applicationDataset.addElectoralDivision(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public ElectoralDivision(ApplicationDataset applicationDataset,
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
            Double shapeLength,
            Integer edId,
            String edIdString){
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
            yMin,
            cluster,
            county,
            nr,
            populationDensity,
            province,
            shape,
            shapeArea,
            shapeLength);
        setEdId(edId);
        setEdIdString(edIdString);
        applicationDataset.addElectoralDivision(this);
    }

    public ElectoralDivision(ElectoralDivision other){
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
            other.shapeLength,
            other.edId,
            other.edIdString);
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
        return getApplicationDataset().removeElectoralDivision(this) && getApplicationDataset().removeShaped(this) && getApplicationDataset().removeArea(this) && getApplicationDataset().removeMapLocation(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute edId
 *
 * @return Integer
*/

    public Integer getEdId(){
        return this.edId;
    }

/**
 *  get attribute edIdString
 *
 * @return String
*/

    public String getEdIdString(){
        return this.edIdString;
    }

/**
 *  set attribute edId, mark dataset as dirty, mark dataset as not valid
@param edId Integer
 *
*/

    public void setEdId(Integer edId){
        this.edId = edId;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute edIdString, mark dataset as dirty, mark dataset as not valid
@param edIdString String
 *
*/

    public void setEdIdString(String edIdString){
        this.edIdString = edIdString;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute edId, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incEdId(){
        this.edId++;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getIdent()+ " " +getLatitude()+ " " +getLongitude()+ " " +getShortName()+ " " +getTotalArea()+ " " +getTotalPopulation()+ " " +getXMax()+ " " +getXMin()+ " " +getYMax()+ " " +getYMin()+ " " +getCluster()+ " " +getCounty().toColumnString()+ " " +getNr()+ " " +getPopulationDensity()+ " " +getProvince().toColumnString()+ " " +getShape()+ " " +getShapeArea()+ " " +getShapeLength()+ " " +getEdId()+ " " +getEdIdString();
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
         out.println("<electoralDivision "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
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
            " shapeLength=\""+toXMLShapeLength()+"\""+
            " edId=\""+toXMLEdId()+"\""+
            " edIdString=\""+toXMLEdIdString()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLEdId(){
        return this.getEdId().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLEdIdString(){
        return this.safeXML(getEdIdString());
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>ElectoralDivision</th>"+"<th>Name</th>"+"<th>ShortName</th>"+"<th>Longitude</th>"+"<th>Latitude</th>"+"<th>Ident</th>"+"<th>XMin</th>"+"<th>XMax</th>"+"<th>YMin</th>"+"<th>YMax</th>"+"<th>TotalPopulation</th>"+"<th>TotalArea</th>"+"<th>Nr</th>"+"<th>ShapeLength</th>"+"<th>ShapeArea</th>"+"<th>PopulationDensity</th>"+"<th>Cluster</th>"+"<th>County</th>"+"<th>Province</th>"+"<th>Shape</th>"+"<th>EdId</th>"+"<th>EdIdString</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getShortName()+"</td>"+ " " +"<td>"+getLongitude()+"</td>"+ " " +"<td>"+getLatitude()+"</td>"+ " " +"<td>"+getIdent()+"</td>"+ " " +"<td>"+getXMin()+"</td>"+ " " +"<td>"+getXMax()+"</td>"+ " " +"<td>"+getYMin()+"</td>"+ " " +"<td>"+getYMax()+"</td>"+ " " +"<td>"+getTotalPopulation()+"</td>"+ " " +"<td>"+getTotalArea()+"</td>"+ " " +"<td>"+getNr()+"</td>"+ " " +"<td>"+getShapeLength()+"</td>"+ " " +"<td>"+getShapeArea()+"</td>"+ " " +"<td>"+getPopulationDensity()+"</td>"+ " " +"<td>"+getCluster()+"</td>"+ " " +"<td>"+getCounty().toColumnString()+"</td>"+ " " +"<td>"+getProvince().toColumnString()+"</td>"+ " " +"<td>"+getShape()+"</td>"+ " " +"<td>"+getEdId()+"</td>"+ " " +"<td>"+getEdIdString()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a ElectoralDivision item we are looking for
 * @param bList List<ElectoralDivision> list of items in which we are searching
 * @return ElectoralDivision entry of list b which is applicationSame() to a
*/

    public static ElectoralDivision find(ElectoralDivision a, List<ElectoralDivision> bList){
        for(ElectoralDivision b : bList){
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
 * @param name ElectoralDivision name of the object we are looking for
 * @return ElectoralDivision entry of the dataset with the given name; otherwise null
*/

    public static ElectoralDivision findByName(ApplicationDataset base, String name){
        for(ElectoralDivision a:base.getListElectoralDivision()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        return null;
    }

/**
 * find an object from its name; create new instance if no such item exists
 * it is not defined which object is returned if multiple have the same name
 * @param base  dataset in which we are searching
 * @param name ElectoralDivision name of the object we are looking for
 * @return ElectoralDivision entry of the dataset with the given name
*/

    public static ElectoralDivision findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(ElectoralDivision a:base.getListElectoralDivision()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        ElectoralDivision res = new ElectoralDivision(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return ElectoralDivision first entry in the dataset of this type; null if that does not exists
*/

    public static ElectoralDivision findFirst(ApplicationDataset base){
        if (base.getListElectoralDivision().isEmpty()) {
            return null;
        }
        return base.getListElectoralDivision().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return ElectoralDivision some entry in the dataset of this type; null if that does not exists
*/

    public static ElectoralDivision findAny(ApplicationDataset base){
        int size=base.getListElectoralDivision().size();
        if (size > 0) {
             return base.getListElectoralDivision().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return ElectoralDivision last entry in the dataset of this type; null if that does not exists
*/

    public static ElectoralDivision findLast(ApplicationDataset base){
        int size=base.getListElectoralDivision().size();
        if (size > 0) {
             return base.getListElectoralDivision().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b ElectoralDivision compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(ElectoralDivision b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b ElectoralDivision compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(ElectoralDivision b){
      if(!this.getCluster().equals(b.getCluster())){
         System.out.println("Cluster");
        }
      if(!this.getCounty().applicationSame(b.getCounty())){
         System.out.println("County");
        }
      if(!this.getEdId().equals(b.getEdId())){
         System.out.println("EdId");
        }
      if(!this.getEdIdString().equals(b.getEdIdString())){
         System.out.println("EdIdString");
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
          this.getEdId().equals(b.getEdId()) &&
          this.getEdIdString().equals(b.getEdIdString()) &&
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
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","ElectoralDivision",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getCounty() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"county","ElectoralDivision",(getCounty()==null?"null":getCounty().toString()),"",WarningType.NOTNULL);
        }
        if (getProvince() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"province","ElectoralDivision",(getProvince()==null?"null":getProvince().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class ElectoralDivision
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
