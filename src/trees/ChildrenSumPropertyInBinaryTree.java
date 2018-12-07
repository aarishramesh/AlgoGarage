package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Check if children property holds i.e Root element is the sum of the left and right sum values
 * 
 * Using level order traversal
 * 
 * This is just to check whether children sum property holds and is different from arbitrary tree to children sum tree
 *  in a non-decreasing manner
 * 
 * @author polymath
 *
 */
public class ChildrenSumPropertyInBinaryTree {

	public static void main(String[] args) {
		Node node = new Node(28);
		Node node1 = new Node(13);
		Node node2 = new Node(15);
		node.left = node1; node.right = node2;
		Node node3 = new Node(4);
		Node node4 = new Node(9);
		node1.left = node3;
		node1.right = node4;

		System.out.println(IsCheckSumPropertyHolds(node));
	}

	private static boolean IsCheckSumPropertyHolds(Node node) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		boolean checkSumHolds = true;
		while (!queue.isEmpty()) {
			Node currNode = queue.remove();
			Node leftNode = currNode.left;
			Node rightNode = currNode.right;
			if (leftNode != null || rightNode != null) {
				int leftVal = leftNode != null ? leftNode.data : 0;
				int rightVal = rightNode != null ? rightNode.data : 0;
				if (currNode.data == leftVal + rightVal) {
					if (leftNode != null)
						queue.add(leftNode);
					if (rightNode != null)
						queue.add(rightNode);
				} else {
					checkSumHolds = false;
					break;
				}
			}
		}
		return checkSumHolds;
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
