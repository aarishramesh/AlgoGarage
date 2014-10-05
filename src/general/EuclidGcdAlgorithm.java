package general;

import java.util.Scanner;

/**
 * A GCD/HCF calculator implementation using recursion by Euclid's Algorithm 
 * http://en.wikipedia.org/wiki/Euclidean_algorithm
 * 
 * This can be practically applied to fill out a rectangular area with square tiles leaving no residual space left
 * 
 * Sample question:
 * 
 * Find the greatest dimension of the square tile to fill out the rectangular area leaving no residual space 
 * having the dimensions 8 X 6 and the number of squares which can be laid out. 
 * 
 * The answer is square with side 2 and number of squares is 12(4 X 3) 
 * 
 * Complexity calculation using Iteration method
 * 
 * Recurrence relation is given by 
 * T(a, b)  =  T(b, r0) + 1
 * 			=  T(r0, r1) + 2
 * 			=  T(r(N-2), r(N-1)) + N
 * 			=  T(r(N-1), 0) + N
 * 			=  N + 1
 * 
 * where a, b are the numbers for which GCD/HCF is to be determined
 * 
 * Since we assume T(x, 0) = 1
 * 
 * Therefore Euclidian algorithm always requires N steps 
 * 
 * N, the number of steps in Euclid's algorithm can never be more than five times the number of its digits (base 10)
 * 
 * N <= 5 log10b
 * 
 * Euclidean algorithm always needs less than O(h) divisions, where h is the number of digits in the smaller number b
 * 
 * @author AARISH
 */
public class EuclidGcdAlgorithm {
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			System.out.println("Enter two numbers for GCD computation");
			sc = new Scanner(System.in);
			int a  = sc.nextInt();
			int b = sc.nextInt();
			gcdCalculator(a, b);
		} catch(Exception e) {
			System.out.println("Enter proper integer input");
		} finally {
			sc.close();
		}
	}

	public static void gcdCalculator(int m, int n) {
		if(n == 0) {
			System.out.println("GCD of the numbers is:"+m);
		} else {
			gcdCalculator(n, m%n);
		}
	}
}

