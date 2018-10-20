package arraysstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class NextPermutation {

	public static void main(String[] args) {
		int[] arr  = {	251, 844, 767, 778, 658, 337, 10, 252, 632, 262, 707, 506, 701, 475, 410, 696, 631, 903, 516, 149, 344, 101, 42, 891, 991, 46, 22
};
		ArrayList<Integer> a = (ArrayList<Integer>) Arrays.stream(arr).boxed().collect(Collectors.toList());
		//a.add(20); a.add(50); a.add(113);
		nextPermutation(a);
		if (!swapped) {
			int first = 0, last = a.size() - 1;
			while (first < last) {
				int temp = a.get(first);
				a.set(first, a.get(last));
				a.set(last, temp);
			}
		}
		System.out.println(a.toString());
	}

	public static void nextPermutation(ArrayList<Integer> a) {
		swap(a, 0, 1);
	}

	static boolean swapped = false;

	static void swap(ArrayList<Integer> a, int currIndex, int nextIndex) {
		if (nextIndex < a.size()) {
			swap(a, currIndex + 1, nextIndex + 1);
			if (!swapped) {
				if (a.get(currIndex) < a.get(nextIndex)) {
					int temp = a.get(nextIndex);
					a.set(nextIndex, a.get(currIndex));
					a.set(currIndex, temp);
					swapped = true;
					Collections.sort(a.subList(nextIndex, a.size()));
				}
			}
		}
	}
	
}
