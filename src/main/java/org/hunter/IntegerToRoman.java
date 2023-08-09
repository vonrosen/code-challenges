package org.hunter;

import java.util.Map;

public class IntegerToRoman{

	public static void main(String [] args){
		IntegerToRoman integerToRoman = new IntegerToRoman();
		System.out.println(integerToRoman.intToRoman(3));
		System.out.println(integerToRoman.intToRoman(58));
		System.out.println(integerToRoman.intToRoman(1994));
	}

	/**
	 * I             1
	 * V             5
	 * X             10
	 * L             50
	 * C             100
	 * D             500
	 * M             1000
	 * @param num
	 * @return
	 */
	public String intToRoman(int num) {
		Map<String,Integer> map = Map.of("I", 1,
				"V", 5,
				"X", 10,
				"L", 50,
				"C", 100,
				"D", 500,
				"M", 1000);
		StringBuffer roman = new StringBuffer();
		Integer rem = build(map, "M", num, roman);
		rem = build(map, "D", rem, roman);
		rem = build(map, "C", rem, roman);
		rem = build(map, "L", rem, roman);
		rem = build(map, "X", rem, roman);
		rem = build(map, "V", rem, roman);
		build(map, "I", rem, roman);
		return roman.toString();
	}

	Integer build(Map<String, Integer> map, String numeral, Integer num, StringBuffer roman){
		int value = map.get(numeral);
		if(value > num){
			return num;
		}
		if(String.valueOf(num).startsWith("9")){
			int length = String.valueOf(num).length();
			if(length == 3){
				roman.append("CM");
				return num % 900;
			}
			if(length == 2){
				roman.append("XC");
				return num % 90;
			}
			if(length == 1){
				roman.append("IX");
				return num % 9;
			}
		}
		if(String.valueOf(num).startsWith("4")){
			int length = String.valueOf(num).length();
			if(length == 3){
				roman.append("CD");
				return num % 400;
			}
			if(length == 2){
				roman.append("XL");
				return num % 40;
			}
			if(length == 1){
				roman.append("IV");
				return num % 4;
			}
		}
		int rem = num % value;
		int value2 = num - rem;
		int times = value2 / value;
		for(int i = 0; i < times; ++i){
			roman.append(numeral);
		}
		return rem;
	}

}
