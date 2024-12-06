package org.hunter;

import java.util.*;

class coursescheduleii {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int [] preq : prerequisites){
            graph.putIfAbsent(preq[0], new ArrayList<>());
            graph.get(preq[0]).add(preq[1]);
        }
        Map<Integer,List<Integer>> ans = new HashMap<>();
        for(int i = 0; i < numCourses; ++i){
            if(!dfs(graph, i, 0, ans, new HashSet<>())){
                return new int[0];
            };
        }
        Set<Integer> added = new HashSet<>();
        int size = ans.size();
        List<Integer> ans2 = new ArrayList<>();
        for(int i = size - 1; i >= 0; --i){
            for(int course: ans.get(i)){
                if(!added.contains(course)){
                    ans2.add(course);
                }
                added.add(course);
            }
        }
        int [] intans = new int[ans2.size()];
        for(int i = 0; i < intans.length; ++i){
            intans[i] = ans2.get(i);
        }
        return intans;
    }

    boolean dfs(Map<Integer,List<Integer>> graph, int course, int index, Map<Integer,List<Integer>> ans, Set<Integer> visited){
        if(visited.contains(course)){
            return false;
        }
        visited.add(course);
        ans.putIfAbsent(index, new ArrayList<>());            
        ans.get(index).add(course);
        for(int preq : graph.getOrDefault(course, List.of())){
            if(!dfs(graph, preq, index + 1, ans, visited)){
                return false;
            }
        }
        visited.remove(course);
        return true;
    }
}
