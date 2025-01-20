package org.hunter;

class CustomStack {

    int maxSize;
    int [] arr;
    int maxIndex;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.maxIndex = 0;
    }
    
    public void push(int x) {
        if(maxIndex == maxSize){
            return;
        }
        arr[maxIndex++] = x;
    }    
    
    public int pop() {
        if(maxIndex == 0){
            return -1;
        }
        int value = arr[maxIndex - 1];
        --maxIndex;
        return value;
    }

    public void increment(int k, int val) {
        int max = Math.min(k, maxIndex);
        for(int i = 0; i < max; ++i){
            arr[i] = arr[i] + val;
        }
    }
}
