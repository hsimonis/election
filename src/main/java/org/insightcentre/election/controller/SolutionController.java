package org.insightcentre.election.controller;

import framework.gui.AbstractJfxMainWindow;
import framework.gui.Table3Controller;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.reflect.Field;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.insightcentre.election.GeneratedJfxApp;
import org.insightcentre.election.datamodel.Solution;
import org.insightcentre.election.datamodel.SolutionStatus;

/**
 * Generated at 17:04:25 on 2024-08-07 */
public class SolutionController extends Table3Controller {
	@FXML
	private TableView<Solution> table;

	@FXML
	private TableColumn<Solution, String> name;

	@FXML
	private TableColumn<Solution, Integer> nr;

	@FXML
	private TableColumn<Solution, Integer> k;

	@FXML
	private TableColumn<Solution, Integer> delta;

	@FXML
	private TableColumn<Solution, Double> deltaPercent;

	@FXML
	private TableColumn<Solution, Integer> personsPerTD;

	@FXML
	private TableColumn<Solution, Double> minE;

	@FXML
	private TableColumn<Solution, Double> maxE;

	@FXML
	private TableColumn<Solution, Double> weightedAverage;

	@FXML
	private TableColumn<Solution, Double> weightedVariance;

	@FXML
	private TableColumn<Solution, Double> weightedAbsoluteVariation;

	@FXML
	private TableColumn<Solution, Double> minV;

	@FXML
	private TableColumn<Solution, Double> maxV;

	@FXML
	private TableColumn<Solution, Double> range;

	@FXML
	private TableColumn<Solution, Integer> totalTransfers;

	@FXML
	private TableColumn<Solution, Integer> totalTransferred;

	@FXML
	private TableColumn<Solution, Integer> nrConstituencies;

	@FXML
	private TableColumn<Solution, Double> avgSeatsPerConstituency;

	@FXML
	private TableColumn<Solution, Integer> timeLimit;

	@FXML
	private TableColumn<Solution, Integer> nrThreads;

	@FXML
	private TableColumn<Solution, SolutionStatus> solutionStatus;

	@FXML
	private TableColumn<Solution, Double> objValue;

	@FXML
	private TableColumn<Solution, Double> lb;

	@FXML
	private TableColumn<Solution, Double> gapPercent;

	@FXML
	private TableColumn<Solution, Double> time;

	private GeneratedJfxApp mainApp;

	@Override
	public void setMainApp(AbstractJfxMainWindow app) {
		mainApp = (GeneratedJfxApp) app;
		table.setItems(mainApp.getSolutionData());
		ObservableList<SolutionStatus> solutionStatusValues = FXCollections.observableArrayList(SolutionStatus.values());
		solutionStatus.setCellFactory(ComboBoxTableCell.forTableColumn(solutionStatusValues));
		solutionStatus.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setSolutionStatus(event.getNewValue()); mainApp.reset();});
	}

	public TableView<Solution> getTable() {
		return table;
	}

	@FXML
	private void initialize() {
		table.setTableMenuButtonVisible(true);
		table.setOnMouseClicked(event -> {if (event.isControlDown()) {mainApp.showObject(table.getFocusModel().getFocusedItem());}});
		ObservableList<String> choices = FXCollections.observableArrayList();
		choices.add("name");
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		name.setCellFactory(TextFieldTableCell.forTableColumn());
		name.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setName(event.getNewValue()); mainApp.reset();});
		choices.add("nr");
		nr.setCellValueFactory(new PropertyValueFactory<>("nr"));
		nr.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		nr.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setNr(event.getNewValue()); mainApp.reset();});
		choices.add("k");
		k.setCellValueFactory(new PropertyValueFactory<>("k"));
		k.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		k.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setK(event.getNewValue()); mainApp.reset();});
		choices.add("delta");
		delta.setCellValueFactory(new PropertyValueFactory<>("delta"));
		delta.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		delta.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setDelta(event.getNewValue()); mainApp.reset();});
		choices.add("deltaPercent");
		deltaPercent.setCellValueFactory(new PropertyValueFactory<>("deltaPercent"));
		deltaPercent.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		deltaPercent.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setDeltaPercent(event.getNewValue()); mainApp.reset();});
		choices.add("personsPerTD");
		personsPerTD.setCellValueFactory(new PropertyValueFactory<>("personsPerTD"));
		personsPerTD.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		personsPerTD.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setPersonsPerTD(event.getNewValue()); mainApp.reset();});
		choices.add("minE");
		minE.setCellValueFactory(new PropertyValueFactory<>("minE"));
		minE.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		minE.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setMinE(event.getNewValue()); mainApp.reset();});
		choices.add("maxE");
		maxE.setCellValueFactory(new PropertyValueFactory<>("maxE"));
		maxE.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		maxE.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setMaxE(event.getNewValue()); mainApp.reset();});
		choices.add("weightedAverage");
		weightedAverage.setCellValueFactory(new PropertyValueFactory<>("weightedAverage"));
		weightedAverage.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		weightedAverage.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setWeightedAverage(event.getNewValue()); mainApp.reset();});
		choices.add("weightedVariance");
		weightedVariance.setCellValueFactory(new PropertyValueFactory<>("weightedVariance"));
		weightedVariance.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		weightedVariance.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setWeightedVariance(event.getNewValue()); mainApp.reset();});
		choices.add("weightedAbsoluteVariation");
		weightedAbsoluteVariation.setCellValueFactory(new PropertyValueFactory<>("weightedAbsoluteVariation"));
		weightedAbsoluteVariation.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		weightedAbsoluteVariation.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setWeightedAbsoluteVariation(event.getNewValue()); mainApp.reset();});
		choices.add("minV");
		minV.setCellValueFactory(new PropertyValueFactory<>("minV"));
		minV.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		minV.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setMinV(event.getNewValue()); mainApp.reset();});
		choices.add("maxV");
		maxV.setCellValueFactory(new PropertyValueFactory<>("maxV"));
		maxV.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		maxV.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setMaxV(event.getNewValue()); mainApp.reset();});
		choices.add("range");
		range.setCellValueFactory(new PropertyValueFactory<>("range"));
		range.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		range.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setRange(event.getNewValue()); mainApp.reset();});
		choices.add("totalTransfers");
		totalTransfers.setCellValueFactory(new PropertyValueFactory<>("totalTransfers"));
		totalTransfers.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		totalTransfers.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setTotalTransfers(event.getNewValue()); mainApp.reset();});
		choices.add("totalTransferred");
		totalTransferred.setCellValueFactory(new PropertyValueFactory<>("totalTransferred"));
		totalTransferred.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		totalTransferred.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setTotalTransferred(event.getNewValue()); mainApp.reset();});
		choices.add("nrConstituencies");
		nrConstituencies.setCellValueFactory(new PropertyValueFactory<>("nrConstituencies"));
		nrConstituencies.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		nrConstituencies.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setNrConstituencies(event.getNewValue()); mainApp.reset();});
		choices.add("avgSeatsPerConstituency");
		avgSeatsPerConstituency.setCellValueFactory(new PropertyValueFactory<>("avgSeatsPerConstituency"));
		avgSeatsPerConstituency.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		avgSeatsPerConstituency.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setAvgSeatsPerConstituency(event.getNewValue()); mainApp.reset();});
		choices.add("timeLimit");
		timeLimit.setCellValueFactory(new PropertyValueFactory<>("timeLimit"));
		timeLimit.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		timeLimit.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setTimeLimit(event.getNewValue()); mainApp.reset();});
		choices.add("nrThreads");
		nrThreads.setCellValueFactory(new PropertyValueFactory<>("nrThreads"));
		nrThreads.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		nrThreads.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setNrThreads(event.getNewValue()); mainApp.reset();});
		choices.add("solutionStatus");
		solutionStatus.setCellValueFactory(new PropertyValueFactory<>("solutionStatus"));
		choices.add("objValue");
		objValue.setCellValueFactory(new PropertyValueFactory<>("objValue"));
		objValue.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		objValue.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setObjValue(event.getNewValue()); mainApp.reset();});
		choices.add("lb");
		lb.setCellValueFactory(new PropertyValueFactory<>("lb"));
		lb.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		lb.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setLb(event.getNewValue()); mainApp.reset();});
		choices.add("gapPercent");
		gapPercent.setCellValueFactory(new PropertyValueFactory<>("gapPercent"));
		gapPercent.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		gapPercent.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setGapPercent(event.getNewValue()); mainApp.reset();});
		choices.add("time");
		time.setCellValueFactory(new PropertyValueFactory<>("time"));
		time.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		time.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setTime(event.getNewValue()); mainApp.reset();});
		initialize(choices);
	}

	@Override
	public void filter(String attribute, String comparison, String text) {
		table.setItems(mainApp.getSolutionData());
		try {
			ObservableList<Solution> filteredItems = FXCollections.observableArrayList();
			for (Solution item : table.getItems()) {
				String[] fields = attribute.split("\\.");
				Field f = null;
				Object obj = item;
				for (int i = 0; i < fields.length; i++) {
					f = obj.getClass().getField(fields[i]);
					obj = f.get(obj);
				}
				if (obj instanceof Integer && (comparison.equals("less than")||comparison.equals("greater than"))) {
					Integer value = (Integer) obj;
					int comp;
					try {
						comp = Integer.parseInt(text);
					}
					catch (NumberFormatException e) {
						comp = 0;
					}
					if ((comparison.equals("less than") && value < comp) ||(comparison.equals("greater than") && value > comp)) {
						filteredItems.add(item);
					}
				}
				else if (obj instanceof Double && (comparison.equals("less than")||comparison.equals("greater than"))) {
					Double value = (Double) obj;;
					double comp;;
					try {
						comp = Double.parseDouble(text);
					}
					catch (NumberFormatException e) {
						comp = 0.0;
					}
					if ((comparison.equals("less than") && value < comp) ||	(comparison.equals("greater than") && value > comp)) {
						filteredItems.add(item);
					}
				}
				else {
					String value = (obj==null?null:obj.toString());
					if (value != null && ((comparison.equals("equals") && value.equals(text)) ||(comparison.equals("not equals") && !value.equals(text)) ||(comparison.equals("contains") && value.contains(text)) ||(comparison.equals("matches") && value.matches(text)) ||(comparison.equals("starts with") && value.startsWith(text)) ||(comparison.equals("ends with") && value.endsWith(text)) ||(comparison.equals("less than") && value.compareTo(text) < 0) ||(comparison.equals("greater than") && value.compareTo(text) > 0))) {
						filteredItems.add(item);
					}
				}
			}
			table.setItems(filteredItems);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
