package org.hunter;

public class MergeSortedArray {

    public static void main(String [] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int [] nums1 = new int []{1,2,3,0,0,0};
        mergeSortedArray.merge(nums1, 3, new int [] {2,5,6}, 3);
        for(int i = 0; i < nums1.length; ++i) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println("");
        nums1 = new int []{2,0};
        mergeSortedArray.merge(nums1, 1, new int [] {1}, 1);
        for(int i = 0; i < nums1.length; ++i) {
            System.out.print(nums1[i] + " ");
        }
    }

    /**
     * [2,0]
     * 1
     * [1]
     * 1
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m - 1;
        int i2 = n - 1;
        int index = m + n - 1;
        while(index >= 0) {
            if (i1 >= 0 && i2 >= 0) {
                if(nums1[i1] > nums2[i2]) {
                    nums1[index] = nums1[i1];
                    --i1;
                }else{
                    nums1[index] = nums2[i2];
                    --i2;
                }
            }else {
                break;
            }
            --index;
        }
        for(int i = i1; i >= 0; --i) {
            nums1[index] = nums1[i];
            --index;
        }
        for(int i = i2; i >= 0; --i) {
            nums1[index] = nums2[i];
            --index;
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int [] n1 = new int[m + n];
        int i1 = 0, i2 = 0;
        int index = 0;
        while(i1 < m && i2 < nums2.length) {
            if(nums1[i1] < nums2[i2]) {
                n1[index] = nums1[i1];
                ++i1;
            }else{
                n1[index] = nums2[i2];
                ++i2;
            }
            index++;
        }
        for(int i = i1; i < m; ++i) {
            n1[index] = nums1[i];
            ++index;
        }
        for(int i = i2; i < nums2.length; ++i) {
            n1[index] = nums2[i];
            ++index;
        }
        for(int i = 0; i < m + n; ++i) {
            nums1[i] = n1[i];
        }
    }


}
