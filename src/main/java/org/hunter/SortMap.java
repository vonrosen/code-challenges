package org.hunter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class SortMap{

	public static void main(String[] args){
		Map<Integer,Integer> map = new HashMap<>();
		map.put(891,3);
		map.put(2,3);
		map.put(1,5);
		map.put(3,5);
		map.put(4,6);
		map.put(5,6);
    //sort by value desc, then group within each value set by key desc
		//[[5, 4], [3, 1], [891, 2]]
		Comparator<Integer> desc = (i1, i2) -> {
			if(i2 > i1){
				return 1;
			}
			if(i1 > i2){
				return -1;
			}
			return 0;
		};
		//o(nlogn)
		TreeMap<Integer,PriorityQueue<Integer>> treeMap = new TreeMap<>(desc);
		for(int key : map.keySet()){
			int value = map.get(key);
			treeMap.putIfAbsent(value, new PriorityQueue<>(desc));
			treeMap.get(value).add(key);
		}
		List<List<Integer>> list = new ArrayList<>();
		//o(nlogn)
		for(int key : treeMap.keySet()){
			List<Integer> l = new ArrayList<>();
			var queue = treeMap.get(key);
			while(!queue.isEmpty()){
				l.add(queue.remove());
			}
			list.add(l);
		}
		System.out.println(list);
	}

}
