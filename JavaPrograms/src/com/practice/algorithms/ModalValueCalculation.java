package com.practice.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class ModalValueCalculation {

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String inputElements = sc.nextLine();
		int[] inputArray = new int[n];
		sc.close();
		String[] elems = inputElements.split(" ");

		for (int i = 0; i < n; i++) {
			inputArray[i] = Integer.parseInt(elems[i]);
		}
		calculateModalValue(inputArray);
	}

	private static void calculateModalValue(int[] inputArray) {
		Map<Integer, Integer> counterMap = new HashMap<Integer, Integer>();
		int length = inputArray.length;
		for (int i = 0; i < length; i++) {
			int count = counterMap.containsKey(inputArray[i]) ? counterMap.get(inputArray[i]) : 0;
			counterMap.put(inputArray[i], count + 1);
		}
		List<Entry<Integer, Integer>> entryList = new ArrayList<>(counterMap.entrySet());
		Collections.sort(entryList, new Comparator<Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> i1, Entry<Integer, Integer> i2) {
				Integer value1 = i1.getValue();
				Integer value2 = i2.getValue();
				return value2.compareTo(value1);
			}
		});
		System.out.println(entryList.get(0).getKey());
	}
}
