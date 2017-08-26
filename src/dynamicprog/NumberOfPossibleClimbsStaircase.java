package dynamicprog;

import java.util.Scanner;

public class NumberOfPossibleClimbsStaircase {

	private static int[] memoizedResults = null;

	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			int noOfStairCases = sc.nextInt(); 
			for (int i=0; i < noOfStairCases; i++) {
				int steps = sc.nextInt();
				memoizedResults = new int[steps];
				System.out.println(findNoOfWaysOfClimb(steps));
			}
		} finally {
			if (sc != null) {
				sc.close();
			}
		}

	}

	private static int findNoOfWaysOfClimb(int stepsCount) {
		int noOfWays = 0;
		if (stepsCount == 0) {
			noOfWays = 1;
		} else if (stepsCount > 0) {
			if (memoizedResults[stepsCount - 1] != 0) {
				noOfWays = memoizedResults[stepsCount - 1];
			} else {
				noOfWays = findNoOfWaysOfClimb(stepsCount - 1) + findNoOfWaysOfClimb(stepsCount -2)
				+ findNoOfWaysOfClimb(stepsCount - 3);	
				memoizedResults[stepsCount - 1] = noOfWays;
			}
		}
		return noOfWays;
	}
}
