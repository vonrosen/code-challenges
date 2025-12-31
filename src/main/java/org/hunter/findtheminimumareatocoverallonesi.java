package org.hunter;

class findtheminimumareatocoverallonesi {
    public int minimumArea(int[][] grid) {
        int minLeft = Integer.MAX_VALUE;
        int maxRight = 0;
        int minTop = Integer.MAX_VALUE;
        int maxBottom = 0;
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[i].length; ++j){
                if(grid[i][j] == 1){
                    minLeft = Math.min(minLeft, j);
                    maxRight = Math.max(maxRight, j);
                    minTop = Math.min(minTop, i);
                    maxBottom = Math.max(maxBottom, i);
                }
            }
        }
        int width = maxRight - minLeft + 1;
        int height = maxBottom - minTop + 1;
        return width * height;
    }
}
