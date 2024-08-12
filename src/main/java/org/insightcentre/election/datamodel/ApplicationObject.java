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
 * This is an abstract base class for all application objects. Each application should derive its classes from this class. This class can have many subclasses. Note that the ApplicationDataset is not an ApplicationObject.
 * @author generated
*/

public abstract class ApplicationObject implements ApplicationObjectInterface, Comparable<ApplicationObject>{
/**
 *  Dataset to which the item belongs. Maintained by the system.
 *
*/

    public ApplicationDataset applicationDataset;

/**
 *  An internal id number for all objects. This is unique over all object classes.
 *
*/

    public Integer id;

/**
 *  Name of the item. This does not have to be unique
 *
*/

    public String name;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public ApplicationObject(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public ApplicationObject(ApplicationDataset applicationDataset){
        setApplicationDataset(applicationDataset);
        setId(ApplicationDataset.getIdNr());
        setName("");
        applicationDataset.addApplicationObject(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public ApplicationObject(ApplicationDataset applicationDataset,
            Integer id,
            String name){
        setApplicationDataset(applicationDataset);
        setId(id);
        setName(name);
        applicationDataset.addApplicationObject(this);
    }

    public ApplicationObject(ApplicationObject other){
        this(other.applicationDataset,
            other.id,
            other.name);
    }

    public int compareTo(ApplicationObject that){
        return this.getName().compareTo(that.getName());
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        return getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute applicationDataset
 *
 * @return ApplicationDataset
*/

    public ApplicationDataset getApplicationDataset(){
        return this.applicationDataset;
    }

/**
 *  get attribute id
 *
 * @return Integer
*/

    public Integer getId(){
        return this.id;
    }

/**
 *  get attribute name
 *
 * @return String
*/

    public String getName(){
        return this.name;
    }

/**
 *  set attribute applicationDataset, mark dataset as dirty, mark dataset as not valid
@param applicationDataset ApplicationDataset
 *
*/

    public void setApplicationDataset(ApplicationDataset applicationDataset){
        this.applicationDataset = applicationDataset;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute id, mark dataset as dirty, mark dataset as not valid
@param id Integer
 *
*/

    public void setId(Integer id){
        this.id = id;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute name, mark dataset as dirty, mark dataset as not valid
@param name String
 *
*/

    public void setName(String name){
        this.name = name;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute id, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incId(){
        this.id++;
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
        return ""+ " " +getId()+ " " +getName();
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

    public String safeXML(String s){
        String res=s;
        res = res.replaceAll("&","&amp;");
        res = res.replaceAll("<","&lt;");
        res = res.replaceAll(">","&gt;");
        res = res.replaceAll("\"","&quot;");
        res = res.replaceAll("'","&apos;");
        return res;
    }

/**
 * show object as one element in XML format
 * side effect of writing to file
 * @param out PrintWriter
*/

     public void toXML(PrintWriter out){
         out.println("<applicationObject "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLApplicationDataset(){
        return "ID_"+this.getApplicationDataset().getId().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLId(){
        return "ID_"+this.getId();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLName(){
        return this.safeXML(getName());
    }

/**
 * find the same object in another dataset
 * @param a ApplicationObject item we are looking for
 * @param bList List<ApplicationObject> list of items in which we are searching
 * @return ApplicationObject entry of list b which is applicationSame() to a
*/

    public static ApplicationObject find(ApplicationObject a, List<ApplicationObject> bList){
        for(ApplicationObject b : bList){
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
 * @param name ApplicationObject name of the object we are looking for
 * @return ApplicationObject entry of the dataset with the given name; otherwise null
*/

    public static ApplicationObject findByName(ApplicationDataset base, String name){
        for(ApplicationObject a:base.getListApplicationObject()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        return null;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return ApplicationObject first entry in the dataset of this type; null if that does not exists
*/

    public static ApplicationObject findFirst(ApplicationDataset base){
        if (base.getListApplicationObject().isEmpty()) {
            return null;
        }
        return base.getListApplicationObject().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return ApplicationObject some entry in the dataset of this type; null if that does not exists
*/

    public static ApplicationObject findAny(ApplicationDataset base){
        int size=base.getListApplicationObject().size();
        if (size > 0) {
             return base.getListApplicationObject().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return ApplicationObject last entry in the dataset of this type; null if that does not exists
*/

    public static ApplicationObject findLast(ApplicationDataset base){
        int size=base.getListApplicationObject().size();
        if (size > 0) {
             return base.getListApplicationObject().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b ApplicationObject compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(ApplicationObject b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b ApplicationObject compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(ApplicationObject b){
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
        return  this.getName().equals(b.getName());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","ApplicationObject",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
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
