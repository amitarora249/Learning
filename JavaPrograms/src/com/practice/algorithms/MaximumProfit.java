package com.practice.algorithms;

public class MaximumProfit {

	public void maxProfit(int[] stockPrices) {
		int right = stockPrices.length - 1;
		int left = 0;

		int maxProfit = getMaxProfit(stockPrices, left, right);
		System.out.println(maxProfit);

	}

	private int getMaxProfit(int[] prices, int start, int end) {

		int min = prices[start];
		int diff = prices[start + 1] - prices[start];
		while (end >= start) {
			int currDiff = prices[start] - min;
			if (diff < currDiff) {
				diff = currDiff;
			}
			if (min > prices[start]) {
				min = prices[start];
			}
			start++;
		}
		return diff;
	}

	public static void main(String[] args) {

		int[] stockPrices = { 100, 180, 260, 310, 40, 535, 695 };
		new MaximumProfit().maxProfit(stockPrices);
	}
}
