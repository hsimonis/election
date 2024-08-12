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

public  class NeighborCounty extends ApplicationObject{
/**
 *  
 *
*/

    public County county1;

/**
 *  
 *
*/

    public County county2;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public NeighborCounty(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public NeighborCounty(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setCounty1(null);
        setCounty2(null);
        applicationDataset.addNeighborCounty(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public NeighborCounty(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            County county1,
            County county2){
        super(applicationDataset,
            id,
            name);
        setCounty1(county1);
        setCounty2(county2);
        applicationDataset.addNeighborCounty(this);
    }

    public NeighborCounty(NeighborCounty other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.county1,
            other.county2);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        return getApplicationDataset().removeNeighborCounty(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute county1
 *
 * @return County
*/

    public County getCounty1(){
        return this.county1;
    }

/**
 *  get attribute county2
 *
 * @return County
*/

    public County getCounty2(){
        return this.county2;
    }

/**
 *  set attribute county1, mark dataset as dirty, mark dataset as not valid
@param county1 County
 *
*/

    public void setCounty1(County county1){
        this.county1 = county1;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute county2, mark dataset as dirty, mark dataset as not valid
@param county2 County
 *
*/

    public void setCounty2(County county2){
        this.county2 = county2;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getCounty1().toColumnString()+ " " +getCounty2().toColumnString();
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
         out.println("<neighborCounty "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " county1=\""+toXMLCounty1()+"\""+
            " county2=\""+toXMLCounty2()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCounty1(){
        return "ID_"+this.getCounty1().getId().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCounty2(){
        return "ID_"+this.getCounty2().getId().toString();
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>NeighborCounty</th>"+"<th>Name</th>"+"<th>County1</th>"+"<th>County2</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getCounty1().toColumnString()+"</td>"+ " " +"<td>"+getCounty2().toColumnString()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a NeighborCounty item we are looking for
 * @param bList List<NeighborCounty> list of items in which we are searching
 * @return NeighborCounty entry of list b which is applicationSame() to a
*/

    public static NeighborCounty find(NeighborCounty a, List<NeighborCounty> bList){
        for(NeighborCounty b : bList){
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
 * @param name NeighborCounty name of the object we are looking for
 * @return NeighborCounty entry of the dataset with the given name; otherwise null
*/

    public static NeighborCounty findByName(ApplicationDataset base, String name){
        for(NeighborCounty a:base.getListNeighborCounty()) {
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
 * @param name NeighborCounty name of the object we are looking for
 * @return NeighborCounty entry of the dataset with the given name
*/

    public static NeighborCounty findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(NeighborCounty a:base.getListNeighborCounty()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        NeighborCounty res = new NeighborCounty(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return NeighborCounty first entry in the dataset of this type; null if that does not exists
*/

    public static NeighborCounty findFirst(ApplicationDataset base){
        if (base.getListNeighborCounty().isEmpty()) {
            return null;
        }
        return base.getListNeighborCounty().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return NeighborCounty some entry in the dataset of this type; null if that does not exists
*/

    public static NeighborCounty findAny(ApplicationDataset base){
        int size=base.getListNeighborCounty().size();
        if (size > 0) {
             return base.getListNeighborCounty().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return NeighborCounty last entry in the dataset of this type; null if that does not exists
*/

    public static NeighborCounty findLast(ApplicationDataset base){
        int size=base.getListNeighborCounty().size();
        if (size > 0) {
             return base.getListNeighborCounty().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b NeighborCounty compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(NeighborCounty b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b NeighborCounty compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(NeighborCounty b){
      if(!this.getCounty1().applicationSame(b.getCounty1())){
         System.out.println("County1");
        }
      if(!this.getCounty2().applicationSame(b.getCounty2())){
         System.out.println("County2");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
        return  this.getCounty1().applicationSame(b.getCounty1()) &&
          this.getCounty2().applicationSame(b.getCounty2()) &&
          this.getName().equals(b.getName());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","NeighborCounty",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getCounty1() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"county1","NeighborCounty",(getCounty1()==null?"null":getCounty1().toString()),"",WarningType.NOTNULL);
        }
        if (getCounty2() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"county2","NeighborCounty",(getCounty2()==null?"null":getCounty2().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class NeighborCounty
    }

/**
 *  This method states if the class depends on the solver.
 *
*/

    public static Boolean isSolverDependent(){
        return false;
    }

   public List<ApplicationObjectInterface> getFeasibleValues(ApplicationDatasetInterface base,String attrName){
      if (attrName.equals("county1")){
         return (List) ((Scenario)base).getListCounty();
      }
      if (attrName.equals("county2")){
         return (List) ((Scenario)base).getListCounty();
      }
      return null;
   }

}
