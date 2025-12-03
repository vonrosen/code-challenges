package org.hunter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombosOfPhoneNumber {

    public List<String> letterCombinations(String digits) {
        Map<Integer,List<String>> map = new HashMap<>();
        map.put(2, List.of("a", "b", "c"));
        map.put(3, List.of("d", "e", "f"));
        map.put(4, List.of("g", "h", "i"));
        map.put(5, List.of("j", "k", "l"));
        map.put(6, List.of("m", "n", "o"));
        map.put(7, List.of("p", "q", "r", "s"));
        map.put(8, List.of("t", "u", "v"));
        map.put(9, List.of("w", "x", "y", "z"));

        List<String> ans = new ArrayList<>();
        letterCombinations(digits, 0, map, ans, new StringBuilder());
        return ans;
    }

    public void letterCombinations(String digits, int index, Map<Integer,List<String>> map, List<String> ans, StringBuilder combo) {
        if(index > digits.length() - 1) {
            ans.add(combo.toString());
            return;
        }
        for(String digit: map.get(Integer.parseInt(String.valueOf(digits.charAt(index))))) {
            combo.append(digit);
            letterCombinations(digits, index + 1, map, ans, combo);
            combo.delete(combo.length() - 1, combo.length());
        }
    }
}
