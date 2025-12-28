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
//        List<List<String>> it = List.of(
//                List.of("JFK","SFO"),
//                List.of("JFK","ATL"),
//                List.of("SFO","ATL"),
//                List.of("ATL","JFK"),
//                List.of("ATL","SFO")
//        );
        List<List<String>> it = List.of(
                List.of("JFK", "SFO"),
                List.of("JFK", "ATL"),
                List.of("SFO", "JFK"),
                List.of("ATL", "AAA"),
                List.of("AAA", "ATL"),
                List.of("ATL", "BBB"),
                List.of("BBB", "ATL"),
                List.of("ATL", "CCC"),
                List.of("CCC", "ATL"),
                List.of("ATL", "DDD"),
                List.of("DDD", "ATL"),
                List.of("ATL", "EEE"),
                List.of("EEE", "ATL"),
                List.of("ATL", "FFF"),
                List.of("FFF", "ATL"),
                List.of("ATL", "GGG"),
                List.of("GGG", "ATL"),
                List.of("ATL", "HHH"),
                List.of("HHH", "ATL"),
                List.of("ATL", "III"),
                List.of("III", "ATL"),
                List.of("ATL", "JJJ"),
                List.of("JJJ", "ATL"),
                List.of("ATL", "KKK"),
                List.of("KKK", "ATL"),
                List.of("ATL", "LLL"),
                List.of("LLL", "ATL"),
                List.of("ATL", "MMM"),
                List.of("MMM", "ATL"),
                List.of("ATL", "NNN"),
                List.of("NNN", "ATL")
        );
        ReconstructItenary reconstructItenary = new ReconstructItenary();
        System.out.println(reconstructItenary.findItinerary(it));
    }

    //dp(remainingflights) = min(dp(n)) where n = neighbors of a
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,List<String>> graph = new HashMap<>();
        List<List<String>> ticketsMutable = new ArrayList<>(tickets);
        Collections.sort(ticketsMutable, (f1, f2) -> {
            String from1 = f1.get(0);
            String to1 = f1.get(1);
            String from2 = f2.get(0);
            String to2 = f2.get(1);
            if(from1.compareTo(from2) < 0) {
                return -1;
            }
            if(from1.compareTo(from2) > 0) {
                return 1;
            }
            if(to1.compareTo(to2) < 0) {
                return -1;
            }
            if(to1.compareTo(to2) > 0) {
                return 1;
            }
            return 0;
        });
        Set<String> remaining = new HashSet<>();
        for(List<String> flight : ticketsMutable) {
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
        if(!all.isEmpty()) {
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
