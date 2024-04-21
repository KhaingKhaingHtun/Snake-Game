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
import model.Insect;

public class InsectsController implements Initializable {

	@FXML
	private Button btnAnt;

	@FXML
	private Button btnBee;

	@FXML
	private Button btnBug;

	@FXML
	private Button btnButterfly;

	@FXML
	private Button btnCaterpillar;

	@FXML
	private Button btnCustomized;

	@FXML
	private Button btnDragonfly;

	@FXML
	private Button btnGrasshopper;

	@FXML
	private Button btnHome;

	@FXML
	private Button btnRandomInsects;

	@FXML
	private Button btnRhinoceros;

	@FXML
	private Button btnSpider;

	@FXML
	private Label lblStatus;

	@FXML
	private Label lblTitle;

	public static Insect insect;
	private AudioClip mouseClickSound;
	private Button selectedButton;

	@FXML
	void processAnt(ActionEvent event) {
		CustomizationController.food = Food.INSECTS;
		insect = Insect.ANT;
		System.out.println("You choose Ant" + insect);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnAnt);
		HandleButtonController.handleButtonGroup(btnAnt, btnBee, btnBug, btnButterfly, btnCaterpillar, btnDragonfly,
				btnGrasshopper, btnRhinoceros, btnSpider, btnRandomInsects);
	}

	@FXML
	void processBee(ActionEvent event) {
		CustomizationController.food = Food.INSECTS;
		insect = Insect.BEE;
		System.out.println("You choose Bee" + insect);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnBee);
		HandleButtonController.handleButtonGroup(btnBee, btnAnt, btnBug, btnButterfly, btnCaterpillar, btnDragonfly,
				btnGrasshopper, btnRhinoceros, btnSpider, btnRandomInsects);

	}

	@FXML
	void processBug(ActionEvent event) {
		CustomizationController.food = Food.INSECTS;
		insect = Insect.BUG;
		System.out.println("You choose Bug" + insect);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnBug);
		HandleButtonController.handleButtonGroup(btnBug, btnBee, btnAnt, btnButterfly, btnCaterpillar, btnDragonfly,
				btnGrasshopper, btnRhinoceros, btnSpider, btnRandomInsects);
	}

	@FXML
	void processButterfly(ActionEvent event) {
		CustomizationController.food = Food.INSECTS;
		insect = Insect.BUTTERFLY;
		System.out.println("You choose Butterfly" + insect);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnButterfly);
		HandleButtonController.handleButtonGroup(btnButterfly, btnBee, btnBug, btnAnt, btnCaterpillar, btnDragonfly,
				btnGrasshopper, btnRhinoceros, btnSpider, btnRandomInsects);
	}

	@FXML
	void processCaterpillar(ActionEvent event) {
		CustomizationController.food = Food.INSECTS;
		insect = Insect.CATERPILLAR;
		System.out.println("You choose Caterpillar" + insect);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnCaterpillar);
		HandleButtonController.handleButtonGroup(btnCaterpillar, btnBee, btnBug, btnButterfly, btnAnt, btnDragonfly,
				btnGrasshopper, btnRhinoceros, btnSpider, btnRandomInsects);
	}

	@FXML
	void processDragonfly(ActionEvent event) {
		CustomizationController.food = Food.INSECTS;
		insect = Insect.DRAGONFLY;
		System.out.println("You choose Dragonfly" + insect);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnDragonfly);
		HandleButtonController.handleButtonGroup(btnDragonfly, btnBee, btnBug, btnButterfly, btnCaterpillar, btnAnt,
				btnGrasshopper, btnRhinoceros, btnSpider, btnRandomInsects);

	}

	@FXML
	void processGrasshopper(ActionEvent event) {
		CustomizationController.food = Food.INSECTS;
		insect = Insect.GRASSHOPPER;
		System.out.println("You choose Grasshopper" + insect);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnGrasshopper);
		HandleButtonController.handleButtonGroup(btnGrasshopper, btnBee, btnBug, btnButterfly, btnCaterpillar,
				btnDragonfly, btnAnt, btnRhinoceros, btnSpider, btnRandomInsects);

	}

	@FXML
	void processRandomInsects(ActionEvent event) {
		CustomizationController.food = Food.INSECTS;
		insect = Insect.RANDOMINSECTS;
		// selectedButton = btnRandomInsects;
		System.out.println("You choose Random" + insect);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnRandomInsects);
		HandleButtonController.handleButtonGroup(btnRandomInsects, btnBee, btnBug, btnButterfly, btnCaterpillar,
				btnDragonfly, btnGrasshopper, btnRhinoceros, btnSpider, btnAnt);
	}

	@FXML
	void processRhinoceros(ActionEvent event) {
		CustomizationController.food = Food.INSECTS;
		insect = Insect.RHINOCEROS;
		System.out.println("You choose Rhinoceros-bettle" + insect);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnRhinoceros);
		HandleButtonController.handleButtonGroup(btnRhinoceros, btnBee, btnBug, btnButterfly, btnCaterpillar,
				btnDragonfly, btnGrasshopper, btnAnt, btnSpider, btnRandomInsects);
	}

	@FXML
	void processSpider(ActionEvent event) {
		CustomizationController.food = Food.INSECTS;
		insect = Insect.SPIDER;
		System.out.println("You choose Spider" + insect);
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		HandleButtonController.handleButtonSelection(btnSpider);
		HandleButtonController.handleButtonGroup(btnSpider, btnBee, btnBug, btnButterfly, btnCaterpillar, btnDragonfly,
				btnGrasshopper, btnRhinoceros, btnAnt, btnRandomInsects);
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
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		insect = Insect.RANDOMINSECTS;
		btnRandomInsects.setStyle("-fx-background-color: #007bff");
		HandleButtonController.selectedButton = btnRandomInsects;

	}

}
