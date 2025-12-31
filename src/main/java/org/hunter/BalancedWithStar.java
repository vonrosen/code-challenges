package org.hunter;

public class BalancedWithStar {

    public static void main(String [] args){
        BalancedWithStar b = new BalancedWithStar();
        System.out.println(b.balanced("{}"));//true
        System.out.println(b.balanced("*}"));//true
        System.out.println(b.balanced("{}}"));//false
        System.out.println(b.balanced("***"));//false
        System.out.println(b.balanced("*}*"));//false
        System.out.println(b.balanced("****"));//true
        System.out.println(b.balanced("{*{*"));//true
    }

    //O(2^N), O(1)
    boolean balanced(String expression){
        return balanced(0, expression.charAt(0), expression, 0);
    }

    boolean balanced(int pos, char c, String expression, int counter) {
        if(pos >= expression.length()) {
            return counter == 0;
        }
        if(c == '{') {
            return balanced(pos + 1, pos == expression.length() - 1 ? 'x' : expression.charAt(pos + 1), expression, counter + 1);
        }
        else if (c == '}') {
            return balanced(pos + 1, pos == expression.length() - 1 ? 'x' : expression.charAt(pos + 1), expression, counter - 1);
        }
        else {
            if(balanced(pos + 1, pos == expression.length() - 1 ? 'x' : expression.charAt(pos + 1), expression, counter + 1)){
                return true;
            }
            return balanced(pos + 1, pos == expression.length() - 1 ? 'x' : expression.charAt(pos + 1), expression, counter - 1);
        }
    }
}
