package com.solutions.MCM;

public class EggDropping_MCM {

	static int[][] mem;

	private int solve(int e, int f) {

		// base condition
		if (e == 1)
			return f;
		if (f == 1 || f == 0)
			return f;

		if (mem[e][f] != -1) {
			return mem[e][f];
		}

		int min = Integer.MAX_VALUE;

		// coice
		for (int k = 1; k <= f; k++) {
			int temp = 1 + Integer.max(solve(e - 1, k - 1), solve(e, f - k));
			if (temp < min)
				min = temp;
		}

		return mem[e][f] = min + 1;
	}

	public static void main(String... strings) {

		int e = 2;
		int f = 10;
		mem = new int[e + 1][f + 1];
		for (int i = 0; i <= e; i++) {
			for (int j = 0; j <= f; j++) {
				mem[i][j] = -1;
			}
		}

		System.out.println(new EggDropping_MCM().solve(2, 10));
	}

}
