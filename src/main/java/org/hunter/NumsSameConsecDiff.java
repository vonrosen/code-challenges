package org.hunter;

import java.util.ArrayList;
import java.util.List;

public class NumsSameConsecDiff {

    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        getCombos(n, k, ans, sb);
        int [] ansInt = new int[ans.size()];
        for(int i = 0; i < ans.size(); ++i) {
            ansInt[i] = ans.get(i);
        }
        return ansInt;
    }

    void getCombos(int n, int k, List<Integer> ans, StringBuilder sb) {
        if(sb.length() == n) {
            ans.add(Integer.parseInt(sb.toString()));
            return;
        }
        for(int i = 0; i <= 9; ++i) {
            if(!sb.isEmpty()) {
                int lastDigit = Integer.parseInt(String.valueOf(sb.charAt(sb.length() - 1)));
                if(Math.abs(lastDigit - i) == k) {
                    sb.append(i);
                    getCombos(n, k, ans, sb);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }else {
                if(i > 0) {
                    sb.append(i);
                    getCombos(n, k, ans, sb);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }

}
