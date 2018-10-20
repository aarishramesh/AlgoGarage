package stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class NearestSmallestElement {
	public static void main(String[] args) {
		ArrayList<Integer> elements = new ArrayList<Integer>();
		//elements.add(4); elements.add(5); elements.add(2); elements.add(10); elements.add(8);
		elements.add(5); elements.add(8); elements.add(10);
		System.out.println(prevSmaller(elements).toString());
	}
	
	public static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Deque<Integer> stack = new LinkedList<Integer>();
		for (Integer ele : A) {
			while (stack.peek() != null && !(stack.peek() < ele)) {
				stack.pop();
			}
			if (stack.peek() != null)
				result.add(stack.peek());
			else
				result.add(-1);
			stack.push(ele);
		}
		return result;
    }
}
