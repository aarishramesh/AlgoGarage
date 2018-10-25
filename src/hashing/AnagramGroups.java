package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AnagramGroups {
	
	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<String>();
		words.add("cat"); words.add("dog1"); words.add("god1"); words.add("tca2");
		System.out.println(anagrams(words).toString());
	}
	
	public static ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (A != null && !A.isEmpty()) {
			Map<WordBreakup, ArrayList<Integer>> anagramMap = new HashMap<WordBreakup, ArrayList<Integer>>();
			int index = 1;
			for (String word : A) {
				HashMap<Character, Integer> freqMap = new HashMap<Character, Integer>();
				for (int i = 0; i < word.length(); i++) {
					int count = freqMap.getOrDefault(word.charAt(i), 0);
					freqMap.put(word.charAt(i), count + 1);
				}
				WordBreakup obj = new WordBreakup(freqMap);
				if (anagramMap.containsKey(obj)) {
					anagramMap.get(obj).add(index);
				} else {
					ArrayList<Integer> anagramGroup = new ArrayList<Integer>();
					anagramGroup.add(index);
					anagramMap.put(obj, anagramGroup);
				}
				index++;
			}
			for (Entry<WordBreakup, ArrayList<Integer>> entry : anagramMap.entrySet()) {
				ArrayList<Integer> anagramGroup = entry.getValue();
				result.add(anagramGroup);
			}
		}
		return result;
	}
	
	static class WordBreakup {
		Map<Character
		, Integer> charVsFreq;

		WordBreakup(Map<Character, Integer> obj) {
			this.charVsFreq = obj;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((charVsFreq == null) ? 0 : charVsFreq.hashCode());
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
			WordBreakup other = (WordBreakup) obj;
			if (charVsFreq == null) {
				if (other.charVsFreq != null)
					return false;
			} else if (!charVsFreq.equals(other.charVsFreq))
				return false;
			return true;
		}
	}
}
