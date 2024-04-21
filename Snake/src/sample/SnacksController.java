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
import model.Snack;

public class SnacksController implements Initializable {

	@FXML
	private Button btnBurger;

	@FXML
	private Button btnChicken;

	@FXML
	private Button btnCustomized;

	@FXML
	private Button btnDonut;

	@FXML
	private Button btnDumpling;

	@FXML
	private Button btnFries;

	@FXML
	private Button btnHome;

	@FXML
	private Button btnHotdog;

	@FXML
	private Button btnPizza;

	@FXML
	private Button btnRandomSnack;

	@FXML
	private Button btnSandwich;

	@FXML
	private Button btnSushi;

	@FXML
	private Label lblStatus;

	@FXML
	private Label lblTitle;

	private AudioClip mouseClickSound;
	public static Snack snack;

	@FXML
	void processBurger(ActionEvent event) {
		CustomizationController.food = Food.SNACK;
		snack = Snack.BURGER;
		System.out.println("You choose Burger" + snack);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnBurger);
		HandleButtonController.handleButtonGroup(btnBurger, btnChicken, btnDonut, btnDumpling, btnFries, btnHotdog,
				btnPizza, btnSandwich, btnSushi, btnRandomSnack);
	}

	@FXML
	void processChicken(ActionEvent event) {
		CustomizationController.food = Food.SNACK;
		snack = Snack.CHICKEN;
		System.out.println("You choose Chicken" + snack);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnChicken);
		HandleButtonController.handleButtonGroup(btnChicken, btnBurger, btnDonut, btnDumpling, btnFries, btnHotdog,
				btnPizza, btnSandwich, btnSushi, btnRandomSnack);

	}

	@FXML
	void processDonut(ActionEvent event) {
		CustomizationController.food = Food.SNACK;
		snack = Snack.DONUT;
		System.out.println("You choose Donut" + snack);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnDonut);
		HandleButtonController.handleButtonGroup(btnDonut, btnChicken, btnBurger, btnDumpling, btnFries, btnHotdog,
				btnPizza, btnSandwich, btnSushi, btnRandomSnack);
	}

	@FXML
	void processDumpling(ActionEvent event) {
		CustomizationController.food = Food.SNACK;
		snack = Snack.DUMPLING;
		System.out.println("You choose Dumpling" + snack);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnDumpling);
		HandleButtonController.handleButtonGroup(btnDumpling, btnChicken, btnDonut, btnBurger, btnFries, btnHotdog,
				btnPizza, btnSandwich, btnSushi, btnRandomSnack);

	}

	@FXML
	void processFries(ActionEvent event) {
		CustomizationController.food = Food.SNACK;
		snack = Snack.FRIES;
		System.out.println("You choose French Fries" + snack);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnFries);
		HandleButtonController.handleButtonGroup(btnFries, btnChicken, btnDonut, btnDumpling, btnBurger, btnHotdog,
				btnPizza, btnSandwich, btnSushi, btnRandomSnack);

	}

	@FXML
	void processHotdog(ActionEvent event) {
		CustomizationController.food = Food.SNACK;
		snack = Snack.HOTDOG;
		System.out.println("You choose Hotdog" + snack);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnHotdog);
		HandleButtonController.handleButtonGroup(btnHotdog, btnChicken, btnDonut, btnDumpling, btnFries, btnBurger,
				btnPizza, btnSandwich, btnSushi, btnRandomSnack);

	}

	@FXML
	void processPizza(ActionEvent event) {
		CustomizationController.food = Food.SNACK;
		snack = Snack.PIZZA;
		System.out.println("You choose Pizza" + snack);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnPizza);
		HandleButtonController.handleButtonGroup(btnPizza, btnChicken, btnDonut, btnDumpling, btnFries, btnHotdog,
				btnBurger, btnSandwich, btnSushi, btnRandomSnack);

	}

	@FXML
	void processRandomSnack(ActionEvent event) {

		CustomizationController.food = Food.SNACK;
		snack = Snack.RAMDOMSNACKS;
		System.out.println("You choose Random Snacks" + snack);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnRandomSnack);
		HandleButtonController.handleButtonGroup(btnRandomSnack, btnChicken, btnDonut, btnDumpling, btnFries, btnHotdog,
				btnPizza, btnSandwich, btnSushi, btnBurger);

	}

	@FXML
	void processSandwich(ActionEvent event) {
		CustomizationController.food = Food.SNACK;
		snack = Snack.SANDWICH;
		System.out.println("You choose Sandwich" + snack);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnSandwich);
		HandleButtonController.handleButtonGroup(btnSandwich, btnChicken, btnDonut, btnDumpling, btnFries, btnHotdog,
				btnPizza, btnBurger, btnSushi, btnRandomSnack);

	}

	@FXML
	void processSushi(ActionEvent event) {
		CustomizationController.food = Food.SNACK;
		snack = Snack.SUSHI;
		System.out.println("You choose Sushi" + snack);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnSushi);
		HandleButtonController.handleButtonGroup(btnSushi, btnChicken, btnDonut, btnDumpling, btnFries, btnHotdog,
				btnPizza, btnSandwich, btnBurger, btnRandomSnack);

	}

	@FXML
	void processbacktoCustomize(ActionEvent event) {
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();

		// System.out.println("back to cust : " + animal);
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
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		snack = Snack.RAMDOMSNACKS;
		btnRandomSnack.setStyle("-fx-background-color: #007bff");
		HandleButtonController.selectedButton = btnRandomSnack;

	}

}
