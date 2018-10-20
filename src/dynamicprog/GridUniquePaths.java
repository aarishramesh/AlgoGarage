package dynamicprog;

/**
 * https://www.interviewbit.com/problems/grid-unique-paths/
 * 
 * @author polymath
 *
 */
public class GridUniquePaths {

	public static void main(String[] args) {
		System.out.println(uniquePaths(2, 2));
	}

	public static int uniquePaths(int A, int B) {
		int[][] result = new int[A][B];
		for (int i = 0; i < A; i++) {
			for (int j = 0; j < B; j++) {
				if (i == 0 && j == 0)
					result[0][0] = 1;
				else {
					int left = j - 1 >= 0 ? result[i][j - 1] : 0;
					int right = i-1 >= 0 ? result[i - 1][j] : 0;
					result[i][j] = left + right;
				}
			}
		}
		return result[ A - 1][B - 1];
	}
}
