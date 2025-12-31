package org.hunter;

public class LCATree3 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };

    public Node lowestCommonAncestor(Node p, Node q) {
        Node parentP = p.parent;
        Node root = parentP;
        while(parentP != null) {
            if(parentP.parent == null) {
                root = parentP;
                break;
            }
            parentP = parentP.parent;
        }
        return dfs2(root, p, q);
    }

    Node dfs2(Node root, Node p, Node q) {
        if(root == null) {
            return null;
        }
        Node left = dfs2(root.left, p, q);
        Node right = dfs2(root.right, p, q);
        if(left != null && right != null) {
            return root;
        }
        if(root.val == p.val || root.val == q.val) {
            return root;
        }
        if(left != null) {
            return left;
        }
        if(right != null) {
            return right;
        }
        return null;
    }
}
