package com.solutions.knapsack;

public class RodCutting {

	public int solve(int[] arr, int[] price, int sum) {

		if (arr.length <= 0)
			return 0;

		int n = arr.length;

		// initialization
		int[][] t = new int[n + 1][sum + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {

				if (i == 0 || j == 0) {
					t[i][j] = 0;
				} else if (arr[i - 1] <= j) {
					t[i][j] = Math.max(t[i - 1][j], price[i - 1] + t[i - 1][j - arr[i - 1]]);
				} else {
					t[i][j] = t[i - 1][j];
				}
			}

		}

		return t[n][sum];
	}

	public static void main(String... strings) {
		System.out.println(new RodCutting().solve(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 },
				new int[] { 1, 5, 8, 9, 10, 17, 17, 20 }, 8));
	}

}
