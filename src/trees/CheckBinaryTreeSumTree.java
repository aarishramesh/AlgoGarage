package trees;

/**
 * https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
 * 
 * Corner Test cases - Empty tree, Single node tree, 
 * 
 * @author polymath
 *
 */
public class CheckBinaryTreeSumTree {

	public static void main(String[] args) {
		Node root = new Node(26);
		Node left = new Node(10);
		Node right = new Node(3);
		root.left = left; root.right = right;
		left.left = new Node(4); left.right = new Node(6);
		right.right = new Node(3);
		
		System.out.println(checkBtSumTree(root, new Value(0)));
	}
	
	public static boolean checkBtSumTree(Node node, Value h) {
		if (node == null)
			return true;
		Value lh = new Value(0);
		boolean isLeftSumTree = checkBtSumTree(node.left, lh);
		Value rh = new Value(0);
		boolean isRightSumTree = checkBtSumTree(node.right, rh);
		if (isLeftSumTree && isRightSumTree) {
			if ((node.left == null && node.right == null) ||	node.data == lh.val + rh.val) {
				h.val = node.data + lh.val + rh.val;
				return true;
			}
		}
		return false;
	}
	
	static class Node {
		int data;
		Node left, right;
		
		Node (int data) {
			this.data = data;
		}
	}
	
	static class Value {
		int val;
		
		Value(int val) {
			this.val = val;
		}
	}
}
