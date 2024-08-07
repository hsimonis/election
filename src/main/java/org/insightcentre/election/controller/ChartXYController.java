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
import org.insightcentre.election.GeneratedJfxApp;

/**
 * Generated at 17:04:25 on 2024-08-07 */
public abstract class ChartXYController extends BaseController {
	protected GeneratedJfxApp mainApp;

	@SuppressWarnings("rawtypes")
	protected SortedMap choicesMap = new TreeMap();

	@FXML
	protected ChoiceBox<String> classChoiceBox;

	@FXML
	protected ChoiceBox<String> attributeChoiceBox;

	@FXML
	protected ChoiceBox<String> attributeYChoiceBox;

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
		attributeChoiceBox.getItems().clear();
		attributeYChoiceBox.getItems().clear();
		attributeChoiceBox.getItems().addAll(attributeNames);
		attributeYChoiceBox.getItems().addAll(attributeNames);
		attributeChoiceBox.getSelectionModel().selectFirst();
		attributeYChoiceBox.getSelectionModel().selectFirst();
	}

	@FXML
	public void onAttributeSelect() {
		drawChart();
	}

	public abstract void drawChart();
}
