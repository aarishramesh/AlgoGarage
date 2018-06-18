package trees;

public class BinaryTreeToDllUsingRecursion {

	static Node2 leftMostNode;

	public static void main(String[] args) {
		Node2 node = new Node2(10);
		Node2 node1 = new Node2(12);
		Node2 node2 = new Node2(15);
		node.left = node1; node.right = node2;
		Node2 node3 = new Node2(25);
		Node2 node4 = new Node2(30);
		node1.left = node3;
		node1.right = node4;

		Node2 root = binaryTreeToDll(node);
		printBtreeToDll(root);
	}

	private static void printBtreeToDll(Node2 node) {
		while(node.left != null)
			node = node.left;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.right;
		}
	}
	
 	public static Node2 binaryTreeToDll(Node2 node) {
		if (node == null)
			return node;
		if (node.left != null) {
			Node2 left = binaryTreeToDll(node.left);
			for (; left.right != null; left = left.right);
			node.left = left;
			left.right = node;
		}
		if (node.right != null) {
			Node2 right = binaryTreeToDll(node.right);
			for (; right.left != null; right = right.left);
			right.left = node;
			node.right = right;
		}
		return node;
	}
}

class Node2 {
	int data;
	Node2 left;
	Node2 right;

	Node2(int data) {
		this.data = data;
	}
}