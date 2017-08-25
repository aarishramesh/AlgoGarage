package arraysstrings;

import java.util.Scanner;

/**
 * Find the non-representable minimum integer value from the sub-set of sorted array
 * 
 * @author aarishramesh
 *
 */
public class NonRepresentableMinNumber {
	
	
	private static int findSmallestNonRepresentableNum(int arr[], int n) {
		int res = 1; // Initialize result

		// Traverse the array and increment 'res' if arr[i] is
		// smaller than or equal to 'res'.
		for (int i = 0; i < n && arr[i] <= res; i++)
			res = res + arr[i];

		return res;
	}

	public static void main(String[] args) 
	{
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(findSmallestNonRepresentableNum(arr, n));
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
}

	