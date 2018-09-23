package general;

import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/stickler-theif/0
 * 
 * @author polymath
 *
 */
public class SticklierThief {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int tc  = sc.nextInt();
		for (int j = 0; j < tc; j++) {
			int n = sc.nextInt();
			int[] houseAmount = new int[n];
			for (int i = 0; i < n; i++)
				houseAmount[i] = sc.nextInt();

			int inc = houseAmount[0];
			int exc = 0;
			for (int i = 1; i < houseAmount.length; i++) {
				int newInc = Math.max(exc + houseAmount[i], inc);
				exc = inc;
				inc = newInc;
			}
			System.out.println(inc);
		}
		sc.close();
	}
}