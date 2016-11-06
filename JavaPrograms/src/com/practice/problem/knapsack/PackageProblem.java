package com.practice.problem.knapsack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Pooja
 *
 */
public class PackageProblem {

	private Map<Integer, Queue<PackageDetails>> capacityInputMap = new HashMap<>();

	public void processInput(String filePath) {

		String[] inputDetails;
		File file = new File(filePath);
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (scanner.hasNextLine()) {
			inputDetails = scanner.nextLine().split(":");
			Queue<PackageDetails> packageQueue = new PriorityQueue<>(new PriceAndWeightComparator());
			int maxWt = Integer.parseInt(inputDetails[0].trim());
			// split the input string into an array
			String[] items = inputDetails[1].trim().split("\\s");
			for (String item : items) {
				// extract the value between each parentheses
				Pattern pattern = Pattern.compile("\\((.*?)\\)");
				Matcher matcher = pattern.matcher(item);
				if (matcher.find()) {
					item = matcher.group(1);
				}
				// for each item, create an object and add it to the queue
				PackageDetails packageDetails = createPackage(item);
				if(packageQueue.size() != 15){
					packageQueue.add(packageDetails);
				}
				
			}
			capacityInputMap.put(maxWt, packageQueue);
		}
		scanner.close();
		calculatePackageWt();

	}

	private void calculatePackageWt() {

		Set<Entry<Integer, Queue<PackageDetails>>> entrySet = capacityInputMap.entrySet();
		for (Entry<Integer, Queue<PackageDetails>> entry : entrySet) {
			List<Integer> indexList = new ArrayList<>();
			int capacity = (int) entry.getKey();
			Queue<PackageDetails> itemQueue = (Queue<PackageDetails>) entry.getValue();
			double currentPackageWt = 0;

			while (!itemQueue.isEmpty()) {
				PackageDetails item = itemQueue.poll();
				double weight = item.getWeight();
				double tempWt = currentPackageWt + weight;
				if (weight < capacity && tempWt < capacity) {
					indexList.add(item.getIndex());
					currentPackageWt = currentPackageWt + weight;
				}
			}
			System.out.println(indexList);
		}

	}

	private PackageDetails createPackage(String item) {
		String[] packageData = item.split(",");
		PackageDetails packageDetails = new PackageDetails();
		packageDetails.setIndex(Integer.parseInt(packageData[0]));
		packageDetails.setWeight(Double.parseDouble(packageData[1]));
		packageDetails.setPrice(Double.parseDouble(packageData[2].split("\\$")[1]));
		return packageDetails;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String inputFilePath = scanner.nextLine();
		new PackageProblem().processInput(inputFilePath);
		scanner.close();
	}

}
