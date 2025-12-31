package org.hunter;

import java.util.LinkedList;
import java.util.Queue;

public class MinKnightMoves {

    record State(
            int x,
            int y,
            int moves
    ){}

    record Position(
            int x,
            int y
    ){}

    int [][] dirs = new int [][] {
            {-2, -1},
            {-2, 1},
            {-1, 2},
            {1, 2},
            {2, 1},
            {2, -1},
            {1, -2},
            {-1, -2},
    };

    //if you use a set and not a array for "seen" you time out!
    public int minKnightMoves(int x, int y) {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 0, 0));
        boolean [][] seen = new boolean[601][601];
        seen[300][300] = true;
        while(!queue.isEmpty()) {
            State state = queue.poll();
            int curx = state.x, cury = state.y, moves = state.moves;
            if(curx == x && cury == y) {
                return moves;
            }
            for(int [] dir: dirs) {
                int newx = curx + dir[0], newy = cury + dir[1];
                if(valid(newx, newy, seen)) {
                    seen[newx + 300][newy + 300] = true;
                    queue.add(new State(newx, newy, moves + 1));
                }
            }
        }
        return -1;
    }

    boolean valid(int x, int y, boolean [][] seen) {
        if(Math.abs(x) > 300) {
            return false;
        }
        if(Math.abs(y) > 300) {
            return false;
        }
        if(seen[x + 300][y + 300]) {
            return false;
        }
        return true;
    }

}
