package dynamicprog;

/**
 * https://www.geeksforgeeks.org/printing-brackets-matrix-chain-multiplication-problem/
 * 
 * Time complexity - O(N^3)
 * 
 * Space complexity - O(N^2)
 * 
 * @author polymath
 *
 */
public class MatrixChainMultiplication {
	
	public static void main(String[] args) {
		int[] dmns = {2, 3, 6, 4, 5};
		System.out.println(optimalMatrixChainMultiply(dmns));
	}
	
	public static int optimalMatrixChainMultiply(int[] dmns) {
		if (dmns == null || dmns.length == 1)
			return 0;
		if (dmns.length == 2)
			return dmns[0] * dmns[1];
		int[][] result = new int[dmns.length - 1][dmns.length - 1];
		for (int j = 0; j < dmns.length - 1; j++) {
			int i = 0, dup = j;
			while (i < dmns.length - 1 && j < dmns.length - 1) {
				if (i == j)
					result[i][j] = 0;
				else {
					int min = Integer.MAX_VALUE;
					for (int k = i; k < j; k++) {
						int val = result[i][k] + result[k + 1][j]
								+ (dmns[i] * dmns[k + 1] * dmns[j + 1]);
						min = Math.min(val, min);
					}
					result[i][j] = min;
				}
				i++; j++;
			}
			j = dup;
		}
		return result[0][dmns.length - 2];
	}
}
