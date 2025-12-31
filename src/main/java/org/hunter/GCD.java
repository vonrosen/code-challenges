package org.hunter;

public class GCD {

    public static void main(String [] args) {
        GCD gcd = new GCD();
        System.out.println(gcd.gcd(10, 2)); //2
        System.out.println(gcd.gcd(15, 25)); //5
        System.out.println(gcd.gcd(12, 99)); //3
        System.out.println(gcd.gcd(0, 99)); //99
    }

    int gcd(int a, int b) {
        int high = Math.max(a, b);
        int low = Math.min(a, b);
        if (low == 0) {
            return high;
        }
        int mod = high % low;
        if(mod == 0) {
            return low;
        }
        return gcd(mod, low);
    }

    public int findGCD(int[] nums) {
        int low = Integer.MAX_VALUE, high = 0;
        for(int num: nums) {
            low = Math.min(low, num);
            high = Math.max(high, num);
        }
        return gcd(low, high);
    }

    public int minOperations(int[] nums) {
        int numOnes = 0;
        int gcd = 0;
        for (int num : nums) {
            if(num == 1) {
                numOnes++;
            }
            gcd = gcd(0, num);
        }
        if(numOnes > 1) {
            return nums.length - numOnes;
        }
        if(gcd > 1) {
            return -1;
        }
        int minLength = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 1; ++i) {
            for (int j = i; j < nums.length; ++j) {
                gcd = gcd(nums[i], nums[j]);
                if(gcd == 1) {
                    minLength = Math.min(minLength, j - i + 1);
                }
            }
        }
        return minLength - 1 + (nums.length - 1);
    }

}
