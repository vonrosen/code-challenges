package org.hunter;

import java.util.Set;
import java.util.Stack;

public class BasicCalculator3 {

    public static void main(String [] args) {
        BasicCalculator3 basicCalculator3 = new BasicCalculator3();
//        System.out.println(basicCalculator3.calculate("(2+6*3+5-(3*14/7+2)*5)+3"));
        System.out.println(basicCalculator3.calculate("1-(2+3-(4+(5-(1-(2+4-(5+6))))))"));
        System.out.println(basicCalculator3.calculate("(2+6*3+5-(3*14/7+2)*5)+3"));
//          System.out.println(basicCalculator3.calculate("1*(7-9)"));//1*-2
    }

    //1*(9-7)

    Set<Character> ops = Set.of('+', '-', '*', '/');

    public int calculate(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        stack.push(new StringBuilder());
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(new StringBuilder());
            }else if (c == ')') {
                StringBuilder lastSb = stack.pop();
                if(!lastSb.isEmpty()) {
                    int result = calculateNoParen(lastSb.toString());
                    if(result < 0) {
                        stack.peek().append("&" + (-result));
                    }else {
                        stack.peek().append(result);
                    }
                }
            }else if(i == 0) {
                stack.push(new StringBuilder());
                stack.peek().append(c);
            }
            else {
                stack.peek().append(c);
            }
        }
        return calculateNoParen(stack.pop().toString());
    }

    public int calculateNoParen(String s) {
        StringBuilder lastNumberString = new StringBuilder();
        char lastOp = '+';
        char curOp;
        int sum = 0, prod = 1;
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                lastNumberString.append(c);
            }
            if(c == '&'){
                lastNumberString.append("-");
            }
            if (ops.contains(c) || i == s.length() - 1){
                int lastNumber = Integer.parseInt(lastNumberString.toString());
                if (lastOp == '-') {
                    lastNumber = -lastNumber;
                }
                curOp = c;
                if(curOp == '*' || curOp == '/') {
                    if (lastOp == '/') {
                        prod /= lastNumber;
                    }else {
                        prod *= lastNumber;
                    }
                }else {
                    if (lastOp == '*') {
                        prod *= lastNumber;
                        sum += prod;
                    }else if (lastOp == '/') {
                        prod /= lastNumber;
                        sum += prod;
                    }else {
                        sum += lastNumber;
                    }
                    prod = 1;
                }
                lastOp = curOp;
                lastNumberString = new StringBuilder();
            }
        }
        return sum;
    }
}
