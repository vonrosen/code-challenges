package org.hunter;

class Calculator {
    public static void main(String [] args){
        Calculator c = new Calculator();
        System.out.println(c.calculate("4+5*10"));
        System.out.println(c.calculate("5*10+1"));
        System.out.println(c.calculate("5+10"));
        System.out.println(c.calculate("5+10+3*66*33+32*3+7+7+3433"));//10,092
        System.out.println(c.calculate("24/2-3*2"));//6
        System.out.println(c.calculate("10*3/3+1"));//11
    }

    /*
     * 4+5*10 = 54
     *
     */
    public int calculate(String expression) {
        int sum = 0;
        int prod = 0;
        StringBuilder lastNum = new StringBuilder();
        Character lastOp = '+';
        for(char c : expression.toCharArray()){
            if(c == '+'){
                int num = Integer.parseInt(lastNum.toString());
                if(lastOp == '+'){
                    sum += num;
                }else{
                    prod *= num;
                    sum += prod;
                    prod = 0;
                }
                lastOp = c;
                lastNum = new StringBuilder();
            }else if(c == '*'){
                int num = Integer.parseInt(lastNum.toString());
                if(prod == 0){
                    prod = 1;
                }
                if(lastOp == '/'){
                    prod /= num;
                }else{
                    prod *= num;
                }
                lastOp = c;
                lastNum = new StringBuilder();
            }else if(c == '/'){
                int num = Integer.parseInt(lastNum.toString());
                if(prod == 0){
                    prod = 1;
                }
                if(lastOp == '*'){
                    prod *= num;
                }else{
                    prod /= num;
                }
                prod *= num;
                lastOp = c;
                lastNum = new StringBuilder();
            }else{
                lastNum.append(c);
            }
        }
        int num = Integer.parseInt(lastNum.toString());
        if(lastOp == '+'){
            sum += num;
        }else if(lastOp == '-'){
            sum -= num;
        }else if(lastOp == '*'){
            prod *= num;
        }else{
            prod /= num;
        }else{
            prod *= num;
        }
        return sum + prod;
    }

}
