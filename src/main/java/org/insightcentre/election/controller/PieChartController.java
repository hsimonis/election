package org.insightcentre.election.controller;

import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;

/**
 * Generated at 10:26:59 on 2024-08-11 */
public class PieChartController extends ChartController {
	public static final Double MIN_SLICE_PERCENTAGE = 1.0d;

	@FXML
	private PieChart chart;

	@FXML
	@SuppressWarnings("unchecked")
	private void initialize() {
		ObservableList<String> attributeNames = null;
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("dirty");
		attributeNames.add("valid");
		attributeNames.add("alphaCostFactor");
		attributeNames.add("betaCostFactor");
		attributeNames.add("lowBound");
		attributeNames.add("highBound");
		attributeNames.add("totalPopulation");
		choicesMap.put("Scenario", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("type");
		attributeNames.add("item");
		choicesMap.put("ApplicationDifference", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("classString");
		attributeNames.add("name");
		attributeNames.add("attrString");
		attributeNames.add("item");
		attributeNames.add("type");
		attributeNames.add("limit");
		choicesMap.put("ApplicationWarning", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("nrSeats");
		attributeNames.add("gammaCostFactor");
		choicesMap.put("ConstituencyType", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("shortName");
		attributeNames.add("ident");
		attributeNames.add("centroidX");
		attributeNames.add("centroidY");
		choicesMap.put("MapLocation", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("shortName");
		attributeNames.add("ident");
		attributeNames.add("centroidX");
		attributeNames.add("centroidY");
		attributeNames.add("xMin");
		attributeNames.add("xMax");
		attributeNames.add("yMin");
		attributeNames.add("yMax");
		attributeNames.add("totalPopulation");
		choicesMap.put("Area", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("shortName");
		attributeNames.add("ident");
		attributeNames.add("centroidX");
		attributeNames.add("centroidY");
		attributeNames.add("xMin");
		attributeNames.add("xMax");
		attributeNames.add("yMin");
		attributeNames.add("yMax");
		attributeNames.add("totalPopulation");
		choicesMap.put("Nuts3", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("shortName");
		attributeNames.add("ident");
		attributeNames.add("centroidX");
		attributeNames.add("centroidY");
		attributeNames.add("xMin");
		attributeNames.add("xMax");
		attributeNames.add("yMin");
		attributeNames.add("yMax");
		attributeNames.add("totalPopulation");
		choicesMap.put("Province", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("shortName");
		attributeNames.add("ident");
		attributeNames.add("centroidX");
		attributeNames.add("centroidY");
		attributeNames.add("xMin");
		attributeNames.add("xMax");
		attributeNames.add("yMin");
		attributeNames.add("yMax");
		attributeNames.add("totalPopulation");
		attributeNames.add("nr");
		attributeNames.add("shape");
		choicesMap.put("Shaped", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("shortName");
		attributeNames.add("ident");
		attributeNames.add("centroidX");
		attributeNames.add("centroidY");
		attributeNames.add("xMin");
		attributeNames.add("xMax");
		attributeNames.add("yMin");
		attributeNames.add("yMax");
		attributeNames.add("totalPopulation");
		attributeNames.add("nr");
		attributeNames.add("shape");
		attributeNames.add("nrED");
		choicesMap.put("County", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("shortName");
		attributeNames.add("ident");
		attributeNames.add("centroidX");
		attributeNames.add("centroidY");
		attributeNames.add("xMin");
		attributeNames.add("xMax");
		attributeNames.add("yMin");
		attributeNames.add("yMax");
		attributeNames.add("totalPopulation");
		attributeNames.add("nr");
		attributeNames.add("shape");
		attributeNames.add("edId");
		attributeNames.add("edIdString");
		attributeNames.add("county");
		attributeNames.add("lea");
		choicesMap.put("ElectoralDivision", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("shortName");
		attributeNames.add("ident");
		attributeNames.add("centroidX");
		attributeNames.add("centroidY");
		attributeNames.add("xMin");
		attributeNames.add("xMax");
		attributeNames.add("yMin");
		attributeNames.add("yMax");
		attributeNames.add("totalPopulation");
		attributeNames.add("nr");
		attributeNames.add("shape");
		choicesMap.put("Lea", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("from");
		attributeNames.add("to");
		attributeNames.add("value");
		attributeNames.add("min");
		attributeNames.add("max");
		choicesMap.put("Distance", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("from");
		attributeNames.add("to");
		choicesMap.put("DistanceError", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("county1");
		attributeNames.add("county2");
		choicesMap.put("NeighborCounty", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("nr");
		attributeNames.add("k");
		attributeNames.add("delta");
		attributeNames.add("deltaPercent");
		attributeNames.add("personsPerTD");
		attributeNames.add("minE");
		attributeNames.add("maxE");
		attributeNames.add("weightedAverage");
		attributeNames.add("weightedVariance");
		attributeNames.add("weightedAbsoluteVariation");
		attributeNames.add("minV");
		attributeNames.add("maxV");
		attributeNames.add("range");
		attributeNames.add("totalTransfers");
		attributeNames.add("totalTransferred");
		attributeNames.add("nrConstituencies");
		attributeNames.add("avgSeatsPerConstituency");
		attributeNames.add("timeLimit");
		attributeNames.add("nrThreads");
		attributeNames.add("solutionStatus");
		attributeNames.add("objValue");
		attributeNames.add("lb");
		attributeNames.add("gapPercent");
		attributeNames.add("time");
		choicesMap.put("Solution", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("county");
		attributeNames.add("solution");
		attributeNames.add("population");
		attributeNames.add("fractionalSeats");
		attributeNames.add("transferOut");
		attributeNames.add("transferIn");
		attributeNames.add("effectivePopulation");
		attributeNames.add("constituenciesAssigned");
		attributeNames.add("constTypes");
		attributeNames.add("seatsAssigned");
		attributeNames.add("personsPerSeat");
		attributeNames.add("variation");
		choicesMap.put("SolCounty", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("solution");
		attributeNames.add("from");
		attributeNames.add("to");
		attributeNames.add("value");
		attributeNames.add("percentOfFrom");
		choicesMap.put("SolTransfer", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("name");
		attributeNames.add("solution");
		attributeNames.add("constituencyType");
		attributeNames.add("value");
		attributeNames.add("percent");
		choicesMap.put("SolConstType", attributeNames);
		ObservableList<String> classes = FXCollections.observableArrayList();
		classes.addAll(choicesMap.keySet());
		classChoiceBox.getItems().addAll(classes);
		chart.setLegendSide(Side.LEFT);
	}

	@SuppressWarnings("rawtypes")
	public void drawChart() {
		String className = classChoiceBox.getSelectionModel().getSelectedItem();
		String attributeName = attributeChoiceBox.getSelectionModel().getSelectedItem();
		if (className == null || attributeName == null) {
			return;
		}
		try {
			ObservableList objectList = null;
			if (className.equals("Scenario")) {
				objectList = mainApp.getScenarioData();
			}
			else if (className.equals("ApplicationDifference")) {
				objectList = mainApp.getApplicationDifferenceData();
			}
			else if (className.equals("ApplicationWarning")) {
				objectList = mainApp.getApplicationWarningData();
			}
			else if (className.equals("ConstituencyType")) {
				objectList = mainApp.getConstituencyTypeData();
			}
			else if (className.equals("MapLocation")) {
				objectList = mainApp.getMapLocationData();
			}
			else if (className.equals("Area")) {
				objectList = mainApp.getAreaData();
			}
			else if (className.equals("Nuts3")) {
				objectList = mainApp.getNuts3Data();
			}
			else if (className.equals("Province")) {
				objectList = mainApp.getProvinceData();
			}
			else if (className.equals("Shaped")) {
				objectList = mainApp.getShapedData();
			}
			else if (className.equals("County")) {
				objectList = mainApp.getCountyData();
			}
			else if (className.equals("ElectoralDivision")) {
				objectList = mainApp.getElectoralDivisionData();
			}
			else if (className.equals("Lea")) {
				objectList = mainApp.getLeaData();
			}
			else if (className.equals("Distance")) {
				objectList = mainApp.getDistanceData();
			}
			else if (className.equals("DistanceError")) {
				objectList = mainApp.getDistanceErrorData();
			}
			else if (className.equals("NeighborCounty")) {
				objectList = mainApp.getNeighborCountyData();
			}
			else if (className.equals("Solution")) {
				objectList = mainApp.getSolutionData();
			}
			else if (className.equals("SolCounty")) {
				objectList = mainApp.getSolCountyData();
			}
			else if (className.equals("SolTransfer")) {
				objectList = mainApp.getSolTransferData();
			}
			else if (className.equals("SolConstType")) {
				objectList = mainApp.getSolConstTypeData();
			}
			if (objectList != null) {
				Map<String, Integer> countMap = new HashMap<String, Integer>();
				for (Object obj : objectList) {
					obj = deref(obj,attributeName);
					String attributeValue = obj == null ? "" : obj.toString();
					if (countMap.containsKey(attributeValue)) {
						countMap.put(attributeValue, countMap.get(attributeValue) + 1);
					}
					else {
						countMap.put(attributeValue, 1);
					}
				}
				ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
				Integer others = 0;
				for (String name: countMap.keySet()) {
					Integer count = countMap.get(name);
					Double percentage = ((double) count / objectList.size()) * 100;
					if (percentage < MIN_SLICE_PERCENTAGE) {
						others += count;
					}
					else {
						String label = String.format("%s (%.1f%%)", name, percentage);
						data.add(new PieChart.Data(label, count));
					}
				}
				if (others > 0) {
					Double percentage = ((double) others / objectList.size()) * 100;
					String label = String.format("Others (%.1f%%)", percentage);
					data.add(new PieChart.Data(label, others));
				}
				chart.setData(data);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
