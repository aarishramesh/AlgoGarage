package trees;

public class ConvertBSTToGivenRange {
	
	public static void main(String[] args) {
		Node node = new Node(5);
		Node leftChild = new Node(2); Node rightChild = new Node(7);
		node.left = leftChild; node.right = rightChild;
		leftChild.left = new Node(1);
		leftChild.right = new Node(3);
		rightChild.left = new Node(6);
		rightChild.right = new Node(8);
		
		Node root = removeValuesOutsideRange(node, 1, 5);
		
		printInorderTrav(root);
	}
	
	public static Node removeValuesOutsideRange(Node node, int minRangeValue, int maxRangeValue) {
		if (node == null) {
			return null;
		}
		node.left = removeValuesOutsideRange(node.left, minRangeValue, maxRangeValue);
		node.right = removeValuesOutsideRange(node.right, minRangeValue, maxRangeValue);
		if (node.data < minRangeValue) {
			return node.right;
		} else if (node.data > maxRangeValue) {
			return node.left;
		}
		return node;
	}
	
	private static void printInorderTrav(Node node) {
		if (node == null)
			return ;
		printInorderTrav(node.left);
		System.out.print(node.data + " ");
		printInorderTrav(node.right);
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
