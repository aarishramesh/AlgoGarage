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
		Node18 root = new Node18(4);
		Node18 left = new Node18(2);
		Node18 right = new Node18(5);
		root.left = left;
		root.right = right;
		left.left = new Node18(1);
		left.right = new Node18(3);
		
		Node18 head = binaryTreeToCll(root);
		
		display(head);
	}
	
	static Node18 binaryTreeToCll(Node18 root) {
		if (root == null)
			return null;
		Node18 leftList = binaryTreeToCll(root.left);
		Node18 rightList = binaryTreeToCll(root.right);
		
		root.left = root.right = root;
		
		// concatenation
		return concatenate(concatenate(leftList, root), rightList);
	}
	
	static Node18 concatenate(Node18 leftList, Node18 rightList) {
		if (leftList == null)
			return rightList;
		if (rightList == null)
			return leftList;
		Node18 leftLast = leftList.left;
		Node18 rightLast = rightList.left;
		
		leftLast.right = rightList;
		rightList.left = leftLast;
		
		leftList.left = rightLast;
		rightLast.right = leftList;
		
		return leftList;
	}
	
	// Display Circular Link List
    static void display(Node18 head) {
        System.out.println("Circular Linked List is :");
        Node18 itr = head;
        do
        {
            System.out.print(itr.data+ " " );
            itr = itr.right;
        }
        while (!itr.equals(head));
        System.out.println();
    }
}


class Node18 {
	int data;
	Node18 left;
	Node18 right;

	Node18(int data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node18 other = (Node18) obj;
		if (data != other.data)
			return false;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		return true;
	}
}

