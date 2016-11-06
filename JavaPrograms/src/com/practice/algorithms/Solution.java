package com.practice.algorithms;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner scanner = new Scanner(System.in);
		int testCases = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < testCases; i++) {
			findWinner(new BigInteger(scanner.nextLine()));
		}
		scanner.close();
	}

	public static void findWinner(BigInteger counter) {
		String player = "Louise";
		BigInteger two = new BigInteger("2");
		do {
			if (ifPowerOfTwo(counter)) {
				counter = counter.divide(two);
			} else {
				BigInteger closestPower = counter.subtract(BigInteger.ONE);
				while (!ifPowerOfTwo(closestPower)) {
					closestPower = closestPower.subtract(BigInteger.ONE);
				}
				counter = counter.subtract(closestPower);
			}
			player = getNextPlayer();
		} while (counter.compareTo(BigInteger.ONE) != 0);
		System.out.println(player);
	}

	public static boolean ifPowerOfTwo(BigInteger closestPower) {
		if (closestPower.and(closestPower.subtract(BigInteger.ONE)).compareTo(BigInteger.ZERO) == 0)
			return true;
		return false;
	}

	public static String getNextPlayer() {
		String player1 = "Louise";
		String player2 = "Richard";
		String currentPlayer = player1;
		if (currentPlayer == player1)
			return player2;
		return player1;
	}
}