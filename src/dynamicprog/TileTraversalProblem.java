package dynamicprog;

import java.util.Scanner;

/**
 * Given a 5 x 5 Grid comprising of tiles numbered from 1 to 25 and a set of 5 start-end point pairs.
For each pair,find a path from the start point to the end point.
The paths should meet the below conditions:
a) Only Horizontal and Vertical moves allowed.
b) No two paths should overlap.
c) Paths should cover the entire grid

Input:
Input consist of 5 lines.
Each line contains two space-separated integers,Starting and Ending point.

Output:
Print 5 lines. Each line consisting of space-separated integers,the path for the corresponding start-end pair.
Assume that such a path Always exists.
In case of Multiple Solution,print any one of them.

This is modified to be a DP problem with tiles numbered as follows

Optimised to calculate the best number of steps to reach from start to end 
	and using DP 
 * 
 * @author aarishramesh
 *
 */
public class TileTraversalProblem {
	private static int[] desiredRoute;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		int noOfSteps = (end - start) / 5 + (end - start) % 5;
		int[] path = new int[noOfSteps + 1];
		if (findRoute(start, end, 0, noOfSteps, path)) {
			for (int i = 0; i < desiredRoute.length; i++)
				System.out.println(desiredRoute[i]);
		}
		sc.close();
	}

	public static boolean findRoute(int start, int end, int stepCount
			, int desiredStepCount, int[] path) {
		if (stepCount == desiredStepCount && start == end) {
			path[stepCount] = end;
			desiredRoute = path; 
			return true;
		} else if (stepCount < desiredStepCount){
			int row = start / 5; int rowStart = row * 5 + 1; int rowEnd = row * 5 + 5;
			if (start > 25 || start < rowStart || start > rowEnd)
				return false;

			path[stepCount] = start;	
			return (findRoute(start + 1, end, stepCount + 1, desiredStepCount, path)
					|| findRoute(start - 1, end, stepCount + 1 , desiredStepCount, path)
					|| findRoute(start + 5, end, stepCount + 1, desiredStepCount, path));
		}
		return false;
	}
}
