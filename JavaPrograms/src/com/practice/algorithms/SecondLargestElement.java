package com.practice.algorithms;

public class SecondLargestElement {

	public static void main(String[] args) {
		int[] array = new int[] { 8, 6, 9, 3, 2, 5, 8, 3 };
		findSecondLargest(array);
	}

	private static void findSecondLargest(int[] array) {
		int n = array.length;
		int[] resultArr = new int[n / 2];
		int count = 0;
		int secondLargestrElem;
		if (n == 2) {
			System.out.println(array[0] > array[1] ? array[1] : array[0]);
			return;
		}
		for (int i = 0; i < n; i = i + 2) {
			secondLargestrElem = array[i] < array[i + 1] ? array[i + 1] : array[i];
			resultArr[count] = secondLargestrElem;
			count++;
		}
		findSecondLargest(resultArr);

	}
}
