package dynamicprog;

/**
 * https://www.geeksforgeeks.org/find-maximum-number-possible-by-doing-at-most-k-swaps/
 * 
 * @author polymath
 *
 */
public class LargestNumberInKSwaps {	
	public static void main(String[] args) {
		String num = "7698"; int allowedSwaps = 2;
		LargestNum obj = new LargestNum();
		obj.max = num;
		findLargestInKSwaps(num, allowedSwaps, obj);
		System.out.println(obj.max);
	}
	
	static void findLargestInKSwaps(String num, int k, LargestNum obj) {
		if (k == 0)
			return;
		for (int i = 0; i < num.length() - 1; i++) {
			for (int j = i + 1; j < num.length(); j++) {
				if (num.charAt(i) < num.charAt(j)) {
					num = swap(num, i, j);
					if (num.compareTo(obj.max) > 0)
						obj.max = num;
					findLargestInKSwaps(num, k - 1, obj);
					num = swap(num, i, j);
				}
			}
		}
	}
	
	static String swap(String num, int indexA, int indexB) {
		int[] arr = new int[num.length()];
		for (int i = 0; i < num.length(); i++) {
			arr[i] = (int) num.charAt(i) - 48;
		}
		int temp = arr[indexA];
		arr[indexA] = arr[indexB];
		arr[indexB] = temp;
		
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < num.length(); i++)
			builder.append(arr[i]);
		return builder.toString();
	}
	
	static class LargestNum {
		String max;
	}
}
