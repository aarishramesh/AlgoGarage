package arraysstrings;

public class MultiplyTwoLargeNumbers {
	
	public static void main(String[] args) {
		System.out.println(multiply("99999", "99999"));
	}
	
	public static String multiply(String A, String B) {
		String resultStr = null;
		if (A.equals("0") || B.equals("0")) {
			return "0";
		}
		if (A != null && !A.isEmpty() && B != null && !B.isEmpty()) {
			int n1 = A.length(), n2 = B.length();
			int[] result = new int[n1 + n2];
			for (int i = B.length() - 1; i >= 0; i--) {
				int digitB = B.charAt(i) - '0', carry = 0;
				if (digitB != 0) {
					int j = 0;
					for (j = A.length() - 1; j >= 0; j--) {
						int digitA = A.charAt(j) - '0';
						int product = digitA * digitB;
						int sum = result[A.length() - 1 - i + B.length() - 1 - j] 
								+ product + carry;
						result[A.length() - 1 - i + B.length() - 1 - j] = sum % 10;
						carry = sum/10;
					}
					result[A.length() - 1 - i + B.length() - 1 - j] = carry;
				}

			}
			StringBuilder builder = new StringBuilder();
			boolean firstNumberFound = false;
			for (int i = result.length - 1; i >= 0; i--) {
				if (!firstNumberFound && result[i] == 0) {
					continue;
				}
				builder.append(result[i]);
				firstNumberFound = true;
			}
			resultStr = builder.toString();
		}
		return resultStr;
	}
}
