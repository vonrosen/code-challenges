package org.hunter;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0;
        int left = 0;
        for(int right = 0; right < s.length(); ++right) {
            char c = s.charAt(right);
            while(!set.add(c)) {
                set.remove(s.charAt(left));
                ++left;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
