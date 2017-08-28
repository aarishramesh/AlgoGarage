package general;

public class LookAndSay {
	public static void main(String[] args) {
		System.out.println(LookAndSay("11", 2));
	}
	
	private static String LookAndSay(String start, int n) {
		for (int i=0; i < n; i++) {
			String result = LookAndSay(start);
			start = result;
		}
		return start;
	}
	
	private static String LookAndSay(String num) {
		int[] numArr = new int[num.length()];
		for (int i = 0; i < num.length(); i++) {
			numArr[i] = Character.getNumericValue(num.charAt(i));
		}
		
		int prevNum = numArr[0];
		StringBuilder result = new StringBuilder();
		int count = 1;
		for (int i = 1; i < numArr.length; i++) {
			int currNum = numArr[i];
			if (prevNum == currNum) {
				count++;
			} else {
				result.append(count);
				result.append(prevNum);
				count = 1;
			}
			prevNum = currNum;
		}
		result.append(count);
		result.append(prevNum);
		int resultNum = Integer.parseInt(result.toString());
		return resultNum + "";
	}
}
