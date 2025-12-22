package org.hunter;

public class NumberOfIslands2 {

    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[i].length; ++j) {
                ans += dfs(i, j, grid);
            }
        }
        return ans;
    }

    int [][] dirs = new int [][] {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    int dfs(int row, int col, char [][] grid) {
        if(!valid(row, col, grid)) {
            return 0;
        }
        grid[row][col] = '0';
        for(int [] dir : dirs) {
            int newRow = row + dir[0], newCol = col + dir[1];
            dfs(newRow, newCol, grid);
        }
        return 1;
    }

    boolean valid(int row, int col, char [][] grid) {
        if(row < 0 || row > grid.length - 1) {
            return false;
        }
        if(col < 0 || col > grid[0].length - 1) {
            return false;
        }
        if(grid[row][col] == '0') {
            return false;
        }
        return true;
    }

}
