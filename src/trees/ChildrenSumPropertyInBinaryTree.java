package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Check if children property holds i.e Root element is the sum of the left and right sum values
 * 
 * @author polymath
 *
 */
public class ChildrenSumPropertyInBinaryTree {

	public static void main(String[] args) {
		Node5 node = new Node5(28);
		Node5 node1 = new Node5(13);
		Node5 node2 = new Node5(15);
		node.left = node1; node.right = node2;
		Node5 node3 = new Node5(4);
		Node5 node4 = new Node5(9);
		node1.left = node3;
		node1.right = node4;
		
		System.out.println(IsCheckSumPropertyHolds(node));
	}

	private static boolean IsCheckSumPropertyHolds(Node5 node) {
		Queue<Node5> queue = new LinkedList<Node5>();
		queue.add(node);
		boolean checkSumHolds = true;
		while (!queue.isEmpty()) {
			Node5 currNode = queue.remove();
			Node5 leftNode = currNode.left;
			Node5 rightNode = currNode.right;
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
}

class Node5 {
	int data;
	Node5 left;
	Node5 right;
	
	Node5(int data) {
		this.data = data;
	}
}