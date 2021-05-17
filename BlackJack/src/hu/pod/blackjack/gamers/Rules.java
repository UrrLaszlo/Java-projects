package hu.pod.blackjack.gamers;

import hu.pod.blackjack.Result;

public interface Rules {

	void startShows();

	int calculateCardsValue();

	Result play(Result result);

}
