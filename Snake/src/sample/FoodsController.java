package sample;

import java.awt.Point;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import model.Animal;
import model.Food;
import model.Fruit;
import model.Insect;
import model.Mode;
import model.Snack;

public class FoodsController {

	private static final String[] FRUITS_IMAGE = new String[] { "/img/ic_apple.png", "/img/ic_banana.png",
			"/img/ic_berry.png", "/img/ic_cherry.png", "/img/ic_coconut_.png", "/img/ic_watermelon.png",
			"/img/ic_orange.png", "/img/ic_peach.png", "/img/ic_pomegranate.png" };
//	private static final String[] ANIMALS_IMAGE = new String[] { "/img/animal_bird.png", "/img/animal_frog.png",
//			"/img/animal_hamster.png", "/img/animal_hedgehog.png", "/img/animal_mouse.png", "/img/animal_rabbit.png",
//			"/img/animal_squirrel.png" };
	private static final String[] ANIMALS_IMAGE = new String[] { "/img/animal1.png", "/img/animal2.png",
			"/img/animal3.png", "/img/animal4.png", "/img/animal5.png", "/img/animal6.png", "/img/animal7.png",
			"/img/animal8.png", "/img/animal9.png" };
	private static final String[] INSECTS_IMAGE = new String[] { "/img/insect1.png", "/img/insect2.png",
			"/img/insect3.png", "/img/insect4.png", "/img/insect5.png", "/img/insect6.png", "/img/insect7.png",
			"/img/insect8.png", "/img/insect9.png" };
	private static final String[] SNACKS_IMAGE = new String[] { "/img/snack1.png", "/img/snack2.png", "/img/snack3.png",
			"/img/snack4.png", "/img/snack5.png", "/img/snack6.png", "/img/snack7.png", "/img/snack8.png",
			"/img/snack9.png" };

	public static Image foodImage;
	public static int foodX;
	public static int foodY;

	public static Food food;
	public static Mode mode;
	public static Insect insect;
	public static Fruit fruit;
	public static Animal animal;
	public static Snack snack;

	public static MediaPlayer backgroundMusicPlayer;
	public static AudioClip explosionSound;
	public static AudioClip gameOverSound;
	public static AudioClip laserSound;
	public static AudioClip mouseClickSound;
	public static String laserShotFile;

	public static void Print() {

		food = CustomizationController.food;
		mode = CustomizationController.mode;
		insect = InsectsController.insect;
		fruit = FruitsController.fruit;
		animal = AnimalsController.animal;
		snack = SnacksController.snack;

//		System.out.println("Food " + food);
//		System.out.println("Fruit " + fruit);
//		System.out.println("Animal " + animal);
//		System.out.println("Insect " + insect);
//		System.out.println("Snack " + snack);
	}

	public static void generateFood() {

		start: while (true) {
			Print();
			foodX = (int) (Math.random() * Game.ROWS);
			foodY = (int) (Math.random() * Game.COLUMNS);

			if (foodX == BombController.bombX && foodY == BombController.bombY) {
				continue start;
			}

			for (Point snake : Game.snakeBody) {
				if (snake.getX() == foodX && snake.getY() == foodY) {
					continue start;
				}
			}

			switch (food) {
			case FRUITS: {
				switch (fruit) {

				case APPLE:
					foodImage = new Image(FRUITS_IMAGE[0]);
					break;
				case BANANA:
					foodImage = new Image(FRUITS_IMAGE[1]);
					break;
				case BERRY:
					foodImage = new Image(FRUITS_IMAGE[2]);
					break;
				case CHERRY:
					// foodImage = new Image(FRUITS_IMAGE[3]);
					foodImage = new Image(FRUITS_IMAGE[3]);
					break;
				case COCONUT:
					foodImage = new Image(FRUITS_IMAGE[4]);
					break;
				case MELON:
					foodImage = new Image(FRUITS_IMAGE[5]);
					break;
				case ORANGE:
					foodImage = new Image(FRUITS_IMAGE[6]);
					break;
				case PEACH:
					foodImage = new Image(FRUITS_IMAGE[7]);
					break;
				case POMEGRANATE:
					foodImage = new Image(FRUITS_IMAGE[8]);
					break;
				case RANDOMFRUITS:
					foodImage = new Image(FRUITS_IMAGE[(int) (Math.random() * FRUITS_IMAGE.length)]);
					break;
				}
			}
				// foodImage = new Image(FRUITS_IMAGE[(int) (Math.random() *
				// FRUITS_IMAGE.length)]);
				break;
			case ANIMALS: {
				switch (animal) {
				case BIRD:
					foodImage = new Image(ANIMALS_IMAGE[0]);
					break;
				case BUNNY:
					foodImage = new Image(ANIMALS_IMAGE[1]);
					break;
				case EGGS:
					foodImage = new Image(ANIMALS_IMAGE[2]);
					break;
				case FROG:
					foodImage = new Image(ANIMALS_IMAGE[3]);
					break;
				case HAMSTER:
					foodImage = new Image(ANIMALS_IMAGE[4]);
					break;
				case HEDGEHOG:
					foodImage = new Image(ANIMALS_IMAGE[5]);
					break;
				case KOALA:
					foodImage = new Image(ANIMALS_IMAGE[6]);
					break;
				case MOUSE:
					foodImage = new Image(ANIMALS_IMAGE[7]);
					break;
				case SQUIRREL:
					foodImage = new Image(ANIMALS_IMAGE[8]);
					break;
				case RANDOMANIMALS:
					foodImage = new Image(ANIMALS_IMAGE[(int) (Math.random() * ANIMALS_IMAGE.length)]);
					break;
				}
			}
				// foodImage = new Image(ANIMALS_IMAGE[(int) (Math.random() *
				// ANIMALS_IMAGE.length)]);
				break;
			case SNACK: {
				switch (snack) {
				case BURGER:
					foodImage = new Image(SNACKS_IMAGE[0]);
					break;
				case CHICKEN:
					foodImage = new Image(SNACKS_IMAGE[1]);
					break;
				case DONUT:
					foodImage = new Image(SNACKS_IMAGE[2]);
					break;
				case DUMPLING:
					foodImage = new Image(SNACKS_IMAGE[3]);
					break;
				case FRIES:
					foodImage = new Image(SNACKS_IMAGE[4]);
					break;
				case HOTDOG:
					foodImage = new Image(SNACKS_IMAGE[5]);
					break;
				case PIZZA:
					foodImage = new Image(SNACKS_IMAGE[6]);
					break;
				case SANDWICH:
					foodImage = new Image(SNACKS_IMAGE[7]);
					break;
				case SUSHI:
					foodImage = new Image(SNACKS_IMAGE[8]);
					break;
				case RAMDOMSNACKS:
					foodImage = new Image(SNACKS_IMAGE[(int) (Math.random() * SNACKS_IMAGE.length)]);
					break;
				}
			}
				break;
			case INSECTS: {
				switch (insect) {
				case ANT:
					foodImage = new Image(INSECTS_IMAGE[0]);
					break;
				case BEE:
					foodImage = new Image(INSECTS_IMAGE[1]);
					break;
				case BUG:
					foodImage = new Image(INSECTS_IMAGE[2]);
					break;
				case BUTTERFLY:
					foodImage = new Image(INSECTS_IMAGE[3]);
					break;
				case CATERPILLAR:
					foodImage = new Image(INSECTS_IMAGE[4]);
					break;
				case DRAGONFLY:
					foodImage = new Image(INSECTS_IMAGE[5]);
					break;
				case GRASSHOPPER:
					foodImage = new Image(INSECTS_IMAGE[6]);
					break;
				case RHINOCEROS:
					foodImage = new Image(INSECTS_IMAGE[7]);
					break;
				case SPIDER:
					foodImage = new Image(INSECTS_IMAGE[8]);
					break;
				case RANDOMINSECTS:
					foodImage = new Image(INSECTS_IMAGE[(int) (Math.random() * INSECTS_IMAGE.length)]);
					break;
				}

				// foodImage = new Image(INSECTS_IMAGE[(int) (Math.random() *
				// INSECTS_IMAGE.length)]);
			}

				break;
			}
			// foodImage = new Image(FRUITS_IMAGE[(int) (Math.random() *
			// FRUITS_IMAGE.length)]);
			break;
		}
	}

	public static void drawFood(GraphicsContext gc) {
		gc.drawImage(foodImage, foodX * Game.SQUARE_SIZE, foodY * Game.SQUARE_SIZE, Game.SQUARE_SIZE, Game.SQUARE_SIZE);
	}

	public void eatFood() {

		if (Game.snakeHead.getX() == foodX && Game.snakeHead.getY() == foodY) {
			Game.snakeBody.add(new Point(-1, -1));
			generateFood();
			Game.score += 5;
			Game.totalfruitEaten += 1;
			BombController.generateBomb();
			// generateLife();
//			if (lives == 1) {
//
//				generateLife();
//				System.out.println("4");
//			}

			// eat food sound
			String laserShotFile = "/audio/eat_food_audio.wav";
			laserSound = new AudioClip(getClass().getResource(laserShotFile).toExternalForm());
			laserSound.play();
//			laserSound.setVolume(2);
			Game.backgroundMusicPlayer.setVolume(0.2);
		}
		Game.backgroundMusicPlayer.setVolume(1);

	}
}
