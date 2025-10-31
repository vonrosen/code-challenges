package org.hunter;

import java.util.*;

class Holder{
    int val;
    int min;
    Holder(int val, int min){
        this.val = val;
        this.min = min;
    }
}

class minstack {

    private Stack<Holder> stack;

    public minstack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new Holder(val, val)); 
            return;   
        }
        int min = Math.min(stack.peek().min, val);
        stack.push(new Holder(val, min));
    }
    
    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}
