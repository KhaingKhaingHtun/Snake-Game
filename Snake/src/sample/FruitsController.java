package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.AudioClip;
import model.Food;
import model.Fruit;

public class FruitsController implements Initializable {

	@FXML
	private Button btnApple;

	@FXML
	private Button btnBanana;

	@FXML
	private Button btnBerry;

	@FXML
	private Button btnCherry;

	@FXML
	private Button btnCoconut;

	@FXML
	private Button btnHome;

	@FXML
	private Button btnMelon;

	@FXML
	private Button btnOrange;

	@FXML
	private Button btnPeach;

	@FXML
	private Button btnPomegranate;

	@FXML
	private Button btnRandomFruit;

	@FXML
	private Button btnCustomized;

	@FXML
	private Label lblStatus;

	@FXML
	private Label lblTitle;

	public static Fruit fruit;
	private AudioClip mouseClickSound;
	// private Button selectedButton;

	@FXML
	void processApple(ActionEvent event) {
		CustomizationController.food = Food.FRUITS;
		fruit = Fruit.APPLE;
		System.out.println("You choose Apple" + fruit);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnApple);
		HandleButtonController.handleButtonGroup(btnApple, btnBanana, btnBerry, btnCherry, btnCoconut, btnMelon,
				btnOrange, btnPeach, btnPomegranate, btnRandomFruit);

	}

	@FXML
	void processBanana(ActionEvent event) {
		CustomizationController.food = Food.FRUITS;
		fruit = Fruit.BANANA;
		System.out.println("You choose Banana" + fruit);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnBanana);
		HandleButtonController.handleButtonGroup(btnBanana, btnApple, btnBerry, btnCherry, btnCoconut, btnMelon,
				btnOrange, btnPeach, btnPomegranate, btnRandomFruit);
	}

	@FXML
	void processBerry(ActionEvent event) {
		CustomizationController.food = Food.FRUITS;
		fruit = Fruit.BERRY;
		System.out.println("You choose Berry" + fruit);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnBerry);
		HandleButtonController.handleButtonGroup(btnBerry, btnBanana, btnApple, btnCherry, btnCoconut, btnMelon,
				btnOrange, btnPeach, btnPomegranate, btnRandomFruit);
	}

	@FXML
	void processCherry(ActionEvent event) {
		CustomizationController.food = Food.FRUITS;
		fruit = Fruit.CHERRY;
		System.out.println("You choose Cherry" + fruit);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnCherry);
		HandleButtonController.handleButtonGroup(btnCherry, btnBanana, btnBerry, btnApple, btnCoconut, btnMelon,
				btnOrange, btnPeach, btnPomegranate, btnRandomFruit);
	}

	@FXML
	void processCoconut(ActionEvent event) {
		CustomizationController.food = Food.FRUITS;
		fruit = Fruit.COCONUT;
		System.out.println("You choose Coconut" + fruit);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnCoconut);
		HandleButtonController.handleButtonGroup(btnCoconut, btnBanana, btnBerry, btnCherry, btnApple, btnMelon,
				btnOrange, btnPeach, btnPomegranate, btnRandomFruit);
	}

	@FXML
	void processMelon(ActionEvent event) {
		CustomizationController.food = Food.FRUITS;
		fruit = Fruit.MELON;
		System.out.println("You choose Melon" + fruit);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnMelon);
		HandleButtonController.handleButtonGroup(btnMelon, btnBanana, btnBerry, btnCherry, btnCoconut, btnApple,
				btnOrange, btnPeach, btnPomegranate, btnRandomFruit);
	}

	@FXML
	void processOrange(ActionEvent event) {
		CustomizationController.food = Food.FRUITS;
		fruit = Fruit.ORANGE;
		System.out.println("You choose Orange" + fruit);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnOrange);
		HandleButtonController.handleButtonGroup(btnOrange, btnBanana, btnBerry, btnCherry, btnCoconut, btnMelon,
				btnApple, btnPeach, btnPomegranate, btnRandomFruit);
	}

	@FXML
	void processPeach(ActionEvent event) {
		CustomizationController.food = Food.FRUITS;
		fruit = Fruit.PEACH;
		System.out.println("You choose Peach" + fruit);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnPeach);
		HandleButtonController.handleButtonGroup(btnPeach, btnBanana, btnBerry, btnCherry, btnCoconut, btnMelon,
				btnOrange, btnApple, btnPomegranate, btnRandomFruit);
	}

	@FXML
	void processPomegranate(ActionEvent event) {
		CustomizationController.food = Food.FRUITS;

		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		fruit = Fruit.POMEGRANATE;
		System.out.println("You choose Pomegranate" + fruit);

		HandleButtonController.handleButtonSelection(btnPomegranate);
		HandleButtonController.handleButtonGroup(btnPomegranate, btnBanana, btnBerry, btnCherry, btnCoconut, btnMelon,
				btnOrange, btnPeach, btnApple, btnRandomFruit);
	}

	@FXML
	void processRandomFruit(ActionEvent event) {
		CustomizationController.food = Food.FRUITS;
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();

		fruit = Fruit.RANDOMFRUITS;
		System.out.println("You choose Random" + fruit);

		HandleButtonController.selectedButton = btnRandomFruit;
		HandleButtonController.handleButtonSelection(btnRandomFruit);
		HandleButtonController.handleButtonGroup(btnRandomFruit, btnBanana, btnBerry, btnCherry, btnCoconut, btnMelon,
				btnOrange, btnPeach, btnPomegranate, btnApple);
	}

	@FXML
	void processbacktoCustomize(ActionEvent event) {
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		// fruit = FruitsController.fruit;
		// System.out.println("back to cust : " + fruit);

		ChangeSceneController changescene = ChangeSceneController.getInstance();
		changescene.changeScene("Customization.fxml", event, "Customization UI");
	}

	@FXML
	void processgotoHome(ActionEvent event) {
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		ChangeSceneController changescene = ChangeSceneController.getInstance();
		changescene.changeScene("HomeUI.fxml", event, "Home UI");
		// CustomizationController.btnFruits.setStyle("-fx-background-color: #007bff");

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		fruit = Fruit.RANDOMFRUITS;
		btnRandomFruit.setStyle("-fx-background-color: #007bff");
		HandleButtonController.selectedButton = btnRandomFruit;

	}

}
