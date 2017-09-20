package arraysstrings;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class KthLargestFreq {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < testCases; i++) {
			String input = sc.nextLine();
			int freq = sc.nextInt();
			HashMap<Character, Integer> freqMap = new HashMap<Character, Integer>();
			for (int j = 0; j < input.length(); j++) {
				int count = freqMap.getOrDefault(input.charAt(j), 0);
				freqMap.put(input.charAt(j), count + 1);
			}
			List<Map.Entry<Character, Integer>> resultList = sortByValue(freqMap);
			
		}
	}

	public static <K, V extends Comparable<? super V>> List<Map.Entry<K, V>> 
		sortByValue(Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
		Collections.sort( list, new Comparator<Map.Entry<K, V>>() {
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return (o2.getValue()).compareTo( o1.getValue() );
			}
		});
		return list;
	}
}