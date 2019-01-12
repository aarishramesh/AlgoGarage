package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintTelephoneNumberWordCombinations {
	private static Map<Integer, List<Character>> phoneDigitVsCharacterMap =
			new HashMap<Integer, List<Character>>();
	
	public static void printCombinations(int[] numbers, int digit, StringBuilder currWord, List<String> wordCombinations) {
		if (digit == numbers.length) {
			wordCombinations.add(currWord.toString());
		} else {
			List<Character> mappedCharForDigits = phoneDigitVsCharacterMap.get(numbers[digit]);
			for (Character letter : mappedCharForDigits) {
				currWord.append(letter);
				printCombinations(numbers, digit + 1, currWord, wordCombinations);
				currWord.deleteCharAt(currWord.length() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		List<Character> characters = new ArrayList<Character>();
		characters.add('a'); characters.add('b'); characters.add('c');
		phoneDigitVsCharacterMap.put(2, characters);
		characters = new ArrayList<Character>();
		characters.add('d'); characters.add('e'); characters.add('f');
		phoneDigitVsCharacterMap.put(3, characters);
		characters = new ArrayList<Character>();
		characters.add('g'); characters.add('h'); characters.add('i');
		phoneDigitVsCharacterMap.put(4, characters);
		characters = new ArrayList<Character>();
		characters.add('j'); characters.add('k'); characters.add('l');
		phoneDigitVsCharacterMap.put(5, characters);
		characters = new ArrayList<Character>();
		characters.add('m'); characters.add('n'); characters.add('o');
		phoneDigitVsCharacterMap.put(6, characters);
		characters = new ArrayList<Character>();
		characters.add('p'); characters.add('q'); characters.add('r');characters.add('s');
		phoneDigitVsCharacterMap.put(7, characters);
		characters = new ArrayList<Character>();
		characters.add('t'); characters.add('u'); characters.add('v');
		phoneDigitVsCharacterMap.put(8, characters);
		characters = new ArrayList<Character>();
		characters.add('w'); characters.add('x'); characters.add('y');characters.add('z');
		phoneDigitVsCharacterMap.put(9, characters);
		
		int[] numbers = {2, 3};
		List<String> wordCombinations = new ArrayList<String>();
		printCombinations(numbers, 0, new StringBuilder(), wordCombinations);
		
		System.out.println(wordCombinations.toString());
	}
}
