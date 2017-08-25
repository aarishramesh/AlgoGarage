package general;

import java.util.Scanner;

public class EquilibriumIndex {
	
	static boolean solve(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		int leftSum = 0;
		int rightSum = sum;
		for (int i = 0; i<a.length; i++) {
			rightSum = rightSum - a[i];
			if (leftSum == rightSum) {
				return true;
			}
			leftSum += a[i];
		}
		return false;
	}

	static int findMinInRotatedSortedArr(int[] arr, int start, int end) {
		int mid = (start + end) / 2;
		if (arr[mid] >= arr[start] && arr[mid] <= arr[end]) {
			return mid;
		} else if (arr[mid] >= arr[start] && arr[mid] >= arr[end]) {
			return findMinInRotatedSortedArr(arr, mid + 1, end);
		} else if (arr[mid] <= arr[start] && arr[mid] <= arr[end]) {
			return findMinInRotatedSortedArr(arr, start, mid -1);
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner in = null;
		try {
			in = new Scanner(System.in);
			int T = in.nextInt();
			in.nextLine();
			boolean[] resultArr = new boolean[T];
			for(int a0 = 0; a0 < T; a0++){
				int n = in.nextInt();
				in.nextLine();
				int[] a = new int[n];
				String arrStr = in.nextLine();
				String[] integerStr = new String[n];
				integerStr = arrStr.split(" ");
				for(int a_i=0; a_i < n; a_i++){
					a[a_i] = Integer.parseInt(integerStr[a_i]);
				}
				boolean result = solve(a);
				resultArr[a0] = result;
			}
			for (int i = 0; i< T; i++) {
				if (resultArr[i] == true) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		} finally {
			if (in != null) 
				in.close();
		}
	}
}
