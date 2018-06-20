package general;

import java.util.Arrays;

public class FindThreeNumbersSumClosestToTarget {
	public static void main(String[] args) {
		int[] arr = {-5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3 };
		int target = -1, bestSum = 100000000;
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 2; i++) {
			int left = i + 1, right = arr.length - 1;
			int sum = 0;
			while (left < right) {
				sum = arr[i] + arr[left] + arr[right];
				if (sum < target) {
					left++;
				} else {
					right--;
				}
				int a = Math.abs(target - sum);
				int b = Math.abs(target - bestSum);
				if (a < b)
					bestSum = sum;
			}
		}
		System.out.println(bestSum);
	}
}
/**
public class FindThreeNumbersSumClosestToTarget {
	public int threeSumClosest(ArrayList<Integer> A, int B) {
	    int low, high, mid;
	    Collections.sort(A);
	    int n = A.size();
	    int res = A.get(0) + A.get(1) + A.get(2);
	    
	    if (n == 3) {
	        return res;
	    }
	    
	    int sum;
	    
	    
	    
	    for (low = 0; low < n - 2; low++) {
	        mid = low + 1;
	        high = n - 1;
	        int num = B - A.get(low);
	        
	        while (mid < high) {
	            
	            sum = A.get(mid) + A.get(high);
	            
	            if (sum == num)
	                return B;
	            else if (sum < num) {
	                mid++;
	            } else {
	                high--;
	            }
	            
	            int diff = Math.abs(sum - num);
	            int otherDiff = Math.abs(res - B);
	            
	            if (diff < otherDiff)
	                res = sum + A.get(low);
	            
	        }
	        
	    }
	    
	    
	    return res;
	    
	    
	}
}

**/
