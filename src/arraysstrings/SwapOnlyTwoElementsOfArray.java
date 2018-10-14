package arraysstrings;

public class SwapOnlyTwoElementsOfArray {

	public static void main(String[] args) {
		int[] arr = {1,1,0,0,0,1,0,1};
		arr = swapTwoElements(arr);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + "");
	}
	
	public static int[] swapTwoElements(int[] arr) {
		int j = arr.length - 1;
		for (int i = 0; i < j; i++) {
			if (arr[i] == 0) {
				while (arr[j] == 1 && i < j) {
					swap(i, j, arr);
					break;
				}
			}
		}
		return arr;
	}

	private static void swap(int firstIndex, int secondIndex, int[] arr) {
		int temp = arr[firstIndex];
		arr[firstIndex] = arr[secondIndex];
		arr[secondIndex] = temp;
	}
}
