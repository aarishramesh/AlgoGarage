package trees;

public class BTree {
	static int T = 2; // minimum degree of B tree
	
	static class BTreeNode {
		int[] keys = new int[2 * T - 1]; // A B tree can have a maximum of 2T - 1 keys
		BTreeNode[] child = new BTreeNode[2 * T]; // 2T - 1 keys therefore max of 2T children
		int n;
		boolean isLeaf;
		
		public boolean isFull() {
			return 2 * T - 1 == n;
		}
		
		public static BTreeNode newNode(int data) {
			BTreeNode newNode = new BTreeNode();
			newNode.keys[0] = data;
			newNode.n = 1;
			newNode.isLeaf = true;
			return newNode;
		}
		
		public static BTreeNode newNode() {
			BTreeNode newNode = new BTreeNode();
			newNode.isLeaf = true;
			newNode.n = 0;
			return newNode;
		}
		
		public int[] getKeys() {
			return keys;
		}
		public void setKeys(int[] keys) {
			this.keys = keys;
		}
		public BTreeNode[] getChild() {
			return child;
		}
		public void setChild(BTreeNode[] child) {
			this.child = child;
		}
		public int getN() {
			return n;
		}
		public void setN(int n) {
			this.n = n;
		}
		public boolean isLeaf() {
			return isLeaf;
		}
		public void setLeaf(boolean isLeaf) {
			this.isLeaf = isLeaf;
		}
	}
}
