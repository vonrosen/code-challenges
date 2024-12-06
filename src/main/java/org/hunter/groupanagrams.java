package org.hunter;

import java.util.*;

class groupanagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            char [] c = s.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
