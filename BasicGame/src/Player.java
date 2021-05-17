
public class Player extends MovingEntity {

	private int iterationNumber;

	public Player(String mark, Direction direction, Level level) {
		super(mark, level.getRandomCooedinates(), direction, level);
		currentMovingStrategy = new EscapeMovingStrategy(this);
	}

	@Override
	public boolean update() {
		if (level.isAnyStrengsPowerUpActive()) {
			currentMovingStrategy = new EscapeMovingStrategy(this);
		} else {
			if (isAnyPowerUpOnLevel()) {
				currentMovingStrategy = new PickUpPowerUpMovingStrategy(this);
			} else {
				if (iterationNumber++ % 100 == 0) {
					setEscapeCoordinates(level.getFarthesCorner(coordinates));
				}
				currentMovingStrategy = new EscapeMovingStrategy(this);
			}
		}
		direction = currentMovingStrategy.calculateNewDirection();
		return super.update();
	}

	private boolean isAnyPowerUpOnLevel() {
		for (PowerUp powerUp : level.getPowerUps()) {
			if (powerUp.isPresentOnLevel()) {
				return true;
			}
		}
		return false;
	}

}
