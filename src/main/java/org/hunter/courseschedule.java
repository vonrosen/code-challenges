package org.hunter;

import java.util.*;

class courseschedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int [] preq : prerequisites){
            graph.putIfAbsent(preq[0], new ArrayList<>());
            graph.get(preq[0]).add(preq[1]);
        }
        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i < numCourses; ++i){
            if(!dfs(graph, i, new HashSet<>(), visited)){
                return false;
            }
        }
        return true;
    }

    boolean dfs(Map<Integer,List<Integer>> graph, int course, Set<Integer> visited, Set<Integer> globalVisited){
        if(visited.contains(course)){
            return false;
        }
        if(globalVisited.contains(course)){
            return true;
        }        
        globalVisited.add(course);
        visited.add(course);
        for(int p : graph.getOrDefault(course, List.of())){
            if(!dfs(graph, p, visited, globalVisited)){
                return false;
            }
        }
        visited.remove(course);
        return true;
    }
}
