package arraysstrings;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class GreaterElementsEqualToArrayNum {
	public static int solve(ArrayList<Integer> A) {
		if (A != null && !A.isEmpty()) {
			PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
			for (Integer val : A)
				minHeap.add(val);
			while (!minHeap.isEmpty()) {
				int element = minHeap.remove();
				while (!minHeap.isEmpty() && minHeap.peek() == element)
					minHeap.remove();
				if (minHeap.size() == element)
					return 1;
			}
		}
		return -1;
    }
	
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1); arr.add(2); arr.add(3); arr.add(3); arr.add(4); arr.add(6); arr.add(5); arr.add(6);
		
		System.out.println(solve(arr));
	}
}
