package org.hunter;

public class SingleNumber {

    public static void main(String [] args) {
        SingleNumber s = new SingleNumber();
        System.out.println(s.singleNumber(new int[] {2,2,1}));
        System.out.println(s.singleNumber(new int[] {4,1,2,1,2}));
        System.out.println(s.singleNumber(new int[] {1}));
        System.out.println(s.singleNumber(new int[] {1,0,1}));
        System.out.println(s.singleNumber(new int[] {1,2,3,4,5,1,2,3,4}));
        System.out.println(s.singleNumber(new int[] {1,3,1,-1,3}));
    }

    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            ans ^= nums[i];
        }
        return ans;
    }
}
