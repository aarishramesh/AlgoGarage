package general;

import java.math.BigInteger;

public class TrailingZerosInFactorial {
	
	 public static void main(String[] args) {
		 System.out.println(trailingZeros(9247));
	 }
	 public static int trailingZeros(int A) {
		 int zeros = 0, divisor = 5;
		 while (A / divisor > 0) {
			 zeros += A / divisor;
			 divisor *= 5;
		 }
		 return zeros;
	 }
}
