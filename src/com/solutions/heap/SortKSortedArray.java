package com.solutions.heap;

import java.util.PriorityQueue;

public class SortKSortedArray {

	public int[] solve(int[] arr, int k) {

		if (arr.length <= 0) {
			return arr;
		}

		PriorityQueue<Integer> p = new PriorityQueue<Integer>();

		for (int i = 0; i < k + 1; i++) {
			p.add(arr[i]);
		}

		int index = 0;
		for (int i = k + 1; i < arr.length; i++) {
			arr[index++] = p.poll();
			p.add(arr[i]);

		}

		while (p.iterator().hasNext()) {
			arr[index++] = p.poll();
		}

		System.out.println(p);

		return arr;
	}

	public static void main(String... strings) {
		int[] res = new SortKSortedArray().solve(new int[] { 6, 5, 3, 2, 8, 10, 9 }, 3);

		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}

	}

}
