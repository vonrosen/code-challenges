package org.hunter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LowestCostShirts {

    List<String> ans = new ArrayList<>();
    int minCost = Integer.MAX_VALUE;

    public static void main(String [] args){
        LowestCostShirts l = new LowestCostShirts();
        List<String> ans = l.lowestCost(new int [] {100, 1, 76, 14}, new int [] {22, 20, 1, 2}, new int [] { 99, 99, 5, 12});
        for(String s: ans){
            System.out.print(s + " ");
        }
        System.out.println("");
        ans = l.lowestCost(new int [] {1, 1, 1}, new int [] {3, 5, 7}, new int [] {4, 6, 4});
        for(String s: ans){
            System.out.print(s + " ");
        }
        System.out.println("");
        ans = l.lowestCost(new int [] {100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000}, new int [] {1, 2088899, 1, 2, 20, 1, 2, 20, 1, 2}, new int [] { 1, 99, 5, 12, 99, 99, 5, 99, 99, 5});
        for(String s: ans){
            System.out.print(s + " ");
        }
        System.out.println("");

    }

    public List<String> lowestCost(int [] blueCosts, int [] greenCosts, int [] redCosts){
        ans = new ArrayList<>();
        minCost = Integer.MAX_VALUE;
        Map<String, List<String>> mem = new HashMap<>();
        List<String> cur = new ArrayList<>();
        cur.add("b");
        lowestCost(blueCosts, greenCosts, redCosts, 'b', 0, blueCosts[0], cur, mem);
        cur.remove(cur.size() - 1);
        cur.add("g");
        lowestCost(blueCosts, greenCosts, redCosts, 'g', 0, greenCosts[0], cur, mem);
        cur.remove(cur.size() - 1);
        cur.add("r");
        lowestCost(blueCosts, greenCosts, redCosts, 'r', 0, redCosts[0], cur, mem);
        cur.remove(cur.size() - 1);
        return ans;
    }

    void lowestCost(int [] blueCosts, int [] greenCosts, int [] redCosts, char color, int index, int totalCost, List<String> cur, Map<String, List<String>> mem){
        if(cur.size() == blueCosts.length) {
            if (minCost > totalCost) {
                minCost = totalCost;
                ans = new ArrayList<>(cur);
            }
            return;
        }
//        if(mem.get(String.valueOf(color) + index) != null){
//            ans = mem.get(String.valueOf(color) + index);
//            return;
//        }
        if(color == 'b'){
            cur.add("g");
            lowestCost(blueCosts, greenCosts, redCosts, 'g', index + 1, totalCost + greenCosts[index + 1], cur, mem);
            cur.remove(cur.size() - 1);
            cur.add("r");
            lowestCost(blueCosts, greenCosts, redCosts, 'r', index + 1, totalCost + redCosts[index + 1], cur, mem);
            cur.remove(cur.size() - 1);
        }else if(color == 'g'){
            cur.add("b");
            lowestCost(blueCosts, greenCosts, redCosts, 'b', index + 1, totalCost + blueCosts[index + 1], cur, mem);
            cur.remove(cur.size() - 1);
            cur.add("r");
            lowestCost(blueCosts, greenCosts, redCosts, 'r', index + 1, totalCost + redCosts[index + 1], cur, mem);
            cur.remove(cur.size() - 1);
        }else{
            cur.add("b");
            lowestCost(blueCosts, greenCosts, redCosts, 'b', index + 1, totalCost + blueCosts[index + 1], cur, mem);
            cur.remove(cur.size() - 1);
            cur.add("g");
            lowestCost(blueCosts, greenCosts, redCosts, 'g', index + 1, totalCost + greenCosts[index + 1], cur, mem);
            cur.remove(cur.size() - 1);
        }
       //mem.put(String.valueOf(color) + index, ans);
    }
}
