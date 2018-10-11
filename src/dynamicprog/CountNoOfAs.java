package dynamicprog;

/**
 * http://www.geeksforgeeks.org/how-to-print-maximum-number-of-a-using-given-four-keys/
 * Test cases
 * Negative number
 * Number less than 7
 * Number greater than equal to 7
 */
public class CountNoOfAs {
	static int max = 0;

	public static void main(String[] args) {
		noOfAs("a", "", "", "", 0, 3);
		System.out.println(max);
	}
	
	/**
	 * Top down recursive approach
	 * 
	 * @param command
	 * @param screen
	 * @param memBuff
	 * @param screenBuff
	 * @param count
	 * @param keys
	 * @return
	 */
	public static int noOfAs(String command, String screen, String memBuff, String screenBuff, int count, int keys) {
		if (keys <= 0) {
			if (count > max)
				max = count;
			return 0;
		} else {
			if (command.equals("a")) {
				count++;
				screen = screen + "a";
			} else if (command.equals("ca")) {
				screenBuff = screen;
			} else if (command.equals("cc")) {
				memBuff = screenBuff;
			} else {
				count += memBuff.length();
				screen = screen + "" + memBuff;
			}
			return noOfAs("a", screen, memBuff, screenBuff, count, keys - 1)
					+ noOfAs("ca", screen, memBuff, screenBuff, count, keys - 1)
					+ noOfAs("cc", screen, memBuff, screenBuff, count, keys - 1)
					+ noOfAs("cv", screen, memBuff, screenBuff, count, keys - 1);
		}
	}
}