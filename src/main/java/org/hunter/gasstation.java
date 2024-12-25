package org.hunter;

class gasstation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int [] diffs = new int[gas.length * 2];
        for(int i = 0; i < diffs.length; ++i){
            int index = i % gas.length;
            diffs[i] = gas[index] - cost[index];
        }
        int sum = 0;
        int left = 0;
        int right = 0;
        while(right < diffs.length){            
            sum += diffs[right];
            if(sum < 0){
                left = right + 1;
                sum = 0;
            }
            int length = right - left + 1;
            if(length == gas.length){
                return left;
            }
            ++right;
        }
        return -1;
    }
}
