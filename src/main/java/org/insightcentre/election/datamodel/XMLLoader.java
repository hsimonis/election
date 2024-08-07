package org.insightcentre.election.datamodel;

import framework.AbstractXMLLoader;
import framework.ApplicationDatasetInterface;
import framework.ApplicationObjectInterface;
import framework.gui.StatusException;
import framework.types.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.*;

public class XMLLoader extends AbstractXMLLoader {
    Scenario base = null;

    public XMLLoader() {
    }
    public ApplicationDatasetInterface loadXML(File filename) {
        try {
            SAXParserFactory configFactory = SAXParserFactory.newInstance();
            SAXParser configParser = configFactory.newSAXParser();
            ConfigHandler configHandler = new ConfigHandler();
            Phase2Handler phase2Handler = new Phase2Handler();
            configParser.parse(filename, configHandler);
            configParser.parse(filename, phase2Handler);
            base = configHandler.getScenario();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        base.setIdNr(base.lastIdNr()+1);
        return base;
    }

public DifferenceType getDifferenceType(String attributeName,
                               Attributes attributes) {
        String e = attributes.getValue(attributeName);
        if (e == null) {
            System.out.println("DifferenceType"+": "+attributeName);
            return null;
        } else {
            return DifferenceType.valueOf(e);
        }
    }
public WarningType getWarningType(String attributeName,
                               Attributes attributes) {
        String e = attributes.getValue(attributeName);
        if (e == null) {
            System.out.println("WarningType"+": "+attributeName);
            return null;
        } else {
            return WarningType.valueOf(e);
        }
    }
public SolutionStatus getSolutionStatus(String attributeName,
                               Attributes attributes) {
        String e = attributes.getValue(attributeName);
        if (e == null) {
            System.out.println("SolutionStatus"+": "+attributeName);
            return null;
        } else {
            return SolutionStatus.valueOf(e);
        }
    }
public SolverType getSolverType(String attributeName,
                               Attributes attributes) {
        String e = attributes.getValue(attributeName);
        if (e == null) {
            System.out.println("SolverType"+": "+attributeName);
            return null;
        } else {
            return SolverType.valueOf(e);
        }
    }
    public ApplicationDataset getApplicationDataset(String attributeName,
                               Attributes attributes) {
        return (ApplicationDataset) find(getId(attributeName,attributes));
    }

    public List<ApplicationDataset> getApplicationDatasetCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<ApplicationDataset> res = new ArrayList<ApplicationDataset>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((ApplicationDataset) find(id));
            }
        }
        return res;
    }

    public ApplicationDifference getApplicationDifference(String attributeName,
                               Attributes attributes) {
        return (ApplicationDifference) find(getId(attributeName,attributes));
    }

    public List<ApplicationDifference> getApplicationDifferenceCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<ApplicationDifference> res = new ArrayList<ApplicationDifference>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((ApplicationDifference) find(id));
            }
        }
        return res;
    }

    public ApplicationObject getApplicationObject(String attributeName,
                               Attributes attributes) {
        return (ApplicationObject) find(getId(attributeName,attributes));
    }

    public List<ApplicationObject> getApplicationObjectCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<ApplicationObject> res = new ArrayList<ApplicationObject>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((ApplicationObject) find(id));
            }
        }
        return res;
    }

    public ApplicationWarning getApplicationWarning(String attributeName,
                               Attributes attributes) {
        return (ApplicationWarning) find(getId(attributeName,attributes));
    }

    public List<ApplicationWarning> getApplicationWarningCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<ApplicationWarning> res = new ArrayList<ApplicationWarning>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((ApplicationWarning) find(id));
            }
        }
        return res;
    }

    public Area getArea(String attributeName,
                               Attributes attributes) {
        return (Area) find(getId(attributeName,attributes));
    }

    public List<Area> getAreaCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<Area> res = new ArrayList<Area>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((Area) find(id));
            }
        }
        return res;
    }

    public ConstituencyType getConstituencyType(String attributeName,
                               Attributes attributes) {
        return (ConstituencyType) find(getId(attributeName,attributes));
    }

    public List<ConstituencyType> getConstituencyTypeCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<ConstituencyType> res = new ArrayList<ConstituencyType>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((ConstituencyType) find(id));
            }
        }
        return res;
    }

    public Country getCountry(String attributeName,
                               Attributes attributes) {
        return (Country) find(getId(attributeName,attributes));
    }

    public List<Country> getCountryCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<Country> res = new ArrayList<Country>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((Country) find(id));
            }
        }
        return res;
    }

    public County getCounty(String attributeName,
                               Attributes attributes) {
        return (County) find(getId(attributeName,attributes));
    }

    public List<County> getCountyCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<County> res = new ArrayList<County>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((County) find(id));
            }
        }
        return res;
    }

    public Distance getDistance(String attributeName,
                               Attributes attributes) {
        return (Distance) find(getId(attributeName,attributes));
    }

    public List<Distance> getDistanceCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<Distance> res = new ArrayList<Distance>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((Distance) find(id));
            }
        }
        return res;
    }

    public DistanceError getDistanceError(String attributeName,
                               Attributes attributes) {
        return (DistanceError) find(getId(attributeName,attributes));
    }

    public List<DistanceError> getDistanceErrorCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<DistanceError> res = new ArrayList<DistanceError>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((DistanceError) find(id));
            }
        }
        return res;
    }

    public ElectoralDivision getElectoralDivision(String attributeName,
                               Attributes attributes) {
        return (ElectoralDivision) find(getId(attributeName,attributes));
    }

    public List<ElectoralDivision> getElectoralDivisionCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<ElectoralDivision> res = new ArrayList<ElectoralDivision>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((ElectoralDivision) find(id));
            }
        }
        return res;
    }

    public MapLocation getMapLocation(String attributeName,
                               Attributes attributes) {
        return (MapLocation) find(getId(attributeName,attributes));
    }

    public List<MapLocation> getMapLocationCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<MapLocation> res = new ArrayList<MapLocation>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((MapLocation) find(id));
            }
        }
        return res;
    }

    public NeighborCounty getNeighborCounty(String attributeName,
                               Attributes attributes) {
        return (NeighborCounty) find(getId(attributeName,attributes));
    }

    public List<NeighborCounty> getNeighborCountyCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<NeighborCounty> res = new ArrayList<NeighborCounty>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((NeighborCounty) find(id));
            }
        }
        return res;
    }

    public Nuts3 getNuts3(String attributeName,
                               Attributes attributes) {
        return (Nuts3) find(getId(attributeName,attributes));
    }

    public List<Nuts3> getNuts3CollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<Nuts3> res = new ArrayList<Nuts3>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((Nuts3) find(id));
            }
        }
        return res;
    }

    public Province getProvince(String attributeName,
                               Attributes attributes) {
        return (Province) find(getId(attributeName,attributes));
    }

    public List<Province> getProvinceCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<Province> res = new ArrayList<Province>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((Province) find(id));
            }
        }
        return res;
    }

    public Scenario getScenario(String attributeName,
                               Attributes attributes) {
        return (Scenario) find(getId(attributeName,attributes));
    }

    public List<Scenario> getScenarioCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<Scenario> res = new ArrayList<Scenario>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((Scenario) find(id));
            }
        }
        return res;
    }

    public Shaped getShaped(String attributeName,
                               Attributes attributes) {
        return (Shaped) find(getId(attributeName,attributes));
    }

    public List<Shaped> getShapedCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<Shaped> res = new ArrayList<Shaped>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((Shaped) find(id));
            }
        }
        return res;
    }

    public SolConstType getSolConstType(String attributeName,
                               Attributes attributes) {
        return (SolConstType) find(getId(attributeName,attributes));
    }

    public List<SolConstType> getSolConstTypeCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<SolConstType> res = new ArrayList<SolConstType>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((SolConstType) find(id));
            }
        }
        return res;
    }

    public SolCounty getSolCounty(String attributeName,
                               Attributes attributes) {
        return (SolCounty) find(getId(attributeName,attributes));
    }

    public List<SolCounty> getSolCountyCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<SolCounty> res = new ArrayList<SolCounty>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((SolCounty) find(id));
            }
        }
        return res;
    }

    public SolTransfer getSolTransfer(String attributeName,
                               Attributes attributes) {
        return (SolTransfer) find(getId(attributeName,attributes));
    }

    public List<SolTransfer> getSolTransferCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<SolTransfer> res = new ArrayList<SolTransfer>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((SolTransfer) find(id));
            }
        }
        return res;
    }

    public Solution getSolution(String attributeName,
                               Attributes attributes) {
        return (Solution) find(getId(attributeName,attributes));
    }

    public List<Solution> getSolutionCollectionFromIds(String attributeName,
                                     Attributes attributes) {
        String e = attributes.getValue(attributeName);
        String[] words = e.split(" ");
        List<Solution> res = new ArrayList<Solution>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                int id = Integer.parseInt(words[i].substring(3));
                res.add((Solution) find(id));
            }
        }
        return res;
    }

    private class ConfigHandler extends DefaultHandler {
        private int numNodes = 0;
        public Scenario getScenario() {
            return base;
        }

        public void startDocument() {
            System.out.println("Reading XML Document, Pass 1");
        }

        public void endDocument() {
            System.out.println("Pass 1 complete");
        }

        public void processingInstruction(String target, String data) {
            System.out.println("AssignableProcess target" + target + " data " + data);
        }
        public void startElement(String uri,
                                 String localname, String qname,
                                 Attributes attributes) {
            if (qname.equals("body")) {
            } else if (qname.equals("scenario")) {
                base = new Scenario(false,
                        getId("id", attributes),
                        getString("name", attributes, "dummy"),
                        getBoolean("valid",attributes,false),
                        getInteger("alphaCostFactor",attributes,0),
                        getInteger("betaCostFactor",attributes,0),
                        getInteger("highBound",attributes,0),
                        getInteger("lowBound",attributes,0),
                        getInteger("totalPopulation",attributes,0)
                              );
            } else if (qname.equals("applicationDifference")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new ApplicationDifference(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getString("item",attributes,""),
                        null
                        ));
            } else if (qname.equals("applicationWarning")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new ApplicationWarning(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getString("attrString",attributes,""),
                        getString("classString",attributes,""),
                        getString("item",attributes,""),
                        getString("limit",attributes,""),
                        null
                        ));
            } else if (qname.equals("constituencyType")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new ConstituencyType(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getInteger("gammaCostFactor",attributes,0),
                        getInteger("nrSeats",attributes,0)
                        ));
            } else if (qname.equals("country")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new Country(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getInteger("population",attributes,0)
                        ));
            } else if (qname.equals("county")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new County(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getDouble("centroidX",attributes,0.0),
                        getDouble("centroidY",attributes,0.0),
                        getInteger("nrED",attributes,0),
                        getInteger("population",attributes,0)
                        ));
            } else if (qname.equals("distance")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new Distance(base,
                        id,
                        getString("name", attributes, "dummy"),
                        null,
                        getDouble("max",attributes,0.0),
                        getDouble("min",attributes,0.0),
                        null,
                        getDouble("value",attributes,0.0)
                        ));
            } else if (qname.equals("distanceError")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new DistanceError(base,
                        id,
                        getString("name", attributes, "dummy"),
                        null,
                        null
                        ));
            } else if (qname.equals("electoralDivision")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new ElectoralDivision(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getString("ident",attributes,""),
                        getDouble("latitude",attributes,0.0),
                        getDouble("longitude",attributes,0.0),
                        getString("shortName",attributes,""),
                        getDouble("totalArea",attributes,0.0),
                        getInteger("totalPopulation",attributes,0),
                        getDouble("xMax",attributes,0.0),
                        getDouble("xMin",attributes,0.0),
                        getDouble("yMax",attributes,0.0),
                        getDouble("yMin",attributes,0.0),
                        getInteger("cluster",attributes,0),
                        null,
                        getInteger("nr",attributes,0),
                        getDouble("populationDensity",attributes,0.0),
                        null,
                        getString("shape",attributes,""),
                        getDouble("shapeArea",attributes,0.0),
                        getDouble("shapeLength",attributes,0.0),
                        getInteger("edId",attributes,0),
                        getString("edIdString",attributes,"")
                        ));
            } else if (qname.equals("neighborCounty")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new NeighborCounty(base,
                        id,
                        getString("name", attributes, "dummy"),
                        null,
                        null
                        ));
            } else if (qname.equals("nuts3")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new Nuts3(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getString("ident",attributes,""),
                        getDouble("latitude",attributes,0.0),
                        getDouble("longitude",attributes,0.0),
                        getString("shortName",attributes,""),
                        getDouble("totalArea",attributes,0.0),
                        getInteger("totalPopulation",attributes,0),
                        getDouble("xMax",attributes,0.0),
                        getDouble("xMin",attributes,0.0),
                        getDouble("yMax",attributes,0.0),
                        getDouble("yMin",attributes,0.0)
                        ));
            } else if (qname.equals("province")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new Province(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getString("ident",attributes,""),
                        getDouble("latitude",attributes,0.0),
                        getDouble("longitude",attributes,0.0),
                        getString("shortName",attributes,""),
                        getDouble("totalArea",attributes,0.0),
                        getInteger("totalPopulation",attributes,0),
                        getDouble("xMax",attributes,0.0),
                        getDouble("xMin",attributes,0.0),
                        getDouble("yMax",attributes,0.0),
                        getDouble("yMin",attributes,0.0)
                        ));
            } else if (qname.equals("solConstType")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new SolConstType(base,
                        id,
                        getString("name", attributes, "dummy"),
                        null,
                        getDouble("percent",attributes,0.0),
                        null,
                        getInteger("value",attributes,0)
                        ));
            } else if (qname.equals("solCounty")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new SolCounty(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getString("constTypes",attributes,""),
                        getInteger("constituenciesAssigned",attributes,0),
                        null,
                        getInteger("effectivePopulation",attributes,0),
                        getDouble("fractionalSeats",attributes,0.0),
                        getDouble("personsPerSeat",attributes,0.0),
                        getInteger("population",attributes,0),
                        getInteger("seatsAssigned",attributes,0),
                        null,
                        getInteger("transferIn",attributes,0),
                        getInteger("transferOut",attributes,0),
                        getDouble("variation",attributes,0.0)
                        ));
            } else if (qname.equals("solTransfer")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new SolTransfer(base,
                        id,
                        getString("name", attributes, "dummy"),
                        null,
                        getDouble("percentOfFrom",attributes,0.0),
                        null,
                        null,
                        getInteger("value",attributes,0)
                        ));
            } else if (qname.equals("solution")) {
                assert (base != null);
                int id = getId("id", attributes);
                store(id, new Solution(base,
                        id,
                        getString("name", attributes, "dummy"),
                        getDouble("avgSeatsPerConstituency",attributes,0.0),
                        getInteger("delta",attributes,0),
                        getDouble("deltaPercent",attributes,0.0),
                        getDouble("gapPercent",attributes,0.0),
                        getInteger("k",attributes,0),
                        getDouble("lb",attributes,0.0),
                        getDouble("maxE",attributes,0.0),
                        getDouble("maxV",attributes,0.0),
                        getDouble("minE",attributes,0.0),
                        getDouble("minV",attributes,0.0),
                        getInteger("nr",attributes,0),
                        getInteger("nrConstituencies",attributes,0),
                        getInteger("nrThreads",attributes,0),
                        getDouble("objValue",attributes,0.0),
                        getInteger("personsPerTD",attributes,0),
                        getDouble("range",attributes,0.0),
                        null,
                        getDouble("time",attributes,0.0),
                        getInteger("timeLimit",attributes,0),
                        getInteger("totalTransferred",attributes,0),
                        getInteger("totalTransfers",attributes,0),
                        getDouble("weightedAbsoluteVariation",attributes,0.0),
                        getDouble("weightedAverage",attributes,0.0),
                        getDouble("weightedVariance",attributes,0.0)
                        ));
            } else {
                System.out.println("Element Structure " + qname);
                numNodes++;
            }
        }
    }
    private class Phase2Handler extends DefaultHandler {
        private int numNodes = 0;
        public Scenario getScenario() {
            return base;
        }

        public void startDocument() {
            System.out.println("Reading XML Document, Pass 2");
        }

        public void endDocument() {
            System.out.println("Pass 2 complete");
        }

        public void processingInstruction(String target, String data) {
            System.out.println("AssignableProcess target" + target + " data " + data);
        }
        public void startElement(String uri,
                                 String localname, String qname,
                                 Attributes attributes) {
            if (qname.equals("body")) {
            } else if (qname.equals("scenario")) {
                assert (base != null);
                int id = getId("id", attributes);
                Scenario item = (Scenario) base;
            } else if (qname.equals("applicationDifference")) {
                assert (base != null);
                int id = getId("id", attributes);
                ApplicationDifference item = (ApplicationDifference) find(id);
                 item.setType(getDifferenceType("type",attributes));
            } else if (qname.equals("applicationWarning")) {
                assert (base != null);
                int id = getId("id", attributes);
                ApplicationWarning item = (ApplicationWarning) find(id);
                 item.setType(getWarningType("type",attributes));
            } else if (qname.equals("constituencyType")) {
                assert (base != null);
                int id = getId("id", attributes);
                ConstituencyType item = (ConstituencyType) find(id);
            } else if (qname.equals("country")) {
                assert (base != null);
                int id = getId("id", attributes);
                Country item = (Country) find(id);
            } else if (qname.equals("county")) {
                assert (base != null);
                int id = getId("id", attributes);
                County item = (County) find(id);
            } else if (qname.equals("distance")) {
                assert (base != null);
                int id = getId("id", attributes);
                Distance item = (Distance) find(id);
                 item.setFrom(getMapLocation("from",attributes));
                 item.setTo(getMapLocation("to",attributes));
            } else if (qname.equals("distanceError")) {
                assert (base != null);
                int id = getId("id", attributes);
                DistanceError item = (DistanceError) find(id);
                 item.setFrom(getMapLocation("from",attributes));
                 item.setTo(getMapLocation("to",attributes));
            } else if (qname.equals("electoralDivision")) {
                assert (base != null);
                int id = getId("id", attributes);
                ElectoralDivision item = (ElectoralDivision) find(id);
                 item.setCounty(getCounty("county",attributes));
                 item.setProvince(getProvince("province",attributes));
            } else if (qname.equals("neighborCounty")) {
                assert (base != null);
                int id = getId("id", attributes);
                NeighborCounty item = (NeighborCounty) find(id);
                 item.setCounty1(getCounty("county1",attributes));
                 item.setCounty2(getCounty("county2",attributes));
            } else if (qname.equals("nuts3")) {
                assert (base != null);
                int id = getId("id", attributes);
                Nuts3 item = (Nuts3) find(id);
            } else if (qname.equals("province")) {
                assert (base != null);
                int id = getId("id", attributes);
                Province item = (Province) find(id);
            } else if (qname.equals("solConstType")) {
                assert (base != null);
                int id = getId("id", attributes);
                SolConstType item = (SolConstType) find(id);
                 item.setConstituencyType(getConstituencyType("constituencyType",attributes));
                 item.setSolution(getSolution("solution",attributes));
            } else if (qname.equals("solCounty")) {
                assert (base != null);
                int id = getId("id", attributes);
                SolCounty item = (SolCounty) find(id);
                 item.setCounty(getCounty("county",attributes));
                 item.setSolution(getSolution("solution",attributes));
            } else if (qname.equals("solTransfer")) {
                assert (base != null);
                int id = getId("id", attributes);
                SolTransfer item = (SolTransfer) find(id);
                 item.setFrom(getCounty("from",attributes));
                 item.setSolution(getSolution("solution",attributes));
                 item.setTo(getCounty("to",attributes));
            } else if (qname.equals("solution")) {
                assert (base != null);
                int id = getId("id", attributes);
                Solution item = (Solution) find(id);
                 item.setSolutionStatus(getSolutionStatus("solutionStatus",attributes));
            } else {
                System.out.println("Element Structure " + qname);
                numNodes++;
            }
        }
    }


}
