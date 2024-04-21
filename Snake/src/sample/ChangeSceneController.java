package sample;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChangeSceneController {

	private static ChangeSceneController instance;

	public static Stage primaryStage;
	public static Stage newStage;

	private ChangeSceneController() {
	}

	public static ChangeSceneController getInstance() {
		if (instance == null) {
			instance = new ChangeSceneController();
		}
		return instance;
	}

	public void changeScene(String fxmlFileName, ActionEvent event, String title) {
		try {
			FXMLLoader loader = new FXMLLoader((getClass().getResource(fxmlFileName)));
			Parent root = loader.load();
			Scene scene = new Scene(root);
//			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//
//			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//			primaryStage.hide();
//			primaryStage.setScene(scene);
//			primaryStage.setTitle(title);
//			primaryStage.show();

			primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

			// primaryStage = new Stage();

			newStage = new Stage();

			primaryStage.hide();
			// getPrimaryStage().hide();
			// Game game = new Game(false);

			// setPrimaryStage(primaryStage);
//			primaryStage.hide();
			// primaryStage.setScene(scene);

			newStage.setScene(scene);
			// setPrimaryStage(primaryStage);

			// primaryStage.setTitle(title);

			newStage.setTitle(title);
			newStage.setResizable(false);
			// primaryStage.show();
			newStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Stage getPrimaryStage() {

		// primaryStage = setPrimaryStage(primaryStage);
		// GamePlay(primaryStage);
		primaryStage.hide();
		return primaryStage;
	}

	public Stage setPrimaryStage(Stage stage) {
//		primaryStage = stage;
//		GamePlay(primaryStage);
		primaryStage.hide();
		primaryStage = stage;
		primaryStage.hide();

		return primaryStage;
	}

	public void changeScene(String fxmlFileName, ActionEvent event, String title, String username) {
		try {
//			FXMLLoader loader = new FXMLLoader((getClass().getResource(fxmlFileName)));
//			Parent root = loader.load();
//			Scene scene = new Scene(root);
//			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//
//			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//			primaryStage.hide();
//			primaryStage.setScene(scene);
//			primaryStage.setTitle(title);
//			primaryStage.show();

			FXMLLoader loader = new FXMLLoader((getClass().getResource(fxmlFileName)));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			newStage = new Stage();
			primaryStage.hide();
			newStage.setScene(scene);
			newStage.setTitle(title);
			newStage.setResizable(false);
			// primaryStage.show();
			newStage.show();

			if (loader.getController() instanceof HomeController) {
				HomeController homeController = loader.getController();
				homeController.showWelcomeStatus(username);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
