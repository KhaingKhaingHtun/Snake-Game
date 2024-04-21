package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Skin;

public class SkinController {

	@FXML
	private Button btnHelp;

	@FXML
	private Button btnHome;

	@FXML
	private Button btnPlay;

	@FXML
	private Button btnRed;

	@FXML
	private Button btnYellow;

	@FXML
	private Button btnGreen;

	@FXML
	private Label lblStatus;

	@FXML
	private Label lblTitle;

	@FXML
	private Label lblSkinStatus;

	private AudioClip mouseClickSound;

	public static Skin skin;

	@FXML
	void processHelp(ActionEvent event) {

		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();

		HelpService.Help();

	}

	@FXML
	void processRedSkin(ActionEvent event) {
		skin = Skin.RED;
		System.out.println("You choose Red");

		lblSkinStatus.setTextFill(Color.GRAY);
		lblSkinStatus.setText("You choosed " + skin + " Skin");
	}

	@FXML
	void processYellowSkin(ActionEvent event) {
		skin = Skin.YELLOW;
		System.out.println("You choose Yellow");

		lblSkinStatus.setTextFill(Color.GRAY);
		lblSkinStatus.setText("You choosed " + skin + " Skin");
	}

	@FXML
	void processGreenSkin(ActionEvent event) {
		skin = Skin.GREEN;
		System.out.println("You choose Green");

		lblSkinStatus.setTextFill(Color.GRAY);
		lblSkinStatus.setText("You choosed  " + skin + " Skin");
	}

	@FXML
	void processgotoHome(ActionEvent event) {
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		ChangeSceneController changescene = ChangeSceneController.getInstance();
		changescene.changeScene("HomeUI.fxml", event, "Home UI");
	}

	@FXML
	void processgotoPlayGame(ActionEvent event) {

//		switch (skin) {
//		case YELLOW:
//
//			Game game = new Game(false);
//
//			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//			primaryStage.hide();
//
//			// Scene primaryScene = primaryStage.getScene();
//
//			// game.GamePlay(gameStage);
//			try {
//				game.gameOver = false;
//				// Game.gameOverButton.setVisible(false);
//				game.start(primaryStage);
//
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			break;
//		case RED:
//			break;
//		}

		Game game = new Game(false);

		Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.hide();
		try {
			game.gameOver = false;
			// Game.gameOverButton.setVisible(false);
			game.start(primaryStage);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
