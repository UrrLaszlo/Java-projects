package hu.pod.blackjack.gamers;

import java.util.ArrayList;
import java.util.List;

import hu.pod.blackjack.card.Card;
import hu.pod.blackjack.card.Deck;

public abstract class Gamer implements Rules {

	protected List<Card> hand;
	protected List<Integer> cardsValue;
	protected Deck deck;

	public Gamer(Deck deck) {
		this.hand = new ArrayList<>();
		this.cardsValue = new ArrayList<>();
		this.deck = deck;
	}

	public String shows() {
		String shows = "";
		for (int numberOfCards = 0; numberOfCards < hand.size(); numberOfCards++) {
			shows += hand.get(numberOfCards).cardName() + "  ";
		}
		return shows;
	}

	public void getCard() {
		Card card = deck.addCard();
		hand.add(card);
		if (sum() < 11 && card.getValue() == 1)
			cardsValue.add(11);
		else
			cardsValue.add(card.getValue());
	}

	protected int sum() {
		int sum = 0;
		for (int i = 0; i < cardsValue.size(); i++) {
			sum = sum + cardsValue.get(i);
		}
		return sum;
	}

	public boolean isBlackjackValid() {
		return hand.size() == 2 && calculateCardsValue() == 21;
	}

	public boolean isTooMuchValid() {
		return calculateCardsValue() > 21;
	}
	
	public void throwTheCards() {
		hand.removeAll(hand);
		cardsValue.removeAll(cardsValue);
	}
}
