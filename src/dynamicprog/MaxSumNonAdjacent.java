package dynamicprog;

/**
 * Find maximum sum for non adjacent elements.
 * Variation is finding maximum sum non adjacent elements assuming its a circular array.
 * So first element cannot be with last element.
 *
 * Time complexity O(n)
 * Space complexity O(1)
 *
 * https://leetcode.com/problems/house-robber/
 * https://leetcode.com/problems/house-robber-ii/
 */
public class MaxSumNonAdjacent {
	public static void main(String[] args) {
		int[] arr = {4, 1, 1, 4, 2, 1};
		int inc = 4, exc = 0;
		for (int i = 1; i < arr.length; i++) {
			int newInc = Math.max(arr[i] + exc, inc);
			exc = inc;
			inc = newInc;
		}
		System.out.println(Math.max(inc, exc));
	}
	
	  /**
     * Recursive slow solution.
     */
    public static int maxSum(int arr[], int index) {
        if (index == 0) {
            return arr[0];
        } else if (index == 1) {
            return Math.max(arr[0], arr[1]);
        }
        return Math.max(maxSum(arr, index - 2) + arr[index], maxSum(arr, index - 1));
    }
}
