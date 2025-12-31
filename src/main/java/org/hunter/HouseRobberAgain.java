package org.hunter;

import java.util.Arrays;

public class HouseRobberAgain {

    //recurrence relation
    //dp(i) = max(amount + dp(i + 2), dp(i + 1))
    public int rob(int[] nums) {
        int [] mem = new int[nums.length];
        Arrays.fill(mem, -1);
        return Math.max(
                rob(0, nums, mem),
                rob(1, nums, mem)
        );
    }

    int rob(int index, int [] nums, int [] mem) {
        if(index > nums.length - 1) {
            return 0;
        }
        if(mem[index] != -1) {
            return mem[index];
        }
        int gain = Math.max(
                nums[index] + rob(index + 2, nums, mem),
                rob(index + 1, nums, mem)
        );
        mem[index] = gain;
        return gain;
    }
}
