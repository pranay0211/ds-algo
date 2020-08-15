package com.solutions.knapsack;

public class EqualSumPartitionSubSet {

	private boolean solve(int[] arr, int n) {

		if (n <= 0)
			return false;

		int sum = 0;

		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}

		if (sum % 2 != 0)
			return false;

		sum = sum / 2;

		boolean[][] t = new boolean[n + 1][sum + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0) {
					t[i][j] = false;
				} else if (j == 0) {
					t[i][j] = true;
				} else if (arr[i - 1] <= j) {
					t[i][j] = t[i - 1][j] || t[i - 1][j - arr[i - 1]];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}

		return t[n][sum];
	}

	public static void main(String... strings) {
		int[] arr = new int[] { 1, 5, 11, 5 };
		int n = arr.length;
		System.out.println(new EqualSumPartitionSubSet().solve(arr, n));
	}

}
