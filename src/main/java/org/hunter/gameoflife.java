package org.hunter;

class gameoflife {
    public void gameOfLife(int[][] board) {
        int [][] copy = new int[board.length][board[0].length];
        for(int r = 0; r < board.length; ++r){
            for(int c = 0; c < board[0].length; ++c){
                copy[r][c] = board[r][c];
            }
        }
        for(int r = 0; r < board.length; ++r){
            for(int c = 0; c < board[0].length; ++c){
                update(board, copy, r, c);
            }            
        }
    }

    int [][] dirs = new int[][]{
        { -1, 0 },
        { -1, 1 },
        { 0, 1 },
        { 1, 1 },
        { 1, 0 },
        { 1, -1 },
        { 0, -1 },
        { -1, -1 },
    };

    void update(int [][] board, int [][] copy, int r, int c){
        int liveCount = 0;        
        for(int [] dir : dirs){
            int newR = r + dir[0];
            int newC = c + dir[1];
            if(valid(board, newR, newC)){
                liveCount += copy[newR][newC] == 1 ? 1 : 0;
            }
        }
        if(board[r][c] == 1){
            if(liveCount < 2){
                board[r][c] = 0;
            }
            if(liveCount > 3){
                board[r][c] = 0;
            }
        }else{
            if(liveCount == 3){
                board[r][c] = 1;
            }
        }
    }

    boolean valid(int [][] board, int r, int c){
        if(r > board.length - 1 || r < 0){
            return false;
        }
        if(c > board[0].length - 1 || c < 0){
            return false;
        }
        return true;
    }
}
