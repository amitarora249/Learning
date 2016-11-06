package com.practice.algorithms;

import java.util.Scanner;

public class LargestDifference {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());
		String inputElements = sc.nextLine();
		int[] inputArray = new int[n];
		sc.close();
		String[] elems = inputElements.split(" ");

		for (int i = 0; i < n; i++) {
			inputArray[i] = Integer.parseInt(elems[i]);
		}

		getLargestDifference(inputArray);
	}

	private static void getLargestDifference(int[] inputArray) {
		int index = 0;
		int max = inputArray[0];
		int min = inputArray[0];

		for (int i = 1; i < inputArray.length; i++) {
			if (inputArray[i] > max) {
				max = inputArray[i];
				index = i;
			}
		}

		for (int i = 0; i < index; i++) {
			if (inputArray[i] < min) {
				min = inputArray[i];
			}
		}

		int diff = max - min;
		System.out.println(diff);
	}
}
