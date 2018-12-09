package sorting;

/**
 * https://www.geeksforgeeks.org/counting-inversions/
 * 
 * @author polymath
 *
 */
public class CountInversions {
	static int inversions = 0;

	public static void mergeSort(int[] arr, int left, int right) {
		if (left >= right)
			return;
		int mid = (left + right) / 2;
		mergeSort(arr, left, mid);
		mergeSort(arr, mid + 1, right);
		merge(arr, left, right);
	}

	public static void merge(int[] arr, int left, int right) {
		int[] temp = new int[right - left + 1];
		int i = left, mid = (left + right) / 2, j = mid + 1, r = 0;
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[r++] = arr[i++];
			} else {
				inversions += mid - i + 1;
				temp[r++] = arr[j++];
			}
		}
		while (i <= mid) {
			temp[r++] = arr[i++];
		}
		while (j <= right) {
			temp[r++] = arr[j++];
		}
		i = left;
		for (int k = 0; k < temp.length;) {
			arr[i++] = temp[k++];
		}
	}


	public static void main(String[] args) {
		int[] arr = {1, 20, 6, 4, 5};
		//int[] arr = {5, 10, 1, 6, 3, 2, 7};
		//int[] arr = {2, 4, 1, 3, 5};
		mergeSort(arr, 0, 4);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println("\n" + inversions);
	}
}
