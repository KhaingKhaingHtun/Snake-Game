package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.AudioClip;
import model.Animal;
import model.Food;

public class AnimalsController implements Initializable {

	@FXML
	private Button btnBird;

	@FXML
	private Button btnBunny;

	@FXML
	private Button btnCustomized;

	@FXML
	private Button btnEgg;

	@FXML
	private Button btnFrog;

	@FXML
	private Button btnHamster;

	@FXML
	private Button btnHedgehog;

	@FXML
	private Button btnHome;

	@FXML
	private Button btnKoala;

	@FXML
	private Button btnMouse;

	@FXML
	private Button btnRandomAnimal;

	@FXML
	private Button btnSquirrel;

	@FXML
	private Label lblStatus;

	@FXML
	private Label lblTitle;

	public static Animal animal;
	private AudioClip mouseClickSound;

	@FXML
	void processBird(ActionEvent event) {
		CustomizationController.food = Food.ANIMALS;
		animal = Animal.BIRD;
		System.out.println("You choose Bird" + animal);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnBird);
		HandleButtonController.handleButtonGroup(btnBird, btnBunny, btnEgg, btnFrog, btnHamster, btnHedgehog, btnKoala,
				btnMouse, btnRandomAnimal, btnSquirrel);

	}

	@FXML
	void processBunny(ActionEvent event) {
		CustomizationController.food = Food.ANIMALS;
		animal = Animal.BUNNY;
		System.out.println("You choose Bunny" + animal);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnBunny);
		HandleButtonController.handleButtonGroup(btnBunny, btnBird, btnEgg, btnFrog, btnHamster, btnHedgehog, btnKoala,
				btnMouse, btnRandomAnimal, btnSquirrel);

	}

	@FXML
	void processEgg(ActionEvent event) {
		CustomizationController.food = Food.ANIMALS;
		animal = Animal.EGGS;
		System.out.println("You choose Eggs" + animal);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnEgg);
		HandleButtonController.handleButtonGroup(btnEgg, btnBunny, btnBird, btnFrog, btnHamster, btnHedgehog, btnKoala,
				btnMouse, btnRandomAnimal, btnSquirrel);

	}

	@FXML
	void processFrog(ActionEvent event) {
		CustomizationController.food = Food.ANIMALS;
		animal = Animal.FROG;
		System.out.println("You choose Frog" + animal);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnFrog);
		HandleButtonController.handleButtonGroup(btnFrog, btnBunny, btnEgg, btnBird, btnHamster, btnHedgehog, btnKoala,
				btnMouse, btnRandomAnimal, btnSquirrel);

	}

	@FXML
	void processHamster(ActionEvent event) {
		CustomizationController.food = Food.ANIMALS;
		animal = Animal.HAMSTER;
		System.out.println("You choose Hamster" + animal);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnHamster);
		HandleButtonController.handleButtonGroup(btnHamster, btnBunny, btnEgg, btnFrog, btnBird, btnHedgehog, btnKoala,
				btnMouse, btnRandomAnimal, btnSquirrel);

	}

	@FXML
	void processHedgehog(ActionEvent event) {
		CustomizationController.food = Food.ANIMALS;
		animal = Animal.HEDGEHOG;
		System.out.println("You choose Hedgehog" + animal);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnHedgehog);
		HandleButtonController.handleButtonGroup(btnHedgehog, btnBunny, btnEgg, btnFrog, btnHamster, btnBird, btnKoala,
				btnMouse, btnRandomAnimal, btnSquirrel);

	}

	@FXML
	void processKoala(ActionEvent event) {
		CustomizationController.food = Food.ANIMALS;
		animal = Animal.KOALA;
		System.out.println("You choose Koala" + animal);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnKoala);
		HandleButtonController.handleButtonGroup(btnKoala, btnBunny, btnEgg, btnFrog, btnHamster, btnHedgehog, btnBird,
				btnMouse, btnRandomAnimal, btnSquirrel);

	}

	@FXML
	void processMouse(ActionEvent event) {
		CustomizationController.food = Food.ANIMALS;
		animal = Animal.MOUSE;
		System.out.println("You choose Mouse" + animal);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnMouse);
		HandleButtonController.handleButtonGroup(btnMouse, btnBunny, btnEgg, btnFrog, btnHamster, btnHedgehog, btnKoala,
				btnSquirrel, btnRandomAnimal, btnBird);

	}

	@FXML
	void processRandomAnimal(ActionEvent event) {
		CustomizationController.food = Food.ANIMALS;
		animal = Animal.RANDOMANIMALS;
		System.out.println("You choose Random" + animal);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.selectedButton = btnRandomAnimal;
		HandleButtonController.handleButtonSelection(btnRandomAnimal);
		HandleButtonController.handleButtonGroup(btnRandomAnimal, btnBunny, btnEgg, btnFrog, btnHamster, btnHedgehog,
				btnKoala, btnMouse, btnSquirrel, btnBird);
	}

	@FXML
	void processSquirrel(ActionEvent event) {

		CustomizationController.food = Food.ANIMALS;
		animal = Animal.SQUIRREL;
		System.out.println("You choose squirrel" + animal);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnSquirrel);
		HandleButtonController.handleButtonGroup(btnSquirrel, btnBunny, btnEgg, btnFrog, btnHamster, btnHedgehog,
				btnKoala, btnMouse, btnRandomAnimal, btnBird);
	}

	@FXML
	void processbacktoCustomize(ActionEvent event) {
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();

		System.out.println("back to cust : " + animal);
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
		animal = Animal.RANDOMANIMALS;
		btnRandomAnimal.setStyle("-fx-background-color: #007bff");
		HandleButtonController.selectedButton = btnRandomAnimal;

	}

}
