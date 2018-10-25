package hashing;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

public class Fractions {

	public static void main(String[] args) {
		/**
		System.out.println(fractionToDecimalNew(2, 5));
		System.out.println(fractionToDecimalNew(1, 2));
		System.out.println(fractionToDecimalNew(2, 3));
		System.out.println(fractionToDecimalNew(1, 81));
		System.out.println(fractionToDecimalNew(0, 0));
		System.out.println(fractionToDecimalNew(Integer.MIN_VALUE, -1));
		System.out.println(fractionToDecimalNew(1, Integer.MIN_VALUE));
		System.out.println(fractionToDecimalNew(1, Integer.MAX_VALUE));
		System.out.println(fractionToDecimalNew(20, 4));
		System.out.println(fractionToDecimalNew(1, 9));
		System.out.println(fractionToDecimalNew(1, 3));
		System.out.println(fractionToDecimalNew(7, 12));
		System.out.println(fractionToDecimalNew(1, 7));
		System.out.println(fractionToDecimalNew(22, 7));
		System.out.println(fractionToDecimalNew(Integer.MIN_VALUE, Integer.MAX_VALUE));
		System.out.println(fractionToDecimalNew(Integer.MAX_VALUE, Integer.MIN_VALUE));
		System.out.println(fractionToDecimalNew(593, 88));
		System.out.println(fractionToDecimalNew(353, 905));**/
		
		System.out.println(fractionToDecimalNew(1, 97));
	}

	public static String fractionToDecimalNew(int A, int B) {
		if (A == 0 || B == 0)
			return "0";

		BigDecimal a = new BigDecimal(A + "");
		BigDecimal b = new BigDecimal(B + "");
		BigDecimal result = a.divide(b, 1000, RoundingMode.HALF_UP);
		String resultStr = result.toPlainString();

		boolean dotIndexFound = false;
		HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		for (int i = 1; i < resultStr.length(); i++) {
			
			if (!dotIndexFound) {
				while (resultStr.charAt(i) != '.') {
					i++;
					if (i >= resultStr.length()) {
						return resultStr;
					}
				}
				dotIndexFound = true;
			}
			if (!freqMap.containsKey(resultStr.charAt(i) - 48)) {
				freqMap.put(resultStr.charAt(i) - 48, i);
			} else {
				int matchIndex = freqMap.get(resultStr.charAt(i) - 48);
				int matchIdxPtr = matchIndex;
				int j = i;
				String pattern = resultStr.substring(matchIndex, i);
				int patternLen = 0;
				while (j < resultStr.length() && patternLen < pattern.length() && resultStr.charAt(j) - 48 == resultStr.charAt(matchIdxPtr) - 48) {
					j++; matchIdxPtr++;
					patternLen++;
				}
				boolean patternFound = false;
				if (patternLen == pattern.length()) {
					patternFound = true;
				}
				if (patternFound) {
					if (!pattern.equals("0")) {
						// check if pattern is present throughout;
						boolean isFullMatch = true;
						while (j + pattern.length() < resultStr.length()) {
							if (resultStr.substring(j, j + pattern.length()).equals(pattern)) {
								j += pattern.length();
							} else {
								isFullMatch = false;
								break;
							}
						}
						if (isFullMatch) {
							resultStr = resultStr.substring(0, matchIndex) + "(" + pattern + ")";
						}
					}
				}
			}
		}
		int end = resultStr.length() - 1;
		if (resultStr.charAt(end) == ')' && resultStr.charAt(end - 1) - 48 == 0 && resultStr.charAt(end - 2) - 48 == 0 && resultStr.charAt(end - 3) == '(') {
			end -= 4;
			if (resultStr.charAt(end) == '.')
				end -= 1;
		} else {
			while (resultStr.charAt(end) - 48 == 0)
				end--;
		}

		return resultStr.substring(0, end + 1);
	}
}
