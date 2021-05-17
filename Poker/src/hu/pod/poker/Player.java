package hu.pod.poker;

import java.util.ArrayList;

import hu.pod.poker.cards.Card;

public class Player extends Gamers {

	public Player() {
		super();
	}

	public void startDeal(ArrayList<Card> deck) {
		for (int i = 0; i < 2; i++) {
			getCard(deck);
		}
	}

}
