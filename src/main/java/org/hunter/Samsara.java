package org.hunter;

public class Samsara {


    /**
     * 2 d array
     * [
     *  [0,1,1],
     *  [1,0,0]
     * ]
     *
     * up,down,left,right
     *
     * N = width
     * M = height
     * O(N * M) = time
     * O(N * M) = space
     *
     */
    public static void main(String [] args) {
        Samsara samsara = new Samsara();
        int [][] matrix = new int[][]{
                {0,1,1},
                {1,0,0},
        };
        System.out.println(samsara.islands(matrix));
        matrix = new int[][]{
                {1,1,1},
                {1,1,1},
        };
        System.out.println(samsara.islands(matrix));
        matrix = new int[][]{
                {0,0,0},
                {0,0,0},
        };
        System.out.println(samsara.islands(matrix));
        matrix = new int[][]{
                {1,0,0,0},
                {0,0,1,1},
                {0,1,1,0},
                {0,0,1,0},
        };
        System.out.println(samsara.islands(matrix));
        matrix = new int[][]{
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,1},
        };
        System.out.println(samsara.islands(matrix));
        matrix = new int[][]{
                {0,1,0,1},
                {1,0,1,0},
                {0,1,0,1},
                {0,0,1,0},
        };
        System.out.println(samsara.islands(matrix));
        matrix = new int[][]{
                {0,0,1,0},
                {0,0,1,0},
                {0,0,1,0},
                {0,0,1,0},
                {1,0,1,0},
                {1,1,1,0},
                {0,0,1,0},
        };
        System.out.println(samsara.islands(matrix));
    }

    public int islands(int [][] matrix) {
        boolean [][] visited = new boolean[matrix.length][matrix[0].length];
        int ans = 0;
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[i].length; ++j) {
                ans = Math.max(ans, dfs(matrix, i, j, visited));
            }
        }
        return ans;
    }

    int [][] dirs = new int[][]{
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1},
    };

    int dfs(int [][] matrix, int row, int col, boolean [][] visited) {
        if(!valid(matrix, row, col, visited)) {
            return 0;
        }
        visited[row][col] = true;
        int ans = 1;
        for(int [] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            ans += dfs(matrix, newRow, newCol, visited);
        }
        return ans;
    }

    boolean valid(int [][] matrix, int row, int col, boolean [][] visited) {
        if(row < 0 || row > matrix.length - 1) {
            return false;
        }
        if(col < 0 || col > matrix[0].length - 1) {
            return false;
        }
        if(visited[row][col]) {
            return false;
        }
        if(matrix[row][col] == 0) {
            return false;
        }
        return true;
    }



}
