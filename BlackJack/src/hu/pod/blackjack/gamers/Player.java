package hu.pod.blackjack.gamers;

import java.util.Scanner;

import hu.pod.blackjack.Bank;
import hu.pod.blackjack.Result;
import hu.pod.blackjack.card.Deck;

public class Player extends Gamer {

	private String answer;
	private int pot;
	private Bank bank;

	public Player(Deck deck) {
		super(deck);
		this.answer = new String();
		this.pot = 0;
		this.bank = new Bank();
	}

	public void placeABet() {
		Scanner scan = new Scanner(System.in);
		System.out.println("zsetonjaid: " + bank.getMoney() + " Ft.");
		System.out.println();

		do {

			System.out.print("Tedd meg téted: ");
			if (scan.hasNextInt()) {
				pot = scan.nextInt();

			} else {
				System.out.println("Nem számot adtál meg");
				scan.nextLine();
			}
			if (!isBetTooMuch()) {
				System.out.println();
				System.out.println("Nincs elég pénzed!");
				System.out.println();
			}
			System.out.println();

		} while (!isBetTooMuch() || pot <= 0);

		System.out.println();
		System.out.println("tét: " + pot + " Ft.");
		System.out.println();
	}

	private boolean isBetTooMuch() {
		return pot <= bank.getMoney();
	}

	@Override
	public void startShows() {
		System.out.println("Lapjaid: " + shows());
		System.out.println();
	}

	@Override
	public int calculateCardsValue() {
		for (int i = 0; i < cardsValue.size(); i++) {
			if (sum() > 21 && cardsValue.get(i) == 11)
				cardsValue.set(i, 1);
		}
		int sum = sum();
		return sum;
	}

	@Override
	public Result play(Result result) {
		do {
			answersTheQuestion("Kérsz még lapot?");
			System.out.println();
			if (isYesValid()) {
				getCard();
				System.out.println("Lapjaid: " + shows());
			}
			if (isTooMuchValid()) {
				result = Result.LOSE;
			}
		} while (!isTooMuchValid() && isYesValid());
		return result;
	}

	public boolean isYesValid() {
		return answer.equals("i");
	}

	public void answersTheQuestion(String question) {
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println();
			System.out.print(question);
			answer = scan.nextLine();
		} while (!isAnswerValid());
	}

	private boolean isAnswerValid() {
		return answer.equals("i") || answer.equals("n");
	}

	public void takesOverThePrize(Result result) {
		int prize = pot * result.getMultiplier();
		if (prize < 0)
			System.out.println("vesztettél: " + Math.abs(prize) + " Ft.-ot");
		else
			System.out.println("nyereményed: " + prize + " Ft.");
		int newBank = bank.getMoney() + prize;
		bank.setMoney(newBank);
	}

	public boolean isWentBankruptValid() {
		return bank.getMoney() == 0;
	}
}
