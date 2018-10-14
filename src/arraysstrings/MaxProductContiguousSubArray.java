package arraysstrings;

/**
 * https://www.geeksforgeeks.org/maximum-product-subarray/
 * 
 * Basic assumption is that max product is atleast 1 if no such product greater than 1 exists
 * 
 * test cases - all zero array, one non-zero element array, 
 * 
 * @author polymath
 *
 */
public class MaxProductContiguousSubArray {
	
	public static void main(String[] args) {
		//int[] arr = {6, -3, -10, 0, 2};
		//int[] arr = {-1, -3, -10, 0, 60};
		//int[] arr = {0, 0, 0, 0, 3};
		int[] arr = {0, 0, 0, 0, -120, -20};
		System.out.println(maxProduct(arr));
	}
	
	public static int maxProduct(int[] arr) {
		int minEndingHere = 1, maxEndingHere = 1, maxSoFar = 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				maxEndingHere = arr[i] * maxEndingHere;
				minEndingHere = Math.min(arr[i] * minEndingHere, 1);
			} else if (arr[i] == 0) {
				maxEndingHere = 1; minEndingHere = 1;
			} else {
				int temp = maxEndingHere;
				maxEndingHere = Math.max(minEndingHere * arr[i], 1);
				minEndingHere = temp * arr[i];
			}
			if (maxEndingHere > maxSoFar)
				maxSoFar = maxEndingHere;
		}
		return maxSoFar;
	}
}
