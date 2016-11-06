package org.pooja.sorting;

import java.util.Arrays;
public class ShellSort {

	public static void main(String[] args) {
		
		int[] arr = {97,9,55,10,77,2,0,4,66};
		int length = arr.length;
		//calculate interval
		int interval = 1;
		while(interval<arr.length/3){
			interval = interval*3+1;
		}
		System.out.println(interval);
		
		while(interval >  0){
			for(int i=interval;i<length;i++){
				int j =i;
				int val = arr[j];
				while(j>=interval && arr[j-interval]>val){
					arr[j] = arr[j-interval];
					j = j - interval;
				}
				arr[j] = val;
			}
			interval = interval-1/3;
		}
		System.out.println(Arrays.toString(arr));
	}
}
