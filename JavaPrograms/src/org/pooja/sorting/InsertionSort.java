package org.pooja.sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		
		int[] arr = {97,9,55,10,77,2,0,4,66};
		
		for(int i=0;i<arr.length;i++){
			int min = arr[i];
			int position = i;
			for(int j=i-1;j>=0;j--){
				if(min < arr[j]){
					arr[j+1] = arr[j];
					position = j;
				}
				arr[position] = min;
			}
			System.out.println(Arrays.toString(arr));
		}
	}

}
