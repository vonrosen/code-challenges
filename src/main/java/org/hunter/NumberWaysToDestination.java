package org.hunter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/
 */
public class NumberWaysToDestination{

	public static void main(String [] args){
		NumberWaysToDestination numberWaysToDestination = new NumberWaysToDestination();
		int [][] roads = new int[][]{{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
		int n = 7;
		System.out.println(numberWaysToDestination.countPaths3(n, roads));
		roads = new int[][]{{1,0,10}};
		n = 2;
		System.out.println(numberWaysToDestination.countPaths3(n, roads));
		roads = new int[][]{{1,0,2348},{2,1,2852},{2,0,5200},{3,1,12480},{2,3,9628},{4,3,7367},{4,0,22195},{5,4,5668},
		{1,5,
			25515},{0,5,27863},{6,5,836},{6,0,28699},{2,6,23499},{6,3,13871},{1,6,26351},{5,7,6229},{2,7,28892},{1,7,
				31744},{3,7,19264},{6,7,5393},{2,8,31998},{8,7,3106},{3,8,22370},{8,4,15003},{8,6,8499},{8,5,9335},{8,9,5258},{9,2,37256},{3,9,27628},{7,9,8364},{1,9,40108},{9,5,14593},{2,10,45922},{5,10,23259},{9,10,8666},{10,0,51122},{10,3,36294},{10,4,28927},{11,4,25190},{11,9,4929},{11,8,10187},{11,6,18686},{2,11,42185},{11,3,32557},{1,11,45037}};
		n = 12;
		System.out.println(numberWaysToDestination.countPaths3(n, roads));
		roads = new int[][]{{0,3,3},{0,2,1},{1,2,1},{1,3,1}};
		n = 4;
		System.out.println(numberWaysToDestination.countPaths3(n, roads));
		n = 6;
		roads = new int[][]{{3,0,4},{0,2,3},{1,2,2},{4,1,3},{2,5,5},{2,3,1},{0,4,1},{2,4,6},{4,3,1}};
		System.out.println(numberWaysToDestination.countPaths3(n, roads));
		roads = new int[][]{{0,1,4},{0,7,8},{1,7,11},{1,2,8},{7,6,1},{7,8,7},{2,8,2},{8,6,6},{2,5,4},{2,3,7},{6,5,2},
				{3,5,14},{3,4,9},{5,4,10}};
		n = 14;
		System.out.println(numberWaysToDestination.countPaths3(n, roads));
		roads = new int[][]{{0,1,865326231},{1,4,865326231},{0,2,865326231},{2,4,865326231},{0,3,865326231},{3,4,865326231},{4,5,
				647618270},{5,9,647618270},{4,6,647618270},{6,9,647618270},{4,7,647618270},{7,9,647618270},{4,8,647618270},{8,9,647618270},{9,10,153310768},{10,15,153310768},{9,11,153310768},{11,15,153310768},{9,12,153310768},{12,15,153310768},{9,13,153310768},{13,15,153310768},{9,14,153310768},{14,15,153310768},{15,16,446216658},{16,21,446216658},{15,17,446216658},{17,21,446216658},{15,18,446216658},{18,21,446216658},{15,19,446216658},{19,21,446216658},{15,20,446216658},{20,21,446216658},{21,22,482432125},{22,27,482432125},{21,23,482432125},{23,27,482432125},{21,24,482432125},{24,27,482432125},{21,25,482432125},{25,27,482432125},{21,26,482432125},{26,27,482432125},{27,28,546917635},{28,32,546917635},{27,29,546917635},{29,32,546917635},{27,30,546917635},{30,32,546917635},{27,31,546917635},{31,32,546917635},{32,33,905837683},{33,37,905837683},{32,34,905837683},{34,37,905837683},{32,35,905837683},{35,37,905837683},{32,36,905837683},{36,37,905837683},{37,38,941383964},{38,41,941383964},{37,39,941383964},{39,41,941383964},{37,40,941383964},{40,41,941383964},{41,42,482278242},{42,44,482278242},{41,43,482278242},{43,44,482278242},{44,45,209029963},{45,49,209029963},{44,46,209029963},{46,49,209029963},{44,47,209029963},{47,49,209029963},{44,48,209029963},{48,49,209029963},{49,50,180362920},{50,53,180362920},{49,51,180362920},{51,53,180362920},{49,52,180362920},{52,53,180362920},{53,54,40040617},{54,58,40040617},{53,55,40040617},{55,58,40040617},{53,56,40040617},{56,58,40040617},{53,57,40040617},{57,58,40040617},{58,59,429647103},{59,62,429647103},{58,60,429647103},{60,62,429647103},{58,61,429647103},{61,62,429647103},{62,63,863858638},{63,64,250353988},{64,66,250353988},{63,65,250353988},{65,66,250353988},{66,67,502785687},{67,68,565934645},{68,69,548158326},{69,74,548158326},{68,70,548158326},{70,74,548158326},{68,71,548158326},{71,74,548158326},{68,72,548158326},{72,74,548158326},{68,73,548158326},{73,74,548158326},{74,75,858926247},{75,79,858926247},{74,76,858926247},{76,79,858926247},{74,77,858926247},{77,79,858926247},{74,78,858926247},{78,79,858926247},{79,80,610164528},{80,82,610164528},{79,81,610164528},{81,82,610164528},{82,83,116910438},{83,84,153203278},{84,88,153203278},{83,85,153203278},{85,88,153203278},{83,86,153203278},{86,88,153203278},{83,87,153203278},{87,88,153203278},{88,89,484666281},{89,93,484666281},{88,90,484666281},{90,93,484666281},{88,91,484666281},{91,93,484666281},{88,92,484666281},{92,93,484666281},{93,94,694001013},{94,95,180373702},{95,96,392438425},{96,97,392438425},{97,98,915720722},{98,99,915720722},{99,100,660886218},{100,101,980566840},{101,103,980566840},{100,102,980566840},{102,103,980566840},{103,104,509703517},{104,105,817920401},{105,106,992341639},{106,107,992341639},{107,108,180854348},{108,111,180854348},{107,109,180854348},{109,111,180854348},{107,110,180854348},{110,111,180854348},{111,112,699029750},{112,115,699029750},{111,113,699029750},{113,115,699029750},{111,114,699029750},{114,115,699029750},{115,116,973634138},{116,120,973634138},{115,117,973634138},{117,120,973634138},{115,118,973634138},{118,120,973634138},{115,119,973634138},{119,120,973634138},{120,121,785570880},{121,125,785570880},{120,122,785570880},{122,125,785570880},{120,123,785570880},{123,125,785570880},{120,124,785570880},{124,125,785570880},{125,126,720521316},{126,130,720521316},{125,127,720521316},{127,130,720521316},{125,128,720521316},{128,130,720521316},{125,129,720521316},{129,130,720521316},{130,131,829375409},{131,132,152165056},{132,133,152165056},{133,134,50370340},{134,137,50370340},{133,135,50370340},{135,137,50370340},{133,136,50370340},{136,137,50370340},{137,138,704034877},{138,139,484468238},{139,143,484468238},{138,140,484468238},{140,143,484468238},{138,141,484468238},{141,143,484468238},{138,142,484468238},{142,143,484468238},{143,144,205433987},{144,145,205433987},{145,146,166956493},{146,149,166956493},{145,147,166956493},{147,149,166956493},{145,148,166956493},{148,149,166956493},{149,150,476307189},{150,151,388217973},{151,152,388217973},{152,153,211490211},{153,155,211490211},{152,154,211490211},{154,155,211490211},{155,156,186981143},{156,160,186981143},{155,157,186981143},{157,160,186981143},{155,158,186981143},{158,160,186981143},{155,159,186981143},{159,160,186981143},{160,161,305206923},{161,166,305206923},{160,162,305206923},{162,166,305206923},{160,163,305206923},{163,166,305206923},{160,164,305206923},{164,166,305206923},{160,165,305206923},{165,166,305206923},{166,167,482432170},{167,171,482432170},{166,168,482432170},{168,171,482432170},{166,169,482432170},{169,171,482432170},{166,170,482432170},{170,171,482432170},{171,172,455923183},{172,177,455923183},{171,173,455923183},{173,177,455923183},{171,174,455923183},{174,177,455923183},{171,175,455923183},{175,177,455923183},{171,176,455923183},{176,177,455923183},{177,178,266584262},{178,179,266584262},{179,180,751579148},{180,185,751579148},{179,181,751579148},{181,185,751579148},{179,182,751579148},{182,185,751579148},{179,183,751579148},{183,185,751579148},{179,184,751579148},{184,185,751579148},{185,186,389984057},{186,188,389984057},{185,187,389984057},{187,188,389984057},{188,189,926312609},{189,192,926312609},{188,190,926312609},{190,192,926312609},{188,191,926312609},{191,192,926312609},{192,193,323360653},{193,196,323360653},{192,194,323360653},{194,196,323360653},{192,195,323360653},{195,196,323360653},{196,197,977934872},{197,198,977934872},{198,199,434009290}};
		n = 200;
//		expected = 940420443 WTF? this is wrong!
		System.out.println(numberWaysToDestination.countPaths3(n, roads));
	}

	public long add(long a, long b){
		return ((a % 1_000_000_007) + (b % 1_000_000_007)) % 1_000_000_007;
	}

	public int countPaths3(int n, int[][] roads) {
		if(roads.length == 0){
			return 1;
		}

		Queue<Vert> verts = new PriorityQueue<>(1000,
				Comparator.comparing(Vert::getDistanceFromSource));
		Map<Integer, Vert> vertMap = new HashMap<>();
		for(int [] road : roads){
			Vert vert = new Vert(road[0], new ArrayList<>());
			Vert vert2 = new Vert(road[1], new ArrayList<>());
			if(vert.value == 0){
				vert.distanceFromSource = 0L;
			}
			if(vert2.value == 0){
				vert2.distanceFromSource = 0L;
			}
			if(vertMap.get(vert.value) != null){
				vert = vertMap.get(vert.value);
			}else{
				verts.add(vert);
				vertMap.put(vert.value, vert);
			}
			if(vertMap.get(vert2.value) != null){
				vert2 = vertMap.get(vert2.value);
			}else{
				verts.add(vert2);
				vertMap.put(vert2.value, vert2);
			}
			Edge edge = new Edge(road[2], vert, vert2);
			Edge edge2 = new Edge(road[2], vert2, vert);
			vert.edges.add(edge);
			vert2.edges.add(edge2);
		}
		Map<Vert, Vert> sptSet = new HashMap<>();
		long [] count = new long[n];
		count[0] = 1;
		while(!verts.isEmpty()){
			Vert vert = verts.poll();
			if(sptSet.get(vert) != null){
				continue;
			}
			sptSet.put(vert, vert);
			for(Edge edge : vert.getEdges()){
				long totalTime = add(vert.distanceFromSource, edge.time);
				if(totalTime < edge.vert2.distanceFromSource){
					edge.vert2.distanceFromSource =  totalTime;
					verts.remove(edge.vert2);
					verts.add(edge.vert2);
					count[edge.vert2.value] = count[vert.value];
				}else if(totalTime == edge.vert2.distanceFromSource){
					count[edge.vert2.value] = add(count[edge.vert2.value], count[vert.value]);
				}
			}
		}
		return (int)add(count[n - 1], 0);
	}

//	public int countPaths(int n, int[][] roads) {
//		if(roads.length == 0){
//			return 1;
//		}
//
//		long [][] mem = new long[n + 1][2];
//		for(int i = 0; i < mem.length; ++i){
//			Arrays.fill(mem[i], -1);
//		}
//
//		for(int i = 0; i < mem.length; ++i){
//			for(int [] road : roads){
//				int min = Math.min(road[0], road[1]);
//				int max = Math.max(road[0], road[1]);
//				int time = road[2];
//
//				if(i == min){
//					long lastTime = mem[min][0];
//					if(mem[max][0] == -1){
//						if(lastTime == -1){
//							mem[max][0] = time;
//							mem[max][1] = 1;
//						}else{
//							long totalTime = add(lastTime, time);
//							mem[max][0] = totalTime;
//							mem[max][1] = mem[min][1];
//						}
//					}else{
//						if(lastTime == -1){
//							lastTime = mem[max][0];
//							mem[min][0] = add(lastTime, time);
//							mem[min][1] = 1;
//						}else{
//							long totalTime = add(lastTime, time);
//							if(mem[max][0] == totalTime){
//								mem[max][0] = totalTime;
//								mem[max][1] = add(mem[max][1], mem[min][1]);
//							}else if(mem[max][0] > totalTime){
//								mem[max][0] = totalTime;
//								mem[max][1] = mem[min][1];
//							}
//						}
//					}
//				}
//			}
//		}
//		return (int)(mem[n - 1][1] % 1_000_000_007);
//	}
//
//	public int countPaths2(int n, int[][] roads) {
//		Map<Integer,Vert> vertMap = new HashMap<>();
//		Map<Edge,Edge> edgeMap = new HashMap<>();
//		for(int [] road : roads){
//			vertMap.putIfAbsent(road[0], new Vert(road[0], new ArrayList<>()));
//			vertMap.putIfAbsent(road[1], new Vert(road[1], new ArrayList<>()));
//			Vert vert = vertMap.get(road[0]);
//			Vert vert2 = vertMap.get(road[1]);
//			Edge edge = new Edge(road[2], vert, vert2);
//			Edge edge2 = new Edge(road[2], vert2, vert);
//			vert.edges.add(edge);
//			vert2.edges.add(edge2);
//			edgeMap.put(edge, edge);
//			edgeMap.put(edge2, edge2);
//		}
//		List<Edge> startingEdges = new ArrayList<>();
//		for(int [] road : roads){
//			if(road[0] == 0){
//				startingEdges.add(edgeMap.get(new Edge(
//						road[2],
//						new Vert(road[0]),
//						new Vert(road[1]))));
//			}
//			if(road[1] == 0){
//				startingEdges.add(edgeMap.get(new Edge(
//						road[2],
//						new Vert(road[1]),
//						new Vert(road[0]))));
//			}
//		}
//		List<Integer> times = new ArrayList<>();
//		for(Edge edge : startingEdges){
//			Map<Edge,Edge> processed = new HashMap<>();
//			countPaths(edge, edge.time, n - 1, times, processed);
//		}
//		if(times.isEmpty()){
//			return 0;
//		}
//		Collections.sort(times);
//		int count = 0;
//		int last = times.get(0);
//		for(int i : times){
//			if(last != i){
//				break;
//			}
//			count++;
//			last = i;
//		}
//		return (int)(count % (Math.pow(10, 9)  + 7));
//	}
//
//	void countPaths(Edge edge, int time, int n, List<Integer> times, Map<Edge,Edge> processed){
//		if(processed.get(edge) != null){
//			return;
//		}
//		if(edge.vert2.value == n){
//			times.add(time);
//			return;
//		}
//		processed.put(edge, edge);
//		for(Edge e: edge.vert2.edges){
//			countPaths(e, time + e.time, n, times, processed);
//		}
//		processed.remove(edge);
//	}

	class Edge{
		public Vert vert;
		public Vert vert2;
		public int time;
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

	class Vert{
		int value;
		long distanceFromSource = Long.MAX_VALUE;
		List<Edge> edges;

		Vert(int value){
			this.value = value;
			this.edges = new ArrayList<>();
		}

		Vert(int value, List<Edge> edges){
			this.value = value;
			this.edges = edges;
		}

		public int getValue(){
			return value;
		}

		public long getDistanceFromSource(){
			return distanceFromSource;
		}

		public List<Edge> getEdges(){
			return edges;
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
