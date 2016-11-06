package com.practice.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortOnValue {
	private static Map<Integer, String> map = new HashMap<>();

	public static void main(String[] args) {

		map.put(1, "z");
		map.put(2, "q");
		map.put(3, "c");
		map.put(4, "y");
		List<Entry<Integer, String>> entrySet = new ArrayList<>(map.entrySet());
		Collections.sort(entrySet, new ValueComparator());
		System.out.println(entrySet.toString());

	}
}

class ValueComparator implements Comparator<Entry<Integer, String>> {
	Map<Integer, String> tempMap = new HashMap<>();

	public ValueComparator() {
	}

	public int compare(Entry<Integer, String> s1, Entry<Integer, String> s2) {
		String value = s1.getValue();
		String value2 = s2.getValue();
		return value.compareTo(value2);

	}
}