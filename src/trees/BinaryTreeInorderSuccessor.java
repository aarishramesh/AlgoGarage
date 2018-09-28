package trees;

/**
 * 
 * 
 * @author polymath
 *
 */
public class BinaryTreeInorderSuccessor {

	private static Node prev;

	private static Node next;

	public static void main(String[] args) {
		Node node = new Node(10);
		Node node1 = new Node(12);
		Node Node = new Node(15);
		node.left = node1; node.right = Node;
		Node node3 = new Node(25);
		Node node4 = new Node(30);
		node1.left = node3;
		node1.right = node4;

		//inorderSuccessor(node);
		//printInorderSuccessor(node);

		reverseInorderSuccessor(node);
		printReverseInorderSuccessor(node);
	}

	static void inorderSuccessor(Node node) {
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

	static void reverseInorderSuccessor(Node node) {
		if (node == null)
			return;
		reverseInorderSuccessor(node.right);
		if (next != null)
			next.left = node;
		next = node;
		reverseInorderSuccessor(node.left);
	}

	static void printInorderSuccessor(Node node) {
		Node startingNode = node;
		while (startingNode.left != null)
			startingNode = startingNode.left;
		do {
			System.out.print(startingNode.data + " ");
			startingNode = startingNode.right;
		} while (startingNode != null);
	}

	static void printReverseInorderSuccessor(Node node) {
		Node startingNode = node;
		while (startingNode.right != null)
			startingNode = startingNode.right;
		do {
			System.out.print(startingNode.data + " ");
			startingNode = startingNode.left;
		} while (startingNode != null);
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
