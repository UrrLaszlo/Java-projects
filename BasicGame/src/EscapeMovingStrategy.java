
public class EscapeMovingStrategy extends AbstractMovingStrategy{

	public EscapeMovingStrategy(MovingEntity entity) {
		super(entity);
	}

	@Override
	public Direction calculateNewDirection() {
		return entity.getLevel().getShortestPath(entity.getDirection(), entity.getCoordinates(), entity.getEscapeCoordinates());
	}

}
