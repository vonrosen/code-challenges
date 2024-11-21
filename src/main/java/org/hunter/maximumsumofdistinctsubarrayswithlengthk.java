class maximumsumofdistinctsubarrayswithlengthk {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;
        int left = 0;
        long ans = 0;
        Map<Long,Integer> map = new HashMap<>();
        for(int right = 0; right < nums.length; ++right){
            long num = nums[right];
            sum += num;
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
            while((right - left + 1) > k){
                long numLeft = nums[left];
                sum -= numLeft;
                map.put(numLeft, map.get(numLeft) - 1);
                if(map.get(numLeft) <= 0){
                    map.remove(numLeft);
                }
                left++;
            }            
            if((right - left + 1) == k){
                if(map.size() == k){
                    ans = Math.max(ans, sum);
                }                
            }
        }
        return ans;
    }
}
