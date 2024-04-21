package sample;

import java.awt.Point;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import model.Mode;

public class BombController {

	public static final String[] BOMB_IMAGE = new String[] { "/img/ic_bomb.png" };

	public static Image bombImage;
	public static int bombX;
	public static int bombY;

//	public static Food food = CustomizationController.food;
	public static Mode mode;

	public static MediaPlayer backgroundMusicPlayer;
	public static AudioClip explosionSound;
	public static AudioClip gameOverSound;
	public static AudioClip laserSound;
	public static AudioClip mouseClickSound;
	public static String laserShotFile;

	public static void generateBomb() {
		mode = CustomizationController.mode;
		// System.out.println("In bomb controller : Mode " + mode);
		switch (mode) {
		case NORMAL: {
			// System.out.println("Mode " + mode);
			start: while (true) {

				bombX = (int) (Math.random() * Game.ROWS);
				bombY = (int) (Math.random() * Game.COLUMNS);

				if (bombX == Game.foodX && bombY == Game.foodY) {
					continue start;
				}

				for (Point snake : Game.snakeBody) {
					if (snake.getX() == bombX && snake.getY() == bombY) {
						continue start;
					}
				}
				bombImage = new Image(BOMB_IMAGE[(int) (Math.random() * BOMB_IMAGE.length)]);
				break;
			}
		}
			break;
		case ENDLESS:
			break;
		}
//		System.out.println("Mode " + mode);
//		start: while (true) {
//
//			bombX = (int) (Math.random() * ROWS);
//			bombY = (int) (Math.random() * COLUMNS);
//
//			if (bombX == foodX && bombY == foodY) {
//				continue start;
//			}
//
//			for (Point snake : snakeBody) {
//				if (snake.getX() == bombX && snake.getY() == bombY) {
//					continue start;
//				}
//			}
//			bombImage = new Image(BOMB_IMAGE[(int) (Math.random() * BOMB_IMAGE.length)]);
//			break;
//		}
	}

	public static void drawBomb(GraphicsContext gc) {
		mode = CustomizationController.mode;
		// System.out.println("Mode " + mode);
		switch (mode) {
		case NORMAL:
			gc.drawImage(bombImage, bombX * Game.SQUARE_SIZE, bombY * Game.SQUARE_SIZE, Game.SQUARE_SIZE,
					Game.SQUARE_SIZE);
			break;
		case ENDLESS:
			break;
		}
	}

	public void eatBomb() {
		mode = CustomizationController.mode;
		switch (mode) {
		case NORMAL: {
			// System.out.println("Mode " + mode);
			if (Game.snakeHead.getX() == bombX && Game.snakeHead.getY() == bombY) {
				// snakeBody.add(new Point(-1, -1));

				generateBomb();
				Game.score -= 5;
				Game.lives -= 1;
				// generateFood();
				FoodsController.generateFood();
				// generateLife();
//				if (lives == 1) {
				//
//					generateLife();
//					System.out.println("In eat bomb : generate lives");
//				}

//				Game.snakeHeadImage = new Image(Game.SNAKEHEAD_CUSTOM[0]);
//				Game.gc.drawImage(Game.snakeHeadImage, Game.snakeHead.getX() * Game.SQUARE_SIZE,
//						Game.snakeHead.getY() * Game.SQUARE_SIZE, Game.SQUARE_SIZE, Game.SQUARE_SIZE);

				// eat dynamite sound
				String explosionSoundFile = "/audio/eat_dynamite_audio.mp3";
				explosionSound = new AudioClip(getClass().getResource(explosionSoundFile).toExternalForm());
				explosionSound.play();
				Game.backgroundMusicPlayer.setVolume(0.5);
			}
			Game.backgroundMusicPlayer.setVolume(1);
		}
			break;
		case ENDLESS:
			break;
		}
	}
}

//		System.out.println("Mode " + mode);
//		if (snakeHead.getX() == bombX && snakeHead.getY() == bombY) {
//			// snakeBody.add(new Point(-1, -1));
//
//			generateBomb();
//			score -= 5;
//			lives -= 1;
//			generateFood();
//			// generateLife();
////			if (lives == 1) {
////
////				generateLife();
////				System.out.println("In eat bomb : generate lives");
////			}
//
//			snakeHeadImage = new Image(SNAKEHEAD_CUSTOM[0]);
//			gc.drawImage(snakeHeadImage, snakeHead.getX() * SQUARE_SIZE, snakeHead.getY() * SQUARE_SIZE, SQUARE_SIZE,
//					SQUARE_SIZE);
//
//			// eat dynamite sound
//			String explosionSoundFile = "/audio/eat_dynamite_audio.mp3";
//			explosionSound = new AudioClip(getClass().getResource(explosionSoundFile).toExternalForm());
//			explosionSound.play();
//			backgroundMusicPlayer.setVolume(0.5);

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

//		}
//		backgroundMusicPlayer.setVolume(1);
//	}
