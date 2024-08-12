package org.insightcentre.election;

import framework.ApplicationDatasetInterface;
import framework.gui.AbstractJfxMainWindow;
import framework.gui.BaseController;
import framework.gui.StatusException;
import java.io.File;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.insightcentre.election.controller.RootController;
import org.insightcentre.election.datamodel.ApplicationDifference;
import org.insightcentre.election.datamodel.ApplicationWarning;
import org.insightcentre.election.datamodel.Area;
import org.insightcentre.election.datamodel.ConstituencyType;
import org.insightcentre.election.datamodel.County;
import org.insightcentre.election.datamodel.Distance;
import org.insightcentre.election.datamodel.DistanceError;
import org.insightcentre.election.datamodel.ElectoralDivision;
import org.insightcentre.election.datamodel.Lea;
import org.insightcentre.election.datamodel.MapLocation;
import org.insightcentre.election.datamodel.NeighborCounty;
import org.insightcentre.election.datamodel.Nuts3;
import org.insightcentre.election.datamodel.Province;
import org.insightcentre.election.datamodel.Scenario;
import org.insightcentre.election.datamodel.Shaped;
import org.insightcentre.election.datamodel.SolConstType;
import org.insightcentre.election.datamodel.SolCounty;
import org.insightcentre.election.datamodel.SolTransfer;
import org.insightcentre.election.datamodel.Solution;
import org.insightcentre.election.datamodel.XMLLoader;

/**
 * Generated at 10:26:59 on 2024-08-11 */
public class GeneratedJfxApp extends AbstractJfxMainWindow {
	static {
		FREEMARKER_CFG.setClassForTemplateLoading(GeneratedJfxApp.class, "C:/Users/hsimonis/Documents/Github/election/site/web");
	}

	public Scenario basebase;

	protected List<BaseController> controllers = new ArrayList<>();

	private RootController controller;

	private ObservableList<Scenario> scenarioData = FXCollections.observableArrayList();

	private ObservableList<ApplicationDifference> applicationDifferenceData = FXCollections.observableArrayList();

	private ObservableList<ApplicationWarning> applicationWarningData = FXCollections.observableArrayList();

	private ObservableList<ConstituencyType> constituencyTypeData = FXCollections.observableArrayList();

	private ObservableList<MapLocation> mapLocationData = FXCollections.observableArrayList();

	private ObservableList<Area> areaData = FXCollections.observableArrayList();

	private ObservableList<Nuts3> nuts3Data = FXCollections.observableArrayList();

	private ObservableList<Province> provinceData = FXCollections.observableArrayList();

	private ObservableList<Shaped> shapedData = FXCollections.observableArrayList();

	private ObservableList<County> countyData = FXCollections.observableArrayList();

	private ObservableList<ElectoralDivision> electoralDivisionData = FXCollections.observableArrayList();

	private ObservableList<Lea> leaData = FXCollections.observableArrayList();

	private ObservableList<Distance> distanceData = FXCollections.observableArrayList();

	private ObservableList<DistanceError> distanceErrorData = FXCollections.observableArrayList();

	private ObservableList<NeighborCounty> neighborCountyData = FXCollections.observableArrayList();

	private ObservableList<Solution> solutionData = FXCollections.observableArrayList();

	private ObservableList<SolCounty> solCountyData = FXCollections.observableArrayList();

	private ObservableList<SolTransfer> solTransferData = FXCollections.observableArrayList();

	private ObservableList<SolConstType> solConstTypeData = FXCollections.observableArrayList();

	public GeneratedJfxApp() {
		super("election", "Election District Mapping - Insight SFI Centre for Data Analytics", "*.data", "C:/Users/hsimonis/Documents/Github/election");
		fs = minimalDataset();
		reset();
		tableViews.put("ConstituencyType", "ConstituencyType");
		tableViews.put("MapLocation", "MapLocation");
		tableViews.put("Area", "Area");
		tableViews.put("Nuts3", "Nuts3");
		tableViews.put("Province", "Province");
		tableViews.put("Shaped", "Shaped");
		tableViews.put("County", "County");
		tableViews.put("ElectoralDivision", "ElectoralDivision");
		tableViews.put("Lea", "Lea");
		tableViews.put("Distance", "Distance");
		tableViews.put("DistanceError", "DistanceError");
		tableViews.put("NeighborCounty", "NeighborCounty");
		tableViews.put("Solution", "Solution");
		tableViews.put("SolCounty", "SolCounty");
		tableViews.put("SolTransfer", "SolTransfer");
		tableViews.put("SolConstType", "SolConstType");
		tableViews.put("Scenario", "Scenario");
		tableViews.put("Scenario Differences", "ApplicationDifference");
		tableViews.put("Warnings", "ApplicationWarning");
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		super.start(primaryStage);
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("view/RootLayout.fxml"));
			BorderPane rootLayout = (BorderPane) loader.load();
			controller = loader.getController();
			controller.setMainApp(this);
			Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
			rootLayout.setPrefWidth(bounds.getWidth() * 0.7);
			rootLayout.setPrefHeight(bounds.getHeight() * 0.7);
			rootLayout.setCenter(tabPane);
			Scene scene = new Scene(rootLayout);
			URL url = getClass().getResource("/framework/gui/css/theme.css");
			if (url != null) {
				scene.getStylesheets().addAll(url.toExternalForm());
			}
			primaryStage.setScene(scene);
			primaryStage.setTitle(applicationTitle);
			primaryStage.show();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void showView(String name) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(String.format("view/%s.fxml", name)));
			Tab tab = (Tab) loader.load();
			showTab(tab);
			BaseController controller = (BaseController) loader.getController();
			controller.setMainApp(this);
			controllers.add(controller);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setStatus(String text) {
		controller.setStatus(text);
	}

	@Override
	public ApplicationDatasetInterface minimalDataset() {
		Scenario base = new Scenario();
		base.setDirty(false);
		return base;
	}

	@Override
	public ApplicationDatasetInterface loadXML(File file) throws StatusException {
		return (Scenario) new XMLLoader().loadXML(file);
	}

	@Override
	public void reset() {
		Scenario base = (Scenario) fs;
		scenarioData.clear();
		scenarioData.addAll(base.getListScenario());
		applicationDifferenceData.clear();
		applicationDifferenceData.addAll(base.getListApplicationDifference());
		applicationWarningData.clear();
		applicationWarningData.addAll(base.getListApplicationWarning());
		constituencyTypeData.clear();
		constituencyTypeData.addAll(base.getListConstituencyType());
		mapLocationData.clear();
		mapLocationData.addAll(base.getListMapLocation());
		areaData.clear();
		areaData.addAll(base.getListArea());
		nuts3Data.clear();
		nuts3Data.addAll(base.getListNuts3());
		provinceData.clear();
		provinceData.addAll(base.getListProvince());
		shapedData.clear();
		shapedData.addAll(base.getListShaped());
		countyData.clear();
		countyData.addAll(base.getListCounty());
		electoralDivisionData.clear();
		electoralDivisionData.addAll(base.getListElectoralDivision());
		leaData.clear();
		leaData.addAll(base.getListLea());
		distanceData.clear();
		distanceData.addAll(base.getListDistance());
		distanceErrorData.clear();
		distanceErrorData.addAll(base.getListDistanceError());
		neighborCountyData.clear();
		neighborCountyData.addAll(base.getListNeighborCounty());
		solutionData.clear();
		solutionData.addAll(base.getListSolution());
		solCountyData.clear();
		solCountyData.addAll(base.getListSolCounty());
		solTransferData.clear();
		solTransferData.addAll(base.getListSolTransfer());
		solConstTypeData.clear();
		solConstTypeData.addAll(base.getListSolConstType());
		for (BaseController controller : controllers) {
			controller.setMainApp(this);
		}
	}

	public ObservableList<Scenario> getScenarioData() {
		return scenarioData;
	}

	public ObservableList<ApplicationDifference> getApplicationDifferenceData() {
		return applicationDifferenceData;
	}

	public ObservableList<ApplicationWarning> getApplicationWarningData() {
		return applicationWarningData;
	}

	public ObservableList<ConstituencyType> getConstituencyTypeData() {
		return constituencyTypeData;
	}

	public ObservableList<MapLocation> getMapLocationData() {
		return mapLocationData;
	}

	public ObservableList<Area> getAreaData() {
		return areaData;
	}

	public ObservableList<Nuts3> getNuts3Data() {
		return nuts3Data;
	}

	public ObservableList<Province> getProvinceData() {
		return provinceData;
	}

	public ObservableList<Shaped> getShapedData() {
		return shapedData;
	}

	public ObservableList<County> getCountyData() {
		return countyData;
	}

	public ObservableList<ElectoralDivision> getElectoralDivisionData() {
		return electoralDivisionData;
	}

	public ObservableList<Lea> getLeaData() {
		return leaData;
	}

	public ObservableList<Distance> getDistanceData() {
		return distanceData;
	}

	public ObservableList<DistanceError> getDistanceErrorData() {
		return distanceErrorData;
	}

	public ObservableList<NeighborCounty> getNeighborCountyData() {
		return neighborCountyData;
	}

	public ObservableList<Solution> getSolutionData() {
		return solutionData;
	}

	public ObservableList<SolCounty> getSolCountyData() {
		return solCountyData;
	}

	public ObservableList<SolTransfer> getSolTransferData() {
		return solTransferData;
	}

	public ObservableList<SolConstType> getSolConstTypeData() {
		return solConstTypeData;
	}
}
