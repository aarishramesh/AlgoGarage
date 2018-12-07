package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Using level order traversal and adding null markers in the queue to separate different levels
 * 
 * https://www.geeksforgeeks.org/connect-nodes-level-level-order-traversal/
 * 
 * https://ide.geeksforgeeks.org/gV1Oc2 - Alternate approach
 * 
 * @author polymath
 *
 */
public class ConnectNodesAtSameLevel {

	public static void main(String[] args) {
		Node node = new Node(15);
		Node node1 = new Node(13);
		Node node2 = new Node(20);
		node.left = node1; node.right = node2;
		Node node3 = new Node(4);
		Node node4 = new Node(14);
		node1.left = node3;
		node1.right = node4;
		
		connectNodes(node);

	}
	
	public static void connectNodes(Node root) {
		Queue<Node> nodes = new LinkedList<Node>();
		nodes.add(root);
		nodes.add(null);
		while (!nodes.isEmpty()) {
			Node node = nodes.remove();
			if (node != null) {
				node.nextRight = nodes.peek();
				if (node.left != null)
					nodes.add(node.left);
				if (node.right != null)
					nodes.add(node.right);
			} else if (!nodes.isEmpty()){
				nodes.add(null);
			}
		}
	}
	
	static class Node {
		int data;
		Node left;
		Node right;
		Node nextRight;
		
		Node(int data) {
			this.data = data;
		}
	}
}


