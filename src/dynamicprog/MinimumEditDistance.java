package dynamicprog;

/**
 * Given two strings how many minimum edits(update, delete or add) is needed to convert one string to another
 *
 * Time complexity is O(m*n)
 * Space complexity is O(m*n)
 *
 * References:
 * http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 * https://en.wikipedia.org/wiki/Edit_distance
 */
public class MinimumEditDistance {

	public static void main(String[] args) {
		String str1 = "azced";
        String str2 = "abcdef";
        System.out.println(minEditDistance(str1.toCharArray(), str2.toCharArray()));
        printEdits(distArr, str1, str2);
	}
	
	private static int[][] distArr;
	
	public static int minEditDistance(char[] str1, char[] str2) {
		if (str1 != null && str2 != null) {
			if (str1.length == 0)
				return str2.length;
			if (str2.length == 0)
				return str1.length;
			distArr = new int[str1.length + 1][str2.length + 1];

			for (int i = 0; i < str1.length + 1; i++) {
				for (int j = 0; j < str2.length + 1; j++) {
					if (i == 0) {
						distArr[i][j] = j;
						continue;
					}
					if (j == 0) {
						distArr[i][j] = i;
						continue;
					}
					if (str1[i - 1] == str2[j - 1]) {
						distArr[i][j] = distArr[i - 1][j - 1];
					} else {
						distArr[i][j] = 1 + Math.min(distArr[i - 1][j - 1], Math.min(distArr[i - 1][j]
								, distArr[i][j - 1]));
					}
				}
			}
			return distArr[str1.length][str2.length];
		}
		return 0;
	}

	public static void printEdits(int[][] distArr, String string1, String string2) {
		char[] str1 = string1.toCharArray();
		char[] str2 = string2.toCharArray();
		int i = str1.length, j = str2.length;
		while(i > 0 && j > 0) {
			if (distArr[i][j] == distArr[i - 1][j - 1] + 1) {
				System.out.println("Edit " + str1[i - 1] + " with " + str2[j - 1] + " in " + string1);
			} else if (distArr[i][j] == distArr[i - 1][j] + 1) {
				System.out.println("Delete " + str1[i - 1] + " from " + string1);
				i--;
				continue;
			} else if (distArr[i][j] == distArr[i][j - 1] + 1) {
				System.out.println("Delete " + str2[j - 1] + " from " + string2);
				j--;
				continue;
			}
			i--; j--;
		}
	}
}
