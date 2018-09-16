package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/level-order-tree-traversal/
 * 
 * @author polymath
 *
 */
public class LevelOrderTraversal {
	
	public static void levelOrderTraversal(Node root) {
		Queue<Node> nodesQueue = new LinkedList<Node>();
		nodesQueue.add(root);
		while (!nodesQueue.isEmpty()) {
			Node node = nodesQueue.poll();
			System.out.println(node.data);
			if (node.left != null)
				nodesQueue.add(node.left);
			if (node.right != null)
				nodesQueue.add(node.right);
		}
			
	}
	
	static class Node {
		int data;
		Node left;
		Node right;
	}
}
