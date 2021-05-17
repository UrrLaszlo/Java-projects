package hu.pod.blackjack.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> deck;

	public Deck() {
		this.deck = new ArrayList<>();
		List<Card> cards = new ArrayList<Card>();
		int value = 0;
		for (int suit = 0; suit < 4; suit++) {
			for (int rank = 1; rank < 14; rank++) {
				if (rank > 10)
					value = 10;
				else
					value = rank;
				Card card = new Card(suit, rank, value);
				cards.add(card);
			}
		}
		for (int numberOfDeck = 0; numberOfDeck < 8; numberOfDeck++) {
			deck.addAll(cards);
		}
		Collections.shuffle(deck);
	}

	public Card addCard() {
		Card card = deck.get(0);
		deck.remove(0);
		return card;
	}

}