package com.solutions.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KsmallestElement {

	public int solve(int[] arr, int k) {

		PriorityQueue<Integer> p = new PriorityQueue<Integer>(k, Collections.reverseOrder());

		for (int i = 0; i < arr.length; i++) {
			p.add(arr[i]);
			if (i > k-1) {
				p.poll();
			}
		}
		return p.poll();
	}

	public static void main(String... strings) {
		int[] arr = new int[] { 7, 10, 4, 3, 20, 15, 100 };
		int k = 3;
		System.out.println(new KsmallestElement().solve(arr, k));
	}

}
