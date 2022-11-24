package org.hunter;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku{

	public static void main(String [] args){
		ValidSudoku validSudoku = new ValidSudoku();
		char [][] board = new char[][]{
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}};
		System.out.println(validSudoku.isValidSudoku(board));
		board = new char[][]{
				{'8','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}};
		System.out.println(validSudoku.isValidSudoku(board));
	}

	public boolean isValidSudoku(char[][] board) {
		for(int r = 0; r < board.length; ++r){
			Map<Character,Character> map = new HashMap<>();
			for(int c = 0; c < board.length; ++c){
				if(board[r][c] == '.'){
					continue;
				}
				if(map.get(board[r][c]) != null){
					return false;
				}
				if(!isValid(board[r][c])){
					return false;
				}
				map.put(board[r][c], board[r][c]);
			}
		}

		for(int c = 0; c < board.length; ++c){
			Map<Character,Character> map = new HashMap<>();
			for(int r = 0; r < board.length; ++r){
				if(board[r][c] == '.'){
					continue;
				}
				if(map.get(board[r][c]) != null){
					return false;
				}
				if(!isValid(board[r][c])){
					return false;
				}
				map.put(board[r][c], board[r][c]);
			}
		}
		Map<Character,Character> map = new HashMap<>();
		for(int r = 0; r < 3; ++r){
			for(int c = 0; c < 3; ++c){
				if(board[r][c] == '.'){
					continue;
				}
				if(map.get(board[r][c]) != null){
					return false;
				}
				if(!isValid(board[r][c])){
					return false;
				}
				map.put(board[r][c], board[r][c]);
			}
		}
		map = new HashMap<>();
		for(int r = 0; r < 3; ++r){
			for(int c = 3; c < 6; ++c){
				if(board[r][c] == '.'){
					continue;
				}
				if(map.get(board[r][c]) != null){
					return false;
				}
				if(!isValid(board[r][c])){
					return false;
				}
				map.put(board[r][c], board[r][c]);
			}
		}
		map = new HashMap<>();
		for(int r = 0; r < 3; ++r){
			for(int c = 6; c < 9; ++c){
				if(board[r][c] == '.'){
					continue;
				}
				if(map.get(board[r][c]) != null){
					return false;
				}
				if(!isValid(board[r][c])){
					return false;
				}
				map.put(board[r][c], board[r][c]);
			}
		}
		map = new HashMap<>();
		for(int r = 3; r < 6; ++r){
			for(int c = 0; c < 3; ++c){
				if(board[r][c] == '.'){
					continue;
				}
				if(map.get(board[r][c]) != null){
					return false;
				}
				if(!isValid(board[r][c])){
					return false;
				}
				map.put(board[r][c], board[r][c]);
			}
		}
		map = new HashMap<>();
		for(int r = 3; r < 6; ++r){
			for(int c = 3; c < 6; ++c){
				if(board[r][c] == '.'){
					continue;
				}
				if(map.get(board[r][c]) != null){
					return false;
				}
				map.put(board[r][c], board[r][c]);
			}
		}
		map = new HashMap<>();
		for(int r = 3; r < 6; ++r){
			for(int c = 6; c < 9; ++c){
				if(board[r][c] == '.'){
					continue;
				}
				if(map.get(board[r][c]) != null){
					return false;
				}
				map.put(board[r][c], board[r][c]);
			}
		}
		map = new HashMap<>();
		for(int r = 6; r < 9; ++r){
			for(int c = 0; c < 3; ++c){
				if(board[r][c] == '.'){
					continue;
				}
				if(map.get(board[r][c]) != null){
					return false;
				}
				map.put(board[r][c], board[r][c]);
			}
		}
		map = new HashMap<>();
		for(int r = 6; r < 9; ++r){
			for(int c = 3; c < 6; ++c){
				if(board[r][c] == '.'){
					continue;
				}
				if(map.get(board[r][c]) != null){
					return false;
				}
				map.put(board[r][c], board[r][c]);
			}
		}
		map = new HashMap<>();
		for(int r = 6; r < 9; ++r){
			for(int c = 6; c < 9; ++c){
				if(board[r][c] == '.'){
					continue;
				}
				if(map.get(board[r][c]) != null){
					return false;
				}
				map.put(board[r][c], board[r][c]);
			}
		}

		return true;
	}

	private boolean isValid(char character){
		return character == '1'
				|| character == '2'
				|| character == '3'
				|| character == '4'
				|| character == '5'
				|| character == '6'
				|| character == '7'
				|| character == '8'
				|| character == '9';
	}

}
