package org.hunter;

public class SquaresSorted {
    public static void main(String [] args) {
//        int [] arr = new int[]{-10000,-9999,-7,-5,0,0,10000};
//        int [] arr = new int[]{-3,-3,-2,1};
//        int [] arr = new int[]{-10,-3,-2,-2,-2,1,3,3,4,8};
        int [] arr = new int[]{-10,-6,-5,-3,-2,-2,3,3,3,5};
        SquaresSorted ss = new SquaresSorted();
        ss.sortedSquares2(arr);
    }

    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int [] ans = new int[nums.length];
        int index = nums.length - 1;
        while (i <= j) {
            if(Math.abs(nums[i]) < Math.abs(nums[j])) {
                ans[index] = nums[j] * nums[j];
                j--;
            }else {
                ans[index] = nums[i] * nums[i];
                i++;
            }
            index--;
        }
        return ans;
    }

    public int[] sortedSquares2(int[] nums) {
        if (nums[0] >= 0) {
            for(int i = 0; i < nums.length; ++i) {
                nums[i] = nums[i] * nums[i];
            }
            return nums;
        }
        if(nums[nums.length - 1] <= 0) {
            int [] nums2 = new int[nums.length];
            int tmpi = 0;
            for (int i = nums.length - 1; i >= 0; --i) {
                nums2[tmpi] = nums[i] * nums[i];
                tmpi++;
            }
            return nums2;
        }
        int lenfirst = 0;
        boolean stop = false;
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = nums[i] * nums[i];
            if (!stop && i < nums.length - 1 && nums[i] >= (nums[i + 1] * nums[i + 1])) {
                lenfirst = i + 1;
            }else {
                stop = true;
            }
        }
        int lensecond = nums.length - lenfirst;
        int [] arr1 = new int[lenfirst];
        int [] arr2 = new int[lensecond];
        int tmpi = 0;
        for(int i = lenfirst - 1; i >= 0; --i) {
            arr1[tmpi] = nums[i];
            tmpi++;
        }
        tmpi = 0;
        for(int i = lenfirst; i < nums.length; ++i) {
            arr2[tmpi] = nums[i];
            tmpi++;
        }
        int fi = 0;
        int si = 0;
        int index = 0;
        while (fi < lenfirst && si < lensecond) {
            if (arr1[fi] < arr2[si]) {
                nums[index] = arr1[fi];
                ++fi;
            } else {
                nums[index] = arr2[si];
                ++si;
            }
            ++index;
        }
        for(int i = fi; i < lenfirst; ++i) {
            nums[index] = arr1[i];
            ++index;
        }
        for(int i = si; i < lensecond; ++i) {
            nums[index] = arr2[i];
            ++index;
        }
        return nums;
    }
}
