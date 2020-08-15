package com.solutions;

/***
 * Given a binary tree, write a function to test if the tree is a binary search
 * tree.
 * 
 * @author pranay
 *
 */

class Nod {
	public int value;
	public Nod right, left;

	Nod(int value) {
		this.value = value;
	}
}

public class BinarySearchTreeValidation {

	public boolean isBST(Nod n) {
		return isBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBST(Nod n, int minValue, int maxValue) {
		if (n == null)
			return true;
		if (n.value < minValue || n.value > maxValue)
			return false;

		return isBST(n.left, minValue, n.value) && isBST(n.right, n.value + 1, maxValue);
	}

	public static void main(String... strings) {
		Nod n = new Nod(10);
		Nod n1 = new Nod(15);
		Nod n2 = new Nod(20);
		Nod n3 = new Nod(5);
		Nod n4 = new Nod(8);

		n.left = n4;
		n4.left = n1;
		n.right = n2;
		n1.right = n3;

		System.out.println(new BinarySearchTreeValidation().isBST(n));

	}

}
