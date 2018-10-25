package trees;

/**
 * 
 * FYI Remember the catches
 * 
 *  - In Preorder the sequence is like => root -> left sub tree i.e print all elements on left sub tree -> right sub tree i.e elements greater than root
 *  
 *  - Inorder is a sorted array => print all elements on left sub tree -> root -> print all elements on right sub tree
 * 
 * - In Postrorder the sequence is like => print all elements on left sub tree -> print all elements on right sub tree -> root 
 * 
 * @author polymath
 *
 */
public class ConstructBSTFromPreOrderAray {

	public static void main(String[] args) {
		int[] preOrderArr = {10, 5, 1, 7, 40, 50};
		Node root = constructTree(preOrderArr, new Index(0), Integer.MIN_VALUE, Integer.MAX_VALUE);
		inOrderTrav(root);
	}

	public static Node constructTree(int[] preOrderArr, Index preIndex, int min, int max) {
		// Base case
		if (preIndex.index >= preOrderArr.length)
			return null;
		Node root = null;
		int key = preOrderArr[preIndex.index];
		// If current element of preOrderArr[] is in range, then
	    // only it is part of current subtree
		if (key > min && key < max) {
			root = new Node(key);
			preIndex.index++;
			if (preIndex.index < preOrderArr.length) {
				// Contruct the subtree under root
				
	            // All nodes which are in range {min .. key} will go in left
	            // subtree, and first such node will be root of left subtree.
				root.left = constructTree(preOrderArr, preIndex, min, key);
				
				// All nodes which are in range {key..max} will go in right
	            // subtree, and first such node will be root of right subtree.
				root.right = constructTree(preOrderArr, preIndex, key, max);
			}
		}
		return root;
	}

	static void inOrderTrav(Node root) {
		if (root == null)
			return;
		inOrderTrav(root.left);
		System.out.println(root.data);
		inOrderTrav(root.right);
	}

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}
	
	static class Index {
		int index;
		
		Index(int index) {
			this.index = index;
		}
	}
}
