package org.hunter;

import java.util.*;

class exclusivetimeoffunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> levelMap = new HashMap<>();
        Stack<String> stack = new Stack<>();
        int level = 0;

        for(String log : logs){
            if(log.contains("start")){                
                stack.push(log);
                ++level;
            }else{
                String[] arrStart = stack.pop().split(":");
                String[] arrEnd = log.split(":");
                int fid = Integer.parseInt(arrStart[0]);
                int start = Integer.parseInt(arrStart[2]);
                int end = Integer.parseInt(arrEnd[2]);
                int dur = (end - start + 1) - (levelMap.getOrDefault(level + 1, 0));
                map.putIfAbsent(fid, 0);
                map.put(fid, map.get(fid) + dur);
                int lastDur = levelMap.getOrDefault(level + 1, 0);
                levelMap.remove(level + 1);
                levelMap.putIfAbsent(level, 0);
                levelMap.put(level, levelMap.get(level) + dur + lastDur);
                --level;
            }
        }
        int [] ans = new int[map.size()];
        for(int i = 0; i < map.size(); ++i){
            ans[i] = map.get(i);
        }
        return ans;
    }
}
