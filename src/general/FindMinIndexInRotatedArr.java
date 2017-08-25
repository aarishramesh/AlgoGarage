package general;

/**
 * Find min element in rotated sorted array using Binary Search 
 * Run time complexity is O(logN)
 * Space time complexity is O(1)
 * 
 * @author aarishramesh
 *
 */
public class FindMinIndexInRotatedArr {
	public static void main(String[] args) {
		int[] arr = {4, 5, 6, -1, 0};
		int minIndex = findMinInRotatedSortedArr(arr, 0, arr.length - 1);
		System.out.println("Min element is : " + arr[minIndex]);
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
}
