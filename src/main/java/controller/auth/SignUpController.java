package controller.auth;

import app.AuthApp;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML private TextField nameField;
    @FXML private TextField surnameField;
    @FXML private TextField emailField;
    @FXML private TextField phoneField;
    @FXML private TextField dniField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmPasswordField;
    @FXML private Hyperlink signInLink;
    
    private AuthApp mainApp;

    public void setMainApp(AuthApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void initialize() {
        signInLink.setOnAction(e -> mainApp.showSignInScene());
    }

    @FXML
    private void handleSignUp() {
        String name = nameField.getText();
        String surname = surnameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String dni = dniField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        
        // Add validation and registration logic here
        System.out.println("Sign Up Attempt: " + email);
    }
}