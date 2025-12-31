package org.hunter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WarmUp {

    public static void main(String [] args) {
        WarmUp warmUp = new WarmUp();
        System.out.println(warmUp.twoSum(new int[]{5,6,8,9,11,2}, 13));
    }

    public List<List<Integer>> twoSum(int [] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        while (left < right) {
            int sum = nums[left] + nums[right];
            if(sum > target) {
                --right;
            }else if (sum < target) {
                ++left;
            }else {
                ans.add(List.of(nums[left], nums[right]));
                ++left;
                --right;
            }
        }
        return ans;
    }

}
