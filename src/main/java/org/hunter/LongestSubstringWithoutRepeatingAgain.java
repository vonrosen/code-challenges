package org.hunter;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingAgain {

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        Set<Character> set = new HashSet<>();
        int ans = 0;
        for(int right = 0; right < s.length(); ++right) {
            char c = s.charAt(right);
            while(set.contains(c)) {
                set.remove(s.charAt(left));
                ++left;
            }
            set.add(c);
            ans = Math.max(ans, set.size());
        }
        return ans;
    }

}
