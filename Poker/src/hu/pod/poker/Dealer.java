package hu.pod.poker;

import java.util.ArrayList;

import hu.pod.poker.cards.Card;

public class Dealer extends Gamers {

	public Dealer() {
		super();
	}

	public void startDeal(ArrayList<Card> deck) {
		for (int i = 0; i < 5; i++) {
			getCard(deck);
		}
	}

}
