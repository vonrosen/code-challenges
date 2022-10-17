package org.hunter;

//https://leetcode.com/problems/validate-binary-search-tree/
public class ValidBst{

	public static void main(String [] args){
		ValidBst validBst = new ValidBst();

		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		System.out.println(validBst.isValidBST(root));

		root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(6);
		System.out.println(validBst.isValidBST(root));

		root = new TreeNode(0);
		root.left = new TreeNode(-1);
		System.out.println(validBst.isValidBST(root));

		//[5,4,6,null,null,3,7]
		//false expected
		root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(6);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(7);
		System.out.println(validBst.isValidBST(root));
	}

	public boolean isValidBST(TreeNode root) {
		if(root == null){
			return true;
		}

		if(root.left == null && root.right == null){
			return true;
		}

		return isValidBST(root.left, null, root.val) && isValidBST(root.right, root.val, null);
	}

	public boolean isValidBST(TreeNode root, Integer min, Integer max){
		if(root == null){
			return true;
		}

		if(max != null && root.val >= max){
			return false;
		}

		if(min != null && root.val <= min){
			return false;
		}

		return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
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
