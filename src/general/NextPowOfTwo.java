package general;

import java.util.Scanner;

/**
 * http://www.geeksforgeeks.org/next-power-of-2/
 * 
 * Time complexity - O(logN)
 * 
 * @author polymath
 *
 */
public class NextPowOfTwo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(findNextPowOfTwoUsingLogCeiling(n));
		sc.close();
	}
	
	public static int findNextPowOfTwoUsingLogCeiling(int n) {
		int count = 0;
		while (n != 0) {
			n = n >> 1;
			count++;
		}
		int val = (int)Math.pow(2, count);
		return val; // Returning the ceiling of pow of two
	}
}
