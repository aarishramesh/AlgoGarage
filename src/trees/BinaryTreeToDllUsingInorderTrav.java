package trees;

public class BinaryTreeToDllUsingInorderTrav {

	static Node prev;
	static Node head;

	public static void main(String[] args) {
		Node node = new Node(10);
		Node node1 = new Node(12);
		Node node2 = new Node(15);
		node.left = node1; node.right = node2;
		Node node3 = new Node(25);
		Node node4 = new Node(30);
		node1.left = node3;
		node1.right = node4;
		
		inorderTrav(node);
		printBtreeToDll(head);
	}
	
	static void inorderTrav(Node root) {
		if (root == null)
			return;
		inorderTrav(root.left);
		if (prev == null) {
			head = root;
		} else {
			prev.right = root;
			root.left = prev;
		}
		prev = root; 
		inorderTrav(root.right);
	}
	
	private static void printBtreeToDll(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.right;
		}
	}
	
	static class Node {
		Node left, right;
		int data;
		
		Node(int data) {
			this.data = data;
		}
	}
}