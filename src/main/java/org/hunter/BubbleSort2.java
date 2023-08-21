package org.hunter;

public class BubbleSort2{

	public static void main(String [] args){
		int [] nums = new int[]{1, 4, 3, 6, 2};
		BubbleSort2 bubbleSort2 = new BubbleSort2();
		bubbleSort2.sort(nums);
		for(int i = 0; i < nums.length; ++i){
			System.out.println(nums[i]);
		}
	}

	void sort(int [] arr){
		for(int i = 0; i < arr.length; ++i){
			int max = arr[0];
			int index = 0;
			for(int j = 0; j <= arr.length - i - 1; ++j){
				if(arr[j] > max){
					max = arr[j];
					index = j;
				}
			}
			int tmp = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = arr[index];
			arr[index] = tmp;
		}
	}

}
