package general;

public class RainWaterTrapProblemWithExtraSpace {
	public static void main(String[] args) {
		int[] arr = {4, 0, 0, 3, 0, 2, 0, 1};
		
		if (arr.length == 0) {
			System.out.println("0");
			return;
		}
		
		int[] leftMaxArr = new int[arr.length];
		int[] rightMaxArr = new int[arr.length];
		leftMaxArr[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (leftMaxArr[i - 1] < arr[i]) {
				leftMaxArr[i] = arr[i];
			} else {
				leftMaxArr[i] = leftMaxArr[i - 1];
			}
		}
		
		rightMaxArr[arr.length - 1] = arr[arr.length - 1];
		for (int i = arr.length - 2; i >=0; i--) {
			if (rightMaxArr[i + 1] < arr[i]) {
				rightMaxArr[i] = arr[i];
			} else {
				rightMaxArr[i] = rightMaxArr[i + 1];
			}
		}
		System.out.println(calculateWaterTrapped(arr, leftMaxArr, rightMaxArr));
	}
	
	private static int calculateWaterTrapped(int[] arr, int[] leftMaxArr, int[] rightMaxArr) {
		int area = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == leftMaxArr[i] || arr[i] == rightMaxArr[i]) {
				continue;
			} else {
				if (arr[i] == 0) {
					int factor = 1;
					if (i - 1 >= 0 && arr[i - 1] != 0) {
						factor = 2;
					}
					area += (Math.min(leftMaxArr[i], rightMaxArr[i]) * factor);
				} else {
					area += Math.min(leftMaxArr[i], rightMaxArr[i]) - arr[i];
				}
			}
		}
		return area;
	}
}
