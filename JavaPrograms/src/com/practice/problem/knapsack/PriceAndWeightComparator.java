package com.practice.problem.knapsack;

import java.util.Comparator;

/**
 * Compare the packages based on value, and if the value is equal the compare
 * based on weight
 * 
 * @author Pooja
 *
 */
public class PriceAndWeightComparator implements Comparator<PackageDetails> {

	@Override
	public int compare(PackageDetails o1, PackageDetails o2) {

		if (o2.getPrice() > o1.getPrice()) {
			return 1;
		} else if (o2.getPrice() < o1.getPrice()) {
			return -1;
		} else {
			if (o1.getWeight() > o2.getWeight()) {
				return 1;
			} else if (o1.getWeight() < o2.getWeight()) {
				return -1;
			} else {
				return 0;
			}
		}

	}

}
