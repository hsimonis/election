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
import org.insightcentre.election.datamodel.County;
import org.insightcentre.election.datamodel.SolCounty;
import org.insightcentre.election.datamodel.Solution;

/**
 * Generated at 17:04:25 on 2024-08-07 */
public class SolCountyController extends Table3Controller {
	@FXML
	private TableView<SolCounty> table;

	@FXML
	private TableColumn<SolCounty, String> name;

	@FXML
	private TableColumn<SolCounty, County> county;

	@FXML
	private TableColumn<SolCounty, Solution> solution;

	@FXML
	private TableColumn<SolCounty, Integer> population;

	@FXML
	private TableColumn<SolCounty, Double> fractionalSeats;

	@FXML
	private TableColumn<SolCounty, Integer> transferOut;

	@FXML
	private TableColumn<SolCounty, Integer> transferIn;

	@FXML
	private TableColumn<SolCounty, Integer> effectivePopulation;

	@FXML
	private TableColumn<SolCounty, Integer> constituenciesAssigned;

	@FXML
	private TableColumn<SolCounty, String> constTypes;

	@FXML
	private TableColumn<SolCounty, Integer> seatsAssigned;

	@FXML
	private TableColumn<SolCounty, Double> personsPerSeat;

	@FXML
	private TableColumn<SolCounty, Double> variation;

	private GeneratedJfxApp mainApp;

	@Override
	public void setMainApp(AbstractJfxMainWindow app) {
		mainApp = (GeneratedJfxApp) app;
		table.setItems(mainApp.getSolCountyData());
		county.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getCountyData()));
		county.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setCounty(event.getNewValue()); mainApp.reset();});
		solution.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getSolutionData()));
		solution.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setSolution(event.getNewValue()); mainApp.reset();});
	}

	public TableView<SolCounty> getTable() {
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
		choices.add("county");
		county.setCellValueFactory(new PropertyValueFactory<>("county"));
		choices.add("solution");
		solution.setCellValueFactory(new PropertyValueFactory<>("solution"));
		choices.add("population");
		population.setCellValueFactory(new PropertyValueFactory<>("population"));
		population.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		population.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setPopulation(event.getNewValue()); mainApp.reset();});
		choices.add("fractionalSeats");
		fractionalSeats.setCellValueFactory(new PropertyValueFactory<>("fractionalSeats"));
		fractionalSeats.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		fractionalSeats.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setFractionalSeats(event.getNewValue()); mainApp.reset();});
		choices.add("transferOut");
		transferOut.setCellValueFactory(new PropertyValueFactory<>("transferOut"));
		transferOut.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		transferOut.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setTransferOut(event.getNewValue()); mainApp.reset();});
		choices.add("transferIn");
		transferIn.setCellValueFactory(new PropertyValueFactory<>("transferIn"));
		transferIn.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		transferIn.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setTransferIn(event.getNewValue()); mainApp.reset();});
		choices.add("effectivePopulation");
		effectivePopulation.setCellValueFactory(new PropertyValueFactory<>("effectivePopulation"));
		effectivePopulation.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		effectivePopulation.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setEffectivePopulation(event.getNewValue()); mainApp.reset();});
		choices.add("constituenciesAssigned");
		constituenciesAssigned.setCellValueFactory(new PropertyValueFactory<>("constituenciesAssigned"));
		constituenciesAssigned.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		constituenciesAssigned.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setConstituenciesAssigned(event.getNewValue()); mainApp.reset();});
		choices.add("constTypes");
		constTypes.setCellValueFactory(new PropertyValueFactory<>("constTypes"));
		constTypes.setCellFactory(TextFieldTableCell.forTableColumn());
		constTypes.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setConstTypes(event.getNewValue()); mainApp.reset();});
		choices.add("seatsAssigned");
		seatsAssigned.setCellValueFactory(new PropertyValueFactory<>("seatsAssigned"));
		seatsAssigned.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		seatsAssigned.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setSeatsAssigned(event.getNewValue()); mainApp.reset();});
		choices.add("personsPerSeat");
		personsPerSeat.setCellValueFactory(new PropertyValueFactory<>("personsPerSeat"));
		personsPerSeat.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		personsPerSeat.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setPersonsPerSeat(event.getNewValue()); mainApp.reset();});
		choices.add("variation");
		variation.setCellValueFactory(new PropertyValueFactory<>("variation"));
		variation.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		variation.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setVariation(event.getNewValue()); mainApp.reset();});
		initialize(choices);
	}

	@Override
	public void filter(String attribute, String comparison, String text) {
		table.setItems(mainApp.getSolCountyData());
		try {
			ObservableList<SolCounty> filteredItems = FXCollections.observableArrayList();
			for (SolCounty item : table.getItems()) {
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
