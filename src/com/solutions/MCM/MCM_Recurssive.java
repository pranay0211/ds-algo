package com.solutions.MCM;

public class MCM_Recurssive {

	static int[][] mem;

	private int solve(int arr[], int i, int j) {

		if (i >= j) {
			return 0;
		}

		if (mem[i][j] != -1) {
			return mem[i][j];
		}

		int min = Integer.MAX_VALUE;

		for (int k = i; k <= j - 1; k++) {
			int temp = solve(arr, i, k) + solve(arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);
			if (temp < min)
				min = temp;
		}

		return mem[i][j] = min;
	}

	public static void main(String... strings) {
		int[] arr = new int[] { 40, 20, 30, 10, 30 };
		mem = new int[arr.length + 1][arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				mem[i][j] = -1;
			}
		}
		System.out.println(new MCM_Recurssive().solve(arr, 1, arr.length - 1));
	}

}
