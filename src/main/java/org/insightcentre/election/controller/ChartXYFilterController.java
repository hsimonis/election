package org.insightcentre.election.controller;

import framework.gui.AbstractJfxMainWindow;
import framework.gui.BaseController;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.SortedMap;
import java.util.TreeMap;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.insightcentre.election.GeneratedJfxApp;

/**
 * Generated at 17:04:25 on 2024-08-07 */
public abstract class ChartXYFilterController extends BaseController {
	protected GeneratedJfxApp mainApp;

	@SuppressWarnings("rawtypes")
	protected SortedMap choicesMap = new TreeMap();

	@SuppressWarnings("rawtypes")
	protected SortedMap filterMap = new TreeMap();

	@FXML
	protected ChoiceBox<String> classChoiceBox;

	@FXML
	protected ChoiceBox<String> attributeChoiceBox;

	@FXML
	protected ChoiceBox<String> attributeYChoiceBox;

	@FXML
	protected ChoiceBox<String> attributeFilterBox;

	@FXML
	protected ChoiceBox<String> filterComparisonBox;

	@FXML
	protected TextField filterTextField;

	@FXML
	protected ChoiceBox<String> attributeGroupBox;

	@Override
	public void setMainApp(AbstractJfxMainWindow mainApp) {
		this.mainApp = (GeneratedJfxApp) mainApp;
		drawChart();
	}

	@FXML
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void onClassSelect() {
		String className = classChoiceBox.getSelectionModel().getSelectedItem();
		ObservableList attributeNames = (ObservableList) choicesMap.get(className);
		ObservableList filterNames = (ObservableList) filterMap.get(className);
		attributeChoiceBox.getItems().clear();
		attributeChoiceBox.getItems().addAll(attributeNames);
		attributeChoiceBox.getSelectionModel().selectFirst();
		attributeYChoiceBox.getItems().clear();
		attributeYChoiceBox.getItems().addAll(attributeNames);
		attributeYChoiceBox.getSelectionModel().selectFirst();
		attributeFilterBox.getItems().clear();
		attributeFilterBox.getItems().addAll(filterNames);
		attributeFilterBox.getSelectionModel().selectFirst();
		attributeGroupBox.getItems().clear();
		attributeGroupBox.getItems().addAll(filterNames);
		attributeGroupBox.getSelectionModel().selectFirst();
		filterComparisonBox.getSelectionModel().selectFirst();
	}

	@FXML
	public void onAttributeSelect() {
		drawChart();
	}

	public abstract void drawChart();
}
