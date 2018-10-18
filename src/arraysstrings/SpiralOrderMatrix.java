package arraysstrings;

/**
 * https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 * 
 * @author polymath
 *
 */
public class SpiralOrderMatrix {

	public static void main(String[] args) {
		int[][] matrix = {{133, 241, 22}, {258, 187, 150}, {79, 207, 196}, {401, 366, 335}, {401, 55, 260}, {363, 14, 318}};
		int[] result = printMatrixSpiralOrder(matrix);
		for (int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
	}

	public static int[] printMatrixSpiralOrder(int[][] matrix) {
		int rows = matrix.length, columns = matrix[0].length;
		int[] arr = new int[matrix.length * matrix[0].length];
		
		int k = 0, l = 0, index = 0;
		while (k < rows && l < columns) {
			for (int j = l; j < columns; j++)
				arr[index++] = matrix[k][j];
			k++;
			for (int i = k; i < rows; i++)
				arr[index++] = matrix[i][columns - 1];
			columns--;
			if (k < rows) {
				for (int j = columns - 1; j >= l; j--)
					arr[index++] = matrix[rows - 1][j];
				rows--;
			}
			if (l < columns) {
				for (int i = rows - 1; i >= k; i--)
					arr[index++] = matrix[i][l];
				l++;
			}
		}
		return arr;
	}
}
