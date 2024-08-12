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
import org.insightcentre.election.datamodel.ElectoralDivision;
import org.insightcentre.election.datamodel.Lea;

/**
 * Generated at 10:26:59 on 2024-08-11 */
public class ElectoralDivisionController extends Table3Controller {
	@FXML
	private TableView<ElectoralDivision> table;

	@FXML
	private TableColumn<ElectoralDivision, String> name;

	@FXML
	private TableColumn<ElectoralDivision, String> shortName;

	@FXML
	private TableColumn<ElectoralDivision, String> ident;

	@FXML
	private TableColumn<ElectoralDivision, Double> centroidX;

	@FXML
	private TableColumn<ElectoralDivision, Double> centroidY;

	@FXML
	private TableColumn<ElectoralDivision, Double> xMin;

	@FXML
	private TableColumn<ElectoralDivision, Double> xMax;

	@FXML
	private TableColumn<ElectoralDivision, Double> yMin;

	@FXML
	private TableColumn<ElectoralDivision, Double> yMax;

	@FXML
	private TableColumn<ElectoralDivision, Integer> totalPopulation;

	@FXML
	private TableColumn<ElectoralDivision, Integer> nr;

	@FXML
	private TableColumn<ElectoralDivision, String> shape;

	@FXML
	private TableColumn<ElectoralDivision, Integer> edId;

	@FXML
	private TableColumn<ElectoralDivision, String> edIdString;

	@FXML
	private TableColumn<ElectoralDivision, County> county;

	@FXML
	private TableColumn<ElectoralDivision, Lea> lea;

	private GeneratedJfxApp mainApp;

	@Override
	public void setMainApp(AbstractJfxMainWindow app) {
		mainApp = (GeneratedJfxApp) app;
		table.setItems(mainApp.getElectoralDivisionData());
		county.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getCountyData()));
		county.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setCounty(event.getNewValue()); mainApp.reset();});
		lea.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getLeaData()));
		lea.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setLea(event.getNewValue()); mainApp.reset();});
	}

	public TableView<ElectoralDivision> getTable() {
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
		choices.add("ident");
		ident.setCellValueFactory(new PropertyValueFactory<>("ident"));
		ident.setCellFactory(TextFieldTableCell.forTableColumn());
		ident.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setIdent(event.getNewValue()); mainApp.reset();});
		choices.add("centroidX");
		centroidX.setCellValueFactory(new PropertyValueFactory<>("centroidX"));
		centroidX.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		centroidX.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setCentroidX(event.getNewValue()); mainApp.reset();});
		choices.add("centroidY");
		centroidY.setCellValueFactory(new PropertyValueFactory<>("centroidY"));
		centroidY.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		centroidY.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setCentroidY(event.getNewValue()); mainApp.reset();});
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
		choices.add("nr");
		nr.setCellValueFactory(new PropertyValueFactory<>("nr"));
		nr.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		nr.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setNr(event.getNewValue()); mainApp.reset();});
		choices.add("shape");
		shape.setCellValueFactory(new PropertyValueFactory<>("shape"));
		shape.setCellFactory(TextFieldTableCell.forTableColumn());
		shape.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setShape(event.getNewValue()); mainApp.reset();});
		choices.add("edId");
		edId.setCellValueFactory(new PropertyValueFactory<>("edId"));
		edId.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		edId.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setEdId(event.getNewValue()); mainApp.reset();});
		choices.add("edIdString");
		edIdString.setCellValueFactory(new PropertyValueFactory<>("edIdString"));
		edIdString.setCellFactory(TextFieldTableCell.forTableColumn());
		edIdString.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setEdIdString(event.getNewValue()); mainApp.reset();});
		choices.add("county");
		county.setCellValueFactory(new PropertyValueFactory<>("county"));
		choices.add("lea");
		lea.setCellValueFactory(new PropertyValueFactory<>("lea"));
		initialize(choices);
	}

	@Override
	public void filter(String attribute, String comparison, String text) {
		table.setItems(mainApp.getElectoralDivisionData());
		try {
			ObservableList<ElectoralDivision> filteredItems = FXCollections.observableArrayList();
			for (ElectoralDivision item : table.getItems()) {
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
