package org.hunter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpiralOrder {

    public static void main(String [] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        List<Integer> ans = spiralOrder.spiralOrder(new int [][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        });
        System.out.println(ans);
    }

    record Pos(int row, int col){}

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        Set<Pos> seen = new HashSet<>();
        int size = matrix.length * matrix[0].length;
        int row = 0;
        int col = 0;
        while(ans.size() < size)  {
            col = right(ans, seen, matrix, row, col);
            ++row;
            row = down(ans, seen, matrix, row, col);
            col--;
            col = left(ans, seen, matrix, row, col);
            row--;
            row = up(ans, seen, matrix, row, col);
            ++col;
        }
        return ans;
    }

    int right(List<Integer> ans, Set<Pos> seen, int [][] matrix, int row, int col) {
        for(int i = col; i < matrix[0].length; ++i) {
            if(!seen.contains(new Pos(row, i))) {
                ans.add(matrix[row][i]);
                seen.add(new Pos(row, i));
            }else{
                return i - 1;
            }
        }
        return matrix[0].length - 1;
    }

    int down(List<Integer> ans, Set<Pos> seen, int [][] matrix, int row, int col) {
        for(int i = row; i < matrix.length; ++i) {
            if(!seen.contains(new Pos(i, col))) {
                ans.add(matrix[i][col]);
                seen.add(new Pos(i, col));
            }else{
                return i - 1;
            }
        }
        return matrix.length - 1;
    }

    int left(List<Integer> ans, Set<Pos> seen, int [][] matrix, int row, int col) {
        for(int i = col; i >= 0; --i) {
            if(!seen.contains(new Pos(row, i))) {
                ans.add(matrix[row][i]);
                seen.add(new Pos(row, i));
            }else{
                return i + 1;
            }
        }
        return 0;
    }

    int up(List<Integer> ans, Set<Pos> seen, int [][] matrix, int row, int col) {
        for(int i = row; i >= 0; --i) {
            if(!seen.contains(new Pos(i, col))) {
                ans.add(matrix[i][col]);
                seen.add(new Pos(i, col));
            }else{
                return i + 1;
            }
        }
        return 0;
    }
}
