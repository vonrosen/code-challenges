package org.hunter;

import java.util.Arrays;

/**
 * h = 8
 * k = ? (bananas per hour)
 * 1,??,??,660000
 */
public class LongestSubSequenceWithLimitedSum {

    public static void main(String [] args) {
        LongestSubSequenceWithLimitedSum l = new LongestSubSequenceWithLimitedSum();
        l.answerQueries(new int [] {4,5,2,1}, new int [] {3,10,21});
    }

    /**
     * Input: nums = [4,5,2,1], queries = [3,10,21]
     * [1,3,7,12]
     * @param nums
     * @param queries
     * @return
     */
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int [] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i = 1; i < nums.length; ++i){
            prefix[i] = prefix[i - 1] + nums[i];
        }
        int [] answer = new int[queries.length];
        for(int i = 0; i < queries.length; ++i) {
            answer[i] = binSearch(prefix, queries[i]);
        }
        return answer;
    }

    int binSearch(int [] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid + 1;
            }
            if (arr[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

}
