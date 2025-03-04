package controller.auth;

import app.AuthApp;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.LoginInfo;
import model.UserInfo;
import utils.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SignUpController {

	@FXML
	private TextField		nameField;

	@FXML
	private TextField		surnameField;

	@FXML
	private TextField		emailField;

	@FXML
	private TextField		phoneField;

	@FXML
	private TextField		dniField;

	@FXML
	private PasswordField	passwordField;

	@FXML
	private PasswordField	confirmPasswordField;

	@FXML
	private Hyperlink		signInLink;

	@FXML
	private Label			errorLabel;

	private AuthApp			mainApp;

	public void setMainApp(AuthApp mainApp) { this.mainApp = mainApp; }

	@FXML
	private void initialize() { signInLink.setOnAction(e -> mainApp.showSignInScene()); }

	@FXML
	private void handleSignUp() {
		// Validate input fields
		if (!validateInput()) { return; }

		// Check if passwords match
		if (!passwordField.getText().equals(confirmPasswordField.getText())) {
			errorLabel.setText("Passwords do not match.");
			return;
		}

		// Check if email or DNI already exists
		if (emailExists(emailField.getText())) {
			errorLabel.setText("Email already registered.");
			return;
		}
		if (dniExists(dniField.getText())) {
			errorLabel.setText("DNI already registered.");
			return;
		}

		// Create new user
		UserInfo newUser = createUser();
		LoginInfo newLogin = createLoginInfo(newUser);

		// Save to database
		if (saveUser(newUser, newLogin)) {
			errorLabel.setText("Registration successful!");
			clearFields();
			mainApp.showSignInScene(); // Redirect to sign-in page
		} else {
			errorLabel.setText("Registration failed. Please try again.");
		}
	}

	private boolean validateInput() {
		if (nameField.getText().isEmpty() || surnameField.getText().isEmpty() || emailField.getText().isEmpty()
				|| phoneField.getText().isEmpty() || dniField.getText().isEmpty()
				|| passwordField.getText().isEmpty()) {
			errorLabel.setText("All fields are required.");
			return false;
		}
		return true;
	}

	private boolean emailExists(String email) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("FROM LoginInfo WHERE email = :email", LoginInfo.class)
					.setParameter("email", email).uniqueResult() != null;
		}
	}

	private boolean dniExists(String dni) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("FROM UserInfo WHERE dni = :dni", UserInfo.class).setParameter("dni", dni)
					.uniqueResult() != null;
		}
	}

	private UserInfo createUser() {
		UserInfo user = new UserInfo();
		user.setName(nameField.getText());
		user.setSurname(surnameField.getText());
		user.setPhone(Integer.parseInt(phoneField.getText()));
		user.setDni(dniField.getText());
		return user;
	}

	private LoginInfo createLoginInfo(UserInfo user) {
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setEmail(emailField.getText());
		loginInfo.setPassword(passwordField.getText()); // In a real app, hash the password
		loginInfo.setUser(user);
		return loginInfo;
	}

	private boolean saveUser(UserInfo user, LoginInfo loginInfo) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(user); // Save UserInfo first
			session.persist(loginInfo); // Save LoginInfo
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return false;
		}
	}

	private void clearFields() {
		nameField.clear();
		surnameField.clear();
		emailField.clear();
		phoneField.clear();
		dniField.clear();
		passwordField.clear();
		confirmPasswordField.clear();
		errorLabel.setText("");
	}
}