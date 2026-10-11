package org.hunter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinSubSequenceNonIncreasingOrder {

    public static void main(String [] args) {
        MinSubSequenceNonIncreasingOrder m = new MinSubSequenceNonIncreasingOrder();
        System.out.println(m.minSubsequence(new int [] {
                4,3,10,9,8
        }));
        System.out.println(m.minSubsequence(new int [] {
                4,4,7,6,7
        }));
    }

    public List<Integer> minSubsequence(int[] nums) {
        int totalSum = 0;
        for (int num: nums) {
            totalSum += num;
        }
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            sum += nums[i];
            ans.add(nums[i]);
            if (sum > totalSum - sum) {
                return ans;
            }
        }
        return ans;
    }
}
