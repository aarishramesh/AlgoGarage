package trees;

/**
 * http://www.geeksforgeeks.org/full-and-complete-binary-tree-from-given-preorder-and-postorder-traversals/
 * 
 * Full tree is a tree with all nodes with either 0 or 2 child. Never has 1 child.
 * Test cases
 * Empty tree
 * Tree with big on left side
 * Tree with big on right side
 * 
 * @author polymath
 */
public class ConstFullTreePreOrderPostOrder {

	static int preIndex = 1;
	
	public static void main(String[] args) {
		int preorder[] = {1, 2, 4, 8, 9, 5, 3, 6, 7};
        int postorder[] = {8, 9, 4, 5, 2, 6, 7, 3, 1};
		Node root = new Node(preorder[0]);
		root.left = constTree(root, preorder, postorder, 0, preorder.length - 1);
		
		printInorder(root);
	}
	
	public static Node constTree(Node root, int[] preOrder, int[] postOrder, int left, int right) {
		if (left > right || preIndex > preOrder.length - 1)
			return null;
		Node node = new Node(preOrder[preIndex]);
		int indexInPostArr = findIndexInPostArr(postOrder, preOrder[preIndex], left, right);
		preIndex++;
		if (left == right)
			return node;
		
		node.left = constTree(node, preOrder, postOrder, left, indexInPostArr - 1);
		root.right = constTree(root, preOrder, postOrder, indexInPostArr + 1, right);
		
		return node;
	}
	
	// Needs to be optimised by creating a hashmap
	static int findIndexInPostArr(int[] postArr, int element, int start, int end) {
		for (int i = start; i <= end; i++) {
			if (postArr[i] == element)
				return i;
		}
		return -1;
	}
	
	static void printInorder(Node root) {
		if (root == null)
			return;
		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);
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
