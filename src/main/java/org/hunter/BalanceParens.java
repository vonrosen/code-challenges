package org.hunter;

import java.util.Stack;

import com.sun.tools.javac.util.Assert;

public class BalanceParens{

	public static void main(String [] args){
		String s1 = "{{{{{{{{";
		String s2 = "}";
		String s3 = "((}}}";

		Assert.check(balanced(s1) == false);
		Assert.check(balanced(s2) == false);
		Assert.check(balanced(s3) == false);
	}

	public static boolean balanced(String s){
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < s.length(); ++i){
			Character c = s.charAt(i);
			if (c == '{' || c == '[' || c == '('){
				stack.push(c);
				continue;
			}

			if (c == '}' || c == ']' || c == ')'){
				if(stack.size() == 0){
					return false;
				}
				Character popped = stack.pop();
				if(popped.charValue() != c){
					return false;
				}
				continue;
			}
		}
		return stack.size() == 0;
	}

}
