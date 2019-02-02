package dynamicprog;

/**
 * https://www.geeksforgeeks.org/dice-throw-dp-30/
 * @author polymath
 *
 */
public class DiceThrowNoOfWaysToGetASum {
	
	public static void main(String[] args) {
		System.out.println(noOfWays(4, 3, 5));
	}
	
	public static int noOfWays(int m, int n, int x) {
		// m - faces of dice, n - no of dices, x - desired sum
		if (n > x)
			return 0;
		int[][] result = new int[n + 1][x + 1];
		for (int j = 1; j <= m; j++) {
			result[1][j] = 1;
		}
		for (int i = 2; i <= n; i++) {
			for (int j = 2; j <= x; j++) {
				if (i > j)
					continue;
				for (int k = 1; k <= m; k++) {
					if (j - k >= i - 1)
						result[i][j] += result[i - 1][j - k];
				}
			}
		}
		return result[n][x];
	}
}
