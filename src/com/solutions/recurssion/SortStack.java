package com.solutions.recurssion;

import java.util.Stack;

public class SortStack {

	Stack<Integer> sort(Stack s) {
		// base condition
		if (s.size() == 1) {
			return s;
		}

		// hypo
		int temp = (int) s.pop();
		s = sort(s);

		// induction
		s = insert(s, temp);

		return s;
	}

	private Stack<Integer> insert(Stack s, int temp) {
		
		// base cond
		if (s.isEmpty() || (int) s.peek() <= temp) {
			s.push(temp);
			return s;
		}

		//hypo
		int ele = (int) s.pop();
		s = insert(s, temp);
		s.push(ele);

		return s;
	}

	public static void main(String... strings) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(5);
		s.push(2);
		s.push(6);
		s.push(3);
		System.out.println(s);
		System.out.println(new SortStack().sort(s));
	}

}
