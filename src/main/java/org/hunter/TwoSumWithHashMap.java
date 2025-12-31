package org.hunter;

import java.util.HashMap;
import java.util.Map;

public class TwoSumWithHashMap {

    public int [] twoSum(int [] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; ++i) {
            map.put(target - nums[i], i);
        }
        for(int i = 0; i < nums.length; ++i) {
            if(map.containsKey(nums[i]) && map.get(nums[i]) != i) {
                return new int[]{i, map.get(nums[i])};
            }
        }
        return null;
    }
}
