package com.solutions;

/***
 * Given an input amount of change x, write a function to determine the minimum
 * number of coins required to make that amount of change. Ex:change(1) = 1
 * change(3) = 3 change(7) = 3 change(32) = 4
 * 
 * @author pranay
 *
 */
public class SmallestChangeCoin {

	public int change(int x, int[] coins) {
		int[] cache = new int[x];
		for (int i = 1; i < x; i++) {
			cache[i] = -1;
		}
		return change(x, coins, cache);
	}

	public int change(int x, int[] coins, int[] cache) {

		if (x == 0)
			return 0;

		int min = x;

		for (int coin : coins) {
			if (x - coin >= 0) {
				int c;
				if (cache[x - coin] >= 0)
					c = cache[x - coin];
				else {
					c = change(x - coin, coins, cache);
					cache[x - coin] = c;
				}
				if (min > c + 1)
					min = c + 1;
			}
		}

		return min;
	}

	public static void main(String... strings) {
		int[] coins = new int[] { 25, 10, 5, 1 };
		System.out.println(new SmallestChangeCoin().change(31, coins));
	}

}
