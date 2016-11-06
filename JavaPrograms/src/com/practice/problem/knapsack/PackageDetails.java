package com.practice.problem.knapsack;

public class PackageDetails {

	private int index;
	private double price;
	private double weight;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "PackageDetails [index=" + index + ", price=" + price + ", weight=" + weight + "]";
	}

}
