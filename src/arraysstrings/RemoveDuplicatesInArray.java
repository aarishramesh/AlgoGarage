package arraysstrings;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Algorithm to remove duplicates in a sorted array of integers
 * 
 * Time Complexity -  O(N)
 * Space Complexity - O(1)
 * 
 * @author aarishramesh
 *
 */
public class RemoveDuplicatesInArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int size = sc.nextInt();
			LinkedList<Integer> list = new LinkedList<Integer>();
			for (int i = 0; i < size; i++) {
				list.add(sc.nextInt());
			}
			removeDuplicates(list);
			System.out.println(list.toString());
		} finally {
			sc.close();
		}
	}

	private static void removeDuplicates(LinkedList<Integer> list) {
		if (list.size() == 0 || list.size() == 1) {
			return;
		}
		int j = 0;
		int size = list.size();
		for (int i = 1; i < size;) {
			if (list.get(i) == list.get(j)) {
				list.remove(i);
				size -= 1;
			} else {
				i++;
				j++;
			}
		}
	}
}
