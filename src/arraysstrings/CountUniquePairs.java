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
		int[] arr = {1, 5, 7, -1, 5};
		System.out.println(countSumPairs(arr, 6));
		System.out.println(countDiffPairs(arr, 4));
		System.out.println(countDiffPaisWithSorting(arr, 5, 4));
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
	
	/* Returns count of pairs with
	difference k in arr[] of size n. */
	static int countDiffPaisWithSorting(int arr[], int n,
	                                          int k)
	{
	    int count = 0;
	    Arrays.sort(arr); // Sort array elements
	 
	    int l = 0;
	    int r = 0;
	    while(r < n)
	    {
	        if(arr[r] - arr[l] == k)
	        {
	            count++;
	            l++;
	            r++;
	        }
	        else if(arr[r] - arr[l] > k)
	            l++;
	        else // arr[r] - arr[l] < sum
	            r++;
	    } 
	    return count;
	}

}
