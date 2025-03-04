package controller.main;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Appointment;
import model.Doctor;
import model.Location;
import model.UserInfo;
import service.auth.AppointmentService;
import utils.hibernate.HibernateUtil;

public class ScheduleAppointmentController {
    @FXML private DatePicker datePicker;
    @FXML private ComboBox<Doctor> doctorComboBox;
    @FXML private ComboBox<Location> locationComboBox;
    @FXML private TextArea symptomsArea;
    
    private AppointmentService appointmentService = new AppointmentService();
    private UserInfo currentUser;

    public void setCurrentUser(UserInfo user) {
        this.currentUser = user;
        loadDoctors();
        loadLocations();
    }

    private void loadDoctors() {
        // Implementation to load doctors from database
    }

    private void loadLocations() {
        // Implementation to load locations from database
    }

    @FXML
    private void handleSchedule() {
        Appointment appointment = new Appointment();
        appointment.setPatient(currentUser);
        appointment.setDoctor(doctorComboBox.getValue());
        appointment.setLocation(locationComboBox.getValue());
        appointment.setDate(datePicker.getValue().atTime(9, 0)); // Example time
        appointment.setMotives(symptomsArea.getText());
        
        appointmentService.createAppointment(appointment);
        // Show confirmation
    }
}