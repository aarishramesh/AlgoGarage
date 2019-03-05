package arraysstrings;

public class RemoveElementWaysNonDecSortedArray {

	public static void main(String[] args) {
		int[] arr = {};
		System.out.println(noOfWays(arr));
	}

	public static int noOfWays(int[] arr) {
		int count = 0;
		if (arr != null && arr.length != 0) {
			if (arr.length == 1)
				return 1;
			boolean[] startHere = new boolean[arr.length];
			boolean[] endHere = new boolean[arr.length];
			endHere[0] = true;
			startHere[arr.length - 1] = true;
			int j = arr.length - 2;
			for (int i = 1; i < arr.length; i++) {
				endHere[i] = endHere[i - 1] & (arr[i - 1] <= arr[i]);
				startHere[j] = startHere[j + 1] & (arr[j] <= arr[j + 1]);
				j--;
			}
			for (int i = 0; i < arr.length; i++) {
				boolean leftSorted = true;
				boolean rightSorted = true;
				if (i - 1 >= 0) {
					leftSorted = endHere[i - 1];
				}
				if (i + 1 < arr.length) {
					rightSorted = startHere[i + 1];
				}
				if (leftSorted && rightSorted) {
					if (i - 1 >= 0 && i + 1 < arr.length) {
						if (arr[i - 1] <= arr[i + 1])
							count++;
					} else
						count++;
				}
			}
		}
		return count;
	}
}
