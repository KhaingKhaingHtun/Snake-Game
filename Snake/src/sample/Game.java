package sample;

import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Mode;
import model.Skin;
import model.Theme;
import model.User;

public class Game extends Application {

	public static final int WIDTH = 600;
	public static final int HEIGHT = WIDTH;
	public static final int ROWS = 20;
	public static final int COLUMNS = ROWS;
	public static final int SQUARE_SIZE = WIDTH / ROWS;
	// private static final String[] FRUITS_IMAGE = new String[] {
	// "/img/ic_orange.png", "/img/ic_apple.png",
	// "/img/ic_cherry.png","/img/ic_berry.png","/img/ic_coconut_.png","/img/ic_peach.png","/img/ic_watermelon.png","/img/ic_orange.png","/img/ic_pomegranate.png"};
	// private static final String[] ANIMALS_IMAGE = new String[] {
	// "/img/animal_bird.png", "/img/animal_frog.png",
	// "/img/animal_hamster.png","/img/animal_hedgehog.png","/img/animal_mouse.png","/img/animal_rabbit.png","/img/animal_squirrel.png"};
	// private static final String[] BOMB_IMAGE = new String[] { "/img/ic_bomb.png"
	// };
	// private static final String[] LIFE_IMAGE = new String[] { "/img/heart2.png"
	// };

	// private static final String[] SNAKEHEAD_IMAGE = new String[] {
	// "/img/angry_emoji1.png" };
//	private static final String[] SNAKEHEAD_IMAGE = new String[] { /* "/img/snake_head1.png", */ "/img/head_shu.png",
//			"/img/angry_emoji1.png", "/img/snake_head3.png" };
	public static final String[] SNAKEHEAD_IMAGE = new String[] { "/img/skin1.png", "/img/skin2.png", "/img/skin3.png",
			"/img/skin4.png", "/img/skin5.png", "/img/skin6.png" };
	public static final String[] SNAKEHEAD_CUSTOM = new String[] { "/img/emoji_poison.png", "/img/emoji_smiley.png" };

	private static final int RIGHT = 0;
	private static final int LEFT = 1;
	private static final int UP = 2;
	private static final int DOWN = 3;

	public static GraphicsContext gc;
	public static List<Point> snakeBody = new ArrayList();
	public static Point snakeHead;
	public static Image foodImage;
	public static int foodX;
	public static int foodY;
	public static Image bombImage;
	public static int bombX;
	public static int bombY;
	private static Image lifeImage;
	private static int lifeX;
	private static int lifeY;
	public static Image snakeHeadImage;
	public boolean gameOver;
	private int currentDirection;
	public static int score = 0;
	public static int lives = 3;
	public static int totalfruitEaten = 0;
	public LocalDateTime start;
	public LocalDateTime end;
	public static String formattedTime;
	public static KeyEvent event;
	public Timeline timeline;
	// public String GameOverTitle;

	public static Stage primaryStage;
	// public static Stage primaryStage = (Stage) ((Node)
	// event.getSource()).getScene().getWindow();
	private static Scene primaryscene;

	public static Button gameOverButton;
//	GameController controller = new GameController();

	public static MediaPlayer backgroundMusicPlayer;
	public AudioClip explosionSound;
	public AudioClip gameOverSound;
	public AudioClip laserSound;
	public AudioClip mouseClickSound;

	public static User user;
	public static Skin skin;
//	public static Food food;
	public static Theme theme;
	public static Mode mode;

	public Stage GamePlay(Stage stage) {

		primaryStage = stage;
//		Stage gamestage = new Stage();
//		gamestage = stage;

		primaryStage.setTitle("Snake");
		StackPane root = new StackPane();
		Canvas canvas = new Canvas(WIDTH, HEIGHT);

		gameOverButton = new Button("Game Over");
		gameOverButton.setStyle("-fx-background-color: #45FFCA; " + /* Green background color */
				"-fx-text-fill: black; " + /* White text color */
				"-fx-font-size: 25px;" + /* Font size */
				"-fx-background-radius: 30;" + /* Corner radius */
				"-fx-font-family: 'Broadway';");
		gameOverButton.setVisible(false);

		// gameOverButton.setOnAction());

		root.getChildren().add(canvas);
		root.getChildren().add(gameOverButton);
		primaryscene = new Scene(root);
		primaryStage.setScene(primaryscene);
		primaryStage.show();
		primaryStage.setResizable(false);

		gc = canvas.getGraphicsContext2D();

		drawBackground(gc);
		// drawSnake(gc);

		FoodsController.drawFood(gc);
		BombController.drawBomb(gc);
		drawScore(gc);
		timeDuration();

//		if (lives == 1) {
//			drawLife(gc);
//			System.out.println("7");
//		}

//		try {
//			start(primaryStage);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// timeDuration();
		// run(gc);
		return stage;

	}

	public Game(boolean gameOver) {
		super();
		this.gameOver = gameOver;

	}

	@Override
	public void start(Stage stage) throws Exception {
		start = LocalDateTime.now();
		user = MainController.user;
		skin = CustomizationController.skin;
		// food = CustomizationController.food;
		theme = CustomizationController.theme;
		mode = CustomizationController.mode;
		// System.out.println("In Game : user from homecontroller");

		// System.out.println("In the start " + gameOver);
//		gameOverButton = new Button("Game Over");
//		gameOverButton.setVisible(false);
		// start = LocalDateTime.now();
		/*
		 * primaryStage = stage;
		 * 
		 * primaryStage.setTitle("Snake"); StackPane root = new StackPane(); Canvas
		 * canvas = new Canvas(WIDTH, HEIGHT);
		 * 
		 * gameOverButton = new Button("Game Over"); gameOverButton.setVisible(false);
		 * 
		 * // gameOverButton.setOnAction());
		 * 
		 * root.getChildren().add(canvas); root.getChildren().add(gameOverButton);
		 * primaryscene = new Scene(root); primaryStage.setScene(primaryscene);
		 * primaryStage.show(); primaryStage.setResizable(false);
		 * 
		 * gc = canvas.getGraphicsContext2D();
		 */
		primaryStage = setPrimaryStage(GamePlay(stage));
		GamePlay(primaryStage);
//		start = LocalDateTime.now();
		primaryscene = primaryStage.getScene();
		primaryscene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {

				KeyCode code = event.getCode();
				if (code == KeyCode.RIGHT || code == KeyCode.D) {
					if (currentDirection != LEFT) {
						currentDirection = RIGHT;
					}
				} else if (code == KeyCode.LEFT || code == KeyCode.A) {
					if (currentDirection != RIGHT) {
						currentDirection = LEFT;
					}
				} else if (code == KeyCode.UP || code == KeyCode.W) {
					if (currentDirection != DOWN) {
						currentDirection = UP;
					}
				} else if (code == KeyCode.DOWN || code == KeyCode.S) {
					if (currentDirection != UP) {
						currentDirection = DOWN;
					}
				}
			}
		});

		for (int i = 0; i < 3; i++) {
			snakeBody.add(new Point(5, ROWS / 2));
		}
		snakeHead = snakeBody.get(0);
		FoodsController.generateFood();
		BombController.generateBomb();
		// generateLife();

//		if (lives == 1) {
//
//			generateLife();
//			System.out.println("5");
//		}

		// ActionEvent event = new ActionEvent();

		String backgroundMusicFile = "/audio/snakecharmer.mp3";
		Media backgroundMusic = new Media(getClass().getResource(backgroundMusicFile).toExternalForm());
		backgroundMusicPlayer = new MediaPlayer(backgroundMusic);
		backgroundMusicPlayer.setCycleCount(MediaPlayer.INDEFINITE);

		backgroundMusicPlayer.play();

		timeline = new Timeline(new KeyFrame(javafx.util.Duration.millis(130), e -> run(gc)));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();

	}

	public void run(GraphicsContext gc) {

		// System.out.println("In the run" + gameOver);

		if (gameOver) {
			backgroundMusicPlayer.stop();
			timeline.stop();
			// GameOverTitle = "Game Over";

			String gameOverClick = "/audio/game-over-sound.mp3";
			gameOverSound = new AudioClip(getClass().getResource(gameOverClick).toExternalForm());
			gameOverSound.play();

//			gc.setFill(Color.RED);
//			gc.setFont(new Font("Digital-7", 70));
//			gc.fillText("Game Over", WIDTH / 6, HEIGHT / 2 - 25);

			gameOverButton.setVisible(true);
			gameOverButton.setOnAction(event -> handleGameOver(event));
			snakeBody.removeAll(snakeBody);

//			snakeHead.move(10, 10);

//			Alert alert = new Alert(AlertType.CONFIRMATION);
//			alert.setTitle("Game Over");
//			alert.setHeaderText("Hee Hee");
//			alert.setContentText("Game Over! Your score: " + score);
//			alert.show();
//			alert.hide();
			// alert.setOnHidden(event -> System.exit(0));

//			TextInputDialog gameOverDialog = new TextInputDialog();
//			gameOverDialog.setTitle("Game Over");
//			gameOverDialog.setHeaderText("Hi");
//			gameOverDialog.setContentText("hello");
//
//			Optional<String> gameOverResult = gameOverDialog.showAndWait();

//			try {
//				FXMLLoader loader = new FXMLLoader(getClass().getResource("GameOverUI.fxml"));
//				AnchorPane root = loader.load();
//				Scene scene = new Scene(root);
////				AnchorPane root1 = (AnchorPane) FXMLLoader.load(getClass().getResource("GameOverUI.fxml"));
////				scene = new Scene(root1);
//				primaryStage.setScene(scene);
//				// primaryStage.setScene(scene);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

//			try {
//				AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("GamingUI.fxml"));
//				Scene scene = new Scene(root);
//				primaryStage.setScene(scene);
//				primaryStage.show();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

			// changeScene("GameOverUI.fxml", event, "Game Over");

			return;
		}

		drawBackground(gc);
		FoodsController.drawFood(gc);
		drawSnake(gc);
		BombController.drawBomb(gc);
		drawScore(gc);
		// drawLife(gc);
//		if (lives == 1) {
//			drawLife(gc);
//			System.out.println("In run : if -- draw Life");
//		}

		// fruitEaten();

		for (int i = snakeBody.size() - 1; i >= 1; i--) {
			snakeBody.get(i).x = snakeBody.get(i - 1).x;
			snakeBody.get(i).y = snakeBody.get(i - 1).y;
		}

		switch (currentDirection) {
		case RIGHT:
			moveRight();
			break;
		case LEFT:
			moveLeft();
			break;
		case UP:
			moveUp();
			break;
		case DOWN:
			moveDown();
			break;
		}

		gameOver();
		FoodsController foodsController = new FoodsController();
		foodsController.eatFood();
		BombController bombController = new BombController();
		bombController.eatBomb();
		// System.out.println("End time " + end);
		// eatLife();
		timeDuration();
	}

	public Stage getPrimaryStage() {

		// primaryStage = setPrimaryStage(primaryStage);
		GamePlay(primaryStage);
		return primaryStage;
	}

	public Stage setPrimaryStage(Stage stage) {
//		primaryStage = stage;
//		GamePlay(primaryStage);

		primaryStage = GamePlay(stage);

		return primaryStage;
	}

	public static Scene getGameScene() {
		return primaryscene;
	}

	public static Scene setGameScene(Scene scene) {
		primaryscene = scene;
		return scene;
	}

	private static void drawBackground(GraphicsContext gc) {
//		for (int i = 0; i < ROWS; i++) {
//			for (int j = 0; j < COLUMNS; j++) {
//				if ((i + j) % 2 == 0) {
//					gc.setFill(Color.web("AAD751"));
////					gc.setFill(Color.web("303030"));
//				} else {
//					gc.setFill(Color.web("A2D149"));
////					gc.setFill(Color.web("505050"));
//				}
//				gc.fillRect(i * SQUARE_SIZE, j * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
//			}
//		}

		switch (theme) {
		case LIGHT: {
			for (int i = 0; i < ROWS; i++) {
				for (int j = 0; j < COLUMNS; j++) {
					if ((i + j) % 2 == 0) {
						gc.setFill(Color.web("AAD751"));
//						gc.setFill(Color.web("303030"));
					} else {
						gc.setFill(Color.web("A2D149"));
//						gc.setFill(Color.web("505050"));
					}
					gc.fillRect(i * SQUARE_SIZE, j * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
				}
			}
		}

			break;

		case DARK: {
			for (int i = 0; i < ROWS; i++) {
				for (int j = 0; j < COLUMNS; j++) {
					if ((i + j) % 2 == 0) {
						// gc.setFill(Color.web("AAD751"));
//						gc.setFill(Color.web("303030"));
						// gc.setFill(Color.web("2C3E50")); // Dark blue-gray for even squares
						gc.setFill(Color.web("2E4053")); // Dark slate gray for even squares
					} else {
						// gc.setFill(Color.web("A2D149"));
						// gc.setFill(Color.web("505050"));
//						gc.setFill(Color.web("34495E")); // Slightly lighter blue-gray for odd squares
						gc.setFill(Color.web("34495E")); // Slightly lighter blue-gray for odd squares
					}
					gc.fillRect(i * SQUARE_SIZE, j * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
				}
			}
		}
			break;
		}

	}

	/*
	 * public static void generateFood() { start: while (true) { foodX = (int)
	 * (Math.random() * ROWS); foodY = (int) (Math.random() * COLUMNS);
	 * 
	 * if (foodX == bombX && foodY == bombY) { continue start; }
	 * 
	 * for (Point snake : snakeBody) { if (snake.getX() == foodX && snake.getY() ==
	 * foodY) { continue start; } }
	 * 
	 * switch (food) { case FRUITS: foodImage = new Image(FRUITS_IMAGE[(int)
	 * (Math.random() * FRUITS_IMAGE.length)]); break; case ANIMALS: foodImage = new
	 * Image(ANIMALS_IMAGE[(int) (Math.random() * ANIMALS_IMAGE.length)]); break; }
	 * // foodImage = new Image(FRUITS_IMAGE[(int) (Math.random() * //
	 * FRUITS_IMAGE.length)]); break; } }
	 * 
	 * private static void drawFood(GraphicsContext gc) { gc.drawImage(foodImage,
	 * foodX * SQUARE_SIZE, foodY * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE); }
	 */

	/*
	 * private void generateBomb() { start: while (true) { bombX = (int)
	 * (Math.random() * ROWS); bombY = (int) (Math.random() * COLUMNS);
	 * 
	 * if (bombX == foodX && bombY == foodY) { continue start; }
	 * 
	 * for (Point snake : snakeBody) { if (snake.getX() == bombX && snake.getY() ==
	 * bombY) { continue start; } } bombImage = new Image(BOMB_IMAGE[(int)
	 * (Math.random() * BOMB_IMAGE.length)]); break; } }
	 * 
	 * private static void drawBomb(GraphicsContext gc) { gc.drawImage(bombImage,
	 * bombX * SQUARE_SIZE, bombY * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE); }
	 */

//	private void generateLife() {
//		start: while (true) {
//
//			lifeX = (int) (Math.random() * ROWS);
//			lifeY = (int) (Math.random() * COLUMNS);
//
//			if (lifeX == bombX && lifeY == bombY) {
//				continue start;
//			}
//
//			if (lifeX == foodX && lifeY == foodY) {
//				continue start;
//			}
//
//			for (Point snake : snakeBody) {
//				if (snake.getX() == lifeX && snake.getY() == lifeY) {
//					continue start;
//				}
//			}
//
//			lifeImage = new Image(LIFE_IMAGE[(int) (Math.random() * LIFE_IMAGE.length)]);
//			System.out.println("In Generate Lives");
//			break;
//		}
//
//	}
//
//	private static void drawLife(GraphicsContext gc) {
////	if (lives == 1) {
////
////			gc.drawImage(lifeImage, lifeX * SQUARE_SIZE, lifeY * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
////			System.out.println("In draw Life");
////		}	
//		gc.drawImage(lifeImage, lifeX * SQUARE_SIZE, lifeY * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
//		System.out.println("In draw Life");
//
//	}

	private static void drawSnake(GraphicsContext gc) {
//		gc.setFill(Color.web("4674E9"));
//		gc.fillRoundRect(snakeHead.getX() * SQUARE_SIZE, snakeHead.getY() * SQUARE_SIZE, SQUARE_SIZE - 1,
//				SQUARE_SIZE - 1, 35, 35);

//		snakeHeadImage = new Image(SNAKEHEAD_IMAGE[(int) (Math.random() * SNAKEHEAD_IMAGE.length)]);
//		gc.drawImage(snakeHeadImage, snakeHead.getX() * SQUARE_SIZE, snakeHead.getY() * SQUARE_SIZE, SQUARE_SIZE,
//				SQUARE_SIZE);
//
//		gc.setFill(Color.web("FFD300"));
//		for (int i = 1; i < snakeBody.size(); i++) {
////			gc.fillRoundRect(snakeBody.get(i).getX() * SQUARE_SIZE, snakeBody.get(i).getY() * SQUARE_SIZE,
////					SQUARE_SIZE - 1, SQUARE_SIZE - 1, 20, 20);
//			gc.fillOval(snakeBody.get(i).getX() * SQUARE_SIZE, snakeBody.get(i).getY() * SQUARE_SIZE, SQUARE_SIZE - 1,
//					SQUARE_SIZE - 1);
//		}

		switch (skin) {
		case YELLOW:
			snakeHeadImage = new Image(SNAKEHEAD_IMAGE[0]);
			gc.drawImage(snakeHeadImage, snakeHead.getX() * SQUARE_SIZE, snakeHead.getY() * SQUARE_SIZE, SQUARE_SIZE,
					SQUARE_SIZE);

			gc.setFill(Color.web("FFD300"));
			for (int i = 1; i < snakeBody.size(); i++) {
//				gc.fillRoundRect(snakeBody.get(i).getX() * SQUARE_SIZE, snakeBody.get(i).getY() * SQUARE_SIZE,
//						SQUARE_SIZE - 1, SQUARE_SIZE - 1, 20, 20);
				gc.fillOval(snakeBody.get(i).getX() * SQUARE_SIZE, snakeBody.get(i).getY() * SQUARE_SIZE,
						SQUARE_SIZE - 1, SQUARE_SIZE - 1);
			}
			break;
		case RED:
			snakeHeadImage = new Image(SNAKEHEAD_IMAGE[1]);
			gc.drawImage(snakeHeadImage, snakeHead.getX() * SQUARE_SIZE, snakeHead.getY() * SQUARE_SIZE, SQUARE_SIZE,
					SQUARE_SIZE);

			// gc.setFill(Color.web("FF6347"));
			gc.setFill(Color.web("B22222"));
			for (int i = 1; i < snakeBody.size(); i++) {
//				gc.fillRoundRect(snakeBody.get(i).getX() * SQUARE_SIZE, snakeBody.get(i).getY() * SQUARE_SIZE,
//						SQUARE_SIZE - 1, SQUARE_SIZE - 1, 20, 20);
				gc.fillOval(snakeBody.get(i).getX() * SQUARE_SIZE, snakeBody.get(i).getY() * SQUARE_SIZE,
						SQUARE_SIZE - 1, SQUARE_SIZE - 1);
			}
			break;
		case GREEN:
			snakeHeadImage = new Image(SNAKEHEAD_IMAGE[2]);
			gc.drawImage(snakeHeadImage, snakeHead.getX() * SQUARE_SIZE, snakeHead.getY() * SQUARE_SIZE, SQUARE_SIZE,
					SQUARE_SIZE);

			// gc.setFill(Color.web("FF6347"));
			gc.setFill(Color.web("228B22"));
			for (int i = 1; i < snakeBody.size(); i++) {
//				gc.fillRoundRect(snakeBody.get(i).getX() * SQUARE_SIZE, snakeBody.get(i).getY() * SQUARE_SIZE,
//						SQUARE_SIZE - 1, SQUARE_SIZE - 1, 20, 20);
				gc.fillOval(snakeBody.get(i).getX() * SQUARE_SIZE, snakeBody.get(i).getY() * SQUARE_SIZE,
						SQUARE_SIZE - 1, SQUARE_SIZE - 1);
			}
			break;

		case SAD: {
			snakeHeadImage = new Image(SNAKEHEAD_IMAGE[3]);
			gc.drawImage(snakeHeadImage, snakeHead.getX() * SQUARE_SIZE, snakeHead.getY() * SQUARE_SIZE, SQUARE_SIZE,
					SQUARE_SIZE);

			gc.setFill(Color.web("FFD300"));
			for (int i = 1; i < snakeBody.size(); i++) {
//				gc.fillRoundRect(snakeBody.get(i).getX() * SQUARE_SIZE, snakeBody.get(i).getY() * SQUARE_SIZE,
//						SQUARE_SIZE - 1, SQUARE_SIZE - 1, 20, 20);
				gc.fillOval(snakeBody.get(i).getX() * SQUARE_SIZE, snakeBody.get(i).getY() * SQUARE_SIZE,
						SQUARE_SIZE - 1, SQUARE_SIZE - 1);
			}
		}
			break;
		case HAPPY: {
			snakeHeadImage = new Image(SNAKEHEAD_IMAGE[4]);
			gc.drawImage(snakeHeadImage, snakeHead.getX() * SQUARE_SIZE, snakeHead.getY() * SQUARE_SIZE, SQUARE_SIZE,
					SQUARE_SIZE);

			gc.setFill(Color.web("FFD300"));
			for (int i = 1; i < snakeBody.size(); i++) {
//				gc.fillRoundRect(snakeBody.get(i).getX() * SQUARE_SIZE, snakeBody.get(i).getY() * SQUARE_SIZE,
//						SQUARE_SIZE - 1, SQUARE_SIZE - 1, 20, 20);
				gc.fillOval(snakeBody.get(i).getX() * SQUARE_SIZE, snakeBody.get(i).getY() * SQUARE_SIZE,
						SQUARE_SIZE - 1, SQUARE_SIZE - 1);
			}
		}
			break;
		case ASHAMED: {
			snakeHeadImage = new Image(SNAKEHEAD_IMAGE[5]);
			gc.drawImage(snakeHeadImage, snakeHead.getX() * SQUARE_SIZE, snakeHead.getY() * SQUARE_SIZE, SQUARE_SIZE,
					SQUARE_SIZE);

			gc.setFill(Color.web("FFD300"));
			for (int i = 1; i < snakeBody.size(); i++) {
//				gc.fillRoundRect(snakeBody.get(i).getX() * SQUARE_SIZE, snakeBody.get(i).getY() * SQUARE_SIZE,
//						SQUARE_SIZE - 1, SQUARE_SIZE - 1, 20, 20);
				gc.fillOval(snakeBody.get(i).getX() * SQUARE_SIZE, snakeBody.get(i).getY() * SQUARE_SIZE,
						SQUARE_SIZE - 1, SQUARE_SIZE - 1);
			}
		}
			break;
		}
	}

	private void moveRight() {
		snakeHead.x++;
	}

	private void moveLeft() {
		snakeHead.x--;
	}

	private void moveUp() {
		snakeHead.y--;
	}

	private void moveDown() {
		snakeHead.y++;
	}

	public void gameOver() {

		if (snakeHead.x < 0 || snakeHead.y < 0 || snakeHead.x * SQUARE_SIZE >= WIDTH
				|| snakeHead.y * SQUARE_SIZE >= HEIGHT) {
			gameOver = true;
			// showGameOverAlert();
			// changeScene("GameOverUI.fxml", event, "Game Over");

		}
		if (lives == 0) {
			gameOver = true;
			// showGameOverAlert();
			// changeScene("GameOverUI.fxml", event, "Game Over");
		}

		// destroy itself
		for (int i = 1; i < snakeBody.size(); i++) {
			if (snakeHead.x == snakeBody.get(i).getX() && snakeHead.getY() == snakeBody.get(i).getY()) {
				gameOver = true;
				// showGameOverAlert();
				// changeScene("GameOverUI.fxml", event, "Game Over");
				break;
			}
		}

	}

	/*
	 * private void eatFood() {
	 * 
	 * if (snakeHead.getX() == foodX && snakeHead.getY() == foodY) {
	 * snakeBody.add(new Point(-1, -1)); generateFood(); score += 5; totalfruitEaten
	 * += 1; BombController.generateBomb(); // generateLife(); // if (lives == 1) {
	 * // // generateLife(); // System.out.println("4"); // }
	 * 
	 * // eat food sound String laserShotFile = "/audio/eat_food_audio.wav";
	 * laserSound = new
	 * AudioClip(getClass().getResource(laserShotFile).toExternalForm());
	 * laserSound.play(); // laserSound.setVolume(2);
	 * backgroundMusicPlayer.setVolume(0.2); } backgroundMusicPlayer.setVolume(1);
	 * 
	 * }
	 */

	/*
	 * private void eatBomb() {
	 * 
	 * if (snakeHead.getX() == bombX && snakeHead.getY() == bombY) { //
	 * snakeBody.add(new Point(-1, -1));
	 * 
	 * BombController.generateBomb(); score -= 5; lives -= 1; generateFood(); //
	 * generateLife(); // if (lives == 1) { // // generateLife(); //
	 * System.out.println("In eat bomb : generate lives"); // }
	 * 
	 * snakeHeadImage = new Image(SNAKEHEAD_CUSTOM[0]); gc.drawImage(snakeHeadImage,
	 * snakeHead.getX() * SQUARE_SIZE, snakeHead.getY() * SQUARE_SIZE, SQUARE_SIZE,
	 * SQUARE_SIZE);
	 * 
	 * // eat dynamite sound String explosionSoundFile =
	 * "/audio/eat_dynamite_audio.mp3"; explosionSound = new
	 * AudioClip(getClass().getResource(explosionSoundFile).toExternalForm());
	 * explosionSound.play(); backgroundMusicPlayer.setVolume(0.5); }
	 * backgroundMusicPlayer.setVolume(1); }
	 */

//			for (int i = 1; i < snakeBody.size() - 3; i++) {
//				// gc.fillRoundRect(snakeBody.get(i).getX() * SQUARE_SIZE,
//				// snakeBody.get(i).getY() * SQUARE_SIZE,
//				// SQUARE_SIZE - 1, SQUARE_SIZE - 1, 20, 20);
//				gc.setFill(Color.web("FFD352"));
//				gc.fillOval(snakeBody.get(i).getX() * SQUARE_SIZE, snakeBody.get(i).getY() * SQUARE_SIZE,
//						SQUARE_SIZE - 1, SQUARE_SIZE - 1);
//			}
//			snakeBody.remove(snakeBody.indexOf(0));

//			for (int i = 1; i < snakeBody.size(); i++) {
////				gc.fillRoundRect(snakeBody.get(i).getX() * SQUARE_SIZE, snakeBody.get(i).getY() * SQUARE_SIZE,
////						SQUARE_SIZE - 1, SQUARE_SIZE - 1, 20, 20);
//				gc.fillOval(snakeBody.get(i).getX() * SQUARE_SIZE, snakeBody.get(i).getY() * SQUARE_SIZE, SQUARE_SIZE - 1,
//						SQUARE_SIZE - 1);
//
//			}

//			snakeBody.remove(snakeBody.lastIndexOf(snakeBody));
//			try {
//				TimeUnit.SECONDS.sleep(1L);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

//	private void eatLife() {
//
//		if (snakeHead.getX() == lifeX && snakeHead.getY() == lifeY) {
//			// snakeBody.add(new Point(-1, -1));
//			// generateFood();
////			if (lives == 1) {
////
////				generateLife();
////				System.out.println("5");
////			}
//
////			score += 5;
////			totalfruitEaten += 1;
//			// generateLife();
//			generateBomb();
//			generateFood();
//
//			lives += 1;
//
//			// eat food sound
//			String laserShotFile = "/audio/eat_food_audio.wav";
//			laserSound = new AudioClip(getClass().getResource(laserShotFile).toExternalForm());
//			laserSound.play();
////			laserSound.setVolume(2);
//			backgroundMusicPlayer.setVolume(0.2);
//		}
//		backgroundMusicPlayer.setVolume(1);
//
//	}

	private void drawScore(GraphicsContext gc) {
		switch (theme) {
		case DARK:
			gc.setFill(Color.web("FFFAFA"));
			break;
		case LIGHT:
			gc.setFill(Color.web("333333"));
			break;
		}

		// gc.setFill(Color.web("333333"));
		gc.setFont(new Font("Digital-7", 20));
		gc.fillText("Score: " + score, 10, 30);
//		gc.setFill(Color.web("333333"));

		switch (mode) {
		case NORMAL:
			gc.setFont(new Font("Digital-7", 20));
			gc.fillText("Lives: " + lives, 510, 70);
			break;
		case ENDLESS:
			break;
		}

//		gc.setFill(Color.web("333333"));
		gc.setFont(new Font("Digital-7", 20));
		gc.fillText("Total Fruit Eaten: " + totalfruitEaten, 10, 70);
		gc.fillText("Duration: " + formattedTime, 400, 30);
		gc.setFont(new Font("Digital-7", 20));

	}

//	private void fruitEaten() {
//		gc.setFont(new Font("Digital-7", 20));
//		gc.fillText("Total Fruit Eaten: " + totalfruitEaten, 10, 70);
//		gc.setFill(Color.BLACK);
//
//	}

	public void timeDuration() {
		end = LocalDateTime.now();
		// System.out.println("end " + end);
		long secondCount = 0;
		Duration d = Duration.between(start, end);
		secondCount = d.getSeconds();
		long minuteCount = secondCount / 60;
		secondCount = secondCount % 60;
		long hourCount = minuteCount / 60;
		minuteCount = minuteCount % 60;
		formattedTime = String.format("%02d:%02d:%02d", hourCount, minuteCount, secondCount);
		// gc.setFill(Color.web("333333"));

	}
	// gc.fillText("Duration: " + formattedTime, 430, 35);
//		primaryStage.setTitle("Score: " + score + "\tFruit Eaten: " + totalfruitEaten + "\tDuration: " + formattedTime
//				+ "\tLives: " + lives);

	// return formattedTime;

//		long secondCount = (long) duration.toSeconds();
//		long minuteCount = secondCount / 60;
//		secondCount = secondCount % 60;
//		long hourCount = minuteCount / 60;
//		minuteCount = minuteCount % 60;

	// String formattedTime = String.format("%02d:%02d:%02d", hourCount,
	// minuteCount, secondCount);

//}

//	private void showGameOverAlert() {
//		Alert alert = new Alert(AlertType.INFORMATION);
//		alert.setTitle("Game Over");
//		alert.setHeaderText("Game Over");
//		alert.setContentText("Your score: " + score + "\nTotal Fruit Eaten: " + totalfruitEaten + "\nTime Duration: "
//				+ timeDuration());
//
//		alert.show();
//		alert.setOnHidden(event -> System.exit(0));
//
//	}

	private void handleGameOver(ActionEvent event) {

		String mouseClick = "/audio/mouse_click.mp3";
		mouseClickSound = new AudioClip(getClass().getResource(mouseClick).toExternalForm());
		mouseClickSound.play();

//		String clickSound = "/audio/clickButton.wav";
//		mouseClickSound = new AudioClip(getClass().getResource(clickSound).toExternalForm());
//		mouseClickSound.play();

		ChangeSceneController changescene = ChangeSceneController.getInstance();
		changescene.changeScene("GameOverUI.fxml", event, "Game Over UI");

//		getPrimaryStage().hide();
//		getPrimaryStage().setTitle("Game Over UI");

		// gameOver = false;

//		Connection connection = null;
//		PreparedStatement psInsert = null;
////		PreparedStatement psCheckUserExists = null;
////		ResultSet resultSet = null;
//
//		try {
//			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/snakegame", "root", "Admin*123");
//
//			psInsert = connection.prepareStatement(
//					"insert into history(total_fruit_eaten,total_score,start_time,end_time,user_id) values(?,?,?,?,?); ");
//			psInsert.setLong(1, totalfruitEaten);
//			psInsert.setLong(2, score);
////			psInsert.setString(3, tfEmail.getText().trim());
////			psInsert.setString(4, gender);
//			psInsert.setTimestamp(3, Timestamp.valueOf(start));
//			psInsert.setTimestamp(4, Timestamp.valueOf(end));
//			psInsert.setLong(5, user.setId(user.getId()));
//			psInsert.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		createHistory(user.getId());
		score = 0;
		totalfruitEaten = 0;
		lives = 3;
//		psCheckUserExists = connection.prepareStatement("select * from users where username = ?");
//		psCheckUserExists.setString(1, tfUsername.getText().trim());
//		resultSet = psCheckUserExists.executeQuery();
//
//		if (resultSet.isBeforeFirst()) {
//			System.out.println("user have already existed!");
//			Alert alert = new Alert(Alert.AlertType.ERROR);
//			alert.setContentText("You cannot use that username");
//			alert.show();
//			ChangeSceneController changescene = ChangeSceneController.getInstance();
//			changescene.changeScene("Signup.fxml", event, "Signup UI");
//
//		} else {

//		}

//		System.out.println("Hi");
//		primaryStage.hide();
//
//		AnchorPane root;
//		try {
//			root = (AnchorPane) FXMLLoader.load(getClass().getResource("GameOverUI.fxml"));
//			Scene scene = new Scene(root);
//			primaryStage.setScene(scene);
//			primaryStage.setTitle("Game Over UI");
//			primaryStage.show();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// changeScene("GameOverUI.fxml", event);
	}

	public boolean createHistory(Long userId) {
		boolean created = false;

		Connection connection = null;
		PreparedStatement psInsert = null;
//		PreparedStatement psCheckUserExists = null;
//		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/snakegame", "root", "Admin*123");

			psInsert = connection.prepareStatement(
					"insert into history(total_fruit_eaten,total_score,start_time,end_time,user_id,mode) values(?,?,?,?,?,?); ");
			psInsert.setLong(1, totalfruitEaten);
			psInsert.setLong(2, score);
//			psInsert.setString(3, tfEmail.getText().trim());
//			psInsert.setString(4, gender);
			psInsert.setTimestamp(3, Timestamp.valueOf(start));
			psInsert.setTimestamp(4, Timestamp.valueOf(end));
			psInsert.setLong(5, userId);
			psInsert.setString(6, mode.toString());
			created = psInsert.executeUpdate() > 0 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return created;

	}

//	public void changeScene(String fxmlFileName, ActionEvent event) {
//		try {
//			FXMLLoader loader = new FXMLLoader((getClass().getResource(fxmlFileName)));
//			Parent root = loader.load();
//			Scene scene = new Scene(root);
//			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//
//			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
////			primaryStage.hide();
//			primaryStage.setScene(scene);
//			// primaryStage.setTitle(title);
//			primaryStage.show();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

//	public static void main(String[] args) {
//		launch(args);
//	}
}