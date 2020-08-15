package com.solutions.recurssion;

import java.util.ArrayList;

public class AllPossibleParanthesis {

	private ArrayList<String> solve(int N, int open, int close, ArrayList<String> output, String op) {

		// base condn
		if (open == 0 && close == 0) {
			output.add(op);
			return output;
		}

		if (open != 0) {
			String op1 = op;
			op1 = op1 + "(";
			solve(N, open - 1, close, output, op1);
		}

		if (close > open) {
			String op1 = op;
			op1 = op1 + ")";
			solve(N, open, close - 1, output, op1);
		}

		return output;
	}

	public static void main(String... strings) {

		int N = 3;
		int open = N;
		int close = N;
		ArrayList<String> output = new ArrayList<String>();
		System.out.println(new AllPossibleParanthesis().solve(N, open, close, output, ""));

	}

}
