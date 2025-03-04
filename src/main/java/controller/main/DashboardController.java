// File: src/main/java/controller/main/DashboardController.java
package controller.main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import app.MainApp;

public class DashboardController {
	@FXML
	private Button	btnScheduleAppointment;

	@FXML
	private Button	btnViewAppointments;

	private MainApp	mainApp;

	public void setMainApp(MainApp mainApp) { this.mainApp = mainApp; }

	@FXML
	private void initialize() {
		btnScheduleAppointment.setOnAction(e -> showScheduleAppointment());
		btnViewAppointments.setOnAction(e -> showAppointments());
	}

	private void showScheduleAppointment() { mainApp.showScheduleAppointment(); }

	private void showAppointments() { mainApp.showAppointments(); }
}