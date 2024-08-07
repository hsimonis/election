package org.insightcentre.election.controller;

import framework.gui.AbstractJfxMainWindow;
import framework.gui.Table3Controller;
import java.lang.Double;
import java.lang.Exception;
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
import org.insightcentre.election.datamodel.Distance;
import org.insightcentre.election.datamodel.MapLocation;

/**
 * Generated at 17:04:25 on 2024-08-07 */
public class DistanceController extends Table3Controller {
	@FXML
	private TableView<Distance> table;

	@FXML
	private TableColumn<Distance, String> name;

	@FXML
	private TableColumn<Distance, MapLocation> from;

	@FXML
	private TableColumn<Distance, MapLocation> to;

	@FXML
	private TableColumn<Distance, Double> value;

	@FXML
	private TableColumn<Distance, Double> min;

	@FXML
	private TableColumn<Distance, Double> max;

	private GeneratedJfxApp mainApp;

	@Override
	public void setMainApp(AbstractJfxMainWindow app) {
		mainApp = (GeneratedJfxApp) app;
		table.setItems(mainApp.getDistanceData());
		from.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getMapLocationData()));
		from.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setFrom(event.getNewValue()); mainApp.reset();});
		to.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getMapLocationData()));
		to.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setTo(event.getNewValue()); mainApp.reset();});
	}

	public TableView<Distance> getTable() {
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
		choices.add("from");
		from.setCellValueFactory(new PropertyValueFactory<>("from"));
		choices.add("to");
		to.setCellValueFactory(new PropertyValueFactory<>("to"));
		choices.add("value");
		value.setCellValueFactory(new PropertyValueFactory<>("value"));
		value.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		value.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setValue(event.getNewValue()); mainApp.reset();});
		choices.add("min");
		min.setCellValueFactory(new PropertyValueFactory<>("min"));
		min.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		min.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setMin(event.getNewValue()); mainApp.reset();});
		choices.add("max");
		max.setCellValueFactory(new PropertyValueFactory<>("max"));
		max.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		max.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setMax(event.getNewValue()); mainApp.reset();});
		initialize(choices);
	}

	@Override
	public void filter(String attribute, String comparison, String text) {
		table.setItems(mainApp.getDistanceData());
		try {
			ObservableList<Distance> filteredItems = FXCollections.observableArrayList();
			for (Distance item : table.getItems()) {
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
