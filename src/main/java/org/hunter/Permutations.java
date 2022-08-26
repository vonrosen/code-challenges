package org.hunter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 */
public class Permutations{

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> lists = new ArrayList<>();
		permute(0, nums, lists);
		return lists;
	}

	public void permute(int pos, int [] nums, List<List<Integer>> lists){
		if(pos == nums.length - 1){
			List<Integer> list = new ArrayList<>();
			list.add(nums[pos]);
			lists.add(list);
			return;
		}
		permute(pos + 1, nums, lists);
		List<List<Integer>> tmp = new ArrayList<>();
		for(List<Integer> list: lists){
			for(int j = 0; j <= list.size(); ++j){
				List<Integer> l = new ArrayList<>(list);
				l.add(j, nums[pos]);
				tmp.add(l);
			}
		}
		lists.clear();
		lists.addAll(tmp);
	}

	public static void main(String [] args){
		Permutations permutations = new Permutations();
		System.out.println(permutations.permute(new int[]{1}));
		System.out.println(permutations.permute(new int[]{0, 1}));
		System.out.println(permutations.permute(new int[]{1, 2, 3}));
		System.out.println(permutations.permute(new int[]{5,4,6,2}));
	}
}
