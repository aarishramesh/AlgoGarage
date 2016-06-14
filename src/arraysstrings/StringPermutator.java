package arraysstrings;

/**
 * Class containing all operations relating to permutations in a string
 * 
 * Run time complexity - O(n*n!)
 * 
 * Backtracking is employed
 * 
 * Space optimisations 
 * ---------------------
 * 
 * Char array is employed instead of string as string modifications result in every new copy of the String which is inefficient
 *      for larger inputs
 *      
 * 
 * @author aarish-1867
 *
 */
public class StringPermutator {

    static String input;
    static String testStr;
    static int option;        
    static boolean stop = false;

    public static void main(String[] args) {
        System.out.println("--------- String permutation operations -----------" 
                + "\n" + " Enter 1 or 2 for option");        
        System.out.println(" 1 - to print all permutations of string " + "\n" + 
                " 2 - to check if string is part of the permutation ");
        System.out.println("Execution : java StringPermutator inputStr "
                + " option testStr(for option 2)");

        if (args[0] != null && !args[0].isEmpty()) {
            input = args[0];
            if (args[1] != null && !args[1].isEmpty() 
                    && (args[1].equals("1") || args[1].equals("2"))) {
                option = Integer.parseInt(args[1]);
            } else {
                System.out.println("Incorrect option entered");
                return;
            }
            if (option == 2) {
                if (args[2] != null && !args[2].isEmpty()) {
                    testStr = args[2];
                } else {
                    System.out.println("Test string not in proper format");
                    return;
                }
            }
            permute(convertStrToCharArray(input), 0, input.length());
            if (option == 2 && !stop) {
                System.out.println(testStr + " is not a permutation of input : " + input);
            }
        } else {
            System.out.println("Incorrect input entered");
        }
    }

    static void permute(char[] charArr, int start, int end) {
        if (stop) {
            return;
        }
        if (start == end - 1) {
            if (option == 1) {
                System.out.println(getStringFromArr(charArr));
            } else {
                if (testStr.equals(getStringFromArr(charArr))) {
                    System.out.println(testStr + " is a permutation of input : " + input);
                    stop = true;
                }
            }
            return;
        }
        for (int i  = start; i < end; i++) {
            if (i != start) {
                swap(charArr, i, start);
            }
            permute(charArr, start + 1, end);
            if (i != start) {
                swap(charArr, i, start);
            }
        }
    }

    static void swap(char[] inputArr, int pos1, int pos2) {
        char pos1char = inputArr[pos1];
        inputArr[pos1] = inputArr[pos2];
        inputArr[pos2] = pos1char;
    }

    static char[] convertStrToCharArray(String input) {
        char[] charArr = new char[input.length()];
        for (int i = 0; i < input.length() ; i++) {
            charArr[i] = input.charAt(i);
        }
        return charArr;
    }

    static String getStringFromArr(char[] charArr) {
        StringBuffer buff = new StringBuffer();
        for (int i = 0; i< charArr.length; i++) {
            buff.append(charArr[i]);
        }
        return buff.toString();
    }
}
