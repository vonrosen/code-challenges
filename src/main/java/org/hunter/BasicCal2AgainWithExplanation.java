package org.hunter;

import java.util.Set;

public class BasicCal2AgainWithExplanation {

    public static void main(String [] args) {
        BasicCal2AgainWithExplanation basicCal2Again = new BasicCal2AgainWithExplanation();
//        System.out.println(basicCal2Again.calculate("3+2*2"));
        System.out.println(basicCal2Again.calculate(" 3/2 "));
//        System.out.println(basicCal2Again.calculate("1-1"));
//        System.out.println(basicCal2Again.calculate("2*3-4"));
//        System.out.println(basicCal2Again.calculate("12-3*4"));
//        System.out.println(basicCal2Again.calculate("2*3*4"));
//        System.out.println(basicCal2Again.calculate("14/3*2"));
//        System.out.println(basicCal2Again.calculate("14/3/2"));
//        System.out.println(basicCal2Again.calculate("1*2+3*4"));
    }

    /**
     * key takeaways:
     * - do the logic when an op is detected not a number
     * - for constant space must check current op in addition to last op
     *
     * 19
     * [2 + 4 * 3 + 5]
     * using stack logic is loop through string and when an op is detected as current char take last number and last op
     * and if op is * then pop stack, multiply last + popped number and put it back on stack, else just put last number on stack
     * then at end, iterate stack and add all numbers in stack
     *
     * constant space solution is loop through string and keep sum = 0 and prod = 1 vars. when an op is detected
     * check what the op is:
     * - if op = * then prod * last number
     * - if op = + then check last op. if last op = * then prod *= last number
     * - sum = 2, prod = 0
     * - sum = 2, prod = 4
     * - sum = 2, prod = 12
     * - sum = 7, prod = 12
     *  return sum + prod = 19
     * @param s
     * @return
     */
    Set<Character> ops = Set.of('+', '-', '*', '/');
    public int calculate(String s) {
        StringBuilder lastNumberString = new StringBuilder();
        char lastOp = '+';
        char curOp;
        int sum = 0, prod = 1;
        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                lastNumberString.append(c);
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
