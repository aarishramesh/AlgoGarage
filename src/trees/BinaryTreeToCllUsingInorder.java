package trees;

public class BinaryTreeToCllUsingInorder {

	static Node17 prev;
	static Node17 head;

	static boolean headFound;

	static void binaryTreeToCll(Node17 root) {
		if (root == null) {
			return;
		}
		binaryTreeToCll(root.left);
		if (!headFound) {
			head = root;
			headFound = true;
		}
		if (prev != null) {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		binaryTreeToCll(root.right);
	}

	public static void main(String[] args) {
		Node17 root = new Node17(4);
		Node17 left = new Node17(2);
		Node17 right = new Node17(5);
		root.left = left;
		root.right = right;
		left.left = new Node17(1);
		left.right = new Node17(3);

		binaryTreeToCll(root);

		head.left = prev;
		prev.right = head;

		printTreeAsDll();
	}

	private static void printTreeAsDll() {
		Node17 node = head;
		if (node != null) {
			do {
				System.out.println(node.left.data + " " + node.data + " " + node.right.data);
				node = node.right;
			} while (!node.equals(head));
		}
	}
}

class Node17 {
	int data;
	Node17 left;
	Node17 right;

	Node17(int data) {
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
		Node17 other = (Node17) obj;
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