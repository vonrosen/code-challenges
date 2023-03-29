package org.hunter;

import java.util.Arrays;

public class RandomIndexPick{

	public static void main(String [] args){
		RandomIndexPick solution = new RandomIndexPick(new int[]{1});
		System.out.println(solution.pickIndex());
		solution = new RandomIndexPick(new int[]{1,3});
		System.out.println(solution.pickIndex());
		solution = new RandomIndexPick(new int[]{3,14,1,7});
		System.out.println(solution.pickIndex());
		solution = new RandomIndexPick(new int[]{188,927,949,95,151,659,405,906,481,363,728,839});
		System.out.println(solution.pickIndex());
	}

	private int [] prefixSums;
	private int sum;

	public RandomIndexPick(int[] w) {
		prefixSums = new int[w.length];
		for(int i = 0; i < w.length; ++i){
			if(i == 0){
				prefixSums[i] = w[i];
			}else{
				prefixSums[i] += prefixSums[i - 1] + w[i];
			}
		}
		sum = Arrays.stream(w).sum();
	}

	public int pickIndex() {
		double rand = Math.random() * sum;
		for(int i = 0; i < prefixSums.length; ++i){
			if(rand < prefixSums[i]){
				return i;
			}
		}
		return -1;
	}

}
