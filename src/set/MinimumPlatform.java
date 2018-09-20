package set;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
 * 
 * @author polymath
 *
 */
public class MinimumPlatform
{
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int i = 0; i < testCase; i++) {
			int timesCount = sc.nextInt();
			sc.nextLine();
			int[] arrival = new int[timesCount];
			for (int j = 0; j < timesCount; j++) {
				arrival[j] = sc.nextInt();
			}
			sc.nextLine();
			int[] departure = new int[timesCount];
			for (int j = 0; j < timesCount; j++) {
				departure[j] = sc.nextInt();
			}
			
			System.out.println(findPlatform(arrival, departure, timesCount));
		}
		sc.close();
	}

	// Returns minimum number of platforms reqquired
	static int findPlatform(int arr[], int dep[], int n)
	{
		// Sort arrival and departure arrays
		Arrays.sort(arr);
		Arrays.sort(dep);

		// plat_needed indicates number of platforms
		// needed at a time
		int plat_needed = 0, result = 1;
		int i = 1, j = 0;

		// Similar to merge in merge sort to process 
		// all events in sorted order
		while (i < n && j < n)
		{
			// If next event in sorted order is arrival, 
			// increment count of platforms needed
			if (arr[i] <= dep[j])
			{
				plat_needed++;
				i++;

				// Update result if needed 
				if (plat_needed > result) 
					result = plat_needed;
			}

			// Else decrement count of platforms needed
			else
			{
				plat_needed--;
				j++;
			}
		}

		return result;
	}
}