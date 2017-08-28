package general;

import java.util.Scanner;

public class RobotPML {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		if (input != null && !input.isEmpty()) {
			System.out.println(input);
		}
	}

	static String compute(String instructions) {
		StringBuilder sb = new StringBuilder();
		char[] chars = instructions.toCharArray();
		int[] intOut = new int[10];
		int count = 0;
		int position = 0;
		for (int i = 0; i < chars.length; i++) {

			if (chars[i] == 'P') {
				count = 1;
			} else if (chars[i] == 'M') {
				if (position < 9) {
					position++;
				}
			} else if (chars[i] == 'L') {
				intOut[position] = intOut[position] + count;
				position = 0;
				count = 0;
			}

		}

		for (int i = 0; i < intOut.length; i++) {
			sb.append(getChar(intOut[i]));
		}
		int i = 0;
		return sb.toString();

	}

	private static char getChar(int i) {
		switch (i) {
		case 0:
			return '0';
		case 1:
			return '1';
		case 2:
			return '2';
		case 3:
			return '3';
		case 4:
			return '4';
		case 5:
			return '5';
		case 6:
			return '6';
		case 7:
			return '7';
		case 8:
			return '8';
		case 9:
			return '9';
		case 10:
			return 'A';
		case 11:
			return 'B';
		case 12:
			return 'C';
		case 13:
			return 'D';
		case 14:
			return 'E';
		default:
			if (i > 14) {
				return 'E';
			}
		}
		return '-';
	}

}