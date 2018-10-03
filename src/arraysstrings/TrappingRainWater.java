package arraysstrings;

public class TrappingRainWater {
	public static void main(String[] args) {
		int[] barArr = {1, 0, 0, 2, 3, 4, 0, 6, 7};
		int leftMax = 0;
		int rightMax = 0;
		int low = 0, high = barArr.length - 1, result = 0;
		
		while (low <= high) {
			if (barArr[low] < barArr[high]) {
				if (barArr[low] > leftMax)
					leftMax = barArr[low];
				else
					result += leftMax - barArr[low];
				low++;
			} else {
				if (barArr[high] > rightMax)
					rightMax = barArr[high];
				else
					result += rightMax - barArr[high];
				high--;
			}
		}
		System.out.println(result);
	}
}
	