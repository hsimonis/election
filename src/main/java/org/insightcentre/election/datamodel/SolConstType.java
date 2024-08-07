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

public  class SolConstType extends ApplicationObject{
/**
 *  
 *
*/

    public ConstituencyType constituencyType;

/**
 *  
 *
*/

    public Double percent;

/**
 *  
 *
*/

    public Solution solution;

/**
 *  
 *
*/

    public Integer value;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public SolConstType(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public SolConstType(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setConstituencyType(null);
        setPercent(0.0);
        setSolution(null);
        setValue(0);
        applicationDataset.addSolConstType(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public SolConstType(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            ConstituencyType constituencyType,
            Double percent,
            Solution solution,
            Integer value){
        super(applicationDataset,
            id,
            name);
        setConstituencyType(constituencyType);
        setPercent(percent);
        setSolution(solution);
        setValue(value);
        applicationDataset.addSolConstType(this);
    }

    public SolConstType(SolConstType other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.constituencyType,
            other.percent,
            other.solution,
            other.value);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        return getApplicationDataset().removeSolConstType(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute constituencyType
 *
 * @return ConstituencyType
*/

    public ConstituencyType getConstituencyType(){
        return this.constituencyType;
    }

/**
 *  get attribute percent
 *
 * @return Double
*/

    public Double getPercent(){
        return this.percent;
    }

/**
 *  get attribute solution
 *
 * @return Solution
*/

    public Solution getSolution(){
        return this.solution;
    }

/**
 *  get attribute value
 *
 * @return Integer
*/

    public Integer getValue(){
        return this.value;
    }

/**
 *  set attribute constituencyType, mark dataset as dirty, mark dataset as not valid
@param constituencyType ConstituencyType
 *
*/

    public void setConstituencyType(ConstituencyType constituencyType){
        this.constituencyType = constituencyType;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute percent, mark dataset as dirty, mark dataset as not valid
@param percent Double
 *
*/

    public void setPercent(Double percent){
        this.percent = percent;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute solution, mark dataset as dirty, mark dataset as not valid
@param solution Solution
 *
*/

    public void setSolution(Solution solution){
        this.solution = solution;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute value, mark dataset as dirty, mark dataset as not valid
@param value Integer
 *
*/

    public void setValue(Integer value){
        this.value = value;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute value, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incValue(){
        this.value++;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getConstituencyType().toColumnString()+ " " +getPercent()+ " " +getSolution().toColumnString()+ " " +getValue();
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
         out.println("<solConstType "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " constituencyType=\""+toXMLConstituencyType()+"\""+
            " percent=\""+toXMLPercent()+"\""+
            " solution=\""+toXMLSolution()+"\""+
            " value=\""+toXMLValue()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLConstituencyType(){
        return "ID_"+this.getConstituencyType().getId().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLPercent(){
        return this.getPercent().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLSolution(){
        return "ID_"+this.getSolution().getId().toString();
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
        return "<tr><th>SolConstType</th>"+"<th>Name</th>"+"<th>Solution</th>"+"<th>ConstituencyType</th>"+"<th>Value</th>"+"<th>Percent</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getSolution().toColumnString()+"</td>"+ " " +"<td>"+getConstituencyType().toColumnString()+"</td>"+ " " +"<td>"+getValue()+"</td>"+ " " +"<td>"+getPercent()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a SolConstType item we are looking for
 * @param bList List<SolConstType> list of items in which we are searching
 * @return SolConstType entry of list b which is applicationSame() to a
*/

    public static SolConstType find(SolConstType a, List<SolConstType> bList){
        for(SolConstType b : bList){
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
 * @param name SolConstType name of the object we are looking for
 * @return SolConstType entry of the dataset with the given name; otherwise null
*/

    public static SolConstType findByName(ApplicationDataset base, String name){
        for(SolConstType a:base.getListSolConstType()) {
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
 * @param name SolConstType name of the object we are looking for
 * @return SolConstType entry of the dataset with the given name
*/

    public static SolConstType findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(SolConstType a:base.getListSolConstType()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        SolConstType res = new SolConstType(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return SolConstType first entry in the dataset of this type; null if that does not exists
*/

    public static SolConstType findFirst(ApplicationDataset base){
        if (base.getListSolConstType().isEmpty()) {
            return null;
        }
        return base.getListSolConstType().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return SolConstType some entry in the dataset of this type; null if that does not exists
*/

    public static SolConstType findAny(ApplicationDataset base){
        int size=base.getListSolConstType().size();
        if (size > 0) {
             return base.getListSolConstType().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return SolConstType last entry in the dataset of this type; null if that does not exists
*/

    public static SolConstType findLast(ApplicationDataset base){
        int size=base.getListSolConstType().size();
        if (size > 0) {
             return base.getListSolConstType().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b SolConstType compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(SolConstType b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b SolConstType compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(SolConstType b){
      if(!this.getConstituencyType().applicationSame(b.getConstituencyType())){
         System.out.println("ConstituencyType");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getPercent().equals(b.getPercent())){
         System.out.println("Percent");
        }
      if(!this.getSolution().applicationSame(b.getSolution())){
         System.out.println("Solution");
        }
      if(!this.getValue().equals(b.getValue())){
         System.out.println("Value");
        }
        return  this.getConstituencyType().applicationSame(b.getConstituencyType()) &&
          this.getName().equals(b.getName()) &&
          this.getPercent().equals(b.getPercent()) &&
          this.getSolution().applicationSame(b.getSolution()) &&
          this.getValue().equals(b.getValue());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","SolConstType",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getConstituencyType() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"constituencyType","SolConstType",(getConstituencyType()==null?"null":getConstituencyType().toString()),"",WarningType.NOTNULL);
        }
        if (getSolution() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"solution","SolConstType",(getSolution()==null?"null":getSolution().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class SolConstType
    }

/**
 *  This method states if the class depends on the solver.
 *
*/

    public static Boolean isSolverDependent(){
        return false;
    }

   public List<ApplicationObjectInterface> getFeasibleValues(ApplicationDatasetInterface base,String attrName){
      if (attrName.equals("constituencyType")){
         return (List) ((Scenario)base).getListConstituencyType();
      }
      if (attrName.equals("solution")){
         return (List) ((Scenario)base).getListSolution();
      }
      return null;
   }

}
