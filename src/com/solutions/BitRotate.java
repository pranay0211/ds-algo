package com.solutions;

public class BitRotate {

	private static final int BITS_IN_INTEGER = 32;

	public int rotate(int x, int N) {
		return (x << N | x >> (BITS_IN_INTEGER - N));
	}

	public static void main(String... strings) {
		System.out.println(new BitRotate().rotate(16, 2));
	}

}
