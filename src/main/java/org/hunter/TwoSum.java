package org.hunter;

import java.util.*;

public class TwoSum {

    public static void main(String [] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(twoSum.twoSum(new int []{5,6,7,19,4}, 11));
    }

    public List<List<Integer>> twoSum(int [] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            int sum = arr[left] + arr[right];
            if(sum == target) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(arr[left]);
                tmp.add(arr[right]);
                ans.add(tmp);
                ++left;
                --right;
            }else if(sum > target) {
                --right;
            }else{
                ++left;
            }
        }
        return ans;
    }

}
