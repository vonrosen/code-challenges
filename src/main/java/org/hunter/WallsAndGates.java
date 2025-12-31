package org.hunter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WallsAndGates {

    public static void main(String [] args) {
        WallsAndGates wallsAndGates = new WallsAndGates();
        int [][] rooms = new int [][] {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        wallsAndGates.wallsAndGates(rooms);
        for(int i = 0; i < rooms.length; ++i) {
            for(int j = 0; j < rooms[0].length; ++j) {
                System.out.print(rooms[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void wallsAndGates(int[][] rooms) {
        List<int []> gates = new ArrayList<>();
        for(int i = 0; i < rooms.length; ++i) {
            for(int j = 0; j < rooms[i].length; ++j) {
                if(rooms[i][j] == 0) {
                    gates.add(new int[]{i, j});
                }
            }
        }
        bfs2(rooms, gates);
    }

    int [][] dirs = new int[][]{
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    record State (
        int steps,
        int row,
        int col
    ){};

    //good solution
    //from each gate do bfs
    //O(n*m
    void bfs2(int [][] rooms, List<int []> gates) {
        Queue<State> queue = new LinkedList<>();
        boolean [][] seen = new boolean[rooms.length][rooms[0].length];
        for(int i = 0; i < gates.size(); ++i) {
            queue.add(new State(0, gates.get(i)[0], gates.get(i)[1]));
        }
        while(!queue.isEmpty()) {
            State state = queue.poll();
            int steps = state.steps, r = state.row, c = state.col;
            if(rooms[r][c] > 0) {
                rooms[r][c] = steps;
            }
            for(int [] dir : dirs) {
                int nextRow = r + dir[0], nextCol = c + dir[1];
                if(valid(rooms, nextRow, nextCol, seen)) {
                    seen[nextRow][nextCol] = true;
                    queue.add(new State(steps + 1, nextRow, nextCol));
                }
            }
        }
    }

    boolean valid(int [][] rooms, int row, int col, boolean [][] seen) {
        if(row < 0 || row > rooms.length - 1) {
            return false;
        }
        if(col < 0 || col > rooms[0].length - 1) {
            return false;
        }
        if(seen[row][col]) {
            return false;
        }
        return (rooms[row][col] > 0);
    }



    //bad solution. O(n2*m2)
    //for each empty room do bfs
    int bfs(int [][] rooms, int row, int col) {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, row, col));
        boolean [][] seen = new boolean[rooms.length][rooms[0].length];
        seen[row][col] = true;
        while(!queue.isEmpty()) {
            State state = queue.poll();
            int steps = state.steps, r = state.row, c = state.col;
            if(rooms[r][c] == 0) {
                return steps;
            }
            for(int [] dir : dirs) {
                int nextRow = r + dir[0], nextCol = c + dir[1];
                if(valid(rooms, nextRow, nextCol, seen)) {
                    seen[nextRow][nextCol] = true;
                    queue.add(new State(nextRow, nextCol, steps + 1));
                }
            }
        }
        return Integer.MAX_VALUE;
    }

}
