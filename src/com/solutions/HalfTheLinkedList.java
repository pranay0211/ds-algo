package com.solutions;

/***
 * Given a linked list, write a function to split the list into two equal
 * halves.
 * 
 * @author pranay
 *
 */
public class HalfTheLinkedList {

	class Node {
		private Node next;
	}

	public Node devide(Node list) {

		if (list == null)
			return null;

		Node runner = list.next;

		while (runner != null) {
			runner = runner.next;
			if (runner == null)
				break;
			runner = runner.next;
			list = list.next;
		}

		Node toReturn = list.next;
		list.next = null;
		return toReturn;
	}

	public static void main(String... strings) {

	}

}
