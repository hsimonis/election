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

public  class ConstituencyType extends ApplicationObject{
/**
 *  
 *
*/

    public Integer gammaCostFactor;

/**
 *  
 *
*/

    public Integer nrSeats;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public ConstituencyType(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public ConstituencyType(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setGammaCostFactor(0);
        setNrSeats(0);
        applicationDataset.addConstituencyType(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public ConstituencyType(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            Integer gammaCostFactor,
            Integer nrSeats){
        super(applicationDataset,
            id,
            name);
        setGammaCostFactor(gammaCostFactor);
        setNrSeats(nrSeats);
        applicationDataset.addConstituencyType(this);
    }

    public ConstituencyType(ConstituencyType other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.gammaCostFactor,
            other.nrSeats);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        getApplicationDataset().cascadeSolConstTypeConstituencyType(this);
        return getApplicationDataset().removeConstituencyType(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute gammaCostFactor
 *
 * @return Integer
*/

    public Integer getGammaCostFactor(){
        return this.gammaCostFactor;
    }

/**
 *  get attribute nrSeats
 *
 * @return Integer
*/

    public Integer getNrSeats(){
        return this.nrSeats;
    }

/**
 *  set attribute gammaCostFactor, mark dataset as dirty, mark dataset as not valid
@param gammaCostFactor Integer
 *
*/

    public void setGammaCostFactor(Integer gammaCostFactor){
        this.gammaCostFactor = gammaCostFactor;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute nrSeats, mark dataset as dirty, mark dataset as not valid
@param nrSeats Integer
 *
*/

    public void setNrSeats(Integer nrSeats){
        this.nrSeats = nrSeats;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute gammaCostFactor, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incGammaCostFactor(){
        this.gammaCostFactor++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute nrSeats, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incNrSeats(){
        this.nrSeats++;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getGammaCostFactor()+ " " +getNrSeats();
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
         out.println("<constituencyType "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " gammaCostFactor=\""+toXMLGammaCostFactor()+"\""+
            " nrSeats=\""+toXMLNrSeats()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLGammaCostFactor(){
        return this.getGammaCostFactor().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLNrSeats(){
        return this.getNrSeats().toString();
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>ConstituencyType</th>"+"<th>Name</th>"+"<th>NrSeats</th>"+"<th>GammaCostFactor</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getNrSeats()+"</td>"+ " " +"<td>"+getGammaCostFactor()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a ConstituencyType item we are looking for
 * @param bList List<ConstituencyType> list of items in which we are searching
 * @return ConstituencyType entry of list b which is applicationSame() to a
*/

    public static ConstituencyType find(ConstituencyType a, List<ConstituencyType> bList){
        for(ConstituencyType b : bList){
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
 * @param name ConstituencyType name of the object we are looking for
 * @return ConstituencyType entry of the dataset with the given name; otherwise null
*/

    public static ConstituencyType findByName(ApplicationDataset base, String name){
        for(ConstituencyType a:base.getListConstituencyType()) {
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
 * @param name ConstituencyType name of the object we are looking for
 * @return ConstituencyType entry of the dataset with the given name
*/

    public static ConstituencyType findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(ConstituencyType a:base.getListConstituencyType()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        ConstituencyType res = new ConstituencyType(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return ConstituencyType first entry in the dataset of this type; null if that does not exists
*/

    public static ConstituencyType findFirst(ApplicationDataset base){
        if (base.getListConstituencyType().isEmpty()) {
            return null;
        }
        return base.getListConstituencyType().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return ConstituencyType some entry in the dataset of this type; null if that does not exists
*/

    public static ConstituencyType findAny(ApplicationDataset base){
        int size=base.getListConstituencyType().size();
        if (size > 0) {
             return base.getListConstituencyType().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return ConstituencyType last entry in the dataset of this type; null if that does not exists
*/

    public static ConstituencyType findLast(ApplicationDataset base){
        int size=base.getListConstituencyType().size();
        if (size > 0) {
             return base.getListConstituencyType().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b ConstituencyType compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(ConstituencyType b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b ConstituencyType compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(ConstituencyType b){
      if(!this.getGammaCostFactor().equals(b.getGammaCostFactor())){
         System.out.println("GammaCostFactor");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getNrSeats().equals(b.getNrSeats())){
         System.out.println("NrSeats");
        }
        return  this.getGammaCostFactor().equals(b.getGammaCostFactor()) &&
          this.getName().equals(b.getName()) &&
          this.getNrSeats().equals(b.getNrSeats());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","ConstituencyType",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class ConstituencyType
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
