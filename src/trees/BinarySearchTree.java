package trees;

public class BinarySearchTree {
	private BinaryTreeNode root;

	public BinaryTreeNode insert(BinaryTreeNode n, int element) {
		if(n == null) {
			return new BinaryTreeNode(element);
		} else if(element <= n.element){
			n.left = insert(n.left, element);
		} else if(element > n.element) {
			n.right = insert(n.right, element);
		}
		return n;
	}

	public boolean search(BinaryTreeNode n, int num) {
		if(n!= null) {
			if (n.element == num) {
				return true;
			} else if (num < n.element) {
				return search(n.left, num);
			} else {
				return search(n.right, num);
			}
		}
		return false;
	}

	public void print(BinaryTreeNode n) {
		if(n != null) {
			System.out.println(n.element);
			print(n.left);
			print(n.right);
		}
	}

	public BinaryTreeNode getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.setRoot(tree.insert(null, 10));
		tree.insert(tree.getRoot(), 6);
		tree.insert(tree.getRoot(), 11);
		tree.print(tree.getRoot());
		System.out.println(tree.search(tree.getRoot(), 7));
	}
}

class BinaryTreeNode {
	int element;
	BinaryTreeNode left;
	BinaryTreeNode right;

	BinaryTreeNode(int element) {
		this.element = element;
	}
}
