package org.hunter;

import java.util.Stack;

/**
 *
 * [[0,0],[3,0],[0,2],[2,2]]
 *
 * [[0,0],[3,0],[0,0],[2,2]]
 *
 *
 *
 *
 * [7]
 * [7,3]
 * [7,5,3]
 *
 *
 * [[1,1],[5,3],[3,6],[6,6]]
 *
 *
 *
 * [1,5,3,6] min = 1
 * pop
 * [5,3,6] min = 3 how to know?
 *
 * [5][6,3,1]
 *
 * [5]
 * [6][5]
 *
 * [5,6] [1]
 *
 */

record Holder(
        int val,
        int min
){}

public class MinStack {
    private final Stack<Holder> stack;
    private Integer min = null;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        min = min == null ? val : Math.min(val, min);
        stack.push(new Holder(val, min));
    }

    public void pop() {
        stack.pop();
        if(stack.isEmpty()) {
            min = null;
        }else {
            min = stack.peek().min();
        }
    }

    public int top() {
        return stack.peek().val();
    }

    public int getMin() {
        return min;
    }

}
