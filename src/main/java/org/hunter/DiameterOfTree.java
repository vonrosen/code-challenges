package org.hunter;

public class DiameterOfTree {

    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }

    int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(root.left != null) {
            left++;
        }
        if(root.right != null) {
            right++;
        }
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right);
    }

}
