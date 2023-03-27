package org.hunter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class NumberOfIslands{

	//https://leetcode.com/problems/number-of-islands/description/
	public static void main(String [] args){
		NumberOfIslands numberOfIslands = new NumberOfIslands();
		char[][] grid = new char[][]{
				{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'}
		};
		System.out.println(numberOfIslands.numIslands(grid));
		grid = new char[][]{
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}
		};
		System.out.println(numberOfIslands.numIslands(grid));
		grid = new char[][]{
				{'0','1','0'},
				{'1','0','1'},
				{'0','1','0'}};
		//expected = 4
		System.out.println(numberOfIslands.numIslands(grid));
	}

	public int numIslands(char[][] grid) {
		Set<String> islands = new HashSet<>();
		boolean [][] visited = new boolean[grid.length][grid[0].length];
		for(int i = 0; i < grid.length; ++i){
			for(int k = 0; k < grid[i].length; ++k){
				if(grid[i][k] == '1'){
					Set<String> border = new HashSet<>();
					dfs(i, k, grid, border, visited);
					if(border.size() > 0){
						islands.add(border.stream().sorted().collect(Collectors.joining()));
					}
				}
			}
		}
		return islands.size();
	}

	private void dfs(int i, int k, char [][] grid, Set<String> borders, boolean [][] visited){
		if(i < 0){
			borders.add(String.format("%s-%s", 0, k));
			return;
		}
		if(k < 0){
			borders.add(String.format("%s-%s", i, 0));
			return;
		}
		if(i > grid.length - 1){
			borders.add(String.format("%s-%s", grid.length - 1, k));
			return;
		}
		if(k > grid[i].length - 1){
			borders.add(String.format("%s-%s", i, grid[i].length - 1));
			return;
		}
		if(grid[i][k] == '0'){
			borders.add(String.format("%s-%s", i, k));
			return;
		}
		if(visited[i][k]){
			return;
		}
		visited[i][k] = true;
		dfs(i - 1, k, grid, borders, visited);
		dfs(i, k + 1, grid, borders, visited);
		dfs(i + 1, k, grid, borders, visited);
		dfs(i, k - 1, grid, borders, visited);
	}

}
