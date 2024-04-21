package sample;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HelpService {

	public static void Help() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Help");
		alert.setHeaderText("Game Instructions..!");

		DialogPane dialogPane = alert.getDialogPane();
		dialogPane.setPadding(new Insets(20));
		dialogPane.setBackground(
				new Background(new BackgroundFill(Color.rgb(69, 255, 202), CornerRadii.EMPTY, Insets.EMPTY)));

		Text instructionsText = new Text(
				"At first, Snake has 3 parts and 3 lives.\n\n" + "Eat food to increase its parts.\n\n"
						+ "If snake eats dynamites, it loses 3 parts and lose 1 life.\n\n"
						+ "If snake eats dynamites 3 times, Game Over.\n\n"
						+ "Snake must have 3 minimum parts, if not Game Over.\n\n"
						+ "As snake increases its length, it will also increase speed.\n\n"
						+ "Based on Levels, Speed increases and dynamites increases.");

		Font font = Font.font("Arial", 14);
		instructionsText.setFont(font);
		dialogPane.setContent(instructionsText);
		alert.showAndWait();
	}

}
