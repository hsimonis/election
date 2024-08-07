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

public  class Solution extends ApplicationObject{
/**
 *  
 *
*/

    public Double avgSeatsPerConstituency;

/**
 *  
 *
*/

    public Integer delta;

/**
 *  
 *
*/

    public Double deltaPercent;

/**
 *  
 *
*/

    public Double gapPercent;

/**
 *  
 *
*/

    public Integer k;

/**
 *  
 *
*/

    public Double lb;

/**
 *  
 *
*/

    public Double maxE;

/**
 *  
 *
*/

    public Double maxV;

/**
 *  
 *
*/

    public Double minE;

/**
 *  
 *
*/

    public Double minV;

/**
 *  
 *
*/

    public Integer nr;

/**
 *  
 *
*/

    public Integer nrConstituencies;

/**
 *  
 *
*/

    public Integer nrThreads;

/**
 *  
 *
*/

    public Double objValue;

/**
 *  
 *
*/

    public Integer personsPerTD;

/**
 *  
 *
*/

    public Double range;

/**
 *  
 *
*/

    public SolutionStatus solutionStatus;

/**
 *  
 *
*/

    public Double time;

/**
 *  
 *
*/

    public Integer timeLimit;

/**
 *  
 *
*/

    public Integer totalTransferred;

/**
 *  
 *
*/

    public Integer totalTransfers;

/**
 *  
 *
*/

    public Double weightedAbsoluteVariation;

/**
 *  
 *
*/

    public Double weightedAverage;

/**
 *  
 *
*/

    public Double weightedVariance;

/**
 *  No-arg constructor for use in TableView
 *
*/

    public Solution(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public Solution(ApplicationDataset applicationDataset){
        super(applicationDataset);
        setAvgSeatsPerConstituency(0.0);
        setDelta(0);
        setDeltaPercent(0.0);
        setGapPercent(0.0);
        setK(0);
        setLb(0.0);
        setMaxE(0.0);
        setMaxV(0.0);
        setMinE(0.0);
        setMinV(0.0);
        setNr(0);
        setNrConstituencies(0);
        setNrThreads(0);
        setObjValue(0.0);
        setPersonsPerTD(0);
        setRange(0.0);
        setSolutionStatus(null);
        setTime(0.0);
        setTimeLimit(0);
        setTotalTransferred(0);
        setTotalTransfers(0);
        setWeightedAbsoluteVariation(0.0);
        setWeightedAverage(0.0);
        setWeightedVariance(0.0);
        applicationDataset.addSolution(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public Solution(ApplicationDataset applicationDataset,
            Integer id,
            String name,
            Double avgSeatsPerConstituency,
            Integer delta,
            Double deltaPercent,
            Double gapPercent,
            Integer k,
            Double lb,
            Double maxE,
            Double maxV,
            Double minE,
            Double minV,
            Integer nr,
            Integer nrConstituencies,
            Integer nrThreads,
            Double objValue,
            Integer personsPerTD,
            Double range,
            SolutionStatus solutionStatus,
            Double time,
            Integer timeLimit,
            Integer totalTransferred,
            Integer totalTransfers,
            Double weightedAbsoluteVariation,
            Double weightedAverage,
            Double weightedVariance){
        super(applicationDataset,
            id,
            name);
        setAvgSeatsPerConstituency(avgSeatsPerConstituency);
        setDelta(delta);
        setDeltaPercent(deltaPercent);
        setGapPercent(gapPercent);
        setK(k);
        setLb(lb);
        setMaxE(maxE);
        setMaxV(maxV);
        setMinE(minE);
        setMinV(minV);
        setNr(nr);
        setNrConstituencies(nrConstituencies);
        setNrThreads(nrThreads);
        setObjValue(objValue);
        setPersonsPerTD(personsPerTD);
        setRange(range);
        setSolutionStatus(solutionStatus);
        setTime(time);
        setTimeLimit(timeLimit);
        setTotalTransferred(totalTransferred);
        setTotalTransfers(totalTransfers);
        setWeightedAbsoluteVariation(weightedAbsoluteVariation);
        setWeightedAverage(weightedAverage);
        setWeightedVariance(weightedVariance);
        applicationDataset.addSolution(this);
    }

    public Solution(Solution other){
        this(other.applicationDataset,
            other.id,
            other.name,
            other.avgSeatsPerConstituency,
            other.delta,
            other.deltaPercent,
            other.gapPercent,
            other.k,
            other.lb,
            other.maxE,
            other.maxV,
            other.minE,
            other.minV,
            other.nr,
            other.nrConstituencies,
            other.nrThreads,
            other.objValue,
            other.personsPerTD,
            other.range,
            other.solutionStatus,
            other.time,
            other.timeLimit,
            other.totalTransferred,
            other.totalTransfers,
            other.weightedAbsoluteVariation,
            other.weightedAverage,
            other.weightedVariance);
    }

/**
 *  remove this object from dataset, this may remove
 *  other objects of other classes, if they rely on this.
 *  Will remove item from list of this type, but also all parent types
 * @return Boolean true if item was removed without problems
*/

    public Boolean remove(){
        getApplicationDataset().cascadeSolCountySolution(this);
        getApplicationDataset().cascadeSolTransferSolution(this);
        getApplicationDataset().cascadeSolConstTypeSolution(this);
        return getApplicationDataset().removeSolution(this) && getApplicationDataset().removeApplicationObject(this);
    }

/**
 *  get attribute avgSeatsPerConstituency
 *
 * @return Double
*/

    public Double getAvgSeatsPerConstituency(){
        return this.avgSeatsPerConstituency;
    }

/**
 *  get attribute delta
 *
 * @return Integer
*/

    public Integer getDelta(){
        return this.delta;
    }

/**
 *  get attribute deltaPercent
 *
 * @return Double
*/

    public Double getDeltaPercent(){
        return this.deltaPercent;
    }

/**
 *  get attribute gapPercent
 *
 * @return Double
*/

    public Double getGapPercent(){
        return this.gapPercent;
    }

/**
 *  get attribute k
 *
 * @return Integer
*/

    public Integer getK(){
        return this.k;
    }

/**
 *  get attribute lb
 *
 * @return Double
*/

    public Double getLb(){
        return this.lb;
    }

/**
 *  get attribute maxE
 *
 * @return Double
*/

    public Double getMaxE(){
        return this.maxE;
    }

/**
 *  get attribute maxV
 *
 * @return Double
*/

    public Double getMaxV(){
        return this.maxV;
    }

/**
 *  get attribute minE
 *
 * @return Double
*/

    public Double getMinE(){
        return this.minE;
    }

/**
 *  get attribute minV
 *
 * @return Double
*/

    public Double getMinV(){
        return this.minV;
    }

/**
 *  get attribute nr
 *
 * @return Integer
*/

    public Integer getNr(){
        return this.nr;
    }

/**
 *  get attribute nrConstituencies
 *
 * @return Integer
*/

    public Integer getNrConstituencies(){
        return this.nrConstituencies;
    }

/**
 *  get attribute nrThreads
 *
 * @return Integer
*/

    public Integer getNrThreads(){
        return this.nrThreads;
    }

/**
 *  get attribute objValue
 *
 * @return Double
*/

    public Double getObjValue(){
        return this.objValue;
    }

/**
 *  get attribute personsPerTD
 *
 * @return Integer
*/

    public Integer getPersonsPerTD(){
        return this.personsPerTD;
    }

/**
 *  get attribute range
 *
 * @return Double
*/

    public Double getRange(){
        return this.range;
    }

/**
 *  get attribute solutionStatus
 *
 * @return SolutionStatus
*/

    public SolutionStatus getSolutionStatus(){
        return this.solutionStatus;
    }

/**
 *  get attribute time
 *
 * @return Double
*/

    public Double getTime(){
        return this.time;
    }

/**
 *  get attribute timeLimit
 *
 * @return Integer
*/

    public Integer getTimeLimit(){
        return this.timeLimit;
    }

/**
 *  get attribute totalTransferred
 *
 * @return Integer
*/

    public Integer getTotalTransferred(){
        return this.totalTransferred;
    }

/**
 *  get attribute totalTransfers
 *
 * @return Integer
*/

    public Integer getTotalTransfers(){
        return this.totalTransfers;
    }

/**
 *  get attribute weightedAbsoluteVariation
 *
 * @return Double
*/

    public Double getWeightedAbsoluteVariation(){
        return this.weightedAbsoluteVariation;
    }

/**
 *  get attribute weightedAverage
 *
 * @return Double
*/

    public Double getWeightedAverage(){
        return this.weightedAverage;
    }

/**
 *  get attribute weightedVariance
 *
 * @return Double
*/

    public Double getWeightedVariance(){
        return this.weightedVariance;
    }

/**
 *  set attribute avgSeatsPerConstituency, mark dataset as dirty, mark dataset as not valid
@param avgSeatsPerConstituency Double
 *
*/

    public void setAvgSeatsPerConstituency(Double avgSeatsPerConstituency){
        this.avgSeatsPerConstituency = avgSeatsPerConstituency;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute delta, mark dataset as dirty, mark dataset as not valid
@param delta Integer
 *
*/

    public void setDelta(Integer delta){
        this.delta = delta;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute deltaPercent, mark dataset as dirty, mark dataset as not valid
@param deltaPercent Double
 *
*/

    public void setDeltaPercent(Double deltaPercent){
        this.deltaPercent = deltaPercent;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute gapPercent, mark dataset as dirty, mark dataset as not valid
@param gapPercent Double
 *
*/

    public void setGapPercent(Double gapPercent){
        this.gapPercent = gapPercent;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute k, mark dataset as dirty, mark dataset as not valid
@param k Integer
 *
*/

    public void setK(Integer k){
        this.k = k;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute lb, mark dataset as dirty, mark dataset as not valid
@param lb Double
 *
*/

    public void setLb(Double lb){
        this.lb = lb;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute maxE, mark dataset as dirty, mark dataset as not valid
@param maxE Double
 *
*/

    public void setMaxE(Double maxE){
        this.maxE = maxE;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute maxV, mark dataset as dirty, mark dataset as not valid
@param maxV Double
 *
*/

    public void setMaxV(Double maxV){
        this.maxV = maxV;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute minE, mark dataset as dirty, mark dataset as not valid
@param minE Double
 *
*/

    public void setMinE(Double minE){
        this.minE = minE;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute minV, mark dataset as dirty, mark dataset as not valid
@param minV Double
 *
*/

    public void setMinV(Double minV){
        this.minV = minV;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute nr, mark dataset as dirty, mark dataset as not valid
@param nr Integer
 *
*/

    public void setNr(Integer nr){
        this.nr = nr;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute nrConstituencies, mark dataset as dirty, mark dataset as not valid
@param nrConstituencies Integer
 *
*/

    public void setNrConstituencies(Integer nrConstituencies){
        this.nrConstituencies = nrConstituencies;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute nrThreads, mark dataset as dirty, mark dataset as not valid
@param nrThreads Integer
 *
*/

    public void setNrThreads(Integer nrThreads){
        this.nrThreads = nrThreads;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute objValue, mark dataset as dirty, mark dataset as not valid
@param objValue Double
 *
*/

    public void setObjValue(Double objValue){
        this.objValue = objValue;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute personsPerTD, mark dataset as dirty, mark dataset as not valid
@param personsPerTD Integer
 *
*/

    public void setPersonsPerTD(Integer personsPerTD){
        this.personsPerTD = personsPerTD;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute range, mark dataset as dirty, mark dataset as not valid
@param range Double
 *
*/

    public void setRange(Double range){
        this.range = range;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute solutionStatus, mark dataset as dirty, mark dataset as not valid
@param solutionStatus SolutionStatus
 *
*/

    public void setSolutionStatus(SolutionStatus solutionStatus){
        this.solutionStatus = solutionStatus;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute time, mark dataset as dirty, mark dataset as not valid
@param time Double
 *
*/

    public void setTime(Double time){
        this.time = time;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute timeLimit, mark dataset as dirty, mark dataset as not valid
@param timeLimit Integer
 *
*/

    public void setTimeLimit(Integer timeLimit){
        this.timeLimit = timeLimit;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute totalTransferred, mark dataset as dirty, mark dataset as not valid
@param totalTransferred Integer
 *
*/

    public void setTotalTransferred(Integer totalTransferred){
        this.totalTransferred = totalTransferred;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute totalTransfers, mark dataset as dirty, mark dataset as not valid
@param totalTransfers Integer
 *
*/

    public void setTotalTransfers(Integer totalTransfers){
        this.totalTransfers = totalTransfers;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute weightedAbsoluteVariation, mark dataset as dirty, mark dataset as not valid
@param weightedAbsoluteVariation Double
 *
*/

    public void setWeightedAbsoluteVariation(Double weightedAbsoluteVariation){
        this.weightedAbsoluteVariation = weightedAbsoluteVariation;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute weightedAverage, mark dataset as dirty, mark dataset as not valid
@param weightedAverage Double
 *
*/

    public void setWeightedAverage(Double weightedAverage){
        this.weightedAverage = weightedAverage;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  set attribute weightedVariance, mark dataset as dirty, mark dataset as not valid
@param weightedVariance Double
 *
*/

    public void setWeightedVariance(Double weightedVariance){
        this.weightedVariance = weightedVariance;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute delta, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incDelta(){
        this.delta++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute k, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incK(){
        this.k++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute nr, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incNr(){
        this.nr++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute nrConstituencies, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incNrConstituencies(){
        this.nrConstituencies++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute nrThreads, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incNrThreads(){
        this.nrThreads++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute personsPerTD, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incPersonsPerTD(){
        this.personsPerTD++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute timeLimit, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incTimeLimit(){
        this.timeLimit++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute totalTransferred, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incTotalTransferred(){
        this.totalTransferred++;
        getApplicationDataset().setDirty(true);
        getApplicationDataset().setValid(false);
    }

/**
 *  inc attribute totalTransfers, mark dataset as dirty, mark dataset as not valid
 *
*/

    public void incTotalTransfers(){
        this.totalTransfers++;
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
        return ""+ " " +getId()+ " " +getName()+ " " +getAvgSeatsPerConstituency()+ " " +getDelta()+ " " +getDeltaPercent()+ " " +getGapPercent()+ " " +getK()+ " " +getLb()+ " " +getMaxE()+ " " +getMaxV()+ " " +getMinE()+ " " +getMinV()+ " " +getNr()+ " " +getNrConstituencies()+ " " +getNrThreads()+ " " +getObjValue()+ " " +getPersonsPerTD()+ " " +getRange()+ " " +getSolutionStatus()+ " " +getTime()+ " " +getTimeLimit()+ " " +getTotalTransferred()+ " " +getTotalTransfers()+ " " +getWeightedAbsoluteVariation()+ " " +getWeightedAverage()+ " " +getWeightedVariance();
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
         out.println("<solution "+ " applicationDataset=\""+toXMLApplicationDataset()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " avgSeatsPerConstituency=\""+toXMLAvgSeatsPerConstituency()+"\""+
            " delta=\""+toXMLDelta()+"\""+
            " deltaPercent=\""+toXMLDeltaPercent()+"\""+
            " gapPercent=\""+toXMLGapPercent()+"\""+
            " k=\""+toXMLK()+"\""+
            " lb=\""+toXMLLb()+"\""+
            " maxE=\""+toXMLMaxE()+"\""+
            " maxV=\""+toXMLMaxV()+"\""+
            " minE=\""+toXMLMinE()+"\""+
            " minV=\""+toXMLMinV()+"\""+
            " nr=\""+toXMLNr()+"\""+
            " nrConstituencies=\""+toXMLNrConstituencies()+"\""+
            " nrThreads=\""+toXMLNrThreads()+"\""+
            " objValue=\""+toXMLObjValue()+"\""+
            " personsPerTD=\""+toXMLPersonsPerTD()+"\""+
            " range=\""+toXMLRange()+"\""+
            " solutionStatus=\""+toXMLSolutionStatus()+"\""+
            " time=\""+toXMLTime()+"\""+
            " timeLimit=\""+toXMLTimeLimit()+"\""+
            " totalTransferred=\""+toXMLTotalTransferred()+"\""+
            " totalTransfers=\""+toXMLTotalTransfers()+"\""+
            " weightedAbsoluteVariation=\""+toXMLWeightedAbsoluteVariation()+"\""+
            " weightedAverage=\""+toXMLWeightedAverage()+"\""+
            " weightedVariance=\""+toXMLWeightedVariance()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLAvgSeatsPerConstituency(){
        return this.getAvgSeatsPerConstituency().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLDelta(){
        return this.getDelta().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLDeltaPercent(){
        return this.getDeltaPercent().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLGapPercent(){
        return this.getGapPercent().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLK(){
        return this.getK().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLLb(){
        return this.getLb().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLMaxE(){
        return this.getMaxE().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLMaxV(){
        return this.getMaxV().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLMinE(){
        return this.getMinE().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLMinV(){
        return this.getMinV().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLNr(){
        return this.getNr().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLNrConstituencies(){
        return this.getNrConstituencies().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLNrThreads(){
        return this.getNrThreads().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLObjValue(){
        return this.getObjValue().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLPersonsPerTD(){
        return this.getPersonsPerTD().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLRange(){
        return this.getRange().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLSolutionStatus(){
        return this.getSolutionStatus().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLTime(){
        return this.getTime().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLTimeLimit(){
        return this.getTimeLimit().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLTotalTransferred(){
        return this.getTotalTransferred().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLTotalTransfers(){
        return this.getTotalTransfers().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLWeightedAbsoluteVariation(){
        return this.getWeightedAbsoluteVariation().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLWeightedAverage(){
        return this.getWeightedAverage().toString();
    }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLWeightedVariance(){
        return this.getWeightedVariance().toString();
    }

/**
 * show object as one row in an HTML table
 * 
 * @return String of form <tr>...</tr>
*/

    public static String toHTMLLabels(){
        return "<tr><th>Solution</th>"+"<th>Name</th>"+"<th>Nr</th>"+"<th>K</th>"+"<th>Delta</th>"+"<th>DeltaPercent</th>"+"<th>PersonsPerTD</th>"+"<th>MinE</th>"+"<th>MaxE</th>"+"<th>WeightedAverage</th>"+"<th>WeightedVariance</th>"+"<th>WeightedAbsoluteVariation</th>"+"<th>MinV</th>"+"<th>MaxV</th>"+"<th>Range</th>"+"<th>TotalTransfers</th>"+"<th>TotalTransferred</th>"+"<th>NrConstituencies</th>"+"<th>AvgSeatsPerConstituency</th>"+"<th>TimeLimit</th>"+"<th>NrThreads</th>"+"<th>SolutionStatus</th>"+"<th>ObjValue</th>"+"<th>Lb</th>"+"<th>GapPercent</th>"+"<th>Time</th>"+"</tr>";
    }

    public String toHTML(){
        return "<tr><th>&nbsp;</th>"+"<td>"+getName()+"</td>"+ " " +"<td>"+getNr()+"</td>"+ " " +"<td>"+getK()+"</td>"+ " " +"<td>"+getDelta()+"</td>"+ " " +"<td>"+getDeltaPercent()+"</td>"+ " " +"<td>"+getPersonsPerTD()+"</td>"+ " " +"<td>"+getMinE()+"</td>"+ " " +"<td>"+getMaxE()+"</td>"+ " " +"<td>"+getWeightedAverage()+"</td>"+ " " +"<td>"+getWeightedVariance()+"</td>"+ " " +"<td>"+getWeightedAbsoluteVariation()+"</td>"+ " " +"<td>"+getMinV()+"</td>"+ " " +"<td>"+getMaxV()+"</td>"+ " " +"<td>"+getRange()+"</td>"+ " " +"<td>"+getTotalTransfers()+"</td>"+ " " +"<td>"+getTotalTransferred()+"</td>"+ " " +"<td>"+getNrConstituencies()+"</td>"+ " " +"<td>"+getAvgSeatsPerConstituency()+"</td>"+ " " +"<td>"+getTimeLimit()+"</td>"+ " " +"<td>"+getNrThreads()+"</td>"+ " " +"<td>"+getSolutionStatus()+"</td>"+ " " +"<td>"+getObjValue()+"</td>"+ " " +"<td>"+getLb()+"</td>"+ " " +"<td>"+getGapPercent()+"</td>"+ " " +"<td>"+getTime()+"</td>"+"</tr>";
    }

/**
 * find the same object in another dataset
 * @param a Solution item we are looking for
 * @param bList List<Solution> list of items in which we are searching
 * @return Solution entry of list b which is applicationSame() to a
*/

    public static Solution find(Solution a, List<Solution> bList){
        for(Solution b : bList){
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
 * @param name Solution name of the object we are looking for
 * @return Solution entry of the dataset with the given name; otherwise null
*/

    public static Solution findByName(ApplicationDataset base, String name){
        for(Solution a:base.getListSolution()) {
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
 * @param name Solution name of the object we are looking for
 * @return Solution entry of the dataset with the given name
*/

    public static Solution findOrCreate(ApplicationDataset base, String name){
        if (name.equals("null")){ return null;}
        for(Solution a:base.getListSolution()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        Solution res = new Solution(base);
        res.setName(name);
        return res;
    }

/**
 * find the first entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Solution first entry in the dataset of this type; null if that does not exists
*/

    public static Solution findFirst(ApplicationDataset base){
        if (base.getListSolution().isEmpty()) {
            return null;
        }
        return base.getListSolution().get(0);
    }

/**
 * find some entry entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Solution some entry in the dataset of this type; null if that does not exists
*/

    public static Solution findAny(ApplicationDataset base){
        int size=base.getListSolution().size();
        if (size > 0) {
             return base.getListSolution().get(new Random().nextInt(size));
        }
        return null;
    }

/**
 * find the last entry in the dataset of that type
 * @param base dataset in which we are searching
 * @return Solution last entry in the dataset of this type; null if that does not exists
*/

    public static Solution findLast(ApplicationDataset base){
        int size=base.getListSolution().size();
        if (size > 0) {
             return base.getListSolution().get(size-1);
        }
        return null;
    }

/**
 * check if two objects (typically in different datasets) refer to the same real-world item
 * often this means that the names match, depending on the display_key
 * @param b Solution compare this to that object
 * @return Boolean true if the objects match the same criteria
*/

    public Boolean applicationSame(Solution b){
        return this.getName().equals(b.getName());
    }

/**
 * check if two objects (typically in different datasets) are equal, i.e. have the same field values
 * typically used to check if an item is different in two datasets
 * this is quite different from the equals() method, which checks if the objects are idenitcal
 * @param b Solution compare this to that object
 * @return Boolean true if the objects match the equal criteria
*/

    public Boolean applicationEqual(Solution b){
      if(!this.getAvgSeatsPerConstituency().equals(b.getAvgSeatsPerConstituency())){
         System.out.println("AvgSeatsPerConstituency");
        }
      if(!this.getDelta().equals(b.getDelta())){
         System.out.println("Delta");
        }
      if(!this.getDeltaPercent().equals(b.getDeltaPercent())){
         System.out.println("DeltaPercent");
        }
      if(!this.getGapPercent().equals(b.getGapPercent())){
         System.out.println("GapPercent");
        }
      if(!this.getK().equals(b.getK())){
         System.out.println("K");
        }
      if(!this.getLb().equals(b.getLb())){
         System.out.println("Lb");
        }
      if(!this.getMaxE().equals(b.getMaxE())){
         System.out.println("MaxE");
        }
      if(!this.getMaxV().equals(b.getMaxV())){
         System.out.println("MaxV");
        }
      if(!this.getMinE().equals(b.getMinE())){
         System.out.println("MinE");
        }
      if(!this.getMinV().equals(b.getMinV())){
         System.out.println("MinV");
        }
      if(!this.getName().equals(b.getName())){
         System.out.println("Name");
        }
      if(!this.getNr().equals(b.getNr())){
         System.out.println("Nr");
        }
      if(!this.getNrConstituencies().equals(b.getNrConstituencies())){
         System.out.println("NrConstituencies");
        }
      if(!this.getNrThreads().equals(b.getNrThreads())){
         System.out.println("NrThreads");
        }
      if(!this.getObjValue().equals(b.getObjValue())){
         System.out.println("ObjValue");
        }
      if(!this.getPersonsPerTD().equals(b.getPersonsPerTD())){
         System.out.println("PersonsPerTD");
        }
      if(!this.getRange().equals(b.getRange())){
         System.out.println("Range");
        }
      if(!this.getSolutionStatus().equals(b.getSolutionStatus())){
         System.out.println("SolutionStatus");
        }
      if(!this.getTime().equals(b.getTime())){
         System.out.println("Time");
        }
      if(!this.getTimeLimit().equals(b.getTimeLimit())){
         System.out.println("TimeLimit");
        }
      if(!this.getTotalTransferred().equals(b.getTotalTransferred())){
         System.out.println("TotalTransferred");
        }
      if(!this.getTotalTransfers().equals(b.getTotalTransfers())){
         System.out.println("TotalTransfers");
        }
      if(!this.getWeightedAbsoluteVariation().equals(b.getWeightedAbsoluteVariation())){
         System.out.println("WeightedAbsoluteVariation");
        }
      if(!this.getWeightedAverage().equals(b.getWeightedAverage())){
         System.out.println("WeightedAverage");
        }
      if(!this.getWeightedVariance().equals(b.getWeightedVariance())){
         System.out.println("WeightedVariance");
        }
        return  this.getAvgSeatsPerConstituency().equals(b.getAvgSeatsPerConstituency()) &&
          this.getDelta().equals(b.getDelta()) &&
          this.getDeltaPercent().equals(b.getDeltaPercent()) &&
          this.getGapPercent().equals(b.getGapPercent()) &&
          this.getK().equals(b.getK()) &&
          this.getLb().equals(b.getLb()) &&
          this.getMaxE().equals(b.getMaxE()) &&
          this.getMaxV().equals(b.getMaxV()) &&
          this.getMinE().equals(b.getMinE()) &&
          this.getMinV().equals(b.getMinV()) &&
          this.getName().equals(b.getName()) &&
          this.getNr().equals(b.getNr()) &&
          this.getNrConstituencies().equals(b.getNrConstituencies()) &&
          this.getNrThreads().equals(b.getNrThreads()) &&
          this.getObjValue().equals(b.getObjValue()) &&
          this.getPersonsPerTD().equals(b.getPersonsPerTD()) &&
          this.getRange().equals(b.getRange()) &&
          this.getSolutionStatus().equals(b.getSolutionStatus()) &&
          this.getTime().equals(b.getTime()) &&
          this.getTimeLimit().equals(b.getTimeLimit()) &&
          this.getTotalTransferred().equals(b.getTotalTransferred()) &&
          this.getTotalTransfers().equals(b.getTotalTransfers()) &&
          this.getWeightedAbsoluteVariation().equals(b.getWeightedAbsoluteVariation()) &&
          this.getWeightedAverage().equals(b.getWeightedAverage()) &&
          this.getWeightedVariance().equals(b.getWeightedVariance());
    }

/**
 * check an object for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void check(){
        if (getApplicationDataset() == null){
         new ApplicationWarning(getApplicationDataset(),ApplicationDataset.getIdNr(),toColumnString(),"applicationDataset","Solution",(getApplicationDataset()==null?"null":getApplicationDataset().toString()),"",WarningType.NOTNULL);
        }
    }

    static void dummy(ApplicationDataset base){
// no dummy information for class Solution
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
