package com.solutions;

/***
 * Given an integer, write a function to compute the number of ones in the
 * binary representation of the number. ones(0) = 0 ones(1) = 1 ones(2) = 1
 * ones(3) = 2 ones(7) = 3
 * 
 * @author pranay
 *
 */
public class NoOnesInBinary {

	public int ones(int x) {
		int sum = 0;

		while (x > 0) {
			sum += x & 1;
			x >>= 1;
		}
		
		return sum;
	}

	public static void main(String... strings) {
		System.out.println(new NoOnesInBinary().ones(6));
	}

}
