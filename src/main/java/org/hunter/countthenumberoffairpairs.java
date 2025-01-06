package org.hunter;

class countthenumberoffairpairs {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        for(int i = 0; i < nums.length; ++i){
            int num = nums[i];
            int low = getBound(nums, i + 1, nums.length - 1, lower - num);
            int high = getBound(nums, i + 1, nums.length - 1, upper - num + 1);
            ans += high - low;
        }
        return ans;        
    }

    int getBound(int [] nums, int low, int high, int value){
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] < value){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
}
