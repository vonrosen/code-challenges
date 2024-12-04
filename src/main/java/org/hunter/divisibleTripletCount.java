package org.hunter;

class divisibleTripletCount {
    public int divisibleTripletCount(int[] nums, int d) {
        int [] remainders = new int[d];
        int ans = 0;
        for(int i = 2; i < nums.length; ++i){
            int rem = nums[i] % d;
            for(int j = i - 2; j >= 0; --j){
                int sum = nums[i - 1] + nums[j];
                int rem2 = sum % d;
                remainders[rem2]++;
            }
            ans += rem == 0 ? remainders[0] : remainders[d - rem];
        }
        return ans;
    }
}
