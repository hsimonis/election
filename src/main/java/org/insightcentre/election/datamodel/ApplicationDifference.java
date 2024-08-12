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
 * This is a utility class used to store differences between two datasets. Most applications will use this class for some predefined functionality.
 * @author generated
*/

public  class ApplicationDifference extends ApplicationObject{
/**
 *  The object which is different in the two datasets
 *
*/

    public String item;

/**
 *  Whether the item occurs in only one of the datasets, or occurs in both, but is different
 *
*/

    public DifferenceType type;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public ApplicationDifference(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public ApplicationDifference(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setItem("");
        setType(null);
        applicationDataset.addApplicationDifference(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public ApplicationDifference(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            String item,
            DifferenceType type){
        super(applicationDataset,
            id,
            name);
        setItem(item);
        setType(type);
        applicationDataset.addApplicationDifference(this);
    }

    public ApplicationDifference(ApplicationDifference other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.item,
            other.type);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        return getApplicationDataset().removeApplicationDifference(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute item
 *
 * @return String
*/

    public String getItem(){
        return this.item;
    }

/**
 *  get attribute type
 *
 * @return DifferenceType
*/

    public DifferenceType getType(){
        return this.type;
    }

/**
 *  set attribute item, mark dataset as dirty, mark dataset as not valid
@param item String
 *
*/

    public void setItem(String item){
        this.item = item;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute type, mark dataset as dirty, mark dataset as not valid
@param type DifferenceType
 *
*/

    public void setType(DifferenceType type){
        this.type = type;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getItem()+ " " +getType();
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
         out.println("<applicationDifference "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " item=\""+toXMLItem()+"\""+
            " type=\""+toXMLType()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLItem(){
        return this.safeXML(getItem());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLType(){
        return this.getType().toString();
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>ApplicationDifference</th>"+"<th>Name</th>"+"<th>Type</th>"+"<th>Item</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getType()+"</td>"+ " " +"<td>"+getItem()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a ApplicationDifference item we are looking for
 * @param bList List<ApplicationDifference> list of items in which we are searching
 * @return ApplicationDifference entry of list b which is applicationSame() to a
*/

    public static ApplicationDifference find(ApplicationDifference a, List<ApplicationDifference> bList){
        for(ApplicationDifference b : bList){
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
 * @param name ApplicationDifference name of the object we are looking for
 * @return ApplicationDifference entry of the dataset with the given name; otherwise null
*/

    public static ApplicationDifference findByName(ApplicationDataset base, String name){
        for(ApplicationDifference a:base.getListApplicationDifference()) {
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
 * @param name ApplicationDifference name of the object we are looking for
 * @return ApplicationDifference entry of the dataset with the given name
*/

    public static ApplicationDifference findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(ApplicationDifference a:base.getListApplicationDifference()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        ApplicationDifference res = new ApplicationDifference(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return ApplicationDifference first entry in the dataset of this type; null if that does not exists
*/

    public static ApplicationDifference findFirst(ApplicationDataset base){
        if (base.getListApplicationDifference().isEmpty()) {
            return null;
        }
        return base.getListApplicationDifference().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return ApplicationDifference some entry in the dataset of this type; null if that does not exists
*/

    public static ApplicationDifference findAny(ApplicationDataset base){
        int size=base.getListApplicationDifference().size();
        if (size > 0) {
             return base.getListApplicationDifference().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return ApplicationDifference last entry in the dataset of this type; null if that does not exists
*/

    public static ApplicationDifference findLast(ApplicationDataset base){
        int size=base.getListApplicationDifference().size();
        if (size > 0) {
             return base.getListApplicationDifference().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b ApplicationDifference compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(ApplicationDifference b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b ApplicationDifference compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(ApplicationDifference b){
      if(!this.getItem().equals(b.getItem())){
         System.out.println("Item");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getType().equals(b.getType())){
         System.out.println("Type");
        }
        return  this.getItem().equals(b.getItem()) &&
          this.getName().equals(b.getName()) &&
          this.getType().equals(b.getType());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","ApplicationDifference",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getName().length() == 0) {
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"name","ApplicationDifference",(getName()==null?"null":getName().toString()),"",WarningType.NOTEMPTY);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class ApplicationDifference
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
