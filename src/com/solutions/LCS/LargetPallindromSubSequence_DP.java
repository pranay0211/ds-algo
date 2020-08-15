package com.solutions.LCS;

public class LargetPallindromSubSequence_DP {
	private int LCS(String x, String y, int n, int m) {

		int t[][] = new int[n + 1][m + 1];

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (i == 0 || j == 0) {
					t[i][j] = 0;
				} else if (x.toCharArray()[i - 1] == y.toCharArray()[j - 1]) {
					t[i][j] = 1 + t[i - 1][j - 1];
				} else {
					t[i][j] = Integer.max(t[i - 1][j], t[i][j - 1]);
				}
			}
		}
		return t[n][m];
	}

	public static void main(String... strings) {
		String x = "mokskojip";
		String y = new StringBuffer(x).reverse().toString();

		int n = x.length();
		int m = y.length();

		System.out.println(new LargetPallindromSubSequence_DP().LCS(x, y, n, m));
	}

}
