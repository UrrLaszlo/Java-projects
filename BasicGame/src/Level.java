import java.util.Random;

public class Level {

	private final int height;
	private final int width;
	private final String[][] level;
	private final Random RANDOM;
	private Player player;
	private Enemy[] enemies;
	private PowerUp[] powerUps;

	public Level(Random random, int height, int width) {
		this.RANDOM = random;
		this.height = height;
		this.width = width;
		this.level = new String[height][width];
		int lastRowIndex = height - 1;
		int lastColumnIndex = width - 1;
		do {
			initLevelWithSurrondingWalls(height, width, lastRowIndex, lastColumnIndex);
			addRandomWalls();
		} while (!isPassible());
	}

	private void initLevelWithSurrondingWalls(int height, int width, int lastRowIndex, int lastColumnIndex) {
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				if (row == 0 || column == 0 || row == lastRowIndex || column == lastColumnIndex) {
					level[row][column] = "*";
				} else {
					level[row][column] = " ";
				}
			}
		}
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

	public Enemy[] getEnemies() {
		return enemies;
	}

	public PowerUp[] getPowerUps() {
		return powerUps;
	}

	public void setEnemies(Enemy[] enemies) {
		this.enemies = enemies;
	}

	public void setPowerUps(PowerUp[] powerUps) {
		this.powerUps = powerUps;
	}

	public void addRandomWalls() {
		addRandomWalls(15, 15);
	}

	public void addRandomWalls(int numberOfHorizontalWalls, int numberOfVerticalWalls) {
		for (int i = 0; i < numberOfHorizontalWalls; i++) {
			addHorizontalWall();
		}
		for (int i = 0; i < numberOfVerticalWalls; i++) {
			addVerticalWall();
		}
	}

	private void addHorizontalWall() {
		int wallWidth = RANDOM.nextInt(width - 3);
		int wallRow = RANDOM.nextInt(height - 2) + 1;
		int wallColumn = RANDOM.nextInt(width - 2 - wallWidth);
		for (int i = 0; i < wallWidth; i++) {
			level[wallRow][wallColumn + i] = "*";
		}
	}

	private void addVerticalWall() {
		int wallHeight = RANDOM.nextInt(height - 3);
		int wallRow = RANDOM.nextInt(height - 2 - wallHeight);
		int wallColumn = RANDOM.nextInt(width - 2) + 1;
		for (int i = 0; i < wallHeight; i++) {
			level[wallRow + i][wallColumn] = "*";
		}
	}

	public boolean isPassible(boolean draw) {
		String[][] levelCopy = copy(level);
		outer: for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				if (" ".equals(levelCopy[row][column])) {
					levelCopy[row][column] = "o";
					break outer;
				}
			}
		}
		while (spreadAsterixs(levelCopy)) {
			if (draw) {
				for (int row = 0; row < height; row++) {
					for (int column = 0; column < width; column++) {
						System.out.print(levelCopy[row][column]);
					}
					System.out.println();
				}
			}
		}
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				if (" ".equals(levelCopy[row][column])) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isPassible() {
		return isPassible(false);
	}

	private boolean spreadAsterixs(String[][] levelCopy) {
		boolean changed = false;
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				if ("o".equals(levelCopy[row][column])) {
					if (" ".equals(levelCopy[row - 1][column])) {
						levelCopy[row - 1][column] = "o";
						changed = true;
					}
					if (" ".equals(levelCopy[row + 1][column])) {
						levelCopy[row + 1][column] = "o";
						changed = true;
					}
					if (" ".equals(levelCopy[row][column - 1])) {
						levelCopy[row][column - 1] = "o";
						changed = true;
					}
					if (" ".equals(levelCopy[row][column + 1])) {
						levelCopy[row][column + 1] = "o";
						changed = true;
					}
				}
			}
		}
		return changed;
	}

	private String[][] copy(String[][] level) {
		String[][] copy = new String[height][width];
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				copy[row][column] = level[row][column];
			}
		}
		return copy;
	}

	private boolean spreadAsterixsWithCheck(String[][] levelCopy) {
		boolean[][] mask = new boolean[height][width];
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				if ("o".equals(levelCopy[row][column])) {
					mask[row][column] = true;
				}
			}
		}
		boolean changed = false;
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				if ("o".equals(levelCopy[row][column]) && mask[row][column]) {
					if (" ".equals(levelCopy[row - 1][column])) {
						levelCopy[row - 1][column] = "o";
						changed = true;
					}
					if (" ".equals(levelCopy[row + 1][column])) {
						levelCopy[row + 1][column] = "o";
						changed = true;
					}
					if (" ".equals(levelCopy[row][column - 1])) {
						levelCopy[row][column - 1] = "o";
						changed = true;
					}
					if (" ".equals(levelCopy[row][column + 1])) {
						levelCopy[row][column + 1] = "o";
						changed = true;
					}
				}
			}
		}
		return changed;
	}

	public boolean isEmpty(Coordinates coordinates) {
		return " ".equals(level[coordinates.getRow()][coordinates.getColumn()]);
	}

	public Direction getShortestPath(Direction defaultDirection, Coordinates from, Coordinates to) {
		String[][] levelCopy = copy(level);
		levelCopy[to.getRow()][to.getColumn()] = "o";
		while (spreadAsterixsWithCheck(levelCopy)) {
			if ("o".equals(levelCopy[from.getRow() - 1][from.getColumn()])) {
				return Direction.UP;
			}
			if ("o".equals(levelCopy[from.getRow() + 1][from.getColumn()])) {
				return Direction.DOWN;
			}
			if ("o".equals(levelCopy[from.getRow()][from.getColumn() - 1])) {
				return Direction.LEFT;
			}
			if ("o".equals(levelCopy[from.getRow()][from.getColumn() + 1])) {
				return Direction.RIGHT;
			}
		}
		return defaultDirection;
	}

	public Coordinates getFarthesCorner(Coordinates from) {
		String[][] levelCopy = copy(level);
		levelCopy[from.getRow()][from.getColumn()] = "o";
		int farthesRow = 0;
		int farthesColumn = 0;
		while (spreadAsterixsWithCheck(levelCopy)) {
			outer: for (int row = 0; row < height; row++) {
				for (int column = 0; column < width; column++) {
					if (" ".equals(levelCopy[row][column])) {
						farthesRow = row;
						farthesColumn = column;
						break outer;
					}
				}
			}
		}
		return new Coordinates(farthesRow, farthesColumn);
	}

	public String getCell(Coordinates coordinates) {
		return level[coordinates.getRow()][coordinates.getColumn()];
	}

	public Coordinates getRandomCooedinates() {
		Coordinates randomCoordinates;
		do {
			randomCoordinates = new Coordinates(RANDOM.nextInt(height), RANDOM.nextInt(width));
		} while (!isEmpty(randomCoordinates));
		return randomCoordinates;
	}

	public Coordinates getRandomCooedinatesAtLeastACertainDistanceFromGivenPoint(Coordinates coordinates,
			int distance) {
		Coordinates randomCoordinates;
		int counter = 0;
		do {
			randomCoordinates = getRandomCooedinates();
		} while (counter++ < 1000 && randomCoordinates.distanceFrom(coordinates) < distance);
		return randomCoordinates;
	}

	public void draw() {
		String[][] drawBuffer = copy(level);
		drawBuffer[player.getCoordinates().getRow()][player.getCoordinates().getColumn()] = player.getMark();
		for (Enemy enemy : enemies) {
			drawBuffer[enemy.getCoordinates().getRow()][enemy.getCoordinates().getColumn()] = enemy.getMark();
		}
		for (PowerUp powerUp : powerUps) {
			if (powerUp.isPresentOnLevel()) {
				drawBuffer[powerUp.getCoordinates().getRow()][powerUp.getCoordinates().getColumn()] = powerUp.getMark();
			}

		}

		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				System.out.print(drawBuffer[row][column]);
			}
			System.out.println();
		}
	}

	public boolean isAnyStrengsPowerUpActive() {
		for (PowerUp powerUp : powerUps) {
			if (powerUp instanceof StrengsPowerUp && powerUp.isActive()) {
				return true;
			}
		}
		return false;
	}

	public int getShortestPathtoPowerUp(Coordinates to, Coordinates from) {
		String[][] levelCopy = copy(level);
		int counter = 0;
		levelCopy[to.getRow()][to.getColumn()] = "o";
		while (spreadAsterixsWithCheck(levelCopy)) {
			if ("o".equals(levelCopy[from.getRow() - 1][from.getColumn()])) {
				break;
			}
			if ("o".equals(levelCopy[from.getRow() + 1][from.getColumn()])) {
				break;
			}
			if ("o".equals(levelCopy[from.getRow()][from.getColumn() - 1])) {
				break;
			}
			if ("o".equals(levelCopy[from.getRow()][from.getColumn() + 1])) {
				break;
			}
		}
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				if (levelCopy[row][column].equals("o")) {
					counter++;
				}
			}
		}

		return counter;
	}

}
