class gasstation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int [] diffs = new int[gas.length * 2];
        for(int i = 0; i < diffs.length; ++i){
            int index = i % gas.length;
            diffs[i] = gas[index] - cost[index];
        }
        int sum = 0;
        for(int i = 0; i < gas.length; ++i){
            sum += diffs[i];
        }
        if(sum < 0){
            return -1;
        }
        sum = 0;
        int left = 0;
        int right = 0;
        while(right < diffs.length){
            while(diffs[left] < 0 || sum < 0){
                sum -= diffs[left];               
                ++left;
            }    
            sum += diffs[right];
            int length = right - left + 1;
            if(length == gas.length){
                if(sum >= 0){
                    return left % gas.length;
                }
                sum = 0;
                ++left;
            }
            ++right;
        }
        //should never happen
        return -1;
    }
}
