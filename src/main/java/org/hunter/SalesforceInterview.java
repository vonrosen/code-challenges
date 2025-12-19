package org.hunter;

import java.util.*;

public class SalesforceInterview {

    public static void main(String [] args) {
        List<List<String>> commands = new ArrayList<>();
//        commands.add(List.of("A", "B"));
//        commands.add(List.of("A", "E"));
//        commands.add(List.of("A", "X"));
//        commands.add(List.of("C", "E"));
//        commands.add(List.of("X", "Y"));
        //[E,C,B,A]

        commands.add(List.of("A", "B"));
        commands.add(List.of("A", "C"));
        commands.add(List.of("C", "D"));
        commands.add(List.of("C", "F"));
        commands.add(List.of("F", "G"));

        //C must be executed before E but C is disconnected from A therefore A will never run.
        Map<String,Set<String>> graph = new HashMap<>();
        for(List<String> command: commands) {
            graph.putIfAbsent(command.get(0), new HashSet<>());
            graph.get(command.get(0)).add(command.get(1));
        }

        Map<String,Set<String>> opGraph = new HashMap<>();
        for(List<String> command: commands) {
            opGraph.putIfAbsent(command.get(1), new HashSet<>());
            opGraph.get(command.get(1)).add(command.get(0));
        }

        Stack<String> executionOrder = new Stack<>();
        dfs(graph, "A", executionOrder, opGraph);
        System.out.println(executionOrder);
        while(!executionOrder.isEmpty()) {
            System.out.println(executionOrder.pop());
        }
    }

    static void dfs(Map<String,Set<String>> graph, String command, Stack<String> executionOrder, Map<String,Set<String>> opGraph) {
        Set<String> mustBeExecuted = new HashSet<>(opGraph.getOrDefault(command, Set.of()));
        Set<String> executed = new HashSet<>(executionOrder);
        mustBeExecuted.removeAll(executed);
        if(!mustBeExecuted.isEmpty()) {
            for(String node: mustBeExecuted) {
                dfs(graph, node, executionOrder, opGraph);
            }
        }else{
            executionOrder.add(command);
            for(String node: graph.getOrDefault(command, Set.of())) {
                dfs(graph, node, executionOrder, opGraph);
            }
        }
    }

}
