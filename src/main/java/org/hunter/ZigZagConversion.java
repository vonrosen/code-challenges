package org.hunter;

public class ZigZagConversion {

    public static void main(String [] args) {
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        System.out.println(zigZagConversion.convert("PAYPALISHIRING", 3));
    }

    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        Character [][] matrix = new Character[numRows][s.length()];
        int col = 0;
        int row = 0;
        int inc = 1;
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            matrix[row][col] = c;
            if(row == numRows - 1) {
                inc = -1;
                row += inc;
                ++col;
            }else if(row == 0) {
                inc = 1;
                row += inc;
            }
            else{
                row += inc;
                if(inc == -1) {
                    col++;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int r = 0; r < matrix.length; ++r) {
            for(int c = 0; c < matrix[0].length; ++c) {
                if(matrix[r][c] == null) {
                    continue;
                }
                ans.append(matrix[r][c]);
            }
        }
        return ans.toString();
    }

}
