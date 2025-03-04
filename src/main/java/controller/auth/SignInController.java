package controller.auth;

import org.hibernate.Session;

import app.AuthApp;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.LoginInfo;
import utils.hibernate.HibernateUtil;

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
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            LoginInfo loginInfo = session.createQuery(
                "FROM LoginInfo WHERE email = :email", LoginInfo.class)
                .setParameter("email", email)
                .uniqueResult();
            
            if (loginInfo != null && loginInfo.getPassword().equals(password)) {
                mainApp.showMainApplication(loginInfo.getUser());
            } else {
                // Show error message
            }
        }
    }
}