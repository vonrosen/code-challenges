package org.hunter;

import java.util.ArrayList;
import java.util.List;

public class Permutations4{

	public static void main(String [] args){
		int [] arr = new int[] {1,2,3};
		Permutations4 permutations4 = new Permutations4();
		List<List<Integer>> permutations = permutations4.permute(arr);

		for(List<Integer> permutation: permutations){
			for(int i = 0; i < permutation.size(); ++i){
				System.out.print(permutation.get(i));
				System.out.print(" ");
			}
			System.out.println("");
		}
	}

	//O(N*N!), N
	private List<List<Integer>> permute(int [] integers){
		List<Integer> visited = new ArrayList<>();
		List<List<Integer>> permutations = new ArrayList<>();
		for(int i = 0; i < integers.length; ++i){
			visited.add(Integer.valueOf(integers[i]));
			permute(integers, visited, permutations);
			visited.remove(Integer.valueOf(integers[i]));
		}
		return permutations;
	}

	private void permute(int [] integers, List<Integer> visited,
			List<List<Integer>> permutations){
		for(int i = 0; i < integers.length; ++i){
			if(!visited.contains(integers[i])){
				visited.add(Integer.valueOf(integers[i]));
				permute(integers, visited, permutations);
				visited.remove(Integer.valueOf(integers[i]));
			}
		}
		if(visited.size() == integers.length){
			permutations.add(new ArrayList<>(visited));
		}
	}

}
