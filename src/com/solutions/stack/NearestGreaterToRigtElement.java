package com.solutions.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NearestGreaterToRigtElement {

	private ArrayList<Integer> solve(int[] arr) {

		ArrayList<Integer> res = new ArrayList<Integer>();

		Stack<Integer> s = new Stack<Integer>();
		int len = arr.length;
		for (int i = len - 1; i >= 0; i--) {
			if (s.size() == 0) {
				res.add(-1);
			} else if (s.size() > 0 && s.peek() > arr[i]) {
				res.add(s.peek());
			} else if (s.size() > 0 && arr[i] > s.peek()) {
				while (s.size() > 0 && s.peek() <= arr[i]) {
					s.pop();
				}
				if (s.size() == 0) {
					res.add(-1);
				} else {
					res.add(s.pop());
				}

			}
			s.push(arr[i]);
		}

		Collections.reverse(res);

		return res;

	}

	public static void main(String... strings) {
		System.out.println(new NearestGreaterToRigtElement().solve(new int[] { 1, 3, 2, 4 }));
	}

}
