package org.hunter;

public class Sort{

	public static void main(String [] args){
		int [] toSort = { 10, 44, 22, 1, 23 };
		sort(toSort, 0, toSort.length - 1);
		for(int i = 0; i < toSort.length; ++i){
			System.out.println(toSort[i]);
		}
		System.out.println("");
		toSort = new int[]{ 66, 10, 44, 22, 1, 23, 2, 3, 5, 4 };
		sort(toSort, 0, toSort.length - 1);
		for(int i = 0; i < toSort.length; ++i){
			System.out.println(toSort[i]);
		}
		System.out.println("");
		toSort = new int[]{ 1, 2, 3, 4, 5 };
		sort(toSort, 0, toSort.length - 1);
		for(int i = 0; i < toSort.length; ++i){
			System.out.println(toSort[i]);
		}
	}

	//best case time=O(N*log(N)), worst case time=O(n^2) space=O(1)
	private static void sort(int[] toSort, int start, int end){
		if(start >= end){
			return;
		}
		int pivot = partition(toSort, start, end);
		sort(toSort, start, pivot - 1);
		sort(toSort, pivot + 1, end);
	}

	public static int partition(int [] array, int start, int end){
		int last = start;
		for (int i = start; i <= end - 1; ++i){
			if(array[i] < array[end]){
				swap(array, i, last);
				last++;
			}
		}
		swap(array, last, end);
		return last;
	}

	private static void swap(int [] array, int i, int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}
