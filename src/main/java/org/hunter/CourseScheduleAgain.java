package org.hunter;

import java.util.*;

public class CourseScheduleAgain {

    /**
     * 2 -> 4, 4 -> 1
     * @param args
     * n = numCourses, m = prereqs
     * n * (n + m) = n^2 + n*m
     */
    public static void main(String [] args) {
        CourseScheduleAgain courseScheduleAgain = new CourseScheduleAgain();
        System.out.println(courseScheduleAgain.canFinish(5, new int [][]{{1,4},{2,4},{3,1},{3,2}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < numCourses; ++i) {
            graph.putIfAbsent(i, new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; ++i) {
            int to = prerequisites[i][0];
            int from = prerequisites[i][1];
            graph.get(from).add(to);
        }
        Set<Integer> seen = new HashSet<>();
        for(int i = 0; i < numCourses; ++i) {
            if(!dfs(graph, i, seen, new HashSet<>())) {
                return false;
            }
        }
        return true;
    }

    boolean dfs(Map<Integer,List<Integer>> graph, int course, Set<Integer> seen, Set<Integer> path) {
        if(path.contains(course)) {
            return false;
        }
        if(seen.contains(course)){
            return true;
        }
        seen.add(course);
        path.add(course);
        for(int c: graph.get(course)) {
            if(!dfs(graph, c, seen, path)){
                return false;
            }
        }
        path.remove(course);
        return true;
    }
}
