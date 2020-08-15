package com.solutions.MCM;

public class BooleanParantheses {
	private int solve(String s, int i, int j, boolean isTrue) {
		// base condition
		if (i > j)
			return 0;
		if (i == j) {
			if (isTrue == Boolean.valueOf(s.substring(i, j))) {
				return 1;
			} else {
				return 0;
			}
		}

		// code
		int ans = 0;
		for (int k = i + 1; k <= j - 1; k = k + 2) {

			int lt = solve(s, i, k - 1, true);
			int lf = solve(s, i, k - 1, false);
			int rt = solve(s, k + 1, j, true);
			int rf = solve(s, k + 1, j, false);

			if (s.charAt(k) == '&') {
				if (isTrue == true) {
					ans = ans + lt * rt;
				} else {
					ans = ans + lf * rt + lt * rf + rf * lf;
				}
			} else if (s.charAt(k) == '|') {
				if (isTrue == true) {
					ans = ans + lt * rf + lf * rt + lt * rt;
				} else {
					ans = ans + lf * rf;
				}
			} else if (s.charAt(k) == '^') {
				if (isTrue == true)
					ans = ans + lf * rt + lt * rf;
				else
					ans = ans + lt * rt + lf * rf;
			}

		}

		return ans;
	}

	public static void main(String... strings) {
		String s = "T|F&T^F";
		System.out.println(new BooleanParantheses().solve(s, 0, s.length(), true));
	}

}
