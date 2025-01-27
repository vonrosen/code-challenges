package org.hunter;

class maximalsquare {

	public int maximalSquare(char[][] matrix) {
		int [][] mem = new int[matrix.length][matrix[0].length];
		int ans = 0;
		for(int row = 0;  row < matrix.length; ++row){
			for(int col = 0;  col < matrix[0].length; ++col){
				if(matrix[row][col] == '1'){
					int up = 0, diag = 0, left = 0;
					if(valid(matrix, row - 1, col)){
						up = mem[row - 1][col];
					}
					if(valid(matrix, row - 1, col - 1)){
						diag = mem[row - 1][col - 1];
					}
					if(valid(matrix, row, col - 1)){
						left = mem[row][col - 1];
					}
					int min = Math.min(Math.min(up, diag), left);				
					mem[row][col] = 1 + min;
					ans = Math.max(ans, mem[row][col]);
				}				
			}			
		}
    return ans * ans;
	}

	boolean valid(char [][] matrix, int row, int col){
		if(row < 0 || row > matrix.length - 1){
			return false;
		}
		if(col < 0 || col > matrix[0].length - 1){
			return false;
		}
		if(matrix[row][col] == '0'){
			return false;
		}
		return true;
	}

}
