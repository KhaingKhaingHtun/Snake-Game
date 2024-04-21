package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import model.Theme;

public class ThemeController {

	@FXML
	private Button btnDark;

	@FXML
	private Button btnFood;

	@FXML
	private Button btnHome;

	@FXML
	private Button btnLight;

	@FXML
	private Label lblFoodStatus;

	@FXML
	private Label lblStatus;

	@FXML
	private Label lblTitle;

	private AudioClip mouseClickSound;

	public static Theme theme;

	@FXML
	void processDark(ActionEvent event) {
		theme = Theme.DARK;
		System.out.println("You choose Dark");
		lblFoodStatus.setTextFill(Color.GRAY);
		lblFoodStatus.setText("You choosed " + theme + " theme");
	}

	@FXML
	void processLight(ActionEvent event) {
		theme = Theme.LIGHT;
		System.out.println("You choose Light");
		lblFoodStatus.setTextFill(Color.GRAY);
		lblFoodStatus.setText("You choosed " + theme + " theme");
	}

	@FXML
	void processgotoFood(ActionEvent event) {
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		ChangeSceneController changescene = ChangeSceneController.getInstance();
		changescene.changeScene("FoodUI.fxml", event, "Food UI");
	}

	@FXML
	void processgotoHome(ActionEvent event) {
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		ChangeSceneController changescene = ChangeSceneController.getInstance();
		changescene.changeScene("HomeUI.fxml", event, "Home UI");
	}

}
