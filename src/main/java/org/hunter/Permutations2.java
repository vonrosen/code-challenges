package org.hunter;

import java.util.ArrayList;
import java.util.List;

public class Permutations2{

	public static void main(String [] args){
		Permutations2 permutations2 = new Permutations2();
		int [] nums = new int[]{1,2,3};
		System.out.println(permutations2.permute(nums));
		nums = new int[]{0,1};
		System.out.println(permutations2.permute(nums));
		nums = new int[]{1};
		System.out.println(permutations2.permute(nums));
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> permutations = new ArrayList<>();
		for(int i = 0; i < nums.length; ++i){
			List<Integer> permutation = new ArrayList<>();
			permutation.add(nums[i]);
			permute(nums, 1, permutation, permutations);
		}
		return permutations;
	}

	public void permute(int [] nums, int index, List<Integer> permutation, List<List<Integer>> permutations){
		if(index == nums.length){
			permutations.add(permutation);
			return;
		}
		for(int i = 0; i < nums.length; ++i){
			boolean skip = false;
			for(int value : permutation){
				if(value == nums[i]){
					skip = true;
					break;
				}
			}
			if(!skip){
				List<Integer> permutationCopy = new ArrayList<>();
				permutationCopy.addAll(permutation);
				permutationCopy.add(nums[i]);
				permute(nums, index + 1, permutationCopy, permutations);
			}
		}
	}

}
