package org.hunter;

import java.util.*;

class rottingoranges {

    int [][] dirs = new int[][]{
        {-1, 0},
        {0, 1},
        {1, 0},
        {0, -1},
    };

    public int orangesRotting(int[][] grid) {
        Queue<int []> q = new LinkedList<>();
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        for(int row = 0; row < grid.length; ++row){
            for(int col = 0; col < grid[0].length; ++col){
                if(grid[row][col] == 2){
                    q.add(new int[]{ row, col});
                }
            }
        }
        int ans = bfs(grid, q, visited);
        for(int row = 0; row < grid.length; ++row){
            for(int col = 0; col < grid[0].length; ++col){
                if(grid[row][col] == 1 && !visited[row][col]){
                    return -1;
                }
            }
        }
        return ans;
    }

    int bfs(int [][] grid, Queue<int []> q, boolean [][] visited){
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; ++i){
                int [] pos = q.poll();
                visited[pos[0]][pos[1]] = true;
                for(int [] dir : dirs){
                    int r = pos[0] + dir[0];
                    int c = pos[1] + dir[1];
                    if(valid(grid, r, c, visited) && grid[r][c] == 1){  
                        visited[r][c] = true;                      
                        q.add(new int[]{r, c});
                    }
                }                
            }
            if(!q.isEmpty()){
                ++ans;
            }            
        }
        return ans;
    }

    boolean valid(int [][] grid, int row, int col, boolean [][] visited){
        if(row > grid.length - 1 || row < 0){
            return false;
        }
        if(col > grid[0].length - 1|| col < 0){
            return false;
        }
        if(visited[row][col]){
            return false;
        }
        return true;
    }

}
