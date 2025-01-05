package org.hunter;

class coinchange {
    public int coinChange(int[] coins, int amount) {
        Integer [] mem = new Integer[amount + 1];
        return coinChange(coins, 0, amount, mem);        
    }

    int coinChange(int [] coins, long curAmount, long amount, Integer[] mem){
        if(curAmount == amount){
            return 0;
        }
        if(curAmount > amount){
            return -1;
        }
        if(mem[(int)curAmount] != null){
            return mem[(int)curAmount];
        }
        int ans = 0;
        for(int i = 0; i < coins.length; ++i){
            int tmp = coinChange(coins, curAmount + coins[i], amount, mem);
            if(tmp != -1){
                if(ans == 0){
                    ans = 1 + tmp;
                }else{
                    ans = Math.min(ans, 1 + tmp);
                }                
            }
        }
        if(ans == 0){
            ans = -1;
        }
        mem[(int)curAmount] = ans;
        return ans;
    }
}
