package arraysstrings;

import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.interviewbit.com/problems/wave-array/
 * 
 * @author polymath
 *
 */
public class WaveArray {
	
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(6); arr.add(1); arr.add(2); arr.add(3); arr.add(4); arr.add(5); arr.add(6);
		
		System.out.println(wave(arr));
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
}
