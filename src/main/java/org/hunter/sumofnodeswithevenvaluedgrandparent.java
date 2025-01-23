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
class sumofnodeswithevenvaluedgrandparent {
    
    int ans = 0;
    public int sumEvenGrandparent(TreeNode root) {
        Set<Integer> takeAction = new HashSet<>();
        sumEvenGrandparent(root, 0, takeAction);
        return ans;
    }

    void sumEvenGrandparent(TreeNode root, int level, Set<Integer> takeAction){
        if(root == null){
            return;
        }
        if(root.val % 2 == 0){
            takeAction.add(level + 2);
        }
        if(takeAction.contains(level)){
            ans += root.val;
        }
        sumEvenGrandparent(root.left, level + 1, takeAction);
        sumEvenGrandparent(root.right, level + 1, takeAction);
        takeAction.remove(level + 2);        
    }
}
