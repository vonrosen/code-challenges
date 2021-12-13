package org.hunter;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeating{

	/**
	 * "abc" returns 'a'
	 * "cbac" returns 'b'
	 * "aabbccbd" returns 'd'
	 * @param args
	 */
	public static void main(String [] args){
		System.out.println(firstNonRepeating("abc"));
		System.out.println(firstNonRepeating("cbac"));
		System.out.println(firstNonRepeating("aabbccbd"));
	}

	//time = O(2N)=O(N) space = O(N)
	public static Character firstNonRepeating(String s){
		Map<Character,Integer> m = new LinkedHashMap<>();
		for (Character c : s.toCharArray()){
			m.putIfAbsent(c, 0);
			m.put(c, m.get(c) + 1);
		}

		for(Character c: m.keySet()){
			if(m.get(c) == 1){
				return c;
			}
		}

		return null;
	}

}
