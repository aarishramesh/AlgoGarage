package hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class LargestZeroSequence {
	
	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(0); input.add(0); input.add(0); input.add(0); input.add(0);
		System.out.println(lsZero(input).toString());
	}
	
	public static ArrayList<Integer> lsZero(ArrayList<Integer> A) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (A != null && !A.isEmpty()) {
			int sum = 0, i = 1, startIdx = 0, endIdx = 0, maxSeqLen = 0;
			HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
			sumMap.put(0, 0);
			for (Integer num : A) {
				sum += num;
				if (sumMap.containsKey(sum)) {
					int diff = i - sumMap.get(sum);
					if (diff > maxSeqLen) {
						maxSeqLen = diff;
						startIdx = sumMap.get(sum);
						endIdx = i;
					}
				} else {
					sumMap.put(sum, i);
				}
				i++;
			}
			for (int j = startIdx; j < endIdx; j++) {
				result.add(A.get(j));
			}
		}
		return result;
	}
}
