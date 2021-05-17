package hu.pod.poker.cards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	private ArrayList<Card> deck;

	public Deck() {
		this.deck = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 14; j++) {
				Card card = new Card(i, j);
				deck.add(card);
			}
		}
	}

	public ArrayList<Card> mixer() {
		Collections.shuffle(deck);
		return deck;
	}

}
