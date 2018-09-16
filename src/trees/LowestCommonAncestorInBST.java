package trees;

/**
 * https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
 * 
 * @author polymath
 *
 */
public class LowestCommonAncestorInBST {
	public static Node lcaInBst(Node root, int a , int b) {
		if (root.data > a && root.data < b) {
			return root;
		} else if (root.data > Math.max(a, b)) {
			return lcaInBst(root.left, a, b);
		} else {
			return lcaInBst(root.right, a, b);
		}
	}
	
	static class Node {
		int data;
		Node left;
		Node right;
	}
}
