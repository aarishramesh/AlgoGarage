package trees;

import java.util.LinkedList;
import java.util.Queue;

public class AddGreaterValueToBSTNodes {
	private static Node next;

	public static void main(String[] args) {
		Node node = new Node(10);
		Node node1 = new Node(8);
		Node node2 = new Node(15);
		node.left = node1; node.right = node2;
		Node node3 = new Node(4);
		Node node4 = new Node(9);
		node1.left = node3;
		node1.right = node4;

		addGreaterValueEveryNode(node);

		printTreeNodes(node);
	}

	private static void addGreaterValueEveryNode(Node node) {
		if (node == null)
			return;
		addGreaterValueEveryNode(node.right);
		if(next != null)
			node.data += next.data;
		next = node;
		addGreaterValueEveryNode(node.left);
	}

	private static void printTreeNodes(Node node) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node tempNode = queue.remove();
			System.out.print(tempNode.data + " ");
			if (tempNode.left != null)
				queue.add(tempNode.left);
			if (tempNode.right != null)	
				queue.add(tempNode.right);
		}
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
