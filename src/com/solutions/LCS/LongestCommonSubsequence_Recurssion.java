package com.solutions.LCS;

/***
 * return longest common sub-sequence length
 * 
 * @author pranay
 *
 */

public class LongestCommonSubsequence_Recurssion {

	static int[][] t;

	private int LCS(String x, String y, int n, int m) {

		if (n == 0 || m == 0)
			return 0;

		if (t[n][m] != -1)
			return t[n][m];

		if (x.toCharArray()[n - 1] == y.toCharArray()[m - 1]) {
			return t[n][m] = 1 + LCS(x, y, n - 1, m - 1);
		} else {
			return t[n][m] = Math.max(LCS(x, y, n - 1, m), LCS(x, y, n, m - 1));
		}

	}

	public static void main(String... strings) {
		String x = "abcdtf";
		String y = "abedtf";

		int n = x.length();
		int m = y.length();

		t = new int[n + 1][m + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < m + 1; j++) {
				t[i][j] = -1;
			}
		}

		System.out.println(new LongestCommonSubsequence_Recurssion().LCS(x, y, n, m));
	}

}
