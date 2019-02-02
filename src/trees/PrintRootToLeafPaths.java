package trees;

/**
 * https://www.geeksforgeeks.org/given-a-binary-tree-print-all-root-to-leaf-paths/
 * 
 * @author polymath
 *
 */
public class PrintRootToLeafPaths {

	public static void printRootToLeafPaths(Node root, StringBuilder sb) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			System.out.println(sb.toString());
			return;
		}
		if (root.left != null) {
			printRootToLeafPaths(root.left, sb.append(root.left.data));
			sb.deleteCharAt(sb.length() - 1);
		}
		if (root.right != null) {
			printRootToLeafPaths(root.right, sb.append(root.right.data));
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		//Node left = new Node(8);
		//Node right = new Node(2);
		//root.left = left; root.right = right;
		//left.left = new Node(3); left.right = new Node(5);
		//right.left = new Node(2);
		printRootToLeafPaths(root, new StringBuilder().append(root.data));
	}

	static class Node {
		Node left, right;
		int data;

		Node(int data) {
			this.data = data;
		}
	}
}
