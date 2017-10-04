package arraysstrings;

import java.util.Arrays;
import java.util.Scanner;

public class FindElementInAnInfiniteSortedArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++)
			arr[i] = sc.nextInt();
		
		int element = sc.nextInt();
		
		// To ensure that 
		Arrays.sort(arr);
		
		int low = 0, high = 1;
		boolean isElementPresent = false;
		while (arr[high] <= element) {
			if (arr[high] == element) {
				System.out.println("Element Present");
				break;
			} else {
				low = high;
				high = high * 2;
			}
		}
		if (!isElementPresent)
			binarySearch(low, high, arr, element);
		
		sc.close();
	}
	
	private static void binarySearch(int low, int high, int[] arr, int element) {
		int mid = (low + high) / 2 ;
		while (mid >= 0 && mid < arr.length) {
			if (arr[mid] == element) {
				System.out.println("Element present");
				break;
			} else if (element < arr[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
			mid = (low + high) / 2;
		}
 	}
}