package dynamicprog;

/**
 * Write a program to perform regex matching with * an . 
 * 
 * References : http://leetcode.com/2011/09/regular-expression-matching.html
 */
public class RegexExpressionDP {
	public static void main(String[] args) {
		System.out.println(regexMatchingDp("baaaaaabaaaabaaaaababababbaab", "..a*aa*a.aba*a*bab*"));
	}

	public static int regexMatchingDp(String text, String regex) {
		boolean[][] regexMatch = new boolean[text.length() + 1][regex.length() + 1];
		
		regexMatch[0][0] = true;

		// Does regex match empty string ?
		boolean emptyRegexMatch = true;
		if (regex.equals(".*")) {
			int j = 1;
			while (j < regex.length()) {
				if (regex.charAt(j) == '*') {
					j += 2;
					continue;
				}
				emptyRegexMatch = false;
				break;
			}
		}
		if (emptyRegexMatch) {
			for (int j = 1; j < regex.length() + 1; j++) {
				regexMatch[0][j] = emptyRegexMatch;
			}
		}
		
		for (int i = 1; i < text.length() + 1; i++) {
			for (int j = 1; j < regex.length() + 1; j++) {
				if (text.charAt(i - 1) == regex.charAt(j - 1) || regex.charAt(j - 1) == '.') {
					regexMatch[i][j] = regexMatch[i - 1][j - 1];
				} else {
					if (regex.charAt(j - 1) == '*') {
						regexMatch[i][j]	 = regexMatch[i][j - 2];
						if (text.charAt(i - 1) == regex.charAt(j - 2) ||
								regex.charAt(j - 2) == '.') {
							regexMatch[i][j] = regexMatch[i][j] | regexMatch[i - 1][j];
						}
					}
				}
			}
		}
		return regexMatch[text.length()][regex.length()] ? 1 : 0;
	}
}
