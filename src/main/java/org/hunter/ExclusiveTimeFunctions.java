package org.hunter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ExclusiveTimeFunctions {

    //["0:start:0","0:start:2","0:end:5","1:start:7","1:end:7","0:end:8"] = [8,1]
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int [] ans = new int[n];
        stack.push(Integer.parseInt(logs.get(0).split(":")[0]));
        int prevTime = Integer.parseInt(logs.get(0).split(":")[2]);
        for(int i = 1; i < logs.size(); ++i) {
            String [] parts = logs.get(i).split(":");
            int fun = Integer.parseInt(parts[0]);
            boolean starting = parts[1].equals("start");
            int time = Integer.parseInt(parts[2]);
            if(starting) {
                int duration = time - prevTime;
                if(!stack.isEmpty()) {
                    ans[stack.peek()] += duration;
                }
                prevTime = time;
                stack.push(fun);
            }else {
                int duration = time - prevTime + 1;
                ans[stack.peek()] += duration;
                stack.pop();
                prevTime = time;
                prevTime++;
            }
        }
        return ans;
    }

    /**
     * 2 - 5 = 4
     * 6 - 6 = 1
     * 0 - 7 = 8
     * current log starting last log starting
     * current log starting last log ending
     *
     * current log ending last log starting
     * current log ending last log ending
     *
     * ["0:start:0","1:start:2","1:end:5","0:end:6"] = [3,4]
     *
     * ["0:start:0","0:start:2","0:end:5","1:start:7","1:end:7","0:end:8"] = [8,1]
     *  2, 4, 1 = 7
     */
    public static void main(String [] args) {
        ExclusiveTimeFunctions exclusiveTimeFunctions = new ExclusiveTimeFunctions();
//        int [] ans = exclusiveTimeFunctions.exclusiveTime(2, List.of("0:start:0","1:start:2","1:end:5","0:end:6"));
        int [] ans = exclusiveTimeFunctions.exclusiveTime2(2, List.of("0:start:0","0:start:2","0:end:5","1:start:7","1:end:7","0:end:8"));
        for(int a : ans) {
            System.out.print(a + " ");
        }
    }

    //["0:start:0","1:start:2","1:end:5","0:end:6"] = [3,4]
    //["0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"]
    public int[] exclusiveTime2(int n, List<String> logs) {
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> running = new Stack<>();
        for(int i = 0; i < logs.size(); ++i) {
            if(i > 0) {
                String logline = logs.get(i);
                String lastLogline = logs.get(i - 1);

                String [] parts = logline.split(":");
                int fun = Integer.parseInt(parts[0]);
                boolean starting = parts[1].equals("start");
                int time = Integer.parseInt(parts[2]);

                String [] lastParts = lastLogline.split(":");
                int lastFun = Integer.parseInt(lastParts[0]);
                boolean lastStarting = lastParts[1].equals("start");
                int lastTime = Integer.parseInt(lastParts[2]);

                if(!starting && lastStarting && lastFun == fun) {
                    int duration = time - lastTime + 1;
                    map.putIfAbsent(fun, 0);
                    map.put(fun, map.get(fun) + duration);
                }else if(!starting && !lastStarting) {
                    int duration = time - lastTime;
                    map.putIfAbsent(fun, 0);
                    map.put(fun, map.get(fun) + duration);
                }else if(starting && lastStarting){
                    int duration = time - lastTime;
                    map.putIfAbsent(lastFun, 0);
                    map.put(lastFun, map.get(lastFun) + duration);
                }else if (starting && !lastStarting) {
                    if(!running.isEmpty()) {
                        int curRunningFun = running.peek();
                        int duration = time - lastTime - 1;
                        map.putIfAbsent(curRunningFun, 0);
                        map.put(curRunningFun, map.get(curRunningFun) + duration);
                    }
                }
            }
            if(logs.get(i).split(":")[1].equals("start")) {
                running.push(Integer.parseInt(logs.get(i).split(":")[0]));
            }else{
                if(!running.isEmpty()) {
                    running.pop();
                }
            }
        }
        int [] ans = new int[map.size()];
        for(int fun : map.keySet()) {
            ans[fun] = map.get(fun);
        }
        return ans;
    }

}
