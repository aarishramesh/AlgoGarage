package sorting;

/**
 * http://en.wikipedia.org/wiki/Merge_sort
 * Test cases
 * 1 element
 * 2 element
 * negative numbers
 * already sorted
 * reverse sorted
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] arr = {5, 10, 1, 6, 3, 2, 7};
		mergeSort(arr, 0, 6);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
	
	static void mergeSort(int[] arr, int low, int high) {
		if (low >= high)
			return;
		int mid = (low + high) / 2;
		mergeSort(arr, low, mid);
		mergeSort(arr, mid + 1, high);
		merge(arr, low, high);
	}
	
	static void merge(int[] arr, int low, int high) {
		int[] temp = new int[high - low + 1];
		int mid = (low + high) / 2;
		int i = low, j = mid + 1, r = 0;
		while (i <= mid && j <= high) {
			if (arr[i] <= arr[j]) {
				temp[r++] = arr[i++];
			} else {
				temp[r++] = arr[j++];
			}
		}
		
		while (i <= mid) {
			temp[r++] = arr[i++];
		}
		
		while (j <= high) {
			temp[r++] = arr[j++];
		}
		
		i = low;
		for (int k = 0; k < temp.length;)
			arr[i++] = temp[k++];
	}
}