package trees;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * Time complexity O(logn)
 *
 * Reference
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class BinaryTreeBalanced {
	
	public static boolean isBinaryTreeBalanced(Node root, Height h) {
		if (root == null)
			return true;
		Height leftHeight = new Height();
		boolean isLeftSubtreeBal = isBinaryTreeBalanced(root.left, leftHeight);
		Height rightHeight = new Height();
		boolean isRightSubtreeBal = isBinaryTreeBalanced(root.right, rightHeight);
		if (isLeftSubtreeBal && isRightSubtreeBal &&
				Math.abs(leftHeight.h - rightHeight.h) < 2) {
			h.h = 1 + Math.max(leftHeight.h, rightHeight.h);
			return true;
		} else 
			return false;
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
		node2.left = new Node(25);
		node2.right = new Node(45);
		
		System.out.println(isBinaryTreeBalanced(node, new Height()));
	}
	
	// Method 2 from tushar roy
	public boolean isBalanced(Node root) {
        return isBalancedUtil(root) >= 0;
    }

    private int isBalancedUtil(Node root) {
        if (root == null) {
            return 0;
        }
        int left = isBalancedUtil(root.left);
        if (left < 0) {
            return -1;
        }
        int right = isBalancedUtil(root.right);
        if (right < 0) {
            return -1;
        }
        int diff = Math.abs(left - right);
        return diff <= 1 ? (Math.max(left, right) + 1) : -1;
    }
    
	static class Height {
		int h;
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
