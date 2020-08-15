package com.solutions;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public List<String> permutationsString(String str) {
		List<String> result = new ArrayList<>();
		permutationsString("", str, result);
		return result;
	}

	public void permutationsString(String prefix, String suffix, List<String> result) {
		if (suffix.length() <= 0) {
			result.add(prefix);
		} else {
			for (int i = 0; i < suffix.length(); i++) {
				permutationsString(prefix + suffix.charAt(i),
						suffix.substring(0, i) + suffix.substring(i + 1, suffix.length()), result);
			}
		}
	}

	public List<int[]> permutations(int[] arr) {

		List<int[]> result = new ArrayList<>();
		permutations(arr, 0, result);
		return result;
	}

	private void permutations(int[] a, int start, List<int[]> result) {
		if (start >= a.length)
			result.add(a.clone());
		else
			for (int i = start; i < a.length; i++) {
				swap(a, start, i);
				permutations(a, start + 1, result);
				swap(a, start, i);
			}

	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	public static void main(String... strings) {

		List<int[]> result = new Permutations().permutations(new int[] { 1, 2, 3 });
		for (int[] i : result) {
			for (int j = 0; j < i.length; j++) {
				System.out.print(i[j] + "  ");
			}
			System.out.println(" ");
		}

		System.out.println();
	}

}
