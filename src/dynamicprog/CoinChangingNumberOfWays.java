package dynamicprog;

/**
 * 
 * 
 * @author polymath
 *
 */
public class CoinChangingNumberOfWays {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		System.out.println(coinChangingNoOfWays(arr, 0, 6, 6));
		System.out.println(coinChangingDP(arr, 6));
	}

	public static int coinChangingNoOfWays(int[] arr, int start, int total, int reqTotal) {
		if (start == arr.length || total < 0) {
			return 0;
		}
		if (total == 0)
			return 1;
		return coinChangingNoOfWays(arr, start, total - arr[start], reqTotal)
				+ coinChangingNoOfWays(arr, start + 1, total, reqTotal);
	}

	public static int coinChangingDP(int[] coins, int total) {
		int[][] result = new int[coins.length][total + 1];
		for (int i = 0; i < coins.length; i++) {
			for (int j = 0; j < total + 1; j++) {
				if (j == 0)
					result[i][j] = 1;
				else if (j >= coins[i]) {
					int resultVal = result[i][j - coins[i]];
					if (i - 1 >= 0)
						resultVal += result[i - 1][j];
					result[i][j] = resultVal;
				} else {
					result[i][j] = result[i - 1][j];
				}
			}
		}
		return result[coins.length - 1][total];
	}
}
