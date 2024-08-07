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

public  class SolCounty extends ApplicationObject{
/**
 *  
 *
*/

    public String constTypes;

/**
 *  
 *
*/

    public Integer constituenciesAssigned;

/**
 *  
 *
*/

    public County county;

/**
 *  
 *
*/

    public Integer effectivePopulation;

/**
 *  
 *
*/

    public Double fractionalSeats;

/**
 *  
 *
*/

    public Double personsPerSeat;

/**
 *  
 *
*/

    public Integer population;

/**
 *  
 *
*/

    public Integer seatsAssigned;

/**
 *  
 *
*/

    public Solution solution;

/**
 *  
 *
*/

    public Integer transferIn;

/**
 *  
 *
*/

    public Integer transferOut;

/**
 *  
 *
*/

    public Double variation;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public SolCounty(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public SolCounty(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setConstTypes("");
        setConstituenciesAssigned(0);
        setCounty(null);
        setEffectivePopulation(0);
        setFractionalSeats(0.0);
        setPersonsPerSeat(0.0);
        setPopulation(0);
        setSeatsAssigned(0);
        setSolution(null);
        setTransferIn(0);
        setTransferOut(0);
        setVariation(0.0);
        applicationDataset.addSolCounty(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public SolCounty(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            String constTypes,
            Integer constituenciesAssigned,
            County county,
            Integer effectivePopulation,
            Double fractionalSeats,
            Double personsPerSeat,
            Integer population,
            Integer seatsAssigned,
            Solution solution,
            Integer transferIn,
            Integer transferOut,
            Double variation){
        super(applicationDataset,
            id,
            name);
        setConstTypes(constTypes);
        setConstituenciesAssigned(constituenciesAssigned);
        setCounty(county);
        setEffectivePopulation(effectivePopulation);
        setFractionalSeats(fractionalSeats);
        setPersonsPerSeat(personsPerSeat);
        setPopulation(population);
        setSeatsAssigned(seatsAssigned);
        setSolution(solution);
        setTransferIn(transferIn);
        setTransferOut(transferOut);
        setVariation(variation);
        applicationDataset.addSolCounty(this);
    }

    public SolCounty(SolCounty other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.constTypes,
            other.constituenciesAssigned,
            other.county,
            other.effectivePopulation,
            other.fractionalSeats,
            other.personsPerSeat,
            other.population,
            other.seatsAssigned,
            other.solution,
            other.transferIn,
            other.transferOut,
            other.variation);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        return getApplicationDataset().removeSolCounty(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute constTypes
 *
 * @return String
*/

    public String getConstTypes(){
        return this.constTypes;
    }

/**
 *  get attribute constituenciesAssigned
 *
 * @return Integer
*/

    public Integer getConstituenciesAssigned(){
        return this.constituenciesAssigned;
    }

/**
 *  get attribute county
 *
 * @return County
*/

    public County getCounty(){
        return this.county;
    }

/**
 *  get attribute effectivePopulation
 *
 * @return Integer
*/

    public Integer getEffectivePopulation(){
        return this.effectivePopulation;
    }

/**
 *  get attribute fractionalSeats
 *
 * @return Double
*/

    public Double getFractionalSeats(){
        return this.fractionalSeats;
    }

/**
 *  get attribute personsPerSeat
 *
 * @return Double
*/

    public Double getPersonsPerSeat(){
        return this.personsPerSeat;
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
 *  get attribute seatsAssigned
 *
 * @return Integer
*/

    public Integer getSeatsAssigned(){
        return this.seatsAssigned;
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
 *  get attribute transferIn
 *
 * @return Integer
*/

    public Integer getTransferIn(){
        return this.transferIn;
    }

/**
 *  get attribute transferOut
 *
 * @return Integer
*/

    public Integer getTransferOut(){
        return this.transferOut;
    }

/**
 *  get attribute variation
 *
 * @return Double
*/

    public Double getVariation(){
        return this.variation;
    }

/**
 *  set attribute constTypes, mark dataset as dirty, mark dataset as not valid
@param constTypes String
 *
*/

    public void setConstTypes(String constTypes){
        this.constTypes = constTypes;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute constituenciesAssigned, mark dataset as dirty, mark dataset as not valid
@param constituenciesAssigned Integer
 *
*/

    public void setConstituenciesAssigned(Integer constituenciesAssigned){
        this.constituenciesAssigned = constituenciesAssigned;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute county, mark dataset as dirty, mark dataset as not valid
@param county County
 *
*/

    public void setCounty(County county){
        this.county = county;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute effectivePopulation, mark dataset as dirty, mark dataset as not valid
@param effectivePopulation Integer
 *
*/

    public void setEffectivePopulation(Integer effectivePopulation){
        this.effectivePopulation = effectivePopulation;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute fractionalSeats, mark dataset as dirty, mark dataset as not valid
@param fractionalSeats Double
 *
*/

    public void setFractionalSeats(Double fractionalSeats){
        this.fractionalSeats = fractionalSeats;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute personsPerSeat, mark dataset as dirty, mark dataset as not valid
@param personsPerSeat Double
 *
*/

    public void setPersonsPerSeat(Double personsPerSeat){
        this.personsPerSeat = personsPerSeat;
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
 *  set attribute seatsAssigned, mark dataset as dirty, mark dataset as not valid
@param seatsAssigned Integer
 *
*/

    public void setSeatsAssigned(Integer seatsAssigned){
        this.seatsAssigned = seatsAssigned;
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
 *  set attribute transferIn, mark dataset as dirty, mark dataset as not valid
@param transferIn Integer
 *
*/

    public void setTransferIn(Integer transferIn){
        this.transferIn = transferIn;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute transferOut, mark dataset as dirty, mark dataset as not valid
@param transferOut Integer
 *
*/

    public void setTransferOut(Integer transferOut){
        this.transferOut = transferOut;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute variation, mark dataset as dirty, mark dataset as not valid
@param variation Double
 *
*/

    public void setVariation(Double variation){
        this.variation = variation;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute constituenciesAssigned, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incConstituenciesAssigned(){
        this.constituenciesAssigned++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute effectivePopulation, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incEffectivePopulation(){
        this.effectivePopulation++;
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
 *  inc attribute seatsAssigned, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incSeatsAssigned(){
        this.seatsAssigned++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute transferIn, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incTransferIn(){
        this.transferIn++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute transferOut, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incTransferOut(){
        this.transferOut++;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getConstTypes()+ " " +getConstituenciesAssigned()+ " " +getCounty().toColumnString()+ " " +getEffectivePopulation()+ " " +getFractionalSeats()+ " " +getPersonsPerSeat()+ " " +getPopulation()+ " " +getSeatsAssigned()+ " " +getSolution().toColumnString()+ " " +getTransferIn()+ " " +getTransferOut()+ " " +getVariation();
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
         out.println("<solCounty "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " constTypes=\""+toXMLConstTypes()+"\""+
            " constituenciesAssigned=\""+toXMLConstituenciesAssigned()+"\""+
            " county=\""+toXMLCounty()+"\""+
            " effectivePopulation=\""+toXMLEffectivePopulation()+"\""+
            " fractionalSeats=\""+toXMLFractionalSeats()+"\""+
            " personsPerSeat=\""+toXMLPersonsPerSeat()+"\""+
            " population=\""+toXMLPopulation()+"\""+
            " seatsAssigned=\""+toXMLSeatsAssigned()+"\""+
            " solution=\""+toXMLSolution()+"\""+
            " transferIn=\""+toXMLTransferIn()+"\""+
            " transferOut=\""+toXMLTransferOut()+"\""+
            " variation=\""+toXMLVariation()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLConstTypes(){
        return this.safeXML(getConstTypes());
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLConstituenciesAssigned(){
        return this.getConstituenciesAssigned().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLCounty(){
        return "ID_"+this.getCounty().getId().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLEffectivePopulation(){
        return this.getEffectivePopulation().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLFractionalSeats(){
        return this.getFractionalSeats().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLPersonsPerSeat(){
        return this.getPersonsPerSeat().toString();
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
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLSeatsAssigned(){
        return this.getSeatsAssigned().toString();
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

    String toXMLTransferIn(){
        return this.getTransferIn().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLTransferOut(){
        return this.getTransferOut().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLVariation(){
        return this.getVariation().toString();
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>SolCounty</th>"+"<th>Name</th>"+"<th>County</th>"+"<th>Solution</th>"+"<th>Population</th>"+"<th>FractionalSeats</th>"+"<th>TransferOut</th>"+"<th>TransferIn</th>"+"<th>EffectivePopulation</th>"+"<th>ConstituenciesAssigned</th>"+"<th>ConstTypes</th>"+"<th>SeatsAssigned</th>"+"<th>PersonsPerSeat</th>"+"<th>Variation</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getCounty().toColumnString()+"</td>"+ " " +"<td>"+getSolution().toColumnString()+"</td>"+ " " +"<td>"+getPopulation()+"</td>"+ " " +"<td>"+getFractionalSeats()+"</td>"+ " " +"<td>"+getTransferOut()+"</td>"+ " " +"<td>"+getTransferIn()+"</td>"+ " " +"<td>"+getEffectivePopulation()+"</td>"+ " " +"<td>"+getConstituenciesAssigned()+"</td>"+ " " +"<td>"+getConstTypes()+"</td>"+ " " +"<td>"+getSeatsAssigned()+"</td>"+ " " +"<td>"+getPersonsPerSeat()+"</td>"+ " " +"<td>"+getVariation()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a SolCounty item we are looking for
 * @param bList List<SolCounty> list of items in which we are searching
 * @return SolCounty entry of list b which is applicationSame() to a
*/

    public static SolCounty find(SolCounty a, List<SolCounty> bList){
        for(SolCounty b : bList){
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
 * @param name SolCounty name of the object we are looking for
 * @return SolCounty entry of the dataset with the given name; otherwise null
*/

    public static SolCounty findByName(ApplicationDataset base, String name){
        for(SolCounty a:base.getListSolCounty()) {
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
 * @param name SolCounty name of the object we are looking for
 * @return SolCounty entry of the dataset with the given name
*/

    public static SolCounty findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(SolCounty a:base.getListSolCounty()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        SolCounty res = new SolCounty(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return SolCounty first entry in the dataset of this type; null if that does not exists
*/

    public static SolCounty findFirst(ApplicationDataset base){
        if (base.getListSolCounty().isEmpty()) {
            return null;
        }
        return base.getListSolCounty().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return SolCounty some entry in the dataset of this type; null if that does not exists
*/

    public static SolCounty findAny(ApplicationDataset base){
        int size=base.getListSolCounty().size();
        if (size > 0) {
             return base.getListSolCounty().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return SolCounty last entry in the dataset of this type; null if that does not exists
*/

    public static SolCounty findLast(ApplicationDataset base){
        int size=base.getListSolCounty().size();
        if (size > 0) {
             return base.getListSolCounty().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b SolCounty compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(SolCounty b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b SolCounty compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(SolCounty b){
      if(!this.getConstTypes().equals(b.getConstTypes())){
         System.out.println("ConstTypes");
        }
      if(!this.getConstituenciesAssigned().equals(b.getConstituenciesAssigned())){
         System.out.println("ConstituenciesAssigned");
        }
      if(!this.getCounty().applicationSame(b.getCounty())){
         System.out.println("County");
        }
      if(!this.getEffectivePopulation().equals(b.getEffectivePopulation())){
         System.out.println("EffectivePopulation");
        }
      if(!this.getFractionalSeats().equals(b.getFractionalSeats())){
         System.out.println("FractionalSeats");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getPersonsPerSeat().equals(b.getPersonsPerSeat())){
         System.out.println("PersonsPerSeat");
        }
      if(!this.getPopulation().equals(b.getPopulation())){
         System.out.println("Population");
        }
      if(!this.getSeatsAssigned().equals(b.getSeatsAssigned())){
         System.out.println("SeatsAssigned");
        }
      if(!this.getSolution().applicationSame(b.getSolution())){
         System.out.println("Solution");
        }
      if(!this.getTransferIn().equals(b.getTransferIn())){
         System.out.println("TransferIn");
        }
      if(!this.getTransferOut().equals(b.getTransferOut())){
         System.out.println("TransferOut");
        }
      if(!this.getVariation().equals(b.getVariation())){
         System.out.println("Variation");
        }
        return  this.getConstTypes().equals(b.getConstTypes()) &&
          this.getConstituenciesAssigned().equals(b.getConstituenciesAssigned()) &&
          this.getCounty().applicationSame(b.getCounty()) &&
          this.getEffectivePopulation().equals(b.getEffectivePopulation()) &&
          this.getFractionalSeats().equals(b.getFractionalSeats()) &&
          this.getName().equals(b.getName()) &&
          this.getPersonsPerSeat().equals(b.getPersonsPerSeat()) &&
          this.getPopulation().equals(b.getPopulation()) &&
          this.getSeatsAssigned().equals(b.getSeatsAssigned()) &&
          this.getSolution().applicationSame(b.getSolution()) &&
          this.getTransferIn().equals(b.getTransferIn()) &&
          this.getTransferOut().equals(b.getTransferOut()) &&
          this.getVariation().equals(b.getVariation());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","SolCounty",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
        if (getCounty() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"county","SolCounty",(getCounty()==null?"null":getCounty().toString()),"",WarningType.NOTNULL);
        }
        if (getSolution() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"solution","SolCounty",(getSolution()==null?"null":getSolution().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class SolCounty
    }

/**
 *  This method states if the class depends on the solver.
 *
*/

    public static Boolean isSolverDependent(){
        return false;
    }

   public List<ApplicationObjectInterface> getFeasibleValues(ApplicationDatasetInterface base,String attrName){
      if (attrName.equals("county")){
         return (List) ((Scenario)base).getListCounty();
      }
      if (attrName.equals("solution")){
         return (List) ((Scenario)base).getListSolution();
      }
      return null;
   }

}
