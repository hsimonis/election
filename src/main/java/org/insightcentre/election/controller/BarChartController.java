package org.insightcentre.election.controller;

import framework.ApplicationObjectInterface;
import java.lang.Exception;
import java.lang.Number;
import java.lang.Object;
import java.lang.String;
import java.lang.SuppressWarnings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

/**
 * Generated at 17:04:25 on 2024-08-07 */
public class BarChartController extends ChartController {
	@FXML
	private BarChart<String, Number> chart;

	@FXML
	@SuppressWarnings("unchecked")
	private void initialize() {
		ObservableList<String> attributeNames = FXCollections.observableArrayList();
		attributeNames.add("alphaCostFactor");
		attributeNames.add("betaCostFactor");
		attributeNames.add("lowBound");
		attributeNames.add("highBound");
		attributeNames.add("totalPopulation");
		choicesMap.put("Scenario", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("population");
		choicesMap.put("Country", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("population");
		attributeNames.add("nrED");
		attributeNames.add("centroidX");
		attributeNames.add("centroidY");
		choicesMap.put("County", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("nrSeats");
		attributeNames.add("gammaCostFactor");
		choicesMap.put("ConstituencyType", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("longitude");
		attributeNames.add("latitude");
		choicesMap.put("MapLocation", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("longitude");
		attributeNames.add("latitude");
		attributeNames.add("xMin");
		attributeNames.add("xMax");
		attributeNames.add("yMin");
		attributeNames.add("yMax");
		attributeNames.add("totalPopulation");
		attributeNames.add("totalArea");
		choicesMap.put("Area", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("longitude");
		attributeNames.add("latitude");
		attributeNames.add("xMin");
		attributeNames.add("xMax");
		attributeNames.add("yMin");
		attributeNames.add("yMax");
		attributeNames.add("totalPopulation");
		attributeNames.add("totalArea");
		choicesMap.put("Nuts3", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("longitude");
		attributeNames.add("latitude");
		attributeNames.add("xMin");
		attributeNames.add("xMax");
		attributeNames.add("yMin");
		attributeNames.add("yMax");
		attributeNames.add("totalPopulation");
		attributeNames.add("totalArea");
		choicesMap.put("Province", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("longitude");
		attributeNames.add("latitude");
		attributeNames.add("xMin");
		attributeNames.add("xMax");
		attributeNames.add("yMin");
		attributeNames.add("yMax");
		attributeNames.add("totalPopulation");
		attributeNames.add("totalArea");
		attributeNames.add("nr");
		attributeNames.add("shapeLength");
		attributeNames.add("shapeArea");
		attributeNames.add("populationDensity");
		attributeNames.add("cluster");
		choicesMap.put("Shaped", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("longitude");
		attributeNames.add("latitude");
		attributeNames.add("xMin");
		attributeNames.add("xMax");
		attributeNames.add("yMin");
		attributeNames.add("yMax");
		attributeNames.add("totalPopulation");
		attributeNames.add("totalArea");
		attributeNames.add("nr");
		attributeNames.add("shapeLength");
		attributeNames.add("shapeArea");
		attributeNames.add("populationDensity");
		attributeNames.add("cluster");
		attributeNames.add("edId");
		choicesMap.put("ElectoralDivision", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("value");
		attributeNames.add("min");
		attributeNames.add("max");
		choicesMap.put("Distance", attributeNames);
		attributeNames = FXCollections.observableArrayList();
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
		attributeNames.add("objValue");
		attributeNames.add("lb");
		attributeNames.add("gapPercent");
		attributeNames.add("time");
		choicesMap.put("Solution", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("population");
		attributeNames.add("fractionalSeats");
		attributeNames.add("transferOut");
		attributeNames.add("transferIn");
		attributeNames.add("effectivePopulation");
		attributeNames.add("constituenciesAssigned");
		attributeNames.add("seatsAssigned");
		attributeNames.add("personsPerSeat");
		attributeNames.add("variation");
		choicesMap.put("SolCounty", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("value");
		attributeNames.add("percentOfFrom");
		choicesMap.put("SolTransfer", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		attributeNames.add("value");
		attributeNames.add("percent");
		choicesMap.put("SolConstType", attributeNames);
		attributeNames = FXCollections.observableArrayList();
		ObservableList<String> classes = FXCollections.observableArrayList();
		classes.addAll(choicesMap.keySet());
		classChoiceBox.getItems().addAll(classes);
		chart.setLegendVisible(false);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
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
			else if (className.equals("Country")) {
				objectList = mainApp.getCountryData();
			}
			else if (className.equals("County")) {
				objectList = mainApp.getCountyData();
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
			else if (className.equals("ElectoralDivision")) {
				objectList = mainApp.getElectoralDivisionData();
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
				XYChart.Series series = new XYChart.Series();
				for (Object obj : objectList) {
					String name = ((ApplicationObjectInterface) obj).getName();
					obj = deref(obj,attributeName);
					if (Number.class.isAssignableFrom(obj.getClass())) {
						series.getData().add(new XYChart.Data(name, obj));
					}
				}
				chart.getData().clear();
				chart.getData().add(series);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
