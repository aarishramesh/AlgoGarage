package arraysstrings;

import java.util.ArrayList;

public class ReverseString {
	public static void main(String[] args) {
		System.out.println(reverseString("  aaaa  bbbb b   n  b "));
	}
	
	public static String reverseString(String a) {
		ArrayList<String> result = new ArrayList<String>();
		StringBuilder word = new StringBuilder();
		boolean charFound = false; char prevChar = ' ';
		if (a != null && !a.isEmpty()) {
			for (int i = a.length() - 1; i >= 0; i--) {
				if (a.charAt(i) == ' ') {
					if (charFound && prevChar != ' ') {
						result.add(word.toString());
						word = new StringBuilder();
						prevChar = ' ';
					}
				} else {
					if (!charFound)
						charFound = true;
					word.insert(0, a.charAt(i));
					prevChar = a.charAt(i);
				}
			}
			if (word.length() != 0) {
				result.add(word.toString());
			}
		}
		StringBuilder sentence = new StringBuilder();
		for (String obj : result) {
			sentence.append(obj + " ");
		}
		if (!sentence.toString().isEmpty())
			return sentence.deleteCharAt(sentence.length() - 1).toString();
		return sentence.toString();
	}
}
