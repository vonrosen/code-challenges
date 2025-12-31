package org.hunter;

public class Palindrome {

    public static void main(String [] args) {
        Palindrome p = new Palindrome();
        System.out.println(p.isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome2(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c) || Character.isDigit(c)){
                sb.append(c);
            }
        }
        String orig = sb.toString();
        return orig.contentEquals(sb.reverse());
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char leftc = Character.toLowerCase(s.charAt(left));
            char rightc = Character.toLowerCase(s.charAt(right));
            if(!Character.isAlphabetic(leftc) && !Character.isDigit(leftc)) {
                ++left;
                continue;
            }
            if(!Character.isAlphabetic(rightc) && !Character.isDigit(rightc)) {
                --right;
                continue;
            }
            if(leftc != rightc) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

}
