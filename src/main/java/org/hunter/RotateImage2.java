package org.hunter;

public class RotateImage2 {

    public static void main(String [] args) {
        RotateImage2 rotateImage2 = new RotateImage2();
        int [][] matrix = new int [][] {{1,2,3},{4,5,6},{7,8,9}};
        rotateImage2.rotate(matrix);
        matrix = new int [][] {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };
        //[[21,16,11,6,1],[22,17,12,7,2],[23,18,13,8,3],[24,19,14,9,4],[25,20,15,10,5]]
        rotateImage2.rotate(matrix);

//        matrix = new int [][] {
//                {5,1,9,11},
//                {2,4,8,10},
//                {13,3,6,7},
//                {15,14,12,16}
//        };
//        rotateImage2.rotate(matrix);
        for (int r = 0; r < matrix.length; ++r) {
            for (int c = 0; c < matrix.length; ++c) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println(" ");
        }
    }

    public void rotate(int[][] matrix) {
        //transpose
        for (int row = 0; row < matrix.length; ++row) {
            for (int col = row; col < matrix.length; ++col) {
                if (row != col) {
                    int tmp = matrix[row][col];
                    matrix[row][col] = matrix[col][row];
                    matrix[col][row] = tmp;
                }
            }
        }
        //reverse
        for (int row = 0; row < matrix.length; ++row) {
            int low = 0;
            int high = matrix.length - 1;
            while (low < high) {
                int tmp = matrix[row][low];
                matrix[row][low] = matrix[row][high];
                matrix[row][high] = tmp;
                ++low;
                --high;
            }
        }
    }

    public void rotate2(int[][] matrix) {
        int rotations = (int)Math.ceil((double)matrix.length / 2.0);
        int row = 0;
        int colStart = 0;
        int colEnd = matrix.length - 1;
        while (rotations > 0) {
            int ctr = 0;
            for (int c = colStart;  c < colEnd; ++c) {
                int tmp = matrix[c][colEnd];
                matrix[c][colEnd] = matrix[row][c];

                int tmp2 = matrix[colEnd][colEnd - ctr];
                matrix[colEnd][colEnd - ctr] = tmp;

                tmp = matrix[colEnd - ctr][colStart];
                matrix[colEnd - ctr][colStart] = tmp2;

                matrix[row][c] = tmp;
                ++ctr;
            }
            row++;
            colStart++;
            colEnd--;
            rotations--;
        }
    }
}
