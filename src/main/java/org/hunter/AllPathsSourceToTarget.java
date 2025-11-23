package org.hunter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPathsSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer,List<Integer>> adjList = new HashMap<>();
        for(int i = 0; i < graph.length; ++i) {
            adjList.putIfAbsent(i, new ArrayList<>());
            for(int j = 0; j < graph[i].length; ++j) {
                adjList.get(i).add(graph[i][j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        boolean [] seen = new boolean[graph.length];
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(adjList, 0, ans, path, seen);
        return ans;
    }

    void dfs(Map<Integer,List<Integer>> graph, int node, List<List<Integer>> ans, List<Integer> path, boolean [] seen) {
        if(seen[node]) {
            return;
        }
        if(node == graph.size() - 1) {
            ans.add(new ArrayList<>(path));
            return;
        }
        seen[node] = true;
        for(int n : graph.get(node)) {
            path.add(n);
            dfs(graph, n, ans, path, seen);
            path.remove(path.size() - 1);
        }
        seen[node] = false;
    }

}
