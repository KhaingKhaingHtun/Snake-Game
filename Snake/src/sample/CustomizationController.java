package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import model.Food;
import model.Fruit;
import model.Mode;
import model.Skin;
import model.Theme;

public class CustomizationController implements Initializable {
	@FXML
	private Button btnAnimals;

	@FXML
	private Button btnDark;

	@FXML
	private Button btnAshamed;

	@FXML
	private Button btnEndlessMode;

	@FXML
	private Button btnFruits;

	@FXML
	private Button btnGreen;

	@FXML
	private Button btnHappy;

	@FXML
	private Button btnHome;

	@FXML
	private Button btnInsects;

	@FXML
	private Button btnLight;

	@FXML
	private Button btnNormalMode;

	@FXML
	private Button btnPlayGame;

	@FXML
	private Button btnRed;

	@FXML
	private Button btnSad;

	@FXML
	private Button btnSnack;

	@FXML
	private Button btnYellow;

	@FXML
	private Label lblFoodStatus;

	@FXML
	private Label lblSkinStatus;

	@FXML
	private Label lblStatus;

	@FXML
	private Label lblThemeStatus;

	@FXML
	private Label lblThemeStatus1;

	@FXML
	private Label lblTitle;

	public static Skin skin;
	public static Theme theme;
	public static Food food;
	public static Mode mode;
	private AudioClip mouseClickSound;
	private Button selectedButton;

	@FXML
	void processDark(ActionEvent event) {
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		theme = Theme.DARK;
		System.out.println("You choose Dark");
		// btnDark.setStyle("-fx-border-color: #007bff");
		handleButtonSelection(btnDark);
		handleButtonGroup(btnDark, btnLight);
	}

	@FXML
	void processLight(ActionEvent event) {
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		theme = Theme.LIGHT;
		selectedButton = btnLight;
		System.out.println("You choose Light");
		// btnLight.setStyle("-fx-background-color: #007bff");
		handleButtonSelection(btnLight);
		handleButtonGroup(btnLight, btnDark);
	}

	@FXML
	void processAnimal(ActionEvent event) {
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		food = Food.ANIMALS;
		System.out.println("You choose Animals");
		// btnAnimals.setStyle("-fx-background-color: #007bff");
		handleButtonSelection(btnAnimals);
		// handleButtonGroup(btnAnimals, btnFruits);
		handleButtonGroup(btnAnimals, btnSnack, btnFruits, btnInsects);
		ChangeSceneController changescene = ChangeSceneController.getInstance();
		changescene.changeScene("AnimalsUI.fxml", event, "Fruits UI");

//		food = Food.ANIMALS;
//		System.out.println("You choose Animals");
//		lblFoodStatus.setTextFill(Color.GRAY);
//		lblFoodStatus.setText("You choosed " + food);
	}

	@FXML
	void processFruits(ActionEvent event) {
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		food = Food.FRUITS;
		selectedButton = btnFruits;
		System.out.println("You choose Fruits");
		// btnFruits.setStyle("-fx-background-color: #007bff");
		handleButtonSelection(btnFruits);
		// handleButtonGroup(btnFruits, btnAnimals);
		handleButtonGroup(btnFruits, btnAnimals, btnSnack, btnInsects);
		ChangeSceneController changescene = ChangeSceneController.getInstance();
		changescene.changeScene("FruitsUI.fxml", event, "Fruits UI");
	}

	@FXML
	void processSnack(ActionEvent event) {
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		food = Food.SNACK;
		System.out.println("You choose Snacks");
		// btnFruits.setStyle("-fx-background-color: #007bff");
		handleButtonSelection(btnSnack);
		// handleButtonGroup(btnFruits, btnAnimals);
		handleButtonGroup(btnSnack, btnAnimals, btnFruits, btnInsects);

		ChangeSceneController changescene = ChangeSceneController.getInstance();
		changescene.changeScene("SnacksUI.fxml", event, "Snacks UI");
	}

	@FXML
	void processInsects(ActionEvent event) {
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		food = Food.INSECTS;
		System.out.println("You choose Insects");
		// btnFruits.setStyle("-fx-background-color: #007bff");
		handleButtonSelection(btnInsects);
		// handleButtonGroup(btnFruits, btnAnimals);
		handleButtonGroup(btnInsects, btnAnimals, btnFruits, btnSnack);
		ChangeSceneController changescene = ChangeSceneController.getInstance();
		changescene.changeScene("InsectsUI.fxml", event, "Insects UI");
	}

	@FXML
	void processGreenSkin(ActionEvent event) {
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		skin = Skin.GREEN;
		System.out.println("You choose Green");
		// btnGreen.setStyle("-fx-background-color: #007bff");
		handleButtonSelection(btnGreen);
		handleButtonGroup(btnGreen, btnRed, btnYellow, btnSad, btnHappy, btnAshamed);

	}

	@FXML
	void processRedSkin(ActionEvent event) {
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		skin = Skin.RED;
		System.out.println("You choose Red");
		handleButtonSelection(btnRed);
		handleButtonGroup(btnRed, btnGreen, btnYellow, btnSad, btnHappy, btnAshamed);
		// btnRed.setStyle("-fx-background-color: #007bff");

//		lblSkinStatus.setTextFill(Color.GRAY);
//		lblSkinStatus.setText("You choosed " + skin + " Skin");
	}

	@FXML
	void processYellowSkin(ActionEvent event) {
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		skin = Skin.YELLOW;
		selectedButton = btnYellow;
		System.out.println("You choose Yellow");
		// btnYellow.setStyle("-fx-background-color: #007bff");
		handleButtonSelection(btnYellow);
		handleButtonGroup(btnYellow, btnRed, btnGreen, btnSad, btnHappy, btnAshamed);
	}

	@FXML
	void processHappySkin(ActionEvent event) {
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		skin = Skin.HAPPY;
		System.out.println("You choose Happy");
		// btnYellow.setStyle("-fx-background-color: #007bff");
		handleButtonSelection(btnHappy);
		handleButtonGroup(btnHappy, btnRed, btnGreen, btnSad, btnYellow, btnAshamed);
	}

	@FXML
	void processSadSkin(ActionEvent event) {
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		skin = Skin.SAD;
		System.out.println("You choose Sad");
		// btnYellow.setStyle("-fx-background-color: #007bff");
		handleButtonSelection(btnSad);
		handleButtonGroup(btnSad, btnRed, btnGreen, btnYellow, btnHappy, btnAshamed);
	}

	@FXML
	void processAshamedSkin(ActionEvent event) {
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		skin = Skin.ASHAMED;
		System.out.println("You choose Dragon");
		// btnYellow.setStyle("-fx-background-color: #007bff");
		handleButtonSelection(btnAshamed);
		handleButtonGroup(btnAshamed, btnRed, btnGreen, btnSad, btnHappy, btnYellow);
	}

	@FXML
	void processEndlessMode(ActionEvent event) {

		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		mode = Mode.ENDLESS;
		System.out.println("You choose Endless");
		// btnDark.setStyle("-fx-border-color: #007bff");
		handleButtonSelection(btnEndlessMode);
		handleButtonGroup(btnEndlessMode, btnNormalMode);

	}

	@FXML
	void processNormalMode(ActionEvent event) {
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		mode = Mode.NORMAL;
		selectedButton = btnNormalMode;
		System.out.println("You choose Normal");
		// btnDark.setStyle("-fx-border-color: #007bff");
		handleButtonSelection(btnNormalMode);
		handleButtonGroup(btnNormalMode, btnEndlessMode);
	}

	@FXML
	void processPlayGame(ActionEvent event) {
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

	@FXML
	void processgotoHome(ActionEvent event) {
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		ChangeSceneController changescene = ChangeSceneController.getInstance();
		changescene.changeScene("HomeUI.fxml", event, "Home UI");
	}

	private void handleButtonSelection(Button button) {
		if (button.getStyle().contains("-fx-background-color: #007bff")) {
			// Button is selected, reset style
//			button.setStyle("-fx-background-color: transparent");
			if (selectedButton == button) {
				button.setStyle("-fx-background-color: #007bff");
			} else {
				button.setStyle("-fx-background-color: transparent");
				selectedButton = null;
			}
		} else {
			// Button is not selected, set style
			button.setStyle("-fx-background-color: #007bff");
			selectedButton = button;
		}
	}

	/*
	 * private void handleButtonGroup(Button button1, Button button2) { if
	 * (button1.getStyle().contains("-fx-background-color: #007bff")) { // Button is
	 * selected, reset style button2.setStyle("-fx-background-color: transparent");
	 * // button1.setStyle("-fx-background-color: #007bff");
	 * 
	 * } else if (button2.getStyle().contains("-fx-background-color: #007bff")) { //
	 * Button is not selected, set style //
	 * button1.setStyle("-fx-background-color: #007bff"); //
	 * button2.setStyle("-fx-background-color: #007bff");
	 * button1.setStyle("-fx-background-color: transparent");
	 * lblThemeStatus.setText(""); //
	 * button2.setStyle("-fx-background-color: e0e0e0"); } // if
	 * (button1.getStyle().contains("-fx-background-color: transparent") // &&
	 * button2.getStyle().contains("-fx-background-color: transparent")) { //
	 * button1.setStyle("-fx-background-color: 007bff"); // // //
	 * lblThemeStatus.setText("You must choose One Theme!!!"); // // } }
	 * 
	 * private void handleButtonGroup(Button button1, Button button2, Button
	 * button3) { if (button1.getStyle().contains("-fx-background-color: #007bff"))
	 * { // Button is selected, reset style
	 * button2.setStyle("-fx-background-color: transparent");
	 * button3.setStyle("-fx-background-color: transparent");
	 * 
	 * } else if (button2.getStyle().contains("-fx-background-color: #007bff")) { //
	 * Button is not selected, set style //
	 * button1.setStyle("-fx-background-color: #007bff");
	 * button1.setStyle("-fx-background-color: transparent");
	 * button3.setStyle("-fx-background-color: transparent"); //
	 * button2.setStyle("-fx-background-color: e0e0e0"); } else if
	 * (button3.getStyle().contains("-fx-background-color: #007bff")) { // Button is
	 * not selected, set style // button1.setStyle("-fx-background-color: #007bff");
	 * button1.setStyle("-fx-background-color: transparent");
	 * button2.setStyle("-fx-background-color: transparent"); //
	 * button2.setStyle("-fx-background-color: e0e0e0");
	 * 
	 * } }
	 */
	private void handleButtonGroup(Button... buttons) {
		for (Button button : buttons) {
			if (button.getStyle().contains("-fx-background-color: #007bff")) {
				// Button is selected, reset style for other buttons
				for (Button otherButton : buttons) {
					if (otherButton != button) {
						otherButton.setStyle("-fx-background-color: transparent");
					}
				}
			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		System.out.println("Fruit "+ FruitsController.fruit);
//		System.out.println("Fruit "+ FruitsController.fruit);
//		System.out.println("Fruit "+ FruitsController.fruit);
//		System.out.println("Fruit "+ FruitsController.fruit);
		// TODO Auto-generated method stub
		// theme = Theme.LIGHT;
		// btnLight.setStyle("-fx-background-color: #007bff");
		// food = Food.FRUITS;
		// btnFruits.setStyle("-fx-background-color: #007bff");
		// skin = Skin.YELLOW;
		// btnYellow.setStyle("-fx-background-color: #007bff");
		// mode = Mode.NORMAL;
		// btnNormalMode.setStyle("-fx-background-color: #007bff");
		if (food == null) {
			food = Food.FRUITS;
			FruitsController.fruit = Fruit.RANDOMFRUITS;
			btnFruits.setStyle("-fx-background-color: #007bff");
		}
		if (theme == null) {
			theme = Theme.LIGHT;
			btnLight.setStyle("-fx-background-color: #007bff");
		}
		if (skin == null) {
			skin = Skin.YELLOW;
			btnYellow.setStyle("-fx-background-color: #007bff");
		}
		if (mode == null) {
			mode = Mode.NORMAL;
			btnNormalMode.setStyle("-fx-background-color: #007bff");
		}

		switch (food) {
		case ANIMALS:
			btnAnimals.setStyle("-fx-background-color: #007bff");
			break;
		case FRUITS:
			btnFruits.setStyle("-fx-background-color: #007bff");
			break;
		case INSECTS:
			btnInsects.setStyle("-fx-background-color: #007bff");
			break;
		case SNACK:
			btnSnack.setStyle("-fx-background-color: #007bff");
			break;
		}
		switch (theme) {
		case DARK:
			btnDark.setStyle("-fx-background-color: #007bff");
			break;
		case LIGHT:
			btnLight.setStyle("-fx-background-color: #007bff");
			break;
		}
		switch (skin) {
		case ASHAMED:
			btnAshamed.setStyle("-fx-background-color: #007bff");
			break;
		case GREEN:
			btnGreen.setStyle("-fx-background-color: #007bff");
			break;
		case HAPPY:
			btnHappy.setStyle("-fx-background-color: #007bff");
			break;
		case RED:
			btnRed.setStyle("-fx-background-color: #007bff");
			break;
		case SAD:
			btnSad.setStyle("-fx-background-color: #007bff");
			break;
		case YELLOW:
			btnYellow.setStyle("-fx-background-color: #007bff");
			break;
		}
		switch (mode) {
		case ENDLESS:
			btnEndlessMode.setStyle("-fx-background-color: #007bff");
			break;
		case NORMAL:
			btnNormalMode.setStyle("-fx-background-color: #007bff");
			break;
		}
	}

}