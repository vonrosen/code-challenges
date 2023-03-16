package org.hunter;

import java.util.Arrays;

public class JumpGame2{

	public static void main(String [] args){
		int [] nums = new int[]{ 2, 3, 1, 1, 4};
		JumpGame2 jumpGame = new JumpGame2();
		System.out.println(jumpGame.jump(nums));
		nums = new int[]{2,3,0,1,4};
		System.out.println(jumpGame.jump(nums));
		nums = new int[]{1,2,1,1,1};
		System.out.println(jumpGame.jump(nums));
//		nums = new int[]{0};
//		System.out.println(jumpGame.jump(nums));
//		nums = new int[]{2,0};
//		System.out.println(jumpGame.jump(nums));
//		nums = new int[]{5,9,3,2,1,0,2,3,3,1,0,0};
//		System.out.println(jumpGame.jump(nums));
//		nums = new int[]{3,0,8,2,0,0,1};
//		System.out.println(jumpGame.jump(nums));
	}

	//time = O(N^2) space = O(N), using memoization
	public int jump(int[] nums) {
		if(nums.length <= 1){
			return 0;
		}
		int [] mem = new int[nums.length];
		Arrays.fill(mem, -1);
		for(int i = 0; i < nums.length; ++i){
			for(int k = 1; k <= nums[i]; ++k){
				if(i + k < nums.length){
					if(i == 0){
						mem[k] = 1;
					}else{
						if(mem[i + k] == -1){
							mem[i + k] = mem[i] + 1;
						}else{
							mem[i + k] = Math.min(mem[i] + 1, mem[i + k]);
						}
					}
				}
			}
		}
		return mem[nums.length - 1];
	}

	//time ~= O(2^N) space = O(1)
	public int jump2(int[] nums) {
		return jump(0, 0, nums);
	}

	private Integer jump(int pos, int numbJumps, int[] nums){
		if(pos > nums.length - 1){
			return null;
		}
		if(pos == nums.length - 1){
			return numbJumps;
		}
		if(nums[pos] == 0){
			return null;
		}
		Integer minJumps = null;
		for(int i = 1; i <= nums[pos]; ++i){
			Integer jumps = jump(pos + i, numbJumps + 1, nums);
			if(jumps != null){
				if(minJumps != null){
					minJumps = Math.min(minJumps, jumps);
				}else{
					minJumps = jumps;
				}
			}
		}
		return minJumps;
	}

}
