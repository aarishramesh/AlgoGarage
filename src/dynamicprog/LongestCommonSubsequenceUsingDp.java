package dynamicprog;

import java.util.Scanner;

/**
 * Impl using DP bottam up approach using iteration
 * 
 * Runtime complexity - O(M * N) 
 * 
 * Space time complexity - O(M * N)
 * 
 * @author aarishramesh
 *
 */
public class LongestCommonSubsequenceUsingDp {
	private static String A, B;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextLine();
		B = sc.nextLine();
		long startTime = System.currentTimeMillis();
		System.out.println(lcs(A.toCharArray(), B.toCharArray(), A.length()
				, B.length()));
		System.out.println("Time taken - " + (System.currentTimeMillis() - startTime));
		sc.close();
	}

	static int lcs( char[] X, char[] Y, int m, int n )
	{
		int L[][] = new int[m+1][n+1];

		/* Following steps build L[m+1][n+1] in bottom up fashion. Note
	         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
		for (int i=0; i<=m; i++)
		{
			for (int j=0; j<=n; j++)
			{
				if (i == 0 || j == 0)
					L[i][j] = 0;
				else if (X[i-1] == Y[j-1])
					L[i][j] = L[i-1][j-1] + 1;
				else
					L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
			}
		}
		return L[m][n];
	}

}
