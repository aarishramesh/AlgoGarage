package general;

/**
 * Kadane's Algorithm
 * 
 * https://en.wikipedia.org/wiki/Maximum_subarray_problem
 * 
 * Run time complexity - O(N)
 * Space time complexity - O(1)
 * 
 * @author aarishramesh
 *
 */
public class MaxContigousSubArraySum {
	public static void main(String[] args) {
		int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
		int max_so_far = 0, max_ending_here = 0;
		for (int i = 0; i < arr.length; i++) {
			max_ending_here = Math.max(max_ending_here + arr[i], arr[i]);
			max_so_far = Math.max(max_ending_here, max_so_far);
		}
		System.out.println(max_so_far);
	}
}
