package org.hunter;

import java.util.*;

class Calculator2 {

    public int calculate(String s) {
        s = s.replace(" ", "");
        Stack<Integer> stack = new Stack<>();
        Set<Character> ops = Set.of('+', '-', '*', '/');
        int lastNumber = 0;
        char lastOp = '+';
        for(char c : s.toCharArray()){
            if(ops.contains(c)){
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
            }else{
                lastNumber *= 10;
                lastNumber += (c - '0');
            }
        }
        if(lastOp == '+'){
            stack.push(lastNumber);
        }else if(lastOp == '-'){
            stack.push(-lastNumber);
        }else if(lastOp == '*'){
            stack.push(stack.pop() * lastNumber);
        }else{
            stack.push(stack.pop() / lastNumber);
        }
        int ans = 0;
        for(int n : stack){
            ans += n;
        }
        return ans;
    }


}
