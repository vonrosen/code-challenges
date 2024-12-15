package org.hunter;

class longestincreasingsubsequence {
    public int lengthOfLIS(int[] nums) {
        Integer [] mem = new Integer[nums.length];
        int ans = 0;
        for(int i = 0; i < nums.length; ++i){
            ans = Math.max(ans, lengthOfLIS(nums, i, mem));
        }
        return ans;        
    }

    int lengthOfLIS(int [] nums, int index, Integer [] mem){
        if(index > nums.length - 1){
            return 0;
        }
        if(mem[index] != null){
            return mem[index];
        }
        int ans = 1;
        for(int i = index + 1; i < nums.length; ++i){
            if(nums[index] < nums[i]){
                ans = Math.max(ans, 1 + lengthOfLIS(nums, i, mem));
            }
        }
        mem[index] = ans;
        return ans;
    }
}
