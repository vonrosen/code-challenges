//"12-3*4+4*5-30"
class basiccalculatorii {

	public int calculate(String s) {
        int sum = 0;
        int prod = 0;
        StringBuilder lastNum = new StringBuilder();
        Character lastOp = '+';
        s = s.replace(" ", "");
        for(char c : s.toCharArray()){
            if(c == '+'){
                int num = Integer.parseInt(lastNum.toString());
                if(lastOp == '-'){
                    num = num * -1;
                    lastOp = '+';
                }
                if(lastOp == '+'){
                    sum += num;
                }else if(lastOp == '*'){
                    prod *= num;
                    sum += prod;
                    prod = 0;
                }else{
                    prod /= num;
                    sum += prod;
                    prod = 0;
                }
                lastOp = c;
                lastNum = new StringBuilder();
            }else if(c == '-'){
                int num = Integer.parseInt(lastNum.toString());
                if(lastOp == '-'){
                    num = num * -1;
                    lastOp = '+';
                }    
                if(lastOp == '+'){
                    sum += num;
                }else if(lastOp == '*'){
                    prod *= num;
                    sum += prod;
                    prod = 0;
                }else{
                    prod /= num;
                    sum += prod;
                    prod = 0;
                }                
                lastOp = '-';
                lastNum = new StringBuilder();
            }
            else if(c == '*'){
                int num = Integer.parseInt(lastNum.toString());
                if(lastOp == '-'){
                    num = num * -1;
                    lastOp = '+';
                }
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
                if(lastOp == '-'){
                    num = num * -1;
                    lastOp = '+';
                }
                if(prod == 0){
                    prod = 1;
                }
                if(lastOp == '*'){
                    prod *= num;
                }else if(lastOp == '/'){
                    prod /= num;
                }else{
                    prod = num;
                }
                lastOp = c;
                lastNum = new StringBuilder();
            }else{
                lastNum.append(c);
            }
        }
        int num = Integer.parseInt(lastNum.toString());
        if(lastOp == '-'){
            num = num * -1;
            lastOp = '+';
        }
        if(lastOp == '+'){
            sum += num;
        }else if(lastOp == '*'){
            prod *= num;
        }else{
            prod /= num;
        }
        return sum + prod;
	}
}
