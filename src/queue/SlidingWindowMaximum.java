package queue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1); list.add(3); list.add(-1); list.add(-3); list.add(5); list.add(3); list.add(6); list.add(7);
		System.out.println(slidingMax(list, 3));
	}
	
	public static ArrayList<Integer> slidingMax(final List<Integer> A, int B) {
		if (A == null || A.isEmpty())
			return null;
		ArrayList<Integer> result = new ArrayList<Integer>();
		Deque<Integer> deque = new LinkedList<Integer>();
		int i = 0;
		for (; i < B; i++) {
			while (!deque.isEmpty() && A.get(deque.peekLast()) <= A.get(i))
				deque.removeLast();
			deque.addLast(i);
		}
		for (; i < A.size(); i++) {
			result.add(A.get(deque.peek()));
			while (!deque.isEmpty() && deque.peek() <= i - B)
				deque.removeFirst();
			while (!deque.isEmpty() && A.get(deque.peekLast()) <= A.get(i))
				deque.removeLast();
			deque.addLast(i);
		}
		result.add(A.get(deque.peek()));
		return result;
	}
}
