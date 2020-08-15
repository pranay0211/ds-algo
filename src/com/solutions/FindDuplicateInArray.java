package com.solutions;

public class FindDuplicateInArray {

	private void findDuplicate(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[Math.abs(arr[i])] >= 0)
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			else
				System.out.print(Math.abs(arr[i]) + " ");
		}
	}

	public static void main(String... strings) {
		new FindDuplicateInArray().findDuplicate(new int[] { 2, 1, 3, 2, 3, 4 });
	}

}
