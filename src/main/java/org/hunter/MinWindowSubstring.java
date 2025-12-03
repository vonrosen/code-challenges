package org.hunter;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

    public static void main(String [] args) {
        MinWindowSubstring minWindowSubstring = new MinWindowSubstring();
        System.out.println(minWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {
        Map<Character,Integer> counts = new HashMap<>();
        for(char c : t.toCharArray()) {
            counts.putIfAbsent(c, 0);
            counts.put(c, counts.get(c) + 1);
        }
        StringBuilder ans = new StringBuilder();
        Map<Character,Integer> curCounts = new HashMap<>();
        int count = 0;
        int left = 0;
        for(int right = 0; right < s.length(); ++right) {
            char c = s.charAt(right);
            if(counts.containsKey(c)) {
                curCounts.putIfAbsent(c, 0);
                curCounts.put(c, curCounts.get(c) + 1);
                if(counts.get(c).equals(curCounts.get(c))) {
                    ++count;
                }
            }
            while(count == counts.size()) {
                String possible = s.substring(left, right + 1);
                if(ans.isEmpty() || possible.length() < ans.length()) {
                    ans = new StringBuilder(possible);
                }
                char n = s.charAt(left);
                if(counts.containsKey(n)) {
                    curCounts.put(n, curCounts.get(n) - 1);
                    if(curCounts.get(n) < counts.get(n)) {
                        count--;
                    }
                }
                ++left;
            }
        }
        return ans.toString();
    }

}
