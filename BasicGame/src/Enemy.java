import java.util.Locale.Category;

public class Enemy extends MovingEntity {

	private int iterationNumber;
	private boolean slowed;

	public Enemy(String mark, Coordinates coordinates, Direction direction, Level level) {
		super(mark, coordinates, direction, level);
		currentMovingStrategy = new CachPlayerMovingStrategy(this);
	}

	public void setSlowed(boolean slowed) {
		this.slowed = slowed;
	}

	@Override
	public boolean update() {
		if (iterationNumber++ % (slowed ? 4 : 2) == 0) {
			if (level.isAnyStrengsPowerUpActive()) {
				if (iterationNumber++ % 100 == 0) {
					escapeCoordinates = level.getFarthesCorner(coordinates);
				}
				currentMovingStrategy= new EscapeMovingStrategy(this);
			} else {
				currentMovingStrategy = new CachPlayerMovingStrategy(this);
			}
			direction = currentMovingStrategy.calculateNewDirection();
			return super.update();
		}
		return false;
	}

}
