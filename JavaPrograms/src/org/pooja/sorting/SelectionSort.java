package org.pooja.sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {

		int[] arr = { 97, 9, 55, 10, 77, 2, 0, 4, 66 };
		selectionSorting(arr);
	}

	private static void selectionSorting(int[] arr) {
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			int minVal = i;
			for (int j = i + 1; j < length; j++) {
				if (arr[j] < arr[minVal]) {
					minVal = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minVal];
			arr[minVal] = temp;

			System.out.println(Arrays.toString(arr));
		}

	}
}
