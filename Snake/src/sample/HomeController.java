package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.AudioClip;
import model.User;

public class HomeController implements Initializable {

	@FXML
	private Button btnExit;

	@FXML
	private Button btnHelp;

	@FXML
	private Button btnHistory;

	@FXML
	private Button btnPlay;

	@FXML
	private Button btnSettings;

	@FXML
	private Label lblStatus;
	public static User user;

	private AudioClip mouseClickSound;

//	private MediaPlayer backgroundMusicPlayer;
//	private AudioClip explosionSound;
//	private AudioClip gameOverSound;
//	private AudioClip laserSound;

	public void showWelcomeStatus(String username) {
		lblStatus.setText("Welcome " + username.toUpperCase() + "!");

	}

	@FXML
	void processExit(ActionEvent event) {

		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();

		Platform.runLater(() -> {
			cleanupBeforeExit();
			System.out.println("Exiting application...");
			Platform.exit();
		});
	}

	@FXML
	void processSettings(ActionEvent event) {

		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		ChangeSceneController changescene = ChangeSceneController.getInstance();
		changescene.changeScene("SettingsUI.fxml", event, "Settings UI");

//		System.out.println("Setting UI");
//		try {
//			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("SettingsUI.fxml"));
//			Scene scene = new Scene(root);
//			Stage SettingStage = new Stage();
//			Game.getPrimaryStage().hide();
//			Game.setPrimaryStage(SettingStage);
//			SettingStage.setScene(scene);
//			SettingStage.show();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	private void cleanupBeforeExit() {
		System.out.println("Performing cleanup before exit..");

	}

	public void processHelp(ActionEvent event) {

		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();

		HelpService.Help();
		// Additional code if needed
	}

	@FXML
	void processgotoPlayGame(ActionEvent event) {
		// Main.setPrimaryStage(Main.getPrimaryStage());
		/*
		 * Game main = new Game(); try { Game.getPrimaryStage().hide(); //
		 * main.start(Game.getPrimaryStage());
		 * main.start(Game.setPrimaryStage(Game.getPrimaryStage()));
		 * 
		 * } catch (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		// Game game = new Game();

//		Scene scene = Game.setGameScene(Game.getGameScene());
//		Stage stage = Game.setPrimaryStage(Game.getPrimaryStage());
////		Game.getPrimaryStage().hide();
//		Game.setPrimaryStage(stage);
//		stage.setScene(scene);
//		stage.show();

//		Stage gameStage = Game.setPrimaryStage(Game.getPrimaryStage());
//		Game.GamePlay(gameStage);
//		
//		primaryStage = setPrimaryStage(primaryStage);
//		GamePlay(primaryStage);

//		primaryStage = setPrimaryStage(GamePlay(stage));
//		GamePlay(primaryStage);

		// game.gameOver = false;

		// Stage gameStage = game.setPrimaryStage(game.getPrimaryStage());
		// Stage primaryStage = new Stage();

		// Scene primaryScene = primaryStage.getScene();

		// game.GamePlay(gameStage);

//		try {
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("GamingUI.fxml"));
//			Parent gamingRoot = loader.load();
//
//			GameController gameController = loader.getController();
//
//			Stage gamingStage = new Stage();
//			gamingStage.setTitle("Gaming Scene");
//
//			Scene gamingScene = new Scene(gamingRoot);
//			gamingStage.setScene(gamingScene);
//
//			try {
//				gameController.start(gamingStage);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			gamingStage.show();
//
//			Stage currentStage = (Stage) gamingRoot.getScene().getWindow();
//			currentStage.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		Game game = new Game(false);
//
//		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//		primaryStage.hide();
//		try {
//			game.gameOver = false;
//			// Game.gameOverButton.setVisible(false);
//			game.start(primaryStage);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		ChangeSceneController changescene = ChangeSceneController.getInstance();
		changescene.changeScene("Customization.fxml", event, "Customization UI");

	}

	@FXML
	public void processgotoHistory(ActionEvent event) {

		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		ChangeSceneController changescene = ChangeSceneController.getInstance();
		changescene.changeScene("HistoryUI.fxml", event, "History UI");
//		changescene.getPrimaryStage().hide();
//		System.out.println("Home UI");
//		try {
//			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("HistoryUI.fxml"));
//			Scene scene = new Scene(root);
//			Stage HistoryStage = new Stage();
//			Game.getPrimaryStage().hide();
//			Game.setPrimaryStage(HistoryStage);
//			HistoryStage.setScene(scene);
//			HistoryStage.show();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

//		String backgroundMusicFile = "/audio/background_music.mp3";
//		Media backgroundMusic = new Media(getClass().getResource(backgroundMusicFile).toExternalForm());
//		backgroundMusicPlayer = new MediaPlayer(backgroundMusic);
//		backgroundMusicPlayer.setCycleCount(MediaPlayer.INDEFINITE);
//
//		backgroundMusicPlayer.play();

		user = MainController.user;
		System.out.println("In Home Controller : User from main controller" + user);
	}

}
