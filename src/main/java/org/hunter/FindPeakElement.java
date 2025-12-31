package org.hunter;

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid - 1 < 0 && mid + 1 > nums.length - 1) {
                return mid;
            }else if (mid - 1 < 0 && nums[mid] > nums[mid + 1]) {
                return mid;
            }else if (mid - 1 < 0 && nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }else if (mid + 1 > nums.length - 1 && nums[mid] > nums[mid - 1]) {
                return mid;
            }else if (mid + 1 > nums.length -1 && nums[mid] < nums[mid - 1]) {
                right = mid - 1;
            } else if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            }else if (nums[mid - 1] > nums[mid]) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int findPeakElement2(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        for(int i = 1; i < nums.length - 1; ++i) {
            if(nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        if(nums[0] > nums[1]) {
            return 0;
        }
        if(nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        return -1;
    }
}
