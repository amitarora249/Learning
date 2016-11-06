package com.practice.algorithms;

import java.util.Scanner;

public class StrangeCounter {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		long t = in.nextLong();

		if (t <= 0 || t > Math.pow(10, 12)) {
			System.out.println("Invalid data");
			return;
		}

		long timeCounter = 1;
		long valueCounter = 3;

		while ((timeCounter + valueCounter) <= t) {
			timeCounter = timeCounter + valueCounter;
			valueCounter = valueCounter * 2;
		}

		System.out.println(valueCounter - (t - timeCounter));

	}
}
