package com.solutions;

import java.util.HashSet;
import java.util.Set;

class CountDistinct {
	
	static int MAX_CHAR = 26;

	static String encodeString(char[] str) {
		int hashEven[] = new int[MAX_CHAR];
		int hashOdd[] = new int[MAX_CHAR];

		for (int i = 0; i < str.length; i++) {
			char c = str[i];
			if ((i & 1) != 0) // If index of current character is odd
				hashOdd[c - 'a']++;
			else
				hashEven[c - 'a']++;

		}

		String encoding = "";
		for (int i = 0; i < MAX_CHAR; i++) {
			encoding += (hashEven[i]);
			encoding += ('-');
			encoding += (hashOdd[i]);
			encoding += ('-');
		}
		return encoding;
	}

	static int countDistinct(String input[], int n) {
		int countDist = 0; // Initialize result

		Set<String> s = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (!s.contains(encodeString(input[i].toCharArray()))) {
				s.add(encodeString(input[i].toCharArray()));
				countDist++;
			}
		}

		return countDist;
	}

	public static void main(String[] args) {
		String input[] = { "abcd", "acbd", "adcb", "cdba", "bcda", "badc" };
		int n = input.length;

		System.out.println(countDistinct(input, n));
	}
}