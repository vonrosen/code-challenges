package org.hunter;

import java.util.Arrays;
import java.util.Stack;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int [] arr1, int [] arr2) -> arr1[0] - arr2[0]);
        Stack<int []> stack = new Stack<>();
        for(int [] arr: intervals) {
            if(stack.isEmpty()) {
                stack.push(arr);
            }else {
                int [] peeked = stack.peek();
                if(overlaps(peeked, arr)) {
                    stack.pop();
                    if(peeked[1] > arr[1]) {
                        stack.push(new int[] {peeked[0], peeked[1]});
                    }else{
                        stack.push(new int[] {peeked[0], arr[1]});
                    }
                }else {
                    stack.push(arr);
                }
            }
        }
        int[][] ans = new int[stack.size()][2];
        for(int i = 0; i < stack.size(); ++i) {
            ans[i] = stack.get(i);
        }
        return ans;
    }

    boolean overlaps(int [] arr1, int [] arr2) {
        return arr2[0] >= arr1[0] && arr2[0] <=  arr1[1];
    }

}
