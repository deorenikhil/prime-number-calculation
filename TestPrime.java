

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.InputMismatchException;

import org.junit.Test;

public class TestPrime {

	Prime prime = new Prime();

	//Test the method with positve test case
	@Test
	public void testFindPrimeNumbers() {
		int array[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
		ArrayList<Integer> expectedList = new ArrayList<Integer>();

		for (int i : array) {
			expectedList.add(i);
		}
		assertArrayEquals(expectedList.toArray(), prime.findPrimeNumbers(10).toArray());

	}

	//Test the method with less than zero input
	@Test(expected = IllegalArgumentException.class)
	public void testFindPrimeNumbersWithLessThanZeroInput() {
		prime.findPrimeNumbers(-2);
	}

	//Test the method with large input
	@Test
	public void testFindPrimeNumbersWithLargeInput() {
		int array[] = {2,3,5,7,11,13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541};
		ArrayList<Integer> expectedList = new ArrayList<Integer>();
		
		for(int i: array) {
			expectedList.add(i);
		}
		assertArrayEquals(expectedList.toArray(), prime.findPrimeNumbers(100).toArray());
	
	}

}
