package org.hunter;

import java.util.*;

public class KahnsAlgorithm {

    public static List<Integer> topologicalSort(int vertices, List<List<Integer>> adj) {
        int[] inDegree = new int[vertices];
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // 1. Calculate in-degree of all vertices
        for (int i = 0; i < vertices; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }

        // 2. Add all vertices with in-degree 0 to the queue
        for (int i = 0; i < vertices; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // 3. Process nodes
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);

            // For each neighbor, reduce in-degree
            for (int neighbor : adj.get(current)) {
                inDegree[neighbor]--;

                // If in-degree becomes 0, add to queue
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // 4. Check for cycle
        if (result.size() != vertices) {
            System.out.println("Cycle detected! Topological sort not possible.");
            return new ArrayList<>();
        }

        return result;
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Example Edges: 5->2, 5->0, 4->0, 4->1, 2->3, 3->1
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        System.out.println("Topological Sort: " + topologicalSort(V, adj));
    }
}