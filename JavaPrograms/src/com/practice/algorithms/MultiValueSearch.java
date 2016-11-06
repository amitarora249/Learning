package com.practice.algorithms;

public class MultiValueSearch {

	public static void main(String[] args) {

		int[] array = new int[] { 3, 3, 1, 2, 2, 3 };
		int size = 6;

		System.out.println(maxRepitions(array, size));

	}

	private static int maxRepitions(int[] array, int size) {
		int i = 0;
		int max = 0;
		int maxIndex = -1;

		for (i = 0; i < size; i++) {
			array[array[i] % size] = array[array[i] % size] + size;
		}

		for (i = 0; i < size; i++) {

			if (array[i] / size > max) {
				max = array[i] / size;
				maxIndex = i;
			}
		}
		return maxIndex;
	}

}
