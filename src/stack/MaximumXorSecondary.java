package stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Referred this tutorial https://gautamimp.blogspot.in/2016/02/d-maximum-xor-secondary-find-max-and.html?showComment=1526498740946
 *  using monotonically decreasing stack
 * 
 * @author aarishramesh
 *
 */
public class MaximumXorSecondary {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int maxXor = 0;
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			int val = sc.nextInt();
			while(!s.isEmpty()) {
				maxXor = Math.max(maxXor, val ^ s.peek());
				if (val < s.peek()) {
					break;
				} else {
					s.pop();
				}
			}
			s.push(val);
		}
		System.out.println(maxXor);
		sc.close();
	}
}
