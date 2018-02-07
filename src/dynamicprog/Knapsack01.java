package dynamicprog;

import java.util.Scanner;

public class Knapsack01 {
	public static void main(String[] argss) {
		Scanner sc = new Scanner(System.in);
		int noOfWeights = sc.nextInt();
		sc.nextLine();
		int[] weights =  new int[noOfWeights];
		int[] values = new int[noOfWeights];
		for (int i = 0; i < noOfWeights; i++) {
			weights[i] = sc.nextInt();
			values[i] = sc.nextInt();
			sc.nextLine();
		}
		int maxWeight = sc.nextInt();
		int[][] T = new int[noOfWeights][maxWeight + 1];
		for (int i = 0; i < noOfWeights; i++) {
			for (int j = 1; j < maxWeight + 1; j++) {
				if (j < weights[i]) {
					if (i - 1 >= 0) {
						T[i][j] = T[i - 1][j];
					} 
				} else {
					if (i - 1 >= 0)
						T[i][j] = Math.max(values[i] + T[i - 1][j - weights[i]], T[i - 1][j]);
					else
						T[i][j] = values[i];
				}
			}
		}
		System.out.println(T[noOfWeights - 1][maxWeight]);
		sc.close();
	}
}