package dynamicprog;

public class MaxRectAreaInBinaryMatrix {
	
	public static void main(String[] args) {
		int[][] matrix = {{1},{0}};
		System.out.println(maxArea(matrix));
	}
	
	public static int maxArea(int[][] matrix) {
		if (matrix.length == 1 || matrix[0].length == 1) {
			if (matrix.length == 1) {
				for (int j = 0; j < matrix[0].length; j++) {
					if (matrix[0][j] == 0) {
						return 0;
					}
				}
				return matrix[0].length;
			}
			if (matrix[0].length == 1) {
				for (int i = 0; i < matrix.length; i++) {
					if (matrix[i][0] == 0)
						return 0;
				}
				return matrix.length;
			}
		}
		SubSquare[][] values = new SubSquare[matrix.length][matrix[0].length];
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1) {
					int hori = 1;
					if (j - 1 >= 0) {
						if (values[i][j - 1] != null)
							hori += values[i][j - 1].hori;
					}
					int vert = 1;
					if (i - 1 >= 0) {
						if (values[i - 1][j] != null)
							vert += values[i - 1][j].vert;
					}
					SubSquare subsq = new SubSquare(hori, vert);
					values[i][j] = subsq;
				}
			}
		}
		
		// Logic to find max area
		int maxArea = 1;

		for (int i = matrix.length - 1; i >= 0; i--) {
			for (int j = matrix[0].length - 1; j >= 0; j--) {
				if (values[i][j] != null) {
					boolean rectFound = false;
					int tempCol = j - 1, tempRow = i - 1;
					while (tempRow >= 0 && tempCol >= 0) {
						SubSquare horSq = values[i][tempCol];
						SubSquare vertSq = values[tempRow][j];
						if (horSq != null && vertSq != null) {
							if (horSq.vert >= values[i][j].vert
									&& vertSq.hori >= values[i][j].hori) {
								rectFound = true;
								tempRow--; tempCol--;
								continue;
							} else {
								rectFound = false;
								break;
							}
						} else {
							rectFound = false;
							break;
						}
					}
					if (rectFound) {
						int area = (i + 1) * (j + 1);
						if (area > maxArea)
							maxArea = area;
					}
				}
			}
		}
	
		return maxArea;
	}
	
	static class SubSquare {
		int hori, vert;
		
		SubSquare(int hori, int vert) {
			this.hori = hori;
			this.vert = vert;
		}
	}
}
