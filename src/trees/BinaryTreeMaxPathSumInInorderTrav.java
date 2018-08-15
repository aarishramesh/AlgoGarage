package trees;

public class BinaryTreeMaxPathSumInInorderTrav {
	static Node16 prev;
	static boolean leftMostSet;
	static Node16 leftMost;
	
	public static void main(String[] args) {
		Node16 one = new Node16(-10);
		Node16 two = new Node16(9);
		Node16 three = new Node16(20);
		one.left = two;
		one.right = three;
		Node16 four = new Node16(15);
		Node16 five = new Node16(7);
		three.left = four;
		three.right = five;
		
		inorderSucc(one);
		System.out.println(maxPathSum(leftMost));
	}
	
	static void inorderSucc(Node16 root) {
		if (root == null) {
			return ;
		}
		inorderSucc(root.left);
		if(!leftMostSet) {
			leftMostSet = true;
			leftMost = root;
		}
		if (prev != null) {
			prev.right = root;
		}
		prev = root;
		inorderSucc(root.right);
	}
	
	static int maxPathSum(Node16 node) {
		int max_so_far = 0, max_ending_here = 0;
		while (node != null) {
			max_ending_here = Math.max(max_ending_here + node.data, node.data);
			max_so_far = Math.max(max_ending_here, max_so_far);
			node = node.right;
		}
		return max_so_far;
	}
}

class Node16 {
	
	Node16(int data) {
		this.data = data;
	}
	
	int data;
	Node16 left;
	Node16 right;
}