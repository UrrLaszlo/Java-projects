package hu.pod.blackjack.gamers;

import hu.pod.blackjack.Result;
import hu.pod.blackjack.card.Deck;

public class Dealer extends Gamer {

	public Dealer(Deck deck) {
		super(deck);
	}

	@Override
	public void startShows() {
		System.out.println("Az osztó lapjai: " + hand.get(0).cardName() + "  [    ?    ]");
	}

	@Override
	public int calculateCardsValue() {
		return sum();
	}

	@Override
	public Result play(Result result) {
		if (result == null) {
			System.out.println("Az osztó lapjai: " + shows());
			do {
				if (!isSoftHandValid()) {
					getCard();
					if (isTooMuchValid()) {
						result = Result.WIN;
					}
				}
			} while (!isSoftHandValid());
			if (hand.size() > 2) {
				System.out.println("Az osztó lapjai: " + shows());
			}
		}
		return result;
	}

	private boolean isSoftHandValid() {
		return calculateCardsValue() > 16;
	}

	public void announcementOfResults(Result result) {
		System.out.println();
		System.out.println(result.getResult());
	}
}
