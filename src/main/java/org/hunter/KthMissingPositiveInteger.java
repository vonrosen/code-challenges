package org.hunter;

import java.util.HashSet;
import java.util.Set;

public class KthMissingPositiveInteger {


    public int findKthPositiveBinSearch(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        int newk = k;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] <= k + mid) {
                left = mid + 1;
                newk = k + left;
            }else {
                right = mid - 1;
            }
        }
        return newk;
    }

    public int find(int [] arr, int k) {
        for(int num : arr) {
            if(num <= k) {
                k++;
            }else {
                break;
            }
        }
        return k;
    }

    //check position of element in array vs value of element
    //value = 4 in array of [2,4]. if 4 was in correct position
    //it would be at index = 3 but it is at index = 1. so there are
    //2 missing numbers before it which is 4 - (1 + 1) = 2 missing number =
    //arr[i] - (i + 1)
    public int findKthPositive(int[] arr, int k) {
        int lastMissing = 0;
        for(int i = 0; i < arr.length; ++i) {
            int numberMissing = arr[i] - (i + 1);
            if(numberMissing >= k) {
                if(i == 0) {
                    return k;
                }else {
                    return arr[i - 1] + (k - lastMissing);
                }
            }
            lastMissing = numberMissing;
        }
        return arr[arr.length - 1] + (k - lastMissing);
    }

    public int findKthPositive2(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; ++i) {
            set.add(arr[i]);
        }
        int missing = 0;
        int positive = 1;
        while(true) {
            if(!set.contains(positive)) {
                missing++;
            }
            if(missing == k) {
                return positive;
            }
            ++positive;
        }
    }

}
