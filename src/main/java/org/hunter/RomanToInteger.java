package org.hunter;

import java.util.Map;

public class RomanToInteger{

	public static void main(String [] args){
		RomanToInteger romanToInteger = new RomanToInteger();
		System.out.println(romanToInteger.romanToInt("X"));
		System.out.println(romanToInteger.romanToInt("XV"));
		System.out.println(romanToInteger.romanToInt("XIV"));
		System.out.println(romanToInteger.romanToInt("MCMXCIV"));
	}

	public int romanToInt(String s) {
		Map<Character,Integer> map = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);
		int sum = 0;
		int lastValue = Integer.MAX_VALUE;
		for(Character c : s.toCharArray()){
			int value = map.get(c);
			if(lastValue < value){
				sum += (value - (2 * lastValue));
			}else{
				sum += value;
			}
			lastValue = value;
		}
		return sum;
	}

}
