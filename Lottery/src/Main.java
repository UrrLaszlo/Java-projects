
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		Random randomNumber = new Random();
		
		// elsõ megoldás

		List<Integer> lotteryNumbers = new ArrayList<>();

		for (int i = 1; i < 91; i++) {
			lotteryNumbers.add(i);
		}

		int pulledOutNumber;
		List<Integer> winnerNumber = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			pulledOutNumber = randomNumber.nextInt(lotteryNumbers.size());
			Collections.shuffle(lotteryNumbers);
			winnerNumber.add(lotteryNumbers.get(pulledOutNumber));
			lotteryNumbers.remove(pulledOutNumber);
			System.out.println(winnerNumber.get(i));
			Thread.sleep(1000L);
		}
		Collections.sort(winnerNumber);
		System.out.println("A kisorsolt számok növekvõ sorrendben: " + winnerNumber.toString());

		
		
		// második megoldás

		System.out.println();
		System.out.println("második megoldás:");

		Set<Integer> winnerNumber2 = new TreeSet<Integer>();

		int pulledOutNumber2;

		while (winnerNumber2.size() != 5) {
			pulledOutNumber2 = randomNumber.nextInt(90) + 1;
			winnerNumber2.add(pulledOutNumber2);
			System.out.println(pulledOutNumber2);
			Thread.sleep(1000L);
		}

		System.out.println("A kisorsolt számok növekvõ sorrendben: " + winnerNumber2);

	}

}
