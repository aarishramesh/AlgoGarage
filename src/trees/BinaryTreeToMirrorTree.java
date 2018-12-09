package trees;

/**
 * https://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
 * 
 * @author polymath
 *
 */
public class BinaryTreeToMirrorTree {
	
	public static void main(String[] args) {
		Node root = new Node(5);
		Node left = new Node(10);
		Node right = new Node(15);
		root.left = left;
		root.right = right;
		left.left = new Node(20);
		left.right = new Node(25);
		right.left = new Node(30);
		right.right = new Node(35);
		
		convertToMirrorTree(root);
		
		inorderTraversal(root);
	}
	
	public static Node convertToMirrorTree(Node node) {
		if (node  == null)
			return null;
		node.left = convertToMirrorTree(node.left);
		node.right = convertToMirrorTree(node.right);
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
		return node;
	}
	
	public static void inorderTraversal(Node node) {
		if (node == null)
			return;
		inorderTraversal(node.left);
		System.out.print(node.data + " ");
		inorderTraversal(node.right);
	}
	
	static class Node {
		int data;
		Node left, right;
		
		Node(int data) {
			this.data = data;
		}
	}
}
