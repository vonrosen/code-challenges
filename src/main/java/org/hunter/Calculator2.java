package org.hunter;

import java.util.*;

class Calculator2 {

    public int calculate(String s) {
        s = s.replace(" ", "");
        Stack<Integer> stack = new Stack<>();
        Set<Character> ops = Set.of('+', '-', '*', '/');
        int lastNumber = 0;
        char lastOp = '+';
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            if(!ops.contains(c)){
                lastNumber *= 10;
                lastNumber += (c - '0');
            }
            if(ops.contains(c) || i == s.length() - 1){
                if(lastOp == '+'){
                   stack.push(lastNumber);
                }else if(lastOp == '-'){
                    stack.push(-lastNumber);
                }else if(lastOp == '*'){
                    stack.push(stack.pop() * lastNumber);
                }else{
                    stack.push(stack.pop() / lastNumber);
                }
                lastNumber = 0;
                lastOp = c;
            }
        }
        int ans = 0;
        for(int n : stack){
            ans += n;
        }
        return ans;
    }


}
