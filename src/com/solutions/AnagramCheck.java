package com.solutions;

public class AnagramCheck {

	public boolean isAnagram(String str1, String str2) {

		if (str1 == null && str2 == null)
			return true;
		if (str1.length() != str2.length())
			return false;

		int[] letters = new int[256];
		for (char c : str1.toCharArray()) {
			letters[c]++;
		}

		for (char c : str2.toCharArray()) {
			letters[c]--;
		}

		for (int i : letters) {
			if (i != 0)
				return false;
		}

		return true;
	}

	public static void main(String... strings) {
		System.out.println(new AnagramCheck().isAnagram("pranay1", "rpan1ay"));
	}

}
