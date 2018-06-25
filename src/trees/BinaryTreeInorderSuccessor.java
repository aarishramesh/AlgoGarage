package trees;

public class BinaryTreeInorderSuccessor {
		
	private static Node3 prev;
	
	public static void main(String[] args) {
		Node3 node = new Node3(10);
		Node3 node1 = new Node3(12);
		Node3 Node3 = new Node3(15);
		node.left = node1; node.right = Node3;
		Node3 node3 = new Node3(25);
		Node3 node4 = new Node3(30);
		node1.left = node3;
		node1.right = node4;
		
		inorderSuccessor(node);
		printInorderSuccessor(node);
	}
	
	static void inorderSuccessor(Node3 node) {
		if (node == null) {
			return;
		}
		inorderSuccessor(node.left);
		if (prev != null) {
			prev.right = node;
		}
		prev = node;
		inorderSuccessor(node.right);
	}
	
	static void printInorderSuccessor(Node3 node) {
		Node3 startingNode = node;
		while (startingNode.left != null)
			startingNode = startingNode.left;
		do {
			System.out.print(startingNode.data + " ");
			startingNode = startingNode.right;
		} while (startingNode != null);
	}
}

class Node3 {
	int data;
	Node3 left;
	Node3 right;
	
	Node3(int data) {
		this.data = data;
	}
}