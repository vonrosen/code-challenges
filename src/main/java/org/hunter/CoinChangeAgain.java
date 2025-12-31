package org.hunter;

public class CoinChangeAgain {

    /**
     * recurrence relation
     * dp(amount) = min(dp(amount - coin)) for all coin in coins
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        Integer [] mem = new Integer[amount + 1];
        int ans = dp(coins, amount, mem);
        if(ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }

    int dp(int [] coins, int amount, Integer [] mem) {
        if(amount < 0) {
            return -1;
        }
        if(amount == 0) {
            return 0;
        }
        if(mem[amount] != null) {
            return mem[amount];
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; ++i) {
            int tmp = dp(coins, amount - coins[i], mem);
            if(tmp == -1) {
                continue;
            }
            ans = Math.min(ans, 1 + tmp);
        }
        if(ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        mem[amount] = ans;
        return ans;
    }

}
