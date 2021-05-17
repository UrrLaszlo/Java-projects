package hu.pod.poker.cards;

public class Card {

	private int suit;
	private int rank;

	public Card(int suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public int getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}

	private final String[] suits = { "Pikk", "Kör", "Káró", "Treff" };
	private final String[] ranks = { null, "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

	public String cardName() {
		String shows = ("[ " + suits[suit] + " - " + ranks[rank] + " ]  ");
		return shows;
	}

}
