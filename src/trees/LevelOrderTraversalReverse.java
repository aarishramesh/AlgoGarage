package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Video link - https://youtu.be/D2bIbWGgvzI
 *
 * Given a binary tree print its level order traversal in reverse
 * e.g           1
 *          2         3
 *        4    5    6   7
 * 
 * Output should be 4 5 6 7 2 3 1
 * 
 * Solution
 * Maintain a stack and queue. Do regular level order traversal but
 * put right first in the queue. Instead of printing put the result
 * in stack. Finally print contents of the stack.
 * 
 * Time and space complexity is O(n)
 * 
 * References : http://www.geeksforgeeks.org/reverse-level-order-traversal/
 */
public class LevelOrderTraversalReverse {
	
	public static void levelOrderTraversalReverse(Node root) {
		Queue<Node> nodesQueue = new LinkedList<Node>();
		nodesQueue.add(root);
		Stack<Integer> nodesStack = new Stack<Integer>();
		while (!nodesQueue.isEmpty()) {
			Node currnode = nodesQueue.poll();
			if (currnode.left != null)
				nodesQueue.add(currnode.left);
			if (currnode.right != null)
				nodesQueue.add(currnode.right);
			nodesStack.add(currnode.data);
		}
		
		while (!nodesStack.isEmpty()) {
			System.out.print(nodesStack.pop() + " ");
		}
	}
	
	static class Node {
		int data;
		Node left;
		Node right;
	}
}
