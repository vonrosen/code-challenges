package org.hunter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberProvinces {

    public int findCircleNum(int[][] isConnected) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < isConnected.length; ++i) {
            for(int j = i; j < isConnected[0].length; ++j) {
                if(isConnected[i][j] == 1) {
                    adj.putIfAbsent(i, new ArrayList<>());
                    adj.putIfAbsent(j, new ArrayList<>());
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int ans = 0;
        boolean [] seen = new boolean[isConnected.length];
        for(int i = 0; i < isConnected.length; ++i) {
            if(!seen[i]) {
                dfs(adj, i, seen);
                ++ans;
            }
        }
        return ans;
    }

    void dfs(Map<Integer,List<Integer>> adj, int i, boolean[] seen) {
        if(seen[i]){
            return;
        }
        seen[i] = true;
        for(int node : adj.get(i)) {
            dfs(adj, node, seen);
        }
    }
}
