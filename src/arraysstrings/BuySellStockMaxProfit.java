package arraysstrings;

/**
 * Given an array of integers, find the best Time to Buy and Sell Stock
 * 
 * 1) Only one txn is allowed
 * 
 * 2) Infinite number of txns allowed
 * 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * 
 * @author aarishramesh
 *
 */
public class BuySellStockMaxProfit {
	public static void main(String[] args) {
		int[] arr = {6,4,1,3,5,7,3,1,3,4,7,9,2,5,6,0,1,2};
		System.out.println(maxProfitInfiTnxs(arr));
		System.out.println(oneTimeMaxProfit(arr));
	}
	
	private static int oneTimeMaxProfit(int[] arr) {
		int maxProfit = 0;
		int minPrice = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < minPrice) {
				minPrice = arr[i];
				continue;
			}
			if (arr[i] - minPrice > maxProfit)
				maxProfit = arr[i] - minPrice;
		}
		return maxProfit;
	}
	
	private static int maxProfitInfiTnxs(int[] arr) {
		int totalProfit = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] < arr[i + 1])
				totalProfit += arr[i + 1] - arr[i];
		}
		return totalProfit;
	}
}
