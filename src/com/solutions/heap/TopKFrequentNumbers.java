package com.solutions.heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentNumbers {
	private int[] solve(int[] arr, int k) {

		HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();

		PriorityQueue<HashMap<Integer, Integer>> p = new PriorityQueue<HashMap<Integer, Integer>>();

		for (int i = 0; i < arr.length; i++) {
			if (freqMap.get(arr[i]) != null) {
				freqMap.put(arr[i], freqMap.get(arr[i]) + 1);
			} else {
				freqMap.put(arr[i], 1);
			}
		}

		return arr;
	}

	public static void main(String... strings) {

		int[] arr = new int[] { 1, 1, 1, 3, 2, 2, 4 };
		new TopKFrequentNumbers().solve(arr, 2);
		System.out.println(">>");
	}

}
