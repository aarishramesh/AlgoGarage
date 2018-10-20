package arraysstrings;

public class SpiralMatrixVariation {
	
	public static void main(String[] args) {
		int[][] result = constSpiralMatrix(4);
		for(int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] constSpiralMatrix(int n) {
		int[][] result = new int[n][n];
		int rows = n, columns = n, k = 0, l = 0, num = 1;
		while (k < rows && l < columns) {
			for (int j = l; j < columns; j++)
				result[k][j] = num++;
			k++;
			for (int i = k; i < rows; i++)
				result[i][columns - 1] = num++;
			columns--;
			if (k < rows) {
				for (int j = columns -  1; j >= l; j--)
					result[rows - 1][j] = num++;
				rows--;
			}
			if (l < columns) {
				for (int i = rows - 1; i >= k; i--)
					result[i][l] = num++;
				l++;
			}
		}
		return result;
	}
}
