package arraysstrings;

public class Atoi {
	
	public static void main(String[] args) {
		System.out.println(atoi("-643556183011M11 648G1 903778065 762 75316456373673B5 334 19885 90668 8 98K X277 9846"));
	}
	
	public static int atoi(final String A) {
		int result = 0, tens = 10; boolean intFound = false, signFound = false, minusFound = false;
		for (int i = 0; i < A.length(); i++) {
			char ch = A.charAt(i);
			if (ch >= 48 && ch <= 57) {
				if (!intFound)
					intFound = true;
				long val = ((long)result * tens) + (ch - 48);
				if (minusFound)
					val = val * -1;
				if (val >= Integer.MAX_VALUE)
					return Integer.MAX_VALUE;
				else if (val <= Integer.MIN_VALUE)
					return Integer.MIN_VALUE;
				else {
					result = (result * tens) + (ch - 48);
				}
			} else {
				if (ch == '-' && !signFound && !intFound) {
					minusFound = true; 
					signFound = true;
				} else if (ch == '+' && !signFound && !intFound) { 
					signFound = true;
				} else if (ch == ' ') {
					if (intFound)
						break;
					else
						return 0;
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
