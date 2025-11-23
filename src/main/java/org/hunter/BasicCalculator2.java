package org.hunter;

import java.util.Set;
import java.util.Stack;

public class BasicCalculator2 {

    public static void main(String [] args) {
        BasicCalculator2 basicCalculator2 = new BasicCalculator2();
        System.out.println(basicCalculator2.calculate("3+2*2"));
        System.out.println(basicCalculator2.calculate("3/2"));
        System.out.println(basicCalculator2.calculate("1-1"));
        System.out.println(basicCalculator2.calculate("2*3-4"));
        System.out.println(basicCalculator2.calculate("12-3*4"));
        System.out.println(basicCalculator2.calculate("2*3*4"));
        System.out.println(basicCalculator2.calculate("14/3*2"));
        System.out.println(basicCalculator2.calculate("14/3/2"));
    }

    //s = "3+2*2+2*2" = 11
    //o(n) space
    public int calculate(String s) {
        Set<Character> ops = Set.of('+', '-', '/', '*');
        Set<Character> multOps = Set.of('/', '*');
        int sum = 0;
        int prod = 1;
        char lastOp = '+';
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); ++i){
            char cur = s.charAt(i);
            if (cur == ' '){
                continue;
            }
            if(ops.contains(cur)){
                int lastVal = Integer.parseInt(sb.toString());
                if(multOps.contains(cur)){
                    if(cur == '/'){
                        if(lastOp == '-'){
                            prod *= -lastVal;
                        }else if(lastOp == '/'){
                            prod /= lastVal;
                        }
                        else{
                            prod *= lastVal;
                        }
                    }else{
                        if(lastOp == '-'){
                            prod *= -lastVal;
                        }else if(lastOp == '/'){
                            prod /= lastVal;
                        }
                        else{
                            prod *= lastVal;
                        }
                    }
                }else{
                    if(cur == '+'){
                        if(lastOp == '*'){
                            prod *= lastVal;
                            sum += prod;
                        }else if(lastOp == '/'){
                            prod /= lastVal;
                            sum += prod;
                        }else if (lastOp == '+'){
                            sum += lastVal;
                        }else{
                            sum -= lastVal;
                        }
                    }else{
                        if(lastOp == '*'){
                            prod *= lastVal;
                            sum += prod;
                        }else if(lastOp == '/'){
                            prod /= lastVal;
                            sum += prod;
                        }else if(lastOp == '+'){
                            sum += lastVal;
                        }else{
                            sum -= lastVal;
                        }
                    }
                    prod = 1;
                }
                sb = new StringBuilder();
                lastOp = cur;
            }else{
                sb.append(cur);
            }
        }
        int lastVal = Integer.parseInt(sb.toString());
        if(lastOp == '*'){
            prod *= lastVal;
            sum += prod;
        }else if(lastOp == '/'){
            prod /= lastVal;
            sum += prod;
        }else if (lastOp == '+'){
            sum += lastVal;
        }else{
            sum -= lastVal;
        }
        return sum;
    }


    //s = "3+2*2*1/2 + 2 * 6"
    //     3 + 2 + 12
    public int calculate2(String s) {
        Set<Character> ops = Set.of('+', '-', '/', '*');
        Set<Character> multOps = Set.of('/', '*');
        Stack<Integer> nums = new Stack<>();
        char lastOp = '+';
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); ++i){
            char cur = s.charAt(i);
            if (cur == ' '){
                continue;
            }
            if(ops.contains(cur)){
                int curValue = Integer.parseInt(sb.toString());
                if(multOps.contains(lastOp)){
                    if(lastOp == '/'){
                        nums.push(nums.pop() / curValue);
                    }else{
                        nums.push(nums.pop() * curValue);
                    }
                }else{
                    if(lastOp == '+'){
                        nums.push(curValue);
                    }else{
                        nums.push(-curValue);
                    }
                }
                sb = new StringBuilder();
                lastOp = cur;
            }else{
                sb.append(cur);
            }
        }
        int curValue = Integer.parseInt(sb.toString());
        if (multOps.contains(lastOp)) {
            if (lastOp == '/') {
                nums.push(nums.pop() / curValue);
            } else {
                nums.push(nums.pop() * curValue);
            }
        } else {
            if (lastOp == '+') {
                nums.push(curValue);
            } else {
                nums.push(-curValue);
            }
        }
        int ans = 0;
        for(int num : nums) {
            ans += num;
        }
        return ans;
    }
}
