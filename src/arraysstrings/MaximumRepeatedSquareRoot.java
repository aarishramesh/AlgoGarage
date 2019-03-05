package arraysstrings;

public class MaximumRepeatedSquareRoot {
	
	public static int solution(int A, int B) {
        // write your code in Java SE 8
		double startSqRoot = Math.ceil(Math.sqrt(A));
		double endSqRoot = Math.floor(Math.sqrt(B));
		int maxCount = 0, count = 1;
		while (startSqRoot <= endSqRoot) {
			double currSqRoot = Math.sqrt(startSqRoot);
			while (currSqRoot == (int) currSqRoot) {
				count++;
				currSqRoot = Math.sqrt(currSqRoot);
			}
			if (count > maxCount)
				maxCount = count;
			startSqRoot++;
			count = 1;
		}
		return maxCount;
    }
	
	public static int solutionB(int A, int B) {
		double startSqRoot = A;
		double endSqRoot = B;
		int count = 0;
		while (startSqRoot <= endSqRoot) {
			startSqRoot = Math.ceil(Math.sqrt(startSqRoot));
			endSqRoot =  Math.floor(Math.sqrt(endSqRoot));
			if (startSqRoot == endSqRoot) {
				if (startSqRoot == (int) startSqRoot) {
					count++;
				}
			}
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(solutionB(2, 1000000000));
	}
}
