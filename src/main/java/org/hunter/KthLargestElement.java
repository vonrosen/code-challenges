package org.hunter;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {

    /**
     * [3,2,1,5,6,4]
     *
     * @param nums
     * @param k
     * @return
     */

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for(int num: nums){
            minHeap.add(num);
            if(minHeap.size() > k){
                minHeap.remove();
            }
        }
        return minHeap.peek();
    }
}
