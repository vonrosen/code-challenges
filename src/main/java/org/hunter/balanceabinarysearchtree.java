package org.hunter;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class balanceabinarysearchtree {
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        build(root, list);
        return balanceBST(list, 0, list.size() - 1);
    }

    TreeNode balanceBST(List<TreeNode> list, int start, int end){
        if(start == end){
            return new TreeNode(list.get(start).val);
        }
        if(start > end){
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode left = balanceBST(list, start, mid - 1);
        TreeNode right = balanceBST(list, mid + 1, end);
        TreeNode node =  list.get(mid);
        node.left = left;
        node.right = right;
        return node;
    }

    void build(TreeNode node, List<TreeNode> list){
        if(node == null){
            return;
        }
        build(node.left, list);
        list.add(node);
        build(node.right, list);
    }
}
