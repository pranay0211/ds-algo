package com.solutions.MCM;

public class ScrambledString_TrueFalse {

	private boolean isScramblledString(String a, String b) {

		// base condition
		if (a.length() != b.length())
			return false;

		int n = a.length();

		if (n == 0)
			return true;
		if (a == b)
			return true;

		for (int i = 1; i < n; i++) {
			if ((isScramblledString(a.substring(0, i), b.substring(n - i, n))
					&& isScramblledString(a.substring(i, n - i), b.substring(0, n - i)))

					|| (isScramblledString(a.substring(0, i), b.substring(0, i))
							&& isScramblledString(a.substring(i, n - i), b.substring(i, n - i)))) {
				return true;
			}
		}

		return false;
	}

	public static void main(String... strings) {

		String a = "great";
		String b = "rgeat";

		System.out.println(new ScrambledString_TrueFalse().isScramblledString(a, b));
	}

}
