package dynamicprog;

/**
 * http://www.geeksforgeeks.org/count-number-binary-strings-without-consecutive-1s/
 * It is really a straight up fibonacci series with values
 * 1,2,3,5,8,13....
 */
public class CountNoOfBinaryStringsWithoutConsecutiveOnes {
	static int count = 0;

	public static void main(String[] args) {
		countBinaryString(0, 0, 5);
		countBinaryString(1, 0, 5);
		System.out.println(count);
	}

	public int count(int n){
		int a[] = new int[n];
		int b[] = new int[n];

		a[0] = 1;
		b[0] = 1;

		for(int i=1; i < n; i++){
			a[i] = a[i-1] + b[i-1];
			b[i] = a[i-1];
		}

		return a[n-1] + b[n-1];
	}

	public int countSimple(int n){
		int a = 1;
		int b = 1;

		for(int i=1; i < n; i++){
			int tmp = a;
			a = a + b;
			b = tmp;
		}

		return a + b;
	}


	public static void countBinaryString(int val, int digit, int n) {
		if (digit > n - 1)
			return;
		if (digit == n - 1)
			count++;
		countBinaryString(0, digit + 1, n);
		if (val == 0) {
			countBinaryString(1, digit + 1, n);
		}
	}
}
