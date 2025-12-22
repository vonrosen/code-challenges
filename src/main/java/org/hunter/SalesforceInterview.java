package org.hunter;

import java.util.*;

public class SalesforceInterview {

    public static void main(String [] args) {
        executionOrder();
    }

    static void dfs() {
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

        //C must be executed before E but C is disconnected from A therefore C will never run.
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

    static void executionOrder() {
        List<List<String>> commands = new ArrayList<>();

        commands.add(List.of("A", "B"));
        commands.add(List.of("A", "C"));
        commands.add(List.of("C", "D"));
        commands.add(List.of("C", "F"));
        commands.add(List.of("F", "G"));

        Map<String,List<String>> graph = new HashMap<>();
        Map<String,Integer> inDegree = new HashMap<>();
        for(List<String> command: commands) {
            String first = command.get(0);
            String second = command.get(1);
            graph.putIfAbsent(first, new ArrayList<>());
            graph.get(first).add(second);
            inDegree.putIfAbsent(first, 0);
            inDegree.putIfAbsent(second, 0);
            inDegree.put(second, inDegree.get(second) + 1);
        }
        Queue<String> queue = new LinkedList<>();
        for(String key: inDegree.keySet()) {
            if(inDegree.get(key) == 0) {
                queue.add(key);
            }
        }
        List<List<String>> executionOrder = new ArrayList<>();
        while(!queue.isEmpty()) {
            int size = queue.size();
            executionOrder.add(new ArrayList<>());
            for(int i = 0; i < size; ++i) {
                String command = queue.poll();
                executionOrder.getLast().add(command);
                for(String neighbor : graph.getOrDefault(command, List.of())) {
                    inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                    if(inDegree.get(neighbor) == 0) {
                        queue.add(neighbor);
                    }
                }
            }
        }
        for(int i = executionOrder.size() - 1; i >= 0; --i) {
            System.out.println(executionOrder.get(i));
        }
    }

}
