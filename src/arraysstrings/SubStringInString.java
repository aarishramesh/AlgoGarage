package arraysstrings;

public class SubStringInString {
	 public static int strStr(final String A, final String B) {
		 if (A.isEmpty() || B.isEmpty())
			 return -1;
		 return A.indexOf(B);
	 }
}
