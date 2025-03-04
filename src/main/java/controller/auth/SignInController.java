package controller.auth;

import app.AuthApp;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignInController {

    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private Hyperlink signUpLink;
    
    private AuthApp mainApp;

    public void setMainApp(AuthApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void initialize() {
        signUpLink.setOnAction(e -> mainApp.showSignUpScene());
    }

    @FXML
    private void handleSignIn() {
        String email = emailField.getText();
        String password = passwordField.getText();
        
        // Add authentication logic here
        System.out.println("Sign In Attempt: " + email);
    }
}