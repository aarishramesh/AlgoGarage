package trees;

/**
 * https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
 * 
 * @author polymath
 *
 */
public class ConstructTreeInOrderPreOrder {
	
	static int preIndex = 0;
	
	static Node constTreeInorderPreorder(int[] inArr, int[] preArr, int left, int right) {
		if (left > right)
			return null;
		Node node = new Node(preArr[preIndex]);
		preIndex++;
		if (left == right)
			return node;
		int idx = findIdxInInOrder(inArr, preArr[preIndex - 1], left, right);
		node.left = constTreeInorderPreorder(inArr, preArr, left, idx - 1);
		node.right = constTreeInorderPreorder(inArr, preArr, idx + 1,	 right);
		return node;
	}
	
	static int findIdxInInOrder(int[] inArr, int key, int left, int right) {
		for (int i = left; i <= right; i++) {
			if (inArr[i] == key)
				return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] inArr = {4, 2, 5, 1, 6, 3};
		int[] preArr = {1, 2, 4, 5, 3, 6};
		
		Node root = constTreeInorderPreorder(inArr, preArr, 0	, inArr.length - 1);
		
		printPostOrder(root);
	}
	
	static void printPostOrder(Node node) {
		if (node == null)
			return;
		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(node.data + " ");
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
