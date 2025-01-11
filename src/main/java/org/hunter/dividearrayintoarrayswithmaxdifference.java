package org.hunter;

class dividearrayintoarrayswithmaxdifference {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int [][] ans = new int[nums.length / 3][3];
        int index = 0;
        for(int i  = 0; i < nums.length; ++i){
            if(i > 0 && (i + 1) % 3 == 0){
                if(valid(nums, i, k)){
                    ans[index][0] = nums[i - 2];
                    ans[index][1] = nums[i - 1];
                    ans[index][2] = nums[i];
                    ++index;
                }else{
                    return new int[0][];
                }
            }
        }
        return ans;
    }

    boolean valid(int [] nums, int i, int k){
        int first = nums[i - 2];
        int second = nums[i - 1];
        int third = nums[i];
        if(Math.abs(first - second) > k){
            return false;
        }
        if(Math.abs(first - third) > k){
            return false;
        }
        if(Math.abs(second - third) > k){
            return false;
        }
        return true;
    }

}
