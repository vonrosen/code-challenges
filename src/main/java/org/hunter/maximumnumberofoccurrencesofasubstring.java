package org.hunter;

import java.util.*;

class maximumnumberofoccurrencesofasubstring {

    public static void main(String [] args){
        maximumnumberofoccurrencesofasubstring s = new maximumnumberofoccurrencesofasubstring();
        System.out.println(s.maxFreq("aabcabcab", 2, 2, 3));
    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int left = 0;
        Map<Character,Integer> letters = new HashMap<>();
        Map<String,Integer> answers = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int right = 0; right < s.length(); ++right){
            char c = s.charAt(right);
            letters.putIfAbsent(c, 0);
            letters.put(c, letters.get(c) + 1);
            sb.append(c);
            //we don't need maxSize at all!
            while(letters.size() > maxLetters){
                char lChar = s.charAt(left);
                letters.put(lChar, letters.get(lChar) - 1);
                if(letters.get(lChar) <= 0){
                    letters.remove(lChar);
                }
                sb.delete(0, 1);
                left++;
            }
            if(letters.size() <= maxLetters && sb.length() == minSize){
                answers.putIfAbsent(sb.toString(), 0);
                answers.put(sb.toString(), answers.get(sb.toString()) + 1);
                char lChar = s.charAt(left);
                letters.put(lChar, letters.get(lChar) - 1);
                if(letters.get(lChar) <= 0){
                    letters.remove(lChar);
                }
                sb.delete(0, 1);
                left++;
            }
        }
        if(answers.isEmpty()){
            return 0;
        }
        List<Integer> list = new ArrayList<>(answers.values());
        Collections.sort(list, Collections.reverseOrder());
        return list.get(0);
    }
}
