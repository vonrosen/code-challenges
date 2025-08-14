package org.hunter;

public class JPMorganTradeChallenge {
    public static void main(String [] args) {
        int [] nums = new int[] {778,1,4,6663,22,222,123,33};
        JPMorganTradeChallenge obj = new JPMorganTradeChallenge();
        System.out.println(obj.maxProfit(nums));
    }

    public int maxProfit(int [] nums){
        int min = nums[0];
        int max = 0;
        for (int i = 0; i < nums.length; ++i){
            max = Math.max(max, Math.max(0, nums[i] - min));
            min = Math.min(min, nums[i]);
        }
        return max;
    }

}
