package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PrintAllStringPossibleByAddingSpaces {
	public static List<String> printStringWithSpaces(String input, int start, int end) {
		List<String> result = new ArrayList<String>();
		if (start < end) {
			for (int i = start; i < end; i++) {
				String prefix = input.substring(start, i + 1);
				List<String> tempResult = printStringWithSpaces(input, i + 1, end);
				for (String curr : tempResult) {
					if (curr.isEmpty())
						result.add(prefix);
					else
						result.add(prefix + " " + curr);
				}
			}
		} else
			result.add("");
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(printStringWithSpaces("ABCD", 0, 4));
	}
}
