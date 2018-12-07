package trees;

/**
 * 
 * http://cslibrary.stanford.edu/109/TreeListRecursion.html
 * 
 * O(N)
 * 
 * It essentially has 4 steps
 * 1. make circular list of left sub tree and get the head
 * 2. make circular list of right sub tree and get the head
 * 3. make root's left and right point to root itself
 * 4. Concatenate left and root followed by the right
 * 
 */
public class TreeListRecursionProblem {

	public static void main(String[] args) {
		Node root = new Node(4);
		Node left = new Node(2);
		Node right = new Node(5);
		root.left = left;
		root.right = right;
		left.left = new Node(1);
		left.right = new Node(3);

		Node head = binaryTreeToCll(root);

		display(head);
	}

	static Node binaryTreeToCll(Node root) {
		if (root == null)
			return null;
		Node leftList = binaryTreeToCll(root.left);
		Node rightList = binaryTreeToCll(root.right);

		root.left = root.right = root;

		// concatenation
		return concatenate(concatenate(leftList, root), rightList);
	}

	static Node concatenate(Node leftList, Node rightList) {
		if (leftList == null)
			return rightList;
		if (rightList == null)
			return leftList;
		Node leftLast = leftList.left;
		Node rightLast = rightList.left;

		leftLast.right = rightList;
		rightList.left = leftLast;

		leftList.left = rightLast;
		rightLast.right = leftList;

		return leftList;
	}

	// Display Circular Link List
	static void display(Node head) {
		System.out.println("Circular Linked List is :");
		Node itr = head;
		do
		{
			System.out.print(itr.data+ " " );
			itr = itr.right;
		}
		while (!itr.equals(head));
		System.out.println();
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


