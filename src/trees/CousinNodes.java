package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * http://www.geeksforgeeks.org/check-two-nodes-cousins-binary-tree/ Assumption
 * that both a and b are unique in tree. Test cases: Empty tree Tree with only
 * root Tree and input with a and b as cousin node Tree and input with a and b
 * not cousin node Tree with input a and b being siblings(not cousin)
 */
public class CousinNodes {
	
	static int cousinLevel = -1;
	static Node cousinParent;
	static boolean areCousins;
	
	public static void main(String[] args) {
		Node root = new Node(6);
		Node left = new Node(3);
		Node right = new Node(5);
		root.left = left;
		root.right = right;
		left.left = new Node(7);
		left.right = new Node(8);
		right.left = new Node(1);
		right.right = new Node(3);
		
		cousinNodes(root, null, 0, 7, 5);
		System.out.println(areCousins);
	}
	
	/**
     * Efficient solution using level order traversal
     * 
     */
    public boolean areCousins(Node root, int data1, int data2) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int tempLevel = 1;
        int level = 0;
        boolean found1 = false;
        boolean found2 = false;
        Node parent1 = null;
        Node parent2 = null;
        while (!queue.isEmpty()) {
            while (tempLevel > 0) {
                root = queue.poll();
                if (root.left != null) {
                    if (root.left.data == data1) {
                        found1 = true;
                        parent1 = root;
                    } else if (root.left.data == data2) {
                        found2 = true;
                        parent2 = root;
                    } else {
                        queue.add(root.left);
                        level++;
                    }
                }
                if (root.right != null) {
                    if (root.right.data == data1) {
                        found1 = true;
                        parent1 = root;
                    } else if (root.right.data == data2) {
                        found2 = true;
                        parent2 = root;
                    } else {
                        queue.add(root.right);
                        level++;
                    }
                }
                tempLevel--;
            }
            if (found1 && found2 && parent1 != parent2) {
                return true;
            } else if (found1 || found2) {
                return false;
            }
            tempLevel = level;
            level = 0;
        }
        return false;
    }
    
    /**
     * Inefficient as it uses DFS
     * 
     * @param root
     * @param parent
     * @param level
     * @param a
     * @param b
     */
	public static void cousinNodes(Node root, Node parent, int level, int a, int b) {
		if (root == null)
			return;
		cousinNodes(root.left, root, level + 1, a, b);
		cousinNodes(root.right, root, level + 1, a, b);
		if (root.data == a || root.data == b) {
			if (cousinParent == null) {
				cousinParent = parent;
				cousinLevel = level;
			} else {
				if (!cousinParent.equals(parent) && cousinLevel == level) {
					areCousins = true;	
					return;
				}	
			}
		}
	}
	
	static class Node {
		int data;
		Node left;
		Node right;
		
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

		Node (int data) {
			this.data = data;
		}
	}
}
