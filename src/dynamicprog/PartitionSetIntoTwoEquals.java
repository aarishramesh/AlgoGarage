package dynamicprog;

/**
 * https://www.geeksforgeeks.org/partition-problem-dp-18/
 * 
 * https://en.wikipedia.org/wiki/Partition_problem
 * 
 * @author polymath
 *
 */
public class PartitionSetIntoTwoEquals {
	
	public static void main(String[] args) {
		int[] arr = {1, 1, 5, 1, 1};
		System.out.println(partition(arr));
	}
	
	public static boolean partition(int[] arr) {
		if (arr != null && arr.length != 0) {
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i];
			}
			if (sum % 2 != 0) {
				return false;
			} else {
				return isPartitionExists(arr, 0, 0, sum / 2);
			}
		}
		return false;
	}
	
	public static boolean isPartitionExists(int[] arr, int index, int calSum, int desiredSum) {
		if (calSum > desiredSum || (index >= arr.length && calSum != desiredSum))
			return false;
		if (calSum == desiredSum)
			return true;
		return isPartitionExists(arr, index + 1, calSum + arr[index], desiredSum)
				|| isPartitionExists(arr, index + 1, calSum, desiredSum);
	}
}
