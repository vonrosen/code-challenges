package org.hunter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinDistanceBetweenCities{

	public static void main(String [] args){
		MinDistanceBetweenCities minDistanceBetweenCities = new MinDistanceBetweenCities();
		int n = 4;
		int [][] roads = new int[][] {{1,2,9},{2,3,6},{2,4,5},{1,4,7}};
		System.out.println(minDistanceBetweenCities.minScore(n, roads));
		n = 4;
		roads = new int[][]{{1,2,2},{1,3,4},{3,4,7}};
		System.out.println(minDistanceBetweenCities.minScore(n, roads));
		n = 82;
		roads = new int[][]{{41,47,7732},{60,5,4761},{59,57,7948},{19,59,7071},{5,59,3960},{28,76,5286},{76,45,791},
				{36,57,7203},{59,73,243},{59,25,1553},{58,14,2968},{18,7,2898},{35,2,2890},{7,35,5723},{25,72,9218},{73,41,7886},{1,58,7061},{19,28,3060},{59,4,9138},{66,60,9349},{32,73,8542},{4,62,2921},{2,19,396},{5,44,247},{47,60,2333},{10,12,2571},{40,4,7673},{14,59,1851},{41,59,3541},{59,35,2796},{44,74,2730},{74,40,8253},{82,66,684},{62,25,4332},{59,40,8975},{72,10,8773},{45,36,7815},{59,28,8569},{79,8,2081},{10,59,2978},{36,59,3432},{59,24,1329},{59,82,8828},{2,59,5160},{57,82,4084},{12,18,638},{14,24,7880},{24,32,6079},{59,74,6346},{79,77,5781}};
		System.out.println(minDistanceBetweenCities.minScore(n, roads));
		roads = new int[][]{{1,3,1484},{3,2,3876},{2,4,6823},{6,7,579},{5,6,4436},{4,5,8830}};
		n = 7;
		System.out.println(minDistanceBetweenCities.minScore(n, roads));
	}

	public int minScore(int n, int[][] roads) {
		boolean [] visited = new boolean[n + 1];
		Map<Integer,List<List<Integer>>> graph = new HashMap<>();
		for(int [] road: roads){
			int city1 = road[0];
			int city2 = road[1];
			int score = road[2];
			List<List<Integer>> edges1 = new ArrayList<>();
			List<List<Integer>> edges2 = new ArrayList<>();
			graph.putIfAbsent(city1, edges1);
			graph.putIfAbsent(city2, edges2);
			graph.get(city1).add(List.of(city2, score));
			graph.get(city2).add(List.of(city1, score));
		}

		return minScore(1, Integer.MAX_VALUE, graph, visited);
	}

	private int minScore(int cityStart, int score, Map<Integer,List<List<Integer>>> graph,
			boolean [] visited){
		if(visited[cityStart]){
			return score;
		}
		visited[cityStart] = true;
		int min = Integer.MAX_VALUE;
		for(List<Integer> edge: graph.get(cityStart)){
			min = Math.min(min, minScore(edge.get(0), Math.min(edge.get(1), score), graph, visited));
		}
		return min;
	}

}
