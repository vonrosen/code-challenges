package org.hunter;

import java.util.*;

public class CourseScheduleAgain2 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < prerequisites.length; ++i) {
            int to = prerequisites[i][0];
            int from = prerequisites[i][1];

            adj.putIfAbsent(to, new ArrayList<>());
            adj.get(to).add(from);
        }

        Set<Integer> seen = new HashSet<>();
        for(int i = 0; i < numCourses; ++i) {
            if(!dfs(i, adj, seen, new HashSet<>())) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int i, Map<Integer,List<Integer>> adj, Set<Integer> seen, Set<Integer> localSeen) {
        if (localSeen.contains(i)) {
            return false;
        }
        if (seen.contains(i)) {
            return true;
        }
        seen.add(i);
        localSeen.add(i);
        for(int n : adj.getOrDefault(i, List.of())) {
            if (!dfs(n, adj, seen, localSeen)) {
                return false;
            }
        }
        localSeen.remove(i);
        return true;
    }
}
