package trees;

/**
 * http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 * 
 * @author polymath
 *
 */
public class DiameterOfBinaryTree {
	
	public static int diameter(Node root, Height h) {
		if (root == null)
			return 0;
		Height leftHeight = new Height();
		Height rightHeight = new Height();
		int leftDiameter = diameter(root.left, leftHeight);
		int rightDiameter = diameter(root.right, rightHeight);
		
		h.height = 1 + Math.max(leftHeight.height, rightHeight.height);
		return Math.max(leftHeight.height + rightHeight.height + 1, Math.max(leftDiameter, rightDiameter));
	}
	
	public static void main(String[] args) {
		Node node = new Node(15);
		Node node1 = new Node(13);
		Node node2 = new Node(20);
		node.left = node1; node.right = node2;
		Node node3 = new Node(4);
		Node node4 = new Node(14);
		node1.left = node3;
		node1.right = node4;
		node1.left.right = new Node(25);
		node1.left.right.left = new Node(45);
		
		System.out.println(diameter(node, new Height()));
	}
	
	static class Height { 
	    int height; 
	    
	    Height() {
	    	
	    }
	    
	    Height(int h) {
	    		this.height = h;
	    }
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
