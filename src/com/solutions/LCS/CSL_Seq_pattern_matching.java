package com.solutions.LCS;

public class CSL_Seq_pattern_matching {
	private boolean LCS(String x, String y, int n, int m) {

		int t[][] = new int[n + 1][m + 1];

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (i == 0 || j == 0) {
					t[i][j] = 0;
				} else if (x.toCharArray()[i - 1] == y.toCharArray()[j - 1]) {
					t[i][j] = 1 + t[i - 1][j - 1];
				} else {
					t[i][j] = Integer.max(t[i][j - 1], t[i - 1][j]);
				}
			}
		}

		return t[n][m] == x.length();
	}

	public static void main(String... strings) {
		String x = "axy";
		String y = "adxcpy";

		int n = x.length();
		int m = y.length();

		System.out.println(new CSL_Seq_pattern_matching().LCS(x, y, n, m));
	}
}
