package trees;

import java.util.ArrayList;
import java.util.List;

/**

 * Given an array representation of binary tree where index is data while value at index is
 * parent create the binary tree. Value of -1 indicates root Node.
 * 
 * References:
 * http://www.geeksforgeeks.org/construct-a-binary-tree-from-parent-array-representation/
 */
public class BinaryTreeFromParentRep {

	public Node create(int input[]) {
		Node t[] = new Node[input.length];

		for(int i = 0; i < input.length; i++) {
			t[i] = new Node();
			t[i].data = i;
		}

		Node root = null;
		for(int i = 0; i < input.length; i++) {
			int parentIndex = input[i];
			if(parentIndex == -1) {
				root = t[i];
				continue;
			}
			Node parent = t[parentIndex];
			if(parent.left == null) {
				parent.left = t[i];
			} else {
				parent.right = t[i];
			}
		}
		return root;
	}

	public static void main(String args[]) {
		BinaryTreeFromParentRep btpp = new BinaryTreeFromParentRep();
		int input[] =  {1, 5, 5, 2, 2, -1, 3};
		Node root = btpp.create(input);
		printLevelOrder(root);
	}

	private static void printLevelOrder(Node head) {
		if (head == null)
			return;
		List<Node> nodes = new ArrayList<Node>();
		nodes.add(head);
		while (!nodes.isEmpty()) {
			System.out.print(nodes.get(0).data + " ");
			if (nodes.get(0).left != null)
				nodes.add(nodes.get(0).left);
			if (nodes.get(0).right != null)
				nodes.add(nodes.get(0).right);
			nodes.remove(0);
		}
	}


	static class Node {
		int data;
		Node left;
		Node right;
	}
}
