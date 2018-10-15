package dynamicprog;

import java.util.Scanner;

/**
 * 
 * Solution video tutorial - https://www.youtube.com/watch?v=_nLeiMMSd4E&feature=youtu.be
 * @author polymath
 *
 */
public class ConstructArrayNonConsectuive {
	public static long constArrayNoOfWays(int n, int k, int x) {
		long[] endingInX = new long[n];
		long[] notEndingInX = new long[n];
		endingInX[0] = 0; notEndingInX[0] = 1;
		for (int i = 1; i < n; ++i) {
			endingInX[i] = notEndingInX[i - 1];
			notEndingInX[i] = endingInX[i - 1] * (k - 1) + notEndingInX[i - 1] * (k - 2);
		}
		return endingInX[n - 1];
	}

	public static void main(String[] args) {
		String line  = "The best lies are always mixed with a little truth ";
		System.out.println(line.length());
		String[] words = line.split(" ");
		int index = 0, count = 1, i = 0;
		while (i < line.length() - 1) {
			if (index % 29 == 0) {
				if (line.indexOf(index) != ' ') {
					while (index == ' ') {
						index--;
					}
					count++;
				} else 
					index++;
			}
		}
		
		while (i < words.length) {
			if (index + words[i].length() + 1 >= 30) {
				
				count++;
				index = 0;
			} else {
				index += words[i].length() + 1;
				i++;
			}
		}
		System.out.println(count);
	}

	/**
	public static void main(String[] args) {
		//System.out.println(constArrayNoOfWays(942, 77, 13));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int k = sc.nextInt();
		int count = 0;
		for (int i = 0; i <= k; i++) {
			count += countSubarrays(arr, n, i);
		}
		System.out.println(count);
	}**/

	public static int countSubarrays(int a[], 
			int n, int m) 
	{ 
		int count = 0; 
		int prefix[] = new int[n]; 
		int odd = 0; 

		for (int i = 0; i < n; i++) 
		{ 
			prefix[odd]++; 

			if ((a[i] & 1) == 1) 
				odd++; 

			if (odd >= m) 
				count += prefix[odd - m]; 
		} 

		return count; 
	} 

}