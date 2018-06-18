package arraysstrings;

import java.util.Arrays;

public class ThreeNumbersClosestSum {

	public int threeSumClosest(int[] arr, int target) {
		Arrays.sort(arr);
		int bestSum = 10000000;
		for (int i = 0; i < arr.length - 2; i++) {
			int left = i + 1, right = arr.length - 1;
			int sum = 0;
			while (left < right) {
				sum = arr[i] + arr[left] + arr[right];
				if (sum == target)
					return sum;
				if (sum < target) {
					left++;
				} else {
					right--;
				}
				if (Math.abs(target - sum) < Math.abs(target - bestSum))
					bestSum = sum;
			}
		}
		return bestSum;
	}
}