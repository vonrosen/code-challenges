package org.hunter;

public class JumpGame{

	public static void main(String [] args){
		int [] nums = new int[]{ 2, 3, 1, 1, 4};
		JumpGame jumpGame = new JumpGame();
		System.out.println(jumpGame.canJump(nums));
		nums = new int[]{3,2,1,0,4};
		System.out.println(jumpGame.canJump(nums));
		nums = new int[]{0};
		System.out.println(jumpGame.canJump(nums));
		nums = new int[]{2,0};
		System.out.println(jumpGame.canJump(nums));
		nums = new int[]{5,9,3,2,1,0,2,3,3,1,0,0};//false
		System.out.println(jumpGame.canJump(nums));
		nums = new int[]{3,0,8,2,0,0,1}; //true
		System.out.println(jumpGame.canJump(nums));
	}

	//time O(2^N) without memoization, space = O(N) with memoization
	public boolean canJump(int[] nums) {
		Boolean [] mem = new Boolean[nums.length];
		return canJump(0, nums, mem);
	}

	private boolean canJump(int pos, int[] nums, Boolean [] mem){
		if(mem[pos] != null){
			return mem[pos];
		}
		if(pos > nums.length - 1){
			return false;
		}
		if(pos == nums.length - 1){
			return true;
		}
		if(nums[pos] == 0){
			return false;
		}
		for(int i = 1; i <= nums[pos]; ++i){
			boolean result = canJump(pos + i, nums, mem);
			mem[pos + 1] = result;
			if(result){
				return true;
			}
		}
		return false;
	}

}
