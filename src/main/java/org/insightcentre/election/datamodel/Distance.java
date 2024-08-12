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

public  class Distance extends ApplicationObject{
/**
 *  
 *
*/

    public MapLocation from;

/**
 *  
 *
*/

    public Double max;

/**
 *  
 *
*/

    public Double min;

/**
 *  
 *
*/

    public MapLocation to;

/**
 *  
 *
*/

    public Double value;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public Distance(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public Distance(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setFrom(null);
        setMax(0.0);
        setMin(0.0);
        setTo(null);
        setValue(0.0);
        applicationDataset.addDistance(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public Distance(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            MapLocation from,
            Double max,
            Double min,
            MapLocation to,
            Double value){
        super(applicationDataset,
            id,
            name);
        setFrom(from);
        setMax(max);
        setMin(min);
        setTo(to);
        setValue(value);
        applicationDataset.addDistance(this);
    }

    public Distance(Distance other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.from,
            other.max,
            other.min,
            other.to,
            other.value);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        return getApplicationDataset().removeDistance(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute from
 *
 * @return MapLocation
*/

    public MapLocation getFrom(){
        return this.from;
    }

/**
 *  get attribute max
 *
 * @return Double
*/

    public Double getMax(){
        return this.max;
    }

/**
 *  get attribute min
 *
 * @return Double
*/

    public Double getMin(){
        return this.min;
    }

/**
 *  get attribute to
 *
 * @return MapLocation
*/

    public MapLocation getTo(){
        return this.to;
    }

/**
 *  get attribute value
 *
 * @return Double
*/

    public Double getValue(){
        return this.value;
    }

/**
 *  set attribute from, mark dataset as dirty, mark dataset as not valid
@param from MapLocation
 *
*/

    public void setFrom(MapLocation from){
        this.from = from;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute max, mark dataset as dirty, mark dataset as not valid
@param max Double
 *
*/

    public void setMax(Double max){
        this.max = max;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute min, mark dataset as dirty, mark dataset as not valid
@param min Double
 *
*/

    public void setMin(Double min){
        this.min = min;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute to, mark dataset as dirty, mark dataset as not valid
@param to MapLocation
 *
*/

    public void setTo(MapLocation to){
        this.to = to;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute value, mark dataset as dirty, mark dataset as not valid
@param value Double
 *
*/

    public void setValue(Double value){
        this.value = value;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getFrom().toColumnString()+ " " +getMax()+ " " +getMin()+ " " +getTo().toColumnString()+ " " +getValue();
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
         out.println("<distance "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " from=\""+toXMLFrom()+"\""+
            " max=\""+toXMLMax()+"\""+
            " min=\""+toXMLMin()+"\""+
            " to=\""+toXMLTo()+"\""+
            " value=\""+toXMLValue()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLFrom(){
        return "ID_"+this.getFrom().getId().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLMax(){
        return this.getMax().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLMin(){
        return this.getMin().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLTo(){
        return "ID_"+this.getTo().getId().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLValue(){
        return this.getValue().toString();
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>Distance</th>"+"<th>Name</th>"+"<th>From</th>"+"<th>To</th>"+"<th>Value</th>"+"<th>Min</th>"+"<th>Max</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getFrom().toColumnString()+"</td>"+ " " +"<td>"+getTo().toColumnString()+"</td>"+ " " +"<td>"+getValue()+"</td>"+ " " +"<td>"+getMin()+"</td>"+ " " +"<td>"+getMax()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a Distance item we are looking for
 * @param bList List<Distance> list of items in which we are searching
 * @return Distance entry of list b which is applicationSame() to a
*/

    public static Distance find(Distance a, List<Distance> bList){
        for(Distance b : bList){
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
 * @param name Distance name of the object we are looking for
 * @return Distance entry of the dataset with the given name; otherwise null
*/

    public static Distance findByName(ApplicationDataset base, String name){
        for(Distance a:base.getListDistance()) {
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
 * @param name Distance name of the object we are looking for
 * @return Distance entry of the dataset with the given name
*/

    public static Distance findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(Distance a:base.getListDistance()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        Distance res = new Distance(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Distance first entry in the dataset of this type; null if that does not exists
*/

    public static Distance findFirst(ApplicationDataset base){
        if (base.getListDistance().isEmpty()) {
            return null;
        }
        return base.getListDistance().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Distance some entry in the dataset of this type; null if that does not exists
*/

    public static Distance findAny(ApplicationDataset base){
        int size=base.getListDistance().size();
        if (size > 0) {
             return base.getListDistance().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Distance last entry in the dataset of this type; null if that does not exists
*/

    public static Distance findLast(ApplicationDataset base){
        int size=base.getListDistance().size();
        if (size > 0) {
             return base.getListDistance().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b Distance compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(Distance b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b Distance compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(Distance b){
      if(!this.getFrom().applicationSame(b.getFrom())){
         System.out.println("From");
        }
      if(!this.getMax().equals(b.getMax())){
         System.out.println("Max");
        }
      if(!this.getMin().equals(b.getMin())){
         System.out.println("Min");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getTo().applicationSame(b.getTo())){
         System.out.println("To");
        }
      if(!this.getValue().equals(b.getValue())){
         System.out.println("Value");
        }
        return  this.getFrom().applicationSame(b.getFrom()) &&
          this.getMax().equals(b.getMax()) &&
          this.getMin().equals(b.getMin()) &&
          this.getName().equals(b.getName()) &&
          this.getTo().applicationSame(b.getTo()) &&
          this.getValue().equals(b.getValue());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","Distance",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getFrom() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"from","Distance",(getFrom()==null?"null":getFrom().toString()),"",WarningType.NOTNULL);
        }
        if (getTo() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"to","Distance",(getTo()==null?"null":getTo().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class Distance
    }

/**
 *  This method states if the class depends on the solver.
 *
*/

    public static Boolean isSolverDependent(){
        return false;
    }

   public List<ApplicationObjectInterface> getFeasibleValues(ApplicationDatasetInterface base,String attrName){
      if (attrName.equals("from")){
         return (List) ((Scenario)base).getListMapLocation();
      }
      if (attrName.equals("to")){
         return (List) ((Scenario)base).getListMapLocation();
      }
      return null;
   }

}
