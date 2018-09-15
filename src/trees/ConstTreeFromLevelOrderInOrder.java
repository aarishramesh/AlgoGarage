package trees;

/**
 * https://www.geeksforgeeks.org/construct-tree-inorder-level-order-traversals/
 * 
 * @author polymath
 *
 */
public class ConstTreeFromLevelOrderInOrder {

	static Node constTreeLevelOrderInOrder(Node startNode, int[] inorder, int[] levelorder, int inStart, int inEnd) {
		if (inStart > inEnd)
			return null;
		if (inStart == inEnd)
			return new Node(inorder[inStart]);
		
		// Find the first index of level order in inorder from start to end
		int index = 0;
		boolean  elementFound = false;
		Node newNode = null;
		for (int i = 0; i < levelorder.length; i++) {
			int levelElement = levelorder[i];
			for (int j = inStart; j < inEnd; j++) {
				if (levelElement == inorder[j]) {
					startNode = new Node(inorder[j]);
					index = j;
					elementFound = true;
					break;
				}
			}
			if (elementFound)
				break;
 		}
		
		startNode.left = constTreeLevelOrderInOrder(newNode, inorder, levelorder, inStart, index - 1);
		startNode.right = constTreeLevelOrderInOrder(newNode, inorder, levelorder, index + 1, inEnd);
		
		return startNode;
	}
	
	public static void main(String[] args) {
		int in[] = new int[]{4, 8, 10, 12, 14, 20, 22}; 
        int level[] = new int[]{20, 8, 22, 4, 12, 10, 14}; 
        Node root = constTreeLevelOrderInOrder(null, in, level, 0, in.length - 1);
        printInorder(root);
	}
	static void printInorder(Node node) { 
        if (node == null) 
            return; 
        printInorder(node.left); 
        System.out.print(node.data + " "); 
        printInorder(node.right); 
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