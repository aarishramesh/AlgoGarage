package general;

/**
 * 
 * 
 * @author polymath
 *
 */
public class CatalanNumber {
	static int[] memoizedCatalanArr;
	static int catalan(int n) { 
		int res = 0; 

		// Base case 
		if (n <= 1) { 
			return 1; 
		}  else if (memoizedCatalanArr[n] != 0) {
			return memoizedCatalanArr[n];
		} else {
			for (int i = 0; i < n; i++) { 
				res += catalan(i) * catalan(n - i - 1); 
			}
			memoizedCatalanArr[n] = res;
		}
		return res; 
	} 

	public static void main(String[] args) {
		memoizedCatalanArr = new int[10];
		memoizedCatalanArr[0] = 1;
		memoizedCatalanArr[1] = 1;
		for (int i = 0; i < 10; i++) { 
			System.out.print(catalan(i) + " "); 
		} 
	} 
}