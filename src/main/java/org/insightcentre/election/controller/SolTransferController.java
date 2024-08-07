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
import org.insightcentre.election.datamodel.SolTransfer;
import org.insightcentre.election.datamodel.Solution;

/**
 * Generated at 17:04:25 on 2024-08-07 */
public class SolTransferController extends Table3Controller {
	@FXML
	private TableView<SolTransfer> table;

	@FXML
	private TableColumn<SolTransfer, String> name;

	@FXML
	private TableColumn<SolTransfer, Solution> solution;

	@FXML
	private TableColumn<SolTransfer, County> from;

	@FXML
	private TableColumn<SolTransfer, County> to;

	@FXML
	private TableColumn<SolTransfer, Integer> value;

	@FXML
	private TableColumn<SolTransfer, Double> percentOfFrom;

	private GeneratedJfxApp mainApp;

	@Override
	public void setMainApp(AbstractJfxMainWindow app) {
		mainApp = (GeneratedJfxApp) app;
		table.setItems(mainApp.getSolTransferData());
		solution.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getSolutionData()));
		solution.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setSolution(event.getNewValue()); mainApp.reset();});
		from.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getCountyData()));
		from.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setFrom(event.getNewValue()); mainApp.reset();});
		to.setCellFactory(ComboBoxTableCell.forTableColumn(mainApp.getCountyData()));
		to.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setTo(event.getNewValue()); mainApp.reset();});
	}

	public TableView<SolTransfer> getTable() {
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
		choices.add("solution");
		solution.setCellValueFactory(new PropertyValueFactory<>("solution"));
		choices.add("from");
		from.setCellValueFactory(new PropertyValueFactory<>("from"));
		choices.add("to");
		to.setCellValueFactory(new PropertyValueFactory<>("to"));
		choices.add("value");
		value.setCellValueFactory(new PropertyValueFactory<>("value"));
		value.setCellFactory(TextFieldTableCell.forTableColumn(INTEGER_CONVERTER));
		value.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setValue(event.getNewValue()); mainApp.reset();});
		choices.add("percentOfFrom");
		percentOfFrom.setCellValueFactory(new PropertyValueFactory<>("percentOfFrom"));
		percentOfFrom.setCellFactory(TextFieldTableCell.forTableColumn(getDoubleConverter("#,##0.00")));
		percentOfFrom.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setPercentOfFrom(event.getNewValue()); mainApp.reset();});
		initialize(choices);
	}

	@Override
	public void filter(String attribute, String comparison, String text) {
		table.setItems(mainApp.getSolTransferData());
		try {
			ObservableList<SolTransfer> filteredItems = FXCollections.observableArrayList();
			for (SolTransfer item : table.getItems()) {
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
