package org.hunter;

import java.util.LinkedList;
import java.util.Queue;

public class NearestMazeExist {

    int [][] dirs = new int[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    class State {
        int x;
        int y;
        int steps;
        State(int x, int y, int steps) {
            this.x = x;
            this.y = y;
            this.steps = steps;
        }
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(entrance[0], entrance[1], 0));
        boolean [][] seen = new boolean[maze.length][maze[0].length];
        seen[entrance[0]][entrance[1]] = true;

        while(!queue.isEmpty()) {
            State state = queue.poll();
            int x = state.x, y = state.y, steps = state.steps;
            if(maze[x][y] == '.' && steps > 0) {
                if(x == 0 || x == maze.length - 1){
                    return steps;
                }else if (y == 0 || y == maze[0].length - 1) {
                    return steps;
                }
            }
            for(int [] dir: dirs){
                int newx = x + dir[0], newy = y + dir[1];
                if(valid(newx, newy, maze, seen)) {
                    seen[newx][newy] = true;
                    queue.add(new State(newx, newy, steps + 1));
                }
            }
        }
        return -1;
    }

    boolean valid(int x, int y, char [][] maze, boolean [][] seen) {
        if (x < 0 || x > maze.length - 1) {
            return false;
        }
        if (y < 0 || y > maze[0].length - 1) {
            return false;
        }
        if(maze[x][y] == '+') {
            return false;
        }
        if(seen[x][y]) {
            return false;
        }
        return true;
    }
}
