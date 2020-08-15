package com.solutions.heap;

import java.util.Iterator;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
	int data;
	int diff;

	@Override
	public int compareTo(Pair o) {
		return this.diff > o.diff ? -1 : 1;
	}
}

public class KClosestElements {

	public int[] solve(int[] arr, int k, int x) {

		PriorityQueue<Pair> p = new PriorityQueue<Pair>();
		for (int i = 0; i < arr.length; i++) {
			Pair p1 = new Pair();
			p1.data = arr[i];
			p1.diff = Math.abs(arr[i] - x);
			p.add(p1);

			if (p.size() > k) {
				p.poll();
			}
		}
		
		Iterator<Pair> it = p.iterator();
		while(it.hasNext()) {
			System.out.print(it.next().data +"   ");
		}

		return arr;
	}

	public static void main(String... strings) {

		int[] arr = new int[] { 10, 2, 14, 4, 7, 15 };

		System.out.println(new KClosestElements().solve(arr, 3, 2));

	}

}
