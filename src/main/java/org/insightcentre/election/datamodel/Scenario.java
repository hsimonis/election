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
 * This class describes the dataset for the application. Typically there is a single instance of this class in the application at all times.
 * @author generated
*/

public  class Scenario extends ApplicationDataset{
/**
 *  
 *
*/

    public Integer alphaCostFactor;

/**
 *  
 *
*/

    public Integer betaCostFactor;

/**
 *  
 *
*/

    public Integer highBound;

/**
 *  
 *
*/

    public Integer lowBound;

/**
 *  
 *
*/

    public Integer totalPopulation;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public Scenario(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public Scenario(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setAlphaCostFactor(0);
        setBetaCostFactor(0);
        setHighBound(0);
        setLowBound(0);
        setTotalPopulation(0);
        addScenario(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public Scenario(Boolean dirty,
            Integer id,
            String name,
            Boolean valid,
            Integer alphaCostFactor,
            Integer betaCostFactor,
            Integer highBound,
            Integer lowBound,
            Integer totalPopulation){
        super(dirty,
            id,
            name,
            valid);
        setAlphaCostFactor(alphaCostFactor);
        setBetaCostFactor(betaCostFactor);
        setHighBound(highBound);
        setLowBound(lowBound);
        setTotalPopulation(totalPopulation);
        addScenario(this);
    }

    public Scenario(Scenario other){
        this(other.dirty,
            other.id,
            other.name,
            other.valid,
            other.alphaCostFactor,
            other.betaCostFactor,
            other.highBound,
            other.lowBound,
            other.totalPopulation);
    }

    public Boolean remove(){
        // ignored, you can not remove a dataset like this
        return true;
    }

/**
 *  get attribute alphaCostFactor
 *
 * @return Integer
*/

    public Integer getAlphaCostFactor(){
        return this.alphaCostFactor;
    }

/**
 *  get attribute betaCostFactor
 *
 * @return Integer
*/

    public Integer getBetaCostFactor(){
        return this.betaCostFactor;
    }

/**
 *  get attribute highBound
 *
 * @return Integer
*/

    public Integer getHighBound(){
        return this.highBound;
    }

/**
 *  get attribute lowBound
 *
 * @return Integer
*/

    public Integer getLowBound(){
        return this.lowBound;
    }

/**
 *  get attribute totalPopulation
 *
 * @return Integer
*/

    public Integer getTotalPopulation(){
        return this.totalPopulation;
    }

/**
 *  set attribute alphaCostFactor, mark dataset as dirty, mark dataset as not valid
@param alphaCostFactor Integer
 *
*/

    public void setAlphaCostFactor(Integer alphaCostFactor){
        this.alphaCostFactor = alphaCostFactor;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute betaCostFactor, mark dataset as dirty, mark dataset as not valid
@param betaCostFactor Integer
 *
*/

    public void setBetaCostFactor(Integer betaCostFactor){
        this.betaCostFactor = betaCostFactor;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute highBound, mark dataset as dirty, mark dataset as not valid
@param highBound Integer
 *
*/

    public void setHighBound(Integer highBound){
        this.highBound = highBound;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute lowBound, mark dataset as dirty, mark dataset as not valid
@param lowBound Integer
 *
*/

    public void setLowBound(Integer lowBound){
        this.lowBound = lowBound;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute totalPopulation, mark dataset as dirty, mark dataset as not valid
@param totalPopulation Integer
 *
*/

    public void setTotalPopulation(Integer totalPopulation){
        this.totalPopulation = totalPopulation;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute alphaCostFactor, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incAlphaCostFactor(){
        this.alphaCostFactor++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute betaCostFactor, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incBetaCostFactor(){
        this.betaCostFactor++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute highBound, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incHighBound(){
        this.highBound++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute lowBound, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incLowBound(){
        this.lowBound++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute totalPopulation, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incTotalPopulation(){
        this.totalPopulation++;
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
        return getDirty()+ " " +getId()+ " " +getName()+ " " +getValid()+ " " +getAlphaCostFactor()+ " " +getBetaCostFactor()+ " " +getHighBound()+ " " +getLowBound()+ " " +getTotalPopulation();
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
         out.println("<scenario "+ " dirty=\""+toXMLDirty()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " valid=\""+toXMLValid()+"\""+
            " alphaCostFactor=\""+toXMLAlphaCostFactor()+"\""+
            " betaCostFactor=\""+toXMLBetaCostFactor()+"\""+
            " highBound=\""+toXMLHighBound()+"\""+
            " lowBound=\""+toXMLLowBound()+"\""+
            " totalPopulation=\""+toXMLTotalPopulation()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLAlphaCostFactor(){
        return this.getAlphaCostFactor().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLBetaCostFactor(){
        return this.getBetaCostFactor().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLHighBound(){
        return this.getHighBound().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLLowBound(){
        return this.getLowBound().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLTotalPopulation(){
        return this.getTotalPopulation().toString();
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>Scenario</th>"+"<th>Name</th>"+"<th>Dirty</th>"+"<th>Valid</th>"+"<th>AlphaCostFactor</th>"+"<th>BetaCostFactor</th>"+"<th>LowBound</th>"+"<th>HighBound</th>"+"<th>TotalPopulation</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getDirty()+"</td>"+ " " +"<td>"+getValid()+"</td>"+ " " +"<td>"+getAlphaCostFactor()+"</td>"+ " " +"<td>"+getBetaCostFactor()+"</td>"+ " " +"<td>"+getLowBound()+"</td>"+ " " +"<td>"+getHighBound()+"</td>"+ " " +"<td>"+getTotalPopulation()+"</td>"+"</tr>";
    }

/**
 * compare object to another of the same type, create ApplicationWarnings if they differ
*/

    public void compare(Scenario compare){
        System.out.println("Calling compare super");
        super.compare(compare);
        System.out.println("Comparing Scenario");
        if (!this.applicationEqual(compare)) {
            System.out.println("Scenarios differ:"+this+" "+compare);
            new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Scenario A",this.toString(),DifferenceType.DIFFERA);
            new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Scenario B",compare.toString(),DifferenceType.DIFFERB);
        }
        System.out.println("Done Compare");
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b Scenario compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(Scenario b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b Scenario compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(Scenario b){
      if(!this.getAlphaCostFactor().equals(b.getAlphaCostFactor())){
         System.out.println("AlphaCostFactor");
        }
      if(!this.getBetaCostFactor().equals(b.getBetaCostFactor())){
         System.out.println("BetaCostFactor");
        }
      if(!this.getHighBound().equals(b.getHighBound())){
         System.out.println("HighBound");
        }
      if(!this.getLowBound().equals(b.getLowBound())){
         System.out.println("LowBound");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getTotalPopulation().equals(b.getTotalPopulation())){
         System.out.println("TotalPopulation");
        }
        return  this.getAlphaCostFactor().equals(b.getAlphaCostFactor()) &&
          this.getBetaCostFactor().equals(b.getBetaCostFactor()) &&
          this.getHighBound().equals(b.getHighBound()) &&
          this.getLowBound().equals(b.getLowBound()) &&
          this.getName().equals(b.getName()) &&
          this.getTotalPopulation().equals(b.getTotalPopulation());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getName().length() == 0) {
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"name","Scenario",(getName()==null?"null":getName().toString()),"",WarningType.NOTEMPTY);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class Scenario
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
