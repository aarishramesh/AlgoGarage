package dynamicprog;


/**
 * Given a string find longest palindromic subsequence in this string.
 *
 * Time complexity - O(n2)
 * Space complexity - O(n2
 *
 * Youtube link - https://youtu.be/_nCsPn7_OgI
 *
 * References
 * http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
 */
public class LongestPalindromicSequence {
	
	public static void main(String[] args) {
		System.out.println("\n"+ lps("aaaabaaa".toCharArray()));
	}
	
	public static int lps(char[] arr) {
		int[][] result = new int[arr.length][arr.length];
		int l = 0;
		while (l < arr.length) {
			int i = 0, j = l;
			while (i < arr.length && j < arr.length) {
				if (i == j) {
					result[i][j] = 1;
				} else {
					if (arr[i] == arr[j]) {
						result[i][j] = result[i + 1][j - 1] + 2;
					} else {
						result[i][j] = Math.max(result[i + 1][j], result[i][j - 1]);
					}
				}
				i++; j++;
			}
			l++;
		}
		printPalindromicSequence(arr, result);
		return result[0][arr.length - 1];
	}
	
	public int calculateRecursive(char str[],int start,int len){
        if(len == 1){
            return 1;
        }
        if(len ==0){
            return 0;
        }
        if(str[start] == str[start+len-1]){
            return 2 + calculateRecursive(str,start+1,len-2);
        }else{
            return Math.max(calculateRecursive(str, start+1, len-1), calculateRecursive(str, start, len-1));
        }
    }
    
	static void printPalindromicSequence(char[] arr, int[][] result) {
		int i = 0, j = result.length - 1;
		while (i <= j) {
			if (i == j) {
				System.out.print(arr[i]);
				i++; j--;
			} else if (result[i][j] == result[i + 1][j]) {
				i++;
			} else if (result[i][j] == result[i][j - 1]) {
				j--;
			} else if (result[i][j] == result[i + 1][j - 1] + 2) {
				System.out.print(arr[i] + " " + arr[j]);
				i++; j--;
			}
		}
	}
}
