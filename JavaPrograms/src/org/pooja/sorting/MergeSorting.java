package org.pooja.sorting;

import java.util.Arrays;

public class MergeSorting {

	public static void main(String[] args) {

		int[] array = { 97, 9, 55, 10, 77, 2, 0, 4, 66 };
		mergeSorting(array);
	}

	private static void mergeSorting(int[] originalArray) {

		int length = originalArray.length;
		if (length <= 1) {
			return;
		}

		int mid = (length) / 2;
		int[] left = new int[mid];
		int[] right = new int[length-mid];
		
		System.arraycopy(originalArray, 0, left, 0, left.length);
		System.arraycopy(originalArray, mid, right, 0,right.length);
		mergeSorting(left);
		mergeSorting(right);
		merge(left,right,originalArray);
		System.out.println(Arrays.toString(originalArray));
		
	}

	/**
	 * @param left
	 * @param right
	 * @param array
	 */
	private static void merge(int[] left, int[] right, int[] array) {
		
		int i = 0; //index of left array
		int j = 0; // index of right array
		int k =0; // index of orignal array
		while(i < left.length && j < right.length){
			if(left[i] <= right[j]){
				array[k] = left[i];
				i++;
			}else{
				array[k] = right[j];
				j++;
			}
			k++;
		}
		while(i < left.length){
			System.arraycopy(left, i, array, k, left.length-i);
			i++;
			k++;
		}
		
		while(j < right.length){
			System.arraycopy(right, j, array, k, right.length-j);
			j++;
			k++;
		}
	}
}
