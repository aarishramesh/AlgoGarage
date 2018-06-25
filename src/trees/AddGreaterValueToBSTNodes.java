package trees;

import java.util.LinkedList;
import java.util.Queue;

public class AddGreaterValueToBSTNodes {
	private static Node4 next;
	
	public static void main(String[] args) {
		Node4 node = new Node4(10);
		Node4 node1 = new Node4(8);
		Node4 node2 = new Node4(15);
		node.left = node1; node.right = node2;
		Node4 node3 = new Node4(4);
		Node4 node4 = new Node4(9);
		node1.left = node3;
		node1.right = node4;
		
		addGreaterValueEveryNode(node);
		
		printTreeNodes(node);
	}
	
	private static void addGreaterValueEveryNode(Node4 node) {
		if (node == null)
			return;
		addGreaterValueEveryNode(node.right);
		if(next != null)
			node.data += next.data;
		next = node;
		addGreaterValueEveryNode(node.left);
	}
	
	private static void printTreeNodes(Node4 node) {
		Queue<Node4> queue = new LinkedList<Node4>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node4 tempNode = queue.remove();
			System.out.print(tempNode.data + " ");
			if (tempNode.left != null)
				queue.add(tempNode.left);
			if (tempNode.right != null)	
				queue.add(tempNode.right);
		}
	}
}

class Node4 {
	int data;
	Node4 left;
	Node4 right;
	
	Node4(int data) {
		this.data = data;
	}
}