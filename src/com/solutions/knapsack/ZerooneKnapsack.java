package com.solutions.knapsack;

public class ZerooneKnapsack {

	private int solve(int[] wt, int[] p, int W, int n) {

		if (wt.length == 0 || n == 0) {
			return 0;
		}

		if (wt[n - 1] <= W) {

			return Math.max(p[n - 1] + solve(wt, p, W - wt[n - 1], n - 1), solve(wt, p, W, n - 1));

		} else {
			return solve(wt, p, W, n - 1);
		}

	}

	public static void main(String... strings) {

		int[] wt = new int[] { 1, 3, 4, 5 };
		int[] p = new int[] { 1, 4, 5, 7 };
		int W = 7;

		System.out.println(new ZerooneKnapsack().solve(wt, p, W, wt.length));
	}

}
