import java.util.Random;

public class BasicGame {

	static final int GAME_LOOP_NUMBER = 1000;
	static final int HEIGHT = 30;
	static final int WIDTH = 40;
	static final int ENEMIES = 3;
	static final int POWERUPS = 4;
	static Random RANDOM = new Random(12L);//858

	public static void main(String[] args) throws InterruptedException {

		Level level = new Level(RANDOM, HEIGHT, WIDTH);
		
		

		Player player = new Player("P", Direction.RIGHT, level);
		level.setPlayer(player);

		Enemy[] enemies = new Enemy[ENEMIES];
		for (int i = 0; i < ENEMIES; i++) {
			enemies[i] = new Enemy("E",
					level.getRandomCooedinatesAtLeastACertainDistanceFromGivenPoint(player.getCoordinates(), 10),
					Direction.LEFT, level);
		}
		level.setEnemies(enemies);

		PowerUp[] powerUps = new PowerUp[POWERUPS];
		for (int i = 0; i < POWERUPS / 2; i++) {
			powerUps[i] = new StrengsPowerUp(level);
		}
		for (int i = POWERUPS / 2; i < POWERUPS; i++) {
			powerUps[i] = new SlowdownPowerUp(level);
		}
		level.setPowerUps(powerUps);

		GameResult gameResult = GameResult.TIE;

		gameLoop: for (int iterationNumber = 1; iterationNumber < GAME_LOOP_NUMBER; iterationNumber++) {

			player.update();
			
			for (Enemy enemy : enemies) {
				enemy.update();
			}

			for (PowerUp powerUp : powerUps) {
				if (powerUp.update()) {

					player.setEscapeCoordinates(level.getFarthesCorner(player.getCoordinates()));
				}
			}

			// jÃ¡tÃ©kos - power-up interakciÃ³ lekezelÃ©se
			for (PowerUp powerUp : powerUps) {
				if (powerUp.isPresentOnLevel() && player.getCoordinates().isSameAs(powerUp.getCoordinates())) {
					powerUp.activate();
					powerUp.hideOnLevel();
					powerUp.resetPresentCounter();
					for (Enemy enemy : enemies) {
						enemy.setEscapeCoordinates(level.getFarthesCorner(enemy.getCoordinates()));
					}
				}
			}
			level.draw();

			addSomeDelay(200L, iterationNumber);

			// játékos és ellenfél azonos kordinátán van
			for (Enemy enemy : enemies) {
				if (player.getCoordinates().isSameAs(enemy.getCoordinates())) {
					if (level.isAnyStrengsPowerUpActive()) {
						gameResult = GameResult.WIN;
					} else {
						gameResult = GameResult.LOSE;
					}
					break gameLoop;
				}
			}
		}
		switch (gameResult) {
		case WIN:
			System.out.println("Gyõztél!");
			break;
		case LOSE:
			System.out.println("Vesztettél!");
			break;
		case TIE:
			System.out.println("Döntetlen!");
			break;

		}
	}

	static void addSomeDelay(long timeout, int iterationNumber) throws InterruptedException {
		System.out.println("---------------- " + iterationNumber + " ----------------");
		Thread.sleep(timeout);
	}
}
