package org.hunter;

public class MaximumGold {

    public int getMaximumGold(int[][] grid) {
        boolean [][] seen = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[0].length; ++j) {
                ans = Math.max(ans, dfs(grid, i, j, seen));
            }
        }
        return ans;
    }

    int [][] dirs = new int[][] {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1},
    };

    int dfs(int [][] grid, int row, int col, boolean [][] seen) {
        if(!valid(grid, row, col, seen)) {
            return 0;
        }
        seen[row][col] = true;
        int ans = grid[row][col];
        for(int [] dir : dirs) {
            int newRow = row + dir[0], newCol = col + dir[1];
            int amount = grid[row][col] + dfs(grid, newRow, newCol, seen);
            ans = Math.max(ans, amount);
        }
        seen[row][col] = false;
        return ans;
    }

    boolean valid(int [][] grid, int row, int col, boolean [][] seen) {
        if(row < 0 || row > grid.length - 1) {
            return false;
        }
        if(col < 0 || col > grid[0].length - 1) {
            return false;
        }
        if(seen[row][col]) {
            return false;
        }
        if(grid[row][col] == 0) {
            return false;
        }
        return true;
    }

}
