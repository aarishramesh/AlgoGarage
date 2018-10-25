package trees;

/**
* Given a complete binary tree, count the number of nodes.
*
* Time complexity O(log(n) ^ 2)
*
* Reference
* https://leetcode.com/problems/count-complete-tree-nodes/
*/
public class CountNodesCompleteTree {

	public static int countNodesCompleteTree(Node24 root) {
		if (root == null)
			return 0;
		int lh = leftHeight(root.left);
		int rh = rightHeight(root.right);
		int rlh = rightHeight(root.left);
		if (lh == rh) {
			// If left height and right heights are equal then tree is complete and full so return the height 2 ^h - 1
			return (1 << lh + 1) - 1;
		} else {
			if (lh == rlh) {
				// If left sub tree is full then right sub tree is not full so 
				//     find out the height and sum it with left sub tree tree height plus root
				return 1 + countNodesCompleteTree(root.right) + (1 << lh) - 1;
			} else {
				// If left subtree is not full then right sub tree is full so 
				//     find out the height of right full sub tree and sum it with right sub tree
				return 1 + countNodesCompleteTree(root.left) + (1 << rh) - 1;
			}
		}
	}
	
	static int rightHeight(Node24 node) {
		int h = 0;
		while (node != null) {
			node = node.right;
			h++;
		}
		return h;
	}
	
	static int leftHeight(Node24 node) {
		int h = 0;
		while (node != null) {
			node = node.left;
			h++;
		}
		return h;
	}

	static class Node24 {
		int data;
		Node24 left;
		Node24 right;
	}
}
