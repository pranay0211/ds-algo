package com.solutions;

/***
 * Given a string, write a function to compress it by shortening every sequence
 * of the same character to that character followed by the number of
 * repetitions. If the compressed string is longer than the original, you should
 * return the original string.
 * 
 * @author pranay
 *
 */

public class StringCompression {

	public String solution(String str) {
		String out = "";
		int sum = 1;

		for (int i = 0; i < str.length()-1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				sum++;
			} else {
				out = out + str.charAt(i) + sum;
				sum = 1;
			}
		}

		return out;
	}

	public static void main(String... strings) {
		System.out.println(new StringCompression().solution("aaaabbbcccdee"));
	}

}
