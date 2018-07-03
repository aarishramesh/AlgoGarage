package trees;

/**
 * https://www.geeksforgeeks.org/convert-an-arbitrary-binary-tree-to-a-tree-that-holds-children-sum-property/
 * 
 * Run time complexity : O(N * 2)
 * 
 * Space time complexity : O(1) if stack size is not taken into account
 * 
 * @author polymath
 *
 */
public class ArbitraryTreeToChildSumTreeNonDec {
	public static void main(String[] args) {
		Node7 node = new Node7(32);
		Node7 node1 = new Node7(13);
		Node7 node2 = new Node7(15);
		node.left = node1; node.right = node2;
		Node7 node3 = new Node7(3);
		Node7 node4 = new Node7(10);
		node1.left = node3;
		node1.right = node4;
		
		convertBinaryTreeToChildSumNonDec(node);
		
		printPostOrderBinaryTree(node);
	}
	
	private static void printPostOrderBinaryTree(Node7 node) {
		if (node == null)
			return;
		printPostOrderBinaryTree(node.left);
		printPostOrderBinaryTree(node.right);
		System.out.print(node.data + " ");
	}
	
	private static void convertBinaryTreeToChildSumNonDec(Node7 node) {
		if (node == null || (node.left == null && node.right == null))
			return;
		convertBinaryTreeToChildSumNonDec(node.left);
		convertBinaryTreeToChildSumNonDec(node.right);
		int leftVal = node.left != null ? node.left.data : 0;
		int rightVal = node.right != null ? node.right.data : 0;
		if (node.data < leftVal + rightVal) {
			node.data = leftVal + rightVal;
		} else if (node.data > leftVal + rightVal) {
			if (node.left != null) {
				node.left.data += node.data - (node.left.data + node.right.data);
				convertBinaryTreeToChildSumNonDec(node.left);
			} else {
				node.right.data += node.data - node.right.data;
				convertBinaryTreeToChildSumNonDec(node.right);
			}
		}
	}
}


class Node7 {
	int data;
	Node7 left;
	Node7 right;
	
	Node7(int data) {
		this.data = data;
	}
}