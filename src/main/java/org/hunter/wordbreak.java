package org.hunter;

import java.util.*;

class wordbreak {
    public boolean wordBreak(String s, List<String> wordDict){ 
        Map<String,Boolean> map = new HashMap<>();
        return wordBreak2(s, wordDict, map);
    }

    boolean wordBreak2(String s, List<String> wordDict, Map<String,Boolean> map){
        if(map.containsKey(s)){
            return map.get(s);
        }
        boolean ans = false;
        for(int i = 0; i < wordDict.size(); ++i){
            String word = wordDict.get(i);
            if(s.equals(word)){
                ans = true;
                break;
            }  
            if(s.startsWith(word)){
                ans = wordBreak2(s.substring(word.length()), wordDict, map);
            }
            if(ans){
                break;
            }
        }
        map.put(s, ans);       
        return ans;
    }
}
