
public abstract class PowerUp extends BasicEntity {

	private boolean presentOnLevel=true;
	private int presentCounter;
	private boolean active;
	private int activeCounter;

	public PowerUp(String mark,Level level) {
		super(mark,level.getRandomCooedinates(), level);
	}

	public int incrementPresentCounter() {
		return ++presentCounter;
	}

	public void resetPresentCounter() {
		presentCounter = 0;
	}

	public int incrementActiveCounter() {
		return ++activeCounter;
	}

	public void resetActiveCounter() {
		activeCounter = 0;
	}

	public boolean isPresentOnLevel() {
		return presentOnLevel;
	}

	public boolean isActive() {
		return active;
	}

	public void activate() {
		active = true;
	}

	public void deactivate() {
		active = false;
	}

	public void showOnLevel() {
		presentOnLevel = true;
	}

	public void hideOnLevel() {
		presentOnLevel = false;
	}
	
	public boolean update() {
		if (active)
			incrementActiveCounter();
		else
			incrementPresentCounter();
		if (presentCounter >= 60) {
			
			if (presentOnLevel) {
				setCoordinates(level.getRandomCooedinates());
				
			}
			hideOnLevel();
			resetPresentCounter();
		}
		if (activeCounter >= 60) {
			deactivate();
			resetActiveCounter();
			setCoordinates(level.getRandomCooedinates());
			return true;
		}
		return false;
	}
}
