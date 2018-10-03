package arraysstrings;

/**
 * Test cases 
 * 
 * Empty array, length 1, 2 
 * 
 * @author polymath
 *
 */
public class FindEquilibriumInArray {
	public static int findEquilibriumInArray(int[] arr) {
		if (arr != null) {
			if (arr.length == 1) {
				return arr[0];
			} else {
				int left = arr[0];
				int right = arr[arr.length - 1];
				int leftIndex = 1;
				int rightIndex = arr.length - 2;
				while ((rightIndex - leftIndex) >= 0) {
					if (left == right) {
						if (leftIndex == rightIndex) {
							return leftIndex;
						} else {
							left += arr[leftIndex++];
							right += arr[rightIndex++];
						}
					} else if (left > right) {
						right += arr[rightIndex--];
					} else {
						left += arr[leftIndex++];
					}
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {5, 4, 4, 1, 5, 4, 4};
		System.out.println(findEquilibriumInArray(arr));
	}
}
