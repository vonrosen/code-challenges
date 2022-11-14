package org.hunter;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/
 */
public class PathToSum{

	public static void main(String [] args){
		//[5,4,8,11,null,13,4,7,2,null,null,5,1]
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);

		PathToSum pathToSum = new PathToSum();
		System.out.println(pathToSum.pathSum(root, 22));

		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(pathToSum.pathSum(root, 5));

		root = new TreeNode(1);
		root.left = new TreeNode(2);
		System.out.println(pathToSum.pathSum(root, 0));

		root = new TreeNode(1);
		root.left = new TreeNode(2);
		System.out.println(pathToSum.pathSum(root, 1));

		root = new TreeNode(1);
		System.out.println(pathToSum.pathSum(root, 1));

		root = new TreeNode(-2);
		root.right = new TreeNode(-3);
		System.out.println(pathToSum.pathSum(root, -5));

		//[1,2,null,3,null,4,null,5]
		//6
		//[]
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.left.left.left.left = new TreeNode(5);
		System.out.println(pathToSum.pathSum(root, 6));

		//[1,-2,-3,1,3,-2,null,-1]
		//-1
		//[[1,-2,1,-1]]
		root = new TreeNode(1);
		root.left = new TreeNode(-2);
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(1);
		root.left.left.left = new TreeNode(-2);
		root.right.left = new TreeNode(-1);
		System.out.println(pathToSum.pathSum(root, -1));

		root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(-1);
		root.left.left = new TreeNode(1);
		root.left.left.left = new TreeNode(-1);
		root.right.left = new TreeNode(0);
		System.out.println(pathToSum.pathSum(root, 0));
	}

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		if(root == null){
			return new ArrayList<>();
		}
		if(root.val == targetSum && root.left == null && root.right == null){
			List<List<Integer>> paths = new ArrayList<>();
			List<Integer> path = new ArrayList<>();
			path.add(root.val);
			paths.add(path);
			return paths;
		}
		return pathToSum(root, 0, targetSum, new ArrayList<>(), new ArrayList<>());
	}

	private List<List<Integer>> pathToSum(TreeNode node, int sum, int targetSum, List<Integer> path,
			List<List<Integer>> paths){
		if(node == null){
			return paths;
		}
		if(node.val + sum != targetSum){
			return continueNavigatePath(node, sum, targetSum, path, paths);
		}else if(node.left == null && node.right == null){
			path.add(node.val);
			paths.add(path);
			return paths;
		}else{
			return continueNavigatePath(node, sum, targetSum, path, paths);
		}
	}

	private List<List<Integer>> continueNavigatePath(TreeNode node, int sum, int targetSum,
			List<Integer> path, List<List<Integer>> paths){
		path.add(node.val);
		List<Integer> newPath = new ArrayList<>(path);
		pathToSum(node.left, node.val + sum, targetSum, path, paths);
		pathToSum(node.right, node.val + sum, targetSum, newPath, paths);
		return paths;
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
