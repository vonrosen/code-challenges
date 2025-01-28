package org.hunter;

import java.util.*;

class minimuminsertionstobalanceaparenthesesstring {
    public int minInsertions(String s) {
        int inserts = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
            }else if(c == ')'){
                if(stack.isEmpty()){
                    if(i == s.length() - 1){
                        inserts += 2;
                    }else if(s.charAt(i + 1) == ')'){
                        i += 1;
                        inserts++;
                    }else{
                        inserts += 2;
                    }
                }else{
                    stack.pop();
                    if(i == s.length() - 1){
                        inserts++;
                    }else if(s.charAt(i + 1) != ')'){
                        inserts++;
                    }else{
                        i += 1;
                    }
                }
            }
        }
   
        return (stack.size() * 2) + inserts;
    }
}
