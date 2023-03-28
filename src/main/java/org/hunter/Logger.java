package org.hunter;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/logger-rate-limiter
public class Logger{

	private final Map<String,Integer> store = new HashMap<>();

	public Logger() {
	}

	public boolean shouldPrintMessage(int timestamp, String message) {
			Integer lastTimestamp = store.get(message);
			if(lastTimestamp == null){
				store.put(message, timestamp);
				return true;
			}
			if(lastTimestamp + 10 > timestamp){
				return false;
			}
			store.put(message, timestamp);
			return true;
	}
}
