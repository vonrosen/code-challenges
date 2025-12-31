package org.hunter;

import java.util.HashMap;
import java.util.Map;

public class FiboAgain {

    public static void main(String [] args) {
        FiboAgain fiboAgain = new FiboAgain();
        Map<Integer,Integer> mem = new HashMap<>();
        System.out.println(fiboAgain.fibo(0, mem));
        System.out.println(fiboAgain.fibo(1, mem));
        System.out.println(fiboAgain.fibo(2, mem));
        System.out.println(fiboAgain.fibo(3, mem));
        System.out.println(fiboAgain.fibo(4, mem));
        System.out.println(fiboAgain.fibo(5, mem));
    }

    public int fibo(int n, Map<Integer,Integer> mem) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if (mem.containsKey(n)) {
            return mem.get(n);
        }
        int ans =  fibo(n - 1, mem) + fibo(n - 2, mem);
        mem.put(n, ans);
        return ans;
    }

}
