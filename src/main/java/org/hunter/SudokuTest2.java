package org.hunter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SudokuTest2 {

    int found = 0;
    int target = 0;
    int [][] dirs = new int[][]{
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1},
    };

    public static void main(String [] args){
        SudokuTest2 sudoku = new SudokuTest2();
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
//        char [][] grid = new char[][]{
//                {'5','3','.','.','7','.','.','.','.'},
//                {'6','.','.','1','9','5','.','.','.'},
//                {'.','9','8','.','.','.','.','6','.'},
//                {'8','.','.','.','6','.','.','.','3'},
//                {'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','6'},
//                {'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'}
//        };
//        char [][] grid = new char[][]{
//                {'.','.','9','7','4','8','.','.','.'},
//                {'7','.','.','.','.','.','.','.','.'},
//                {'.','2','.','1','.','9','.','.','.'},
//                {'.','.','7','.','.','.','2','4','.'},
//                {'.','6','4','.','1','.','5','9','.'},
//                {'.','9','8','.','.','.','3','.','.'},
//                {'.','.','.','8','.','3','.','2','.'},
//                {'.','.','.','.','.','.','.','.','6'},
//                {'.','.','.','2','7','5','9','.','.'}
//        };
        char [][] grid = new char[][]{
                {'.','.','.','.','.','.','.','.','.'},
                {'.','9','.','.','1','.','.','3','.'},
                {'.','.','6','.','2','.','7','.','.'},
                {'.','.','.','3','.','4','.','.','.'},
                {'2','1','.','.','.','.','.','9','8'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','2','5','.','6','4','.','.'},
                {'.','8','.','.','.','.','.','1','.'},
                {'.','.','.','.','.','.','.','.','.'}
        };
        sudoku.solveSudoku(grid);
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[i].length; ++j){
                if(grid[i][j] != '.'){
                    System.out.print("|" + grid[i][j] + "|");
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

    boolean isValid(char value,
                    int row,
                    int col,
                    Map<Integer,Set<Character>> rows,
                    Map<Integer,Set<Character>> cols,
                    Map<Integer,Set<Character>> boxes){
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

    boolean isValid(char [][] grid,
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

    public void solveSudoku(char[][] board) {
        char [][] copy = new char[board.length][board[0].length];
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer,Set<Character>> cols = new HashMap<>();
        Map<Integer,Set<Character>> boxes = new HashMap<>();
        for(int i = 0; i < board.length; ++i){
            boxes.put(i, new HashSet<>());
        }
        for(int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if(board[i][j] == '.'){
                    target++;
                }
                copy[i][j] = board[i][j];
                rows.putIfAbsent(i, new HashSet<>());
                cols.putIfAbsent(j, new HashSet<>());
                if(board[i][j] != '.'){
                    int boxId = boxId(i, j);
                    rows.get(i).add(board[i][j]);
                    cols.get(j).add(board[i][j]);
                    boxes.get(boxId).add(board[i][j]);
                }
            }
        }
        boolean [][] visited = new boolean[board.length][board[0].length];
        solveSudoku(board, copy, visited, rows, cols, boxes, 0, 0);
        for(int i = 0; i < copy.length; ++i){
            for(int j = 0; j < copy[i].length; ++j){
                board[i][j] = copy[i][j];
            }
        }
    }

    public int solveSudoku(char [][] grid,
                           char [][] copy,
                           boolean [][] visited,
                           Map<Integer,Set<Character>> rows,
                           Map<Integer,Set<Character>> cols,
                           Map<Integer,Set<Character>> boxes,
                           int row,
                           int col){
        if(found == target){
            return 1;
        }
        if(!isValid(copy, visited, row, col)){
            return 0;
        }
        visited[row][col] = true;
        if(grid[row][col] != '.'){
            for(int [] dir : dirs){
                int result = solveSudoku(grid, copy, visited, rows, cols, boxes, row + dir[0], col + dir[1]);
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
            char value = Character.forDigit(i,10);
            if(isValid(value, row, col, rows, cols, boxes)){
                copy[row][col] = value;
                rows.get(row).add(value);
                cols.get(col).add(value);
                boxes.get(boxId).add(value);
                ++found;
                for(int [] dir : dirs){
                    int result = solveSudoku(grid, copy, visited, rows, cols, boxes, row + dir[0], col + dir[1]);
                    if(result == 1){
                        return 1;
                    }else if(result == -1){
                        break;
                    }
                }
                copy[row][col] = '.';
                rows.get(row).remove(value);
                cols.get(col).remove(value);
                boxes.get(boxId).remove(value);
                --found;
            }
        }
        visited[row][col] = false;
        return -1;
    }

}
