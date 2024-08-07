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
 * This is a utility class to store warnings created by the application. Most applications will use this class for some predefined functionality.
 * @author generated
*/

public  class ApplicationWarning extends ApplicationObject{
/**
 *  The attribute for which the warning was generated
 *
*/

    public String attrString;

/**
 *  The class of the item for which the warning was generated
 *
*/

    public String classString;

/**
 *  The value which was identified as a problem
 *
*/

    public String item;

/**
 *  The given limit for the attribute value, if set
 *
*/

    public String limit;

/**
 *  The type of the warning
 *
*/

    public WarningType type;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public ApplicationWarning(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public ApplicationWarning(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setAttrString("");
        setClassString("");
        setItem("");
        setLimit("");
        setType(null);
        applicationDataset.addApplicationWarning(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public ApplicationWarning(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            String attrString,
            String classString,
            String item,
            String limit,
            WarningType type){
        super(applicationDataset,
            id,
            name);
        setAttrString(attrString);
        setClassString(classString);
        setItem(item);
        setLimit(limit);
        setType(type);
        applicationDataset.addApplicationWarning(this);
    }

    public ApplicationWarning(ApplicationWarning other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.attrString,
            other.classString,
            other.item,
            other.limit,
            other.type);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        return getApplicationDataset().removeApplicationWarning(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute attrString
 *
 * @return String
*/

    public String getAttrString(){
        return this.attrString;
    }

/**
 *  get attribute classString
 *
 * @return String
*/

    public String getClassString(){
        return this.classString;
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
 *  get attribute limit
 *
 * @return String
*/

    public String getLimit(){
        return this.limit;
    }

/**
 *  get attribute type
 *
 * @return WarningType
*/

    public WarningType getType(){
        return this.type;
    }

/**
 *  set attribute attrString, mark dataset as dirty, mark dataset as not valid
@param attrString String
 *
*/

    public void setAttrString(String attrString){
        this.attrString = attrString;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute classString, mark dataset as dirty, mark dataset as not valid
@param classString String
 *
*/

    public void setClassString(String classString){
        this.classString = classString;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
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
 *  set attribute limit, mark dataset as dirty, mark dataset as not valid
@param limit String
 *
*/

    public void setLimit(String limit){
        this.limit = limit;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute type, mark dataset as dirty, mark dataset as not valid
@param type WarningType
 *
*/

    public void setType(WarningType type){
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
        return ""+ " " +getId()+ " " +getName()+ " " +getAttrString()+ " " +getClassString()+ " " +getItem()+ " " +getLimit()+ " " +getType();
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
         out.println("<applicationWarning "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " attrString=\""+toXMLAttrString()+"\""+
            " classString=\""+toXMLClassString()+"\""+
            " item=\""+toXMLItem()+"\""+
            " limit=\""+toXMLLimit()+"\""+
            " type=\""+toXMLType()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLAttrString(){
        return this.safeXML(getAttrString());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLClassString(){
        return this.safeXML(getClassString());
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

    String toXMLLimit(){
        return this.safeXML(getLimit());
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
        return "<tr><th>ApplicationWarning</th>"+"<th>Class</th>"+"<th>Name</th>"+"<th>Attribute</th>"+"<th>Value</th>"+"<th>Type</th>"+"<th>Limit</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getClassString()+"</td>"+ " " +"<td>"+getName()+"</td>"+ " " +"<td>"+getAttrString()+"</td>"+ " " +"<td>"+getItem()+"</td>"+ " " +"<td>"+getType()+"</td>"+ " " +"<td>"+getLimit()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a ApplicationWarning item we are looking for
 * @param bList List<ApplicationWarning> list of items in which we are searching
 * @return ApplicationWarning entry of list b which is applicationSame() to a
*/

    public static ApplicationWarning find(ApplicationWarning a, List<ApplicationWarning> bList){
        for(ApplicationWarning b : bList){
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
 * @param name ApplicationWarning name of the object we are looking for
 * @return ApplicationWarning entry of the dataset with the given name; otherwise null
*/

    public static ApplicationWarning findByName(ApplicationDataset base, String name){
        for(ApplicationWarning a:base.getListApplicationWarning()) {
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
 * @param name ApplicationWarning name of the object we are looking for
 * @return ApplicationWarning entry of the dataset with the given name
*/

    public static ApplicationWarning findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(ApplicationWarning a:base.getListApplicationWarning()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        ApplicationWarning res = new ApplicationWarning(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return ApplicationWarning first entry in the dataset of this type; null if that does not exists
*/

    public static ApplicationWarning findFirst(ApplicationDataset base){
        if (base.getListApplicationWarning().isEmpty()) {
            return null;
        }
        return base.getListApplicationWarning().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return ApplicationWarning some entry in the dataset of this type; null if that does not exists
*/

    public static ApplicationWarning findAny(ApplicationDataset base){
        int size=base.getListApplicationWarning().size();
        if (size > 0) {
             return base.getListApplicationWarning().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return ApplicationWarning last entry in the dataset of this type; null if that does not exists
*/

    public static ApplicationWarning findLast(ApplicationDataset base){
        int size=base.getListApplicationWarning().size();
        if (size > 0) {
             return base.getListApplicationWarning().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b ApplicationWarning compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(ApplicationWarning b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b ApplicationWarning compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(ApplicationWarning b){
      if(!this.getAttrString().equals(b.getAttrString())){
         System.out.println("AttrString");
        }
      if(!this.getClassString().equals(b.getClassString())){
         System.out.println("ClassString");
        }
      if(!this.getItem().equals(b.getItem())){
         System.out.println("Item");
        }
      if(!this.getLimit().equals(b.getLimit())){
         System.out.println("Limit");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getType().equals(b.getType())){
         System.out.println("Type");
        }
        return  this.getAttrString().equals(b.getAttrString()) &&
          this.getClassString().equals(b.getClassString()) &&
          this.getItem().equals(b.getItem()) &&
          this.getLimit().equals(b.getLimit()) &&
          this.getName().equals(b.getName()) &&
          this.getType().equals(b.getType());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","ApplicationWarning",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class ApplicationWarning
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
