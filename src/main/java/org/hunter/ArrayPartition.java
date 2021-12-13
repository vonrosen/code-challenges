package org.hunter;

public class ArrayPartition{

	public static void main(String [] args){
		int [] arr1 = {7,6,5,4};
		int [] arr2 = {7,6,4,5};
		int [] arr3 = {7,3,4,5};
		int [] arr4 = {7,3,4,5,33,22,11,10};

		int [] newarr1 = partition(arr1);
		for(int i = 0; i < newarr1.length; ++i) {
			System.out.println(newarr1[i]);
		}

		System.out.println("");

		int [] newarr2 = partition(arr2);
		for(int i = 0; i < newarr2.length; ++i) {
			System.out.println(newarr2[i]);
		}

		System.out.println("");

		int [] newarr3 = partition(arr3);
		for(int i = 0; i < newarr3.length; ++i) {
			System.out.println(newarr3[i]);
		}

		int [] newarr4 = partition(arr4);
		for(int i = 0; i < newarr4.length; ++i) {
			System.out.println(newarr4[i]);
		}
	}

	//time=O(n) space=O(1)
	public static int [] partition(int [] array){
		if(array.length == 0){
			return array;
		}
		int last = 0;
		for (int i = 0; i < array.length - 1; ++i){
			if(array[i] < array[array.length - 1]){
				swap(array, i, last);
				last++;
			}
		}
		swap(array, last, array.length - 1);
		return array;
	}

	private static void swap(int [] array, int i, int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

}
