package org.hunter;

import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class MaxDiameterNAryTree {

    int ans = 0;
    public int diameter(Node root) {
        dfs(root);
        return ans;
    }

    int dfs(Node root) {
        if(root == null) {
            return 0;
        }
        int maxPathSize = 0;
        int curAns = 0;
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(Node child : root.children) {
            int pathSize = 1 + dfs(child);
            queue.add(pathSize);
            maxPathSize = Math.max(pathSize, maxPathSize);
        }
        if(!queue.isEmpty()) {
            if(queue.size() == 1) {
                curAns = queue.poll();
            }else{
                curAns += queue.poll();
                curAns += queue.poll();
            }
        }
        ans = Math.max(ans, curAns);
        return maxPathSize;
    }

}
