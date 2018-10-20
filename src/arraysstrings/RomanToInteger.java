package arraysstrings;

public class RomanToInteger {
	public static void main(String[] args) {
		//System.out.println(romanToInteger("MMCDLXXV"));
		System.out.println(multiply("123", "456"));
	}
	
	public static String multiply(String A, String B) {
        String result = null;
        if (A != null && !A.isEmpty() && B != null && !B.isEmpty()) {
            result = (Long.parseLong(A) * Long.parseLong(B)) + "";
        }
        return result;
    }
	
	public static int romanToInteger(String romanNum) {
		int result = 0, resultCopy = 0;;
		for (int i = 0; i < romanNum.length(); i++) {
			resultCopy = result;
			char first = romanNum.charAt(i);
			if ( i + 1 < romanNum.length()) {
				String subStr = romanNum.substring(i, i + 2);
				switch (subStr) {
				case "CM":
					resultCopy += 900;
					break;
				case "CD":
					resultCopy += 400;
					break;
				case "XC":
					resultCopy += 90;
					break;
				case "XL":
					resultCopy += 40;
					break;
				case "IX":
					resultCopy += 9;
					break;
				case "IV":
					resultCopy += 4;
					break;
				}
				if (result != resultCopy) {
					result = resultCopy;
					i++;
					continue;
				}
			}
			switch(first) {
			case 'M' :
				resultCopy += 1000;
				break;
			case 'D':
				resultCopy += 500;
				break;
			case 'C':
				resultCopy += 100;
				break;
			case 'L':
				resultCopy += 50;
				break;
			case 'X':
				resultCopy += 10;
				break;
			case 'V':
				resultCopy += 5;
				break;
			case 'I':
				resultCopy += 1;
			}
			result = resultCopy;
		}
		return result;
	}
}
