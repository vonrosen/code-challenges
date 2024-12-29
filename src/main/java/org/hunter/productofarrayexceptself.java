package org.hunter;

class productofarrayexceptself {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 1){
            return nums;
        }
        int sum = 0;
        int [] left = new int[nums.length];
        int [] right = new int[nums.length];
        left[0] = nums[0];
        right[nums.length - 1] = nums[nums.length - 1];
        for(int i = 1; i < nums.length; ++i){
            left[i] = left[i - 1] * nums[i];
        }
        for(int i = nums.length - 2; i >= 0; --i){
            right[i] = right[i + 1] * nums[i];
        }
        int [] ans = new int[nums.length];
        for(int i = 0; i < nums.length; ++i){
            if(i == 0){
                ans[i] = right[i + 1];
            }else if(i == nums.length - 1){
                ans[i] = left[i - 1];
            }else{
                ans[i] = left[i - 1] * right[i + 1];
            }
        }
        return ans;
    }
}
