package arraysstrings;

public class FindNextGreatestNumberUsingAllDigits {
	
	public static void main(String[] args) {
		int[] arr = {4, 3, 2, 1};
		int[] result = findNextGreatestNumber(arr);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}
	}
	public static int[] findNextGreatestNumber(int[] arr) {
		if (arr != null) {
			int[] arrCpy = arr.clone();
			for (int i = arr.length - 1; i > 0; i--) {
				if (arr[i - 1] < arr[i]) {
					int temp = arr[i - 1];
					arr[i - 1] = arr[i];
					int k = arrCpy.length - 1; boolean elementPlaced = false;
					while (i < arr.length) {
						if (!elementPlaced) {
							if (arrCpy[k] < temp) {
								arr[i] = arrCpy[k];
								k--; i++;
							} else {
								arr[i] = temp;
								elementPlaced = true;
								i++;
							}
						} else {
							arr[i] = arrCpy[k];
							i++; k--;
						}
					}
					if (!elementPlaced) {
						arr[i - 1] = temp;
					}
					break;
				}
			}
		}
		return arr;
	}
}
