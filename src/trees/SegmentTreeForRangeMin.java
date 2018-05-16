package trees;

import java.util.Scanner;

import general.NextPowOfTwo;

/**
 * Build segment tree for range minimum query
 * 
 * @author polymath
 *
 */
public class SegmentTreeForRangeMin {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] elementsArr = new int[n];
		for (int i = 0; i < n; i++)
			elementsArr[i] = sc.nextInt();
		
		int segmentArrSize = NextPowOfTwo.findNextPowOfTwoUsingBitManip(n) * 2 - 1;

		int[] rangeQueryArr = new int[segmentArrSize];
		
		for (int i = 0; i < segmentArrSize; i++)
			rangeQueryArr[i] = Integer.MAX_VALUE;
			
		constructSegmentTree(elementsArr, rangeQueryArr, 0, elementsArr.length - 1, 0);
		
		for (int i = 0; i < segmentArrSize; i++)
			System.out.println(rangeQueryArr[i]);
		
		int l = sc.nextInt(); int r = sc.nextInt();
		System.out.println(rangeMinQuery(rangeQueryArr, l, r, 0, elementsArr.length - 1, 0));
		sc.close();
	}
	
	public static void constructSegmentTree(int[] arr, int[] segmentArr, int start, int end, int index) {
		if (start == end) {
			segmentArr[index] = arr[start];
			return;
		}
		int mid = (start + end) / 2;
		constructSegmentTree(arr, segmentArr, start, mid, 2 * index + 1);
		constructSegmentTree(arr, segmentArr, mid + 1, end, 2 * index + 2);
		segmentArr[index] = Math.min(segmentArr[2 * index + 1], segmentArr[2 * index + 2]);
	}
	
	public static int rangeMinQuery(int[] segmentArr, int l, int r, int start, int end, int index) {
		if (l <= start && r >= end)
			return segmentArr[index];
		if (l > end || r < start)
			return Integer.MAX_VALUE;
		int mid = (start + end) / 2;
		return Math.min(rangeMinQuery(segmentArr, l, r, start, mid, 2 * index + 1)
				, rangeMinQuery(segmentArr, l, r, mid + 1, end, 2 * index + 2)); 
	}
	
}
