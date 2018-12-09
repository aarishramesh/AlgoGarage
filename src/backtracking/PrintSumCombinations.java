package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrintSumCombinations {
	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int b) {
		for (int count = 1; count <= arr.size(); count++) {
			combinationSum(arr, 0, 0, 28, count, new ArrayList<Integer>());
		}
		return resultArr;
    }
	
	// 15, 8, 15, 10, 19, 18, 10, 3, 11, 7, 17
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(15); arr.add(8); arr.add(15); arr.add(10); arr.add(19); arr.add(18); arr.add(10); arr.add(3);arr.add(11);arr.add(7);arr.add(17);
		for (int count = 1; count <= arr.size(); count++) {
			combinationSum(arr, 0, 0, 33, count, new ArrayList<Integer>());
		}
		for (ArrayList<Integer> list : resultArr) {
			System.out.println(list.toString());
		}
	}
	
	static void combinationSum(ArrayList<Integer> arr, int idx, int sum, int target, int count, ArrayList<Integer> currList) {
		if (idx > arr.size() || sum > target) {
			return;
		}
		if (count <= 0) {
			if (count == 0 && sum == target) {
				Collections.sort(currList, new CombinationArrayComparator());
				if (!resultArr.contains(currList))
					resultArr.add(currList);
			}
			return;
		}
		for (int i = idx; i < arr.size(); i++) {
			if (arr.get(i) + sum <= target) {
				ArrayList<Integer> sumSeq = new ArrayList<Integer>(currList);
				sumSeq.add(arr.get(i));
				combinationSum(arr, i + 1, arr.get(i) + sum, target, count - 1, sumSeq);
			}
		}
	}
	
	static ArrayList<ArrayList<Integer>> resultArr = new ArrayList<ArrayList<Integer>>();
	
	static class CombinationArrayComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer arg0, Integer arg1) {
			if (arg0 <= arg1)
				return -1;
			return 1;
		}
		
	}
}
