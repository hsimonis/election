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
 * This is an abstract base class for the dataset description. Each application should derive one class from this to describe a dataset in the application. Most of the time, we will only use one dataset at a time.
 * @author generated
*/

public abstract class ApplicationDataset implements ApplicationDatasetInterface,Comparable<ApplicationDataset>{
/**
 *  Marks the dataset as dirty, there are unsaved modifications.
 *
*/

    public Boolean dirty;

    private transient BooleanProperty dirtyWrapper;

/**
 *  Id number of the dataset, required as this item is not an ApplicationObject.
 *
*/

    public Integer id;

/**
 *  Name of the datase. This is required as the item is not an ApplicationObject.
 *
*/

    public String name;

/**
 *  Marks the dataset as valid, when the solver has been run and no other data has been changed.
 *
*/

    public Boolean valid;

    private transient BooleanProperty validWrapper;

/**
 *  This lists holds all items of class ApplicationDataset and its subclasses
 *
*/

    List<ApplicationDataset> listApplicationDataset = new ArrayList<ApplicationDataset>();

/**
 *  This lists holds all items of class ApplicationObject and its subclasses
 *
*/

    List<ApplicationObject> listApplicationObject = new ArrayList<ApplicationObject>();

/**
 *  This lists holds all items of class ApplicationDifference and its subclasses
 *
*/

    List<ApplicationDifference> listApplicationDifference = new ArrayList<ApplicationDifference>();

/**
 *  This lists holds all items of class ApplicationWarning and its subclasses
 *
*/

    List<ApplicationWarning> listApplicationWarning = new ArrayList<ApplicationWarning>();

/**
 *  This lists holds all items of class Scenario and its subclasses
 *
*/

    List<Scenario> listScenario = new ArrayList<Scenario>();

/**
 *  This lists holds all items of class Country and its subclasses
 *
*/

    List<Country> listCountry = new ArrayList<Country>();

/**
 *  This lists holds all items of class County and its subclasses
 *
*/

    List<County> listCounty = new ArrayList<County>();

/**
 *  This lists holds all items of class ConstituencyType and its subclasses
 *
*/

    List<ConstituencyType> listConstituencyType = new ArrayList<ConstituencyType>();

/**
 *  This lists holds all items of class MapLocation and its subclasses
 *
*/

    List<MapLocation> listMapLocation = new ArrayList<MapLocation>();

/**
 *  This lists holds all items of class Area and its subclasses
 *
*/

    List<Area> listArea = new ArrayList<Area>();

/**
 *  This lists holds all items of class Nuts3 and its subclasses
 *
*/

    List<Nuts3> listNuts3 = new ArrayList<Nuts3>();

/**
 *  This lists holds all items of class Province and its subclasses
 *
*/

    List<Province> listProvince = new ArrayList<Province>();

/**
 *  This lists holds all items of class Shaped and its subclasses
 *
*/

    List<Shaped> listShaped = new ArrayList<Shaped>();

/**
 *  This lists holds all items of class ElectoralDivision and its subclasses
 *
*/

    List<ElectoralDivision> listElectoralDivision = new ArrayList<ElectoralDivision>();

/**
 *  This lists holds all items of class Distance and its subclasses
 *
*/

    List<Distance> listDistance = new ArrayList<Distance>();

/**
 *  This lists holds all items of class DistanceError and its subclasses
 *
*/

    List<DistanceError> listDistanceError = new ArrayList<DistanceError>();

/**
 *  This lists holds all items of class NeighborCounty and its subclasses
 *
*/

    List<NeighborCounty> listNeighborCounty = new ArrayList<NeighborCounty>();

/**
 *  This lists holds all items of class Solution and its subclasses
 *
*/

    List<Solution> listSolution = new ArrayList<Solution>();

/**
 *  This lists holds all items of class SolCounty and its subclasses
 *
*/

    List<SolCounty> listSolCounty = new ArrayList<SolCounty>();

/**
 *  This lists holds all items of class SolTransfer and its subclasses
 *
*/

    List<SolTransfer> listSolTransfer = new ArrayList<SolTransfer>();

/**
 *  This lists holds all items of class SolConstType and its subclasses
 *
*/

    List<SolConstType> listSolConstType = new ArrayList<SolConstType>();

/**
 *  This is the static counter from which all id numbers are generated.It is used by all classes, so that ids are unique over all objects.
 *
*/

    private static int idNr=0;

public int compareTo(ApplicationDataset ds2){
    return id.compareTo(ds2.getId());
}

/**
 *  No-arg constructor for use in TableView
 *
*/

    public ApplicationDataset(){
        super();
    }

/**
 *  Constructor for use in TableView
 *  only one argument: the dataset
 *  other fields are left to null or set to defaults
 *  adds object to the relevant lists in the dataset
 *
*/

    public ApplicationDataset(ApplicationDataset applicationDataset){
        setId(ApplicationDataset.getIdNr());
        setName("");
        addApplicationDataset(this);
    }

/**
 *  General Constructor with all attributes given
 *  attributes from parent come first, others are sorted alphabetically
 *  adds object to the relevant lists in the dataset
 *
*/

    public ApplicationDataset(Boolean dirty,
            Integer id,
            String name,
            Boolean valid){
        setDirty(dirty);
        setId(id);
        setName(name);
        setValid(valid);
        addApplicationDataset(this);
    }

    public Boolean remove(){
        // ignored, you can not remove a dataset like this
        return true;
    }

/**
 *  get attribute dirty
 *
 * @return Boolean
*/

    public Boolean getDirty(){
        return this.dirty;
    }

    public BooleanProperty dirtyWrapperProperty() {
        if (dirtyWrapper == null) {
            dirtyWrapper = new SimpleBooleanProperty();
        }
        dirtyWrapper.set(dirty);
        return dirtyWrapper;
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
 *  get attribute valid
 *
 * @return Boolean
*/

    public Boolean getValid(){
        return this.valid;
    }

    public BooleanProperty validWrapperProperty() {
        if (validWrapper == null) {
            validWrapper = new SimpleBooleanProperty();
        }
        validWrapper.set(valid);
        return validWrapper;
    }

/**
 *  implement the ApplicationObjectInterface
 *
*/

    public ApplicationDataset getApplicationDataset() {
        return this;
    }

    public List<String> getListOfClassNames(){
        return Arrays.asList("ApplicationDifference",
                             "ApplicationWarning",
                             "ConstituencyType",
                             "Country",
                             "County",
                             "Distance",
                             "DistanceError",
                             "ElectoralDivision",
                             "NeighborCounty",
                             "Nuts3",
                             "Province",
                             "Scenario",
                             "SolConstType",
                             "SolCounty",
                             "SolTransfer",
                             "Solution");
    }

/**
 *  Iterator for list of class ApplicationDataset
 *
*/

    public Iterator<ApplicationDataset> getIteratorApplicationDataset(){
        return listApplicationDataset.iterator();
    }

/**
 *  Getter for list of class ApplicationDataset
 *
*/

    public List<ApplicationDataset> getListApplicationDataset(){
        return listApplicationDataset;
    }

/**
 *  reset the list of class ApplicationDataset; use with care, does not call cascades
 *
*/

    public void resetListApplicationDataset(){
        listApplicationDataset = new ArrayList<ApplicationDataset>();
        resetListScenario();
    }

/**
 *  Iterator for list of class ApplicationObject
 *
*/

    public Iterator<ApplicationObject> getIteratorApplicationObject(){
        return listApplicationObject.iterator();
    }

/**
 *  Getter for list of class ApplicationObject
 *
*/

    public List<ApplicationObject> getListApplicationObject(){
        return listApplicationObject;
    }

/**
 *  reset the list of class ApplicationObject; use with care, does not call cascades
 *
*/

    public void resetListApplicationObject(){
        listApplicationObject = new ArrayList<ApplicationObject>();
        resetListApplicationWarning();
        resetListApplicationDifference();
        resetListCountry();
        resetListCounty();
        resetListConstituencyType();
        resetListMapLocation();
        resetListArea();
        resetListNuts3();
        resetListProvince();
        resetListShaped();
        resetListElectoralDivision();
        resetListDistance();
        resetListDistanceError();
        resetListNeighborCounty();
        resetListSolution();
        resetListSolCounty();
        resetListSolTransfer();
        resetListSolConstType();
    }

/**
 *  Iterator for list of class ApplicationDifference
 *
*/

    public Iterator<ApplicationDifference> getIteratorApplicationDifference(){
        return listApplicationDifference.iterator();
    }

/**
 *  Getter for list of class ApplicationDifference
 *
*/

    public List<ApplicationDifference> getListApplicationDifference(){
        return listApplicationDifference;
    }

/**
 *  reset the list of class ApplicationDifference; use with care, does not call cascades
 *
*/

    public void resetListApplicationDifference(){
        listApplicationDifference = new ArrayList<ApplicationDifference>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof ApplicationDifference)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class ApplicationWarning
 *
*/

    public Iterator<ApplicationWarning> getIteratorApplicationWarning(){
        return listApplicationWarning.iterator();
    }

/**
 *  Getter for list of class ApplicationWarning
 *
*/

    public List<ApplicationWarning> getListApplicationWarning(){
        return listApplicationWarning;
    }

/**
 *  reset the list of class ApplicationWarning; use with care, does not call cascades
 *
*/

    public void resetListApplicationWarning(){
        listApplicationWarning = new ArrayList<ApplicationWarning>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof ApplicationWarning)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class Scenario
 *
*/

    public Iterator<Scenario> getIteratorScenario(){
        return listScenario.iterator();
    }

/**
 *  Getter for list of class Scenario
 *
*/

    public List<Scenario> getListScenario(){
        return listScenario;
    }

/**
 *  reset the list of class Scenario; use with care, does not call cascades
 *
*/

    public void resetListScenario(){
        listScenario = new ArrayList<Scenario>();
        List<ApplicationDataset> newListApplicationDataset = new ArrayList<ApplicationDataset>();
        for(ApplicationDataset a:listApplicationDataset){
            if (!(a instanceof Scenario)){
                newListApplicationDataset.add(a);
            }
        }
       listApplicationDataset = newListApplicationDataset;
    }

/**
 *  Iterator for list of class Country
 *
*/

    public Iterator<Country> getIteratorCountry(){
        return listCountry.iterator();
    }

/**
 *  Getter for list of class Country
 *
*/

    public List<Country> getListCountry(){
        return listCountry;
    }

/**
 *  reset the list of class Country; use with care, does not call cascades
 *
*/

    public void resetListCountry(){
        listCountry = new ArrayList<Country>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof Country)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class County
 *
*/

    public Iterator<County> getIteratorCounty(){
        return listCounty.iterator();
    }

/**
 *  Getter for list of class County
 *
*/

    public List<County> getListCounty(){
        return listCounty;
    }

/**
 *  reset the list of class County; use with care, does not call cascades
 *
*/

    public void resetListCounty(){
        listCounty = new ArrayList<County>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof County)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class ConstituencyType
 *
*/

    public Iterator<ConstituencyType> getIteratorConstituencyType(){
        return listConstituencyType.iterator();
    }

/**
 *  Getter for list of class ConstituencyType
 *
*/

    public List<ConstituencyType> getListConstituencyType(){
        return listConstituencyType;
    }

/**
 *  reset the list of class ConstituencyType; use with care, does not call cascades
 *
*/

    public void resetListConstituencyType(){
        listConstituencyType = new ArrayList<ConstituencyType>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof ConstituencyType)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class MapLocation
 *
*/

    public Iterator<MapLocation> getIteratorMapLocation(){
        return listMapLocation.iterator();
    }

/**
 *  Getter for list of class MapLocation
 *
*/

    public List<MapLocation> getListMapLocation(){
        return listMapLocation;
    }

/**
 *  reset the list of class MapLocation; use with care, does not call cascades
 *
*/

    public void resetListMapLocation(){
        listMapLocation = new ArrayList<MapLocation>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof MapLocation)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
        resetListArea();
        resetListNuts3();
        resetListProvince();
        resetListShaped();
        resetListElectoralDivision();
    }

/**
 *  Iterator for list of class Area
 *
*/

    public Iterator<Area> getIteratorArea(){
        return listArea.iterator();
    }

/**
 *  Getter for list of class Area
 *
*/

    public List<Area> getListArea(){
        return listArea;
    }

/**
 *  reset the list of class Area; use with care, does not call cascades
 *
*/

    public void resetListArea(){
        listArea = new ArrayList<Area>();
        List<MapLocation> newListMapLocation = new ArrayList<MapLocation>();
        for(MapLocation a:listMapLocation){
            if (!(a instanceof Area)){
                newListMapLocation.add(a);
            }
        }
       listMapLocation = newListMapLocation;
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof Area)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
        resetListNuts3();
        resetListProvince();
        resetListShaped();
        resetListElectoralDivision();
    }

/**
 *  Iterator for list of class Nuts3
 *
*/

    public Iterator<Nuts3> getIteratorNuts3(){
        return listNuts3.iterator();
    }

/**
 *  Getter for list of class Nuts3
 *
*/

    public List<Nuts3> getListNuts3(){
        return listNuts3;
    }

/**
 *  reset the list of class Nuts3; use with care, does not call cascades
 *
*/

    public void resetListNuts3(){
        listNuts3 = new ArrayList<Nuts3>();
        List<Area> newListArea = new ArrayList<Area>();
        for(Area a:listArea){
            if (!(a instanceof Nuts3)){
                newListArea.add(a);
            }
        }
       listArea = newListArea;
        List<MapLocation> newListMapLocation = new ArrayList<MapLocation>();
        for(MapLocation a:listMapLocation){
            if (!(a instanceof Nuts3)){
                newListMapLocation.add(a);
            }
        }
       listMapLocation = newListMapLocation;
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof Nuts3)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class Province
 *
*/

    public Iterator<Province> getIteratorProvince(){
        return listProvince.iterator();
    }

/**
 *  Getter for list of class Province
 *
*/

    public List<Province> getListProvince(){
        return listProvince;
    }

/**
 *  reset the list of class Province; use with care, does not call cascades
 *
*/

    public void resetListProvince(){
        listProvince = new ArrayList<Province>();
        List<Area> newListArea = new ArrayList<Area>();
        for(Area a:listArea){
            if (!(a instanceof Province)){
                newListArea.add(a);
            }
        }
       listArea = newListArea;
        List<MapLocation> newListMapLocation = new ArrayList<MapLocation>();
        for(MapLocation a:listMapLocation){
            if (!(a instanceof Province)){
                newListMapLocation.add(a);
            }
        }
       listMapLocation = newListMapLocation;
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof Province)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class Shaped
 *
*/

    public Iterator<Shaped> getIteratorShaped(){
        return listShaped.iterator();
    }

/**
 *  Getter for list of class Shaped
 *
*/

    public List<Shaped> getListShaped(){
        return listShaped;
    }

/**
 *  reset the list of class Shaped; use with care, does not call cascades
 *
*/

    public void resetListShaped(){
        listShaped = new ArrayList<Shaped>();
        List<Area> newListArea = new ArrayList<Area>();
        for(Area a:listArea){
            if (!(a instanceof Shaped)){
                newListArea.add(a);
            }
        }
       listArea = newListArea;
        List<MapLocation> newListMapLocation = new ArrayList<MapLocation>();
        for(MapLocation a:listMapLocation){
            if (!(a instanceof Shaped)){
                newListMapLocation.add(a);
            }
        }
       listMapLocation = newListMapLocation;
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof Shaped)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
        resetListElectoralDivision();
    }

/**
 *  Iterator for list of class ElectoralDivision
 *
*/

    public Iterator<ElectoralDivision> getIteratorElectoralDivision(){
        return listElectoralDivision.iterator();
    }

/**
 *  Getter for list of class ElectoralDivision
 *
*/

    public List<ElectoralDivision> getListElectoralDivision(){
        return listElectoralDivision;
    }

/**
 *  reset the list of class ElectoralDivision; use with care, does not call cascades
 *
*/

    public void resetListElectoralDivision(){
        listElectoralDivision = new ArrayList<ElectoralDivision>();
        List<Shaped> newListShaped = new ArrayList<Shaped>();
        for(Shaped a:listShaped){
            if (!(a instanceof ElectoralDivision)){
                newListShaped.add(a);
            }
        }
       listShaped = newListShaped;
        List<Area> newListArea = new ArrayList<Area>();
        for(Area a:listArea){
            if (!(a instanceof ElectoralDivision)){
                newListArea.add(a);
            }
        }
       listArea = newListArea;
        List<MapLocation> newListMapLocation = new ArrayList<MapLocation>();
        for(MapLocation a:listMapLocation){
            if (!(a instanceof ElectoralDivision)){
                newListMapLocation.add(a);
            }
        }
       listMapLocation = newListMapLocation;
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof ElectoralDivision)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class Distance
 *
*/

    public Iterator<Distance> getIteratorDistance(){
        return listDistance.iterator();
    }

/**
 *  Getter for list of class Distance
 *
*/

    public List<Distance> getListDistance(){
        return listDistance;
    }

/**
 *  reset the list of class Distance; use with care, does not call cascades
 *
*/

    public void resetListDistance(){
        listDistance = new ArrayList<Distance>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof Distance)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class DistanceError
 *
*/

    public Iterator<DistanceError> getIteratorDistanceError(){
        return listDistanceError.iterator();
    }

/**
 *  Getter for list of class DistanceError
 *
*/

    public List<DistanceError> getListDistanceError(){
        return listDistanceError;
    }

/**
 *  reset the list of class DistanceError; use with care, does not call cascades
 *
*/

    public void resetListDistanceError(){
        listDistanceError = new ArrayList<DistanceError>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof DistanceError)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class NeighborCounty
 *
*/

    public Iterator<NeighborCounty> getIteratorNeighborCounty(){
        return listNeighborCounty.iterator();
    }

/**
 *  Getter for list of class NeighborCounty
 *
*/

    public List<NeighborCounty> getListNeighborCounty(){
        return listNeighborCounty;
    }

/**
 *  reset the list of class NeighborCounty; use with care, does not call cascades
 *
*/

    public void resetListNeighborCounty(){
        listNeighborCounty = new ArrayList<NeighborCounty>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof NeighborCounty)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class Solution
 *
*/

    public Iterator<Solution> getIteratorSolution(){
        return listSolution.iterator();
    }

/**
 *  Getter for list of class Solution
 *
*/

    public List<Solution> getListSolution(){
        return listSolution;
    }

/**
 *  reset the list of class Solution; use with care, does not call cascades
 *
*/

    public void resetListSolution(){
        listSolution = new ArrayList<Solution>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof Solution)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class SolCounty
 *
*/

    public Iterator<SolCounty> getIteratorSolCounty(){
        return listSolCounty.iterator();
    }

/**
 *  Getter for list of class SolCounty
 *
*/

    public List<SolCounty> getListSolCounty(){
        return listSolCounty;
    }

/**
 *  reset the list of class SolCounty; use with care, does not call cascades
 *
*/

    public void resetListSolCounty(){
        listSolCounty = new ArrayList<SolCounty>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof SolCounty)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class SolTransfer
 *
*/

    public Iterator<SolTransfer> getIteratorSolTransfer(){
        return listSolTransfer.iterator();
    }

/**
 *  Getter for list of class SolTransfer
 *
*/

    public List<SolTransfer> getListSolTransfer(){
        return listSolTransfer;
    }

/**
 *  reset the list of class SolTransfer; use with care, does not call cascades
 *
*/

    public void resetListSolTransfer(){
        listSolTransfer = new ArrayList<SolTransfer>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof SolTransfer)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Iterator for list of class SolConstType
 *
*/

    public Iterator<SolConstType> getIteratorSolConstType(){
        return listSolConstType.iterator();
    }

/**
 *  Getter for list of class SolConstType
 *
*/

    public List<SolConstType> getListSolConstType(){
        return listSolConstType;
    }

/**
 *  reset the list of class SolConstType; use with care, does not call cascades
 *
*/

    public void resetListSolConstType(){
        listSolConstType = new ArrayList<SolConstType>();
        List<ApplicationObject> newListApplicationObject = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:listApplicationObject){
            if (!(a instanceof SolConstType)){
                newListApplicationObject.add(a);
            }
        }
       listApplicationObject = newListApplicationObject;
    }

/**
 *  Generate a new id number, used in constructor calls
 *
*/

    public static int getIdNr() {
        return idNr++;
    }

    public static void setIdNr(int value) {
        idNr = value;
    }

    public int lastIdNr(){
        int res = 0;
        for(ApplicationObject obj:getListApplicationObject()){
            res = Math.max(res,obj.getId());
        }
        return res;
    }

/**
 *  set attribute dirty, mark dataset as dirty, mark dataset as not valid
@param dirty Boolean
 *
*/

    public void setDirty(Boolean dirty){
        this.dirty = dirty;
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
 *  set attribute valid, mark dataset as dirty, mark dataset as not valid
@param valid Boolean
 *
*/

    public void setValid(Boolean valid){
        this.valid = valid;
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
 *  Removing object item of class ApplicationDataset; remove all dependent objects of class ApplicationObject which refer to item through their attribute applicationDataset
 *
*/

    public void cascadeApplicationObjectApplicationDataset(ApplicationDataset item){
        assert item != null;
        List<ApplicationObject> toRemove = new ArrayList<ApplicationObject>();
        for(ApplicationObject a:getListApplicationObject()) {
         if (a.getApplicationDataset() == item) {
            toRemove.add(a);
         }
        }
        for(ApplicationObject b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class County; remove all dependent objects of class NeighborCounty which refer to item through their attribute county1
 *
*/

    public void cascadeNeighborCountyCounty1(County item){
        assert item != null;
        List<NeighborCounty> toRemove = new ArrayList<NeighborCounty>();
        for(NeighborCounty a:getListNeighborCounty()) {
         if (a.getCounty1() == item) {
            toRemove.add(a);
         }
        }
        for(NeighborCounty b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class County; remove all dependent objects of class NeighborCounty which refer to item through their attribute county2
 *
*/

    public void cascadeNeighborCountyCounty2(County item){
        assert item != null;
        List<NeighborCounty> toRemove = new ArrayList<NeighborCounty>();
        for(NeighborCounty a:getListNeighborCounty()) {
         if (a.getCounty2() == item) {
            toRemove.add(a);
         }
        }
        for(NeighborCounty b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class County; remove all dependent objects of class Shaped which refer to item through their attribute county
 *
*/

    public void cascadeShapedCounty(County item){
        assert item != null;
        List<Shaped> toRemove = new ArrayList<Shaped>();
        for(Shaped a:getListShaped()) {
         if (a.getCounty() == item) {
            toRemove.add(a);
         }
        }
        for(Shaped b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class Province; remove all dependent objects of class Shaped which refer to item through their attribute province
 *
*/

    public void cascadeShapedProvince(Province item){
        assert item != null;
        List<Shaped> toRemove = new ArrayList<Shaped>();
        for(Shaped a:getListShaped()) {
         if (a.getProvince() == item) {
            toRemove.add(a);
         }
        }
        for(Shaped b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class MapLocation; remove all dependent objects of class Distance which refer to item through their attribute from
 *
*/

    public void cascadeDistanceFrom(MapLocation item){
        assert item != null;
        List<Distance> toRemove = new ArrayList<Distance>();
        for(Distance a:getListDistance()) {
         if (a.getFrom() == item) {
            toRemove.add(a);
         }
        }
        for(Distance b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class MapLocation; remove all dependent objects of class Distance which refer to item through their attribute to
 *
*/

    public void cascadeDistanceTo(MapLocation item){
        assert item != null;
        List<Distance> toRemove = new ArrayList<Distance>();
        for(Distance a:getListDistance()) {
         if (a.getTo() == item) {
            toRemove.add(a);
         }
        }
        for(Distance b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class MapLocation; remove all dependent objects of class DistanceError which refer to item through their attribute from
 *
*/

    public void cascadeDistanceErrorFrom(MapLocation item){
        assert item != null;
        List<DistanceError> toRemove = new ArrayList<DistanceError>();
        for(DistanceError a:getListDistanceError()) {
         if (a.getFrom() == item) {
            toRemove.add(a);
         }
        }
        for(DistanceError b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class MapLocation; remove all dependent objects of class DistanceError which refer to item through their attribute to
 *
*/

    public void cascadeDistanceErrorTo(MapLocation item){
        assert item != null;
        List<DistanceError> toRemove = new ArrayList<DistanceError>();
        for(DistanceError a:getListDistanceError()) {
         if (a.getTo() == item) {
            toRemove.add(a);
         }
        }
        for(DistanceError b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class County; remove all dependent objects of class SolCounty which refer to item through their attribute county
 *
*/

    public void cascadeSolCountyCounty(County item){
        assert item != null;
        List<SolCounty> toRemove = new ArrayList<SolCounty>();
        for(SolCounty a:getListSolCounty()) {
         if (a.getCounty() == item) {
            toRemove.add(a);
         }
        }
        for(SolCounty b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class Solution; remove all dependent objects of class SolCounty which refer to item through their attribute solution
 *
*/

    public void cascadeSolCountySolution(Solution item){
        assert item != null;
        List<SolCounty> toRemove = new ArrayList<SolCounty>();
        for(SolCounty a:getListSolCounty()) {
         if (a.getSolution() == item) {
            toRemove.add(a);
         }
        }
        for(SolCounty b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class Solution; remove all dependent objects of class SolTransfer which refer to item through their attribute solution
 *
*/

    public void cascadeSolTransferSolution(Solution item){
        assert item != null;
        List<SolTransfer> toRemove = new ArrayList<SolTransfer>();
        for(SolTransfer a:getListSolTransfer()) {
         if (a.getSolution() == item) {
            toRemove.add(a);
         }
        }
        for(SolTransfer b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class County; remove all dependent objects of class SolTransfer which refer to item through their attribute from
 *
*/

    public void cascadeSolTransferFrom(County item){
        assert item != null;
        List<SolTransfer> toRemove = new ArrayList<SolTransfer>();
        for(SolTransfer a:getListSolTransfer()) {
         if (a.getFrom() == item) {
            toRemove.add(a);
         }
        }
        for(SolTransfer b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class County; remove all dependent objects of class SolTransfer which refer to item through their attribute to
 *
*/

    public void cascadeSolTransferTo(County item){
        assert item != null;
        List<SolTransfer> toRemove = new ArrayList<SolTransfer>();
        for(SolTransfer a:getListSolTransfer()) {
         if (a.getTo() == item) {
            toRemove.add(a);
         }
        }
        for(SolTransfer b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class Solution; remove all dependent objects of class SolConstType which refer to item through their attribute solution
 *
*/

    public void cascadeSolConstTypeSolution(Solution item){
        assert item != null;
        List<SolConstType> toRemove = new ArrayList<SolConstType>();
        for(SolConstType a:getListSolConstType()) {
         if (a.getSolution() == item) {
            toRemove.add(a);
         }
        }
        for(SolConstType b:toRemove) {
            b.remove();
        }
    }

/**
 *  Removing object item of class ConstituencyType; remove all dependent objects of class SolConstType which refer to item through their attribute constituencyType
 *
*/

    public void cascadeSolConstTypeConstituencyType(ConstituencyType item){
        assert item != null;
        List<SolConstType> toRemove = new ArrayList<SolConstType>();
        for(SolConstType a:getListSolConstType()) {
         if (a.getConstituencyType() == item) {
            toRemove.add(a);
         }
        }
        for(SolConstType b:toRemove) {
            b.remove();
        }
    }

/**
 *  add an item to the list for class ApplicationDataset
 *
*/

    public void addApplicationDataset(ApplicationDataset applicationDataset){
        assert applicationDataset != null;
        this.listApplicationDataset.add(applicationDataset);
    }

/**
 *  remove an item from the list for class ApplicationDataset
 *
*/

    public Boolean removeApplicationDataset(ApplicationDataset applicationDataset){
        assert applicationDataset != null;
        return this.listApplicationDataset.remove(applicationDataset);
    }

/**
 *  add an item to the list for class ApplicationObject
 *
*/

    public void addApplicationObject(ApplicationObject applicationObject){
        assert applicationObject != null;
        this.listApplicationObject.add(applicationObject);
    }

/**
 *  remove an item from the list for class ApplicationObject
 *
*/

    public Boolean removeApplicationObject(ApplicationObject applicationObject){
        assert applicationObject != null;
        return this.listApplicationObject.remove(applicationObject);
    }

/**
 *  add an item to the list for class ApplicationDifference
 *
*/

    public void addApplicationDifference(ApplicationDifference applicationDifference){
        assert applicationDifference != null;
        this.listApplicationDifference.add(applicationDifference);
    }

/**
 *  remove an item from the list for class ApplicationDifference
 *
*/

    public Boolean removeApplicationDifference(ApplicationDifference applicationDifference){
        assert applicationDifference != null;
        return this.listApplicationDifference.remove(applicationDifference);
    }

/**
 *  add an item to the list for class ApplicationWarning
 *
*/

    public void addApplicationWarning(ApplicationWarning applicationWarning){
        assert applicationWarning != null;
        this.listApplicationWarning.add(applicationWarning);
    }

/**
 *  remove an item from the list for class ApplicationWarning
 *
*/

    public Boolean removeApplicationWarning(ApplicationWarning applicationWarning){
        assert applicationWarning != null;
        return this.listApplicationWarning.remove(applicationWarning);
    }

/**
 *  add an item to the list for class Scenario
 *
*/

    public void addScenario(Scenario scenario){
        assert scenario != null;
        this.listScenario.add(scenario);
    }

/**
 *  remove an item from the list for class Scenario
 *
*/

    public Boolean removeScenario(Scenario scenario){
        assert scenario != null;
        return this.listScenario.remove(scenario);
    }

/**
 *  add an item to the list for class Country
 *
*/

    public void addCountry(Country country){
        assert country != null;
        this.listCountry.add(country);
    }

/**
 *  remove an item from the list for class Country
 *
*/

    public Boolean removeCountry(Country country){
        assert country != null;
        return this.listCountry.remove(country);
    }

/**
 *  add an item to the list for class County
 *
*/

    public void addCounty(County county){
        assert county != null;
        this.listCounty.add(county);
    }

/**
 *  remove an item from the list for class County
 *
*/

    public Boolean removeCounty(County county){
        assert county != null;
        return this.listCounty.remove(county);
    }

/**
 *  add an item to the list for class ConstituencyType
 *
*/

    public void addConstituencyType(ConstituencyType constituencyType){
        assert constituencyType != null;
        this.listConstituencyType.add(constituencyType);
    }

/**
 *  remove an item from the list for class ConstituencyType
 *
*/

    public Boolean removeConstituencyType(ConstituencyType constituencyType){
        assert constituencyType != null;
        return this.listConstituencyType.remove(constituencyType);
    }

/**
 *  add an item to the list for class MapLocation
 *
*/

    public void addMapLocation(MapLocation mapLocation){
        assert mapLocation != null;
        this.listMapLocation.add(mapLocation);
    }

/**
 *  remove an item from the list for class MapLocation
 *
*/

    public Boolean removeMapLocation(MapLocation mapLocation){
        assert mapLocation != null;
        return this.listMapLocation.remove(mapLocation);
    }

/**
 *  add an item to the list for class Area
 *
*/

    public void addArea(Area area){
        assert area != null;
        this.listArea.add(area);
    }

/**
 *  remove an item from the list for class Area
 *
*/

    public Boolean removeArea(Area area){
        assert area != null;
        return this.listArea.remove(area);
    }

/**
 *  add an item to the list for class Nuts3
 *
*/

    public void addNuts3(Nuts3 nuts3){
        assert nuts3 != null;
        this.listNuts3.add(nuts3);
    }

/**
 *  remove an item from the list for class Nuts3
 *
*/

    public Boolean removeNuts3(Nuts3 nuts3){
        assert nuts3 != null;
        return this.listNuts3.remove(nuts3);
    }

/**
 *  add an item to the list for class Province
 *
*/

    public void addProvince(Province province){
        assert province != null;
        this.listProvince.add(province);
    }

/**
 *  remove an item from the list for class Province
 *
*/

    public Boolean removeProvince(Province province){
        assert province != null;
        return this.listProvince.remove(province);
    }

/**
 *  add an item to the list for class Shaped
 *
*/

    public void addShaped(Shaped shaped){
        assert shaped != null;
        this.listShaped.add(shaped);
    }

/**
 *  remove an item from the list for class Shaped
 *
*/

    public Boolean removeShaped(Shaped shaped){
        assert shaped != null;
        return this.listShaped.remove(shaped);
    }

/**
 *  add an item to the list for class ElectoralDivision
 *
*/

    public void addElectoralDivision(ElectoralDivision electoralDivision){
        assert electoralDivision != null;
        this.listElectoralDivision.add(electoralDivision);
    }

/**
 *  remove an item from the list for class ElectoralDivision
 *
*/

    public Boolean removeElectoralDivision(ElectoralDivision electoralDivision){
        assert electoralDivision != null;
        return this.listElectoralDivision.remove(electoralDivision);
    }

/**
 *  add an item to the list for class Distance
 *
*/

    public void addDistance(Distance distance){
        assert distance != null;
        this.listDistance.add(distance);
    }

/**
 *  remove an item from the list for class Distance
 *
*/

    public Boolean removeDistance(Distance distance){
        assert distance != null;
        return this.listDistance.remove(distance);
    }

/**
 *  add an item to the list for class DistanceError
 *
*/

    public void addDistanceError(DistanceError distanceError){
        assert distanceError != null;
        this.listDistanceError.add(distanceError);
    }

/**
 *  remove an item from the list for class DistanceError
 *
*/

    public Boolean removeDistanceError(DistanceError distanceError){
        assert distanceError != null;
        return this.listDistanceError.remove(distanceError);
    }

/**
 *  add an item to the list for class NeighborCounty
 *
*/

    public void addNeighborCounty(NeighborCounty neighborCounty){
        assert neighborCounty != null;
        this.listNeighborCounty.add(neighborCounty);
    }

/**
 *  remove an item from the list for class NeighborCounty
 *
*/

    public Boolean removeNeighborCounty(NeighborCounty neighborCounty){
        assert neighborCounty != null;
        return this.listNeighborCounty.remove(neighborCounty);
    }

/**
 *  add an item to the list for class Solution
 *
*/

    public void addSolution(Solution solution){
        assert solution != null;
        this.listSolution.add(solution);
    }

/**
 *  remove an item from the list for class Solution
 *
*/

    public Boolean removeSolution(Solution solution){
        assert solution != null;
        return this.listSolution.remove(solution);
    }

/**
 *  add an item to the list for class SolCounty
 *
*/

    public void addSolCounty(SolCounty solCounty){
        assert solCounty != null;
        this.listSolCounty.add(solCounty);
    }

/**
 *  remove an item from the list for class SolCounty
 *
*/

    public Boolean removeSolCounty(SolCounty solCounty){
        assert solCounty != null;
        return this.listSolCounty.remove(solCounty);
    }

/**
 *  add an item to the list for class SolTransfer
 *
*/

    public void addSolTransfer(SolTransfer solTransfer){
        assert solTransfer != null;
        this.listSolTransfer.add(solTransfer);
    }

/**
 *  remove an item from the list for class SolTransfer
 *
*/

    public Boolean removeSolTransfer(SolTransfer solTransfer){
        assert solTransfer != null;
        return this.listSolTransfer.remove(solTransfer);
    }

/**
 *  add an item to the list for class SolConstType
 *
*/

    public void addSolConstType(SolConstType solConstType){
        assert solConstType != null;
        this.listSolConstType.add(solConstType);
    }

/**
 *  remove an item from the list for class SolConstType
 *
*/

    public Boolean removeSolConstType(SolConstType solConstType){
        assert solConstType != null;
        return this.listSolConstType.remove(solConstType);
    }

/**
 *  dump all items on the console for debugging
 *
*/

    public void dump(){
        for(ApplicationDifference x:getListApplicationDifference()){
            System.out.println(x);
        }
        for(ApplicationWarning x:getListApplicationWarning()){
            System.out.println(x);
        }
        for(ConstituencyType x:getListConstituencyType()){
            System.out.println(x);
        }
        for(Country x:getListCountry()){
            System.out.println(x);
        }
        for(County x:getListCounty()){
            System.out.println(x);
        }
        for(Distance x:getListDistance()){
            System.out.println(x);
        }
        for(DistanceError x:getListDistanceError()){
            System.out.println(x);
        }
        for(ElectoralDivision x:getListElectoralDivision()){
            System.out.println(x);
        }
        for(NeighborCounty x:getListNeighborCounty()){
            System.out.println(x);
        }
        for(Nuts3 x:getListNuts3()){
            System.out.println(x);
        }
        for(Province x:getListProvince()){
            System.out.println(x);
        }
        for(Scenario x:getListScenario()){
            System.out.println(x);
        }
        for(SolConstType x:getListSolConstType()){
            System.out.println(x);
        }
        for(SolCounty x:getListSolCounty()){
            System.out.println(x);
        }
        for(SolTransfer x:getListSolTransfer()){
            System.out.println(x);
        }
        for(Solution x:getListSolution()){
            System.out.println(x);
        }
    }

    public String getReport(String settings){
        StringWriter out = new StringWriter();
        out.write("<html><head><title>Report</title></head><body>");
        out.write("</body></html>");
        return out.toString();
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
 *  dump all items in XML format to a file
 *
*/

    public void dumpAsXML(String fileName){
        PrintWriter out=null;
        try {
    	      File f = new File(fileName);
    	      out = new PrintWriter(new FileWriter(f));
    	  } catch (IOException e) {
    	      System.out.println("Can not create file: "+fileName);
    	  }
        out.println("<?xml version=\"1.0\" ?>");
        out.println("<body xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"test.xsd\">");
        for(Scenario x:getListScenario()){
            if (x.getClass().equals(Scenario.class)) x.toXML(out);
        }
        for(ApplicationDifference x:getListApplicationDifference()){
            if (x.getClass().equals(ApplicationDifference.class)) x.toXML(out);
        }
        for(ApplicationWarning x:getListApplicationWarning()){
            if (x.getClass().equals(ApplicationWarning.class)) x.toXML(out);
        }
        for(ConstituencyType x:getListConstituencyType()){
            if (x.getClass().equals(ConstituencyType.class)) x.toXML(out);
        }
        for(Country x:getListCountry()){
            if (x.getClass().equals(Country.class)) x.toXML(out);
        }
        for(County x:getListCounty()){
            if (x.getClass().equals(County.class)) x.toXML(out);
        }
        for(Distance x:getListDistance()){
            if (x.getClass().equals(Distance.class)) x.toXML(out);
        }
        for(DistanceError x:getListDistanceError()){
            if (x.getClass().equals(DistanceError.class)) x.toXML(out);
        }
        for(ElectoralDivision x:getListElectoralDivision()){
            if (x.getClass().equals(ElectoralDivision.class)) x.toXML(out);
        }
        for(NeighborCounty x:getListNeighborCounty()){
            if (x.getClass().equals(NeighborCounty.class)) x.toXML(out);
        }
        for(Nuts3 x:getListNuts3()){
            if (x.getClass().equals(Nuts3.class)) x.toXML(out);
        }
        for(Province x:getListProvince()){
            if (x.getClass().equals(Province.class)) x.toXML(out);
        }
        for(SolConstType x:getListSolConstType()){
            if (x.getClass().equals(SolConstType.class)) x.toXML(out);
        }
        for(SolCounty x:getListSolCounty()){
            if (x.getClass().equals(SolCounty.class)) x.toXML(out);
        }
        for(SolTransfer x:getListSolTransfer()){
            if (x.getClass().equals(SolTransfer.class)) x.toXML(out);
        }
        for(Solution x:getListSolution()){
            if (x.getClass().equals(Solution.class)) x.toXML(out);
        }
        out.println("</body>");
        out.close();
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
        return getDirty()+ " " +getId()+ " " +getName()+ " " +getValid();
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
         out.println("<applicationDataset "+ " dirty=\""+toXMLDirty()+"\""+
            " id=\""+toXMLId()+"\""+
            " name=\""+toXMLName()+"\""+
            " valid=\""+toXMLValid()+"\""+" />");
     }

/**
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLDirty(){
        return this.getDirty().toString();
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
 * helper method for toXML(), prcess one attribute
 * probably useless on its own
 * @return String
*/

    String toXMLValid(){
        return this.getValid().toString();
    }

/**
 * compare object to another of the same type, create ApplicationWarnings if they differ
*/

    public void compare(ApplicationDatasetInterface c){
        ApplicationDataset compare = (ApplicationDataset) c;
        System.out.println("Comparing ApplicationDataset");
        compareApplicationWarning(this.getListApplicationWarning(),compare.getListApplicationWarning());
        compareConstituencyType(this.getListConstituencyType(),compare.getListConstituencyType());
        compareCountry(this.getListCountry(),compare.getListCountry());
        compareCounty(this.getListCounty(),compare.getListCounty());
        compareDistance(this.getListDistance(),compare.getListDistance());
        compareDistanceError(this.getListDistanceError(),compare.getListDistanceError());
        compareElectoralDivision(this.getListElectoralDivision(),compare.getListElectoralDivision());
        compareNeighborCounty(this.getListNeighborCounty(),compare.getListNeighborCounty());
        compareNuts3(this.getListNuts3(),compare.getListNuts3());
        compareProvince(this.getListProvince(),compare.getListProvince());
        compareSolConstType(this.getListSolConstType(),compare.getListSolConstType());
        compareSolCounty(this.getListSolCounty(),compare.getListSolCounty());
        compareSolTransfer(this.getListSolTransfer(),compare.getListSolTransfer());
        compareSolution(this.getListSolution(),compare.getListSolution());
        System.out.println("Done Comparing ApplicationDataset");
    }

/**
 * compare two lists of types ApplicationWarning, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareApplicationWarning(List<ApplicationWarning> aList,List<ApplicationWarning> bList){
        System.out.println("Comparing ApplicationWarning");
        for(ApplicationWarning a:aList){
            ApplicationWarning b= ApplicationWarning.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"ApplicationWarning A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"ApplicationWarning A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"ApplicationWarning B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(ApplicationWarning b: bList){
            ApplicationWarning a = ApplicationWarning.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"ApplicationWarning B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types ConstituencyType, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareConstituencyType(List<ConstituencyType> aList,List<ConstituencyType> bList){
        System.out.println("Comparing ConstituencyType");
        for(ConstituencyType a:aList){
            ConstituencyType b= ConstituencyType.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"ConstituencyType A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"ConstituencyType A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"ConstituencyType B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(ConstituencyType b: bList){
            ConstituencyType a = ConstituencyType.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"ConstituencyType B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types Country, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareCountry(List<Country> aList,List<Country> bList){
        System.out.println("Comparing Country");
        for(Country a:aList){
            Country b= Country.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Country A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Country A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Country B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(Country b: bList){
            Country a = Country.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Country B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types County, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareCounty(List<County> aList,List<County> bList){
        System.out.println("Comparing County");
        for(County a:aList){
            County b= County.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"County A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"County A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"County B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(County b: bList){
            County a = County.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"County B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types Distance, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareDistance(List<Distance> aList,List<Distance> bList){
        System.out.println("Comparing Distance");
        for(Distance a:aList){
            Distance b= Distance.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Distance A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Distance A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Distance B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(Distance b: bList){
            Distance a = Distance.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Distance B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types DistanceError, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareDistanceError(List<DistanceError> aList,List<DistanceError> bList){
        System.out.println("Comparing DistanceError");
        for(DistanceError a:aList){
            DistanceError b= DistanceError.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"DistanceError A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"DistanceError A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"DistanceError B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(DistanceError b: bList){
            DistanceError a = DistanceError.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"DistanceError B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types ElectoralDivision, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareElectoralDivision(List<ElectoralDivision> aList,List<ElectoralDivision> bList){
        System.out.println("Comparing ElectoralDivision");
        for(ElectoralDivision a:aList){
            ElectoralDivision b= ElectoralDivision.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"ElectoralDivision A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"ElectoralDivision A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"ElectoralDivision B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(ElectoralDivision b: bList){
            ElectoralDivision a = ElectoralDivision.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"ElectoralDivision B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types NeighborCounty, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareNeighborCounty(List<NeighborCounty> aList,List<NeighborCounty> bList){
        System.out.println("Comparing NeighborCounty");
        for(NeighborCounty a:aList){
            NeighborCounty b= NeighborCounty.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"NeighborCounty A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"NeighborCounty A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"NeighborCounty B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(NeighborCounty b: bList){
            NeighborCounty a = NeighborCounty.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"NeighborCounty B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types Nuts3, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareNuts3(List<Nuts3> aList,List<Nuts3> bList){
        System.out.println("Comparing Nuts3");
        for(Nuts3 a:aList){
            Nuts3 b= Nuts3.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Nuts3 A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Nuts3 A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Nuts3 B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(Nuts3 b: bList){
            Nuts3 a = Nuts3.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Nuts3 B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types Province, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareProvince(List<Province> aList,List<Province> bList){
        System.out.println("Comparing Province");
        for(Province a:aList){
            Province b= Province.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Province A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Province A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Province B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(Province b: bList){
            Province a = Province.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Province B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types SolConstType, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareSolConstType(List<SolConstType> aList,List<SolConstType> bList){
        System.out.println("Comparing SolConstType");
        for(SolConstType a:aList){
            SolConstType b= SolConstType.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"SolConstType A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"SolConstType A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"SolConstType B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(SolConstType b: bList){
            SolConstType a = SolConstType.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"SolConstType B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types SolCounty, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareSolCounty(List<SolCounty> aList,List<SolCounty> bList){
        System.out.println("Comparing SolCounty");
        for(SolCounty a:aList){
            SolCounty b= SolCounty.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"SolCounty A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"SolCounty A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"SolCounty B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(SolCounty b: bList){
            SolCounty a = SolCounty.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"SolCounty B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types SolTransfer, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareSolTransfer(List<SolTransfer> aList,List<SolTransfer> bList){
        System.out.println("Comparing SolTransfer");
        for(SolTransfer a:aList){
            SolTransfer b= SolTransfer.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"SolTransfer A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"SolTransfer A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"SolTransfer B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(SolTransfer b: bList){
            SolTransfer a = SolTransfer.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"SolTransfer B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * compare two lists of types Solution, create AppplicationWarnings for items which are in only one of the lists
 * or for items which are applicationSame(), but not applicationEqual()
*/

    public void compareSolution(List<Solution> aList,List<Solution> bList){
        System.out.println("Comparing Solution");
        for(Solution a:aList){
            Solution b= Solution.find(a,bList);
            if (b == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Solution A",a.prettyString(),DifferenceType.ONLYA);
            } else if (!a.applicationEqual(b)){
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Solution A",a.prettyString(),DifferenceType.DIFFERA);
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Solution B",b.prettyString(),DifferenceType.DIFFERB);
            }
        }
        for(Solution b: bList){
            Solution a = Solution.find(b,aList);
            if (a == null) {
                new ApplicationDifference(this,ApplicationDataset.getIdNr(),"Solution B",b.toString(),DifferenceType.ONLYB);
            }
        }
    }

/**
 * check all objects in dataset for internal consistency, based on multiplicity
 * and restrictions; create applicationWarning if inconsistent
*/

    public void checkAll(){
        checkApplicationWarning(this.getListApplicationWarning());
        checkConstituencyType(this.getListConstituencyType());
        checkCountry(this.getListCountry());
        checkCounty(this.getListCounty());
        checkDistance(this.getListDistance());
        checkDistanceError(this.getListDistanceError());
        checkElectoralDivision(this.getListElectoralDivision());
        checkNeighborCounty(this.getListNeighborCounty());
        checkNuts3(this.getListNuts3());
        checkProvince(this.getListProvince());
        checkScenario(this.getListScenario());
        checkSolConstType(this.getListSolConstType());
        checkSolCounty(this.getListSolCounty());
        checkSolTransfer(this.getListSolTransfer());
        checkSolution(this.getListSolution());
    }

/**
 * helper method for checkAll()
 * @param list List<ApplicationWarning> dataset list of all items of type ApplicationWarning
*/

    public void checkApplicationWarning(List<ApplicationWarning> list){
        for(ApplicationWarning a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<ConstituencyType> dataset list of all items of type ConstituencyType
*/

    public void checkConstituencyType(List<ConstituencyType> list){
        for(ConstituencyType a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<Country> dataset list of all items of type Country
*/

    public void checkCountry(List<Country> list){
        for(Country a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<County> dataset list of all items of type County
*/

    public void checkCounty(List<County> list){
        for(County a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<Distance> dataset list of all items of type Distance
*/

    public void checkDistance(List<Distance> list){
        for(Distance a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<DistanceError> dataset list of all items of type DistanceError
*/

    public void checkDistanceError(List<DistanceError> list){
        for(DistanceError a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<ElectoralDivision> dataset list of all items of type ElectoralDivision
*/

    public void checkElectoralDivision(List<ElectoralDivision> list){
        for(ElectoralDivision a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<NeighborCounty> dataset list of all items of type NeighborCounty
*/

    public void checkNeighborCounty(List<NeighborCounty> list){
        for(NeighborCounty a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<Nuts3> dataset list of all items of type Nuts3
*/

    public void checkNuts3(List<Nuts3> list){
        for(Nuts3 a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<Province> dataset list of all items of type Province
*/

    public void checkProvince(List<Province> list){
        for(Province a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<Scenario> dataset list of all items of type Scenario
*/

    public void checkScenario(List<Scenario> list){
        for(Scenario a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<SolConstType> dataset list of all items of type SolConstType
*/

    public void checkSolConstType(List<SolConstType> list){
        for(SolConstType a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<SolCounty> dataset list of all items of type SolCounty
*/

    public void checkSolCounty(List<SolCounty> list){
        for(SolCounty a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<SolTransfer> dataset list of all items of type SolTransfer
*/

    public void checkSolTransfer(List<SolTransfer> list){
        for(SolTransfer a:list){
            a.check();
        }
    }

/**
 * helper method for checkAll()
 * @param list List<Solution> dataset list of all items of type Solution
*/

    public void checkSolution(List<Solution> list){
        for(Solution a:list){
            a.check();
        }
    }

   public void generateDummies(){
        ApplicationDifference.dummy(this);
        ApplicationWarning.dummy(this);
        ConstituencyType.dummy(this);
        Country.dummy(this);
        County.dummy(this);
        Distance.dummy(this);
        DistanceError.dummy(this);
        ElectoralDivision.dummy(this);
        NeighborCounty.dummy(this);
        Nuts3.dummy(this);
        Province.dummy(this);
        Scenario.dummy(this);
        SolConstType.dummy(this);
        SolCounty.dummy(this);
        SolTransfer.dummy(this);
        Solution.dummy(this);
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
