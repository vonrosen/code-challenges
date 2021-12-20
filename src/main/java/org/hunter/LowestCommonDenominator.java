package org.hunter;

public class LowestCommonDenominator{

	static class Node{
		Node left;
		Node right;
		Object object;

		Node(Object object){
			this.object = object;
		}

		@Override
		public boolean equals(Object obj){
			if(obj == null){
				return false;
			}
			return object.equals(((Node)obj).object);
		}

		@Override
		public String toString(){
			return object.toString();
		}

	}

	public static void main(String [] args){
		Node tree = new Node("top");
		tree.left = new Node("left");
		tree.right = new Node("right");
		tree.left.left = new Node("leftleft");
		tree.left.left.left = new Node("leftleftleft");
		tree.left.right = new Node("leftright");
		tree.left.right.right = new Node("leftrightright");

		System.out.println(lowest(tree, new Node("leftleft"), new Node("leftleftleft")));
		System.out.println(lowest(tree, new Node("right"), new Node("left")));
		System.out.println(lowest(tree, new Node("right2"), new Node("leftd3")));
		System.out.println(lowest(tree, new Node("top"), new Node("leftrightright")));
	}

	//assumptions: all values unique, both children exist in tree
	//N = height of tree. time=O(2^N) space=O(1)
	public static Node lowest(Node node, Node child1, Node child2){
		if(node == null){
			return null;
		}
		if(node.equals(child1) || node.equals(child2)){
			return node;
		}
		Node left = lowest(node.left, child1, child2);
		Node right = lowest(node.right, child1, child2);
		if(left != null && right != null){
			return node;
		}
		if(left != null){
			return left;
		}
		if(right != null){
			return right;
		}
		return null;
	}
}
