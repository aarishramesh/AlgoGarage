package arraysstrings;

/**
 * https://www.geeksforgeeks.org/return-a-pair-with-maximum-product-in-array-of-integers/
 * 
 * @author polymath
 *
 */
public class FindPairWithMaxProduct {
	public static void main(String[] args) {
		//int[] arr = {1, 4, 3, 6, 7, 0};
		int[] arr = {-1, -3, -4, 2, 0, -5};
		System.out.println(maxProduct(arr));
	}
	
	public static int maxProduct(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int max1 = 0, max2 = 0, min1 = 0, min2 = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				if (arr[i] < min2) {
					if (arr[i] < min1) {
						min2 = min1;
						min1 = arr[i];
					} else
						min2 = arr[i];
				}
			} else if (arr[i] > 0) {
				if (arr[i] > max2) {
					if (arr[i] > max1) {
						max2 = max1;
						max1 = arr[i];
					} else
						max2 = arr[i];
				}
			}
		}
		if (min1 * min2 > max1 * max2) {
			return min1 * min2;
		} else {
			return max1 * max2;
		}
	}
}
