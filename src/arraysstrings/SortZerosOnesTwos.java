package arraysstrings;

/**
 * https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 * 
 * Low marks the start of 1
 * 
 * 0 to low -1 -> 0
 * low to high -1 -> 1
 * mid to high - 1 -> unknowns
 * high to arr.length - 1 -> 2
 * 
 * Iterate until there are no unknowns i.e mid same as high
 * 
 * @author polymath
 *
 */
public class SortZerosOnesTwos {
	public static void main(String[] args) {
		int[] arr = {1, 0, 2, 0, 1, 2, 0, 0};
		int low = 0, mid = low, high = arr.length - 1;
		while (mid <= high) {
			switch (arr[mid]) {
				case 0:
					swap(arr, low++, mid++);
					break;
				case 1:
					mid++;
					break;
				case 2:
					swap(arr, mid, high--);
			}
		}
		
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}