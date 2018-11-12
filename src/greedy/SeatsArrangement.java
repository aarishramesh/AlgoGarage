package greedy;

/**
 * https://www.interviewbit.com/problems/seats/
 * 
 * @author polymath
 *
 */
public class SeatsArrangement {

	public static void main(String[] args) {
		System.out.println(seats("....x..xx...x"));
	}
	
    private static final long MOD = 10000003;

	private static final char OCCUPIED = 'x';

	public static int seats(String a) {
		int numLeft = 0;
		int numRight = 0;
		for (int i = 0; i < a.length(); ++i) {
			if (a.charAt(i) == OCCUPIED) {
				++numRight;
			}
		}

		long moves = 0;
		for (int i = 0; i < a.length(); ++i) {
			if (numRight == 0) {
				break;
			} else if (a.charAt(i) == OCCUPIED) {
				++numLeft;
				--numRight;
			} else {
				moves += Math.min(numLeft, numRight);
			}
		}
		return (int) (moves % MOD);
	}
}
