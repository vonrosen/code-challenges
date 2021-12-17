package org.hunter;

public class FibSeq{

	/**
	 * Ex: Given 1, return 0
	 *     Given 3, return 2 (0 + 1 + 1)
	 *     Given 5, return 7 (0 + 1 + 1 + 2 + 3)
	 * @param args
	 */
	public static void main(String [] args){
		System.out.println(fibSum(1));
		System.out.println(fibSum(3));
		System.out.println(fibSum(5));
		System.out.println(fibSumMem(1));
		System.out.println(fibSumMem(3));
		System.out.println(fibSumMem(5));
		System.out.println(fibSumMem(6));
	}

	//time=O(N*2^N) space=O(1)
	public static int fibSum(int index){
		int sum = 0;
		for (int i = 0; i < index; ++i){
			sum += fib(i);
		}
		return sum;
	}

	//time=O(N^2) space=O(N)
	public static int fibSumMem(int index){
		int sum = 0;
		for (int i = 0; i < index; ++i){
			sum += fibMem(i);
		}
		return sum;
	}

	public static int fib(int index){
		if(index == 0){
			return 0;
		}
		if(index == 1){
			return 1;
		}
		return fib(index - 1) + fib(index - 2);
	}

	public static int fibMem(int index){
		if(index == 0){
			return 0;
		}
		int [] mem = new int[index + 1];
		mem[0] = 0;
		mem[1] = 1;
		for(int i = 2; i <= index; ++i){
			mem[i] = mem[i - 1] + mem[i - 2];
		}
		return mem[index];
	}

}
