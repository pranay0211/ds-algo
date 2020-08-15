package com.solutions;

/***
 * Given a linked list, and an input n, write a function that returns the
 * nth-to-last element of the linked list. list = 1 -> 2 -> 3 -> 4 -> 5 -> null
 * nthToLast(list, 0) = 5 nthToLast(list, 1) = 4 nthToLast(list, 4) = 1
 * nthToLast(list, 5) = null
 * 
 * @author pranay
 *
 */

public class NthLastEleInSingleLL {

	public Node nthLastNode(Node node, int n) {
		Node curr = node;
		Node follower = node;

		for (int i = 0; i < n; i++) {
			if (curr == null)
				return null;
			curr = curr.getNext();
		}

		while (curr.getNext() != null) {
			curr = curr.getNext();
			follower = follower.getNext();
		}

		return follower;
	}

	public static void main(String... strings) {
		Node n1 = new Node(5);
		Node n2 = new Node(10);
		Node n3 = new Node(15);
		Node n4 = new Node(25);
		Node n5 = new Node(35);
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);

		NthLastEleInSingleLL n = new NthLastEleInSingleLL();
		System.out.println(n.nthLastNode(n1, 1).getValue());
	}

}
