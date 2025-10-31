package org.hunter;

public class Reverse {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i <= j) {
            char left = s[i];
            char right = s[j];
            s[i] = right;
            s[j] = left;
            i++;
            j--;
        }
    }
}
