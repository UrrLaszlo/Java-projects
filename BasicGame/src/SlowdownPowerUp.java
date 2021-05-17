
public class SlowdownPowerUp extends PowerUp {

	public SlowdownPowerUp(Level level) {
		super("+", level);

	}

	@Override
	public void activate() {
		super.activate();
		for (Enemy enemy : level.getEnemies()) {
			enemy.setSlowed(true);
		}
	}

	@Override
	public void deactivate() {
		super.deactivate();
		for (Enemy enemy : level.getEnemies()) {
			enemy.setSlowed(false);
		}
	}

}
