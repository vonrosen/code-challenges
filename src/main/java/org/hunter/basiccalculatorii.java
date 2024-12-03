package org.hunter;

class basiccalculatorii {

	public int calculate(String s) {
		int sum = 0;
		int prod = 0;
		int lastNum = 0;
		Character lastOp = '+';
		s = s.replace(" ", "");
		for(char c : s.toCharArray()){
			if(!Character.isDigit(c)){
				if(lastOp == '-'){
					lastNum *= -1;
					lastOp = '+';
				}
				if(c == '+' || c == '-'){
					if(lastOp == '+'){
						sum += lastNum;
					}else if(lastOp == '*'){
						prod *= lastNum;
						sum += prod;
						prod = 0;
					}else{
						prod /= lastNum;
						sum += prod;
						prod = 0;
					}
				}else{
					if(prod == 0){
						prod = 1;
					}
					if(lastOp == '*'){
						prod *= lastNum;
					}else if(lastOp == '/'){
						prod /= lastNum;
					}else{
						prod = lastNum;
					}
				}
				lastOp = c;
				lastNum = 0;
			}else{
				lastNum = lastNum * 10 + (c - '0');
			}
		}
		if(lastOp == '-'){
			lastNum *= -1;
			lastOp = '+';
		}
		if(lastOp == '+'){
			sum += lastNum;
		}else if(lastOp == '*'){
			prod *= lastNum;
		}else{
			prod /= lastNum;
		}
		return sum + prod;
	}
}
