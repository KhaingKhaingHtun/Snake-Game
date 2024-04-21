package sample;

import javafx.scene.control.Button;

public class HandleButtonController {
	public static Button selectedButton;

	public static void handleButtonSelection(Button button) {
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

	public static void handleButtonGroup(Button... buttons) {
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
}
