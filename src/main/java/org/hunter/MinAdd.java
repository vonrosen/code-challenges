package org.hunter;

import java.util.Stack;

public class MinAdd {


    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int closedRemaining = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            }else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }else {
                    closedRemaining++;
                }
            }
        }
        return stack.size() + closedRemaining;
    }
}
