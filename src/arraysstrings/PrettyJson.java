package arraysstrings;

import java.util.ArrayList;

public class PrettyJson {
	
	public static void main(String[] args) {
		String test =  "{\"attributes\":[{\"nm\":\"ACCOUNT\",\"lv\":[{\"v\":{\"Id\":null,\"State\":null},\"vt\":\"java.util.Map\",\"cn\":1}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":13585},{\"nm\":\"PROFILE\",\"lv\":[{\"v\":{\"Party\":null,\"Ads\":null},\"vt\":\"java.util.Map\",\"cn\":2}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":41962}]}";
		ArrayList<String> result = prettyJson(test);
		System.out.println(result.toString());
		for (String line : result)
			System.out.println(line);
	}
	public static ArrayList<String> prettyJson(String A) {
		ArrayList<String> result = new ArrayList<String>();
		if (A != null && !A.isEmpty()) {
			StringBuilder temp = new StringBuilder();
			StringBuilder tabBuilder = new StringBuilder();
			for (int i = 0; i < A.length(); i++) {
				if (A.charAt(i) == '[' || A.charAt(i) == '{') {
					temp.append(A.charAt(i));
					result.add(temp.toString());
					tabBuilder.append("\t");
					temp.delete(0, temp.length());
					temp.append(tabBuilder.toString());
				} else if (A.charAt(i) == ',' || (A.charAt(i) == ':' && i + 1 < A.length() && (A.charAt(i + 1) == '[' || A.charAt(i + 1) == '{')) ||
						(A.charAt(i) != ']' && A.charAt(i) != '}' && i + 1 < A.length() && (A.charAt(i + 1) == ']' || A.charAt(i + 1) == '}'))) {
					temp.append(A.charAt(i)); // }}]] }] cases
					result.add(temp.toString());
					if (A.charAt(i) != ']' && A.charAt(i) != '}' && i + 1 < A.length() && ((A.charAt(i + 1) == ']' || A.charAt(i + 1) == '}'))) {
						if (tabBuilder.length() - 1 >= 0)
							tabBuilder.deleteCharAt(tabBuilder.length() - 1);
					}
					temp.delete(0, temp.length());
					temp.append(tabBuilder.toString());
				} else if (A.charAt(i) == ']' || A.charAt(i) == '}') {
					temp.append(A.charAt(i)); // }, }], cases
					if (i + 1 < A.length() && A.charAt(i + 1) == ',') {
						temp.append(A.charAt(i + 1));
						i++;
					} else {
						if (tabBuilder.length() - 1 >= 0)
							tabBuilder.deleteCharAt(tabBuilder.length() - 1);
					}
					result.add(temp.toString());
					temp.delete(0, temp.length());
					temp.append(tabBuilder.toString());
				} else if (A.charAt(i) != ' ')
					temp.append(A.charAt(i));
			}
			result.add(temp.toString());
		}
		return result;
	}
}
