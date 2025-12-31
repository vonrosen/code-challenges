package org.hunter;

import java.util.Arrays;

public class HouseRobber {
    //1,2,3,1
    public static void main(String [] args){
        HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.rob(new int [] {1,2,3,1}));
        //6+8+3+10
        System.out.println(houseRobber.rob(new int [] {6,6,4,8,4,3,3,10}));//27
    }

    //there is something wrong with this solution.
    //the thing that is wrong is that it checks all starting
    //houses from all indexes. but it should not check all indexes as
    //starting indexes. it should only check index 0 and 1. other indexes
    //have no chance of being a max value. there for this solution is inefficient
    //yielding O(n^2) when it should be O(n)!
    public int rob(int[] nums) {
        int [] mem = new int[nums.length];
        Arrays.fill(mem, -1);
        int ans = 0;
        for(int i = 0; i < nums.length; ++i) {
            ans = Math.max(ans, rob(i, nums, mem));
        }
        return ans;
    }

    int rob(int curIndex, int [] nums, int [] mem) {
        if(curIndex > nums.length - 1) {
            return 0;
        }
        if(mem[curIndex] != -1) {
            return mem[curIndex];
        }
        int ans = nums[curIndex];
        for(int i = curIndex + 2; i < nums.length; i++) {
            int amount = nums[curIndex] + rob(i, nums, mem);
            ans = Math.max(ans, amount);
        }
        mem[curIndex] = ans;
        return ans;
    }
}
