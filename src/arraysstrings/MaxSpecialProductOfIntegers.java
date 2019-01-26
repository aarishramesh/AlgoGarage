package arraysstrings;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://www.interviewbit.com/problems/maxspprod/
 * 
 * @author polymath
 *
 */
public class MaxSpecialProductOfIntegers {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(6); arr.add(7); arr.add(9); arr.add(5); arr.add(5); arr.add(8);
		System.out.println(maxSpecialProduct(arr));
	}

	public static int maxSpecialProduct(ArrayList<Integer> A) {
		if (A != null && !A.isEmpty()) {
			if (A.size() == 1) {
				return 0;
			}
			int[] nearestLeftMax = new int[A.size()];
			nearestLeftMax[0] = 0;
			int[] nearestRightMax = new int[A.size()];
			nearestRightMax[A.size() - 1] = 0;
			int j = A.size() - 2;
			Deque<Integer> leftMaxDeque = new LinkedList<Integer>();
			leftMaxDeque.addLast(0);
			Deque<Integer> rightMaxDeque = new LinkedList<Integer>();
			rightMaxDeque.addLast(A.size() - 1);
			for (int i = 1; i < A.size(); i++) {
				while (!leftMaxDeque.isEmpty()) {
					if (A.get(leftMaxDeque.getLast()) > A.get(i))
						break;
					leftMaxDeque.removeLast();
				}
				if (!leftMaxDeque.isEmpty()) {
					nearestLeftMax[i] = leftMaxDeque.getLast();
				} else
					nearestLeftMax[i] = 0;
				leftMaxDeque.addLast(i);

				while (!rightMaxDeque.isEmpty()) {
					if (A.get(rightMaxDeque.getLast()) > A.get(j)) {
						break;
					}
					rightMaxDeque.removeLast();
				}
				if (!rightMaxDeque.isEmpty())
					nearestRightMax[j] = rightMaxDeque.getLast();
				else
					nearestRightMax[j] = 0;
				rightMaxDeque.addLast(j);
				j--;
			}

			long mx = -1;
			for(int i = 0; i < A.size(); i++){
				mx = Long.max(mx, 1L * nearestLeftMax[i] * nearestRightMax[i]);
			}
			return (int)(mx % 1000000007);
		}
		return 0;
	}
}
