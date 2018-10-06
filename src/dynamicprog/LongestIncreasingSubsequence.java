package dynamicprog;

/**
 * 
 * Find a subsequence in given array in which the subsequence's elements are 
 * in sorted order, lowest to highest, and in which the subsequence is as long as possible
 * 
 * Solution : 
 * Dynamic Programming is used to solve this question. DP equation is 
 * if(arr[i] > arr[j]) { T[i] = max(T[i], T[j] + 1 }
 * 
 * Time complexity is O(n^2).
 * Space complexity is O(n)
 * 
 * Reference 
 * http://en.wikipedia.org/wiki/Longest_increasing_subsequence
 * http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {
	
	public static void main(String[] args) {
        int arr[] = {23,10,22,5,33,8,9,21,50,41,60,80,99, 22,23,24,25,26,27};

		//int[] arr = {3, 4, -1, 0, 6, 2, 3};
		System.out.println(longestIncreasingSubSeq(arr));
	}
	
	public static int longestIncreasingSubSeq(int[] arr) {
		int[] T = new int[arr.length];
		int[] actualSoln = new int[arr.length];
		for (int i = 0; i < T.length; i++) {
			T[i] = 1;
			actualSoln[i] = i;
		}
		int max = 1, maxIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					if (T[j] + 1 > T[i]) {
						T[i] = T[j] + 1;
						actualSoln[i] = j;
						if (T[i] > max) {
							max = T[i];
							maxIndex = i;
						}
					}
				}
			}
		}
		
		// Printing the actual soln
		int t = maxIndex;
		do {
			System.out.print(arr[t] + " ");
			t = actualSoln[t];
		} while (t != actualSoln[t]);
		System.out.print(arr[t] + "\n");
		return max;
	}
}
