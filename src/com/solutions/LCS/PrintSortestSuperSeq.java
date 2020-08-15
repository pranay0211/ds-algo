package com.solutions.LCS;

public class PrintSortestSuperSeq {

	private String LCS(String x, String y, int n, int m) {

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
					sb.append(yc[j - 1]);
					j--;
				} else {
					sb.append(xc[i - 1]);
					i--;
				}
			}
		}

		return sb.reverse().toString();
	}

	public static void main(String... strings) {
		String x = "abcdaf";
		String y = "acbcf";

		int n = x.length();
		int m = y.length();

		System.out.println(new PrintSortestSuperSeq().LCS(x, y, n, m));
	}

}
