package org.pooja.sorting;

import java.util.Arrays;

public class BubbleSorting {
public static void main(String[] args) {
		
		int[] arr = {97,9,55,10,77,2,0,4,66};
		bubbleSort(arr);
	}

	private static void bubbleSort(int[] arr) {
		int index = arr.length-1;
		while(index != 1){
			for(int j = 0; j<index ;j++){
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			System.out.println(Arrays.toString(arr));
			index--;
		}
		
	}
}
