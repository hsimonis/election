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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.insightcentre.election.GeneratedJfxApp;
import org.insightcentre.election.datamodel.Area;

/**
 * Generated at 17:04:25 on 2024-08-07 */
public class AreaController extends Table3Controller {
	@FXML
	private TableView<Area> table;

	@FXML
	private TableColumn<Area, String> name;

	@FXML
	private TableColumn<Area, String> shortName;

	@FXML
	private TableColumn<Area, Double> longitude;

	@FXML
	private TableColumn<Area, Double> latitude;

	@FXML
	private TableColumn<Area, String> ident;

	@FXML
	private TableColumn<Area, Double> xMin;

	@FXML
	private TableColumn<Area, Double> xMax;

	@FXML
	private TableColumn<Area, Double> yMin;

	@FXML
	private TableColumn<Area, Double> yMax;

	@FXML
	private TableColumn<Area, Integer> totalPopulation;

	@FXML
	private TableColumn<Area, Double> totalArea;

	private GeneratedJfxApp mainApp;

	@Override
	public void setMainApp(AbstractJfxMainWindow app) {
		mainApp = (GeneratedJfxApp) app;
		table.setItems(mainApp.getAreaData());
	}

	public TableView<Area> getTable() {
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
		choices.add("shortName");
		shortName.setCellValueFactory(new PropertyValueFactory<>("shortName"));
		shortName.setCellFactory(TextFieldTableCell.forTableColumn());
		shortName.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setShortName(event.getNewValue()); mainApp.reset();});
		choices.add("longitude");
		longitude.setCellValueFactory(new PropertyValueFactory<>("longitude"));
		longitude.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.0000")));
		longitude.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setLongitude(event.getNewValue()); mainApp.reset();});
		choices.add("latitude");
		latitude.setCellValueFactory(new PropertyValueFactory<>("latitude"));
		latitude.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.0000")));
		latitude.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setLatitude(event.getNewValue()); mainApp.reset();});
		choices.add("ident");
		ident.setCellValueFactory(new PropertyValueFactory<>("ident"));
		ident.setCellFactory(TextFieldTableCell.forTableColumn());
		ident.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setIdent(event.getNewValue()); mainApp.reset();});
		choices.add("xMin");
		xMin.setCellValueFactory(new PropertyValueFactory<>("xMin"));
		xMin.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.0000")));
		xMin.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setXMin(event.getNewValue()); mainApp.reset();});
		choices.add("xMax");
		xMax.setCellValueFactory(new PropertyValueFactory<>("xMax"));
		xMax.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.0000")));
		xMax.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setXMax(event.getNewValue()); mainApp.reset();});
		choices.add("yMin");
		yMin.setCellValueFactory(new PropertyValueFactory<>("yMin"));
		yMin.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.0000")));
		yMin.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setYMin(event.getNewValue()); mainApp.reset();});
		choices.add("yMax");
		yMax.setCellValueFactory(new PropertyValueFactory<>("yMax"));
		yMax.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.0000")));
		yMax.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setYMax(event.getNewValue()); mainApp.reset();});
		choices.add("totalPopulation");
		totalPopulation.setCellValueFactory(new PropertyValueFactory<>("totalPopulation"));
		totalPopulation.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		totalPopulation.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setTotalPopulation(event.getNewValue()); mainApp.reset();});
		choices.add("totalArea");
		totalArea.setCellValueFactory(new PropertyValueFactory<>("totalArea"));
		totalArea.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		totalArea.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setTotalArea(event.getNewValue()); mainApp.reset();});
		initialize(choices);
	}

	@Override
	public void filter(String attribute, String comparison, String text) {
		table.setItems(mainApp.getAreaData());
		try {
			ObservableList<Area> filteredItems = FXCollections.observableArrayList();
			for (Area item : table.getItems()) {
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
