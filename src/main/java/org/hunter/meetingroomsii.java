package org.hunter;

import java.util.*;

class meetingroomsii {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (interval1, interval2) -> {
            if(interval1[0] < interval2[0]){
                return -1;
            }
            if(interval1[0] > interval2[0]){
                return 1;
            }
            return 0;
        });

        PriorityQueue<Integer> q = new PriorityQueue<>();
        int ans = 0;
        for(int i = 0; i < intervals.length; ++i){
            if(q.isEmpty()){
                q.add(intervals[i][1]);
            }else{
                if(intervals[i][0] >= q.peek()){
                    q.poll();
                }
                q.add(intervals[i][1]);
            }
            ans = Math.max(ans, q.size());
        }

        return ans;
    }
}
