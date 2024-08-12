package org.insightcentre.election.controller;

import java.lang.Exception;
import java.lang.Number;
import java.lang.Object;
import java.lang.String;
import java.lang.SuppressWarnings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;

/**
 * Generated at 10:26:59 on 2024-08-11 */
public class ScatterChartController extends ChartXYFilterController {
	@FXML
	private ScatterChart<Number, Number> chart;

	@FXML
	@SuppressWarnings("unchecked")
	private void initialize() {
		ObservableList<String> attributeNames = FXCollections.observableArrayList();
		ObservableList<String> filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		filterNames.add("name");
		filterNames.add("dirty");
		filterNames.add("valid");
		attributeNames.add("alphaCostFactor");
		filterNames.add("alphaCostFactor");
		attributeNames.add("betaCostFactor");
		filterNames.add("betaCostFactor");
		attributeNames.add("lowBound");
		filterNames.add("lowBound");
		attributeNames.add("highBound");
		filterNames.add("highBound");
		attributeNames.add("totalPopulation");
		filterNames.add("totalPopulation");
		choicesMap.put("Scenario", attributeNames);
		filterMap.put("Scenario", filterNames);
		attributeNames = FXCollections.observableArrayList();
		filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		filterNames.add("name");
		filterNames.add("type");
		filterNames.add("item");
		filterNames.add("classString");
		filterNames.add("name");
		filterNames.add("attrString");
		filterNames.add("item");
		filterNames.add("type");
		filterNames.add("limit");
		filterNames.add("name");
		attributeNames.add("nrSeats");
		filterNames.add("nrSeats");
		attributeNames.add("gammaCostFactor");
		filterNames.add("gammaCostFactor");
		choicesMap.put("ConstituencyType", attributeNames);
		filterMap.put("ConstituencyType", filterNames);
		attributeNames = FXCollections.observableArrayList();
		filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		filterNames.add("name");
		filterNames.add("shortName");
		filterNames.add("ident");
		attributeNames.add("centroidX");
		filterNames.add("centroidX");
		attributeNames.add("centroidY");
		filterNames.add("centroidY");
		choicesMap.put("MapLocation", attributeNames);
		filterMap.put("MapLocation", filterNames);
		attributeNames = FXCollections.observableArrayList();
		filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		filterNames.add("name");
		filterNames.add("shortName");
		filterNames.add("ident");
		attributeNames.add("centroidX");
		filterNames.add("centroidX");
		attributeNames.add("centroidY");
		filterNames.add("centroidY");
		attributeNames.add("xMin");
		filterNames.add("xMin");
		attributeNames.add("xMax");
		filterNames.add("xMax");
		attributeNames.add("yMin");
		filterNames.add("yMin");
		attributeNames.add("yMax");
		filterNames.add("yMax");
		attributeNames.add("totalPopulation");
		filterNames.add("totalPopulation");
		choicesMap.put("Area", attributeNames);
		filterMap.put("Area", filterNames);
		attributeNames = FXCollections.observableArrayList();
		filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		filterNames.add("name");
		filterNames.add("shortName");
		filterNames.add("ident");
		attributeNames.add("centroidX");
		filterNames.add("centroidX");
		attributeNames.add("centroidY");
		filterNames.add("centroidY");
		attributeNames.add("xMin");
		filterNames.add("xMin");
		attributeNames.add("xMax");
		filterNames.add("xMax");
		attributeNames.add("yMin");
		filterNames.add("yMin");
		attributeNames.add("yMax");
		filterNames.add("yMax");
		attributeNames.add("totalPopulation");
		filterNames.add("totalPopulation");
		choicesMap.put("Nuts3", attributeNames);
		filterMap.put("Nuts3", filterNames);
		attributeNames = FXCollections.observableArrayList();
		filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		filterNames.add("name");
		filterNames.add("shortName");
		filterNames.add("ident");
		attributeNames.add("centroidX");
		filterNames.add("centroidX");
		attributeNames.add("centroidY");
		filterNames.add("centroidY");
		attributeNames.add("xMin");
		filterNames.add("xMin");
		attributeNames.add("xMax");
		filterNames.add("xMax");
		attributeNames.add("yMin");
		filterNames.add("yMin");
		attributeNames.add("yMax");
		filterNames.add("yMax");
		attributeNames.add("totalPopulation");
		filterNames.add("totalPopulation");
		choicesMap.put("Province", attributeNames);
		filterMap.put("Province", filterNames);
		attributeNames = FXCollections.observableArrayList();
		filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		filterNames.add("name");
		filterNames.add("shortName");
		filterNames.add("ident");
		attributeNames.add("centroidX");
		filterNames.add("centroidX");
		attributeNames.add("centroidY");
		filterNames.add("centroidY");
		attributeNames.add("xMin");
		filterNames.add("xMin");
		attributeNames.add("xMax");
		filterNames.add("xMax");
		attributeNames.add("yMin");
		filterNames.add("yMin");
		attributeNames.add("yMax");
		filterNames.add("yMax");
		attributeNames.add("totalPopulation");
		filterNames.add("totalPopulation");
		attributeNames.add("nr");
		filterNames.add("nr");
		filterNames.add("shape");
		choicesMap.put("Shaped", attributeNames);
		filterMap.put("Shaped", filterNames);
		attributeNames = FXCollections.observableArrayList();
		filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		filterNames.add("name");
		filterNames.add("shortName");
		filterNames.add("ident");
		attributeNames.add("centroidX");
		filterNames.add("centroidX");
		attributeNames.add("centroidY");
		filterNames.add("centroidY");
		attributeNames.add("xMin");
		filterNames.add("xMin");
		attributeNames.add("xMax");
		filterNames.add("xMax");
		attributeNames.add("yMin");
		filterNames.add("yMin");
		attributeNames.add("yMax");
		filterNames.add("yMax");
		attributeNames.add("totalPopulation");
		filterNames.add("totalPopulation");
		attributeNames.add("nr");
		filterNames.add("nr");
		filterNames.add("shape");
		attributeNames.add("nrED");
		filterNames.add("nrED");
		choicesMap.put("County", attributeNames);
		filterMap.put("County", filterNames);
		attributeNames = FXCollections.observableArrayList();
		filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		filterNames.add("name");
		filterNames.add("shortName");
		filterNames.add("ident");
		attributeNames.add("centroidX");
		filterNames.add("centroidX");
		attributeNames.add("centroidY");
		filterNames.add("centroidY");
		attributeNames.add("xMin");
		filterNames.add("xMin");
		attributeNames.add("xMax");
		filterNames.add("xMax");
		attributeNames.add("yMin");
		filterNames.add("yMin");
		attributeNames.add("yMax");
		filterNames.add("yMax");
		attributeNames.add("totalPopulation");
		filterNames.add("totalPopulation");
		attributeNames.add("nr");
		filterNames.add("nr");
		filterNames.add("shape");
		attributeNames.add("edId");
		filterNames.add("edId");
		filterNames.add("edIdString");
		filterNames.add("county");
		filterNames.add("lea");
		choicesMap.put("ElectoralDivision", attributeNames);
		filterMap.put("ElectoralDivision", filterNames);
		attributeNames = FXCollections.observableArrayList();
		filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		filterNames.add("name");
		filterNames.add("shortName");
		filterNames.add("ident");
		attributeNames.add("centroidX");
		filterNames.add("centroidX");
		attributeNames.add("centroidY");
		filterNames.add("centroidY");
		attributeNames.add("xMin");
		filterNames.add("xMin");
		attributeNames.add("xMax");
		filterNames.add("xMax");
		attributeNames.add("yMin");
		filterNames.add("yMin");
		attributeNames.add("yMax");
		filterNames.add("yMax");
		attributeNames.add("totalPopulation");
		filterNames.add("totalPopulation");
		attributeNames.add("nr");
		filterNames.add("nr");
		filterNames.add("shape");
		choicesMap.put("Lea", attributeNames);
		filterMap.put("Lea", filterNames);
		attributeNames = FXCollections.observableArrayList();
		filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		filterNames.add("name");
		filterNames.add("from");
		filterNames.add("to");
		attributeNames.add("value");
		filterNames.add("value");
		attributeNames.add("min");
		filterNames.add("min");
		attributeNames.add("max");
		filterNames.add("max");
		choicesMap.put("Distance", attributeNames);
		filterMap.put("Distance", filterNames);
		attributeNames = FXCollections.observableArrayList();
		filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		filterNames.add("name");
		filterNames.add("from");
		filterNames.add("to");
		filterNames.add("name");
		filterNames.add("county1");
		filterNames.add("county2");
		filterNames.add("name");
		attributeNames.add("nr");
		filterNames.add("nr");
		attributeNames.add("k");
		filterNames.add("k");
		attributeNames.add("delta");
		filterNames.add("delta");
		attributeNames.add("deltaPercent");
		filterNames.add("deltaPercent");
		attributeNames.add("personsPerTD");
		filterNames.add("personsPerTD");
		attributeNames.add("minE");
		filterNames.add("minE");
		attributeNames.add("maxE");
		filterNames.add("maxE");
		attributeNames.add("weightedAverage");
		filterNames.add("weightedAverage");
		attributeNames.add("weightedVariance");
		filterNames.add("weightedVariance");
		attributeNames.add("weightedAbsoluteVariation");
		filterNames.add("weightedAbsoluteVariation");
		attributeNames.add("minV");
		filterNames.add("minV");
		attributeNames.add("maxV");
		filterNames.add("maxV");
		attributeNames.add("range");
		filterNames.add("range");
		attributeNames.add("totalTransfers");
		filterNames.add("totalTransfers");
		attributeNames.add("totalTransferred");
		filterNames.add("totalTransferred");
		attributeNames.add("nrConstituencies");
		filterNames.add("nrConstituencies");
		attributeNames.add("avgSeatsPerConstituency");
		filterNames.add("avgSeatsPerConstituency");
		attributeNames.add("timeLimit");
		filterNames.add("timeLimit");
		attributeNames.add("nrThreads");
		filterNames.add("nrThreads");
		filterNames.add("solutionStatus");
		attributeNames.add("objValue");
		filterNames.add("objValue");
		attributeNames.add("lb");
		filterNames.add("lb");
		attributeNames.add("gapPercent");
		filterNames.add("gapPercent");
		attributeNames.add("time");
		filterNames.add("time");
		choicesMap.put("Solution", attributeNames);
		filterMap.put("Solution", filterNames);
		attributeNames = FXCollections.observableArrayList();
		filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		filterNames.add("name");
		filterNames.add("county");
		filterNames.add("solution");
		attributeNames.add("population");
		filterNames.add("population");
		attributeNames.add("fractionalSeats");
		filterNames.add("fractionalSeats");
		attributeNames.add("transferOut");
		filterNames.add("transferOut");
		attributeNames.add("transferIn");
		filterNames.add("transferIn");
		attributeNames.add("effectivePopulation");
		filterNames.add("effectivePopulation");
		attributeNames.add("constituenciesAssigned");
		filterNames.add("constituenciesAssigned");
		filterNames.add("constTypes");
		attributeNames.add("seatsAssigned");
		filterNames.add("seatsAssigned");
		attributeNames.add("personsPerSeat");
		filterNames.add("personsPerSeat");
		attributeNames.add("variation");
		filterNames.add("variation");
		choicesMap.put("SolCounty", attributeNames);
		filterMap.put("SolCounty", filterNames);
		attributeNames = FXCollections.observableArrayList();
		filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		filterNames.add("name");
		filterNames.add("solution");
		filterNames.add("from");
		filterNames.add("to");
		attributeNames.add("value");
		filterNames.add("value");
		attributeNames.add("percentOfFrom");
		filterNames.add("percentOfFrom");
		choicesMap.put("SolTransfer", attributeNames);
		filterMap.put("SolTransfer", filterNames);
		attributeNames = FXCollections.observableArrayList();
		filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		filterNames.add("name");
		filterNames.add("solution");
		filterNames.add("constituencyType");
		attributeNames.add("value");
		filterNames.add("value");
		attributeNames.add("percent");
		filterNames.add("percent");
		choicesMap.put("SolConstType", attributeNames);
		filterMap.put("SolConstType", filterNames);
		attributeNames = FXCollections.observableArrayList();
		filterNames = FXCollections.observableArrayList();
		filterNames.add(filterNone);
		ObservableList<String> classes = FXCollections.observableArrayList();
		classes.addAll(choicesMap.keySet());
		classChoiceBox.getItems().addAll(classes);
		ObservableList<String> compOps = FXCollections.observableArrayList();
		compOps.addAll(filterComparisons);
		filterComparisonBox.getItems().addAll(compOps);
		chart.setLegendVisible(false);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void drawChart() {
		String className = classChoiceBox.getSelectionModel().getSelectedItem();
		String attributeXName = attributeChoiceBox.getSelectionModel().getSelectedItem();
		String attributeYName = attributeYChoiceBox.getSelectionModel().getSelectedItem();
		String attributeFilterName = attributeFilterBox.getSelectionModel().getSelectedItem();
		String filterComparisonName = filterComparisonBox.getSelectionModel().getSelectedItem();
		String filterTextName = filterTextField.getText();
		String attributeGroupName = attributeGroupBox.getSelectionModel().getSelectedItem();
		if (className == null || attributeXName == null|| attributeYName == null) {
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
				XYChart.Series series = new XYChart.Series();
				for (Object obj : objectList) {
					Object objX = deref(obj,attributeXName);
					Object objY = deref(obj,attributeYName);
					Object objFilter = obj;
					if(attributeFilterName != null && !attributeFilterName.equals(filterNone)) {
						objFilter=deref(obj,attributeFilterName);
					}
					if (keepFiltered(objFilter,attributeFilterName,filterComparisonName,filterTextName) && Number.class.isAssignableFrom(objX.getClass()) && Number.class.isAssignableFrom(objY.getClass())) {
						series.getData().add(new XYChart.Data(objX,objY));
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
