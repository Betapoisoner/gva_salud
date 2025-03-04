package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import controller.auth.SignInController;
import controller.auth.SignUpController;

public class AuthApp extends Application {

    private Stage primaryStage;
    private Scene signInScene;
    private Scene signUpScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        
        // Load SignIn
        FXMLLoader signInLoader = new FXMLLoader(getClass().getResource("signin.fxml"));
        Parent signInRoot = signInLoader.load();
        SignInController signInController = signInLoader.getController();
        signInController.setMainApp(this);
        signInScene = new Scene(signInRoot);
        
        // Load SignUp
        FXMLLoader signUpLoader = new FXMLLoader(getClass().getResource("signup.fxml"));
        Parent signUpRoot = signUpLoader.load();
        SignUpController signUpController = signUpLoader.getController();
        signUpController.setMainApp(this);
        signUpScene = new Scene(signUpRoot);
        
        // Show initial scene
        showSignInScene();
        primaryStage.setTitle("Authentication System");
        primaryStage.show();
    }

    public void showSignInScene() {
        primaryStage.setScene(signInScene);
    }

    public void showSignUpScene() {
        primaryStage.setScene(signUpScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}