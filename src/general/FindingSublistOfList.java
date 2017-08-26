package general;

import java.util.LinkedList;
import java.util.ListIterator;

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
	public static int find(LinkedList<String> list1, LinkedList<String> list2) {
		String a = getListAsString(list1);
		String b = getListAsString(list2);
		int sublist = a.indexOf(b);
		return sublist;
	}
	
	private static String getListAsString(LinkedList<String> list) {
		StringBuilder text = new StringBuilder();
		ListIterator<String> iterator = (ListIterator<String>) list.iterator();
		while (iterator.hasNext()) {
			text.append(iterator.next());
		}
		
		/**
		 *  JAVA 8 approach
		 */
		list.forEach(System.out::println);
		return text.toString();
	}
}
