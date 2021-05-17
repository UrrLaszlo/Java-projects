
public class CachEnemyMovingStrategy extends AbstractMovingStrategy {

	public CachEnemyMovingStrategy(MovingEntity entity) {
		super(entity);
	}

	@Override
	public Direction calculateNewDirection() {
		Enemy closestEnemy = getClosestEnemy();
		if (closestEnemy == null) {
			return entity.getDirection();
		}
		Coordinates closestEnemyCoordinates = closestEnemy.getCoordinates();
		return entity.getLevel().getShortestPath(entity.getDirection(), entity.getCoordinates(), closestEnemyCoordinates);
	}
	
	private Enemy getClosestEnemy() {
		int shortestDistance = Integer.MAX_VALUE;
		Enemy closestEnemy = null;
		for (Enemy enemy : entity.getLevel().getEnemies()) {
			int distanceFromEnemy = enemy.getCoordinates().distanceFrom(entity.getCoordinates());
			if (distanceFromEnemy < shortestDistance) {
				shortestDistance = distanceFromEnemy;
				closestEnemy = enemy;
			}
		}
		return closestEnemy;
	}

}
