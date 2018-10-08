package dynamicprog;

import java.util.HashSet;

/**
 * Given a string and a dictionary, split this string into multiple words such that
 * each word belongs in dictionary.
 * 
 * e.g peanutbutter -> pea nut butter
 * e.g Iliketoplay -> I like to play
 * 
 * Solution 
 * DP solution to this problem
 * if( input[i...j] belongs in dictionary) T[i][j] = i
 * else{
 *     T[i][j] = k if T[i][k-1] != -1 && T[k][j] != -1
 *     
 * Test cases
 * 1) Empty string
 * 2) String where entire string is in dictionary
 * 3) String which cannot be split into words which are in dictionary
 * 3) String which can be split into words which are in dictionary    
 *
 */
public class WordbreakDictionary {

	public static void main(String[] args) {
		HashSet<String> dictionary = new HashSet<String>();
		dictionary.add("I");dictionary.add("a");dictionary.add("am"); dictionary.add("ace");
		//System.out.println(wordBreakDictionaryExists("Iamace", dictionary));
		//System.out.println(wordBreakDictionaryExists("hello", dictionary));
		System.out.println(breakWords("Iamace", dictionary));
	}

	public static String breakWords(String str, HashSet<String> dictionary) {
		int[][] result = new int[str.length()][str.length()];
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < str.length(); j++) {
				result[i][j] = -1;
			}
		}
		int level = 0;
		while (level < str.length()) {
			int i = 0, j = level;
			while (i < str.length() && j < str.length()) {
				if (i == j) {
					if (dictionary.contains(str.charAt(i) + ""))
						result[i][j] = i;
				} else {
					String subStr = str.substring(i, j + 1);
					if (dictionary.contains(subStr)) {
						result[i][j] = i;
					} else {
						for (int k = i; k <= j; k++) {
							int leftResult = result[i][k];
							if (leftResult != -1) {
								if (k + 1 <= j) {
									if (result[k + 1][j] != -1) {
										result[i][j] = k + 1;
									}
								}
							}
						}
					}
					i++; j++;
				}
				level++;
			}
		}
		if (result[0][str.length() - 1] == -1)
			return null;
		
		//create space separate word from string is possible
        StringBuilder buffer = new StringBuilder();
        int i = 0; int j = str.length() -1;
        while(i < j){
            int k = result[i][j];
            if(i == k){
                buffer.append(str.substring(i, j+1));
                break;
            }
            buffer.append(str.substring(i,k) + " ");
            i = k;
        }
        
        return buffer.toString();
	}


	public static boolean wordBreakDictionaryExists(String str, HashSet<String> dictionary) {
		boolean[][] result = new boolean[str.length()][str.length()];
		int level = 0;
		while (level < str.length()) {
			int i = 0, j = level;
			while (i < str.length() && j < str.length()) {
				if (i == j) {
					result[i][j] = true;
				} else {
					String subStr = str.substring(i, j + 1);
					if (dictionary.contains(subStr)) {
						result[i][j] = true;
					} else {
						for (int k = i; k <= j; k++) {
							boolean currResult = result[i][k];
							if (k + 1 <= j) {
								currResult &= result[k + 1][j];
							}
							if (currResult) {
								result[i][j] = true;
								break;
							}
						}
					}
				}
				i++; j++;
			}
			level++;
		}
		return result[0][str.length() - 1];
	}
}
