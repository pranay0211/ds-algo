package com.solutions.LCS;

/**
 * sortest super sequence
 * 
 * @author pranay
 * 
 *         Ans: just delete total length of longest sub sequence from total
 *         length of two string combined <br/>
 * 
 *         <b>(x.length + y.length)-longestSubString.length</b>
 *
 */

public class SortestCommonSuperSequenceDP {
	private int LCS(String x, String y, int n, int m) {

		int t[][] = new int[n + 1][m + 1];
		StringBuilder sb = new StringBuilder();

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
		int i = n, j = m;
		char[] xc = x.toCharArray();
		char[] yc = y.toCharArray();

		while (i > 0 && j > 0) {
			if (xc[i - 1] == yc[j - 1]) {
				sb.append(xc[i - 1]);
				i--;
				j--;
			} else {
				if (t[i][j - 1] > t[i - 1][j]) {
					j--;
				} else {
					i--;
				}
			}
		}

		return x.length() + y.length() - sb.reverse().toString().length();
	}

	public static void main(String... strings) {
		String x = "AGGTAB";
		String y = "GXTXAYB";

		int n = x.length();
		int m = y.length();

		System.out.println(new SortestCommonSuperSequenceDP().LCS(x, y, n, m));
	}
}
