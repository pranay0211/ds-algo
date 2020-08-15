package com.solutions;

import java.util.Stack;

class N {
	public int value;
	public N next;

	public N(int value) {
		this.value = value;
	}
}

public class Pelindrame {

	public boolean pelindrome(N n) {

		N curr = n;
		N runner = n;

		Stack<Integer> stack = new Stack<>();

		while (runner != null && runner.next != null) {
			stack.push(curr.value);
			curr = curr.next;
			runner = runner.next.next;
		}

		if (runner != null)
			curr = curr.next;

		while (curr != null) {
			if (stack.pop() != curr.value)
				return false;
			curr = curr.next;
		}

		return true;
	}

	public static void main(String... strings) {
		Pelindrame pel = new Pelindrame();
		N n = new N(1);
		N n1 = new N(2);
		N n2 = new N(1);

		n.next = n1;
		n1.next = n2;
		
		System.out.println(pel.pelindrome(n));

	}

}
