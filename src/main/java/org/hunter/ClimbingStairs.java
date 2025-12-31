package org.hunter;

import java.util.Arrays;

public class ClimbingStairs {

    //recurrence relation
    //dp(s) = dp(s + 1) + dp(s + 2)
    public int climbStairs(int n) {
        int [] mem = new int[n + 1];
        Arrays.fill(mem, -1);
        return climbStairs(0, n, mem);
    }

    int climbStairs(int cur, int n, int [] mem) {
        if(cur == n) {
            return 1;
        }
        if(cur > n) {
            return 0;
        }
         if(mem[cur] != -1) {
             return mem[cur];
         }
        int ans = climbStairs(cur + 1, n, mem) + climbStairs(cur + 2, n, mem);
        mem[cur] = ans;
        return ans;
    }

}
