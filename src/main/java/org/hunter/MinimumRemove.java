package org.hunter;

import java.util.Stack;

public class MinimumRemove {

    record Holder(
            char c,
            int index
    ){}

    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Holder> stack = new Stack<>();
        for(int i = 0; i < sb.length(); ++i) {
            char c = sb.charAt(i);
            if(c == '(') {
                stack.push(new Holder(c, i));
            }else if (c == ')') {
                if(!stack.isEmpty()) {
                    if(stack.peek().c == '(') {
                        stack.pop();
                    }else {
                        stack.push(new Holder(c, i));
                    }
                }else {
                    stack.push(new Holder(c, i));
                }
            }
        }
        while(!stack.isEmpty()) {
            Holder h = stack.pop();
            sb.delete(h.index, h.index + 1);
        }
        return sb.toString();
    }


}
