package hu.pod.blackjack.card;

public class Card {

	private int suit;
	private int rank;
	private int value;

	public Card(int suit, int rank, int value) {
		this.suit = suit;
		this.rank = rank;
		this.value = value;
	}

	public int getRank() {
		return rank;
	}

	public int getValue() {
		return value;
	}

	private String[] suits = { "Treff", "Kör", "Káró", "Pikk" };
	private String[] ranks = { null, "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

	public String cardName() {
		String shows = "[ " + suits[suit] + " - " + ranks[rank] + " ]";
		return shows;
	}

}
