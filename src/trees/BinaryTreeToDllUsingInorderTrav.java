package trees;

public class BinaryTreeToDllUsingInorderTrav {

	static Node2 prev;
	static Node2 head;

	public static void main(String[] args) {
		Node2 node = new Node2(10);
		Node2 node1 = new Node2(12);
		Node2 node2 = new Node2(15);
		node.left = node1; node.right = node2;
		Node2 node3 = new Node2(25);
		Node2 node4 = new Node2(30);
		node1.left = node3;
		node1.right = node4;
		
		inorderTrav(node);
		printBtreeToDll(head);
	}
	
	static void inorderTrav(Node2 root) {
		if (root == null)
			return;
		inorderTrav(root.left);
		if (prev == null) {
			head = root;
		} else {
			prev.right = root;
			root.left = prev;
		}
		prev = root; 
		inorderTrav(root.right);
	}
	
	private static void printBtreeToDll(Node2 node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.right;
		}
	}
}