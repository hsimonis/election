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

public  class County extends ApplicationObject{
/**
 *  
 *
*/

    public Double centroidX;

/**
 *  
 *
*/

    public Double centroidY;

/**
 *  
 *
*/

    public Integer nrED;

/**
 *  
 *
*/

    public Integer population;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public County(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public County(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setCentroidX(0.0);
        setCentroidY(0.0);
        setNrED(0);
        setPopulation(0);
        applicationDataset.addCounty(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public County(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            Double centroidX,
            Double centroidY,
            Integer nrED,
            Integer population){
        super(applicationDataset,
            id,
            name);
        setCentroidX(centroidX);
        setCentroidY(centroidY);
        setNrED(nrED);
        setPopulation(population);
        applicationDataset.addCounty(this);
    }

    public County(County other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.centroidX,
            other.centroidY,
            other.nrED,
            other.population);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        getApplicationDataset().cascadeNeighborCountyCounty1(this);
        getApplicationDataset().cascadeNeighborCountyCounty2(this);
        getApplicationDataset().cascadeShapedCounty(this);
        getApplicationDataset().cascadeSolCountyCounty(this);
        getApplicationDataset().cascadeSolTransferFrom(this);
        getApplicationDataset().cascadeSolTransferTo(this);
        return getApplicationDataset().removeCounty(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute centroidX
 *
 * @return Double
*/

    public Double getCentroidX(){
        return this.centroidX;
    }

/**
 *  get attribute centroidY
 *
 * @return Double
*/

    public Double getCentroidY(){
        return this.centroidY;
    }

/**
 *  get attribute nrED
 *
 * @return Integer
*/

    public Integer getNrED(){
        return this.nrED;
    }

/**
 *  get attribute population
 *
 * @return Integer
*/

    public Integer getPopulation(){
        return this.population;
    }

/**
 *  set attribute centroidX, mark dataset as dirty, mark dataset as not valid
@param centroidX Double
 *
*/

    public void setCentroidX(Double centroidX){
        this.centroidX = centroidX;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute centroidY, mark dataset as dirty, mark dataset as not valid
@param centroidY Double
 *
*/

    public void setCentroidY(Double centroidY){
        this.centroidY = centroidY;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute nrED, mark dataset as dirty, mark dataset as not valid
@param nrED Integer
 *
*/

    public void setNrED(Integer nrED){
        this.nrED = nrED;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute population, mark dataset as dirty, mark dataset as not valid
@param population Integer
 *
*/

    public void setPopulation(Integer population){
        this.population = population;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute nrED, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incNrED(){
        this.nrED++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute population, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incPopulation(){
        this.population++;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getCentroidX()+ " " +getCentroidY()+ " " +getNrED()+ " " +getPopulation();
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
         out.println("<county "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " centroidX=\""+toXMLCentroidX()+"\""+
            " centroidY=\""+toXMLCentroidY()+"\""+
            " nrED=\""+toXMLNrED()+"\""+
            " population=\""+toXMLPopulation()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCentroidX(){
        return this.getCentroidX().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCentroidY(){
        return this.getCentroidY().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLNrED(){
        return this.getNrED().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLPopulation(){
        return this.getPopulation().toString();
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>County</th>"+"<th>Name</th>"+"<th>Population</th>"+"<th>NrED</th>"+"<th>CentroidX</th>"+"<th>CentroidY</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getPopulation()+"</td>"+ " " +"<td>"+getNrED()+"</td>"+ " " +"<td>"+getCentroidX()+"</td>"+ " " +"<td>"+getCentroidY()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a County item we are looking for
 * @param bList List<County> list of items in which we are searching
 * @return County entry of list b which is applicationSame() to a
*/

    public static County find(County a, List<County> bList){
        for(County b : bList){
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
 * @param name County name of the object we are looking for
 * @return County entry of the dataset with the given name; otherwise null
*/

    public static County findByName(ApplicationDataset base, String name){
        for(County a:base.getListCounty()) {
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
 * @param name County name of the object we are looking for
 * @return County entry of the dataset with the given name
*/

    public static County findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(County a:base.getListCounty()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        County res = new County(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return County first entry in the dataset of this type; null if that does not exists
*/

    public static County findFirst(ApplicationDataset base){
        if (base.getListCounty().isEmpty()) {
            return null;
        }
        return base.getListCounty().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return County some entry in the dataset of this type; null if that does not exists
*/

    public static County findAny(ApplicationDataset base){
        int size=base.getListCounty().size();
        if (size > 0) {
             return base.getListCounty().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return County last entry in the dataset of this type; null if that does not exists
*/

    public static County findLast(ApplicationDataset base){
        int size=base.getListCounty().size();
        if (size > 0) {
             return base.getListCounty().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b County compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(County b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b County compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(County b){
      if(!this.getCentroidX().equals(b.getCentroidX())){
         System.out.println("CentroidX");
        }
      if(!this.getCentroidY().equals(b.getCentroidY())){
         System.out.println("CentroidY");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getNrED().equals(b.getNrED())){
         System.out.println("NrED");
        }
      if(!this.getPopulation().equals(b.getPopulation())){
         System.out.println("Population");
        }
        return  this.getCentroidX().equals(b.getCentroidX()) &&
          this.getCentroidY().equals(b.getCentroidY()) &&
          this.getName().equals(b.getName()) &&
          this.getNrED().equals(b.getNrED()) &&
          this.getPopulation().equals(b.getPopulation());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","County",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class County
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
