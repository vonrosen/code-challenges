package org.hunter;

public class MaxAverageSubarray {
    public double findMaxAverage(int[] nums, int k) {
        double curr = 0.0;
        for (int i = 0; i < k; ++i) {
            curr += nums[i];
        }
        double ans = curr / k;
        int index = 0;
        for(int i = k; i < nums.length; ++i) {
            curr += nums[i] - nums[index];
            ans = Math.max(ans, curr / k);
            ++index;
        }
        return ans;
    }
}
