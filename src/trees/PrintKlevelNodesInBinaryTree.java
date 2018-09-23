package trees;

/**
 * https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
 * 
 * @author polymath
 *
 */
public class PrintKlevelNodesInBinaryTree {

	static void printKlevelNodesDown(Node root, int level) {
		if (root == null || level < 0)
			return;
		if (level == 0) {
			System.out.print(root.data + " ");
			return;
		}
		printKlevelNodesDown(root.left, level - 1);
		printKlevelNodesDown(root.right, level - 1); 
	}
	
	static int printKlevelNode(Node root, Node target, int level) {
		if (root == null)
			return -1;
		if (root.equals(target)) {
			printKlevelNodesDown(root, level);
			return 0;
		}
		// calculating distance left
		int dl = printKlevelNode(root.left, target, level);
		if (dl != -1) {			
			if (dl + 1 == level) {
				System.out.print(root.data + " ");
			} else {
				// printing nodes on right sub tree at level -> level - ( distanceleft + 2) 
				printKlevelNodesDown(root.right, level - dl - 2);
			}
			return dl + 1;
		}
		
		// calculating distance right
		int dr = printKlevelNode(root.right, target, level);
		if (dr != -1) {			
			if (dl + 1 == level) 
				System.out.print(root.data + " ");
			else
				// printing nodes on left sub tree level -> level - ( distanceright+ 2) 
				printKlevelNodesDown(root.left, level - dl - 2);
			return dr + 1;
		}
		return -1;
	}
	
	// Driver program to test the above functions 
		public static void main(String args[]) { 

			/* Let us construct the tree shown in above diagram */
			Node root = new Node(20); 
			root.left = new Node(8); 
			root.right = new Node(22); 
			root.left.left = new Node(4); 
			root.left.right = new Node(12); 
			root.left.right.left = new Node(10); 
			root.left.right.right = new Node(14); 
			Node target = root.left.left; 
			printKlevelNode(root, target, 2);
		} 
		
	static class Node {
		int data;
		Node left, right;
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + data;
			result = prime * result + ((left == null) ? 0 : left.hashCode());
			result = prime * result + ((right == null) ? 0 : right.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (data != other.data)
				return false;
			if (left == null) {
				if (other.left != null)
					return false;
			} else if (!left.equals(other.left))
				return false;
			if (right == null) {
				if (other.right != null)
					return false;
			} else if (!right.equals(other.right))
				return false;
			return true;
		}

		Node(int data) {
			this.data = data;
		}
	}
}
