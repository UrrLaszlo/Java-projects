package hu.pod.blackjack;

public enum Result {

	BLACKJACK("BLACKJACK", 6), WIN("NYERTÉL", 1), LOSE("VESZTETÉL", -1), TIE("DÖNTETLEN", 0);

	private final String result;
	private final int multiplier;

	private Result(String result, int multiplier) {
		this.result = result;
		this.multiplier = multiplier;
	}

	public String getResult() {
		return result;
	}

	public int getMultiplier() {
		return multiplier;
	}
}
