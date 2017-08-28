package general;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Implement a method 'find' that will find the starting index (zero based) 
 * where the second list occurs as a sub-list in the first list. 
 * It should return -1 if the sub-list cannot be found.
 * Arguments are always given, not empty.
 * 
 * @author aarishramesh
 *
 */
public class FindingSublistOfList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int firstListSize = sc.nextInt();
			ArrayList<Integer> listA = new ArrayList<Integer>();
			for (int i = 0; i < firstListSize; i++) {
				listA.add(sc.nextInt());
			}
			int secondListSize = sc.nextInt();
			ArrayList<Integer> listB = new ArrayList<Integer>();
			for (int i = 0; i < secondListSize; i++) {
				listB.add(sc.nextInt());
			}
			System.out.println(find(listA, listB));
		} catch (Exception ex) {
			ex.printStackTrace();
			
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}

	public static int find(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		String a = getListAsString(list1);
		String b = getListAsString(list2);
		int sublist = a.indexOf(b);
		return sublist;
	}

	private static String getListAsString(ArrayList<Integer> list) {
		StringBuilder text = new StringBuilder();
		for (Integer val : list) {
			text.append(val);
		}
		return text.toString();
	}
}
