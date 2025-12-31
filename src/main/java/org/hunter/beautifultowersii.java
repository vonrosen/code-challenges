package org.hunter;

import java.util.*;

class beautifultowersii {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long [] left = new long[maxHeights.size()];
        long [] right = new long[maxHeights.size()];
        Stack<Integer> stack = new Stack<>();
        long sum = 0;
        for(int i = 0; i < maxHeights.size(); ++i){            
            sum += maxHeights.get(i);
            if(!stack.isEmpty() && maxHeights.get(stack.peek()) > maxHeights.get(i)){
                sum = 0;
                while(!stack.isEmpty() && maxHeights.get(stack.peek()) > maxHeights.get(i)){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    sum += (i + 1) * (long)maxHeights.get(i);
                }else{
                    sum += ((i - stack.peek()) * (long)maxHeights.get(i)) + left[stack.peek()];
                }
            }
            left[i] = sum;
            stack.push(i);
        }
        stack.clear();
        sum = 0;
        for(int i = maxHeights.size() - 1; i >= 0; --i){            
            sum += maxHeights.get(i);
            if(!stack.isEmpty() && maxHeights.get(stack.peek()) > maxHeights.get(i)){
                sum = 0;
                while(!stack.isEmpty() && maxHeights.get(stack.peek()) > maxHeights.get(i)){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    sum += (maxHeights.size() - i) * (long)maxHeights.get(i);
                }else{
                    sum += ((stack.peek() - i) * (long)maxHeights.get(i)) + right[stack.peek()];
                }
            }
            right[i] = sum;
            stack.push(i);
        }
        long ans = 0;
        for(int i = 0; i < maxHeights.size(); ++i){
            ans = Math.max(ans, left[i] + right[i] - (long)maxHeights.get(i));
        }
        return ans;
    }

}
