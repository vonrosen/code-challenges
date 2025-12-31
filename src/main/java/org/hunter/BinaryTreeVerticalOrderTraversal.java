package org.hunter;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {

    record State(
            TreeNode node,
            int index
    ){}

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null){
            return List.of();
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        bfs(root, map);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>(map.keySet());
        Collections.sort(tmp);
        for(int index: tmp) {
            ans.add(map.get(index));
        }
        return ans;
    }

    void bfs(TreeNode root, Map<Integer,List<Integer>> map) {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(root, 0));
        map.putIfAbsent(0, new ArrayList<>());
        map.get(0).add(root.val);
        while(!queue.isEmpty()) {
            State state = queue.poll();
            if(state.node.left != null) {
                queue.add(new State(state.node.left, state.index - 1));
                map.putIfAbsent(state.index - 1, new ArrayList<>());
                map.get(state.index - 1).add(state.node.left.val);
            }
            if(state.node.right != null) {
                queue.add(new State(state.node.right, state.index + 1));
                map.putIfAbsent(state.index + 1, new ArrayList<>());
                map.get(state.index + 1).add(state.node.right.val);
            }
        }
    }

}
