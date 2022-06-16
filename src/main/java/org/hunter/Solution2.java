package org.hunter;

public class Solution2{

	/**
	 * Boggle is a game where you are given a grid of letters and a word.
	 * You must search the grid of letters to see if the word exists in it.
	 * Words are formed from adjoining letters.
	 * Letters must join in the proper sequence to spell a word.
	 * They may join horizontally, vertically, or diagonally, to the left, right, or up-and-down.
	 * You can't re-use the same letter (a letter in a specific position on the
	 * board) more than once to spell a word.
	 *
	 * Examples.
	 *
	 * Word = "pop"
	 *
	 * Case 1:
	 {
		 {'p', 'o'},
		 {'e', 'p'}
	 };// true because pop exists in grid

	 Case 2:
	 {
		 {'p', 'd'},
		 {'d', 'd'}
	 }; //false because pop does not exist in grid

	 write a function boolean hasWord(String word, char[][] grid) to determine
	 if a word exists in a grid using boggle rules
	 */

//	static boolean hasWord(String word, char[][] grid) {
//
//	}

	public static void main(String[] args) {
		String word = "pop";
		char[][] grid1 = {
				{'p', 'o'},
				{'e', 'p'}
		};//true
		char[][] grid2 = {
				{'p', 'e'},
				{'e', 'e'}
		}; //false
		System.out.println(hasWord(word, grid1));
		System.out.println(hasWord(word, grid2));

		String w = "pop";
		char[][] wg1 = {
				{'p', 'o'},
				{'e', 'e'}
		};//false
		System.out.println(hasWord(w, wg1));
	}

	static boolean hasWord(String word, char[][] grid) {
		boolean [][] visited = new boolean[grid.length][grid[0].length];
		for(int i = 0; i < grid.length; ++i){
			for (int j = 0; j < grid[i].length; ++j){
				if(hasWord(word, grid, i, j, 0, visited)){
					return true;
				}
			}
		}
		return false;
	}

	private static boolean hasWord(String word, char[][] grid, int i, int j, int wordPos, boolean [][] visited){
		if(i < 0 || j < 0){
			return false;
		}
		if(i >= grid.length){
			return false;
		}
		if(j >= grid[i].length){
			return false;
		}
		if(wordPos >= word.length()){
			return false;
		}
		if(visited[i][j]){
			return false;
		}
		visited[i][j] = true;
		if(grid[i][j] == word.charAt(wordPos) && word.length() - 1 == wordPos){
			return true;
		}
		if(grid[i][j] == word.charAt(wordPos)){
			return hasWord(word, grid, i - 1, j - 1, wordPos + 1, visited)
					|| hasWord(word, grid, i - 1, j, wordPos + 1, visited)
					|| hasWord(word, grid, i - 1, j + 1, wordPos + 1, visited)
					|| hasWord(word, grid, i, j - 1, wordPos + 1, visited)
					|| hasWord(word, grid, i, j + 1, wordPos + 1, visited)
					|| hasWord(word, grid, i + 1, j - 1, wordPos + 1, visited)
					|| hasWord(word, grid, i + 1, j, wordPos + 1, visited)
					|| hasWord(word, grid, i + 1, j + 1, wordPos + 1, visited);
		}
		visited[i][j] = false;
		return false;
	}

}
