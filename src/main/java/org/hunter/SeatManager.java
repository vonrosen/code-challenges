import java.util.*;

class SeatManager {

    PriorityQueue<Integer> unreserved;

    public SeatManager(int n) {
        unreserved = new PriorityQueue<>();
        for(int i = 1; i <= n; ++i){
            unreserved.add(i);
        }
    }
    
    public int reserve() {
        int seat = unreserved.poll();
        return seat;
    }
    
    public void unreserve(int seatNumber) {
        unreserved.add(seatNumber);
    }
}
