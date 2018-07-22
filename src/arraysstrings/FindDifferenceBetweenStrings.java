package arraysstrings;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Solution to calculate difference in the character count between two strings
 * 
 * Ex: Difference between 'aarish' and 'ramesh' is 4 [a, i, m, e]
 * 
 * @author aarishramesh
 *
 */
public class FindDifferenceBetweenStrings {
	public static int numberNeeded(String first, String second) {
		HashMap<Character, Integer> firstStrMap = new HashMap<Character, Integer>();
		HashMap<Character, Integer> secondStrMap = new HashMap<Character, Integer>();
		int length = first.length();
		if (first.length() < second.length()) {
			length = second.length();
		}
		for (int i = 0; i < length; i++) {
			if (i < first.length()) {
				if (firstStrMap.get(first.charAt(i)) != null) {
					int val = firstStrMap.get(first.charAt(i));
					val = val + 1;
					firstStrMap.put(first.charAt(i), val);
				} else {
					firstStrMap.put(first.charAt(i), 1);
				}
			}
			if (i < second.length()) {
				if (secondStrMap.get(second.charAt(i)) != null) {
					int val = secondStrMap.get(second.charAt(i));
					val = val + 1;
					secondStrMap.put(second.charAt(i), val);
				} else {
					secondStrMap.put(second.charAt(i), 1);
				}
			}
		}
		
		int numDiff = 0;
		HashMap<Character, Integer> firstStrMapClone = new HashMap<Character, Integer>(firstStrMap);
		HashMap<Character, Integer> secondStrMapClone = new HashMap<Character, Integer>(secondStrMap);
		
		for (Entry<Character, Integer> entry : firstStrMap.entrySet()) {
			if (secondStrMap.containsKey(entry.getKey())) {
				int diffVal = Math.abs(entry.getValue() - secondStrMap.get(entry.getKey()));
				numDiff += diffVal;
				firstStrMapClone.remove(entry.getKey());
				secondStrMapClone.remove(entry.getKey());
			}
		}
		
		for (Entry<Character, Integer> entry : firstStrMapClone.entrySet()) {
			numDiff += entry.getValue();
		}
		
		for (Entry<Character, Integer> entry : secondStrMapClone.entrySet()) {
			numDiff += entry.getValue();
		}
		return numDiff;
	}      


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		System.out.println(numberNeeded(a, b));
		in.close();
	}
}
