package trees;

/**
 * Given a binary tree, count the number of uni-value subtrees.
 * A Uni-value subtree means all nodes of the subtree have the same value.
 *
 * https://leetcode.com/problems/count-univalue-subtrees/
 * 
 * https://www.geeksforgeeks.org/find-count-of-singly-subtrees/
 * 
 */
public class CountUniValueTrees {
	
	static int count = 0;
	
	public static boolean countUniValueTree(Node root) {
		if (root == null)
			return true;
		boolean leftSubTree = countUniValueTree(root.left);
		boolean rightSubTree = countUniValueTree(root.right);
		
		if (leftSubTree == false || rightSubTree == false)
			return false;
		if (root.left != null && root.data != root.left.data)
			return false;
		if (root.right != null && root.data != root.right.data)
			return false;
		count++;
		return true;
	}

	static class Node {
		int data;
		Node left;
		Node right;
	}
}
