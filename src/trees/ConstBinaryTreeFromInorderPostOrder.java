package trees;

public class ConstBinaryTreeFromInorderPostOrder {
	
	static int postIndex;
	
	public static void main(String[] args) {
		int[] inOrderArr = {4, 8, 2, 5, 1, 6, 3, 7};
		int[] postOrderArr = {8, 4, 5, 2, 6, 7, 3, 1};
		postIndex = postOrderArr.length - 1;
		
		Node root = constBinaryTree(inOrderArr, postOrderArr, 0, inOrderArr.length - 1);
		
		printInorderTravBT(root);
	}
	
	public static Node constBinaryTree(int[] inOrder, int[] postOrder, int left, int right) {
		if (left > right) {
			return null;
		}
		
		Node newNode = new Node(inOrder[postIndex]);
		postIndex--;
		
		if (left == right) {
			return newNode;
		}
		int inOrderIndex = findIndexInInOrder(postOrder[postIndex], inOrder);

		newNode.right = constBinaryTree(inOrder, postOrder, inOrderIndex + 1, right);
		newNode.left = constBinaryTree(inOrder, postOrder, left, inOrderIndex - 1);
		return newNode;
	}
	
	private static int findIndexInInOrder(int num, int[] inOrder) {
		for(int i = 0; i < inOrder.length; i++) {
			if (inOrder[i] == num) {
				return i;
			}
		}
		return -1;
	}
	
	static class Node {
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data  = data;
		}
	}
	
	private static void printInorderTravBT(Node root) {
		if (root == null)
			return;
		printInorderTravBT(root.left);
		System.out.print(root.data + " ");
		printInorderTravBT(root.right);
	}
}
