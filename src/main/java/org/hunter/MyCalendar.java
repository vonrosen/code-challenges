package org.hunter;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MyCalendar{

	public static void main(String [] args){
		MyCalendar myCalendar = new MyCalendar();
		System.out.println(myCalendar.book(10, 20));
		System.out.println(myCalendar.book(15, 25));
		System.out.println(myCalendar.book(20, 30));

		//[37,50],[33,50],[4,17],[35,48],[8,25]
		myCalendar = new MyCalendar();
		System.out.println(myCalendar.book(37,50));
		System.out.println(myCalendar.book(33,50));
		System.out.println(myCalendar.book(4,17));
		System.out.println(myCalendar.book(35,48));
	}

	private final List<List<Integer>> calendar = new ArrayList<>();

	//N = number times book called. time = O(N^2) space = O(N)
//	public boolean book(int start, int end) {
//		List<Integer> newEvent = new ArrayList<>();
//		newEvent.add(start);
//		newEvent.add(end);
//		if(calendar.isEmpty()){
//			calendar.add(newEvent);
//			return true;
//		}
//		for(List<Integer> event : calendar){
//			if((start >= event.get(0) && start < event.get(1))
//					|| (end > event.get(0) && end <= event.get(1))
//					|| start <= event.get(0) && end >= event.get(1)){
//				return false;
//			}
//		}
//		calendar.add(newEvent);
//		return true;
//	}

	private TreeMap<Integer,Integer> calendar2 = new TreeMap<>();

	public MyCalendar() {
	}

	//N = times book is called. time = O(N * (2 * log(N))) = O(log(N)). space = O(N)
	public boolean book(int start, int end) {
		if(calendar2.isEmpty()){
			calendar2.put(start, end);
			return true;
		}
		 Integer startFloor = calendar2.floorKey(start);
		 if(startFloor == null){
			 if(end <= calendar2.firstKey()){
				 calendar2.put(start, end);
				 return true;
			 }
			 return false;
		 }
		 Integer startCeiling = calendar2.ceilingKey(start);
		 if(startCeiling == null){
			if(start >= calendar2.lastEntry().getValue()){
				calendar2.put(start, end);
				return true;
			}
			return false;
		 }
		if(start >= calendar2.get(startFloor) && end <= startCeiling){
			calendar2.put(start, end);
			return true;
		}
		return false;
	}

	// 6   10

	// 2   4
	// 4   5
	// 10  16
	//

}
