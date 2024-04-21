package sample;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.media.AudioClip;
import model.User;
import model.UserDAO;
//import model.AuthenticationService;
//import model.UserDAO;

public class SettingsController {

	@FXML
	private Button btnDeleteAccount;

	@FXML
	private Button btnGotoHome;

	@FXML
	private Button btnLogout;

	@FXML
	private Button btnChangePassword;

	private AudioClip mouseClickSound;

	private final UserDAO userDAO = new UserDAO();

	private String username;
	public static User user;

	public void setUsername(String username) {
		this.username = username;
	}

//	@FXML
//	void processChangePassword(ActionEvent event) {
//
//		String mouseClick = "/audio/mouse_click.mp3";
//		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
//		mouseClickSound.play();
//
//		// logic -> if the old password is correct , user can change the new password
//		TextInputDialog oldPasswordDialog = new TextInputDialog();
//		oldPasswordDialog.setTitle("Change Password");
//		oldPasswordDialog.setHeaderText("Enter your old password");
//		oldPasswordDialog.setContentText("Old Password :");
//
//		Optional<String> oldPasswordResult = oldPasswordDialog.showAndWait();
//
//		oldPasswordResult.ifPresent(oldPassword -> {
//			PasswordField newPasswordField = new PasswordField();
//			newPasswordField.setPromptText("Enter new password");
//
//			TextInputDialog newPasswordDialog = new TextInputDialog();
//			newPasswordDialog.setTitle("Change Password");
//			newPasswordDialog.setHeaderText("Enter your new password");
//			newPasswordDialog.getDialogPane().setContent(newPasswordField);
//			// newPasswordDialog.getDialogPane().getContent();
//
//			Optional<String> newPasswordResult = newPasswordDialog.showAndWait();
//
//			newPasswordResult.ifPresent(newPassword -> {
//				boolean changed = userDAO.changePassword(username, newPassword, oldPassword);
//
//				if (changed) {
//					System.out.println("Password changed successfully!");
//				} else {
//					Alert alert = new Alert(AlertType.ERROR);
//					alert.setTitle("Error");
//					alert.setHeaderText("Failed to change password");
//					alert.setContentText("Failed to change password!");
//					alert.show();
//				}
//			});
//
//		});
//
//	}
//
//	@FXML
//	public void processDeleteAccount(ActionEvent event) {
//
//		String mouseClick = "/audio/mouse_click.mp3";
//		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
//		mouseClickSound.play();
//
//		String username = AuthenticationService.getCurrentUser().getUsername();
//
//		Alert alert = new Alert(AlertType.CONFIRMATION);
//		alert.setTitle("Delete Account");
//		alert.setHeaderText("Are you sure you want to delete your account?");
//		alert.setContentText("This action is irreversible.");
//
//		Optional<ButtonType> result = alert.showAndWait();
//		if (result.isPresent() && result.get() == ButtonType.OK) {
//			boolean deleted = userDAO.deleteUser(username);
//
//			if (deleted) {
//				ChangeSceneController changescene = ChangeSceneController.getInstance();
//				changescene.changeScene("MainUI.fxml", event, "Main UI");
//			} else {
//				Alert alert2 = new Alert(AlertType.ERROR);
//				alert2.setTitle("Error");
//				alert2.setHeaderText(null);
//				alert2.setContentText("Failed to delete account. Please try again.");
//				alert2.showAndWait();
//			}
//		}
//	}
	@FXML
	public void processChangePassword(ActionEvent event) {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Change Password");
		dialog.setHeaderText("Enter your username");
		dialog.setContentText("Username:");

		try {
			Optional<String> result = dialog.showAndWait();
			if (result.isPresent()) {
				String username = result.get();

				dialog = new TextInputDialog();
				dialog.setTitle("Change Password");
				dialog.setHeaderText("Enter your new password");
				dialog.setContentText("New Password:");

				result = dialog.showAndWait();
				if (result.isPresent()) {
					String newPassword = result.get();
					UserDAO userDAO = new UserDAO();
					boolean passwordChanged = userDAO.changePassword(username, newPassword);

					if (passwordChanged) {
						Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
						successAlert.setTitle("Password Changed");
						successAlert.setHeaderText(null);
						successAlert.setContentText("Your password has been changed successfully.");
						successAlert.showAndWait();
					} else {
						Alert errorAlert = new Alert(Alert.AlertType.ERROR);
						errorAlert.setTitle("Error");
						errorAlert.setHeaderText(null);
						errorAlert.setContentText("Failed to change password. Please try again.");
						errorAlert.showAndWait();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void processDeleteAccount(ActionEvent event) {

		Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
		confirmationAlert.setTitle("Delete Account");
		confirmationAlert.setHeaderText("hii");
		confirmationAlert.setContentText("Are you sure you want to delete your account? This action cannot be undone.");

		Optional<ButtonType> result = confirmationAlert.showAndWait();
		if (result.isPresent() && result.get() == ButtonType.OK) {
			String currentUsername = AuthenticationService.getCurrentUser().getUsername();
			UserDAO userDAO = new UserDAO();
			boolean accountDeleted = userDAO.deleteAccount(currentUsername);

			if (accountDeleted) {
				Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
				successAlert.setTitle("Account Deleted");
				successAlert.setHeaderText(null);
				successAlert.setContentText("Your account has been deleted successfully.");
				successAlert.showAndWait();

				ChangeSceneController changescene = ChangeSceneController.getInstance();
				changescene.changeScene("MainUI.fxml", event, "Main UI");

			} else {
				Alert errorAlert = new Alert(Alert.AlertType.ERROR);
				errorAlert.setTitle("Error");
				errorAlert.setHeaderText(null);
				errorAlert.setContentText("Failed to delete account. Please contact support.");
				errorAlert.showAndWait();
			}
		}
	}

	@FXML
	void processGotoHome(ActionEvent event) {
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		ChangeSceneController changescene = ChangeSceneController.getInstance();
		changescene.changeScene("HomeUI.fxml", event, "Home UI");

//		System.out.println("Home UI");
//		try {
//			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("HomeUI.fxml"));
//			Scene scene = new Scene(root);
//			Stage HomeStage = new Stage();
//			Game game = new Game(false);
//			game.getPrimaryStage().hide();
//			game.setPrimaryStage(HomeStage);
//			HomeStage.setTitle("Home UI");
//			HomeStage.setScene(scene);
//			HomeStage.show();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	@FXML
	void processLogout(ActionEvent event) {

		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		ChangeSceneController changescene = ChangeSceneController.getInstance();
		changescene.changeScene("MainUI.fxml", event, "Main UI");

	}

}
