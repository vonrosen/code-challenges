package org.hunter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberWaysToDestination{

	public static void main(String [] args){
		NumberWaysToDestination numberWaysToDestination = new NumberWaysToDestination();
		int [][] roads = new int[][]{{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
		int n = 7;
//		System.out.println(numberWaysToDestination.countPaths(n, roads));
//		roads = new int[][]{{1,0,10}};
//		n = 2;
//		System.out.println(numberWaysToDestination.countPaths(n, roads));
//		roads = new int[][]{{1,0,2348},{2,1,2852},{2,0,5200},{3,1,12480},{2,3,9628},{4,3,7367},{4,0,22195},{5,4,5668},
//		{1,5,
//			25515},{0,5,27863},{6,5,836},{6,0,28699},{2,6,23499},{6,3,13871},{1,6,26351},{5,7,6229},{2,7,28892},{1,7,
//				31744},{3,7,19264},{6,7,5393},{2,8,31998},{8,7,3106},{3,8,22370},{8,4,15003},{8,6,8499},{8,5,9335},{8,9,5258},{9,2,37256},{3,9,27628},{7,9,8364},{1,9,40108},{9,5,14593},{2,10,45922},{5,10,23259},{9,10,8666},{10,0,51122},{10,3,36294},{10,4,28927},{11,4,25190},{11,9,4929},{11,8,10187},{11,6,18686},{2,11,42185},{11,3,32557},{1,11,45037}};
//		n = 12;
//		System.out.println(numberWaysToDestination.countPaths(n, roads));
		n = 6;
		roads = new int[][]{{3,0,4},{0,2,3},{1,2,2},{4,1,3},{2,5,5},{2,3,1},{0,4,1},{2,4,6},{4,3,1}};
		System.out.println(numberWaysToDestination.countPaths(n, roads));
//		System.out.println(numberWaysToDestination.countPaths2(n, roads));
	}

	public long add(long a, long b){
		return ((a % 1_000_000_007) + (b % 1_000_000_007)) % 1_000_000_007;
	}

	public int countPaths(int n, int[][] roads) {
		if(roads.length == 0){
			return 1;
		}
		long [][] mem = new long[n][2];
		for(int i = 0; i < mem.length; ++i){
			Arrays.fill(mem[i], -1);
		}
		for(int i = 0; i < mem.length; ++i){
			for(int [] road : roads){
				int min = Math.min(road[0], road[1]);
				int max = Math.max(road[0], road[1]);
				int time = road[2];
				if(i == min){
					long lastTime = mem[min][0];
					if(mem[max][0] == -1){
						if(lastTime == -1){
							mem[max][0] = time;
							mem[max][1] = 1;
						}else{
							long totalTime = add(lastTime, time);
							mem[max][0] = totalTime;
							mem[max][1] = mem[min][1];
						}
					}else{
						if(lastTime == -1){
							continue;
						}
						long totalTime = add(lastTime, time);
						if(mem[max][0] == totalTime){
							mem[max][0] = totalTime;
							mem[max][1] = add(mem[max][1], mem[min][1]);
						}else if(mem[max][0] > totalTime){
							mem[max][0] = totalTime;
							mem[max][1] = mem[min][1];
						}
					}
				}
				if(i == max){
					long lastTime = mem[max][0];
					long totalTime = add(lastTime, time);
					if(mem[min][0] == -1){
						mem[min][0] = totalTime;
						mem[min][1] = 1;
					}else{
						if(mem[min][0] >= totalTime){
							mem[min][0] = totalTime;
							mem[min][1] = add(mem[max][1], mem[min][1]);
							for(int [] rd : roads){
								int mn = Math.min(rd[0], rd[1]);
								int mx = Math.max(rd[0], rd[1]);
								int tm = rd[2];
								if(mn == min){
									long lastTm = mem[mn][0];
									if(mem[mx][0] == -1){
										if(lastTm == -1){
											mem[mx][0] = tm;
											mem[mx][1] = 1;
										}else{
											long totalTm = add(lastTm, tm);
											mem[mx][0] = totalTm;
											mem[mx][1] = mem[mn][1];
										}
									}else{
										if(lastTm == -1){
											continue;
										}
										long totalTm = add(lastTm, tm);
										if(mem[mx][0] == totalTm){
											mem[mx][0] = totalTm;
											mem[mx][1] = add(mem[mx][1], mem[mn][1]);
										}else if(mem[mx][0] > totalTm){
											mem[mx][0] = totalTm;
											mem[mx][1] = mem[mn][1];
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return (int)(mem[n - 1][1] % 1_000_000_007);
	}

	public int countPaths2(int n, int[][] roads) {
		Map<Integer,Vert> vertMap = new HashMap<>();
		Map<Edge,Edge> edgeMap = new HashMap<>();
		for(int [] road : roads){
			vertMap.putIfAbsent(road[0], new Vert(road[0], new ArrayList<>()));
			vertMap.putIfAbsent(road[1], new Vert(road[1], new ArrayList<>()));
			Vert vert = vertMap.get(road[0]);
			Vert vert2 = vertMap.get(road[1]);
			Edge edge = new Edge(road[2], vert, vert2);
			Edge edge2 = new Edge(road[2], vert2, vert);
			vert.edges.add(edge);
			vert2.edges.add(edge2);
			edgeMap.put(edge, edge);
			edgeMap.put(edge2, edge2);
		}
		List<Edge> startingEdges = new ArrayList<>();
		for(int [] road : roads){
			if(road[0] == 0){
				startingEdges.add(edgeMap.get(new Edge(
						road[2],
						new Vert(road[0]),
						new Vert(road[1]))));
			}
			if(road[1] == 0){
				startingEdges.add(edgeMap.get(new Edge(
						road[2],
						new Vert(road[1]),
						new Vert(road[0]))));
			}
		}
		List<Integer> times = new ArrayList<>();
		for(Edge edge : startingEdges){
			List<Edge> processed = new ArrayList<>();
			countPaths(edge, edge.time, n - 1, times, processed);
		}
		if(times.isEmpty()){
			return 0;
		}
		Collections.sort(times);
		int count = 0;
		int last = times.get(0);
		for(int i : times){
			if(last != i){
				break;
			}
			count++;
			last = i;
		}
		return (int)(count % (Math.pow(10, 9)  + 7));
	}

	void countPaths(Edge edge, int time, int n, List<Integer> times, List<Edge> processed){
		if(processed.contains(edge)){
			return;
		}
		if(edge.vert2.value == n){
			times.add(time);
			return;
		}
		processed.add(edge);
		for(Edge e: edge.vert2.edges){
			countPaths(e, time + e.time, n, times, processed);
		}
		processed.remove(edge);
	}

	static class Edge{
		Vert vert;
		Vert vert2;
		int time;
		Edge(int time, Vert vert, Vert vert2){
			this.time = time;
			this.vert = vert;
			this.vert2 = vert2;
		}

		public boolean equals(Object o){
			Edge e = (Edge)o;
			return this.time == e.time
					&& this.vert.equals(e.vert)
					&& this.vert2.equals(e.vert2);
		}

		public int hashCode(){
			return this.time + this.vert.value + this.vert2.value;
		}
	}

	static class Vert{
		int value;
		List<Edge> edges;
		Vert(int value){
			this.value = value;
			this.edges = new ArrayList<>();
		}
		Vert(int value, List<Edge> edges){
			this.value = value;
			this.edges = edges;
		}

		public boolean equals(Object o){
			Vert v = (Vert)o;
			return this.value == v.value;
		}

		public int hashCode(){
			return this.value;
		}
	}

}
