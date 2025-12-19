package org.hunter;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest3 {

    //[5,10,4,8] k = 3
    //heap = [4,5,8,10]
    //O(n*log(k)), if sorted it would be higher at O(n*log(n))
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>();
        for(int i = 0; i < nums.length; ++i) {
            maxHeap.add(nums[i]);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }

}
