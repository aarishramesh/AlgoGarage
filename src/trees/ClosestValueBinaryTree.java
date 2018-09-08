package trees;

/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * 
 * https://leetcode.com/problems/closest-binary-search-tree-value/
 */
public class ClosestValueBinaryTree {
	static int closestValue;
	
	public static void closestValueBST(Node22 node, int target) {
		if (node == null) {
			return;
		}
		if (node.data - target == 0) {
			closestValue = node.data;
			return;
		}
		if (Math.abs(node.data - target) < Math.abs(closestValue - target)) {
			closestValue = node.data;
		}
		if (node.data - target < 0) {
			closestValueBST(node.right, target);
		} else {
			closestValueBST(node.left, target);
		}
	}
	
	public static void main(String[] args) {
		Node22 node = new Node22(15);
		Node22 node1 = new Node22(13);
		Node22 node2 = new Node22(20);
		node.left = node1; node.right = node2;
		Node22 node3 = new Node22(4);
		Node22 node4 = new Node22(14);
		node1.left = node3;
		node1.right = node4;
		
		closestValue = 15;
		closestValueBST(node, 10);
		System.out.println(closestValue);
	}
}

class Node22 {
	int data;
	Node22 left;
	Node22 right;
	
	Node22(int data) {
		this.data = data;
	}
}