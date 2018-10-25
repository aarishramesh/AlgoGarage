package backtracking;

import java.util.HashSet;

public class UniquePermutations {
	
	static HashSet<String> permutations = new HashSet<String>();
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		uniquePermut(arr, 0, new StringBuilder());
		System.out.println(permutations.toString());
	}
	
	public static void uniquePermut(int[] arr, int index, StringBuilder sb) {
		if (index == arr.length) {
			String permutation = sb.toString();
			//if (!permutations.contains(permutation))
				permutations.add(permutation);
			return;
		} else {
			for (int i = index; i < arr.length; i++) {
				swap(arr, index, i);
				sb.append(arr[index]);
				uniquePermut(arr, index + 1, new StringBuilder(sb.toString()));
				sb.deleteCharAt(sb.length() - 1);
				swap(arr, i, index);
			}
		}
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
