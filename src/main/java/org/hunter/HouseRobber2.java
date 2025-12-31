package org.hunter;

import java.util.Arrays;

public class HouseRobber2 {

    public static void main(String [] args) {
        HouseRobber2 houseRobber2 = new HouseRobber2();
        int [] nums = new int[]{2,3,2};
        System.out.println(houseRobber2.robOrig(nums));
        nums = new int[]{6,6,4,8,4,3,3,10};
        System.out.println(houseRobber2.robOrig(nums));
    }

    public int robOrig(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int [][] mem = new int[nums.length][2];
        for(int i = 0; i < mem.length; ++i) {
            Arrays.fill(mem[i], -1);
        }
        int ans = 0;
        for(int i = 0; i < nums.length; ++i) {
            ans = Math.max(ans, robOrig(i, nums, mem, i == 0));
        }
        return ans;
    }

    int robOrig(int curIndex, int [] nums, int [][] mem, boolean fromZero) {
        if(curIndex > nums.length - 1) {
            return 0;
        }
        if(curIndex == nums.length - 1 && fromZero) {
            return 0;
        }
        if(mem[curIndex][fromZero ? 0 : 1] != -1) {
            return mem[curIndex][fromZero ? 0 : 1];
        }
        int ans = nums[curIndex];
        for(int i = curIndex + 2; i < nums.length; i++) {
            int amount = nums[curIndex] + rob(i, nums, mem, fromZero);
            ans = Math.max(ans, amount);
        }
        mem[curIndex][fromZero ? 0 : 1] = ans;
        return ans;
    }

    public int rob(int [] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int [][] mem = new int[nums.length][2];
        for(int i = 0; i < mem.length; ++i) {
            Arrays.fill(mem[i], -1);
        }
        int ans1 = rob(0, nums, mem, true);
        int ans2 = rob(1, nums, mem, false);
        return Math.max(ans1, ans2);
    }

    int rob(int index, int [] nums, int [][] mem, boolean fromZero) {
        if(index > nums.length - 1) {
            return 0;
        }
        if(index == nums.length - 1 && fromZero) {
            return 0;
        }
        if(mem[index][fromZero ? 0 : 1] != -1) {
            return mem[index][fromZero ? 0 : 1];
        }
        int ans = Math.max(
                rob(index + 1, nums, mem, fromZero),
                rob(index + 2, nums, mem, fromZero) + nums[index]
        );
        mem[index][fromZero ? 0 : 1] = ans;
        return ans;
    }

}
