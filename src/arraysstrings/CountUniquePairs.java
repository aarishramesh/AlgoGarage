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
		int[] arr = {1, 2, 2, 3, 4, 5};
		System.out.println(countDiffPairsUsingHashing(arr, 1));
		System.out.println(countDiffPairsUsingSorting(arr, 1));
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

	private static int countDiffPairsUsingSorting(int[] arr, int diff) {
		Arrays.sort(arr);
		int l = 0, r = 0, count = 0;
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
