package trees;

/**
 * https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
 * 
 * Run time complexity O(N) 
 * 
 * Tricky part is when leftSubTree has right boundaries and vice-versa. Needs to be taken care while printing boundaries
 * 
 * @author polymath
 *
 */
public class BoundaryTraversal {

	public static void main(String[] args) {
		Node20 root = new Node20(20);
		Node20 leftChild = new Node20(8);
		Node20 rightChild = new Node20(22);
		root.left = leftChild;
		root.right = rightChild;
		rightChild.right = new Node20(25);
		leftChild.left = new Node20(4);
		leftChild.right = new Node20(12);
		leftChild.right.left = new Node20(10);
		leftChild.right.right = new Node20(14);
		
		boundaryTraversal(root);
	}

	static void boundaryTraversal(Node20 root) {
		if (root != null) {
			System.out.println(root.data);
			printLeftBoundary(root.left);
			printLeaves(root.left);
			printLeaves(root.right);
			printRightBoundary(root.right);
		}
	}

	private static void printLeftBoundary(Node20 root) {
		if (root == null)
			return;
		if (root.left != null) {
			System.out.println(root.data);
			printLeftBoundary(root.left);
		} else if (root.right != null) {
			System.out.println(root.data);
			printLeftBoundary(root.right);
		}
		// Not printing leaf nodes to avoid duplicates
	}

	private static void printRightBoundary(Node20 root) {
		if (root == null)
			return;
		if (root.right != null) {
			printRightBoundary(root.right);
			System.out.println(root.data);
		} else if (root.left != null) {
			printRightBoundary(root.left);
			System.out.println(root.data);
		}
		// Not printing leaf nodes to avoid duplicates
	}

	private static void printLeaves(Node20 root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			System.out.println(root.data);
			return;
		}
		printLeaves(root.left);
		printLeaves(root.right);
	}
}

class Node20 {
	int data;
	Node20 left;
	Node20 right;

	Node20(int data) {
		this.data = data;
	}
}