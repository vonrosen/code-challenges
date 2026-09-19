package org.hunter;

public class MoveZeros {

    /**
     * [0,1,0,3,12]
     * [1,0,0,3,12]
     * [1,3,0,0,12]
     * [1,3,12,0,0]
     *
     * [1,3,12,0,0]
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int zeroPointer = 0;
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            if (num != 0) {
                swap(nums, i, zeroPointer);
                ++zeroPointer;
            }
        }
    }

    void swap(int [] nums, int from, int to) {
        int tmp = nums[from];
        nums[from] = nums[to];
        nums[to] = tmp;
    }

}
