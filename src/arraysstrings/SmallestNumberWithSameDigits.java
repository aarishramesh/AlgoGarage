package arraysstrings;

public class SmallestNumberWithSameDigits {
	public static void main(String[] args) {
		System.out.println(solution(28378274));
	}
	
	public static int solution(int N) {
		int length = (int) (Math.log10(N) + 1);
		if (length == 1)
			return 0;
		return (int)Math.pow(10, length - 1);
	}
}
