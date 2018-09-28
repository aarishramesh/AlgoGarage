package trees;

/**
 *
 * Given a binary tree, find the maximum path sum. For this problem, a path is defined as any sequence of nodes
 * from some starting node to any node in the tree along the parent-child connections.
 * 
 * Time complexity O(n)
 * Space complexity depends on depth of tree.
 *
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaxPathSum {
	static int maxSum = 0;

	public static void main(String[] args) {
		Node root = new Node(10);
		Node leftChild = new Node(9);
		Node rightChild = new Node(20);
		root.left = leftChild;
		root.right = rightChild;
		rightChild.left = new Node(15);
		rightChild.right = new Node(7);

		maxPathSum(root);

		System.out.println(maxSum);
	}

	static int maxPathSum(Node root) {
		if (root == null)
			return 0;
		int leftMax = maxPathSum(root.left);
		int rightMax = maxPathSum(root.right);
		int maxSingle = Math.max(root.data + Math.max(leftMax, rightMax), root.data);
		maxSum = Math.max(maxSum, Math.max(maxSingle, root.data + leftMax + rightMax));
		return maxSingle;
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