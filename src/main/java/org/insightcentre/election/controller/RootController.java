package org.insightcentre.election.controller;

import framework.gui.StatusException;
import java.lang.String;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.insightcentre.election.GeneratedJfxApp;

/**
 * Generated at 17:04:25 on 2024-08-07 */
public class RootController {
	private GeneratedJfxApp mainApp;

	@FXML
	private Label statusBar;

	public void setMainApp(GeneratedJfxApp mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
	private void handle(ActionEvent e) throws StatusException {
		mainApp.handle(e);
	}

	public void setStatus(String text) {
		statusBar.setText(text);
	}
}
