package org.hunter;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/clone-graph/submissions/
 */
public class CloneGraph{
	public static void main(String [] args){
		CloneGraph cloneGraph = new CloneGraph();
		Node node = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		node.neighbors.addAll(List.of(node2, node4));
		node2.neighbors.addAll(List.of(node, node3));
		node3.neighbors.addAll(List.of(node2, node4));
		node4.neighbors.addAll(List.of(node, node3));
		Node copy = cloneGraph.cloneGraph(node);
		System.out.println(copy);
	}

	public Node cloneGraph(Node node) {
		if(node == null){
			return null;
		}
		Node newNode = new Node(node.val);
		List<Node> processedNode = new ArrayList<>();
		processedNode.add(newNode);
		for(Node neighbor: node.neighbors){
			Node copyNode = cloneGraph(newNode, neighbor, processedNode);
			if(!exists(copyNode, newNode.neighbors)){
				newNode.neighbors.add(copyNode);
			}
		}
		return newNode;
	}

	public boolean exists(Node node, List<Node> nodes){
		for(Node n : nodes){
			if(n.val == node.val){
				return true;
			}
		}
		return false;
	}

	public Node getNode(Node node, List<Node> nodes){
		for(Node n : nodes){
			if(n.val == node.val){
				return n;
			}
		}
		return null;
	}

	public Node cloneGraph(Node copyNode, Node node, List<Node> processedNode){
		Node n = getNode(node, processedNode);
		if(n != null){
			return n;
		}
		Node newNode = new Node(node.val);
		if(!exists(newNode, copyNode.neighbors)){
			copyNode.neighbors.add(newNode);
		}
		processedNode.add(newNode);
		for(Node neighbor : node.neighbors){
			Node copy = cloneGraph(newNode, neighbor, processedNode);
			if(!exists(copy, newNode.neighbors)){
				newNode.neighbors.add(copy);
			}
		}
		return newNode;
	}

}

class Node {
	public int val;
	public List<Node> neighbors;
	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}
	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}
	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}
