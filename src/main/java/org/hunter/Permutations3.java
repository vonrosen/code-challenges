package org.hunter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutations3{

	public static void main(String [] args){
		Permutations3 permutations3 = new Permutations3();
		int [] nums = new int[]{3,1,66};
		List<List<Integer>> permutations = permutations3.permute(nums);
		System.out.println(permutations);
		nums = new int[]{3,1,66,4,6,33,5,22,450};
		permutations = permutations3.permute(nums);
		System.out.println(permutations.size());
		System.out.println(permutations);
	}

	//time = O(N * N!)
	public List<List<Integer>> permute(int [] nums){
		List<List<Integer>> permutations = new ArrayList<>();
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; ++i){
			map.put(i, i);
		}
		for(int i = 0; i < nums.length; ++i){
			List<Integer> permutation = new ArrayList<>();
			permutation.add(nums[i]);
			permute(nums, permutation, permutations, i, new HashMap<>(map));
		}
		return permutations;
	}

	void permute(int [] nums, List<Integer> permutation, List<List<Integer>> permutations,
			int i, Map<Integer,Integer> map){
		map.remove(i);
		for(Integer index : map.keySet()){
			List<Integer> perm = new ArrayList<>(permutation);
			perm.add(nums[index]);
			permute(nums, perm, permutations, index, new HashMap<>(map));
		}
		if(map.size() == 0){
			permutations.add(permutation);
		}
	}

	//you can't memoize this
//	public List<List<Integer>> permuteMem(int [] nums){
//		List<List<Integer>> permutes = new ArrayList<>();
//		Map<Integer,Integer> map = new HashMap<>();
//		Map<String,List<List<Integer>>> mem = new HashMap<>();
//		for(int i = 0; i < nums.length; ++i){
//			map.put(i, i);
//		}
//		for(int i = 0; i < nums.length; ++i){
//			permutes.addAll(permuteMem(nums, i, new HashMap<>(map), nums.length - 1, mem));
//		}
//		return permutes;
//	}
//
//	List<List<Integer>> permuteMem(int [] nums,
//			int i, Map<Integer,Integer> map, int size, Map<String,List<List<Integer>>> mem){
//		List<List<Integer>> permutes = new ArrayList<>();
//		if(mem.get(i + "-" + size) != null){
//			return mem.get(i + "-" + size);
//		}
//		map.remove(i);
//		for(Integer index : map.keySet()){
//			for(List<Integer> p : permuteMem(nums, index, new HashMap<>(map), size - 1, mem)){
//				List<Integer> newPermutation = new ArrayList<>();
//				newPermutation.add(nums[i]);
//				newPermutation.addAll(p);
//				permutes.add(newPermutation);
//			}
//		}
//		if(map.size() == 0){
//			List<Integer> newPermutation = new ArrayList<>();
//			newPermutation.add(nums[i]);
//			List<List<Integer>> p = new ArrayList<>();
//			p.add(newPermutation);
//			mem.put(i + "-" + size, p);
//			return p;
//		}
//		mem.put(i + "-" + size, permutes);
//		return permutes;
//	}

}
