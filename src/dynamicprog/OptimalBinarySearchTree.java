package dynamicprog;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-24-optimal-binary-search-tree/
 */
public class OptimalBinarySearchTree {
	
	public static void main(String[] args) {
		//int arr[] = {10, 12, 16, 21}, freq[] = {4, 2, 6, 3};
		int arr[] = {10, 12, 20}, freq[] = {34, 8, 50};
		System.out.println(optimalBstCost(arr, freq));
		System.out.println(optimalBstRec(arr, freq, 0, arr.length - 1, 1));
	}
	
	  private static int optimalBstRec(int input[],int freq[],int low,int high,int level){
	        if(low > high){
	            return 0;
	        }
	        
	        int min = Integer.MAX_VALUE;
	        for(int i=low; i <= high; i++){
	            int val = optimalBstRec(input,freq,low,i-1,level+1) + 
	            		optimalBstRec(input,freq,i+1,high,level+1)
	                    + level*freq[i];
	            if(val < min){
	                min = val;
	            }
	        }
	        return min;
	    }
	  
	public static int optimalBstCost(int[] arr, int[] freq) {
		int[][] optimalCost = new int[arr.length][arr.length];
		int level = 0, i = 0, j = 0;
		while (level < arr.length) {
			i = 0;
			j = level;
			while (i < arr.length && j < arr.length) {
				if (i == j) {
					optimalCost[i][j] = freq[i];
				} else {
					int sum = 0;
					for (int k = i; k <= j; k++)
						sum += freq[k]; // needs to be optimised
					int tempSum = 0;
					for (int k = i; k <= j; k++) {
						int tempSum2 = sum;
						if (k - 1 >= i)
							tempSum2 += optimalCost[i][k - 1];
						if (k + 1 <= j)
							tempSum2 += optimalCost[k + 1][j];
						if (tempSum == 0 || tempSum2 < tempSum)
							tempSum = tempSum2;
						tempSum2 = 0;
					}
					optimalCost[i][j] = tempSum;
				}
				i++; j++;
			}
			level++;
		}
		return optimalCost[0][arr.length - 1];
	}
}
