package org.hunter;

import java.util.*;

public class AppendKIntegersWithMinimalSum {

    //O(k * nums.length)
    public long minimalKSum2(int[] nums, int k) {
        List<Integer> numsList = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            if(!set.contains(n)) {
                numsList.add(n);
            }
            set.add(n);
        }
        Collections.sort(numsList);
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < k; ++i) {
            int newk = 1;
            for(int j = 0; j < numsList.size(); ++j) {
                if(numsList.get(j) <= newk) {
                    newk++;
                }else{
                    ans.add(newk);
                    numsList.add(j, newk);
                    break;
                }
                if(j == numsList.size() - 1) {
                    ans.add(newk);
                    numsList.add(numsList.size(), newk);
                    break;
                }
            }
        }
        int sum = 0;
        for(int a : ans) {
            sum += a;
        }
        return sum;
    }


    public long minimalKSum(int[] nums, int k) {
        List<Integer> numsList = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            if(!set.contains(n)) {
                numsList.add(n);
            }
            set.add(n);
        }
        Collections.sort(numsList);
        List<Integer> ans = new ArrayList<>();
        long numsSum = 0;
        for(int j = 0; j < numsList.size(); ++j) {
            if(numsList.get(j) <= k) {
                k++;
            }else{
                break;
            }
            numsSum += numsList.get(j);
        }
        //sum up to newk - numSum
        //newk + (newk - 1) + (newk - 2)... + 1
        //
        long kSum = 0;
        while(k > 0) {
            kSum += k;
            k -= 1;
        }
        return kSum - numsSum;
    }

}
