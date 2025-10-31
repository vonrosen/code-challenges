package org.hunter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SudokuTest3 {


    public static void main(String [] args){
        SudokuTest3 sudoku = new SudokuTest3();
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

    public void solveSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer,Set<Character>> cols = new HashMap<>();
        Map<Integer,Set<Character>> boxes = new HashMap<>();
        for(int i = 0; i < board.length; ++i){
            boxes.put(i, new HashSet<>());
        }
        for(int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
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
        solveSudoku(board, rows, cols, boxes);
    }

    public boolean solveSudoku(char [][] grid,
                           Map<Integer,Set<Character>> rows,
                           Map<Integer,Set<Character>> cols,
                           Map<Integer,Set<Character>> boxes){
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[i].length; ++j){
                if(grid[i][j] == '.'){
                    for(int value = 1; value <= 9; ++value){
                        char charValue = Character.forDigit(value, 10);
                        if(isValid(charValue, i, j, rows, cols, boxes)){
                            grid[i][j] = charValue;
                            rows.get(i).add(charValue);
                            cols.get(j).add(charValue);
                            boxes.get(boxId(i, j)).add(charValue);
                            if(solveSudoku(grid, rows, cols, boxes)){
                                return true;
                            }
                            grid[i][j] = '.';
                            rows.get(i).remove(charValue);
                            cols.get(j).remove(charValue);
                            boxes.get(boxId(i, j)).remove(charValue);
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
