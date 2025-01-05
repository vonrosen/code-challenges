package.org.hunter;

class average-waiting-time {
    public double averageWaitingTime(int[][] customers) {
        int chefFreeTime = 0;
        int [] waits = new int[customers.length];
        for(int i = 0; i < customers.length; ++i){
            int arrival = customers[i][0];
            int prepareTime = customers[i][1];
            if(arrival >= chefFreeTime){
                waits[i] = prepareTime;                
                chefFreeTime = arrival + prepareTime;
            }else{
                waits[i] = (chefFreeTime + prepareTime) - arrival;
                chefFreeTime += prepareTime;
            }            
        }
        double ans = 0d;
        for(int i = 0; i < waits.length; ++i){
            ans += waits[i];
        }
        return ans / waits.length;
    }
}
