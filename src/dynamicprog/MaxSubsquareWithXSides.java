package dynamicprog;

public class MaxSubsquareWithXSides {

	public void findLargestSubsqMatrix(int[][] matrix) {
		SubSquare[][] subsquareMatrix = new SubSquare[matrix.length][matrix.length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				SubSquare subsq;
				if (matrix[i][j] == 0) {
					subsq = new SubSquare(0, 0);
				} else {
					int vertical = 0;
					if (subsquareMatrix[i - 1][j] != null) {
						vertical = subsquareMatrix[i - 1][j].vertical + 1;
					}
					int horizontal = 0;
					if (subsquareMatrix[i][j - 1] != null)
						horizontal = subsquareMatrix[i][j - 1].horizontal + 1;
					subsq = new SubSquare(vertical, horizontal);
				}
				subsquareMatrix[i][j] = subsq;
			}
		}
	}

	static class SubSquare {
		int vertical, horizontal;
		SubSquare(int vertical, int horizontal) {
			this.vertical = vertical;
			this.horizontal = horizontal;
		}
	}
}
