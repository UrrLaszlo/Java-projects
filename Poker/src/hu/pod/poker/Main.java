package hu.pod.poker;

import java.util.ArrayList;

import hu.pod.poker.cards.Card;
import hu.pod.poker.cards.Deck;

public class Main {

	public static void main(String[] args) {

		Deck mixDeck = new Deck();
		ArrayList<Card> deck = mixDeck.mixer();

		Player player = new Player();
		Dealer dealer = new Dealer();
		Gamers[] gamer = { player, dealer };

		player.startDeal(deck);
		dealer.startDeal(deck);
		for (Gamers gamers : gamer) {
			gamers.shows();
			System.out.println();
		}
		System.out.println();
		RuleBook ruleBook = new RuleBook(player, dealer);

		ruleBook.resultCheck();
		
		

	}

}
