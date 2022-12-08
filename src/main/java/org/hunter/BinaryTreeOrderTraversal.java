package org.hunter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/binary-tree-level-order-traversal/description/
public class BinaryTreeOrderTraversal{

	public static void main(String [] args){
		//[3,9,20,null,null,15,7]
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		BinaryTreeOrderTraversal binaryTreeOrderTraversal = new BinaryTreeOrderTraversal();
		System.out.println(binaryTreeOrderTraversal.levelOrder(root));
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		HashMap<Integer,List<Integer>> levels = new LinkedHashMap<>();
		levelOrder(root, 0, levels);
		List<List<Integer>> lists = new ArrayList<>();
		for(List<Integer> list : levels.values()){
			lists.add(list);
		}
		return lists;
	}

	private void levelOrder(TreeNode node, int level, Map<Integer,List<Integer>> levels){
		if(node == null){
			return;
		}
		List<Integer> nodes = levels.get(level);
		if(nodes == null){
			List<Integer> list = new ArrayList<>();
			list.add(node.val);
			levels.put(level, list);
		}else{
			nodes.add(node.val);
		}
		levelOrder(node.left, level + 1, levels);
		levelOrder(node.right, level + 1, levels);
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
