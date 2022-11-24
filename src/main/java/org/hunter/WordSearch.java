package org.hunter;

public class WordSearch{

	public static void main(String [] args){
		WordSearch wordSearch = new WordSearch();
		char[][] grid = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "SEE";
		System.out.println(wordSearch.exist(grid, word));
		grid = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		word = "ABCB";
		System.out.println(wordSearch.exist(grid, word));
	}

	public boolean exist(char[][] board, String word) {
		boolean [][] history = new boolean[board.length][board[0].length];
		for(int r = 0; r < board.length; ++r){
			for(int c = 0; c < board[0].length; ++c){
				if(exist(r, c, board, word, 0, history)){
					return true;
				}
			}
		}
		return false;
	}

	private boolean exist(int row, int col, char [][] board, String word, int pos,
			boolean[][] history){
		if(row < 0){
			return false;
		}
		if(col < 0){
			return false;
		}
		if(row >= board.length){
			return false;
		}
		if(col >= board[0].length){
			return false;
		}
		if(history[row][col]){
			return false;
		}
		if(board[row][col] == word.charAt(pos)){
			if(pos == word.length() - 1){
				return true;
			}
			history[row][col] = true;
			boolean exist = exist(row - 1, col, board, word, pos + 1,
					history) ||
					exist(row, col - 1, board, word, pos + 1,
							history) ||
					exist(row, col + 1, board, word, pos + 1,
							history) ||
					exist(row + 1, col, board, word, pos + 1,
							history);
			if(exist){
				return true;
			}
			history[row][col] = false;
		}
		return false;
	}

}
