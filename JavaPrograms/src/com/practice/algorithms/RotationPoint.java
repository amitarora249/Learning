package com.practice.algorithms;

public class RotationPoint {

	public static void main(String[] args) {

		int[] a = { 4, 5, 6, 7, 8, 1, 2, 3 };

		findRotationPoint(a);
	}

	public static void findRotationPoint(int[] a) {
		int start = 0, end = a.length - 1, mid;
		mid = start + (end - start) / 2;
		int last = a[a.length - 1];
		while (start <= end) {
			if (a[mid] > last) {
				start = mid + 1;
			} else if (a[mid] < last) {
				end = mid - 1;
			} else
				break;
			mid = start + (end - start) / 2;
			System.out.println(mid);
		}
		System.out.println(a[mid]);
	}
}
