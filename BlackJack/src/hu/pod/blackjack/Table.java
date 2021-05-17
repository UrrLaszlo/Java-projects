package hu.pod.blackjack;

import hu.pod.blackjack.card.Deck;
import hu.pod.blackjack.gamers.Dealer;
import hu.pod.blackjack.gamers.Gamer;
import hu.pod.blackjack.gamers.Player;

public class Table {

	static Result result;

	public static void main(String[] args) {

		Deck deck = new Deck();

		Player player = new Player(deck);
		Dealer dealer = new Dealer(deck);

		do {
			result = null;

			player.placeABet();

			for (Gamer gamers : new Gamer[] { player, dealer }) {
				for (int i = 0; i < 2; i++) {
					gamers.getCard();
				}
				gamers.startShows();
			}

			if (player.isBlackjackValid()) {
				result = Result.BLACKJACK;
			} else {
				for (Gamer gamers : new Gamer[] { player, dealer }) {
					result = gamers.play(result);
				}
			}

			if (result == null) {
				if (player.calculateCardsValue() == dealer.calculateCardsValue()) {
					result = Result.TIE;
				} else if (player.calculateCardsValue() > dealer.calculateCardsValue()) {
					result = Result.WIN;
				} else {
					result = Result.LOSE;
				}
			}

			dealer.announcementOfResults(result);

			for (Gamer gamers : new Gamer[] { player, dealer }) {
				gamers.throwTheCards();
			}

			player.takesOverThePrize(result);

			if (player.isWentBankruptValid())
				System.out.println("Nincs több  pénzed!");
			else
				player.answersTheQuestion("Új leosztás?");

		} while (!player.isWentBankruptValid() && player.isYesValid());

		System.out.println("Köszönjük a játékot!");

	}

}
