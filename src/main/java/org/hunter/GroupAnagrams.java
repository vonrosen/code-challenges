package org.hunter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/group-anagrams/submissions/
public class GroupAnagrams{

	public static void main(String [] args){
		String strs [] = {"eat","tea","tan","ate","nat","bat"};
		GroupAnagrams groupAnagrams = new GroupAnagrams();
		System.out.println(groupAnagrams.groupAnagrams(strs));
		String strs2 [] = {"",""};
		System.out.println(groupAnagrams.groupAnagrams(strs2));
		String [] strs3 = {"","b"};
		System.out.println(groupAnagrams.groupAnagrams(strs3));
		String [] str4 = {"ddddddddddg","dgggggggggg"};
		System.out.println(groupAnagrams.groupAnagrams(str4));
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> groups = new ArrayList<>();
		if(strs.length == 1){
			groups.add(List.of(strs[0]));
			return groups;
		}
		String [] tmpStrings = new String[strs.length];
		Map<String,List<Integer>> map = new LinkedHashMap<>();
		for(int i = 0; i < strs.length; ++i){
			char[] sorted = strs[i].toCharArray();
			Arrays.sort(sorted);
			tmpStrings[i] = new String(sorted);
			if(map.get(tmpStrings[i]) == null){
				map.put(tmpStrings[i], new ArrayList<>(List.of(i)));
			}else{
				List<Integer> list = map.get(tmpStrings[i]);
				list.add(i);
				map.put(tmpStrings[i], list);
			}
		}

		for(String s : map.keySet()){
			List<String> anagrams = new ArrayList<>();
			List<Integer> l = map.get(s);
			for(Integer i : l){
				anagrams.add(strs[i]);
			}
			groups.add(anagrams);
		}

		return groups;
	}

}
