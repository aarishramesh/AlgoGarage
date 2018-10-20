package binarysearch;

/**
 * https://www.geeksforgeeks.org/square-root-of-an-integer/
 * 
 * @author polymath
 *
 */
public class SquareRootOfNumber {
	
	public static void main(String[] args) {
		System.out.println(sqRootOfNumber(2147483647));
	}
	
	public static int sqRootOfNumber(int n) {
		if (n == 0 || n == 1)
			return 1;
		int left = 1, right = n, mid = 0;
		while (left <= right) {
			mid = (left + right) / 2;
			if (mid > n / mid) {
				right = mid -1;
			} else {
				if ((mid + 1) >= n / (mid + 1)) {
					return mid;
				}
				left = mid + 1;
			}
		}
		return mid;
	}
}
