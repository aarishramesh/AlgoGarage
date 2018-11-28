package dynamicprog;

/**
 * https://www.geeksforgeeks.org/number-subsequences-form-ai-bj-ck/
 * 
 * @author polymath
 *
 */
public class NumberOfSubSequencesOfForm {
	
	public static void main(String[] args) {
		System.out.println(countSubSeq("abbc"));
	}
	
	public static int countSubSeq(String s) {
		if (s == null || s.isEmpty())
			return 0;
		int aCount = 0, bCount = 0, cCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a') {
				aCount = 1 + (2 * aCount);
			} else if (s.charAt(i) == 'b') {
				bCount = aCount + (2 * bCount);
			} else if (s.charAt(i) == 'c') {
				cCount = bCount + (2 * cCount);
			}
		}
		return cCount;
	}
}
