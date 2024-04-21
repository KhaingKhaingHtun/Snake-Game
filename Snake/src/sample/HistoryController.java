package sample;

import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.AudioClip;
import model.History;
import model.HistoryDAO;
import model.User;

public class HistoryController implements Initializable {

	@FXML
	private Button btnHome;

	@FXML
	private Label lblBestTime;

	@FXML
	private Label lblHighestTotalScore;

	@FXML
	private Label lblLatestScore;

	@FXML
	private Label lblTitle;

	@FXML
	private Label lblTotalGamePlayed;

	private final HistoryDAO historyDAO = new HistoryDAO();

	public static User user;

	private AudioClip mouseClickSound;

	@FXML
	void processgotoHome(ActionEvent event) {

		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		System.out.println("Home UI");

//			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("HomeUI.fxml"));
//			Scene scene = new Scene(root);
//			Stage HomeStage = new Stage();
//			Game game = new Game(false);
//			game.getPrimaryStage().hide();
//			game.setPrimaryStage(HomeStage);
//			HomeStage.setTitle("Home UI");
//			HomeStage.setScene(scene);
//			HomeStage.show();

		ChangeSceneController changescene = ChangeSceneController.getInstance();
		changescene.changeScene("HomeUI.fxml", event, "History UI");

	}

	@FXML
	void processViewDetails(ActionEvent event) {
		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();
		ChangeSceneController changescene = ChangeSceneController.getInstance();
		changescene.changeScene("DetailUI.fxml", event, "Detail UI");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		user = MainController.user;
		System.out.println("In the history : user from Game" + user);
		ObservableList<History> allHistory = historyDAO.getAllScoresByUserId(user.getId());
		System.out.println(allHistory.size());
		History history = null;
		for (Iterator<History> iterator = allHistory.iterator(); iterator.hasNext();) {
			history = (History) iterator.next();
			System.out.println(history);
		}

		lblHighestTotalScore.setText(String.valueOf(historyDAO.getHighestScore(user.getId())));
		lblTotalGamePlayed.setText(String.valueOf(historyDAO.getTotalPlayedGame(user.getId())));
//		lblLatestScore.setText(String.valueOf(history.getTotal_score()));
		if (history == null) {
			lblLatestScore.setText("0");
		} else {
			lblLatestScore.setText(String.valueOf(history.getTotal_score()));
		}
		LocalTime besttime = historyDAO.getTimeInterval(user.getId());
		lblBestTime.setText(besttime.format(DateTimeFormatter.ofPattern("mm:ss")));

	}

}
