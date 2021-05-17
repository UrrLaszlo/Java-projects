
public class CachPlayerMovingStrategy extends AbstractMovingStrategy {

	public CachPlayerMovingStrategy(MovingEntity entity) {
		super(entity);
	}

	@Override
	public Direction calculateNewDirection() {
		return entity.getLevel().getShortestPath(entity.getDirection(), entity.getCoordinates(),
				entity.getLevel().getPlayer().getCoordinates());
	}

}
