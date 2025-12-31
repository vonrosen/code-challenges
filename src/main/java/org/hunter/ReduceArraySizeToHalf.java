package org.hunter;

import java.util.*;

public class ReduceArraySizeToHalf {

    public int minSetSize(int[] arr) {
        Map<Integer,Integer> counts = new HashMap<>();
        for(int i = 0; i < arr.length; ++i) {
            counts.putIfAbsent(arr[i], 0);
            counts.put(arr[i], counts.get(arr[i]) + 1);
        }
        int size = arr.length;
        int target = size / 2;
        List<Integer> ordered = new ArrayList<>(counts.values());
        Collections.sort(ordered, Comparator.reverseOrder());
        int ans = 0;
        for(int i = 0; i < ordered.size(); ++i) {
            ans++;
            size -= ordered.get(i);
            if(size <= target){
                return ans;
            }
        }
        return ans;
    }

}
