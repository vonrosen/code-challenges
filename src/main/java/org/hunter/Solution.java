package org.hunter;

import java.util.Stack;

public class Solution {

	/**
	 * Write a function called "balanced" which takes
	 * a String input which is an expression and determines if the
	 * expression is balanced. it will return true if balanced and
	 * false otherwise
	 * the characters to balance are these:
	 * {", "[", "(", "}", "]", ")
	 * each open char must be matched in correct order
	 * with a corresponding close char
	 * for example "(a)" is a balanced expression
	 * but "{a)" is not a balanced expression
	 * other examples are:

	 "(a)(b)"; //true balanced
	 "(d{b}{b}d)"; //true balanced
	 "{x})"; //false not balanced

	 * try to think about edge cases too and come
	 * up with same example input expressions for
	 * edge cases
	 *
	 * static boolean balanced(String expression)
	 */

//	static boolean balanced(String expression) {
//
//	}

	public static void main(String[] args) {
		String s1 = "(a)(b)"; //true
		String s2 = "(d{b}{b}d)"; //true
		String s3 = "{x})"; //false
		System.out.println(balanced(s1));
		System.out.println(balanced(s2));
		System.out.println(balanced(s3));
	}

	static boolean balanced(String expression) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < expression.length(); ++i){
			char currentChar = expression.charAt(i);
			if(currentChar == '('
					 || currentChar == '{'
					 || currentChar == '['){
				 stack.push(currentChar);
			}
			if((currentChar == ')' || currentChar == ']' || currentChar == '}') && stack.isEmpty()){
				return false;
			}
			if(currentChar == ')' && stack.peek() == '('){
				stack.pop();
			}
			if(currentChar == '}' && stack.peek() == '{'){
				stack.pop();
			}
			if(currentChar == ']' && stack.peek() == '['){
				stack.pop();
			}
		}
		return stack.isEmpty();
	}

}
