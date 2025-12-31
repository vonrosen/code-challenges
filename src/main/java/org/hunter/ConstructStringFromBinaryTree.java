package org.hunter;

public class ConstructStringFromBinaryTree {

    public String tree2str(TreeNode root) {
        if(root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.insert(0, root.val);
        return sb.toString();
    }

    void dfs(TreeNode root, StringBuilder sb) {
        if(root == null) {
            return;
        }
        sb.append("(");
        sb.append(root.val);
        dfs(root.left, sb);
        dfs(root.right, sb);
        if(root.left == null && root.right != null) {
            sb.append("()");
        }else if(root.left == null || root.right == null) {
            sb.append(")");
        }
    }

}
