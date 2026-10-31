package org.hunter;

import java.util.StringTokenizer;

public class GoatLatin {

    public String toGoatLatin(String sentence) {
        StringTokenizer st = new StringTokenizer(sentence);
        StringBuilder ans = new StringBuilder();
        int index = 1;
        while (st.hasMoreTokens()) {
            StringBuilder word = new StringBuilder(st.nextToken());
            if (isVowel(word.charAt(0))) {
                word.append("ma");
            }else {
                word.append(word.charAt(0));
                word.deleteCharAt(0);
                word.append("ma");
            }
            word.append(String.valueOf('a').repeat(index));
            ans.append(word);
            if (st.hasMoreTokens()) {
                ans.append(" ");
            }
            index++;
        }
        return ans.toString();
    }

    private boolean isVowel(char c) {
        boolean isVowel =  c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        if (isVowel) {
            return isVowel;
        }
        return  c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

}
