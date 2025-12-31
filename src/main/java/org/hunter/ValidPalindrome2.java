package org.hunter;

import java.util.HashMap;
import java.util.Map;

public class ValidPalindrome2 {

    public static void main(String [] args) {
        String s = "eceec";
        ValidPalindrome2 validPalindrome2 = new ValidPalindrome2();
        System.out.println(validPalindrome2.validPalindrome(s));
    }

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right)) {
                return isValid(s, left + 1, right)
                        || isValid(s, left, right - 1);
            }
            ++left;
            --right;
        }
        return true;
    }

    boolean isValid(String s, int start, int end) {
        String subString = s.substring(start, end + 1);
        int left = 0;
        int right = subString.length() - 1;
        while (left <= right) {
            if(subString.charAt(left) != subString.charAt(right)) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }


    public boolean validPalindrome5(String s) {
        int left = 0;
        int right = s.length() - 1;
        int diffs = 0;
        while(left <= right) {
            if(s.charAt(left) == s.charAt(right)) {
                ++left;
                --right;
            }else{
                if(left == right) {
                    diffs++;
                    left++;
                    right--;
                }else if (s.charAt(right - 1) == s.charAt(left)) {
                    diffs++;
                    right--;
                }else if (s.charAt(left + 1) == s.charAt(right)) {
                    diffs++;
                    left++;
                }else {
                    ++left;
                    --right;
                    diffs += 2;
                }
            }
        }
        return diffs < 2;
    }


    //O(n^2) = TLE
    public boolean validPalindrome3(String s) {
        StringBuilder sb = new StringBuilder(s);
        if(isValid(s)) {
            return true;
        }
        for(int i = 0; i < s.length(); ++i) {
            sb.delete(i, i + 1);
            if(isValid(sb.toString())) {
                return true;
            }
            sb.insert(i, s.charAt(i));
        }
        return false;
    }

    boolean isValid(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

    //O(s.length * s.length) = 100_000 * 100_000 = TLE
    public boolean validPalindrome2(String s) {
        Map<String,Integer> mem = new HashMap<>();
        int diffs = valid(0, s.length() - 1, s, mem);
        return diffs < 2;
    }

    int valid(int start, int end, String s, Map<String,Integer> mem) {
        if(start > end) {
            return 0;
        }
        if(mem.containsKey(start + "-" + end)) {
            return mem.get(start + "-" + end);
        }
        int ans;
        if(s.charAt(start) == s.charAt(end)) {
            ans = valid(start + 1, end - 1, s, mem);
        }else {
            ans = Math.min(
                    1 + valid(start + 1, end, s, mem),
                    1 + valid(start, end - 1, s, mem)
            );
        }
        mem.put(start + "-" + end, ans);
        return ans;
    }
}
