package hu.pod.poker;

import java.util.ArrayList;

import hu.pod.poker.cards.Card;

public class Gamers {

	protected ArrayList<Card> cards;

	public Gamers() {
		this.cards = new ArrayList<>();
	}

	protected ArrayList<Card> getCards() {
		return cards;
	}

	public void getCard(ArrayList<Card> deck) {
		cards.add(deck.get(0));
		deck.remove(0);
	}

	public void shows() {
		for (int i = 0; i < cards.size(); i++) {
			System.out.print(cards.get(i).cardName());
		}
	}
}
