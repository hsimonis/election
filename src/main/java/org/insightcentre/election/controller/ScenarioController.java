package org.insightcentre.election.controller;

import framework.gui.AbstractJfxMainWindow;
import framework.gui.Table3Controller;
import java.lang.Boolean;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.reflect.Field;
import javafx.beans.property.Property;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import org.insightcentre.election.GeneratedJfxApp;
import org.insightcentre.election.datamodel.Scenario;

/**
 * Generated at 10:26:59 on 2024-08-11 */
public class ScenarioController extends Table3Controller {
	@FXML
	private TableView<Scenario> table;

	@FXML
	private TableColumn<Scenario, String> name;

	@FXML
	private TableColumn<Scenario, Boolean> dirty;

	@FXML
	private TableColumn<Scenario, Boolean> valid;

	@FXML
	private TableColumn<Scenario, Integer> alphaCostFactor;

	@FXML
	private TableColumn<Scenario, Integer> betaCostFactor;

	@FXML
	private TableColumn<Scenario, Integer> lowBound;

	@FXML
	private TableColumn<Scenario, Integer> highBound;

	@FXML
	private TableColumn<Scenario, Integer> totalPopulation;

	private GeneratedJfxApp mainApp;

	@Override
	public void setMainApp(AbstractJfxMainWindow app) {
		mainApp = (GeneratedJfxApp) app;
		table.setItems(mainApp.getScenarioData());
	}

	public TableView<Scenario> getTable() {
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
		choices.add("dirty");
		dirty.setCellValueFactory(new DirtyCallback());
		dirty.setCellFactory(CheckBoxTableCell.forTableColumn(dirty));
		choices.add("valid");
		valid.setCellValueFactory(new ValidCallback());
		valid.setCellFactory(CheckBoxTableCell.forTableColumn(valid));
		choices.add("alphaCostFactor");
		alphaCostFactor.setCellValueFactory(new PropertyValueFactory<>("alphaCostFactor"));
		alphaCostFactor.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		alphaCostFactor.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setAlphaCostFactor(event.getNewValue()); mainApp.reset();});
		choices.add("betaCostFactor");
		betaCostFactor.setCellValueFactory(new PropertyValueFactory<>("betaCostFactor"));
		betaCostFactor.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		betaCostFactor.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setBetaCostFactor(event.getNewValue()); mainApp.reset();});
		choices.add("lowBound");
		lowBound.setCellValueFactory(new PropertyValueFactory<>("lowBound"));
		lowBound.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		lowBound.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setLowBound(event.getNewValue()); mainApp.reset();});
		choices.add("highBound");
		highBound.setCellValueFactory(new PropertyValueFactory<>("highBound"));
		highBound.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		highBound.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setHighBound(event.getNewValue()); mainApp.reset();});
		choices.add("totalPopulation");
		totalPopulation.setCellValueFactory(new PropertyValueFactory<>("totalPopulation"));
		totalPopulation.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		totalPopulation.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setTotalPopulation(event.getNewValue()); mainApp.reset();});
		initialize(choices);
	}

	@Override
	public void filter(String attribute, String comparison, String text) {
		table.setItems(mainApp.getScenarioData());
		try {
			ObservableList<Scenario> filteredItems = FXCollections.observableArrayList();
			for (Scenario item : table.getItems()) {
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

	class DirtyCallback implements Callback<TableColumn.CellDataFeatures<Scenario, Boolean>, ObservableValue<Boolean>> {
		@Override
		public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Scenario, Boolean> cellData) {
			Property<Boolean> prop = cellData.getValue().dirtyWrapperProperty();
			prop.addListener(new ChangeListener<Boolean>() {
				@Override
				@SuppressWarnings("rawtypes")
				public void changed(ObservableValue observable, Boolean oldValue, Boolean newValue) {
					cellData.getValue().setDirty(newValue);
				}
			});
			return prop;
		}
	}

	class ValidCallback implements Callback<TableColumn.CellDataFeatures<Scenario, Boolean>, ObservableValue<Boolean>> {
		@Override
		public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Scenario, Boolean> cellData) {
			Property<Boolean> prop = cellData.getValue().validWrapperProperty();
			prop.addListener(new ChangeListener<Boolean>() {
				@Override
				@SuppressWarnings("rawtypes")
				public void changed(ObservableValue observable, Boolean oldValue, Boolean newValue) {
					cellData.getValue().setValid(newValue);
				}
			});
			return prop;
		}
	}
}
