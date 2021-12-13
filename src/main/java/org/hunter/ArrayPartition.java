package org.hunter;

public class ArrayPartition{

	public static void main(String [] args){
		int [] arr1 = {7,6,5,4};
		int [] arr2 = {7,6,4,5};
		int [] arr3 = {7,3,4,5};
		int [] arr4 = {7,3,4,5,33,22,11,10};

		int partitionIndex = partition(arr1);
		for(int i = 0; i < arr1.length; ++i) {
			System.out.println(arr1[i]);
		}

		System.out.println("");
		System.out.println(partitionIndex);
		System.out.println("");

		partitionIndex = partition(arr2);
		for(int i = 0; i < arr2.length; ++i) {
			System.out.println(arr2[i]);
		}

		System.out.println("");
		System.out.println(partitionIndex);
		System.out.println("");

		partitionIndex = partition(arr3);
		for(int i = 0; i < arr3.length; ++i) {
			System.out.println(arr3[i]);
		}

		System.out.println("");
		System.out.println(partitionIndex);
		System.out.println("");

		partitionIndex = partition(arr4);
		for(int i = 0; i < arr4.length; ++i) {
			System.out.println(arr4[i]);
		}
		System.out.println("");
		System.out.println(partitionIndex);
		System.out.println("");
	}

	//time=O(n) space=O(1)
	public static int partition(int [] array){
		if(array.length == 0){
			return 0;
		}
		int last = 0;
		for (int i = 0; i < array.length - 1; ++i){
			if(array[i] < array[array.length - 1]){
				swap(array, i, last);
				last++;
			}
		}
		swap(array, last, array.length - 1);
		return last;
	}

	private static void swap(int [] array, int i, int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

}
