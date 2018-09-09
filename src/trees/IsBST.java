package trees;

/**
 * Solution for https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem
 * 
 * @author polymath
 *
 */
public class IsBST {
	boolean checkBST(Node25 root) {
		if (root == null) {
			return true;
		}
		return BSTHelperUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	boolean BSTHelperUtil(Node25 node, int min, int max) {
		if (node == null) {
			return true;
		}
		if (node.data > min && node.data < max) {
			return (BSTHelperUtil(node.left, min, node.data) && BSTHelperUtil(node.right, node.data, max));
		} else {
			return false;
		}
	}
}


class Node25 {
	int data;
	Node25 left;
	Node25 right;
}


