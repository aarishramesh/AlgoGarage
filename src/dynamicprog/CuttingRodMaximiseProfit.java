package dynamicprog;

public class CuttingRodMaximiseProfit {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};
		int[] val = {2, 5, 7, 8};
		int len = 5;
		System.out.println(cuttingRodToMaxProfit(arr, val, 0, len, 0));
		System.out.println(cuttingRodDp(arr, val, 5));
	}
	
	/**
	 * Recursive naive approach with exponenial run time complexity 
	 * 
	 * @param arr
	 * @param vals
	 * @param start
	 * @param total
	 * @param profit
	 * @return
	 */
	public static int cuttingRodToMaxProfit(int[] arr, int[] val, int start, int total, int profit) {
		if (start == arr.length - 1 || total == 0)
			return profit;
		if (total < 0)
			return 0;
		return Math.max(cuttingRodToMaxProfit(arr, val, start, total - arr[start], profit + val[start])
				, cuttingRodToMaxProfit(arr, val, start + 1, total, profit));
	}
	
	public static int cuttingRodDp(int[] arr, int[] val, int length) {
		int[][] result = new int[arr.length][length + 1];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < length + 1; j++) {
				if (j == 0)
					result[i][j] = 0;
				else {
					if (j >= arr[i]) {
						result[i][j] = Math.max(i - 1 >= 0 ? result[i - 1][j] : 0, val[i] + result[i][j - arr[i]]);
					} else {
						if (i - 1 >= 0)
							result[i][j] = result[i - 1][j];
					}
				}
			}
		}
		return result[arr.length - 1][length];
	}
}
