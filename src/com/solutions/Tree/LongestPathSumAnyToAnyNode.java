package com.solutions.Tree;

public class LongestPathSumAnyToAnyNode {

	class Node {
		int data;
		Node left;
		Node rigt;

		Node(int data, Node left, Node rigt) {
			this.left = left;
			this.rigt = rigt;
		}
	}

	int res = 0;

	public int solve(Node root) {

		// base condition
		if (root == null) {
			return 0;
		}

		// hypothesis
		int l = solve(root.left);
		int r = solve(root.rigt);

		// induction
		int temp = Math.max(Math.max(l, r) + 1, root.data);
		int ans = Math.max(temp, l + r + 1);
		res = Math.max(res, ans);

		return temp;
	}

	public static void main(String... strings) {

	}

}
