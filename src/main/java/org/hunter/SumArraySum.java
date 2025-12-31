package org.hunter;

import java.util.HashMap;
import java.util.Map;

public class SumArraySum {

    /**
     * k = 3
     * [1,2,3]
     * [1,3,6]
     * ans = 2
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int [] prefix = new int[nums.length];
        Map<Integer,Integer> counts = new HashMap<>();
        counts.put(0, 1);
        int ans = 0;
        for(int i = 0; i < nums.length; ++i) {
            prefix[i] = i == 0 ? nums[0] : prefix[i - 1] + nums[i];
            int want = prefix[i] - k;
            if(counts.containsKey(want)) {
                ans += counts.get(want);
            }
            //key track of HOW MANY times have we seen this prefix sum before!
            counts.putIfAbsent(prefix[i], 0);
            counts.put(prefix[i], counts.get(prefix[i]) + 1);
        }
        return ans;
    }
}
