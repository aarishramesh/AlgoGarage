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
		Node root = new Node(20);
		Node leftChild = new Node(8);
		Node rightChild = new Node(22);
		root.left = leftChild;
		root.right = rightChild;
		rightChild.right = new Node(25);
		leftChild.left = new Node(4);
		leftChild.right = new Node(12);
		leftChild.right.left = new Node(10);
		leftChild.right.right = new Node(14);
		
		boundaryTraversal(root);
	}

	static void boundaryTraversal(Node root) {
		if (root != null) {
			System.out.println(root.data);
			printLeftBoundary(root.left);
			printLeaves(root.left);
			printLeaves(root.right);
			printRightBoundary(root.right);
		}
	}

	private static void printLeftBoundary(Node root) {
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

	private static void printRightBoundary(Node root) {
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

	private static void printLeaves(Node root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			System.out.println(root.data);
			return;
		}
		printLeaves(root.left);
		printLeaves(root.right);
	}
	
	static class Node {
		Node left, right;
		int data;
		
		Node(int data) {
			this.data = data;
		}
	}
}