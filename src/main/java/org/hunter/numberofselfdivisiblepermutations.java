package org.hunter;

import java.util.*;

class numberofselfdivisiblepermutations {
    public int selfDivisiblePermutationCount(int n) {
        List<List<Integer>> perms = new ArrayList<>();
        perms(n, perms, new ArrayList<>());        
        return perms.size();
    }

    boolean gcd(int num1, int num2){
        int max = Math.max(num1, num2);
        int min = Math.min(num1, num2);
        for(int i = 2; i <= min; ++i){
            if(max % i == 0 && min % i == 0){
                return false;
            }
        }
        return true;
    }

    //O(n! * n)
    void perms(int n, List<List<Integer>> perms, List<Integer> list){
        if(list.size() == n){            
            perms.add(new ArrayList<>(list));
            return;
        }
        for(int i = 1; i <= n; ++i){
            if(!list.contains(i)){
                list.add(i);
                if(gcd(i, list.size())){                    
                    perms(n, perms, list);
                }
                list.remove(list.size() - 1);
            }
        }
    }

}
