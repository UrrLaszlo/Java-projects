
public class PickUpPowerUpMovingStrategy extends AbstractMovingStrategy {

	public PickUpPowerUpMovingStrategy(MovingEntity entity) {
		super(entity);
	}

	@Override
	public Direction calculateNewDirection() {
		BasicEntity closestPresentPowerUp = getClosestPresentPowerUp();
		if (closestPresentPowerUp == null) {
			return entity.getDirection();
		}
		Coordinates closestPowerUpCoordinate = closestPresentPowerUp.getCoordinates();
		
		

		return entity.getLevel().getShortestPath(entity.getDirection(), entity.getCoordinates(),
				closestPowerUpCoordinate);
	}

	private BasicEntity getClosestPresentPowerUp() {
		int shortestDistance = Integer.MAX_VALUE;
		PowerUp closestPowerUp = null;
		for (PowerUp powerUp : entity.getLevel().getPowerUps()) {
			if (powerUp.isPresentOnLevel()) {
				int distanceFromPowerUp = powerUp.getCoordinates().distanceFrom(entity.getCoordinates());
				if (distanceFromPowerUp < shortestDistance) {
					shortestDistance = distanceFromPowerUp;
					closestPowerUp = powerUp;
				}
			}
		}
		return closestPowerUp;
	}
	

}
