package arraysstrings;

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
		int[] arr = {1, 5, 5};
		System.out.println(countSumPairs(arr, 6));
		System.out.println(countDiffPairs(arr, 4));
	}
	
	private static int countSumPairs(int[] arr, int sum) {
		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			freqMap.merge(arr[i], 1, Integer::sum);
		}
		int twiceCount = 0;
		for (int i = 0; i < arr.length; i++) {
			if (freqMap.get(sum - arr[i]) != null)
				twiceCount += freqMap.get(sum - arr[i]);
			if (sum - arr[i] == arr[i])
				twiceCount--;
		}
		return twiceCount / 2;
	}
	
	private static int countDiffPairs(int[] arr, int diff) {
		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++)
			freqMap.merge(arr[i], 1, Integer:: sum);
		int twiceCount = 0;
		for (int i = 0; i < arr.length; i++) {
			if (freqMap.get(diff + arr[i]) != null)
				twiceCount += freqMap.get(diff + arr[i]);
			if (diff + arr[i] == arr[i])
				twiceCount--;
		}
		return twiceCount / 2;
	}

}
