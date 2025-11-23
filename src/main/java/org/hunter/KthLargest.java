package org.hunter;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {

    int k;
    Queue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>();
        for(int i = 0; i < nums.length; ++i) {
            queue.add(nums[i]);
            if(queue.size() > k) {
                queue.remove();
            }
        }
    }

    public int add(int val) {
        queue.add(val);
        if(queue.size() > k) {
            queue.remove();
        }
        return queue.peek();
    }
}
