package org.hunter;

import java.util.*;

class reorganizestring {
    public String reorganizeString(String s) {
        Map<Character,List<Character>> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(c);
        }
        PriorityQueue<List<Character>> q = new PriorityQueue<>((l1, l2) -> {
            if(l1.size() > l2.size()){
                return -1;
            }
            if(l1.size() < l2.size()){
                return 1;
            }
            if(l1.isEmpty() && l2.isEmpty()){
                return 0;
            }
            return l1.get(0) - l2.get(0);
        });
        for(char c : map.keySet()){
            q.add(map.get(c));
        }
        StringBuilder sb = new StringBuilder();
        while(sb.length() < s.length()){
            List<Character> list1 = q.poll();
            if(!list1.isEmpty()){
                sb.append(list1.remove(0));
                if(sb.length() > 1 && sb.charAt(sb.length() - 1) == sb.charAt(sb.length() - 2)){
                        return "";
                }
            }
            if(!q.isEmpty()){
                List<Character> list2 = q.poll();
                if(!list2.isEmpty()){
                    sb.append(list2.remove(0));
                    if(sb.length() > 1 && sb.charAt(sb.length() - 1) == sb.charAt(sb.length() - 2)){
                            return "";
                    }
                }
                q.add(list2);
            }
            q.add(list1);
        }
        return sb.toString();        
    }

}
