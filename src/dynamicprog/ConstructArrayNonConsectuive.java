package dynamicprog;

/**
 * 
 * Solution video tutorial - https://www.youtube.com/watch?v=_nLeiMMSd4E&feature=youtu.be
 * @author polymath
 *
 */
public class ConstructArrayNonConsectuive {
	public static long constArrayNoOfWays(int n, int k, int x) {
		long[] endingInX = new long[n];
		long[] notEndingInX = new long[n];
		endingInX[0] = 0; notEndingInX[0] = 1;
		for (int i = 1; i < n; ++i) {
			endingInX[i] = notEndingInX[i - 1];
			notEndingInX[i] = endingInX[i - 1] * (k - 1) + notEndingInX[i - 1] * (k - 2);
		}
		return endingInX[n - 1];
	}

}