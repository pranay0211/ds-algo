package com.solutions.LCS;

public class LongestCommonSubString_len {
	private int LCS(String x, String y, int n, int m) {

		int t[][] = new int[n + 1][m + 1];
		int count = 0;

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (i == 0 || j == 0) {
					t[i][j] = 0;
				} else if (x.toCharArray()[i - 1] == y.toCharArray()[j - 1]) {
					t[i][j] = 1 + t[i - 1][j - 1];
					count = Integer.max(count, t[i][j]);
				} else {
					t[i][j] = 0;
				}
			}
		}

		return count;
	}

	public static void main(String... strings) {
		String x = "abcdtx";
		String y = "abedtf";

		int n = x.length();
		int m = y.length();

		System.out.println(new LongestCommonSubString_len().LCS(x, y, n, m));
	}

}
