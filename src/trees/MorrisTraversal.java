package trees;

/**
 * https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
 * https://en.wikipedia.org/wiki/Threaded_binary_tree
 * 
 * @author polymath
 *
 */
public class MorrisTraversal {
	
	public static void inOrderTraversal(Node root) {
		while (root != null) {
			if (root.left == null) {
				System.out.print(root.data + " ");
				root = root.right;
			} else {
				Node predecessor = root.left;
				while (predecessor.right != null && !predecessor.right.equals(root))
					predecessor = predecessor.right;
				if (predecessor.right == null) {
					predecessor.right = root;
					root = root.left;
				} else {
					predecessor.right = null;
					System.out.print(root.data + " ");
					root = root.right;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		Node left = new Node(2);
		Node right = new Node(3);
		root.left = left;
		root.right = right;
		left.left = new Node(7);
		left.right = new Node(6);
		right.left = new Node(5);
		right.right = new Node(4);
		
		inOrderTraversal(root);
	}
	
	static class Node {
		int data;
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
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
		}
	}
}
