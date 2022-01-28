package org.hunter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Boggle{

	public static void main(String [] args){
		char [][] grid = {
				{ 'G', 'E', 'X'},
				{ 'E', 'E', 'K'},
				{ 'S', 'X', 'S'},
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

	private static void dfs(char [][] grid){
		Stack<List<Integer>> unvisited = new Stack<>();
		unvisited.push(List.of(0, 0));
		Map<List<Integer>, List<Integer>> map = new HashMap<>();

		while(!unvisited.isEmpty()){
			List<Integer> visited = unvisited.pop();
			
			if(visited.get(0) < 0 || visited.get(1) < 0 ||
				visited.get(0) >= grid.length || visited.get(1) >= grid.length
					|| map.get(visited) != null){
				continue;
			}

			map.put(visited, visited);
			System.out.println(grid[visited.get(0)][visited.get(1)]);

			unvisited.push(List.of(visited.get(0) - 1, visited.get(1) - 1));
			unvisited.push(List.of(visited.get(0) - 1, visited.get(1)));
			unvisited.push(List.of(visited.get(0) - 1, visited.get(1) + 1));
			unvisited.push(List.of(visited.get(0), visited.get(1) - 1));
			unvisited.push(List.of(visited.get(0), visited.get(1) + 1));
			unvisited.push(List.of(visited.get(0) + 1, visited.get(1) - 1));
			unvisited.push(List.of(visited.get(0) + 1, visited.get(1)));
			unvisited.push(List.of(visited.get(0) + 1, visited.get(1) + 1));
		}
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
