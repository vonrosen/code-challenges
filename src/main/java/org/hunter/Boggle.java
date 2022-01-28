package org.hunter;

public class Boggle{

	public static void main(String [] args){
		char [][] grid = {
				{ 'G', 'E', 'X', 'B'},
				{ 'E', 'E', 'K', 'B'},
				{ 'S', 'X', 'B', 'X'},
		};

		String word = "GEEKS";

		System.out.println(findWord(grid, word));
	}

	private static boolean findWord(char[][] grid, String word){
		boolean [][] visited = new boolean[grid.length][grid.length];
		char[] wordArray = word.toCharArray();
		for(int i = 0; i < grid.length; ++i){
			for(int k = 0; k < grid.length; ++k){
				if(exists(i, k, visited, grid, wordArray, 0)){
					return true;
				}
			}
		}
		return false;
	}

	private static boolean exists(int i, int k, boolean[][] visited, char[][] grid, char[] word, int pos){
		if(pos == word.length){
			return true;
		}
		if(i < 0 || i >= grid.length || k < 0 || k >= grid.length || visited[i][k] || word[pos] != grid[i][k]){
			return false;
		}
		visited[i][k] = true;
		boolean exists =
				exists(i + 1, k - 1, visited, grid, word, pos + 1)
				|| exists(i + 1, k, visited, grid, word, pos + 1)
				|| exists(i + 1, k + 1, visited, grid, word, pos + 1)
				|| exists(i, k - 1, visited, grid, word, pos + 1)
				|| exists(i, k + 1, visited, grid, word, pos + 1)
				|| exists(i - 1, k - 1, visited, grid, word, pos + 1)
				|| exists(i - 1, k, visited, grid, word, pos + 1)
				|| exists(i - 1, k + 1, visited, grid, word, pos + 1);
		if(exists){
			return exists;
		}
		visited[i][k] = false;
		return false;
	}

}
