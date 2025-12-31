package org.hunter;

import java.util.Arrays;

public class HowManyApplesInBasket {

    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int limit = 5000;
        int ans = 0;
        for(int i = 0; i < weight.length; ++i) {
            if(weight[i] <= limit) {
                ans++;
                limit -= weight[i];
            }
        }
        return ans;
    }

}
