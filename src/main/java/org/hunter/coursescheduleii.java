package org.hunter;

import java.util.*;

class coursescheduleii {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int [] preq : prerequisites){
            graph.putIfAbsent(preq[1], new ArrayList<>());
            graph.get(preq[1]).add(preq[0]);
        }
        Stack<Integer> ans = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i < numCourses; ++i){
            if(!dfs(graph, i, ans, new HashSet<>(), visited)){
                return new int[0];
            };
        }
        int [] ansint = new int[ans.size()];
        int i = 0;
        while(!ans.isEmpty()){
            ansint[i++] = ans.pop();
        }
        return ansint;       
    }

    boolean dfs(Map<Integer,List<Integer>> graph, int course, Stack<Integer> ans, Set<Integer> visited, Set<Integer> globalVisited){
        if(visited.contains(course)){
            return false;
        }
        if(globalVisited.contains(course)){
            return true;
        }
        visited.add(course);
        globalVisited.add(course);
        for(int preq : graph.getOrDefault(course, List.of())){
            if(!dfs(graph, preq, ans, visited, globalVisited)){
                return false;
            }
        }
        visited.remove(course);
        ans.add(course);
        return true;
    }
}
