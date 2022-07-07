package org.hunter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParenthesis{

	public List<String> generateParenthesis(int n) {
		List<HashSet<String>> parens = new ArrayList<>();
		generateParenthesis(1, n, parens);
		return new ArrayList<>(parens.get(n - 1));
	}

	public void generateParenthesis(int p, int n, List<HashSet<String>> parens){
		if(p > n){
			return;
		}

		if(p == 1){
			HashSet<String> set = new HashSet<>();
			set.add("()");
			parens.add(set);
		}else{
			HashSet<String> set = new HashSet<>();
			for(String s : parens.get(p - 2)){
				set.add("(" + s + ")");
			}

			int count = 1;
			for(HashSet<String> prevSet : parens){
				int count2 = 1;
				for(HashSet<String> prevSet2 : parens){
					if(count + count2 == p){
						for(String s : prevSet){
							for(String s2 : prevSet2){
								set.add(s + s2);
								set.add(s2 + s);
							}
						}
					}
					++count2;
				}
				++count;
			}
			parens.add(set);
		}

		generateParenthesis(p + 1, n, parens);
	}

	public static void main(String [] args){
		GenerateParenthesis generateParenthesis = new GenerateParenthesis();
		System.out.println(generateParenthesis.generateParenthesis(8));
	}

}
