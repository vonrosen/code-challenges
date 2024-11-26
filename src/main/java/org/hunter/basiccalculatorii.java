class basiccalculatorii {

	public int calculate(String s) {
		int sum = 0;
		int prod = 0;
		int lastNum = 0;
		Character lastOp = '+';
		s = s.replace(" ", "");
		for(char c : s.toCharArray()){
			if(c == '+'){
				int num = lastNum;
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
				lastNum = 0;
			}else if(c == '-'){
				int num = lastNum;
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
				lastNum = 0;
			}
			else if(c == '*'){
				int num = lastNum;
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
				lastNum = 0;
			}else if(c == '/'){
				int num = lastNum;
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
				lastNum = 0;
			}else{
				lastNum = lastNum * 10 + (c - '0');
			}
		}
		int num = lastNum;
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
