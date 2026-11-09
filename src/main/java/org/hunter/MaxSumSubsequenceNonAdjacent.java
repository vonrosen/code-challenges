package org.hunter;

public class MaxSumSubsequenceNonAdjacent {

    public static void main(String [] args) {
        MaxSumSubsequenceNonAdjacent m = new MaxSumSubsequenceNonAdjacent();
        System.out.println(m.maximumSumSubsequence(
                new int [] {
                        3,5,9
                },
                new int [][] {
                        {1,-2},
                        {0,-3}
                }));
    }

    //O(Q * 2^N) without memoization
    //O(Q * N^2) with memoization
    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        int ans = 0;
        for (int [] query : queries) {
            nums[query[0]] = query[1];
            int thisAns = 0;
            Integer [] mem = new Integer[nums.length];
            for (int i = 0; i < nums.length; ++i) {
                thisAns = Math.max(thisAns, maximumSumSubsequence(nums, i, mem));
            }
            ans += thisAns;
        }
        return ans;
    }

    public int maximumSumSubsequence(int[] nums, int index, Integer[] mem) {
        if (index > nums.length - 1) {
            return 0;
        }
        if (mem[index] != null) {
            return mem[index];
        }
        int ans = nums[index];
        for (int i = index + 2; i < nums.length; ++i) {
            ans = Math.max(ans, nums[index] + maximumSumSubsequence(nums, i, mem));
        }
        mem[index] = ans;
        return ans;
    }

}
