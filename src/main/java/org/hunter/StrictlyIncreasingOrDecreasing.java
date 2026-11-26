package org.hunter;

public class StrictlyIncreasingOrDecreasing {

    public static void main(String [] args) {
        StrictlyIncreasingOrDecreasing s = new StrictlyIncreasingOrDecreasing();
        System.out.println(s.longestMonotonicSubarray(new int [] {
                1,4,3,3,2
        }));
        System.out.println(s.longestMonotonicSubarray(new int [] {
                3,3,3,3
        }));
        System.out.println(s.longestMonotonicSubarray(new int [] {
                3,2,1
        }));
        System.out.println(s.longestMonotonicSubarray(new int [] {
                1,9,7,1
        }));
        System.out.println(s.longestMonotonicSubarray2(new int [] {
                1,5,2,7
        }));
    }

    public int longestMonotonicSubarray(int[] nums) {
        int incCounter = 1;
        int decCounter = 1;
        int ans = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] < nums[i]) {
                incCounter++;
                decCounter = 1;
            } else if (nums[i - 1] > nums[i]) {
                decCounter++;
                incCounter = 1;
            } else {
                incCounter = decCounter = 1;
            }
            ans = Math.max(ans, decCounter);
            ans = Math.max(ans, incCounter);
        }
        return ans;
    }

    public int longestMonotonicSubarray2(int[] nums) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;
        int ans = 1;
        int localAns = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] < nums[i]) {
                if (isIncreasing) {
                    ++localAns;
                    isDecreasing = false;
                } else {
                    isIncreasing = true;
                    isDecreasing = false;
                    localAns = 2;
                }
            } else if (nums[i - 1] > nums[i]) {
                if (isDecreasing) {
                    ++localAns;
                    isIncreasing = false;
                } else {
                    isDecreasing = true;
                    isIncreasing = false;
                    localAns = 2;
                }
            } else {
                isDecreasing = isIncreasing = true;
                localAns = 1;
            }
            ans = Math.max(ans, localAns);
        }
        return ans;
    }

}
