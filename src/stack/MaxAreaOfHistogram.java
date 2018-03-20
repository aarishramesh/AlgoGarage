package stack;

import java.util.Stack;

public class MaxAreaOfHistogram {
	public static void main(String[] args) {
		int[] arr = {2,2,2,6,1,5,4,2,2,2,2};
		int maxArea = findMaxAreaHistogram(arr);
		System.out.println(maxArea);
		assert maxArea == 12;
	}
	
	private static int findMaxAreaHistogram(int[] arr) {
		Stack<Integer> stack = new Stack<Integer>();
		int topIdx, area, maxArea = 0, i = 0;
		for (i = 0; i < arr.length; i++) {
			if (stack.isEmpty() || arr[stack.peek()] <= arr[i]) {
				stack.push(i);
			} else {
				while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
					topIdx = stack.pop();
					if (stack.isEmpty()) {
						area = arr[topIdx] * i;
					} else {
						area = arr[topIdx] * (i - stack.peek() - 1);
					}
					if (area > maxArea)
						maxArea = area;
				}
				stack.push(i);
			}
		}
		
		while (!stack.isEmpty()) {
			topIdx = stack.pop();
			if (stack.isEmpty()) {
				area = arr[topIdx] * i;
			} else {
				area = arr[topIdx] * (i - stack.peek() - 1);
			}
			if (area > maxArea)
				maxArea = area;
		}
		return maxArea;
	}
}
