package arraysstrings;

/**
 * https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2962/
 * 
 * @author polymath
 *
 */
public class Atoi {
	
	public static void main(String[] args) {
		System.out.println(atoi("--21"));
	}
	
	public static int atoi(final String A) {
		int result = 0, ten = 10; boolean intFound = false, signFound = false, minusFound = false;
		for (int i = 0; i < A.length(); i++) {
			char ch = A.charAt(i);
			if (ch >= 48 && ch <= 57) {
				if (!intFound)
					intFound = true;
				long val = ((long)result * ten) + (ch - 48);
				if (minusFound)
					val = val * -1;
				if (val >= Integer.MAX_VALUE)
					return Integer.MAX_VALUE;
				else if (val <= Integer.MIN_VALUE)
					return Integer.MIN_VALUE;
				else {
					result = (result * ten) + (ch - 48);
				}
			} else {
				if ((ch == '-' || ch == '+') && !signFound && !intFound) {
					if (ch == '-')
						minusFound = true; 
					signFound = true;
				} else if (ch == ' ') {
					if (intFound || signFound)
						break;
					else
						continue;
				} else {
					if (!intFound) 
						return 0;
					break;
				}
			}
		}
		if (minusFound)
			result = result * -1;
		return result;
	}
}
