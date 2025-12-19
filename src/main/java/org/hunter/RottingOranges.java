package org.hunter;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    /**
     * 0 = empty
     * 1 = fresh
     * 2 = rotten
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        int time = bfs(grid);
        for(int row = 0; row < grid.length; ++row) {
            for(int col = 0; col < grid[0].length; ++col) {
                if(grid[row][col] == 1) {
                    return -1;
                }
            }
        }
        return time;
    }

    int [][] dirs = new int [][]{
            {-1, 0},
            {0, -1},
            {1, 0},
            {0, 1}
    };

    record State(
            int row,
            int col,
            int time
    ){}

    int bfs(int [][] grid) {
        Queue<State> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[0].length; ++j) {
                if(grid[i][j] == 2) {
                    queue.add(new State(i, j, 0));
                }
            }
        }
        int time = 0;
        while(!queue.isEmpty()) {
            State state = queue.poll();
            int row = state.row, col = state.col;
            time = state.time;
            for(int [] dir : dirs) {
                int newRow = row + dir[0], newCol = col + dir[1];
                if(valid(newRow, newCol, grid)) {
                    grid[newRow][newCol] = 2;
                    queue.add(new State(newRow, newCol, time + 1));
                }
            }
        }
        return time;
    }

    boolean valid(int row, int col, int [][] grid) {
        if(row < 0 || row > grid.length - 1) {
            return false;
        }
        if(col < 0 || col > grid[0].length - 1) {
            return false;
        }
        if(grid[row][col] != 1) {
            return false;
        }
        return true;
    }

}
