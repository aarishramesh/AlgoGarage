package trees;

public class BinaryTreeToDllUsingRecursion {

	static Node leftMostNode;

	public static void main(String[] args) {
		Node node = new Node(10);
		Node node1 = new Node(12);
		Node node2 = new Node(15);
		node.left = node1; node.right = node2;
		Node node3 = new Node(25);
		Node node4 = new Node(30);
		node1.left = node3;
		node1.right = node4;

		Node root = binaryTreeToDll(node);
		printBtreeToDll(root);
	}

	private static void printBtreeToDll(Node node) {
		while(node.left != null)
			node = node.left;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.right;
		}
	}
	
 	public static Node binaryTreeToDll(Node node) {
		if (node == null)
			return node;
		if (node.left != null) {
			Node left = binaryTreeToDll(node.left);
			for (; left.right != null; left = left.right);
			node.left = left;
			left.right = node;
		}
		if (node.right != null) {
			Node right = binaryTreeToDll(node.right);
			for (; right.left != null; right = right.left);
			right.left = node;
			node.right = right;
		}
		return node;
	}
 	
 	static class Node {
		Node left, right;
		int data;
		
		Node(int data) {
			this.data = data;
		}
	}
}