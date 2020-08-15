package com.solutions.LCS;

/***
 * Minimum number of Insertin and deletion to convert string x -> y
 * 
 * @author pranay
 * 
 * Simple logic: 
 * 1. get lengt of LCS
 * 2. get len of string x
 * 3. deletion = x.len -  LCS.len
 * 4. insertion = y.len - LCS.len
 *
 */

public class LCS_String_Insert_Delete_DP {

	private String LCS(String x, String y, int n, int m) {

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

		int deletion = x.length() - t[n][m];
		int insertion = y.length() - t[n][m];

		return "insertion : " + insertion + "    deleteion : " + deletion;
	}

	public static void main(String... strings) {
		String x = "xeap";
		String y = "pea";

		int n = x.length();
		int m = y.length();

		System.out.println(new LCS_String_Insert_Delete_DP().LCS(x, y, n, m));
	}

}
