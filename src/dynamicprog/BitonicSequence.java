package dynamicprog;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-15-longest-bitonic-subsequence/
 */
public class BitonicSequence {
	public static void main(String[] args) {
		int[] arr = {2, -1, 4, 3, 5, -1, 3, 2};
		System.out.println(longestBitonicSubsequence(arr));
	}
	
	public static int longestBitonicSubsequence(int[] arr) {
		int[] lisLeft = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
			lisLeft[i] = 1;
		
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					if (lisLeft[j] + 1 > lisLeft[i]) {
						lisLeft[i] = lisLeft[j] + 1;
					}
				}
			}
		}
		
		int[] lisRight = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
			lisRight[i] = 1;
		
		for (int i = arr.length - 2; i > 0; i--) {
			for (int j = arr.length - 1; j > i; j--) {
				if (arr[j] < arr[i]) {
					if (lisRight[j] + 1 > lisRight[i]) {
						lisRight[i] = lisRight[j] + 1;
					}
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < lisRight.length; i++) {
			max = Math.max(max,  lisLeft[i] + lisRight[i] - 1);
		}
		return max;
	}
}
