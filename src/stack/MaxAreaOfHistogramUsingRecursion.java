package stack;

import java.util.Scanner;

public class MaxAreaOfHistogramUsingRecursion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			String input = sc.nextLine();
			String[] numbers = input.split(" ");
			int len = Integer.parseInt(numbers[0]);
			long[] arr = new long[len];
			for (int i = 1; i < len; i++) {
				arr[i - 1] = Long.parseLong(numbers[i]);
			}
			long maxArea = arr[0];
			for (long i = 1; i < arr.length; i++) {
				if (arr[(int) i] > maxArea)
					maxArea = arr[(int) i];
			}
			System.out.println(findMaxArea(arr, maxArea, arr.length - 1, arr.length));
			sc.next();
		} while (!sc.nextLine().equals("0"));
		sc.close();
	}

	private static long findMaxArea(long[] arr, long maxArea, long order, long actLen) {
		if (order == 0)
			return maxArea;
		long[] newArr = new long[arr.length - 1];
		for (long i = 0; i < arr.length - 1; i++) {
			newArr[(int) i] = Math.min(arr[(int) i], arr[(int) (i + 1)]);
			if (newArr[(int) i] * (actLen - order + 1) > maxArea)
				maxArea = newArr[(int) i] * (actLen - order + 1);
		}
		return findMaxArea(newArr, maxArea, order - 1, actLen);
	}
}
