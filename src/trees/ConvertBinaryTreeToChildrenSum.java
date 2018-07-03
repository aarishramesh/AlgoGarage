package trees;

public class ConvertBinaryTreeToChildrenSum {
	public static void main(String[] args) {
		Node5 node = new Node5(28);
		Node5 node1 = new Node5(13);
		Node5 node2 = new Node5(15);
		node.left = node1; node.right = node2;
		Node5 node3 = new Node5(4);
		Node5 node4 = new Node5(9);
		node1.left = node3;
		node1.right = node4;
	}
	
	private static void convertBTToChildrenSum(Node6 node) {
		if (node  == null)
			return;
		convertBTToChildrenSum(node.left);
		convertBTToChildrenSum(node.right);
		int leftVal = node.left == null ? 0 : node.left.data;
		int rightVal = node.right == null ? 0 : node.right.data;
		node.data = leftVal + rightVal;
	}
}

class Node6 {
	int data;
	Node6 left;
	Node6 right;
}