package arraysstrings;

import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.interviewbit.com/problems/wave-array/
 * https://www.geeksforgeeks.org/sort-array-wave-form-2/
 * 
 * @author polymath
 *
 */
public class WaveArray {
	
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(6); arr.add(1); arr.add(2); arr.add(3); arr.add(4); arr.add(5); arr.add(6);
		
		System.out.println(wave(arr));
		System.out.println(waveTwo(arr));
	}
	
	public static ArrayList<Integer> wave(ArrayList<Integer> A) {
		if (A != null && !A.isEmpty()) {
			if (A.size() == 1)
				return A;
			Collections.sort(A);
			int i = 0;
			while (i <= A.size() - 2) {
				int temp = A.get(i);
				A.set(i, A.get(i + 1));
				A.set(i + 1, temp);
				i+=2;
			}
			return A;
		}
		return null;
    }
	
	public static ArrayList<Integer> waveTwo(ArrayList<Integer> A) {
		if (A != null && !A.isEmpty()) {
			if (A.size() == 1 || A.size() == 2)
				return A;
			for (int i = 0; i < A.size(); i++) {
				if (i - 1 >= 0 && A.get(i - 1) > A.get(i))
					swap(A, i - 1, i);
				if (i + 1 < A.size() && A.get(i + 1) > A.get(i))
					swap(A, i, i + 1);
			}
		}
		return A;
	}
	
	private static void swap(ArrayList<Integer> A, int indexA, int indexB) {
		if (A != null && indexA > indexB && indexB < A.size()) {
			int temp = A.get(indexA);
			A.set(indexA, A.get(indexB));
			A.set(indexB, temp);
		}
	}
}
