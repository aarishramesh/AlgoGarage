package trees;

/**
 * Using reverse inorder traversal
 * 
 * https://www.geeksforgeeks.org/populate-inorder-successor-for-all-nodes/
 * 
 * @author polymath
 *
 */
public class PopulateInorderSuccessor {

	public static void main(String[] args) {
		Node root = new Node(4);
		Node left = new Node(2);
		Node right = new Node(6);
		root.left = left;
		root.right = right;
		left.left = new Node(1);
		left.right = new Node(3);
		right.left = new Node(5);
		right.right = new Node(7);
		
		populateInorderSuccessor(root);
		
		printInorderSucc(left.left);
	}
	
	private static void printInorderSucc(Node root) {
		while (root != null) {
			System.out.print(root.data + " ");
			root = root.next;
		}
	}
	
	static Node inOrderSucc = null; 
			
	private static void populateInorderSuccessor(Node node) {
		if (node == null)
			return;
		populateInorderSuccessor(node.right);
		node.next = inOrderSucc;
		inOrderSucc = node;
		populateInorderSuccessor(node.left);
	}
	
	static class Node {
		int data;
		Node left;
		Node right;
		Node next;
		
		Node(int data) {
			this.data = data;
		}
	}
}
