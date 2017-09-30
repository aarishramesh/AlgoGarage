package dynamicprog;

import java.util.Scanner;

/**
 * Runtime complexity - O(2 ^ N)
 * 
 * @author aarishramesh
 *
 */
public class LongestCommonSubsequenceRecursion {
	private static String A, B;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextLine();
		B = sc.nextLine();
		long startTime = System.currentTimeMillis();
		System.out.println(longestCommonSubsequence(A.length() - 1, B.length() - 1));
		System.out.println("Time taken - " + (System.currentTimeMillis() - startTime));
		sc.close();
	}
	
	private static int longestCommonSubsequence(int row, int column) {
		if (column < 0 || row < 0) {
			return 0;
		}
		if (A.charAt(row) == B.charAt(column)) {
			return 1 + longestCommonSubsequence(row - 1, column - 1);
		}
		return Math.max(longestCommonSubsequence(row, column - 1)
				, longestCommonSubsequence(row - 1, column));
	}
}
