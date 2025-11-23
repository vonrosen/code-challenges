package org.hunter;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest2 {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>();
        for(int i = 0; i < nums.length; ++i) {
            heap.add(nums[i]);
            if(heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }

}
