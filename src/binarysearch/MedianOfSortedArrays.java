package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class MedianOfSortedArrays {

	public static void main(String[] args) {	
		List<Integer> a = new ArrayList<Integer>();
		a.add(-50); a.add(-41); a.add(-40); a.add(-19); a.add(5); a.add(21); a.add(28);
		List<Integer> b = new ArrayList<Integer>();
		b.add(-50); b.add(-21); b.add(-10);
		System.out.println(findMedianSortedArrays(a, b));
	}

	public static double findMedianSortedArrays(List<Integer> input1, List<Integer> input2) {
		//if input1 length is greater than switch them so that input1 is smaller than input2.
		if (input1.size() > input2.size()) {
			return findMedianSortedArrays(input2, input1);
		}
		int x = input1.size();
		int y = input2.size();

		int low = 0;
		int high = x;
		while (low <= high) {
			int partitionX = (low + high)/2;
			int partitionY = (x + y + 1)/2 - partitionX;

			//if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
			//if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1.get(partitionX - 1);
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1.get(partitionX);

			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2.get(partitionY - 1);
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2.get(partitionY);

			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				//We have partitioned array at correct place
				// Now get max of left elements and min of right elements to get the median in case of even length combined array size
				// or get max of left for odd length combined array size.
				if ((x + y) % 2 == 0) {
					return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
				} else {
					return (double)Math.max(maxLeftX, maxLeftY);
				}
			} else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
				high = partitionX - 1;
			} else { //we are too far on left side for partitionX. Go on right side.
				low = partitionX + 1;
			}
		}

		//Only we we can come here is if input arrays were not sorted. Throw in that scenario.
		throw new IllegalArgumentException();
	}
}
