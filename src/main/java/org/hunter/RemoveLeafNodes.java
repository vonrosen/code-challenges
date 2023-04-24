package org.hunter;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-leaves-of-binary-tree/description/
public class RemoveLeafNodes{

	public static void main(String [] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		RemoveLeafNodes removeLeafNodes = new RemoveLeafNodes();
		System.out.println(removeLeafNodes.findLeaves(root));
	}

	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> deletedNodes = new ArrayList<>();
		while(root.left != null || root.right != null){
			List<Integer> deleted = new ArrayList<>();
			findLeaves(root, deleted);
			deletedNodes.add(deleted);
			prune(root);
		}
		deletedNodes.add(List.of(root.val));
		return deletedNodes;
	}

	//time complexity = 2*O(N) = O(N)
	public void findLeaves(TreeNode root, List<Integer> deleted){
		if(root == null){
			return;
		}
		if(root.left == null && root.right == null){
			deleted.add(root.val);
			return;
		}
		findLeaves(root.left, deleted);
		if(root.left != null && root.left.left == null && root.left.right == null){
			root.left.val = -101;
		}
		findLeaves(root.right, deleted);
		if(root.right != null && root.right.left == null && root.right.right == null){
			root.right.val = -101;
		}
	}

	public void prune(TreeNode root){
		if(root == null){
			return;
		}
		if(root.left != null && root.left.val == -101){
			root.left = null;
		}
		if(root.right != null && root.right.val == -101){
			root.right = null;
		}
		prune(root.left);
		prune(root.right);
	}

	 public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode() {}
	     TreeNode(int val) { this.val = val; }
	     TreeNode(int val, TreeNode left, TreeNode right) {
	         this.val = val;
	         this.left = left;
	         this.right = right;
	     }
	 }
}
