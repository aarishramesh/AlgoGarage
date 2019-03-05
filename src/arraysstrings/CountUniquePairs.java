package arraysstrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array find the unique pairs of numbers which sum and diff to a particular value
 * 
 * https://www.geeksforgeeks.org/count-pairs-with-given-sum/
 * 
 * https://www.geeksforgeeks.org/count-pairs-difference-equal-k/
 * 
 * @author polymath
 *
 */
public class CountUniquePairs {
	public static void main(String[] args) {
		int[] arr = {3, 4, 2, 6};
		System.out.println(countDiffPairsUsingHashing(arr, 1));
		System.out.println(countDiffPairsUsingSorting(arr, 1));
		System.out.println(countDiffPairsUsingHashing2(arr, 1));
	}

	private static int countDiffPairsUsingHashing(int[] arr, int diff) {
		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++)
			freqMap.merge(arr[i], 1, Integer:: sum);
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (freqMap.get(diff + arr[i]) != null && freqMap.get(diff + arr[i]) != 0) {
				count++;
				freqMap.put(diff + arr[i], freqMap.get(diff + arr[i]) - 1);
				freqMap.put(arr[i], freqMap.get(arr[i] - 1));
			}
			if (arr[i] - diff > 0 && freqMap.get(arr[i] - diff) != null && freqMap.get(arr[i] - diff) != 0) {
				count++;
				freqMap.put(arr[i] - diff, freqMap.get(arr[i] - diff) - 1);
				freqMap.put(arr[i], freqMap.get(arr[i] - 1));
			}
		}
		return count;
	}

	public static boolean countDiffPairsUsingHashing2(int[] nums, int target) {

		if (nums != null && nums.length > 0) {
			HashMap<Integer, Integer> numVsFreq = new HashMap<Integer, Integer>();
			for (int i = 0; i < nums.length; i++) {
				numVsFreq.put(nums[i], numVsFreq.getOrDefault(nums[i], 0) + 1);   
			}

			for (int i = 0; i < nums.length; i++) {
				int diff = target - nums[i];
				numVsFreq.put(nums[i], numVsFreq.get(nums[i]) - 1);

				if (numVsFreq.get(diff) != null && numVsFreq.get(diff) > 0) {
					return true;
				}
				numVsFreq.put(nums[i], numVsFreq.get(nums[i] + 1));
			}
		}
		return false;
	}
	
	private static int countDiffPairsUsingSorting(int[] arr, int diff) {
		Arrays.sort(arr);
		int l = 0, r = 1, count = 0;
		while (r < arr.length) {
			if (arr[r] - arr[l] == diff) {
				l++; r++;
				count++;
			} else if (arr[r] - arr[l] < diff) {
				r++;
			} else {
				l++;
			}
		}
		return count;
	}
}
