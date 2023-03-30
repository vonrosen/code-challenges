package org.hunter;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar{

	public static void main(String [] args){
		MyCalendar myCalendar = new MyCalendar();
		System.out.println(myCalendar.book(10, 20)); // return True
		System.out.println(myCalendar.book(15, 25)); // return False, It can not be booked because time 15 is already
		// booked by another event.
		System.out.println(myCalendar.book(20, 30));
	}

	private final List<List<Integer>> calendar = new ArrayList<>();

	public MyCalendar() {
	}

	public boolean book(int start, int end) {
		List<Integer> newEvent = new ArrayList<>();
		newEvent.add(start);
		newEvent.add(end);
		if(calendar.isEmpty()){
			calendar.add(newEvent);
			return true;
		}
		for(List<Integer> event : calendar){
			if((start >= event.get(0) && start < event.get(1))
					|| (end > event.get(0) && end <= event.get(1))
					|| start <= event.get(0) && end >= event.get(1)){
				return false;
			}
		}
		calendar.add(newEvent);
		return true;
	}

}
