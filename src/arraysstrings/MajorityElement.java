package arraysstrings;

import java.util.HashMap;

public class MajorityElement {
	
	public static void main(String[] args) {
		int[] arr = {2, 1, 2};
		System.out.println(majorityElement(arr));
	}
	
	public static int majorityElement(final int[] A) {
        HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        int reqFreq = (int) Math.floor(A.length/2);
        for (int i = 0; i < A.length; i++) {
            int freq = freqMap.getOrDefault(A[i], 0);
            if (freq + 1 > reqFreq) {
                return A[i];
            } else {
                freqMap.put(A[i], freq + 1);
            }
        }
        return 0;
    }
}
