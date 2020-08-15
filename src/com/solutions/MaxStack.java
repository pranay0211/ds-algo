package com.solutions;

/***
 * Implement a LIFO stack that has a push(), pop(), and max() function, where
 * max() returns the maximum value in the stack. All of these functions should
 * run in O(1) time
 * 
 * @author pranay
 *
 */

public class MaxStack {

	class Node {
		private int value;
		private Node oldMax;
		private Node next;

		public Node(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getOldMax() {
			return oldMax;
		}

		public void setOldMax(Node oldMax) {
			this.oldMax = oldMax;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}

	private Node max;
	private Node stack;

	public MaxStack() {
	}

	public void push(int x) {
		Node node = new Node(x);

		if (this.max == null || node.getValue() > max.getValue()) {
			node.setOldMax(max);
			this.max = node;
		}
		if (stack == null)
			stack = node;
		else {
			node.next = stack;
			stack = node;
		}

	}

	public int pop() {

		if (stack == null)
			throw new NullPointerException();

		Node node = stack;
		stack = node.getNext();

		if (node.getOldMax() != null) {
			max = node.getOldMax();
		}

		return node.getValue();
	}

	public int max() {
		if (max == null)
			throw new NullPointerException();
		else
			return max.getValue();
	}

	public static void main(String... strings) {

		MaxStack max = new MaxStack();
		max.push(5);
		max.push(2);
		max.push(10);
		
		//--
		max.pop();

		System.out.println(max.toString());
	}

	@Override
	public String toString() {
		return "MaxStack [max=" + max.getValue() + ", stack=" + stack.getValue() + "]";
	}

}
