package org.hunter;

import java.util.HashMap;
import java.util.Map;

public class SparseVector {

    private Map<Integer,Integer> map;

    public SparseVector(int [] nums) {
        map = new HashMap<>(nums.length);
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
    }

    int dotProduct(SparseVector v) {
        int ans = 0;
        for(int key : map.keySet()) {
            if(v.map.containsKey(key)) {
                ans += (map.get(key) * v.map.get(key));
            }
        }
        return ans;
    }

}
