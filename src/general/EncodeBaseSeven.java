package general;

import java.util.Scanner;
import java.util.Stack;

public class EncodeBaseSeven {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println(convertToBase7(num));
	}

	private static String convertToBase7(int num) {
		Stack<Character> resultStack = new Stack<Character>();
		while (num > 0) {
			int rem = num % 7;
			Character charVal = getEncodedChar(rem);
			resultStack.push(charVal);
			num = num / 7;
		}
		StringBuilder result = new StringBuilder();
		while(!resultStack.isEmpty())
			result.append(resultStack.pop());
		return result.toString();
	}
	
	private static Character getEncodedChar(int num) {
		//0 a t l s i N
		switch(num) { 
			case 1:
				return 'a';
			case 2:
				return 't';
			case 3:
				return 'l';
			case 4:
				return 's';
			case 5:
				return 'i';
			case 6:
				return 'n';
			default:
				return '0';	
		}
	}
}
