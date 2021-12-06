package org.hunter;

import java.util.Stack;

public class BalanceParens{

	public static void main(String [] args) throws Exception{
		String s1 = "{{{{{{{{";
		String s2 = "}";
		String s3 = "((}}}"; //} ((
		String s4 = "({[]})"; //] [{(
		String s5 = "({}[]{})";
		String s6 = "({[]})[]{}()";

		if(balanced(s1) != false){
			bad();
		}

		if(balanced(s2) != false){
			bad();
		}

		if(balanced(s3) != false){
			bad();
		}

		if(balanced(s4) != true){
			bad();
		}

		if(balanced(s5) != true){
			bad();
		}

		if(balanced(s6) != true){
			bad();
		}

		good();
	}

	private static void bad() throws Exception{
		throw new Exception("bad!!!!");
	}

	private static void good(){
		System.out.println("PASSED!");
	}

	//time=O(n), space=O(n)
	public static boolean balanced(String s){
		Stack<Character> stack = new Stack<>();
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
				if(c == '}' && popped.charValue() != '{'){
					return false;
				}

				if(c == ']' && popped.charValue() != '['){
					return false;
				}

				if(c == ')' && popped.charValue() != '('){
					return false;
				}

				continue;
			}
		}
		return stack.size() == 0;
	}

}
