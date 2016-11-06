package com.practice.algorithms;

import java.util.Scanner;

public class HighestPositive {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String inputElements = sc.nextLine();
		int[] inputArray = new int[n];
		sc.close();
		String[] elems = inputElements.split(" ");
		
		for (int i = 0; i < n; i++) {
			inputArray[i] = Integer.parseInt(elems[i]);
		}
		
		calculateHighestPositive(inputArray);
	}

	private static void calculateHighestPositive(int[] inputArray) {
		
		int maxValue = Math.abs(inputArray[0]);
		
		
		for(int i = 1; i< inputArray.length; i++){
			int value = Math.abs(inputArray[i]);
			if(maxValue < value){
				maxValue = value;
			}
		}
		
		System.out.println(maxValue);
	}
}
