package org.hunter;

import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String [] args) {
        ThreeSumClosest t = new ThreeSumClosest();
        System.out.println(t.threeSumClosest(
                new int [] {
                -1,2,1,-4
                },
                1));
        System.out.println(t.threeSumClosest(
                new int [] {
                        0,0,0
                },
                1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 2; i < nums.length; ++i) {
            int [] result = twoSum(nums, i - 1, target - nums[i]);
            int sum = nums[result[0]] + nums[result[1]] + nums[i];
            if (Math.abs(sum - target) < diff) {
                ans = sum;
                diff = Math.abs(sum - target);
            }
        }
        return ans;
    }

    private int [] twoSum(int [] nums, int high, int target) {
        int low = 0;
        int diff = Integer.MAX_VALUE;
        int [] indices = new int [] {
                low,
                high,
        };
        while (low < high) {
            int sum = nums[low] + nums[high];
            if (Math.abs(sum - target) < diff) {
                diff = Math.abs(sum - target);
                indices[0] = low;
                indices[1] = high;
            }
            if (sum < target) {
                ++low;
            }else if (sum > target) {
                --high;
            }else {
                return new int [] {
                        low,
                        high,
                };
            }
        }
        return indices;
    }

}
