package trees;

/**
 * https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 * 
 * @author polymath
 *
 */
public class LowestCommonAncestorInBinaryTree {

	static Node leftParent, rightParent;
	
	public static Node lcaInBinaryTree(Node root, int a
			, int b) {
		if (root == null)
			return null;
		if (root.data == a || root.data == b)
			return root;
		Node left = lcaInBinaryTree(root.left, a, b);
		Node right = lcaInBinaryTree(root.right, a, b);
		if (left != null && right != null)
			return root;
		return left != null ? left : right;
	}
	
	static class Node {
		int data;
		Node left;
		Node right;
	}
}
