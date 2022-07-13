package org.hunter;

public class AwareOfSecret{

	/**
	 * https://leetcode.com/problems/number-of-people-aware-of-a-secret
	 * @param n
	 * @param delay
	 * @param forget
	 * @return
	 */
	public int peopleAwareOfSecret(int n, int delay, int forget) {
		long mod = 1000000007;
		long [] memAdded = new long[n + 1];
		for(int i = 1; i <= n; ++i){
			if(i == 1){
				memAdded[i] = 1;
			}else{
				for(int k = 1; k <= i; ++k){
					if(k - forget >= 1){
						memAdded[k - forget] = 0;
					}
				}
				long count = 0;
				for(int k = 1; k <= i; ++k){
					if(k - (delay + 1) >= 0){
						count += (memAdded[k - delay] % mod);
					}
				}
				memAdded[i] = count;
			}
		}
		long count = 0;
		for(int i = 1; i <=n; ++i){
			count += memAdded[i] % mod;
		}

		return (int)(count % mod);
	}

	public static void main(String [] args){
		int n = 6;
		int delay = 2;
		int forget = 4;
		AwareOfSecret awareOfSecret = new AwareOfSecret();
		System.out.println(awareOfSecret.peopleAwareOfSecret(n, delay, forget));

		n = 4;
		delay = 1;
		forget = 3;
		System.out.println(awareOfSecret.peopleAwareOfSecret(n, delay, forget));

		n = 6;
		delay = 1;
		forget = 2;
		System.out.println(awareOfSecret.peopleAwareOfSecret(n, delay, forget));

		n = 684;
		delay = 18;
		forget = 496;
		System.out.println(awareOfSecret.peopleAwareOfSecret(n, delay, forget));
	}

}
