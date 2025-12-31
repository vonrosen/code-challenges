package org.hunter;

import java.util.PriorityQueue;
import java.util.Queue;

public class ConnectSticks {

    public int connectSticks(int[] sticks) {
        Queue<Integer> queue = new PriorityQueue<>();
        for(int cost : sticks) {
            queue.add(cost);
        }
        int cost = 0;
        while(!queue.isEmpty()) {
            if(queue.size() == 1) {
                break;
            }
            int c1 = queue.poll();
            int c2 = queue.poll();
            cost += (c1 + c2);
            queue.add(c1 + c2);
        }
        return cost;
    }
}
