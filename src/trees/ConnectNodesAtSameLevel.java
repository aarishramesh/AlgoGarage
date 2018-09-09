package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Using level order traversal and null markers in the 
 * 
 * https://www.geeksforgeeks.org/connect-nodes-level-level-order-traversal/
 * https://ide.geeksforgeeks.org/gV1Oc2 - Alternate approach
 * 
 * @author polymath
 *
 */
public class ConnectNodesAtSameLevel {

	public static void main(String[] args) {
		Node23 node = new Node23(15);
		Node23 node1 = new Node23(13);
		Node23 node2 = new Node23(20);
		node.left = node1; node.right = node2;
		Node23 node3 = new Node23(4);
		Node23 node4 = new Node23(14);
		node1.left = node3;
		node1.right = node4;
		
		connectNodes(node);

	}
	
	public static void connectNodes(Node23 root) {
		Queue<Node23> nodes = new LinkedList<Node23>();
		nodes.add(root);
		nodes.add(null);
		while (!nodes.isEmpty()) {
			Node23 node = nodes.remove();
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
	
	static class Node23 {
		int data;
		Node23 left;
		Node23 right;
		Node23 nextRight;
		
		Node23(int data) {
			this.data = data;
		}
	}
}


