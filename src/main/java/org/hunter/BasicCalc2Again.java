package org.hunter;

import java.util.Set;
import java.util.Stack;

public class BasicCalc2Again {



    //3+5*4+9/3 + 2
    //3*5
    public static void main(String [] args) {
        BasicCalc2Again b = new BasicCalc2Again();
        System.out.println(b.calculate("3+4*4+2"));
    }


    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        int length = s.length();
        int currentNumber = 0, lastNumber = 0, result = 0;
        char operation = '+';
        for (int i = 0; i < length; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == length - 1) {
                if (operation == '+' || operation == '-') {
                    result += lastNumber;
                    lastNumber = (operation == '+') ? currentNumber : -currentNumber;
                } else if (operation == '*') {
                    lastNumber = lastNumber * currentNumber;
                } else if (operation == '/') {
                    lastNumber = lastNumber / currentNumber;
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        result += lastNumber;
        return result;
    }


    public int calculate2(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Character> ops = Set.of('+', '-', '*', '/');
        char lastOp = '+';
        StringBuilder lastNum = new StringBuilder();
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if(c == ' ') {
                continue;
            }
            if(ops.contains(c)) {
                int lastNumInt = Integer.parseInt(lastNum.toString());
                if(lastOp =='-') {
                    lastNumInt = -lastNumInt;
                }
                if(lastOp == '+' || lastOp == '-') {
                    stack.push(lastNumInt);
                }else if(lastOp == '*') {
                    if(!stack.isEmpty()) {
                        stack.push(stack.pop() * lastNumInt);
                    }
                }else if(lastOp == '/') {
                    stack.push(stack.pop() / lastNumInt);
                }
                lastOp = c;
                lastNum = new StringBuilder();
            }else{
                lastNum.append(c);
            }
        }
        int lastNumInt = Integer.parseInt(lastNum.toString());
        if(lastOp =='-') {
            lastNumInt = -lastNumInt;
        }
        if(lastOp == '+' || lastOp == '-') {
            stack.push(lastNumInt);
        }else if(lastOp == '*') {
            if(!stack.isEmpty()) {
                stack.push(stack.pop() * lastNumInt);
            }
        }else if(lastOp == '/') {
            stack.push(stack.pop() / lastNumInt);
        }
        int ans = 0;
        for(int num : stack) {
            ans += num;
        }
        return ans;
    }
}
