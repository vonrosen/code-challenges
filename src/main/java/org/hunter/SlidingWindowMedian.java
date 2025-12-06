package org.hunter;

import java.util.*;

public class SlidingWindowMedian {

    //o(n * (2)log(k))
    public double[] medianSlidingWindow(int[] nums, int k) {
        boolean even = k % 2 == 0;
        int half = k / 2;
        List<Long> window = new ArrayList<>();
        double [] ans = new double[nums.length - (k - 1)];
        int index = 0;
        for(int i = 0; i < nums.length; ++i) {
            if(index == 0) {
                window.add((long)nums[i]);
            }else{
                add(window, nums[i]);
            }
            if(window.size() == k) {
                if(i == k - 1) {
                    Collections.sort(window);
                    ans[index] = getMedian(window, even, half);
                }else {
                    ans[index] = getMedian(window, even, half);
                }
                int remove = nums[i - k + 1];
                remove(window, remove);
                ++index;
            }
        }
        return ans;
    }

    double getMedian(List<Long> window, boolean even, int half) {
        if(even) {
            return  (double)(window.get(half - 1) + window.get(half)) / 2;
        }
        return (double)window.get(half);
    }

    void add(List<Long> window, long target) {
        int index = binSearch(window, target);
        window.add(index, target);
    }

    void remove(List<Long> window, long target) {
        int index = binSearch(window, target);
        window.remove(index);
    }

    int binSearch(List<Long> window, long target) {
        int left = 0;
        int right = window.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (window.get(mid) == target) {
                return mid;
            }else if(window.get(mid) < target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }

}
