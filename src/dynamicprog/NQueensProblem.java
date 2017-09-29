package dynamicprog;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Determine a possible configuration of N queens on an N * N board or print 
 *  ' N queens cannot be fitted on the board '
 * 
 * @author aarishramesh
 *
 */
public class NQueensProblem {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		List<Integer> rowArr = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			rowArr.add(-1);
		
		if (findNQueens(n, rowArr, 0))
			printArr(rowArr); 
		else 
			System.out.println(n + " queens cannot be fitted on the board");
		sc.close();
	}
	
	private static void printArr(List<Integer> arr) {
		System.out.println(arr.toString());
	}
	
	private static boolean findNQueens(int n, List<Integer> rowArr, int row) {
		if (row == n) {
			return true;
		}
		for (int i = 0; i < rowArr.size(); i++) {
			if (isQueenPositionValid(rowArr, row, i)) {
				rowArr.set(row, i);
				if (findNQueens(n, rowArr, row + 1))
					return true;
			}
		}
		return false;
	}
	
	private static boolean isQueenPositionValid(List<Integer> rowArr, int row, int col) {
		
		//Ensure no queen is present in the column
		for (int i = 0; i < row; i++) {
			if (rowArr.get(i) == col) 
				return false;
		}
		
		//Ensure no queen is present in any diagonals
		boolean lowerLeftCheck = isQueenPresentInLowerLeftDiagonal(rowArr, row + 1, col - 1);
		boolean lowerRightCheck = isQueenPresentInLowerRightDiagonal(rowArr, row + 1, col + 1);
		boolean upperLeftCheck = isQueenPresentInUpperLeftDiagonal(rowArr, row - 1, col - 1);
		boolean upperRightCheck = isQueenPresentInUpperRightDiagonal(rowArr, row - 1, col + 1);
		if ( lowerLeftCheck || lowerRightCheck
				|| upperLeftCheck || upperRightCheck) {
			return false;
		}
		
		return true;
	}
	
	private static boolean isQueenPresentInUpperLeftDiagonal(List<Integer> rowArr, int row, int col) {
		if (row < 0 || col < 0)
			return false;
		if (rowArr.get(row) == col)
			return true;
		else 
			return isQueenPresentInUpperLeftDiagonal(rowArr, row - 1, col - 1);
	}
	
	private static boolean isQueenPresentInUpperRightDiagonal(List<Integer> rowArr, int row, int col) {
		if (row < 0 || col >= rowArr.size())
			return false;
		if (rowArr.get(row) == col)
			return true;
		else 
			return isQueenPresentInUpperRightDiagonal(rowArr, row - 1, col + 1);
	}
	
	private static boolean isQueenPresentInLowerLeftDiagonal(List<Integer> rowArr, int row, int col) {
		if (col < 0 || row >= rowArr.size())
			return false;
		if (rowArr.get(row) == col)
			return true;
		else 
			return isQueenPresentInLowerLeftDiagonal(rowArr, row + 1, col - 1);
	}
	
	private static boolean isQueenPresentInLowerRightDiagonal(List<Integer> rowArr, int row, int col) {
		if (row >= rowArr.size() || col >= rowArr.size())
			return false;
		if (rowArr.get(row) == col)
			return true;
		else 
			return isQueenPresentInLowerRightDiagonal(rowArr, row + 1, col + 1);
	}
}
