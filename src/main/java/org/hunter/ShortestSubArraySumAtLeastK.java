package org.hunter;

import java.util.*;

/**
 * -46,-9,-17,-50,-7,-11,-45,-2,27,64, k = 44, ans = 1 [64]
 * at i = 9 num is 64. so need to find index 8 but we find index 5 instead because
 * prefix sum - k = -140 and -140 exists as a prev prefix sum w index 5.
 * so we must find any prev prefix sum less than -140 and then find the
 * max index of those
 * its easy to find all the prev entries < prefix sum - k. the problem
 * is we must then find the max index of those entries and they are not sorted
 * so we can't use binary search. how can we keep a running list of sorted indices
 * which can be looked up. that is probably not possible
 *
 * what if when we look back to get the prev prefix sum which is <= current psum - k
 * we can only choose from those that are monitonically increasing
 * so at i = 9 our choices are those < -160 which filters out -140 which has the
 * wrong index of 5. keep a stack of monitonically increasing
 * example: -170,-166,-160
 *
 *
 * how to keep a sorted list of indexes
 *  k = 3
 *  2,-1,2
 *  0,2,1,3
 */
public class ShortestSubArraySumAtLeastK {

    public static void main(String [] args) {
        ShortestSubArraySumAtLeastK s = new ShortestSubArraySumAtLeastK();
        System.out.println(s.shortestSubarray(new int [] {
                1
        }, 1));//1
        System.out.println(s.shortestSubarray(new int [] {
                1,2
        }, 4));//-1
        System.out.println(s.shortestSubarray(new int [] {
                2,-1,2
        }, 3));//3
        System.out.println(s.shortestSubarray(new int [] {
                0,0,69,56,-34
        }, 91)); //2
        System.out.println(s.shortestSubarray(new int [] {
                -43,97,96,87,80
        }, 97)); //1
        System.out.println(s.shortestSubarray(new int [] {
                54,-5,53,-19,85
        }, 119)); //3
        System.out.println(s.shortestSubarray(new int [] {
                -46,-9,-17,-50,-7,-11,-45,-2,27,64
        }, 44)); //1
        System.out.println(s.shortestSubarray(new int [] {
                -49,16,-41,24,12,-34,-35,-26,53,19
        }, 72)); //2
    }

    //2,-1,2, k = 3
    //2,1,3
    //stack = [0,2,3]
    public int shortestSubarray(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        map.put(0, -1);
        int ans = Integer.MAX_VALUE;
        int prefixSum = 0;
        for(int i = 0; i < nums.length; ++i) {
            prefixSum += nums[i];
            while (!stack.isEmpty() && stack.peek() > prefixSum) {
                map.remove(stack.peek());
                stack.pop();
            }
            int needed = prefixSum - k;
            Integer prevPrefixSum = map.floorKey(needed);
            if (prevPrefixSum != null) {
                ans = Math.min(ans, i - map.get(prevPrefixSum));
            }
            map.put(prefixSum, i);
            stack.push(prefixSum);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    //[2,-1,2,3] k = 3, ans = 1

    /**
     *         System.out.println(s.shortestSubarray(new int [] {
     *                 0,0,69,56,-34
     *         }, 91)); //2
     * @param nums
     * @param k
     * @return
     */
    //sliding window won't work
    public int shortestSubarray2(int[] nums, int k) {
        if (k == 0) {
            return 1;
        }
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; ++right) {
            sum += nums[right];
            if (nums[right] >= k) {
                ans = Math.min(ans, 1);
            }
            if (sum >= k) {
                ans = Math.min(ans, right - left + 1);
                while (left <= right) {
                    sum -= nums[left];
                    if (sum >= k) {
                        ans = Math.min(ans, right - left + 1);
                    }else {
                        break;
                    }
                    left++;
                }
                sum += nums[left];
                ans = Math.min(ans, right - left + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

}
