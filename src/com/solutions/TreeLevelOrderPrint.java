package com.solutions;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLevelOrderPrint {

	class Node {
		private int value;
		private Node left, right;
	}

	public void leveOrderPrint(Node root) {
		if (root == null)
			System.out.println("no tree");

		Queue<Node> q = new LinkedList<Node>();

		q.add(root);

		while (!q.isEmpty()) {
			Node n = q.poll();
			System.out.println(n.value);

			if (n.left != null)
				q.add(n.left);
			if (n.right != null)
				q.add(n.right);
		}

	}

	public static void main(String... strings) {

	}

}
