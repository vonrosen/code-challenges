package org.hunter;

import java.util.PriorityQueue;
import java.util.Queue;

public class MaxUnitsOnATruck {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Queue<int[]> heap = new PriorityQueue<>((b1, b2) -> b2[1] - b1[1]);
        for(int [] boxType: boxTypes) {
            heap.add(boxType);
        }
        int ans = 0;
        while(!heap.isEmpty()) {
            int[] boxType = heap.poll();
            if(boxType[0] > truckSize) {
                ans += (truckSize * boxType[1]);
                return ans;
            }else{
                ans += boxType[0] * boxType[1];
                truckSize -= boxType[0];
            }
        }
        return ans;
    }

}
