package com.practice.algorithms;

public class SmallestAndLargest {
	public static void main(String[] args) {
		int[] array = { 10, 1, 5, 7, 19, 8 };
		int length = array.length;
		int max = array[0];
		int min = array[0];
		for (int i = 1; i < length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
			if (array[i] > max) {
				max = array[i];
			}
		}
		System.out.println("MIN: " + min + " & MAX: " + max);
	}
}
