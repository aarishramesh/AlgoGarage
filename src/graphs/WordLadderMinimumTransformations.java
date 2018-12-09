package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

public class WordLadderMinimumTransformations {
	
	public static void main(String[] args) {
		String start = "hit", end = "cog";
		ArrayList<String> dictionary = new ArrayList<String>();
		dictionary.add("hot"); dictionary.add("dot"); dictionary.add("dog"); dictionary.add("lot"); dictionary.add("log");
		wordLadderTwo(start, end, dictionary);
		System.out.println(minLength);
	}
	
	static int minLength = Integer.MAX_VALUE;
	
	public static void wordLadderTwo(String start, String end, ArrayList<String> dictionary) {
		if (start != null && end != null && !dictionary.isEmpty()) {
			Queue<WordLadderObj> queue = new LinkedList<WordLadderObj>();
			LinkedHashSet<String> first = new LinkedHashSet<String>();
			first.add(start);
			WordLadderObj obj = new WordLadderObj(first, start);
			queue.add(obj);
			while (!queue.isEmpty()) {
				WordLadderObj polledObj = queue.poll();
				String lastWord = polledObj.lastElement;
				for (String word : dictionary) {
					if (!polledObj.linkedSet.contains(word) && stringDiff(word, lastWord) < 3) {
						if (stringDiff(word, end) < 3) {
							if (polledObj.linkedSet.size() + 2 < minLength) {
								minLength = polledObj.linkedSet.size() + 2;
							}
						} else {
							LinkedHashSet<String> newSet = new LinkedHashSet<String>(polledObj.linkedSet);
							newSet.add(word);
							WordLadderObj newObj = new WordLadderObj(newSet, word);
							queue.add(newObj);
						}
					}
				}
			}
		}
	}
	
	static class WordLadderObj {
		LinkedHashSet<String> linkedSet;
		String lastElement;
		
		WordLadderObj(LinkedHashSet<String> linkedSet, String lastElement) {
			this.lastElement = lastElement;
			this.linkedSet = linkedSet;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((lastElement == null) ? 0 : lastElement.hashCode());
			result = prime * result + ((linkedSet == null) ? 0 : linkedSet.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			WordLadderObj other = (WordLadderObj) obj;
			if (lastElement == null) {
				if (other.lastElement != null)
					return false;
			} else if (!lastElement.equals(other.lastElement))
				return false;
			if (linkedSet == null) {
				if (other.linkedSet != null)
					return false;
			} else if (!linkedSet.equals(other.linkedSet))
				return false;
			return true;
		}
 	}
	
	public static int stringDiff(String first, String second) {
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
}
