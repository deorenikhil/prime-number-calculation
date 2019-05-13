

import java.util.ArrayList;
import java.util.Scanner;

public class Prime {

	/* Method to calculate first N prime numbers
	 * @argument int
	 * @returnType ArrayList<Integer>
	 * 
	 * Method checks for prime number by dividing the previous (N-1) prime numbers
	 * If the previous (N-1)th prime number is less than the square root of N (next candidate for checking the prime number)  
	 */
	public ArrayList<Integer> findPrimeNumbers(int N) throws IllegalArgumentException {

		if (N < 1) {
			throw new IllegalArgumentException(" Number should be greater than 0 ");
		}

		ArrayList<Integer> primes = new ArrayList<Integer>();
		boolean isPrime = true;
		primes.add(2);

		for (int num = 3; primes.size() < N; num++) {
			isPrime = true;
			int j = 0;
			for (; j < primes.size(); j++) {
				if (num % primes.get(j) == 0) {
					isPrime = false;
					break;
				}
			}
			
			//check for every number greater than the last prime number which is less than the sqaure root
			if (isPrime && j > 0 && primes.get(j - 1) < Math.sqrt(num)) {
				for (int k = primes.get(j - 1); k <= Math.sqrt(num); k++) {
					if (num % k == 0) {
						isPrime = false;
						break;
					}
				}

			}

			if (isPrime)
				primes.add(num);

		}
		return primes;
	}

	public void printTable(ArrayList<Integer> primes) {

		int number = primes.get(primes.size() - 1);
		int product = number * number;

		int numberOfDigits = 1;

		while (product > 0) {
			product = product / 10;
			numberOfDigits++;
		}

		System.out.printf("%-" + numberOfDigits + "s", "");
		for (int k = 0; k < primes.size(); k++) {
			System.out.printf("%-" + numberOfDigits + "d", primes.get(k));
		}
		System.out.println();
		for (int i = 0; i < primes.size(); i++) {
			System.out.printf("%-" + numberOfDigits + "d", primes.get(i));
			for (int j = 0; j < primes.size(); j++) {
				System.out.printf("%-" + numberOfDigits + "d", primes.get(i) * primes.get(j));
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number for how many first prime numbers you want to see :");
		int N = sc.nextInt();
		Prime prime = new Prime();
		ArrayList<Integer> list = prime.findPrimeNumbers(N);
		prime.printTable(list);
		// System.out.println(primes);
	}

}
