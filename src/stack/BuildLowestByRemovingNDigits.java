package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://www.geeksforgeeks.org/build-lowest-number-by-removing-n-digits-from-a-given-number/
 * 
 * @author polymath
 *
 */
public class BuildLowestByRemovingNDigits {
    
	public static void main(String[] args) {
		System.out.println(lowestNumberByRemovingNDigits("012", 2));
	}
	
	public static String lowestNumberByRemovingNDigits(String num, int n) {
		if (num != null && !num.isEmpty() && n < num.length()) {
			Deque<Integer> deque = new LinkedList<Integer>();
			int i = 0;
			for (;i <= n; i++) {
				insertIntoDeque(num, deque, i);
			}
			StringBuilder result = new StringBuilder();
			while (i < num.length()) {
				result.append(deque.pop());
				insertIntoDeque(num, deque, i);
				i++;
			}
			result.append(deque.pop());
			return result.toString();
		}
		return "";
	}
	
	private static void insertIntoDeque(String num, Deque<Integer> deque, int i) {
		while (!deque.isEmpty() && deque.getLast() > (num.charAt(i) - '0')) {
			deque.removeLast();
		}
		deque.addLast(num.charAt(i) - '0');
	}
}