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

public  class DistanceError extends ApplicationObject{
/**
 *  
 *
*/

    public MapLocation from;

/**
 *  
 *
*/

    public MapLocation to;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public DistanceError(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public DistanceError(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setFrom(null);
        setTo(null);
        applicationDataset.addDistanceError(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public DistanceError(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            MapLocation from,
            MapLocation to){
        super(applicationDataset,
            id,
            name);
        setFrom(from);
        setTo(to);
        applicationDataset.addDistanceError(this);
    }

    public DistanceError(DistanceError other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.from,
            other.to);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        return getApplicationDataset().removeDistanceError(this) && getApplicationDataset().removeApplicationObject(this);
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
 *  get attribute to
 *
 * @return MapLocation
*/

    public MapLocation getTo(){
        return this.to;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getFrom().toColumnString()+ " " +getTo().toColumnString();
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
         out.println("<distanceError "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " from=\""+toXMLFrom()+"\""+
            " to=\""+toXMLTo()+"\""+" />");
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

    String toXMLTo(){
        return "ID_"+this.getTo().getId().toString();
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>DistanceError</th>"+"<th>Name</th>"+"<th>From</th>"+"<th>To</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getFrom().toColumnString()+"</td>"+ " " +"<td>"+getTo().toColumnString()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a DistanceError item we are looking for
 * @param bList List<DistanceError> list of items in which we are searching
 * @return DistanceError entry of list b which is applicationSame() to a
*/

    public static DistanceError find(DistanceError a, List<DistanceError> bList){
        for(DistanceError b : bList){
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
 * @param name DistanceError name of the object we are looking for
 * @return DistanceError entry of the dataset with the given name; otherwise null
*/

    public static DistanceError findByName(ApplicationDataset base, String name){
        for(DistanceError a:base.getListDistanceError()) {
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
 * @param name DistanceError name of the object we are looking for
 * @return DistanceError entry of the dataset with the given name
*/

    public static DistanceError findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(DistanceError a:base.getListDistanceError()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        DistanceError res = new DistanceError(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return DistanceError first entry in the dataset of this type; null if that does not exists
*/

    public static DistanceError findFirst(ApplicationDataset base){
        if (base.getListDistanceError().isEmpty()) {
            return null;
        }
        return base.getListDistanceError().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return DistanceError some entry in the dataset of this type; null if that does not exists
*/

    public static DistanceError findAny(ApplicationDataset base){
        int size=base.getListDistanceError().size();
        if (size > 0) {
             return base.getListDistanceError().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return DistanceError last entry in the dataset of this type; null if that does not exists
*/

    public static DistanceError findLast(ApplicationDataset base){
        int size=base.getListDistanceError().size();
        if (size > 0) {
             return base.getListDistanceError().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b DistanceError compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(DistanceError b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b DistanceError compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(DistanceError b){
      if(!this.getFrom().applicationSame(b.getFrom())){
         System.out.println("From");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getTo().applicationSame(b.getTo())){
         System.out.println("To");
        }
        return  this.getFrom().applicationSame(b.getFrom()) &&
          this.getName().equals(b.getName()) &&
          this.getTo().applicationSame(b.getTo());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","DistanceError",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getFrom() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"from","DistanceError",(getFrom()==null?"null":getFrom().toString()),"",WarningType.NOTNULL);
        }
        if (getTo() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"to","DistanceError",(getTo()==null?"null":getTo().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class DistanceError
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
