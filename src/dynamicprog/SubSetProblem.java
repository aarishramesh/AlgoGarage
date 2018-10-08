package dynamicprog;

public class SubSetProblem {
	
	public static void main(String[] args) {
		int[] arr = {2, 3, 7, 8, 10};
		System.out.println(canSubsetBeFormed(arr, 11));
		System.out.println(canSubsetBeFormed(arr, 14));
	}
	
	public static boolean canSubsetBeFormed(int[] arr, int total) {
		boolean[][] result = new boolean[arr.length][total + 1];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < total + 1; j++) {
				if (j == 0 || i == j) {
					result[i][j] = true;
				} else {
					if (j < arr[i]) {
						if (i - 1 >= 0) {
							result[i][j] = result[i - 1][j];
						}
					} else {
						if (i - 1 >= 0)
							result[i][j] = result[i - 1][j - arr[i]];
					}
				}
			}
		}
		return result[arr.length - 1][total];
	}
}
