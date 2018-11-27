package bitmanip;

/**
 * https://www.geeksforgeeks.org/count-total-set-bits-in-all-numbers-from-1-to-n/
 * 
 * Runtime complexity - O(NLogN)
 * 
 * @author polymath
 *
 */
public class CountSetBitsInAllNumbers {
	
	public static void main(String[] args) {
		System.out.println(countBits(7));
	}
	
 	public static int countBits(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		int bitCount = 0;
		for (int i = 1; i <= n; i++) {
			bitCount += bitCountUtil(i);
		}
		return bitCount;
	}
	
	private static int bitCountUtil(int n) {
		if (n <= 0)
			return 0;
		return ( n % 2 == 0 ? 0 : 1 ) + bitCountUtil(n / 2);
	}
}
