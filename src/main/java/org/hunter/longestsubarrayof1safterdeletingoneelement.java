class longestsubarrayof1safterdeletingoneelement {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int ans = 0;
        int countZero = 0;
        for(int right = 0; right < nums.length; ++right){
            int num = nums[right];
            if(num == 0){
                countZero++;
            }
            while(countZero > 1){
                if(nums[left++] == 0){
                    countZero--;
                }
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}
