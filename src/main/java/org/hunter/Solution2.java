package org.hunter;

public class Solution2{

	/**
	 * Boggle is a game where you are given a grid of letters and a word.
	 * You must search the grid of letters to see if the word exists in it.
	 * Words are formed from adjoining letters.
	 * Letters must join in the proper sequence to spell a word.
	 * They may join horizontally, vertically, or diagonally, to the left, right, or up-and-down.
	 *
	 * Examples.
	 *
	 * Word = "geeks"
	 *
	 * Case 1:
	 {
	 {'a', 'g', 'a', 'a'},
	 {'a', 'e', 'e', 'a'},
	 {'a', 'a', 'k', 'a'},
	 {'a', 'a', 'a', 's'},
	 }; //true geeks exists!
	 Case 2:
	 {
	 {'s', 'k', 'a', 'a'},
	 {'a', 'e', 'a', 'a'},
	 {'a', 'a', 'e', 'a'},
	 {'a', 'a', 'a', 'g'},
	 }; //true geeks exists!
	 Case 3:
	 {
	 {'a', 'g', 'a', 'a'},
	 {'a', 'e', 'e', 'a'},
	 {'s', 'a', 'k', 'a'},
	 {'a', 'a', 'a', 'a'},
	 };//false geeks does not exist!

	 write a function boolean hasWord(String word, char[][] grid) to determine
	 if a word exists in a grid using boggle rules
	 */

//	static boolean hasWord(String word, char[][] grid) {
//
//	}

	public static void main(String[] args) {
		String word = "geeks";
		char[][] wordGrid = {
				{'a', 'g', 'c', 'x'},
				{'a', 'e', 'e', 'x'},
				{'a', 'b', 'k', 'y'},
				{'a', 'b', 'b', 's'},
		}; //true
		char[][] wordGrid2 = {
				{'s', 'k', 'c', 'x'},
				{'a', 'e', 'b', 'x'},
				{'a', 'b', 'e', 'y'},
				{'a', 'b', 'b', 'g'},
		}; //true
		char[][] wordGrid3 = {
				{'a', 'g', 'c', 'y'},
				{'a', 'e', 'e', 'y'},
				{'s', 'b', 'k', 'y'},
				{'a', 'b', 'x', 'y'},
		};//false
		char[][] wordGrid4 = {
				{'a', 'g', 'c', 'y'},
				{'a', 'e', 'k', 'y'},
				{'s', 'b', 'e', 'y'},
				{'a', 'b', 's', 'y'},
		};//false
		System.out.println(hasWord(word, wordGrid));
		System.out.println(hasWord(word, wordGrid2));
		System.out.println(hasWord(word, wordGrid3));
		System.out.println(hasWord(word, wordGrid4));
	}

	static boolean hasWord(String word, char[][] grid) {
		for(int i = 0; i < grid.length; ++i){
			for (int j = 0; j < grid[i].length; ++j){
				if(hasWord(word, grid, i, j, 0)){
					return true;
				}
			}
		}
		return false;
	}

	private static boolean hasWord(String word, char[][] grid, int i, int j, int wordPos){
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
		if(grid[i][j] == word.charAt(wordPos) && word.length() - 1 == wordPos){
			return true;
		}
		if(grid[i][j] == word.charAt(wordPos)){
			boolean found = hasWord(word, grid, i - 1, j - 1, wordPos + 1)
					|| hasWord(word, grid, i - 1, j, wordPos + 1)
					|| hasWord(word, grid, i - 1, j + 1, wordPos + 1)
					|| hasWord(word, grid, i, j - 1, wordPos + 1)
					|| hasWord(word, grid, i, j + 1, wordPos + 1)
					|| hasWord(word, grid, i + 1, j - 1, wordPos + 1)
					|| hasWord(word, grid, i + 1, j, wordPos + 1)
					|| hasWord(word, grid, i + 1, j + 1, wordPos + 1);
			return found;
		}
		return false;
	}

}
