package trees;

/**
 * http://www.geeksforgeeks.org/check-if-each-internal-node-of-a-bst-has-exactly-one-child/
 * 
 * Run time - O(N)
 * 
 * Important condition to note is in pre-order traversal children nodes come after the parent
 * Solution same as that of checking BST
 * 
 */
public class CheckBSTGivenPreOrderTrav {
	
	public static void main(String[] args) {
		int[] preOrderArr = {20, 10, 7, 13, 22};
		System.out.println(checkBst(preOrderArr));
	}
	
	static boolean checkBst(int[] preOrderArr) {
		int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE, prev = preOrderArr[0];
		for (int i = 1; i < preOrderArr.length; i++) {
			if (preOrderArr[i] > min && preOrderArr[i] < max) {
				if (preOrderArr[i] < prev) {
					max = prev;
				} else {
					min = prev;
				}
				prev = preOrderArr[i];
			} else {
				return false;
			}
		}
		return true;
	}
}
