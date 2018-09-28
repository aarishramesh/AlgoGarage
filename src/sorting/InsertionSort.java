package sorting;

public class InsertionSort {
	
	static int[] arr =  {5, 10, 15, 3, 2, 1};
	
	public static void main(String[] args) {
		insertionSort();
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
	
	static void insertionSort() {
		for (int i = 1; i < arr.length; i++) {
			int j = i - 1, k = i;
			while (j >= 0 && arr[k] < arr[j]) {
				int temp = arr[k];
				arr[k] = arr[j];
				arr[j] = temp;
				k--; j--;
			}
		}
	}
}
