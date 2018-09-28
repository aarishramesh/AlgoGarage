package trees;

public class BinaryTreeToCllUsingInorder {

	static Node prev;
	static Node head;

	static boolean headFound;

	static void binaryTreeToCll(Node root) {
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
		Node root = new Node(4);
		Node left = new Node(2);
		Node right = new Node(5);
		root.left = left;
		root.right = right;
		left.left = new Node(1);
		left.right = new Node(3);

		binaryTreeToCll(root);

		head.left = prev;
		prev.right = head;

		printTreeAsDll();
	}

	private static void printTreeAsDll() {
		Node node = head;
		if (node != null) {
			do {
				System.out.println(node.left.data + " " + node.data + " " + node.right.data);
				node = node.right;
			} while (!node.equals(head));
		}
	}

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
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
			Node other = (Node) obj;
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
}
