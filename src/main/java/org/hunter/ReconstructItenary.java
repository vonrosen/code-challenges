package org.hunter;

import java.util.*;

public class ReconstructItenary {

    public static void main(String [] args) {
//        List<List<String>> it = List.of(
//                List.of("MUC","LHR"),
//                List.of("JFK","MUC"),
//                List.of("SFO","SJC"),
//                List.of("LHR","SFO")
//        );
        List<List<String>> it = List.of(
                List.of("JFK","SFO"),
                List.of("JFK","ATL"),
                List.of("SFO","ATL"),
                List.of("ATL","JFK"),
                List.of("ATL","SFO")
        );
        ReconstructItenary reconstructItenary = new ReconstructItenary();
        System.out.println(reconstructItenary.findItinerary(it));
    }

    //dp(remainingflights) = min(dp(n)) where n = neighbors of a
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,List<String>> graph = new HashMap<>();

        Set<String> remaining = new HashSet<>();
        for(List<String> flight : tickets) {
            String from = flight.get(0);
            String to = flight.get(1);
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(to);
            remaining.add(from + to);
        }
        List<List<String>> all = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        dfs("JFK", graph, ans, all, remaining);

        if(all.size() == 1) {
            return all.getFirst();
        }
        List<String> ansS = new ArrayList<>();
        for(List<String> possible : all) {
            StringBuilder sb = new StringBuilder();
            for(String s : possible) {
                sb.append(s);
            }
            ansS.add(sb.toString());
        }
        Collections.sort(ansS);
        String s = ansS.getFirst();
        ansS.clear();
        for(int i = 0; i < s.length(); ++i) {
            ansS.add(s.substring(i, i + 3));
            i += 2;
        }
        return ansS;
    }

    void dfs(String airport, Map<String,List<String>> graph, List<String> ans, List<List<String>> all, Set<String> remaining) {
        ans.add(airport);
        if(remaining.isEmpty()) {
            all.add(new ArrayList<>(ans));
            ans.remove(airport);
            return;
        }
        for(String nextAirport : graph.getOrDefault(airport, List.of())) {
            if(remaining.contains(airport + nextAirport)) {
                remaining.remove(airport + nextAirport);
                dfs(nextAirport, graph, ans, all, remaining);
                remaining.add(airport + nextAirport);
            }
        }
        ans.remove(airport);
    }

}
