package arraysstrings;

/**
 * Check for character duplication in a string using bit- vector 
 * 
 * Time complexity -  O(n) | Space complexity - O(1)
 * 
 * In case of string containing all the characters apart from acsii, larger bit vectors need to be used
 * 
 * @author aarish-1867
 *
 */
public class ArrayUniqueElementsChecker {

    public static void main(String[] args) {
        /*String input = "abcdd";
        String type = "ascii";
        boolean dupNotPresent = true;
        if (input != null && !input.isEmpty() && type != null && !type.isEmpty() && type.equals("ascii")) {
            input = input.toLowerCase();
            char[] inputArr = new char[input.length()];
            for (int i=0; i< input.length(); i++) {
                inputArr[i] = input.charAt(i);
            }
            dupNotPresent = areArrayElementsUnique(inputArr);
            if (dupNotPresent) {
                System.out.println("" + input + " does not contain any duplicate characters!!");
            } else {
                System.out.println(input + " contains duplicate characters");
            }
        }*/
        int[] testArr = {1, 2, 3, 0};
        areArrayElementsUnique(testArr);
    }

    static boolean areArrayElementsUnique(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int val = arr[Math.abs(arr[i])];
            if (val < 0) {
                System.out.println("Duplicate present");
                break;
            } else {
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            }
        }
        return true;
    }

    static boolean areArrayElementsUnique(char[] arr) {
        int vector = 0; 
        for (int i = 0; i < arr.length; i++) {
            char character = arr[i];
            int val = character - 'a';
            if ((vector & (1 << val)) > 0) {
                return false;
            }
            vector |= (1 << val);
        }
        return true;
    }
}
