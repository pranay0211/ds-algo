package com.solutions.MCM;

public class MCM_PallindromPartitioning_Len {

	static int t[][];

	private boolean isPallindrome(String s) {

		// reverse the given String
		String reverse = new StringBuffer(s).reverse().toString();

		// check whether the string is palindrome or not
		if (s.equals(reverse))
			return true;
		else
			return false;

	}

	private int solve(String s, int i, int j) {

		if (i >= j) {
			return 0;
		}

		if (t[i][j] != -1) {
			return t[i][j];
		}

		if (isPallindrome(s.substring(i, j)) == true) {
			return t[i][j] = 0;
		}

		int min = Integer.MAX_VALUE;

		for (int k = i; k < j - 1; k++) {

			int temp = 1;

			int left = 0;
			if (t[i][k] != -1) {
				left = t[i][k];
			} else {
				left = solve(s, i, k);
				t[i][k] = left;
			}

			int rigt = 0;
			if (t[k + 1][j] != -1) {
				rigt = t[k + 1][j];
			} else {
				rigt = solve(s, k + 1, j);
				t[k + 1][j] = rigt;
			}

			temp = temp + left + rigt;

			if (temp < min)
				min = temp;
		}

		return t[i][j] = min;
	}

	public static void main(String... strings) {

		String s = "nitin";

		t = new int[s.length() + 1][s.length() + 1];
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				t[i][j] = -1;
			}
		}

		System.out.println(new MCM_PallindromPartitioning_Len().solve(s, 0, s.length() - 1));

	}

}
