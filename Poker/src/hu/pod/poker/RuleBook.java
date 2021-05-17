package hu.pod.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hu.pod.poker.cards.Card;

public class RuleBook {

	private List<Integer> ranks;
	private List<Integer> suits;
	private List<Card> result;

	public RuleBook(Player player, Dealer dealer) {
		this.ranks = new ArrayList<>();
		this.suits = new ArrayList<>();
		this.result = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			ranks.add(player.getCards().get(i).getRank());
			suits.add(player.getCards().get(i).getSuit());
			result.add(player.getCards().get(i));
		}
		for (int i = 0; i < 5; i++) {
			ranks.add(dealer.getCards().get(i).getRank());
			suits.add(dealer.getCards().get(i).getSuit());
			result.add(dealer.getCards().get(i));
		}
		Collections.sort(ranks);
		Collections.sort(suits);
	}

	public int pair() {
		for (int i = 1; i < 7; i++) {
			if (ranks.get(i - 1) == ranks.get(i))
				return 1;
		}
		return 0;
	}

	public int twoPair() {
		int counter = 0;
		for (int i = 1; i < 7; i++) {
			if (ranks.get(i - 1) == ranks.get(i))
				counter++;
		}
		if (counter == 2)
			return 1;
		else
			return 0;
	}

	public int drill() {
		for (int i = 2; i < 7; i++) {
			if (ranks.get(i - 2) == ranks.get(i))
				return 1;
		}
		return 0;
	}

	public int poker() {
		for (int i = 3; i < 7; i++) {
			if (ranks.get(i - 3) == ranks.get(i))
				return 1;
		}
		return 0;
	}

	public int flush() {
		for (int i = 4; i < 7; i++) {
			if (suits.get(i - 4) == suits.get(i))
				return 1;
		}
		return 0;
	}

	public int royalFlush() {
		int color = -1;
		int counter = 0;
		for (int i = 4; i < 7; i++) {
			if (suits.get(i - 4) == suits.get(i))
				color = suits.get(i);
		}
		if (color > -1) {
			for (int i = 0; i < 7; i++) {
				if ((result.get(i).getRank() == 1 && result.get(i).getSuit() == color)
						|| (result.get(i).getRank() == 10 && result.get(i).getSuit() == color)
						|| (result.get(i).getRank() == 11 && result.get(i).getSuit() == color)
						|| (result.get(i).getRank() == 12 && result.get(i).getSuit() == color)
						|| (result.get(i).getRank() == 13 && result.get(i).getSuit() == color)) {
					counter++;
				}
			}
		}
		if (counter >= 5)
			return 1;
		else
			return 0;
	}

	public int straight() {
		int counter = 0;
		for (int i = 1; i < 7; i++) {
			if (ranks.get(i) - ranks.get(i - 1) == 1)
				counter++;
		}
		if (counter >= 4)
			return 1;
		else
			return 0;
	}

	public int straightFlush() {
		int color = -1;
		int counter = 0;
		int[] straight = new int[7];
		for (int i = 4; i < 7; i++) {
			if (suits.get(i - 4) == suits.get(i))
				color = suits.get(i);
		}
		if (color > -1) {
			for (int i = 1; i < 7; i++) {
				if (ranks.get(i) - ranks.get(i - 1) == 1) {
					counter++;
					straight[i - 1] = ranks.get(i - 1);
				}
			}
		}
		if (counter >= 5) {
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 5; j++) {
					if (result.get(i).getRank() == straight[j] && result.get(i).getSuit() == color)
						counter++;
				}
			}
		}
		if (counter == 10)
			return 1;
		else
			return 0;
	}

	public int fullHouse() {
		int drill = 0;
		int counter = 0;
		for (int i = 2; i < 7; i++) {
			if (ranks.get(i - 2) == ranks.get(i)) {
				drill = ranks.get(i);
				for (int j = 1; j < 7; j++) {
					if (ranks.get(j - 1) == ranks.get(j) && ranks.get(j) != drill)
						counter++;
				}
			}
		}
		if (counter >= 1)
			return 1;
		else
			return 0;
	}

	public void resultCheck() {
		if (royalFlush() == 1)
			System.out.println("ROYAL FLUSH");
		else if (poker() == 1)
			System.out.println("POKER");
		else if (fullHouse() == 1)
			System.out.println("FULL");
		else if (straightFlush() == 1)
			System.out.println("SZÍN SOR");
		else if (flush() == 1)
			System.out.println("FLUSH");
		else if (straight() == 1)
			System.out.println("SOR");
		else if (drill() == 1)
			System.out.println("DRILL");
		else if (twoPair() == 1)
			System.out.println("KÉT PÁR");
		else if (pair() == 1)
			System.out.println("PÁR");
		else
			System.out.println("MAGAS LAP");
	}
	
}
