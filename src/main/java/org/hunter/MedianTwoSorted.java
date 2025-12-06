package org.hunter;

public class MedianTwoSorted {

    //[1,5,6]
    //[2,3,4]

    //[1,2,3,*4*,*5*,6]

    /**
     * 5 index 2 in arr2
     * 3 index 1 in arr1
     *
     *
     *
     *
     */


    //[1,2,4,5]

    //1,7,10
    //4,5
    //1, 2
    //1, 1

    //[1,4,5,7,10]

    //[1,4,5,7,10]

    //1,*4*,7,*9*,10

    //1,4,7,9,10 = 7
    //insert low and high then take median based on altered array
    //[1,5,10]
    //[2,3,7]
    //[1,2,3,5,7,10] = 3 + 5 / 2

    //[1,2,3]
    //[300]

    public static void main(String [] args) {
        MedianTwoSorted medianTwoSorted = new MedianTwoSorted();
        System.out.println(medianTwoSorted.findMedianSortedArrays2(
                new int [] {1,2,3,4,5},
                new int [] {6,7,8,9,10,11,12,13,14,15,16,17}
        ));
    }

    int p1 = 0, p2 = 0;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if(length % 2 == 0) {
            for(int i = 0; i < (length / 2) - 1; ++i) {
                getMin(nums1, nums2);
            }
            return (double)(getMin(nums1, nums2) + getMin(nums1, nums2)) / 2;
        }
        for(int i = 0; i < (length / 2); ++i) {
            getMin(nums1, nums2);
        }
        return (double)getMin(nums1, nums2);
    }

    int getMin(int [] nums1, int [] nums2) {
        if(p1 < nums1.length && p2 < nums2.length) {
            if(nums1[p1] < nums2[p2]) {
                return nums1[p1++];
            }else{
                return nums2[p2++];
            }
        }else if(p1 < nums1.length) {
            return nums1[p1++];
        }else if(p2 < nums2.length) {
            return nums2[p2++];
        }
        //should never happen
        return -1;
    }

    //o(n)
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int [] merged = merge(nums1, nums2);
        if(merged.length == 1) {
            return merged[0];
        }
        int half = merged.length / 2;
        if(merged.length % 2 == 0) {
            return (double) (merged[half - 1] + merged[half]) / 2;
        }
        return (double)merged[half];
    }

    int [] merge(int [] nums1, int [] nums2) {
        int [] merged = new int[nums1.length + nums2.length];
        int left = 0, right = 0;
        int index = 0;
        while(left < nums1.length && right < nums2.length) {
            if(nums1[left] < nums2[right]) {
                merged[index] = nums1[left];
                ++left;
            }else {
                merged[index] = nums2[right];
                ++right;
            }
            ++index;
        }
        for(int i = left; i < nums1.length; ++i) {
            merged[index] = nums1[i];
            ++index;
        }
        for(int i = right; i < nums2.length; ++i) {
            merged[index] = nums2[i];
            ++index;
        }
        return merged;
    }

}
