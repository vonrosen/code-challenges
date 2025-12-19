package org.hunter;

import java.util.Arrays;

public class LIS {

    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        int [][] mem = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; ++i) {
            for(int j = 0; j < nums.length; ++j) {
                Arrays.fill(mem[j], -1);
            }
            ans = Math.max(ans, lis(i, -1, nums, mem));
        }
        return ans;
    }

    int lis(int index, int lastIndex, int [] nums, int [][] mem) {
        if(index > nums.length - 1) {
            return 0;
        }
        if(lastIndex != -1 && mem[index][lastIndex] != -1) {
            return mem[index][lastIndex];
        }
        int ans;
        if(lastIndex == -1 || nums[lastIndex] < nums[index]) {
            if(lastIndex == -1) {
                lastIndex = index;
            }
            ans = Math.max(
                    1 + lis(index + 1, index, nums, mem),
                    lis(index + 1, lastIndex, nums, mem)
            );
        }else{
            ans = lis(index + 1, lastIndex, nums, mem);
        }
        mem[index][lastIndex] = ans;
        return ans;
    }

}
