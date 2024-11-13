package org.hunter;

import java.util.*;

/**
 * // This is the GridMaster's API interface.
 * // You should not implement it, or speculate about its implementation
 * class GridMaster {
 *     boolean canMove(char direction);
 *     void move(char direction);
 *     boolean isTarget();
 * }
 */
public class ShortestPathHiddenGrid {
    char [] dirs = new char[]{'U','D','L','R'};
    char [] oppDirs = new char[]{'D','U','R','L'};

    public int findShortestPath(GridMaster master){
        Set<String> visited = new HashSet<>();
        dfs(master, 0, 0, visited);        
        //System.out.println("grid size " + visited.size());
        return bfs(visited);
    }

    class State{
        int moves;
        int row;
        int col;
        State(int moves, int row, int col){
            this.moves = moves;
            this.row = row;
            this.col = col;
        }
    }

    int bfs(Set<String> grid){
        Queue<State> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(new State(0, 0, 0));
        visited.add(0 + "x" + 0);
        while(!q.isEmpty()){
            State s = q.poll();
            if(grid.contains(s.row + "xx" + s.col)){
                return s.moves;
            }
            for(int i = 0; i < dirs.length; ++i){
                int r = s.row;
                int c = s.col;
                if(dirs[i] == 'U'){
                    r--;
                }else if(dirs[i] == 'D'){
                    r++;
                }else if(dirs[i] == 'L'){
                    c--;
                }else if(dirs[i] == 'R'){
                    c++;
                }
                if(!visited.contains(r + "x" + c)){
                    visited.add(r + "x" + c);
                    if(grid.contains(r + "x" + c) || grid.contains(r + "xx" + c)){
                        q.add(new State(s.moves + 1, r, c));   
                    }
                }
            }
        }
        return -1;
    }

    void dfs(GridMaster master, int row, int col, Set<String> visited){
        if(visited.contains(row + "x" + col) || visited.contains(row + "xx" + col)){
            return;
        }
        if(master.isTarget()){
            visited.add(row + "xx" + col);
            return;
        }
        visited.add(row + "x" + col);
        for(int i = 0; i < dirs.length; ++i){
            if(master.canMove(dirs[i])){
                master.move(dirs[i]);
                int r = row;
                int c = col;
                if(dirs[i] == 'U'){
                    r--;
                }else if(dirs[i] == 'D'){
                    r++;
                }else if(dirs[i] == 'L'){
                    c--;
                }else if(dirs[i] == 'R'){
                    c++;
                }
                dfs(master, r, c, visited);
                master.move(oppDirs[i]);
            }
        }
    }
   
}
