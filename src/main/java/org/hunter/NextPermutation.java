package org.hunter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * [2,3,1]
 * 1 is never greater anything on its left so go to 3
 * 3 is greater than 2 so swap
 * [3,2,1]
 * 2 is greater than 1 so swap (to make lesser)
 * [3,1,2]
 *
 *
 * [1,3,2]
 * [2,3,1]
 *
 * expected = [2,1,3]
 *
 * 	[5,4,7,5,3,2]   //expected = [5,5,2,3,4,7], actual = [5,5,4,7,3,2]
 * 	[5,5,7,4,3,2]
 * 	[5,5,7,3,4,2]
 * 	[5,7,5,3,4,2]
 * 	[5,7,3,5,4,2]
 *
 *
 * 	nums = new int[]{4,2,0,2,3,2,0};//actual = [4,2,2,0,0,2,3], expected =[4,2,0,3,0,2,2]
 * 	[4,2,0,2,3,2,0]
 * 	[4,2,2,2,3,0,0]
 * 	[4,2,2,0,0,2,3]
 *
 */
public class NextPermutation{

	public static void main(String [] args){
		NextPermutation nextPermutation = new NextPermutation();
		int [] nums = new int[]{1,2,3}; //[1,3,2]
		nextPermutation.nextPermutation(nums);
		nums = new int[]{1,3,2}; //[2,1,3]
		nextPermutation.nextPermutation(nums);
		nums = new int[]{3,2,1}; //[1,2,3]
		nextPermutation.nextPermutation(nums);
		nums = new int[]{2,3,1}; //[3,1,2]
 		nextPermutation.nextPermutation(nums);
		nums = new int[]{1,1,5};
		nextPermutation.nextPermutation(nums);
		nums = new int[]{6,7,5,3,5,6,2,9,1,2,7,0,9};
		nextPermutation.nextPermutation(nums);
		nums = new int[]{5,4,7,5,3,2}; //[5,5,2,3,4,7], actual = [5,5,4,7,3,2]
		nextPermutation.nextPermutation(nums);
		nums = new int[]{4,2,0,2,3,2,0};//actual = [4,2,2,0,0,2,3], expected =[4,2,0,3,0,2,2]
		nextPermutation.nextPermutation(nums);
		System.out.println("");
	}

	public void nextPermutation(int[] nums) {
		TreeMap<Integer,Integer> map = new TreeMap<>();
		for(int i = nums.length - 1; i >= 0; --i){
			for(int k = i - 1; k >= 0; --k){
				if(nums[i] > nums[k]){
					if(map.get(k) != null){
						map.put(k, Math.max(i, map.get(k)));
					}else{
						map.put(k, i);
					}
					break;
				}
			}
		}
		if(map.size() == 0){
			Arrays.sort(nums);
			return;
		}
		int swapIndexStart = map.lastKey();
		int swapIndexEnd = map.get(swapIndexStart);
		int tmp = nums[swapIndexStart];
		nums[swapIndexStart] = nums[swapIndexEnd];
		nums[swapIndexEnd] = tmp;
		Arrays.sort(nums, swapIndexStart + 1, nums.length);
	}

	public void nextPermutation3(int[] nums) {
		for(int i = nums.length - 1; i >= 0; --i){
			for(int k = i - 1; k >= 0; --k){
				if(nums[i] > nums[k]){
					int tmp = nums[k];
					nums[k] = nums[i];
					nums[i] = tmp;
					Arrays.sort(nums, k + 1, nums.length);
					return;
				}
			}
		}
		Arrays.sort(nums);
	}

	private void searchLeft(int[] nums){
		for(int i = nums.length - 1; i >= 0; --i){
			for(int k = i - 1; k >= 0; --k){
				if(nums[i] > nums[k]){
					int tmp = nums[k];
					nums[k] = nums[i];
					nums[i] = tmp;
					Arrays.sort(nums, k + 1, nums.length);
					searchLeft(nums);
				}
			}
		}
	}

	public void nextPermutation2(int[] nums) {
		TreeMap<String, String> permutations = new TreeMap<>();
		Map<Integer,Integer> indices = new HashMap<>();
		for(int i = 0; i < nums.length; ++i){
			indices.put(i, i);
		}
		for(int i = 0; i < nums.length; ++i){
			StringBuffer permutation = new StringBuffer();
			permutation.append(nums[i]);
			permute(nums, i, new TreeMap<>(indices), permutation, permutations);
		}
		StringBuffer value = new StringBuffer();
		for(int i = 0; i < nums.length; ++i){
			value.append(nums[i]);
		}
		String numsString = permutations.higherKey(value.toString());
		if(numsString == null){
			numsString = permutations.firstKey();
		}
		for(int i = 0; i < numsString.length(); ++i){
			nums[i] = Integer.valueOf(numsString.substring(i, i + 1));
		}
	}

	public void permute(int [] nums, int index, Map<Integer, Integer> indices,
			StringBuffer permutation, Map<String,String> permutations){
		indices.remove(index);
		for(int incIndex : indices.keySet()){
			StringBuffer permutation2 = new StringBuffer();
			permutation2.append(permutation.toString());
			permutation2.append(nums[incIndex]);
			permute(nums, incIndex, new TreeMap<>(indices), permutation2, permutations);
		}
		if(permutation.length() == nums.length){
			permutations.put(permutation.toString(), permutation.toString());
		}
	}

}
