package com.solutions;

/***
 * Implement N > 0 stacks using a single array to store all stack data (you may
 * use auxiliary arrays in your stack object, but all of the objects in all of
 * the stacks must be in the same array). No stack should be full unless the
 * entire array is full.
 * 
 * @author pranay
 *
 */

public class StackFromArray {

	int[] topOfStack, stackData, nextIndex;
	int nextAvailable = 0;

	public StackFromArray(int totalStack, int capacity) {
		topOfStack = new int[totalStack];
		stackData = new int[capacity];
		nextIndex = new int[capacity];
		for (int i = 0; i < nextIndex.length - 1; i++) {
			nextIndex[i] = i + 1;
		}
		nextIndex[nextIndex.length - 1] = -1;
	}

	public void push(int stack, int value) {
		if (stack < 0 || stack >= topOfStack.length) {
			throw new IndexOutOfBoundsException();
		}

		if (nextAvailable < 0)
			return;

		int currentIndex = nextAvailable;
		nextAvailable = nextIndex[currentIndex];
		topOfStack[stack] = currentIndex;
		stackData[currentIndex] = value;
		nextIndex[currentIndex] = topOfStack[stack];
	}

	public int pop(int stack) {
		if (stack < 0 || stack >= topOfStack.length || topOfStack[stack] < 0) {
			throw new IndexOutOfBoundsException();
		}

		int currentIndex = topOfStack[stack];
		int value = stackData[stack];
		topOfStack[stack] = nextIndex[currentIndex];
		nextIndex[currentIndex] = nextAvailable;
		nextAvailable = currentIndex;

		return value;
	}

}
