package org.hunter;

import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/word-break/
 */
public class WordBreak{

	public boolean wordBreak(String s, List<String> wordDict) {
		Boolean[][] mem = new Boolean[s.length() + 1][s.length() + 1];
		for(int i = 1; i <= s.length(); ++i){
			boolean found = wordBreak(0, i, s, wordDict, false, mem);
			if(found){
				return true;
			}
		}
		return false;
	}

	private boolean wordBreak(int start, int length, String s, List<String> wordDict, boolean found, Boolean[][] mem){
		if(mem[start][length] != null){
			return mem[start][length];
		}
		if(start + length > s.length()){
			return found;
		}
		String word = s.substring(start, start + length);
		if(wordDict.contains(word)){
			found = true;
			for(int i = 1; i <= s.length(); ++i){
				found = wordBreak(start + length, i, s, wordDict, found, mem);
				mem[start + length][i] = found;
				if(found){
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String [] args){
		WordBreak wordBreak = new WordBreak();
		String s = "applepenapple";
		List<String> wordDict = List.of("apple","pen");

		System.out.println(wordBreak.wordBreak(s, wordDict));

		s = "leetcode";
		wordDict = List.of("leet","code");
		System.out.println(wordBreak.wordBreak(s, wordDict));

		s = "catsandog";
		wordDict = List.of("cats","dog","sand","and","cat"); //false
		System.out.println(wordBreak.wordBreak(s, wordDict));

		s = "a";
		wordDict = List.of("a");
		System.out.println(wordBreak.wordBreak(s, wordDict));

		s = "bb";
		wordDict = List.of("a","b","bbb","bbbb"); //true
		System.out.println(wordBreak.wordBreak(s, wordDict));
	}
}
