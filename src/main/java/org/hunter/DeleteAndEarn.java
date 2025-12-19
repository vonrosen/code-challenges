package org.hunter;

import java.util.*;

public class DeleteAndEarn {


    //recurrence relation
    // dp(number) = max(gain + dp(number - 2), dp(number - 1)
    public int deleteAndEarn(int [] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> mem = new HashMap<>();
        int maxNumber = 0;
        for(int i = 0; i < nums.length; ++i) {
            map.putIfAbsent(nums[i], 0);
            map.put(nums[i], map.get(nums[i]) + nums[i]);
            maxNumber = Math.max(maxNumber, nums[i]);
        }
        return maxGain(maxNumber, map, mem);
    }

    int maxGain(int maxNumber, Map<Integer,Integer> map, Map<Integer,Integer> mem) {
        if(maxNumber == 0) {
            return 0;
        }
        if(maxNumber == 1) {
            return map.getOrDefault(1, 0);
        }
        if(mem.containsKey(maxNumber)) {
            return mem.get(maxNumber);
        }
        int ans = Math.max(
                map.getOrDefault(maxNumber, 0) + maxGain(maxNumber - 2, map, mem),
                maxGain(maxNumber - 1, map, mem)
        );
        mem.put(maxNumber, ans);
        return ans;
    }


//    record Holder(
//            int num,
//            int points
//    ){}
//
//    public int deleteAndEarn(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for(int i = 0; i < nums.length; ++i) {
//            set.add(nums[i]);
//        }
//        Map<Integer,Integer> map = new HashMap<>();
//        for(int i = 0; i < nums.length; ++i) {
//            map.putIfAbsent(nums[i], 0);
//            map.put(nums[i], map.get(nums[i]) + 1);
//        }
//        Queue<Holder> queue = new PriorityQueue<>((h1, h2) -> h2.points - h1.points);
//        for(int key: map.keySet()) {
//            int count = map.get(key);
//            queue.add(new Holder(key, key * count));
//        }
//        int ans = 0;
//        while(!queue.isEmpty()) {
//            Holder holder = queue.poll();
//            if(set.contains(holder.num)) {
//                ans += holder.points;
//                int below = holder.num - 1;
//                int above = holder.num + 1;
//                set.remove(holder.num);
//                set.remove(below);
//                set.remove(above);
//            }
//        }
//        return ans;
//    }

}
