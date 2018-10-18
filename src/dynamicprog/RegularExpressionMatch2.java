package dynamicprog;

/**
 * https://www.interviewbit.com/problems/regular-expression-match/
 * 
 * @author polymath
 *
 */
public class RegularExpressionMatch2 {
	public static void main(String[] args) {
		/**
		System.out.println(isMatch("aa", "a"));
		System.out.println(isMatch("aa", "aa"));
		System.out.println(isMatch("aaa", "aa"));
		System.out.println(isMatch("aa", "*"));
		System.out.println(isMatch("aa", "a*"));
		System.out.println(isMatch("aa", "?*"));
		System.out.println(isMatch("aab", "c*a*b"));**/
		
		String str = "cc";
		String regex = "***??";
		
		System.out.println(isMatch(str, regex));
	}
	
	static int isMatch(String str, String regex) {
		
		boolean[][] match = new boolean[str.length() + 1][regex.length() + 1];
		match[0][0] = true;
		
		int anyMatchCount = 0; boolean otherCharacterEnc = false;
		for (int j = 0; j < regex.length(); j++) {
			if (regex.charAt(j) == '*') {
				anyMatchCount++;
				if (!otherCharacterEnc) {
					match[0][j + 1] = true;
				}
			} else {
				otherCharacterEnc = true;
			}
		}
		if (anyMatchCount == regex.length())
			return 1;

		for (int i = 1; i < match.length; i++) {
			for (int j = 1; j < match[0].length; j++) {
				if (str.charAt(i - 1) == regex.charAt(j - 1) || regex.charAt(j - 1) == '?') {
					match[i][j] = match[i - 1][j - 1];
				} else if (regex.charAt(j - 1) == '*') {
					match[i][j] = match[i][j - 1] || match[i - 1][j - 1] || match[i - 1][j];
				}
			}
		}
		return match[str.length()][regex.length()] == true ?  1 :  0;
	}
}
