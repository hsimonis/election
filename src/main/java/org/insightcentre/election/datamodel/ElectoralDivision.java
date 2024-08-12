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
 * 
 * @author generated
*/

public  class ElectoralDivision extends Shaped{
/**
 *  
 *
*/

    public County county;

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
 *  
 *
*/

    public Lea lea;

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
        setCounty(null);
        setEdId(0);
        setEdIdString("");
        setLea(null);
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
            Double centroidX,
            Double centroidY,
            String ident,
            String shortName,
            Integer totalPopulation,
            Double xMax,
            Double xMin,
            Double yMax,
            Double yMin,
            Integer nr,
            String shape,
            County county,
            Integer edId,
            String edIdString,
            Lea lea){
        super(applicationDataset,
            id,
            name,
            centroidX,
            centroidY,
            ident,
            shortName,
            totalPopulation,
            xMax,
            xMin,
            yMax,
            yMin,
            nr,
            shape);
        setCounty(county);
        setEdId(edId);
        setEdIdString(edIdString);
        setLea(lea);
        applicationDataset.addElectoralDivision(this);
    }

    public ElectoralDivision(ElectoralDivision other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.centroidX,
            other.centroidY,
            other.ident,
            other.shortName,
            other.totalPopulation,
            other.xMax,
            other.xMin,
            other.yMax,
            other.yMin,
            other.nr,
            other.shape,
            other.county,
            other.edId,
            other.edIdString,
            other.lea);
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
 *  get attribute county
 *
 * @return County
*/

    public County getCounty(){
        return this.county;
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
 *  get attribute lea
 *
 * @return Lea
*/

    public Lea getLea(){
        return this.lea;
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
 *  set attribute lea, mark dataset as dirty, mark dataset as not valid
@param lea Lea
 *
*/

    public void setLea(Lea lea){
        this.lea = lea;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getCentroidX()+ " " +getCentroidY()+ " " +getIdent()+ " " +getShortName()+ " " +getTotalPopulation()+ " " +getXMax()+ " " +getXMin()+ " " +getYMax()+ " " +getYMin()+ " " +getNr()+ " " +getShape()+ " " +getCounty().toColumnString()+ " " +getEdId()+ " " +getEdIdString()+ " " +getLea().toColumnString();
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
            " centroidX=\""+toXMLCentroidX()+"\""+
            " centroidY=\""+toXMLCentroidY()+"\""+
            " ident=\""+toXMLIdent()+"\""+
            " shortName=\""+toXMLShortName()+"\""+
            " totalPopulation=\""+toXMLTotalPopulation()+"\""+
            " xMax=\""+toXMLXMax()+"\""+
            " xMin=\""+toXMLXMin()+"\""+
            " yMax=\""+toXMLYMax()+"\""+
            " yMin=\""+toXMLYMin()+"\""+
            " nr=\""+toXMLNr()+"\""+
            " shape=\""+toXMLShape()+"\""+
            " county=\""+toXMLCounty()+"\""+
            " edId=\""+toXMLEdId()+"\""+
            " edIdString=\""+toXMLEdIdString()+"\""+
            " lea=\""+toXMLLea()+"\""+" />");
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
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLLea(){
        return "ID_"+this.getLea().getId().toString();
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>ElectoralDivision</th>"+"<th>Name</th>"+"<th>ShortName</th>"+"<th>Ident</th>"+"<th>CentroidX</th>"+"<th>CentroidY</th>"+"<th>XMin</th>"+"<th>XMax</th>"+"<th>YMin</th>"+"<th>YMax</th>"+"<th>TotalPopulation</th>"+"<th>Nr</th>"+"<th>Shape</th>"+"<th>EdId</th>"+"<th>EdIdString</th>"+"<th>County</th>"+"<th>Lea</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getShortName()+"</td>"+ " " +"<td>"+getIdent()+"</td>"+ " " +"<td>"+getCentroidX()+"</td>"+ " " +"<td>"+getCentroidY()+"</td>"+ " " +"<td>"+getXMin()+"</td>"+ " " +"<td>"+getXMax()+"</td>"+ " " +"<td>"+getYMin()+"</td>"+ " " +"<td>"+getYMax()+"</td>"+ " " +"<td>"+getTotalPopulation()+"</td>"+ " " +"<td>"+getNr()+"</td>"+ " " +"<td>"+getShape()+"</td>"+ " " +"<td>"+getEdId()+"</td>"+ " " +"<td>"+getEdIdString()+"</td>"+ " " +"<td>"+getCounty().toColumnString()+"</td>"+ " " +"<td>"+getLea().toColumnString()+"</td>"+"</tr>";
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
      if(!this.getCentroidX().equals(b.getCentroidX())){
         System.out.println("CentroidX");
        }
      if(!this.getCentroidY().equals(b.getCentroidY())){
         System.out.println("CentroidY");
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
      if(!this.getLea().applicationSame(b.getLea())){
         System.out.println("Lea");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getNr().equals(b.getNr())){
         System.out.println("Nr");
        }
      if(!this.getShape().equals(b.getShape())){
         System.out.println("Shape");
        }
      if(!this.getShortName().equals(b.getShortName())){
         System.out.println("ShortName");
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
        return  this.getCentroidX().equals(b.getCentroidX()) &&
          this.getCentroidY().equals(b.getCentroidY()) &&
          this.getCounty().applicationSame(b.getCounty()) &&
          this.getEdId().equals(b.getEdId()) &&
          this.getEdIdString().equals(b.getEdIdString()) &&
          this.getIdent().equals(b.getIdent()) &&
          this.getLea().applicationSame(b.getLea()) &&
          this.getName().equals(b.getName()) &&
          this.getNr().equals(b.getNr()) &&
          this.getShape().equals(b.getShape()) &&
          this.getShortName().equals(b.getShortName()) &&
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
        if (getLea() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"lea","ElectoralDivision",(getLea()==null?"null":getLea().toString()),"",WarningType.NOTNULL);
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
      if (attrName.equals("lea")){
         return (List) ((Scenario)base).getListLea();
      }
      return null;
   }

}
