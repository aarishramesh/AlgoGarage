package trees;

import java.util.Deque;
import java.util.LinkedList;

public class TreeTraversalSpiralOrder {

	public static void main(String[] args) {
		Node root = new Node(1);
		Node left = new Node(2);
		Node right = new Node(3);
		root.left = left;
		root.right = right;
		left.left = new Node(7);
		left.right = new Node(6);
		right.left = new Node(5);
		right.right = new Node(4);

		// Using level order traversal
		/**
		boolean leftToRight = false;
		int height = heightOfBinaryTree(root);
		for (int level = 0; level < height; level++) {
			if (leftToRight) {
				treeTraversalSpiralOrder(level, root, true);
				leftToRight = false;
			} else {
				treeTraversalSpiralOrder(level, root, false);
				leftToRight = true;
			}
		} **/
		
		treeTraversalSpiralOrderUsingDequeue(root);
	}

	private static int heightOfBinaryTree(Node root) {
		if (root == null)
			return 0;
		int leftHeight = heightOfBinaryTree(root.left);
		int rightHeight = heightOfBinaryTree(root.right);
		return 1 + Math.max(leftHeight, rightHeight);
	}

	/**
	 * O(N^2) solution. Not so cool
	 * 
	 * Also a solution for printing nodes at a certain level O(N)
	 * 
	 * @param level
	 * @param root
	 * @param leftToRight
	 */
	public static void treeTraversalSpiralOrder(int level, Node root, boolean leftToRight) {
		if (level == 0) {
			System.out.print(root.data + " ");
			return;
		}
		if (leftToRight) {
			treeTraversalSpiralOrder(level - 1, root.left, leftToRight);
			treeTraversalSpiralOrder(level - 1, root.right, leftToRight);
		} else {
			treeTraversalSpiralOrder(level - 1, root.right, leftToRight);
			treeTraversalSpiralOrder(level - 1, root.left, leftToRight);
		}
	}
	
	/**
	 * Spiral order traversal of a tree using dequeue
	 * 
	 * @param root
	 */
	public static void treeTraversalSpiralOrderUsingDequeue(Node root) {
		Deque<Node>  dequeue = new LinkedList<Node>();
		dequeue.add(root); boolean takeFront = false;
		while (!dequeue.isEmpty()) {
			int size = dequeue.size();
			while (size > 0) {
				 if (takeFront) {
					 Node node = dequeue.removeFirst();
					 System.out.print(node.data + " ");
					 if (node.left != null)
						 dequeue.addLast(node.left);
					 if (node.right != null)
						 dequeue.addLast(node.right);
				 } else {
					 Node node = dequeue.removeLast();
					 System.out.print(node.data + " ");
					 if (node.right != null)
						 dequeue.addFirst(node.right);
					 if (node.left != null)
						 dequeue.addFirst(node.left);
				 }
				 size--;
			}
			takeFront = !takeFront;
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
