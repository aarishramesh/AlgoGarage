package trees;

/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * 
 * https://leetcode.com/problems/closest-binary-search-tree-value/
 */
public class ClosestValueBinaryTree {
	static int closestValue;

	public static void closestValueBST(Node node, int target) {
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
		Node node = new Node(15);
		Node node1 = new Node(13);
		Node node2 = new Node(20);
		node.left = node1; node.right = node2;
		Node node3 = new Node(4);
		Node node4 = new Node(14);
		node1.left = node3;
		node1.right = node4;

		closestValue = 15;
		closestValueBST(node, 10);
		System.out.println(closestValue);
	}


	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}
}