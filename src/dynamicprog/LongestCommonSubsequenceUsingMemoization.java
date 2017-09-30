package dynamicprog;

import java.util.Scanner;

/**
 * Runtime complexity - O(M * N) in the worst case
 * 
 * Spacetime complexity - O(M * N) - for memoization & maintaining visited 
 * 
 * Memoization is used to save overlapping results
 * 
 * @author aarishramesh
 *
 */
public class LongestCommonSubsequenceUsingMemoization {
	private static String A, B;
	private static int[][] memoizedResults;
	private static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextLine();
		B = sc.nextLine();
		memoizedResults = new int[A.length()][B.length()];
		visited = new boolean[A.length()][B.length()];
		for (int i = 0; i < A.length(); i++) {
			for (int j = 0; j < B.length(); j++) {
				memoizedResults[i][j] = 0;
			}
		}
		long startTime = System.currentTimeMillis();
		System.out.println(longestCommonSubsequence(A.length() - 1, B.length() - 1));
		System.out.println("Time taken - " + (System.currentTimeMillis() - startTime));
		sc.close();
	}

	private static int longestCommonSubsequence(int row, int column) {
		if (visited[row][column] == true) {
			return memoizedResults[row][column];
		} else {
			if (A.charAt(row) == B.charAt(column)) {
				int diagVal = 1;
				if (row - 1 >= 0 && column - 1 >= 0) {
					if (visited[row - 1][column - 1] == false) {
						memoizedResults[row - 1][column - 1] = longestCommonSubsequence(row - 1, column - 1);
						visited[row - 1][column - 1] = true;
					}
					diagVal += memoizedResults[row - 1][column - 1];
				}
				return diagVal;
			}
			int leftVal = 0;
			if (column - 1 >= 0) {
				if (visited[row][column - 1] == false) {
					memoizedResults[row][column - 1] = longestCommonSubsequence(row, column - 1);
					visited[row][column - 1] = true;
				}
				leftVal = memoizedResults[row][column - 1];
			}
			int topVal = 0;
			if (row - 1 >= 0) {
				if (visited[row - 1] [column] == false) {
					memoizedResults[row - 1][column] = longestCommonSubsequence(row - 1, column);
					visited[row - 1][column] = true;
				}
				topVal = memoizedResults[row - 1][column];
			}
			return Math.max(leftVal
					, topVal);
		}
	}
}
