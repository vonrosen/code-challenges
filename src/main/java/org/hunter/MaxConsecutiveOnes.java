package org.hunter;

public class MaxConsecutiveOnes {

    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int left = 0;
        int zcount = 0;
        for (int right = 0; right < nums.length; ++right) {
            if(nums[right] == 0) {
                ++zcount;
            }
            while(zcount > k) {
                if(nums[left] == 0) {
                    --zcount;
                }
                ++left;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

}
