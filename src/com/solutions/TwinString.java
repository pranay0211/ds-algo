package com.solutions;

import java.util.ArrayList;
import java.util.List;

public class TwinString {

	public static void main(String args[]) {

		String[] a = new String[] { "abcd", "abcd" };
		String[] b = new String[] { "bcda", "cdab" };

		List<String> result = new ArrayList<>();

		for (int i = 0; i < a.length; i++) {
			result.add(validateTwinString(a[i], b[i]));
		}

		System.out.println(result);
	}

	public static String validateTwinString(String first, String second) {
		String result = "NO";
		if (validate(first, second))
			result = "YES";

		return result;
	}

	private static boolean validate(String first, String second) {

		if (first == null || second == null || first.length() != second.length())
			return false;

		char[] firstToChar = first.toCharArray();
		char[] secondToChar = second.toCharArray();
		boolean found;

		for (int i = 0; i < first.length(); i++) {
			int j = (i % 2 == 0) ? 0 : 1;
			found = false;
			for (; j < second.length(); j = j + 2) {

				if (firstToChar[i] == secondToChar[j]) {
					found = true;
				}
			}

			if (!found)
				return false;
		}
		return true;
	}

}