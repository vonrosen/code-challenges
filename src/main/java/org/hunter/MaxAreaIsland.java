package org.hunter;

public class MaxAreaIsland {

    int [][] dirs = new int[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    public int maxAreaOfIsland(int[][] grid) {
        boolean [][] seen = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[0].length; ++j) {
                ans = Math.max(dfs(i, j, grid, seen), ans);
            }
        }
        return ans;
    }

    int dfs(int i, int j, int[][] grid, boolean [][] seen) {
        if(!valid(i, j, grid, seen)){
            return 0;
        }
        int ans = 1;
        seen[i][j] = true;
        for(int [] dir: dirs) {
            int newi = i + dir[0], newj = j + dir[1];
            ans += dfs(newi, newj, grid, seen);
        }
        return ans;
    }

    boolean valid(int i, int j, int [][] grid, boolean [][] seen){
        if(i < 0 || i > grid.length - 1){
            return false;
        }
        if(j < 0 || j > grid[0].length - 1) {
            return false;
        }
        if(seen[i][j]) {
            return false;
        }
        if(grid[i][j] == 0) {
            return false;
        }
        return true;
    }

}
