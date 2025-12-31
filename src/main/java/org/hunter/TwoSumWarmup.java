package org.hunter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumWarmup {

    public static void main(String [] args) {
        TwoSumWarmup twoSumWarmup = new TwoSumWarmup();
        System.out.println(twoSumWarmup.twoSum(new int [] {1,2,3,4,5,6}, 7));
        System.out.println(twoSumWarmup.twoSum(new int [] {1,2,3,4,5,6}, 5));
        System.out.println(twoSumWarmup.twoSum(new int [] {1,2,3,4,5,6}, 1));
    }

    //O(n * log(n))
    public List<List<Integer>> twoSum(int [] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        List<List<Integer>> ans = new ArrayList<>();
        while(left < right) {
            int curSum = nums[left] + nums[right];
            if(curSum == target) {
                List<Integer> two = List.of(nums[left], nums[right]);
                ans.add(two);
                ++left;
                --right;
            }else if(curSum < target) {
                ++left;
            }else {
                --right;
            }
        }
        return ans;
    }

}
