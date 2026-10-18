package org.hunter;

import java.util.HashMap;
import java.util.Map;

public class MaxFruits {

    public static void main(String [] args) {
        MaxFruits fruits = new MaxFruits();
        System.out.println(fruits.totalFruit(new int [] {
                1,2,1
        }));
        System.out.println(fruits.totalFruit(new int [] {
                0,1,2,2
        }));
        System.out.println(fruits.totalFruit(new int [] {
                1,2,3,2,2
        }));
        System.out.println(fruits.totalFruit(new int [] {
                0,1,1,4,3
        }));
    }

    //[1,0,1,0,1,2,2,2,2,2,2]
    //[0,1,1,4,3] = 3
    public int totalFruit(int[] fruits) {
        int ans = 0;
        int picked = 0;
        int left = 0;
        Map<Integer,Integer> typesPicked = new HashMap<>();
        for (int right = 0; right < fruits.length; ++right) {
            int type = fruits[right];
            if (typesPicked.size() < 2) {
                picked++;
                typesPicked.putIfAbsent(type, 0);
                typesPicked.put(type, typesPicked.get(type) + 1);
            }else if (typesPicked.containsKey(type)) {
                typesPicked.put(type, typesPicked.get(type) + 1);
                picked++;
            }else {
                while(typesPicked.size() == 2) {
                    int leftType = fruits[left];
                    if (typesPicked.containsKey(leftType)) {
                        typesPicked.put(leftType, typesPicked.get(leftType) - 1);
                        --picked;
                        if (typesPicked.get(leftType) == 0) {
                            typesPicked.remove(leftType);
                        }
                    }
                    ++left;
                }
                typesPicked.putIfAbsent(type, 0);
                typesPicked.put(type, typesPicked.get(type) + 1);
                ++picked;
            }
            ans = Math.max(ans, picked);
        }
        return ans;
    }
}
