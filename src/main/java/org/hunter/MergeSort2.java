package org.hunter;

public class MergeSort2{

	public static void main(String [] args){
		int [] array = new int[]{
				101,
				50,
				2,
				54,
				3,
				10,
				8,
		};
		ms m = new ms();
		int [] ans = m.ms(array, 0, array.length - 1);
		for(int i = 0; i < ans.length; ++i){
			System.out.println(ans[i]);
		}

	}

	int [] ms(int [] array, int start, int end){
		if(start == end){
			return new int[]{ array[start] };
		}
		int mid = start + (end - start) / 2;
		int [] left = ms(array, start, mid);
		int [] right = ms(array, mid + 1, end);
		return merge(left, right);
	}

	int [] merge(int [] left, int [] right){
		int [] merged = new int[left.length + right.length];
		int i = 0, j = 0, index = 0;
		while(i < left.length && j < right.length){
			if(left[i] < right[j]){
				merged[index] = left[i];
				++i;
			}else{
				merged[index] = right[j];
				++j;
			}
			index++;
		}
		for(; i < left.length; ++i){
			merged[index] = left[i];
			index++;
		}
		for(; j < right.length; ++j){
			merged[index] = right[j];
			index++;
		}
		return merged;
	}


}
