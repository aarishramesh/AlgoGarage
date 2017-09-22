package arraysstrings;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
	
/**
 * Algorithm to find out kth largest frequency letter in an array of letters
 * 
 * Sample input : aabcd 
 * Sample output for 1 -> a , 2 -> b, 3 -> -1
 * 
 * Runtime complexity : O(NLogN) - Sorting values by entries
 * Space complexity : O(N) - List of entries + HashMap cost
 * 
 * TODO : Need to check nth order statistic algorithm for O(N) solution 
 * 
 * https://stackoverflow.com/questions/46330187/finding-kth-frequency-letter-in-a-string-of-characters/46332202?noredirect=1#comment79652054_46332202
 * 
 * @author aarishramesh
 *
 */
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

			removeDuplicates(resultList);

			if (resultList.size() >= freq) {
				System.out.println(resultList.get(freq - 1).getKey());
			} else {
				System.out.println(-1);
			}
			sc.nextLine();
		}
		sc.close();
	}
	
	private static <K, V extends Comparable<? super V>> List<Map.Entry<K, V>> 
		sortByValue(Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
		Collections.sort( list, new Comparator<Map.Entry<K, V>>() {
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return (o2.getValue()).compareTo( o1.getValue() );
			}
		});
		return list;
	}
	
	private static <K,V> void removeDuplicates(List<Entry<K, V>> list) {
		if (list.size() == 0 || list.size() == 1) {
			return;
		}
		int j = 0;
		int size = list.size();
		for (int i = 1; i < size;) {
			if (list.get(i).getValue() == list.get(j).getValue()) {
				list.remove(i);
				size -= 1;
			} else {
				i++;
				j++;
			}
		}
	}
	

}