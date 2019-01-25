package arraysstrings;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
 * 
 * @author polymath
 *
 */
public class MinStepsInGrid {
	public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
		int totalMinSteps = 0;
		if (A != null && B != null) {
			List<Coordinate> coordinates = new ArrayList<Coordinate>();
			int i = 0;
			for (Integer val : A) {
				Coordinate coord = new Coordinate(val, B.get(i++));
				coordinates.add(coord);
			}
			for (i = 1; i < coordinates.size(); i++) {
				totalMinSteps += findMinSteps(coordinates.get(i - 1), coordinates.get(i));
			}
		}
		return totalMinSteps;
	}

	private static int findMinSteps(Coordinate A, Coordinate B) {
		int a = Math.abs(A.x - B.x);
		int b = Math.abs(A.y - B.y);
		return Math.max(a, b);
	}

	static class Coordinate {
		int x, y;

		Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
