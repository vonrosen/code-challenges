package org.hunter;

import java.util.HashMap;
import java.util.Map;

public class PrintPaths{

	public static void main(String [] args){
		String [] paths = new String[]{
				"/a/b/c/d",
				"/a/b/c/e",
				"/a/x/f/",
				"/a/x/c/e",
				"/b/f",
		};
		Map<String,Object> root = new HashMap<>();
		for(String path: paths){
			Map<String,Object> nextMap = root;
			int counter = 0;
			String [] segments = path.substring(1).split("/");
			for(String segment : segments){
				boolean isFolder = counter < segments.length - 1 || path.endsWith("/");
				Map<String,Object> map = (Map<String,Object>)nextMap.get(segment);
				if(map == null){
					Map<String,Object> newMap = new HashMap<>();
					nextMap.put(segment, isFolder ? newMap : null);
					nextMap = newMap;
				}else{
					nextMap = map;
				}
				counter++;
			}
		}
		print(root, 0);
	}

	static void print(Map<String,Object> map, int indent){
		if(map == null){
			return;
		}
		for(String segment: map.keySet()){
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < indent; ++i){
				sb.append(" ");
			}
			sb.append(segment);
			Map<String,Object> nextMap = (Map<String,Object>)map.get(segment);
			if(nextMap == null){
				sb.append(" : file");
			}else if(nextMap.isEmpty()){
				sb.append(" : folder");
			}
			System.out.println(sb.toString());
			print((Map<String,Object>)map.get(segment), indent + 2);
		}
	}

}
