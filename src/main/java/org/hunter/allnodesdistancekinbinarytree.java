package.org.hunter;

import java.util.*;

class allnodesdistancekinbinarytree {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        graph.put(root.val, new ArrayList<>());
        distanceK(root, null, graph);

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int counter = 0;
        q.add(target.val);
        while(!q.isEmpty()){
            if(counter == k){
                return new ArrayList<>(q);
            }
            int size = q.size();
            for(int i = 0; i < size; ++i){
                int val = q.poll();
                if(!visited.contains(val)){
                    visited.add(val);
                    for(int adj : graph.getOrDefault(val, List.of())){
                        if(!visited.contains(adj)){
                            q.add(adj);
                        }                        
                    }
                }
            }
            counter++;
        }
        return List.of();
    }

    void distanceK(TreeNode root, Integer lastVal, Map<Integer,List<Integer>> graph){
        if(root == null){
            return;
        }
        if(lastVal != null){
            graph.putIfAbsent(root.val, new ArrayList<>());
            graph.get(root.val).add(lastVal);
        }
        if(root.left != null){
            graph.putIfAbsent(root.val, new ArrayList<>());
            graph.get(root.val).add(root.left.val);

        }
        if(root.right != null){
            graph.putIfAbsent(root.val, new ArrayList<>());
            graph.get(root.val).add(root.right.val);
        }
        distanceK(root.left, root.val, graph);
        distanceK(root.right, root.val, graph);
    }
}
