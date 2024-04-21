package sample;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.media.AudioClip;

public class SignupController {

	@FXML
	private Button btnLogin;

	@FXML
	private Button btnSignup;

	@FXML
	private PasswordField pfPassword;

	@FXML
	private TextField tfEmail;

	@FXML
	private RadioButton rbFemale;

	@FXML
	private RadioButton rbMale;

	@FXML
	private TextField tfUsername;

	private String gender = "";

	private AudioClip mouseClickSound;

	@FXML
	void processGender(ActionEvent event) {
		if (rbMale.isSelected()) {
			gender = rbMale.getText();
		}
		if (rbFemale.isSelected()) {
			gender = rbFemale.getText();
		}

	}

	@FXML
	void processSignup(ActionEvent event) throws SQLException {

		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();

		Connection connection = null;
		PreparedStatement psInsert = null;
		PreparedStatement psCheckUserExists = null;
		ResultSet resultSet = null;

		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/snakegame", "root", "Admin*123");
		psCheckUserExists = connection.prepareStatement("select * from users where username = ?");
		psCheckUserExists.setString(1, tfUsername.getText().trim());
		resultSet = psCheckUserExists.executeQuery();

		if (resultSet.isBeforeFirst()) {
			System.out.println("user have already existed!");
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("You cannot use that username");
			alert.show();
			ChangeSceneController changescene = ChangeSceneController.getInstance();
			changescene.changeScene("Signup.fxml", event, "Signup UI");

		} else {
			psInsert = connection
					.prepareStatement("insert into users(username, password, email, gender) values(?,?,?,?) ");
			psInsert.setString(1, tfUsername.getText().trim());
			psInsert.setString(2, pfPassword.getText().trim());
			psInsert.setString(3, tfEmail.getText().trim());
			psInsert.setString(4, gender);
			psInsert.executeUpdate();

		}
		ChangeSceneController changescene = ChangeSceneController.getInstance();
		changescene.changeScene("MainUI.fxml", event, "Main UI");

	}

	@FXML
	void processgotoLogin(ActionEvent event) throws IOException {
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		ChangeSceneController changescene = ChangeSceneController.getInstance();
		changescene.changeScene("MainUI.fxml", event, "Main UI");

	}

}
