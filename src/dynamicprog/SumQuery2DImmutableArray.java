package dynamicprog;

import java.util.Scanner;


/**
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 * 
 * @author polymath
 *
 */
public class SumQuery2DImmutableArray {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt(), columns = sc.nextInt();
		int[][] matrix = new int[rows][columns];
		for (int  i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		int[][] rowColumns = new int[2][2];
		rowColumns[0][0] = sc.nextInt() + 1;
		rowColumns[0][1] = sc.nextInt() + 1;
		rowColumns[1][0] = sc.nextInt() + 1;
		rowColumns[1][1] = sc.nextInt() + 1;
		System.out.println(findSum(matrix, rowColumns));
		sc.close();
	}
	
	private static int findSum(int[][] matrix, int[][] rowColumns) {
		int[][] sumMatrix = new int[matrix.length + 1][matrix.length + 1];
		
		//Filling the sum matrix
		for (int i = 1; i < sumMatrix.length; i++) {
			for (int j = 1; j < sumMatrix.length; j++) {
				sumMatrix[i][j] = sumMatrix[i - 1][j] + sumMatrix[i][j - 1] - sumMatrix[i - 1][j - 1] + matrix[i - 1][j - 1];
			}
		}
		
		int r1 = rowColumns[0][0], c1 = rowColumns[0][1], r2 = rowColumns[1][0], c2 = rowColumns[1][1];
		
		//Evaluating sum from 
		int sum = sumMatrix[r2][c2] - sumMatrix[r2][c1 - 1] - sumMatrix[r1 - 1][c2] + sumMatrix[r1 - 1][c1 - 1];
		
		return sum;
	}
}
