package org.insightcentre.election.controller;

import framework.gui.AbstractJfxMainWindow;
import framework.gui.Table3Controller;
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
import org.insightcentre.election.datamodel.ApplicationWarning;
import org.insightcentre.election.datamodel.WarningType;

/**
 * Generated at 10:26:59 on 2024-08-11 */
public class ApplicationWarningController extends Table3Controller {
	@FXML
	private TableView<ApplicationWarning> table;

	@FXML
	private TableColumn<ApplicationWarning, String> classString;

	@FXML
	private TableColumn<ApplicationWarning, String> name;

	@FXML
	private TableColumn<ApplicationWarning, String> attrString;

	@FXML
	private TableColumn<ApplicationWarning, String> item;

	@FXML
	private TableColumn<ApplicationWarning, WarningType> type;

	@FXML
	private TableColumn<ApplicationWarning, String> limit;

	private GeneratedJfxApp mainApp;

	@Override
	public void setMainApp(AbstractJfxMainWindow app) {
		mainApp = (GeneratedJfxApp) app;
		table.setItems(mainApp.getApplicationWarningData());
		ObservableList<WarningType> typeValues = FXCollections.observableArrayList(WarningType.values());
		type.setCellFactory(ComboBoxTableCell.forTableColumn(typeValues));
		type.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setType(event.getNewValue()); mainApp.reset();});
	}

	public TableView<ApplicationWarning> getTable() {
		return table;
	}

	@FXML
	private void initialize() {
		table.setTableMenuButtonVisible(true);
		table.setOnMouseClicked(event -> {if (event.isControlDown()) {mainApp.showObject(table.getFocusModel().getFocusedItem());}});
		ObservableList<String> choices = FXCollections.observableArrayList();
		choices.add("classString");
		classString.setCellValueFactory(new PropertyValueFactory<>("classString"));
		classString.setCellFactory(TextFieldTableCell.forTableColumn());
		classString.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setClassString(event.getNewValue()); mainApp.reset();});
		choices.add("name");
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		name.setCellFactory(TextFieldTableCell.forTableColumn());
		name.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setName(event.getNewValue()); mainApp.reset();});
		choices.add("attrString");
		attrString.setCellValueFactory(new PropertyValueFactory<>("attrString"));
		attrString.setCellFactory(TextFieldTableCell.forTableColumn());
		attrString.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setAttrString(event.getNewValue()); mainApp.reset();});
		choices.add("item");
		item.setCellValueFactory(new PropertyValueFactory<>("item"));
		item.setCellFactory(TextFieldTableCell.forTableColumn());
		item.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setItem(event.getNewValue()); mainApp.reset();});
		choices.add("type");
		type.setCellValueFactory(new PropertyValueFactory<>("type"));
		choices.add("limit");
		limit.setCellValueFactory(new PropertyValueFactory<>("limit"));
		limit.setCellFactory(TextFieldTableCell.forTableColumn());
		limit.setOnEditCommit(event -> {table.getSelectionModel().getSelectedItem().setLimit(event.getNewValue()); mainApp.reset();});
		initialize(choices);
	}

	@Override
	public void filter(String attribute, String comparison, String text) {
		table.setItems(mainApp.getApplicationWarningData());
		try {
			ObservableList<ApplicationWarning> filteredItems = FXCollections.observableArrayList();
			for (ApplicationWarning item : table.getItems()) {
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
