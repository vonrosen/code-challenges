package org.hunter;

public class BSTRangeSum {

    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high, 0);
    }

    int dfs(TreeNode root, int low, int high, int sum) {
        if(root == null) {
            return 0;
        }
        dfs(root.left, low, high, sum);
        dfs(root.right, low, high, sum);
        if(low <= root.val && root.val <= high) {
            sum += root.val;
        }
        return sum;
    }


}
