package org.hunter;

import java.util.List;

public class MaxPathSum {

    public static void main(String [] args) {
        MaxPathSum maxPathSum = new MaxPathSum();
        System.out.println(maxPathSum.maxPathSum(new TreeNode(-3)));
    }

    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    Integer dfs(TreeNode root) {
        if(root == null){
            return null;
        }
        Integer left = dfs(root.left);
        Integer right = dfs(root.right);
        int val = root.val;
        int sum = root.val + (left == null ? 0 : left) + (right == null ? 0 : right);
        int leftSum = val + (left == null ? 0 : left);
        int rightSum = val + (right == null ? 0 : right);
        int max = Integer.MIN_VALUE;
        List<Integer> list;
        if(left == null && right == null) {
            list = List.of(val, sum, leftSum, rightSum);
        }else if(left == null) {
            list = List.of(val, sum, leftSum, rightSum, right);
        }else if(right == null) {
            list = List.of(val, sum, leftSum, rightSum, left);
        }else {
            list = List.of(val, sum, leftSum, rightSum, left, right);
        }
        for(int num : list) {
            max = Math.max(max, num);
        }
        ans = Math.max(max, ans);
        return Math.max(val, Math.max(leftSum, rightSum));
    }
}
