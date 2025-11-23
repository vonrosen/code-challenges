package org.hunter;

public class BinSearch {

    public static void main(String [] args) {
        int [] arr = new int[]{1,3,7,12};
        BinSearch binSearch = new BinSearch();
        System.out.println(binSearch.searchInsert(arr, 3));
        System.out.println(binSearch.searchInsert(arr, 10));
        System.out.println(binSearch.searchInsert(arr, 21));
    }

    /**
     * Input: nums = [4,5,2,1], queries = [3,10,21]
     * [1,3,7,12]
     * @param nums
     * @param queries
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

}
