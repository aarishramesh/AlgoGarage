package arraysstrings;

import java.util.ArrayList;

public class AntiDiagonals {
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> rowOne = new ArrayList<Integer>();
		rowOne.add(1); rowOne.add(2); rowOne.add(3);
		ArrayList<Integer> rowTwo = new ArrayList<Integer>();
		rowTwo.add(4); rowTwo.add(5); rowTwo.add(6);
		ArrayList<Integer> rowThree = new ArrayList<Integer>();
		rowThree.add(7); rowThree.add(8); rowThree.add(9);
		
		matrix.add(rowOne); matrix.add(rowTwo); matrix.add(rowThree);
		System.out.println(diagonal(matrix).toString());
	}
	
	public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int rows = A.size(), columns = A.get(0).size();
		for (int j = 0; j < columns; j++) {
			ArrayList<Integer> slice = new ArrayList<Integer>();
			int k = 0, l = j;
			while (k < rows && l >= 0) {
				slice.add(A.get(k).get(l));
				k++; l--;
			}
			result.add(slice);
		}
		
		for (int i = 1; i < rows; i++) {
			ArrayList<Integer> slice = new ArrayList<Integer>();
			int k = i, l = columns - 1;
			while (k < rows && l >= 0) {
				slice.add(A.get(k).get(l));
				k++; l--;
			}
			result.add(slice);
		}
		
		return result;
	}
}
