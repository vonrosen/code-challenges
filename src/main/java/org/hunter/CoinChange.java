package org.hunter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/coin-change/
public class CoinChange{

	public static void main(String [] args){
		CoinChange coinChange = new CoinChange();
		int [] coins = new int[]{1,2,5};
		int amount = 11;
		System.out.println(coinChange.coinChangeMem(coins, amount));
		coins = new int[]{2};
		amount = 3;
		System.out.println(coinChange.coinChangeMem(coins, amount));
		coins = new int[]{1};
		amount = 0;
		System.out.println(coinChange.coinChangeMem(coins, amount));
		coins = new int[]{1,2147483647};
		amount = 2;
		System.out.println(coinChange.coinChangeMem(coins, amount));
		coins = new int[]{1,2,5};
		amount = 100;
		System.out.println(coinChange.coinChangeMem(coins, amount));
		coins = new int[]{1,2,5,10};
		amount = 27;
		//expected =4
		System.out.println(coinChange.coinChangeMem(coins, amount));
		coins = new int[]{5,306,188,467,494};
		amount = 7047;
		System.out.println(coinChange.coinChangeMem(coins, amount));
		coins = new int[]{357,239,73,52};
		amount = 9832;
		System.out.println(coinChange.coinChangeMem(coins, amount));
	}

	//time complexity O(amount * coins.length)
	//space complexity O(amount)
	public int coinChangeMem(int[] coins, int amount) {
		if(amount == 0){
			return 0;
		}
		int [] mem = new int[amount + 1];
		Arrays.fill(mem, -1);
		for(int i = 0; i < mem.length; ++i){
			for(int j = 0; j < coins.length; ++j){
				if(i == 0){
					if(coins[j] < mem.length){
						mem[coins[j]] = 1;
					}
				}else{
					if(mem[i] > -1){
						long longNewIndex = (long)i + (long)coins[j];
						if(longNewIndex < mem.length){
							if(mem[(int)longNewIndex] > -1 && mem[(int)longNewIndex] > mem[i] + 1){
								mem[(int)longNewIndex] = mem[i] + 1;
							}else if (mem[(int)longNewIndex] == -1){
								mem[(int)longNewIndex] = mem[i] + 1;
							}
						}
					}
				}
			}
		}

		return mem[amount];
	}

	//time complexity O(coins.length ^ amount) exponential
	public int coinChange(int[] coins, int amount) {
		if(amount == 0){
			return 0;
		}
		List<Long> counts = new ArrayList<>();
		for(int i = 0; i < coins.length; ++i){
			coinChange(coins, 1, coins[i], amount, counts);
		}
		if(counts.size() == 0){
			return -1;
		}
		Collections.sort(counts);
		return counts.get(0).intValue();
	}

	private void coinChange(int [] coins, long currentCount, long currentAmount, long amount,
			List<Long> counts){
		if(currentAmount == amount){
			counts.add(currentCount);
		}
		if(currentAmount > amount){
			return;
		}
		for(int i = 0; i < coins.length; ++i){
			coinChange(coins, currentCount + 1, currentAmount + coins[i], amount, counts);
		}
	}

}
