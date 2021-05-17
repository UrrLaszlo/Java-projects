
public class Main {

	public static void main(String[] args) {

		int index = 25;

		System.out.println(getFibonacciNumber(index));
		System.out.println(getFibonacciNumber2(index));

		long number = 75025;

		if (whichFibonacciNumber(number) != 0) {
			System.out.println("A(z) " + number + " a(z) " + whichFibonacciNumber(number) + ". fibonacci szám.");
		} else {
			System.out.println("A(z) " + number + " nem fibonacci szám. ");
		}

		System.out.println(whichFibonacciNumber(number));
		
		

	}

	static long getFibonacciNumber(int index) {
		if (index <= 1) {
			return index;
		}
		return getFibonacciNumber(index - 1) + getFibonacciNumber(index - 2);
	}

	static long getFibonacciNumber2(int index) {
		try {
			long[] fibonacciNumbers = new long[index];
			fibonacciNumbers[0] = 1;
			fibonacciNumbers[1] = 1;
			for (int i = 2; i < fibonacciNumbers.length; i++) {
				fibonacciNumbers[i] = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];
			}
			return fibonacciNumbers[index - 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			return 1;
		}

	}

	static int getFibonacciNumberIndex(int number) {
		int counter = 0;
		if (getFibonacciNumber(number) == number) {
			return counter++;
		}
		return 0;
	}

	static int whichFibonacciNumber(long number) {
		int a, b, c ;
		a = 1;
		b = 1;
		for (int i = 3; i < Integer.MAX_VALUE; i++) {
			c = a + b;
			a = b;
			b = c;
			if (c == number) {
				return i;
			}
		}
		return 0;
	}

	static int whichFibonacciNumber2(long number) {
		int a, b, c;
		a = 1;
		b = 1;
		c = a + b;
		a = b;
		b = c;
		int counter = 0;
		if (whichFibonacciNumber2(number) != number) {
			counter++;
		}
		return counter;
	}
	
}
