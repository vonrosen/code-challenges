package org.hunter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SudokuTest {

    int found = 0;
    int target = 0;
    int [][] dirs = new int[][]{
            {-1, 0},
            {-1, 1},
            {0, 1},
            {1, 1},
            {1, 0},
            {1, -1},
            {0, -1},
            {-1, -1},
    };

    public static void main(String [] args){
        SudokuTest sudoku = new SudokuTest();
//        int [][] grid = new int[][]{
//                {9, -1, -1 },
//                {7, 6, 1 },
//                {-1, -1, -1 },
//        };
//        int [][] grid = new int[][]{
//                {1, 2, 3 },
//                {4, -1, 6 },
//                {7, 8, 9 },
//        };
//        int [][] grid = new int[][]{
//                {9, -1, -1, 6, 5, -1 },
//                {7, 6, 1, -1, -1, 4 },
//                {-1, -1, -1, 9, -1, -1 },
//                {-1, 7, 9, -1, -1, -1 },
//                {6, -1, -1, -1, -1, -1 },
//                {-1, 3, -1, -1, -1, -1 },
//        };
//        int [][] grid = new int[][]{
//                {6, 2, -1, -1, -1, 4, -1, -1, -1 },
//                {-1, 7, 5, -1, -1, -1, -1, -1, 6 },
//                {-1, -1, -1, -1, -1, -1, 8, 9, 7 },
//                {-1, -1, -1, 3, -1, 1, -1, -1, 9 },
//                {3, 4, 8, 2, -1, -1, -1, -1, -1 },
//                {-1, -1, -1, 6, 5, -1, 7, -1, -1 },
//                {-1, -1, -1, 1, -1, 9, -1, -1, -1 },
//                {-1, -1, -1, -1, 8, -1, 5, 1, -1 },
//                {-1, 6, 3, -1, 2, -1, -1, 4, -1 },
//        };
//        int [][] grid = new int[][]{
//                {3, -1, 6, 5, -1, 8, 4, -1, -1},
//                {5, 2, -1, -1, -1, -1, -1, -1, -1},
//                {-1, 8, 7, -1, -1, -1, -1, 3, 1},
//                {-1, -1, 3, -1, 1, -1, -1, 8, -1},
//                {9, -1, -1, 8, 6, 3, -1, -1, 5},
//                {-1, 5, -1, -1, 9, -1, 6, -1, -1},
//                {1, 3, -1, -1, -1, -1, 2, 5, -1},
//                {-1, -1, -1, -1, -1, -1, -1, 7, 4},
//                {-1, -1, 5, 2, -1, 6, 3, -1, -1}
//        };
        int [][] grid = new int[][]{
                {5,3,-1,-1,7,-1,-1,-1,-1},
                {6,-1,-1,1,9,5,-1,-1,-1},
                {-1,9,8,-1,-1,-1,-1,6,-1},
                {8,-1,-1,-1,6,-1,-1,-1,3},
                {4,-1,-1,8,-1,3,-1,-1,1},
                {7,-1,-1,-1,2,-1,-1,-1,6},
                {-1,6,-1,-1,-1,-1,2,8,-1},
                {-1,-1,-1,4,1,9,-1,-1,5},
                {-1,-1,-1,-1,8,-1,-1,7,9}};
        int [][] copy = new int[grid.length][grid[0].length];
        Map<Integer, Set<Integer>> rows = new HashMap<>();
        Map<Integer,Set<Integer>> cols = new HashMap<>();
        Map<Integer,Set<Integer>> boxes = new HashMap<>();
        for(int i = 0; i < grid.length; ++i){
            boxes.put(i, new HashSet<>());
        }
        for(int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if(grid[i][j] < 0){
                    sudoku.target++;
                }
                copy[i][j] = grid[i][j];
                rows.putIfAbsent(i, new HashSet<>());
                cols.putIfAbsent(j, new HashSet<>());
                if(grid[i][j] > 0){
                    int boxId = sudoku.boxId(i, j);
                    rows.get(i).add(grid[i][j]);
                    cols.get(j).add(grid[i][j]);
                    boxes.get(boxId).add(grid[i][j]);
                }
            }
        }
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        sudoku.solve(grid, copy, visited, rows, cols, boxes, 0, 0);
        for(int i = 0; i < copy.length; ++i){
            for(int j = 0; j < copy[i].length; ++j){
                if(copy[i][j] > 0){
                    System.out.print("|" + copy[i][j] + "|");
                }else{
                    System.out.print("| |");
                }
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    int boxId(int row, int col){
        return (row / 3) + (col / 3) + ((row / 3) * 2);
    }

    int solve(int [][] grid,
               int [][] copy,
               boolean [][] visited,
               Map<Integer,Set<Integer>> rows,
               Map<Integer,Set<Integer>> cols,
               Map<Integer,Set<Integer>> boxes,
               int row,
               int col){
        if(found == target){
            return 1;
        }
        if(!isValid(copy, visited, row, col)){
            return 0;
        }
        visited[row][col] = true;
        if(grid[row][col] > 0){
            for(int [] dir : dirs){
                int result = solve(grid, copy, visited, rows, cols, boxes, row + dir[0], col + dir[1]);
                if(result == 1){
                    return 1;
                }else if(result == -1){
                    visited[row][col] = false;
                    return -1;
                }
            }
            visited[row][col] = false;
            return 0;
        }
        int boxId = boxId(row, col);
        for(int i = 1; i <= 9; ++i){
            if(isValid(i, row, col, rows, cols, boxes)){
                copy[row][col] = i;
                rows.get(row).add(i);
                cols.get(col).add(i);
                boxes.get(boxId).add(i);
                ++found;
                int result = 0;
                boolean allZero = true;
                for(int [] dir : dirs){
                    result = solve(grid, copy, visited, rows, cols, boxes, row + dir[0], col + dir[1]);
                    if(result != 0){
                        allZero = false;
                    }
                    if(result == 1){
                        return 1;
                    }else if(result == -1){
                        break;
                    }
                }
                if(allZero){
                    return 0;
                }
                copy[row][col] = -1;
                rows.get(row).remove(i);
                cols.get(col).remove(i);
                boxes.get(boxId).remove(i);
                --found;
            }
        }
        visited[row][col] = false;
        return -1;
    }

    boolean isValid(int value,
                    int row,
                    int col,
                    Map<Integer,Set<Integer>> rows,
                    Map<Integer,Set<Integer>> cols,
                    Map<Integer,Set<Integer>> boxes){
        if(rows.get(row).contains(value)){
            return false;
        }
        if(cols.get(col).contains(value)){
            return false;
        }
        int boxId = boxId(row, col);
        if(boxes.get(boxId).contains(value)){
            return false;
        }
        return true;
    }

    boolean isValid(int [][] grid,
                    boolean [][] visited,
                    int row,
                    int col){
        if(row < 0 || row > grid.length - 1){
            return false;
        }
        if(col < 0 || col > grid[row].length - 1){
            return false;
        }
        if(visited[row][col]){
            return false;
        }
        return true;
    }

}
