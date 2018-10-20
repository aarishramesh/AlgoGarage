package binarysearch;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RotatedSortedArraySearch {
	
	public static void main(String[] args) {
		int[] intArr = {180, 181, 182, 183, 184, 187, 188, 189, 191, 192, 193, 194, 195, 196, 201, 202, 203, 204, 3, 4, 5, 6, 7, 8, 9, 10, 14, 16, 17, 18, 19, 23, 26, 27, 28, 29, 32, 33, 36, 37, 38, 39, 41, 42, 43, 45, 48, 51, 52, 53, 54, 56, 62, 63, 64, 67, 69, 72, 73, 75, 77, 78, 79, 83, 85, 87, 90, 91, 92, 93, 96, 98, 99, 101, 102, 104, 105, 106, 107, 108, 109, 111, 113, 115, 116, 118, 119, 120, 122, 123, 124, 126, 127, 129, 130, 135, 137, 138, 139, 143, 144, 145, 147, 149, 152, 155, 156, 160, 162, 163, 164, 166, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177};
		
		List<Integer> arr = Arrays.stream(intArr).boxed().collect(Collectors.toList());
		
		System.out.println(search(arr, 42));
	}
	
	public static int search(final List<Integer> a, int target) {
		int low = 0, high = a.size() - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (target == a.get(mid)) {
				return mid;
			} else if (target < a.get(mid)) {
				if (target >= a.get(low) || a.get(low) >= a.get(mid)) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				if (target <= a.get(high) || a.get(high) < a.get(mid)) {
					low = mid + 1;
				} else
					high = mid - 1;
			}
		}
		return -1;
    }
}
