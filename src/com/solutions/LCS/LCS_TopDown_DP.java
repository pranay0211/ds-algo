package com.solutions.LCS;

/***
 * longest sub sequence length - DP
 * 
 * @author pranay
 *
 */
public class LCS_TopDown_DP {

	private int LCS(String x, String y, int n, int m) {

		int t[][] = new int[n + 1][m + 1];

		// initialization
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < m + 1; j++) {
				if (i == 0 || j == 0) {
					t[i][j] = 0;
				}
			}
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (x.toCharArray()[i - 1] == y.toCharArray()[j - 1]) {
					t[i][j] = 1 + t[i - 1][j - 1];
				} else {
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
				}
			}
		}

		return t[n][m];
	}

	public static void main(String... strings) {
		String x = "ab";
		String y = "ab";

		int n = x.length();
		int m = y.length();

		System.out.println(new LCS_TopDown_DP().LCS(x, y, n, m));
	}

}
