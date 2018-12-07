package trees;

/**
 * https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
 * 
 * Discussion on time complexity 
 * 
 * https://stackoverflow.com/questions/6478063/how-is-the-time-complexity-of-morris-traversal-on
 * 
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
	
	public static void preOrderTraversal(Node root) {
		while (root != null) {
			if (root.left == null) {
				System.out.print(root.data + " ");
				root = root.right;
			} else {
				Node pre = root.left;
				while (pre.right != null && !pre.right.equals(root)) {
					pre = pre.right;
				}
				if (pre.right.equals(root)) {
					pre.right = null;
					root = root.right;
				} else {
					System.out.print(root.data + " ");
					pre.right = root;
					root = root.left;
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
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
		}
	}
}
