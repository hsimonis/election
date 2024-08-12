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

public  class SolTransfer extends ApplicationObject{
/**
 *  
 *
*/

    public County from;

/**
 *  
 *
*/

    public Double percentOfFrom;

/**
 *  
 *
*/

    public Solution solution;

/**
 *  
 *
*/

    public County to;

/**
 *  
 *
*/

    public Integer value;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public SolTransfer(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public SolTransfer(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setFrom(null);
        setPercentOfFrom(0.0);
        setSolution(null);
        setTo(null);
        setValue(0);
        applicationDataset.addSolTransfer(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public SolTransfer(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            County from,
            Double percentOfFrom,
            Solution solution,
            County to,
            Integer value){
        super(applicationDataset,
            id,
            name);
        setFrom(from);
        setPercentOfFrom(percentOfFrom);
        setSolution(solution);
        setTo(to);
        setValue(value);
        applicationDataset.addSolTransfer(this);
    }

    public SolTransfer(SolTransfer other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.from,
            other.percentOfFrom,
            other.solution,
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
        return getApplicationDataset().removeSolTransfer(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute from
 *
 * @return County
*/

    public County getFrom(){
        return this.from;
    }

/**
 *  get attribute percentOfFrom
 *
 * @return Double
*/

    public Double getPercentOfFrom(){
        return this.percentOfFrom;
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
 *  get attribute to
 *
 * @return County
*/

    public County getTo(){
        return this.to;
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
 *  set attribute from, mark dataset as dirty, mark dataset as not valid
@param from County
 *
*/

    public void setFrom(County from){
        this.from = from;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute percentOfFrom, mark dataset as dirty, mark dataset as not valid
@param percentOfFrom Double
 *
*/

    public void setPercentOfFrom(Double percentOfFrom){
        this.percentOfFrom = percentOfFrom;
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
 *  set attribute to, mark dataset as dirty, mark dataset as not valid
@param to County
 *
*/

    public void setTo(County to){
        this.to = to;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getFrom().toColumnString()+ " " +getPercentOfFrom()+ " " +getSolution().toColumnString()+ " " +getTo().toColumnString()+ " " +getValue();
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
         out.println("<solTransfer "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " from=\""+toXMLFrom()+"\""+
            " percentOfFrom=\""+toXMLPercentOfFrom()+"\""+
            " solution=\""+toXMLSolution()+"\""+
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

    String toXMLPercentOfFrom(){
        return this.getPercentOfFrom().toString();
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
        return "<tr><th>SolTransfer</th>"+"<th>Name</th>"+"<th>Solution</th>"+"<th>From</th>"+"<th>To</th>"+"<th>Value</th>"+"<th>PercentOfFrom</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getSolution().toColumnString()+"</td>"+ " " +"<td>"+getFrom().toColumnString()+"</td>"+ " " +"<td>"+getTo().toColumnString()+"</td>"+ " " +"<td>"+getValue()+"</td>"+ " " +"<td>"+getPercentOfFrom()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a SolTransfer item we are looking for
 * @param bList List<SolTransfer> list of items in which we are searching
 * @return SolTransfer entry of list b which is applicationSame() to a
*/

    public static SolTransfer find(SolTransfer a, List<SolTransfer> bList){
        for(SolTransfer b : bList){
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
 * @param name SolTransfer name of the object we are looking for
 * @return SolTransfer entry of the dataset with the given name; otherwise null
*/

    public static SolTransfer findByName(ApplicationDataset base, String name){
        for(SolTransfer a:base.getListSolTransfer()) {
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
 * @param name SolTransfer name of the object we are looking for
 * @return SolTransfer entry of the dataset with the given name
*/

    public static SolTransfer findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(SolTransfer a:base.getListSolTransfer()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        SolTransfer res = new SolTransfer(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return SolTransfer first entry in the dataset of this type; null if that does not exists
*/

    public static SolTransfer findFirst(ApplicationDataset base){
        if (base.getListSolTransfer().isEmpty()) {
            return null;
        }
        return base.getListSolTransfer().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return SolTransfer some entry in the dataset of this type; null if that does not exists
*/

    public static SolTransfer findAny(ApplicationDataset base){
        int size=base.getListSolTransfer().size();
        if (size > 0) {
             return base.getListSolTransfer().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return SolTransfer last entry in the dataset of this type; null if that does not exists
*/

    public static SolTransfer findLast(ApplicationDataset base){
        int size=base.getListSolTransfer().size();
        if (size > 0) {
             return base.getListSolTransfer().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b SolTransfer compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(SolTransfer b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b SolTransfer compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(SolTransfer b){
      if(!this.getFrom().applicationSame(b.getFrom())){
         System.out.println("From");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getPercentOfFrom().equals(b.getPercentOfFrom())){
         System.out.println("PercentOfFrom");
        }
      if(!this.getSolution().applicationSame(b.getSolution())){
         System.out.println("Solution");
        }
      if(!this.getTo().applicationSame(b.getTo())){
         System.out.println("To");
        }
      if(!this.getValue().equals(b.getValue())){
         System.out.println("Value");
        }
        return  this.getFrom().applicationSame(b.getFrom()) &&
          this.getName().equals(b.getName()) &&
          this.getPercentOfFrom().equals(b.getPercentOfFrom()) &&
          this.getSolution().applicationSame(b.getSolution()) &&
          this.getTo().applicationSame(b.getTo()) &&
          this.getValue().equals(b.getValue());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","SolTransfer",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getFrom() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"from","SolTransfer",(getFrom()==null?"null":getFrom().toString()),"",WarningType.NOTNULL);
        }
        if (getSolution() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"solution","SolTransfer",(getSolution()==null?"null":getSolution().toString()),"",WarningType.NOTNULL);
        }
        if (getTo() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"to","SolTransfer",(getTo()==null?"null":getTo().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class SolTransfer
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
         return (List) ((Scenario)base).getListCounty();
      }
      if (attrName.equals("solution")){
         return (List) ((Scenario)base).getListSolution();
      }
      if (attrName.equals("to")){
         return (List) ((Scenario)base).getListCounty();
      }
      return null;
   }

}
