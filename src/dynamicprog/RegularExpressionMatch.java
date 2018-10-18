package dynamicprog;

public class RegularExpressionMatch {
	public static void main(String[][] args) {
		System.out.println(isMatch("aa", "a"));
		System.out.println(isMatch("aa", "aa"));
		System.out.println(isMatch("aaa", "aa"));
		System.out.println(isMatch("aa", "*"));
		System.out.println(isMatch("aa", "a*"));
		System.out.println(isMatch("aa", "?*"));
		System.out.println(isMatch("aab", "c*a*b"));
	}
	
	static int isMatch(String str, String regex) {
		boolean[][] match = new boolean[str.length() + 1][regex.length() + 1];
		match[0][0] = true;
		if (regex.equals("*")) {
			for (int j = 1; j < match[0].length; j++)
				match[0][j] = true;
		}
		for (int i = 1; i < match.length; i++) {
			for (int j = 1; j < match[0].length; j++) {
				if (regex.charAt(j - 1) == '?') {
					match[i][j] = true;
				} else if (regex.charAt(j - 1) == '*') {
					match[i][j] = match[i - 1][j] || match[i][j - 1];
				} else {
					if (str.charAt(i - 1) == regex.charAt(j - 1)) {
						match[i][j] = match[i - 1][j - 1];
					} else {
						if (j > 1) {
							if (regex.charAt(j - 2) == '*') {
								match[i][j] = match[i - 1][j];
							}
						}
					}
				}
			}
		}
		return match[str.length()][regex.length()] == true ?  1 :  0;
	}
}
