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
		Node15 root = new Node15(10);
		Node15 leftChild = new Node15(9);
		Node15 rightChild = new Node15(20);
		root.left = leftChild;
		root.right = rightChild;
		rightChild.left = new Node15(15);
		rightChild.right = new Node15(7);
		
		maxPathSum(root);
		
		System.out.println(maxSum);
	}

	static int maxPathSum(Node15 root) {
		if (root == null)
			return 0;
		int leftMax = maxPathSum(root.left);
		int rightMax = maxPathSum(root.right);
		int maxSingle = Math.max(root.data + Math.max(leftMax, rightMax), root.data);
		maxSum = Math.max(maxSum, Math.max(maxSingle, root.data + leftMax + rightMax));
		return maxSingle;
	}
}

class Node15 {
	int data;
	Node15 left;
	Node15 right;

	Node15(int data) {
		this.data = data;
	}
}